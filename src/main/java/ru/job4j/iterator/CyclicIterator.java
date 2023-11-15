package ru.job4j.iterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CyclicIterator<T> implements Iterator<T> {

    private final List<T> data;
    private int index; /* здесь разместите поля класса, если они будут нужны  */


    public CyclicIterator(List<T> data) {
        this.data = data;
        /* код конструктора */
    }

    @Override
    public boolean hasNext() {
        return data.size() > 0;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (index >= data.size()) {
            index = 0;
        }
        return data.get(index++);

    }
}