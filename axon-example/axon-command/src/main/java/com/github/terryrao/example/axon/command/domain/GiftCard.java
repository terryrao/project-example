package com.github.terryrao.example.axon.command.domain;

import com.github.terryrao.example.axon.command.domain.command.IssueCardCmd;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.factory.annotation.Configurable;

import javax.persistence.Entity;

/**
 * @author raow date: 2019/9/3 18:27
 */
@Configurable
@Entity
@Aggregate
public class GiftCard {
    @AggregateIdentifier
    private String id;
    private int remainingValue;
    private String desc;

    @CommandHandler
    public GiftCard(IssueCardCmd cmd) {

    }

    public GiftCard() {
    }
}
