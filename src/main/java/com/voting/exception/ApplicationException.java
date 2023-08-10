package com.voting.exception;

import com.voting.config.ConfigError;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationException extends Exception {

    private final String message;

    public ApplicationException(ConfigError message) {
        this.message = message.toString();
    }
}
