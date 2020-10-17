package com.study.deemo.object;

import com.study.deemo.ast.PrimaryExpr;
import com.study.deemo.exception.DmCannotCompareError;
import com.study.deemo.exception.DmTypeError;

public interface DmBaseObject extends PrimaryExpr {
    DmType type();

    boolean asBoolean();

    default int compareTo(DmBaseObject other) {
        DmBaseObject left = this.eval();
        if (!DmType.isComparable(left.type())) {
            throw new DmCannotCompareError();
        }
        DmBaseObject right = other.eval();
        if (!DmType.isComparable(right.type())) {
            throw new DmCannotCompareError();
        }
        if (!left.type().equals(right.type())) {
            throw new DmCannotCompareError("only the same type can be compared with > >= < <=.");
        }
        // number
        if (this instanceof DmNumber) {
            DmNumber n1 = (DmNumber) this;
            DmNumber n2 = (DmNumber) other;
            return n1.value.compareTo(n2.value);
        }
        // string
        DmString s1 = (DmString) this;
        DmString s2 = (DmString) other;
        return s1.value.compareTo(s2.value);
    }

    default DmBaseObject add(DmBaseObject other) {
        throw new DmTypeError("only STRING or NUMBER has `+' operator.");
    }
}
