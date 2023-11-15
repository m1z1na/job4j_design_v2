package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleLinkedList<E> implements SimpleLinked<E> {

    private int size;
    private int modCount;
    private Node<E> head;

    @Override
    public void add(E value) {
        size++;
        modCount++;
        if (head == null) {
            this.head = new Node<>(value, null);
        } else {
            Node<E> currentNode = this.head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = new Node<>(value, null);
        }
    }

    @Override
    public E get(int index) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> value = head;
        for (int i = 0; i < index; i++) {
            value = value.next;
        }
        return value.item;
    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {

            final int iterModCount = modCount;
            int iterCount = 0;
            Node<E> tmp = head;

            @Override
            public boolean hasNext() {
                return iterCount < size;
            }

            @Override
            public E next() {
                if (iterCount >= size) {
                    throw new NoSuchElementException();
                }
                if (iterModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                E rsl = tmp.item;
                tmp = tmp.next;
                iterCount++;
                return rsl;
            }
        };
    }

    private static class Node<E> {
        private final E item;
        private Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }
}