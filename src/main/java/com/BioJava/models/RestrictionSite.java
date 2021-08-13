package com.BioJava.models;

public enum RestrictionSite {

    AVRII("CCTAGG", "AvrII"),
    BGLII("AGATCT", "BglII"),
    BSPEI("TCCGGA", "BspEI"),
    BSPHI("TCATGA", "BspHII"),
    BSSHII("GCGCGC","BssHII"),
    ECORI("GAATTC","EcoRI"),
    FSEI("GGCCGGCC", "FseI"),
    FSPI("TGCGCA","FspI"),
    HAEIII("GGCC","HaeIII"),
    MSCI("TGGCCA","MscI"),
    NARI("GGCGCC","NarI"),
    NSII("ATGCAT","NsiI"),
    PACI("TTAATTAA","PacI"),
    SMAI("CCCGGG","SmaI"),
    XBAI("TCTAGA","XbaI");

    private String sequence;
    private String name;

    RestrictionSite(String sequence, String name) {
        this.sequence = sequence;
        this.name = name;
    }

    public String getSequence() {
        return sequence;
    }

    public String getName() {
        return name;
    }
}
