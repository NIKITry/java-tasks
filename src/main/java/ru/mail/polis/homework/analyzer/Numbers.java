package ru.mail.polis.homework.analyzer;

public class Numbers extends Spam implements TextAnalyzer {

    public Numbers(String[] spam) {
        super(spam);
    }

    @Override
    public FilterType analyze(String text) {
        if (super.analyze(text).equals(FilterType.SPAM)) {
            return FilterType.CUSTOM;
        }
        return FilterType.GOOD;
    }
}
