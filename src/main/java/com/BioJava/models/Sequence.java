package com.BioJava.models;

import java.util.Objects;

public class Sequence {

    private Integer size;
    private String sequence;

    public Integer getSize() {
        size = sequence.length();
        return size;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
        this.size = this.getSize();
    }

    @Override
    public String toString() {
        return "Sequence " +
                "size=" + size +
                ", sequence='" + sequence + '\'' ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sequence sequence1 = (Sequence) o;
        return Objects.equals(size, sequence1.size) && Objects.equals(sequence, sequence1.sequence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, sequence);
    }
}
