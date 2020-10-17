package com.study.deemo.object;

public final class DmNull extends DmAbstractObject<Void> {
    public final static DmNull VALUE = new DmNull();

    private DmNull() {
        super(null);
    }

    public DmType type() {
        return DmType.NULL;
    }

    @Override
    public boolean asBoolean() {
        return false;
    }
}
