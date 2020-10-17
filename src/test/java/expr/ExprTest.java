package expr;

import com.study.deemo.ast.Expr;
import com.study.deemo.object.*;
import com.study.deemo.parser.expr.PrimaryParserBuilder;
import com.study.deemo.parser.expr.UnaryParser;
import com.studyvm.pcomj.base.AbstractParserCombinator;
import com.studyvm.pcomj.base.ParseResult;
import com.studyvm.pcomj.base.ParserInput;
import com.studyvm.pcomj.combinator.AltParser;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExprTest {
    @Test
    public void testPrimary() {
        AltParser<DmBaseObject> primary = PrimaryParserBuilder.primary();
        test(primary, "null", DmNull.VALUE);
        test(primary, "false", DmBoolean.of(false));
        test(primary, "true", DmBoolean.of(true));
        test(primary, "'abs'", new DmString("abs"));
        test(primary, "\"a\\tbc\"", new DmString("a\tbc"));
        test(primary, "1.234", DmNumber.of(1.234));
        test(primary, "127", DmNumber.of(127));
        test(primary, "0", DmNumber.of(0));
    }

    private void test(AbstractParserCombinator<DmBaseObject> p, String input, DmBaseObject expect) {
        Optional<ParseResult<DmBaseObject>> opt = p.parse(new ParserInput(input));
        assertTrue(opt.isPresent());
        assertEquals(expect, opt.get().value());
    }

    private void testExpr(AbstractParserCombinator<Expr> p, String input, DmBaseObject expect) {
        Optional<ParseResult<Expr>> opt = p.parse(new ParserInput(input));
        assertTrue(opt.isPresent());
        assertEquals(expect, opt.get().value().eval());
    }

    @Test
    public void testUnaryExpr() {
        AbstractParserCombinator<Expr> unary = UnaryParser.unary();
        testExpr(unary, "typeof ''", DmString.of("STRING"));
        testExpr(unary, "typeof 0", DmString.of("NUMBER"));
        testExpr(unary, "!false", DmBoolean.of(true));
        testExpr(unary, "!0", DmBoolean.of(true));
    }


}
