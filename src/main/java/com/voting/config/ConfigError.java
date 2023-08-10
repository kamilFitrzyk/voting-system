package com.voting.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ConfigError {

    ELECTION_STATUS_NOT_FOUND("Status election not found");

    private final String message;
}
