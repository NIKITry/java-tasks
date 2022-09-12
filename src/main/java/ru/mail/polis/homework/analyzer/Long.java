package ru.mail.polis.homework.analyzer;

public class Long implements TextAnalyzer {
    private final long maxLength;

    public Long(long maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public FilterType analyze(String text) {
        if (text == null || text.length() <= maxLength) {
            return FilterType.GOOD;
        }
        return FilterType.TOO_LONG;
    }
}
