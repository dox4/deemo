package com.study.deemo.parser;

import com.studyvm.pcomj.combinator.AtLeastParser;

import static com.studyvm.pcomj.utils.ParserBuilder.space;

public class CommonParser {
    public static AtLeastParser<Character> sep1() {
        return space().some();
    }
}
