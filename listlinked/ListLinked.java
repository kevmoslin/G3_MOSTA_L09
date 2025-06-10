package listlinked;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListLinked<E> implements Iterable<E> {

    private static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<E> head;
    private int size;

    public ListLinked() {
        head = null;
        size = 0;
    }

    public void add(E data) {
        Node<E> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<E> aux = head;
            while (aux.next != null) {
                aux = aux.next;
            }
            aux.next = newNode;
        }
        size++;
    }

    public boolean remove(E data) {
        if (head == null) return false;

        if (head.data.equals(data)) {
            head = head.next;
            size--;
            return true;
        }

        Node<E> aux = head;
        while (aux.next != null && !aux.next.data.equals(data)) {
            aux = aux.next;
        }

        if (aux.next != null) {
            aux.next = aux.next.next;
            size--;
            return true;
        }

        return false;
    }

    public boolean contains(E data) {
        Node<E> aux = head;
        while (aux != null) {
            if (aux.data.equals(data)) return true;
            aux = aux.next;
        }
        return false;
    }

    public E get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        Node<E> aux = head;
        for (int i = 0; i < index; i++) {
            aux = aux.next;
        }

        return aux.data;
    }

    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> aux = head;
        while (aux != null) {
            sb.append(aux.data).append(" -> ");
            aux = aux.next;
        }
        sb.append("null");
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> current = head;

            public boolean hasNext() {
                return current != null;
            }

            public E next() {
                if (!hasNext()) throw new NoSuchElementException();
                E data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}
