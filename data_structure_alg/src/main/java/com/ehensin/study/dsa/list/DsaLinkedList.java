package com.ehensin.study.dsa.list;

import java.util.Objects;

/**
 * Linked list implements DsaList
 * warning : this is not a thread safe implementor
 * */
public class DsaLinkedList<T> implements DsaList<T>{
    DsaLinkNode<T> header;
    DsaLinkNode<T> tail;
    int size;
    public DsaLinkedList(){
        /*define a header node to make operation simple*/
        header = tail = new DsaLinkNode<>(null, null);
        size = 0;
    }
    @Override
    public void add(T t) {
        assert t != null;
        DsaLinkNode<T> newNode = new DsaLinkNode<>(t, null);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    @Override
    public void add(int index, T t) {
        assert index >= 0 && index <= size && t != null;
        DsaLinkNode<T> current = header;
        /*make current node point the parent of the indexed node*/
        while( current != null && --index >= 0){
            current = current.next;
        }
        current.next = new DsaLinkNode<>(t, current.next);
        if( current.next.next == null )
            tail = current.next;
        size++;
    }

    @Override
    public void remove(T t) {
        assert t != null && !isEmpty();
        DsaLinkNode<T> current = header;
        /*make current node point the parent of the matched node*/
        while( current != null ){
            if(Objects.equals(t, current.next.element) ){
               current.next = current.next.next;
               if( current.next == null ){
                   tail = current;
               }
               size--;
               break;
            }
            current = current.next;
        }
    }

    @Override
    public void remove(int index) {
        assert index >= 0 && index < size && !isEmpty();
        DsaLinkNode<T> current = header;
        /*point to the parent of the matched node*/
        while( current != null && --index >= 0 ){
            current = current.next;
        }
        current.next = current.next.next;
        if( current.next == null ){
            tail = current;
        }
        size--;
    }

    @Override
    public T get(int index) {
        assert index >= 0 && index < size;
        DsaLinkNode<T> current = header.next;
        while( current != null && --index >= 0 ){
            current = current.next;
        }
        return current == null ? null : current.element;
    }

    @Override
    public int indexOf(T t) {
        assert t != null;
        DsaLinkNode<T> current = header.next;
        int index = 0;
        int result = -1;
        while( current != null ){
            if(Objects.equals(t, current.element) ){
                result = index;
                break;
            }
            current = current.next;
            index++;
        }
        return result;
    }

    @Override
    public boolean contains(T t) {
        return indexOf(t) != -1;
    }

    @Override
    public boolean isEmpty() {
        return header == tail;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        header.next = null;
        tail = header;
        size = 0;
    }

    @Override
    public int getCapacity() {
        throw new UnsupportedOperationException("no capacity limitation in linked list");
    }


    class DsaLinkNode<T>{
        T element;
        DsaLinkNode<T> next;
        DsaLinkNode(T e, DsaLinkNode<T> next){
            this.element = e;
            this.next = next;
        }
    }
}
