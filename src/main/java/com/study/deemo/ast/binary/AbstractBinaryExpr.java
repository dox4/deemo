package com.study.deemo.ast.binary;

import com.study.deemo.ast.Expr;

/**
 * binary expr:
 * ||
 * &&
 * == !=
 * > >= < <=
 * + -
 * * / %
 */
public abstract class AbstractBinaryExpr implements Expr {
    protected final Expr lhs, rhs;

    protected AbstractBinaryExpr(Expr lhs, Expr rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }
}
