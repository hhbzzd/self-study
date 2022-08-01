package com.ehensin.study.dsa.sort;

public class DsaSelectSort<T extends Comparable<T>> implements DsaSort<T> {
    @Override
    public T[] sort(T[] array) {
        assert array != null;
        for( int i = 0; i < array.length; i++ ){
            int index = i;
            for( int j = i + 1; j < array.length; j++ ){
                if( array[index].compareTo(array[j]) > 0 ){
                    index = j;
                }
            }
            T tmp = array[i];
            array[i] = array[index];
            array[index] = tmp;
        }
        return array;
    }
}
