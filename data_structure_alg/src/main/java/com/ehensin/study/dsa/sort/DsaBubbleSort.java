package com.ehensin.study.dsa.sort;

public class DsaBubbleSort<T extends Comparable<T>> implements DsaSort<T> {
    @Override
    public T[] sort(T[] array) {
        assert array != null;
        boolean isExchanged = false;
        for(int i = 0; i < array.length; i++ ){
            for(int j = array.length - 1  ; j > i ; j-- ){
                if( array[j].compareTo(array[j-1]) < 0 ){
                    isExchanged = true;
                    T tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                }
            }
            if( !isExchanged ){
                break;
            }
        }
        return array;
    }
}
