package com.BioJava.DNA;

import com.BioJava.models.DNASequence;
import com.BioJava.models.Sequence;

public class DNAMapper {

    /**
     * Converts a DNA sequence to an RNA sequence.
     * @param sequence the DNA sequence to convert
     * @return the RNA sequence
     */
    public Sequence DNAtoRNA (Sequence sequence) {
        Sequence rnaSquence = new Sequence();
        rnaSquence.setSequence(sequence.getSequence().replace('T', 'U'));
        return rnaSquence;
    }

    /**
     * Converts an RNA sequence to a DNA sequence.
     * @param sequence the RNA sequence to convert
     * @return the DNA sequence
     */
    public Sequence RNAtoDNA (Sequence sequence) {
        Sequence dnaSquence = new DNASequence();
        dnaSquence.setSequence(sequence.getSequence().replace('U', 'T'));
        return dnaSquence;
    }
}
