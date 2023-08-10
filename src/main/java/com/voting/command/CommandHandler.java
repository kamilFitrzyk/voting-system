package com.voting.command;

import com.voting.exception.ApplicationException;

public interface CommandHandler<C, R> {
    R execute(C command) throws ApplicationException;
}
