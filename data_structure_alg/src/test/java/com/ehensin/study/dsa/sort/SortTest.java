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
}
