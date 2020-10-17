package com.study.deemo.object;

public abstract class DmAbstractObject<T> implements DmBaseObject {
    final T value;

    protected DmAbstractObject(T value) {
        this.value = value;
    }

    T value() {
        return value;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DmAbstractObject)) {
            return false;
        }
        DmAbstractObject<T> other = (DmAbstractObject<T>) obj;

        return type().equals(other.type())
                && (type() == DmType.NULL
                || value.equals(other.value));
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean asBoolean() {
        return true;
    }
}
