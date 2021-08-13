package com.BioJava.models;

public enum AminoAcids {

    ALANINE("Alanine","Ala",'A'),
    ARGININE("Arginine","Arg",'R'),
    ASPARAGINE("Asparagine","Asn",'N'),
    ASPARTATE("Aspartate","Asp",'D'),
    CYSTEINE("Cysteine","Cys",'C'),
    GLUTAMINE("Glutamine","Gln",'Q'),
    GLYCINE("Glycine","Gly",'G'),
    GLUTAMATE("Glutamate","Glu",'E'),
    HISTIDINE("Histidine","His",'H'),
    ISOLEUCINE("Isoleucine","Ile",'I'),
    LEUCINE("Leucine","Leu",'L'),
    LYSINE("Lysine","Lys",'K'),
    METHIONINE("Methionine","Met",'M'),
    PHENYLALANINE("Phenylalanine","Phe",'F'),
    PROLINE("Proline","Pro",'P'),
    SERINE("Serine","Ser",'S'),
    THREONINE("Threonine","Thr",'T'),
    TRYPTOPHANE("Tryptophan","Trp",'W'),
    TYROSINE("Tyrosine","Tyr",'Y'),
    VALINE("Valine","Val",'V'),
    STOP("Stop","Stop",'-');


    private String name;
    private String lettersCode3;
    private Character lettersCode1;

    AminoAcids (String name, String lettersCode3, Character lettersCode1){
        this.name = name;
        this.lettersCode3 = lettersCode3;
        this.lettersCode1 = lettersCode1;
    }

    public String getName() {
        return name;
    }

    public String getLettersCode3() {
        return lettersCode3;
    }

    public Character getLettersCode1() {
        return lettersCode1;
    }

}
