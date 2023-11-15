package ru.job4j.collection;

import java.util.*;

public class SimpleArrayList<T> implements SimpleList<T> {

    private T[] container;
    private int size;
    private int modCount;

    public SimpleArrayList(int capacity) {
        container = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        if (size == container.length) {
            container = Arrays.copyOf(container, container.length > 0 ? container.length * 2 : 1);
        }
        container[size++] = value;
        modCount++;
    }

    @Override
    public T set(int index, T newValue) {
        if (Objects.checkIndex(index, size) < 0) {
            throw new IndexOutOfBoundsException();
        }
        T value = container[index];
        container[index] = newValue;
        return value;
    }

    @Override
    public T remove(int index) {
        T value;
        if (Objects.checkIndex(index, size) < 0) {
            throw new IndexOutOfBoundsException();
        }
        value = container[index];
        System.arraycopy(
                container,
                index + 1,
                container,
                index,
                container.length - index - 1
        );
        container[container.length - 1] = null;
        size--;
        modCount++;
        return value;
    }

    @Override
    public T get(int index) {
        if (Objects.checkIndex(index, size) < 0) {
            throw new IndexOutOfBoundsException();
        }
        return container[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            final int iterModCount = modCount;
            int iterCount = 0;

            @Override
            public boolean hasNext() {
                if (iterModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return iterCount < size;
            }

            @Override
            public T next() {
                if (iterCount >= size) {
                    throw new NoSuchElementException();
                }
                if (iterModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return container[iterCount++];
            }
        };
    }
}