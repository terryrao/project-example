package com.github.terryrao.example.axon.command.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.github.terryrao.example.axon.command.SpringContextHolder;
import com.github.terryrao.example.axon.command.domain.command.IssueCardCmd;
import com.github.terryrao.example.axon.command.domain.event.IssueCardEvent;
import com.github.terryrao.example.axon.command.repository.GiftCardRepository;
import com.github.terryrao.example.axon.command.repository.impl.GiftCardRepositoryImpl;
import com.google.gson.Gson;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

/**
 * 注解 @Aggregate 必须有，否则处理不了 @CommandHandler, 实际上是一个 spring 的 component
 *
 * @author raow date: 2019/9/3 18:27
 */
@Aggregate
@Log4j2
@Data
public class GiftCard implements Serializable {
    @AggregateIdentifier
    private String id;
    private int remainingValue;
    @TableField("a_desc")
    private String desc;

    @Autowired
    private transient GiftCardRepository giftCardRepository;

    @CommandHandler
    public GiftCard(IssueCardCmd cmd) {
        this();
        log.info(new Gson().toJson(cmd));
        apply(new IssueCardEvent(cmd.getCardId(), cmd.getInitAmount(), cmd.getDesc()));
    }

    /**
     * 做为实体需要无参构造
     */
    public GiftCard() {
        log.info("init giftCard ....");
    }


    /**
     * //@EventHandler
     * //@EventSourcingHandler https://github.com/AxonFramework/AxonFramework/issues/370
     * Technically, @EventSourcingHandler and @EventHandler are exactly identical. They merely have different names to
     * allow you to be explicit about the intent of the handlers. I recommend using @EventSourcingHandler in your
     * Aggregates, and @EventHandler on the beans that create projections.
     */
    @EventSourcingHandler
    public void on(IssueCardEvent evt) {
        log.info("applying {}", evt);
        this.remainingValue += evt.getInitAmount();
        this.id = evt.getCardId();
        this.desc = evt.getDesc();
        this.giftCardRepository = SpringContextHolder.getBean(GiftCardRepositoryImpl.class);
        this.giftCardRepository.save(this);
        log.info("new remaining value {}", this.remainingValue);
    }

}
