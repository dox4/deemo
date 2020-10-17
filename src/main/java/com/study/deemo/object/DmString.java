package com.study.deemo.object;

public final class DmString extends DmAbstractObject<String> {
    public DmString(String value) {
        super(value);
    }

    public static DmBaseObject of(String name) {
        return new DmString(name);
    }

    public DmType type() {
        return DmType.STRING;
    }

    @Override
    public boolean asBoolean() {
        return value.length() != 0;
    }
}
