package com.study.deemo.ast.unary;

import com.study.deemo.ast.Expr;
import com.study.deemo.object.DmBaseObject;
import com.study.deemo.object.DmString;

public class TypeOfExpr implements Expr {
    private final Expr expr;

    public TypeOfExpr(Expr expr) {
        this.expr = expr;
    }

    @Override
    public DmBaseObject eval() {
        return DmString.of(expr.eval().type().name());
    }
}
