package com.study.deemo.exception;

public class DmCannotCompareError extends DmError {
    public DmCannotCompareError() {
        super("only STRING and NUMBER can be used with operator > >= < <=.");
    }

    public DmCannotCompareError(String msg) {
        super(msg);
    }
}
