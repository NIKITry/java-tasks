package ru.mail.polis.homework.analyzer;

public class Spam implements TextAnalyzer {
    protected final String[] spam;

    public Spam(String[] spam) {
        this.spam = spam;
    }

    @Override
    public FilterType analyze(String text) {
        for (int i = 0; i < spam.length; i++) {
            if(text.contains(spam[i])) {
                return FilterType.SPAM;
            }
        }
        return FilterType.GOOD;
    }
}
