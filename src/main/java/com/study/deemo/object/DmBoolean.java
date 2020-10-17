package com.study.deemo.object;

public final class DmBoolean extends DmAbstractObject<Boolean> {
    static final DmBoolean FALSE_VALUE = new DmBoolean(false);
    static final DmBoolean TRUE_VALUE = new DmBoolean(true);

    private DmBoolean(Boolean value) {
        super(value);
    }

    public static DmBoolean of(boolean b) {
        return b ? TRUE_VALUE : FALSE_VALUE;
    }

    public DmType type() {
        return DmType.BOOLEAN;
    }

    @Override
    public boolean asBoolean() {
        return value;
    }
}
