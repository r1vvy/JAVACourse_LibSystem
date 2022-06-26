package com.libsystem.demo.model;

// Values taken from:
// https://www.abebooks.com/books/rarebooks/collecting-guide/understanding-rare-books/guide-book-conditions.shtml
public enum RatingValue {
    five_stars("★★★★★"),
    four_stars("★★★★"),
    three_stars("★★★"),
    two_stars("★★"),
    one_star("★");

    private final String displayValue;

    private RatingValue(String displayValue) {
        this.displayValue = displayValue;
    }
    public String getDisplayValue() {
        return displayValue;
    }
}
