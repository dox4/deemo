package com.study.deemo.ast.unary;

import com.study.deemo.ast.Expr;
import com.study.deemo.object.DmBaseObject;
import com.study.deemo.object.DmBoolean;

public class LogicNotExpr implements Expr {
    private final Expr expr;

    public LogicNotExpr(Expr expr) {
        this.expr = expr;
    }

    @Override
    public DmBaseObject eval() {
        DmBaseObject object = expr.eval();
        return DmBoolean.of(!object.asBoolean());
    }
}
