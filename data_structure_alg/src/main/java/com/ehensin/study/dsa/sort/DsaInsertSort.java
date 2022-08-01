package com.ehensin.study.dsa.sort;

public class DsaInsertSort<T extends Comparable<T>> implements DsaSort<T> {
    @Override
    public T[] sort(T[] array) {
        assert array != null;
        for(int i = 1; i < array.length; i++){
            for( int j = i; (j > 0 && (array[j].compareTo(array[j-1]) < 0)); j--){
                T tmp = array[j];
                array[j] = array[j-1];
                array[j-1] = tmp;
            }
        }
        return array;
    }
}
