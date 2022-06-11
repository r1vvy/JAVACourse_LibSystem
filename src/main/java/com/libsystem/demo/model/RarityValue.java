package com.libsystem.demo.model;

// Values taken from: 
// https://antiques.lovetoknow.com/How_to_Identify_a_Rare_Book
public enum RarityValue {
    // A first edition of famous books or books of significance can be rare and valuable.
    first_edition,
    // A book can be rare if it was signed or autographed by the author or someone of significance.
    signed,
    // If a famous person previously owned the book or the story of the book's history is documented and interesting, it can have provenance and be rare.
    provenance,
    //  Something of special interest or aesthetic importance about the book can make it rare. 
    // This can include an exquisite or notable binding, exceptional artwork, 
    // illustrations by artists of importance or extra-illustrated works, a unique or unusual design, or fine printing or typography.
    special_interest,
    //  These can include watermarks or a pirated copy and also the use of a special press such as a Bozart Press.
    unusual_phys_charstics,
    // The condition of the book can make it rare, especially if it's one of few copies in good condition.
    except_condition
}
