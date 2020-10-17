package com.study.deemo.object;

import java.util.ArrayList;
import java.util.List;

public final class DmArray extends DmAbstractObject<List<DmBaseObject>> {
    public DmArray(List<DmBaseObject> value) {
        super(value);
    }

    public DmArray() {
        super(new ArrayList<>());
    }

    public DmType type() {
        return DmType.ARRAY;
    }
}
