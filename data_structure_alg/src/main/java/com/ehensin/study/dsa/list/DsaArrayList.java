package com.ehensin.study.dsa.list;

import java.util.Objects;

/**
 * Array list implements DsaList
 * warning : this is not a thread safe implementor
 * */
public class DsaArrayList<T> implements DsaList<T>{
    /*internal array to contain elements*/
    private T[] elements;
    /*capacity for current list, default value is 100 */
    private int initCapacity;
    private int capacity = 100;
    /*size of the list*/
    private int size;
    public DsaArrayList(T[] elements) {
        assert elements != null;
        this.elements = elements;
        this.size = elements.length;
    }
    public DsaArrayList() {
        initCapacity = this.capacity;
        this.elements = (T[]) new Object[this.capacity];
    }
    public DsaArrayList(int capacity) {
        assert capacity > 0;
        this.elements = (T[]) new Object[capacity];
        this.initCapacity = capacity;
        this.capacity = capacity;
    }

    private void resize(int newSize){
        assert newSize > capacity;
        T[] newElements = (T[]) new Object[newSize];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        elements = newElements;
        capacity = newSize;
    }
    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public void add(T t) {
        /*check capacity*/
        if( size >= capacity ){
            /*resize list, increase twice*/
            resize(capacity + capacity);
        }
        elements[size++] = t;
    }

    @Override
    public void add(int index, T t) {
        assert index >= 0 && index <= size;
        if( size >= capacity ){
            /*resize list, increase twice*/
            resize(capacity + capacity);
        }
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = t;
        size++;
    }

    @Override
    public void clear() {
        size = 0;
        capacity = this.initCapacity;
        elements = (T[])new Object[capacity];
    }

    @Override
    public void remove(T t) {
        assert t != null;
        /*locate the index*/
        int index = indexOf(t);
        if( index == -1 )
            return;
        System.arraycopy(elements, index + 1, elements, index, size - index);
        size--;
    }

    @Override
    public void remove(int index) {
        assert index >= 0 && index < size;
        System.arraycopy(elements, index + 1, elements, index, size - index);
        size--;
    }

    @Override
    public T get(int index) {
        assert index >=0 && index < size;
        return elements[index];
    }

    @Override
    public int indexOf(T t) {
        assert  t != null;
        for( int i = 0; i < size; i++ ){
            T e = elements[i];
            if(Objects.equals(e, t)){
                 return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(T t) {
        return indexOf(t) != -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
