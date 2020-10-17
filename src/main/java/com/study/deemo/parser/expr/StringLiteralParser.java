package com.study.deemo.parser.expr;

import com.study.deemo.exception.DmUnsupportedEscapeCharacterError;
import com.studyvm.pcomj.base.AbstractParserCombinator;
import com.studyvm.pcomj.base.ParseResult;
import com.studyvm.pcomj.base.ParserInput;
import com.studyvm.pcomj.parser.CharParser;

import java.util.Optional;

import static com.studyvm.pcomj.utils.CommonUtil.makeResult;
import static com.studyvm.pcomj.utils.ParserBuilder.pack;
import static com.studyvm.pcomj.utils.ParserBuilder.symbol;

public class StringLiteralParser extends AbstractParserCombinator<String> {
    final char quote;

    StringLiteralParser(char quote) {
        assert quote == '\'' || quote == '"';
        this.quote = quote;
    }

    public static StringLiteralParser strLit(char quote) {
        return new StringLiteralParser(quote);
    }

    public static AbstractParserCombinator<String> string(char ch) {
        CharParser quote = symbol(ch);
        return pack(quote, strLit(ch), quote);
    }

    @Override
    public Optional<ParseResult<String>> parse(ParserInput s) {
        StringBuilder sb = new StringBuilder();
        char ch;
        while ((ch = s.current()) != quote) {
            if (ch == '\\') {
                s.advance();
                ch = escape(s.current());
            }
            sb.append(ch);
            s.advance();
        }
        return makeResult(sb.toString(), s.rest());
    }

    private char escape(char current) {
        switch (current) {
            case '\'':
                return '\'';
            case '"':
                return '"';
            case 't':
                return '\t';
            default:
                throw new DmUnsupportedEscapeCharacterError(current);
        }
    }
}
