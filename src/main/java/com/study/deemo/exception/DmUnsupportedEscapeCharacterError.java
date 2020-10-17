package com.study.deemo.exception;

public class DmUnsupportedEscapeCharacterError extends DmError {
    public DmUnsupportedEscapeCharacterError(char ch) {
        super("unsupported escape character `" + ch + "'.");
    }
}
