package com.ehensin.study.dsa.sort;

public class DsaQuickSort<T extends Comparable<T>> implements DsaSort<T> {
    @Override
    public T[] sort(T[] array) {
        assert array != null && array.length > 0 ;
        sort(array, 0, array.length - 1);
        return array;
    }

    private void sort(T[] array, int start, int end){
        int pivot = findPivot(array, start, end);
        /*move pivot to end*/
        T tmp = array[pivot];
        array[pivot] = array[end];
        array[end] = tmp;
        /* partition */
        int k = partition(array, start , end, array[end]);
        /*exchange pivot to k position*/
        tmp = array[end];
        array[end] = array[k];
        array[k] = tmp;

        if( k - start > 1){
            sort(array, start, k - 1);
        }
        if( end - k > 1 ){
            sort(array,k + 1, end);
        }
    }

    private int findPivot(T[] array, int start, int end){
        return  (end + start)/2;
    }

    private int partition(T[] array, int start, int end, T pivot) {
        int left = start, right = end;
        do {

            while (array[left].compareTo(pivot) < 0){left++;};
            while( right > 0 && array[--right].compareTo(pivot) > 0 );
            T t = array[left];
            array[left] = array[right];
            array[right] = t;
        }while(left < right);
        T tmp = array[right];
        array[right] = array[left];
        array[left] = tmp;
        return left;
    }
}
