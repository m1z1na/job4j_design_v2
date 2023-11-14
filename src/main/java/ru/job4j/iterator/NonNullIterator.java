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
        for (int i = index; i < data.length; i++) {
            if (data[i] != null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        if (hasNext()) {
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
        } else {
            throw new NoSuchElementException();
        }
    }

}