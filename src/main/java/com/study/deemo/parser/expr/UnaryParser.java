package com.study.deemo.parser.expr;

import com.study.deemo.ast.Expr;
import com.study.deemo.ast.unary.LogicNotExpr;
import com.study.deemo.ast.unary.TypeOfExpr;
import com.studyvm.pcomj.base.AbstractParserCombinator;

import static com.study.deemo.parser.CommonParser.sep1;
import static com.study.deemo.parser.expr.PrimaryParserBuilder.primary;
import static com.studyvm.pcomj.utils.ParserBuilder.*;

/**
 * unary expr:
 * ! typeof
 */
public class UnaryParser {
    private static AbstractParserCombinator<Expr> logicNot() {
        return symbol('!')
                .takeLeft(space().many())
                .takeRight(primary())
                .map(LogicNotExpr::new);
    }

    private static AbstractParserCombinator<Expr> typeOf() {
        return keyword("typeof")
                .takeLeft(sep1())
                .takeRight(primary())
                .map(TypeOfExpr::new);
    }

    public static AbstractParserCombinator<Expr> unary() {
        return logicNot().or(typeOf());
    }
}
