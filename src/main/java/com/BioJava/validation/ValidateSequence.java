package com.BioJava.validation;

import com.BioJava.models.Sequence;

import java.util.regex.Pattern;

/**
 * validate the given sequence
 * @author
 *
 */
public class ValidateSequence {

    /**
     * isDNA method to check if the given sequence is DNA
     * @param sequence a {@link Sequence]
     * @return true if sequence is DNA  so contains only A,T,C or G
     */
    public static Boolean isDNA(Sequence sequence){
       if(Pattern.matches("[ATGC]", sequence.getSequence())){
           return false;
       }else {return true;}
    }

    /**
     * isRNA method to check if the given sequence is RNA
     * @param sequence a {@link Sequence]
     * @return true if sequence is RNA  so contains only A,U,C or G
     */
    public static Boolean isRNA(Sequence sequence){
        if(Pattern.matches("[AUGC]", sequence.getSequence())){
            return false;
        }else {return true;}
    }
}
