package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NonNullIterator implements Iterator<Integer> {

    private final Integer[] data;
    private int index;

    public NonNullIterator(Integer[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        int i = index;
        while (i < data.length) {
            if (data[i] != null) {
                return true;
            }
            i++;
        }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Integer result = null;
        for (int i = index; i < data.length; i++) {
            if (data[index] != null) {
                result = data[index];
                this.index++;
                return result;
            }
            this.index++;
        }
        return result;

    }

}