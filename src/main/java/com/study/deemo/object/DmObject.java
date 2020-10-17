package com.study.deemo.object;

import java.util.Map;

public final class DmObject extends DmAbstractObject<Map<String, Object>> {
    public DmObject(Map<String, Object> value) {
        super(value);
    }

    public DmType type() {
        return DmType.OBJECT;
    }

}
