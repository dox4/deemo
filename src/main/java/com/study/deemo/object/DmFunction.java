package com.study.deemo.object;

import java.util.HashMap;
import java.util.Map;

public class DmFunction implements DmBaseObject {
    private final Map<String, DmBaseObject> localVariables = new HashMap<>();

    @Override
    public DmType type() {
        return null;
    }

    @Override
    public boolean asBoolean() {
        return true;
    }

}
