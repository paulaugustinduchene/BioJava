package com.BioJava.DNA;

import com.BioJava.exceptions.NotACodingSequenceException;
import com.BioJava.exceptions.NotDNAException;
import com.BioJava.models.AminoAcids;
import com.BioJava.models.RestrictionSite;
import com.BioJava.models.Sequence;

import java.util.List;
import java.util.Map;

public interface NucleicAcidsSevices {

    AminoAcids findTranslation(String codon);

    Integer findStartCodon(Sequence sequence) throws NotDNAException, NotACodingSequenceException;

    String readSequenceWithFrame3Letters(Sequence sequence) throws NotDNAException;

    String findComplementaryStrand(Sequence sequence);

    Double GCRate(Sequence sequence);

    Map<Integer, RestrictionSite> findRestrictionSite(Sequence sequence, RestrictionSite restrictionSite);

    List<Map<Integer,RestrictionSite>> findAllRestrictionSites(Sequence sequence);
}
