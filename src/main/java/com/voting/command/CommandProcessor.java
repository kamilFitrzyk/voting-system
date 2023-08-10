package com.voting.command;

import com.voting.exception.ApplicationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommandProcessor {

    private final Handler handler;

    public Object process(Object command) throws ApplicationException {
        CommandHandler<Object, Object> h = handler.getHandler(command);
        return h.execute(command);
    }
}
