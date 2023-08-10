package com.voting.command.exception;

public class HandlerNotImplementsException extends RuntimeException{

    public HandlerNotImplementsException() {
        super("Command nit implements CommandHandler");
    }
}
