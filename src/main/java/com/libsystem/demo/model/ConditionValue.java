package com.libsystem.demo.model;

public enum ConditionValue {
    // The book is in the same immaculate condition as when it was published.  
    // This could be the description for a book that has been lost in a warehouse for years, never shelved, thumbed or even opened yet may still be some years old.
    as_new("As new"),
    // A Fine book approaches the condition of As New, but without being crisp.  
    // The book may have been opened and read, but there are no defects to the book, jacket or pages. 
    fine("Fine"),
    // Describes a book that shows some small signs of wear - but no tears - on either binding or paper. Any defects should be noted by the seller.
    very_good("Very good"),
    // Describes the average used worn book that has all pages or leaves present. Any defects should be noted by the seller.
    good("Good"),
    // Worn book that has complete text pages (including those with maps or plates) but may lack endpapers, half-title, etc. (which must be noted). 
    // Binding, jacket (if any), etc., may also be worn. All defects should be noted.
    fair("Fair"),
    // Describes a book that is sufficiently worn.  
    // Any missing maps or plates should still be noted. 
    // This copy may be soiled, scuffed, stained or spotted and may have loose joints, hinges, pages, etc.
    poor("Poor"),
    // describes a book in which the pages or leaves are perfect but the binding is very bad, loose, off, or nonexistent.
    binding_copy("Binding copy"),
    // A copy usually in poor to fair condition that includes all text presented in a legible fashion.  
    // The copy is fine to read but nothing more.
    reading_copy("Reading copy");

    private final String displayValue;

    private ConditionValue(String displayValue) {
        this.displayValue = displayValue;
    }
    public String getDisplayValue() {
        return displayValue;
    }


}
