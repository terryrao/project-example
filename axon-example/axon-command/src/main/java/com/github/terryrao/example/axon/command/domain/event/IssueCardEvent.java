package com.github.terryrao.example.axon.command.domain.event;

import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * @author raow date: 2019/9/3 18:30
 */
@Getter
public class IssueCardEvent {
    @TargetAggregateIdentifier
    private final String cardId;
    private final int initAmount;
    private final String desc;

    public IssueCardEvent(String cardId, int initAmount, String desc) {
        this.cardId = cardId;
        this.initAmount = initAmount;
        this.desc = desc;
    }
}
