package com.github.terryrao.example.axon.command.domain.command;

import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * @author raow date: 2019/9/3 18:28
 */
@Getter
public class IssueCardCmd {
    @TargetAggregateIdentifier
    private final String cardId;
    private final int initAmount;
    private final String desc;

    public IssueCardCmd(String cardId, int initAmount, String desc) {
        this.cardId = cardId;
        this.initAmount = initAmount;
        this.desc = desc;
    }
}
