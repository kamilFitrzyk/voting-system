package com.voting.command.exception;

public class CommandHandlerNotFoundException extends RuntimeException {
    public CommandHandlerNotFoundException(Class<?> aClass) {
        super("Command handler not found: " + aClass);
    }
}
