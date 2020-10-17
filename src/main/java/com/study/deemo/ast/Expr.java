package com.study.deemo.ast;

import com.study.deemo.object.DmBaseObject;

public interface Expr extends Ast {
    DmBaseObject eval();
}
