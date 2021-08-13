package com.BioJava.DNA;

import com.BioJava.models.AminoAcids;
import com.BioJava.models.RestrictionSite;
import com.BioJava.models.Sequence;
import com.BioJava.exceptions.NotACodingSequenceException;
import com.BioJava.validation.ValidateSequence;
import com.BioJava.exceptions.NotDNAException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DNAServices implements NucleicAcidsSevices {

    /**
     * findStartCodon method is used to find the index of the start codon in a sequence.
     * @param sequence the DNA sequence that is being evaluated
     * @return the index of the start codon
     * @exception NotDNAException when the sequence is not DNA
     * @exception NotACodingSequenceException when the sequence does not contain a start codon
     */
    public Integer findStartCodon(Sequence sequence) throws NotDNAException, NotACodingSequenceException {

        if(!ValidateSequence.isDNA(sequence)){
            throw new NotDNAException("Sequence is not DNA !");
        }

        if(!sequence.getSequence().contains("ATG")){
            throw new NotACodingSequenceException("There is no start please check Sequence");
        }

        return sequence.getSequence().indexOf("ATG");
    }

    /**
     * This method find the start codon in a DNA sequence.
     * @param sequence the DNA sequence to be checked
     * @return the start codon of the DNA sequence
     * @throws NotDNAException if the given sequence is not a DNA sequence
     */
    public String readSequenceWithFrame3Letters(Sequence sequence) throws NotDNAException {
        Integer startIndex = 0;
        try{
             startIndex = findStartCodon(sequence);
        }catch (NotACodingSequenceException e) {
            e.printStackTrace();
        }

        Integer actual = startIndex;
        String  protein = "";

      while (actual + 3 < sequence.getSize()){
           String codon = sequence.getSequence().substring(actual, actual + 3 );
           protein = protein.concat("-" + this.findTranslation(codon).getLettersCode3());
           actual = actual+ 3;
           if(this.findTranslation(codon).equals(AminoAcids.STOP)) {
               break;
           }
        }
        return protein;
    }

    /**
     * This method finds the translation for a given codon.
     *
     * @param  codon the codon to be translated
     * @return the corresponding amino acid
     */
    public AminoAcids findTranslation(String codon) {

      if(codon.startsWith("G")) {
          if(codon.charAt(1) == 'T'){
              return  AminoAcids.VALINE;
          }
          if(codon.charAt(1) == 'C'){
              return  AminoAcids.ALANINE;
          }
          if(codon.charAt(1) == 'A'){
              if(codon.charAt(1) == 'T' || codon.charAt(1) == 'C'){
                return AminoAcids.ASPARTATE;
              }
              if(codon.charAt(1) == 'A' || codon.charAt(1) == 'G'){
                return AminoAcids.GLUTAMATE;
              }
          }
          if(codon.charAt(1) == 'G'){
              return  AminoAcids.GLYCINE;
          }
      }

      if(codon.startsWith("C")) {
          if(codon.charAt(1) == 'T'){
              return  AminoAcids.LEUCINE;
          }
          if(codon.charAt(1) == 'C'){
              return  AminoAcids.PROLINE;
          }
          if(codon.charAt(1) == 'A'){
              if(codon.charAt(1) == 'T' || codon.charAt(1) == 'C'){
                  return AminoAcids.HISTIDINE;
              }
              if(codon.charAt(1) == 'A' || codon.charAt(1) == 'G'){
                  return AminoAcids.GLUTAMINE;
              }
          }
          if(codon.charAt(1) == 'G'){
              return  AminoAcids.ARGININE;
          }
      }
      if(codon.startsWith("A")) {
          if(codon.charAt(1) == 'T'){
              if(codon.charAt(1) == 'T'){
                  return AminoAcids.METHIONINE;
              } else {
                  return AminoAcids.LEUCINE;
              }
          }
          if(codon.charAt(1) == 'C'){
              return  AminoAcids.THREONINE;
          }
          if(codon.charAt(1) == 'A'){
              if(codon.charAt(1) == 'T' || codon.charAt(1) == 'C'){
                  return AminoAcids.ASPARAGINE;
              }
              if(codon.charAt(1) == 'A' || codon.charAt(1) == 'G'){
                  return AminoAcids.LYSINE;
              }
          }
          if(codon.charAt(1) == 'G'){
              if(codon.charAt(1) == 'T' || codon.charAt(1) == 'C'){
                  return AminoAcids.SERINE;
              }
              if(codon.charAt(1) == 'A' || codon.charAt(1) == 'G'){
                  return AminoAcids.ARGININE;
              }
          }
      }

      if(codon.startsWith("T")) {
          if(codon.charAt(1) == 'T'){
              if(codon.charAt(1) == 'T' || codon.charAt(1) == 'C'){
                  return AminoAcids.PHENYLALANINE;
              }
              if(codon.charAt(1) == 'A' || codon.charAt(1) == 'G'){
                  return AminoAcids.LEUCINE;
              }
          }
          if(codon.charAt(1) == 'C'){
              return  AminoAcids.SERINE;
          }
          if(codon.charAt(1) == 'A'){
              if(codon.charAt(1) == 'T' || codon.charAt(1) == 'C'){
                  return AminoAcids.TYROSINE;
              }
              if(codon.charAt(1) == 'A' || codon.charAt(1) == 'G'){
                  return AminoAcids.STOP;
              }
          }
          if(codon.charAt(1) == 'G'){
              if(codon.charAt(1) == 'T' || codon.charAt(1) == 'C'){
                  return AminoAcids.CYSTEINE;
              }
              if( codon.charAt(1) == 'G'){
                  return AminoAcids.TRYPTOPHANE;
              }
              if( codon.charAt(1) == 'A'){
                  return AminoAcids.STOP;
              }
          }
      }
      return null;
    }

    /**
     * This method finds the complementary strand for a given sequence.
     * @param sequence the sequence for which the complementary strand is needed
     * @return the complementary strand
     */
    public String findComplementaryStrand(Sequence sequence) {

        StringBuilder complementaryStrand = new StringBuilder("");

        for(Character character : sequence.getSequence().toCharArray()){

            switch (character){

                case 'A':
                    complementaryStrand.append('T');
                    break;
                case 'T':
                    complementaryStrand.append('A');
                    break;
                case 'G':
                    complementaryStrand.append('C');
                    break;
                case 'C':
                    complementaryStrand.append('G');
                    break;
            }
        }
        return complementaryStrand.toString();
    }


    /**
     * This method returns the GC rate of a given sequence. The GC rate is the ratio of the number of G's and C's in the sequence over the total number of nucleotides in the sequence.
     * @param sequence the given sequence
     * @return the GC rate of the sequence
     */
    public Double GCRate(Sequence sequence) {
        Integer countGC = 0;
        for(int i = 0; i < sequence.getSize() ; i++) {
            Character character = sequence.getSequence().charAt(i);
            if (character.equals('G') || character.equals('C')){
                countGC++;
            }
        }
        return countGC.doubleValue()/sequence.getSize().doubleValue();
    }

    /**
     * Finds the restriction site in the sequence and puts it in a map.
     *
     * @param sequence the sequence to search through
     * @param restrictionSite the restriction site to look for
     * @return a map containing the position of the restriction site in the sequence as the key and the restriction site as the value
     */
    public Map<Integer,RestrictionSite> findRestrictionSite(Sequence sequence, RestrictionSite restrictionSite) {
        HashMap<Integer,RestrictionSite> map = new HashMap<>();
        map.put(sequence.getSequence().indexOf(restrictionSite.getSequence()),restrictionSite);
        return map;
    }

    /**
     * Find all restriction sites in a given sequence
     *
     * @param sequence the sequence to search
     * @return a list of all restriction sites in the sequence
     */
    public List<Map<Integer,RestrictionSite>> findAllRestrictionSites(Sequence sequence){
        List<Map<Integer,RestrictionSite>> sites = new ArrayList();

        for(RestrictionSite site : RestrictionSite.values()){
            Map<Integer, RestrictionSite> map = findRestrictionSite(sequence, site);
            if(!map.containsKey(-1)) {
                sites.add(map);
            }
        }
        return sites;
    }

}
