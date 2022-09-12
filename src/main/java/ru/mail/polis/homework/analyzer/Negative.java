package ru.mail.polis.homework.analyzer;

import java.util.logging.Filter;

public class Negative extends Spam implements TextAnalyzer {

    public Negative(String[] negative) {
        super(negative);
    }

    @Override
    public FilterType analyze(String text) {
        if (super.analyze(text).equals(FilterType.SPAM)) {
            return FilterType.NEGATIVE_TEXT;
        }
        return FilterType.GOOD;
    }
}
