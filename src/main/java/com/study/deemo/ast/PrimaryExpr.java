package com.study.deemo.ast;

import com.study.deemo.exception.DmTypeError;
import com.study.deemo.object.DmBaseObject;

public interface PrimaryExpr extends Expr {
    default DmBaseObject eval() {
        if (!(this instanceof DmBaseObject)) {
            throw new DmTypeError(this.getClass().getName() + " should extends " + DmBaseObject.class.getName());
        }
        return (DmBaseObject) this;
    }
}
