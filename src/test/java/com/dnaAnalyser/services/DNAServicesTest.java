package com.dnaAnalyser.services;


import com.BioJava.models.AminoAcids;
import com.BioJava.models.RestrictionSite;
import com.BioJava.models.Sequence;
import com.BioJava.DNA.DNAServices;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;


public class DNAServicesTest {

    @Mock
    private DNAServices dnaServices;

    @BeforeEach
    public void setUp(){
        dnaServices = new DNAServices();
    }

    /********************  GC-Rate  *******************/
    @Test
    public void testGCRate() {
        Sequence sequence1 = new Sequence();
        sequence1.setSequence("GCAT");// 50% GC ratio expected.
        Double rate = dnaServices.GCRate(sequence1);
        assertEquals(0.5, rate, 0);
    }


    @Test
    public void testGetCodon() {
        assertEquals( AminoAcids.VALINE, dnaServices.findTranslation("GTC"));
        assertEquals(AminoAcids.ALANINE, dnaServices.findTranslation("GCA"));
        assertNull(dnaServices.findTranslation("DFG"));
    }

    @Test
    public void findComplementaryStrandTest() {
        String expectedComplementStrand = "TACGTACGTACGTACGTACGTACGTACG";
        Sequence sequence1 = new Sequence();
        sequence1.setSequence("ATGCATGCATGCATGCATGCATGCATGC");
        String complementStrand = dnaServices.findComplementaryStrand(sequence1);
        assertEquals(expectedComplementStrand, complementStrand);
    }

    @Test
    public void testReadSequenceWithFrame3() throws Exception {

        String expected = "-Met-Ala-Leu-Thr-Arg-Phe-Lys";

        Sequence sequence1 = new Sequence();
        sequence1.setSequence("ATGGCCCTAACTAGATTGAAAC");//-Met-Ala-Leu-Thr-Arg-Phe-Lys

        assertEquals(expected, dnaServices.readSequenceWithFrame3Letters(sequence1));
    }


    @Test
    public void findRestrictionSite() throws Exception {

        Sequence sequence1 = new Sequence();
        sequence1.setSequence("TTTCCAACGTGGGAATTCAAGGCTCCTGTGCTCCAGTGTGT");
        DNAServices dnaServices = new DNAServices();
        Map<Integer,RestrictionSite> map = new HashMap<>();
        map.put(12,RestrictionSite.ECORI);
        assertEquals(map,dnaServices.findRestrictionSite(sequence1, RestrictionSite.ECORI));
    }

    @Test
    public void findRestrictionSite_shouldReturn_mapwithMinus1() throws Exception {

        Sequence sequence1 = new Sequence();
        sequence1.setSequence("TTTCCAACGTGGGAATTCAAGGCTCCTGTGCTCCAGTGTGT");
        DNAServices dnaServices = new DNAServices();
        Map<Integer,RestrictionSite> map = new HashMap<>();
        map.put(-1,RestrictionSite.BSPHI);
        assertEquals(map,dnaServices.findRestrictionSite(sequence1, RestrictionSite.BSPHI));
    }

}