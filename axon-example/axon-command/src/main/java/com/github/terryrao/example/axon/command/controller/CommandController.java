package com.github.terryrao.example.axon.command.controller;

import com.github.terryrao.example.axon.command.domain.command.IssueCardCmd;
import org.axonframework.commandhandling.CommandCallback;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author raow date: 2019/9/4 11:50
 */
@RestController
public class CommandController {
    private final CommandGateway commandGateway;

    public CommandController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @GetMapping("/issue-card/{id}/{amount}/{desc}")
    public String issueCard(@PathVariable("id") String id, @PathVariable("amount") int amount, @PathVariable("desc")
            String desc) {
        String cardId = UUID.randomUUID().toString();

        final String[] commandResult = new String[1];
        this.commandGateway.send(new IssueCardCmd(cardId, amount, desc),
                (CommandCallback<IssueCardCmd, String>) (cmdMsg, cmdResultMsg) -> {
                    // 7.
                    if (cmdResultMsg.isExceptional()) {
                        Throwable throwable = cmdResultMsg.exceptionResult();
                        throwable.printStackTrace();
                    } else {
                        commandResult[0] = cmdResultMsg.getPayload();
                        System.out.println(commandResult[0] + " ===============================");
                    }
                });
        return  "success";
    }

}
