package com.ehensin.study.dsa.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SortTest {
    @Test
    public void testInsertSort(){
        DsaSort<Integer> sorter = new DsaInsertSort<>();
        assert Arrays.equals(sorter.sort(new Integer[]{2,6,3,1}), new Integer[]{1,2,3,6});
        assert Arrays.equals(sorter.sort(new Integer[]{2}), new Integer[]{2});
        assert Arrays.equals(sorter.sort(new Integer[]{}), new Integer[]{});
    }

    @Test
    public void testBubbleSort(){
        DsaSort<Integer> sorter = new DsaBubbleSort<>();
        assert Arrays.equals(sorter.sort(new Integer[]{2,6,3,1}), new Integer[]{1,2,3,6});
        assert Arrays.equals(sorter.sort(new Integer[]{1,2,3}), new Integer[]{1,2,3});
        assert Arrays.equals(sorter.sort(new Integer[]{}), new Integer[]{});
    }

    @Test
    public void testSelectSort(){
        DsaSort<Integer> sorter = new DsaSelectSort<>();
        assert Arrays.equals(sorter.sort(new Integer[]{2,6,3,1}), new Integer[]{1,2,3,6});
        assert Arrays.equals(sorter.sort(new Integer[]{1,2,3}), new Integer[]{1,2,3});
        assert Arrays.equals(sorter.sort(new Integer[]{}), new Integer[]{});
    }

    @Test
    public void testQuickSort(){
        DsaSort<Integer> sorter = new DsaQuickSort<>();
        assert Arrays.equals(sorter.sort(new Integer[]{2,6,3,1}), new Integer[]{1,2,3,6});
        assert Arrays.equals(sorter.sort(new Integer[]{1,2,3}), new Integer[]{1,2,3});
        Integer[] array = new Integer[]{6,5,4,3,2,1,0};
        int i = 0;
        assert array[++i] == 5;
        assert i == 1;
        assert Arrays.equals(sorter.sort(array), new Integer[]{0,1,2,3,4,5,6});

        assert Arrays.equals(sorter.sort(new Integer[]{6,5,4,-1,2,1,0,10}), new Integer[]{-1,0,1,2,4,5,6,10});
    }
}
