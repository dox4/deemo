package com.study.deemo.ast.binary;

import com.study.deemo.ast.Expr;
import com.study.deemo.object.DmBaseObject;
import com.study.deemo.object.DmBoolean;

public class LogicOrExpr extends AbstractBinaryExpr {
    public LogicOrExpr(Expr lhs, Expr rhs) {
        super(lhs, rhs);
    }


    @Override
    public DmBaseObject eval() {
        return DmBoolean.of(lhs.eval().asBoolean() || lhs.eval().asBoolean());
    }
}
