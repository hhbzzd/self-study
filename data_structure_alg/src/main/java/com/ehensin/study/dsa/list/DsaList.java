package com.ehensin.study.dsa.list;

/**
 * data structure and algorithm analysis
 * List : ADT
 *
 * */
public interface DsaList<T> {
    void add(T t);
    void add(int index, T t);
    void remove(T t);
    void remove(int index);
    T get(int index);
    /**
     * return index of array which match the t parameter firstly.
     * index should be great equal than 0 and less than size;
     * @return index of firstly matched element
     *         -1 if no element matched
     * */
    int indexOf(T t);
    boolean contains(T t);
    boolean isEmpty();
    int size();
    void clear();
    int getCapacity();
}
