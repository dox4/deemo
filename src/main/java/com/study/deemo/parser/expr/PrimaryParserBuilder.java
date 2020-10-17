package com.study.deemo.parser.expr;

import com.study.deemo.object.*;
import com.studyvm.pcomj.adaptor.Mapper;
import com.studyvm.pcomj.base.AbstractParserCombinator;
import com.studyvm.pcomj.base.Pair;
import com.studyvm.pcomj.combinator.AltParser;
import com.studyvm.pcomj.combinator.OrParser;
import com.studyvm.pcomj.combinator.StringAccumulator;
import com.studyvm.pcomj.parser.CharParser;
import com.studyvm.pcomj.parser.OneOfParser;

import static com.studyvm.pcomj.utils.ParserBuilder.*;

/**
 * Parsers
 * <p>
 * primary expr:
 * null, true, false, number, string, array, object
 * array:
 * [ expr [, expr] ]
 * object:
 * { [field decl list] }
 * field decl list:
 * field decl [, field decl]
 * filed decl:
 * string: expr
 * <p>
 * assignment expr:
 * =
 * field access expr:
 * primary expr . primary expr
 * function call expr:
 * primary expr ( argument list )
 * argument list:
 * expr [, expr]
 */

public class PrimaryParserBuilder {
    @SuppressWarnings("unchecked")
    public static AltParser<DmBaseObject> primary() {
        return alt(nul(), number(), bool(), string());
    }

    private static AbstractParserCombinator<DmBaseObject> number() {
        OrParser<Character> sign = symbol('+').or(symbol('-'));
        OneOfParser digit1To9 = oneOf("123456789");
        OneOfParser digit0To9 = oneOf("0123456789");
        StringAccumulator digitAccumulate = digit0To9.accumulate();
        Mapper<Pair<Character, String>, String> integer = digit1To9
                .and(digitAccumulate.option("")).concat();
        CharParser point = symbol('.');
        Mapper<Pair<Character, String>, String> fractional = point.and(digitAccumulate).concat();

        Mapper<Pair<String, String>, String> decimalGT1 = integer.and(fractional.option("")).map(Pair::concat);
        Mapper<Pair<Character, String>, String> decimalLT1 = symbol('0').and(fractional.option("")).concat();

        Mapper<String, Double> decimal = decimalGT1.or(decimalLT1)
                .map(Double::parseDouble);

        Mapper<Pair<Character, Double>, Double> signedNumber =
                sign.option('+')
                        .and(decimal)
                        .map(pair -> pair.first() == '-' ? -pair.second() : pair.second());

        return signedNumber.map(DmNumber::of);
    }

    private static AbstractParserCombinator<DmBaseObject> bool() {
        return keyword("false")
                .or(keyword("true"))
                .map(s -> DmBoolean.of(Boolean.parseBoolean(s)));
    }

    private static AbstractParserCombinator<DmBaseObject> nul() {
        return keyword("null").map(s -> DmNull.VALUE);
    }

    private static AbstractParserCombinator<DmBaseObject> string() {
        return StringLiteralParser.string('\'').or(StringLiteralParser.string('"')).map(DmString::new);
    }

//    private static AbstractParserCombinator<DmBaseObject> array() {
//        return nul();
//    }

}
