package com.ehensin.study.dsa.list;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestList {
    @Test
    public void testListAdd(){
        final DsaList<Integer> intDsaList = new DsaArrayList<>();
        intDsaList.add(10);
        assert intDsaList.get(0) == 10;

        intDsaList.add(20);
        assert intDsaList.get(1) == 20;
        assert intDsaList.indexOf(10) == 0;
        assert intDsaList.indexOf(20) == 1;
        assert intDsaList.indexOf(100) == -1;

        Assertions.assertThrows(AssertionError.class, () -> intDsaList.get(-1));

        /*test with capacity*/
        final DsaList<Integer> newDsaList = new DsaArrayList<>(5);
        for(int i = 0; i < 10; i++ ){
            newDsaList.add(i);
        }
        assert newDsaList.getCapacity() == 10;
        newDsaList.add(10);
        assert newDsaList.getCapacity() == 20;
    }
    @Test
    public void testListAddIndex(){
        DsaList<Integer> intDsaList = new DsaArrayList<>();
        intDsaList.add(10);
        intDsaList.add(20);
        intDsaList.add(0,30);

        assert intDsaList.get(0) == 30;
        assert intDsaList.get(1) == 10;
        assert intDsaList.get(2) == 20;
        Assertions.assertThrows(AssertionError.class, () -> intDsaList.add(-1,40));
        Assertions.assertThrows(AssertionError.class, () -> intDsaList.add(3,40));

        intDsaList.add(2,40);
        assert intDsaList.get(2) == 40;
        assert intDsaList.get(3) == 20;

        /*test with capacity*/
        final DsaList<Integer> newDsaList = new DsaArrayList<>(5);
        newDsaList.add(0);
        for(int i = 0; i < 10; i++ ){
            newDsaList.add(0, i);
        }
        assert newDsaList.get(0) == 9;
        assert newDsaList.getCapacity() == 20;
        newDsaList.add(10);
        assert newDsaList.get(11) == 10;
        assert newDsaList.getCapacity() == 20;
    }
    @Test
    public void testListGet(){
        DsaList<Integer> intDsaList = new DsaArrayList<>();
        assert intDsaList.size() == 0;
        Assertions.assertThrows(AssertionError.class, ()-> intDsaList.get(0));
    }
}
