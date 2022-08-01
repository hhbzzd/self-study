package com.ehensin.study.dsa.list;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayListTest {
    @Test
    public void testListAdd() {
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
        for (int i = 0; i < 10; i++) {
            newDsaList.add(i);
        }
        assert newDsaList.getCapacity() == 10;
        newDsaList.add(10);
        assert newDsaList.getCapacity() == 20;
    }

    @Test
    public void testListAddIndex() {
        DsaList<Integer> intDsaList = new DsaArrayList<>();
        intDsaList.add(0, 10);
        intDsaList.add(20);
        intDsaList.add(0, 30);

        assert intDsaList.get(0) == 30;
        assert intDsaList.get(1) == 10;
        assert intDsaList.get(2) == 20;
        Assertions.assertThrows(AssertionError.class, () -> intDsaList.add(-1, 40));
        Assertions.assertThrows(AssertionError.class, () -> intDsaList.add(4, 40));

        intDsaList.add(2, 40);
        assert intDsaList.get(2) == 40;
        assert intDsaList.get(3) == 20;

        /*test with capacity*/
        final DsaList<Integer> newDsaList = new DsaArrayList<>(5);
        newDsaList.add(0);
        for (int i = 0; i < 10; i++) {
            newDsaList.add(0, i);
        }
        assert newDsaList.get(0) == 9;
        assert newDsaList.getCapacity() == 20;
        newDsaList.add(10);
        assert newDsaList.get(11) == 10;
        assert newDsaList.getCapacity() == 20;
    }

    @Test
    public void testListGet() {
        DsaList<Integer> intDsaList = new DsaArrayList<>();
        assert intDsaList.size() == 0;
        Assertions.assertThrows(AssertionError.class, () -> intDsaList.get(0));

        intDsaList.add(0, 10);
        intDsaList.add(20);
        intDsaList.add(0, 30);

        assert intDsaList.get(0) == 30;
        assert intDsaList.get(1) == 10;
        assert intDsaList.get(2) == 20;
    }

    @Test
    public void testGetCapacity() {
        DsaList<Integer> intDsaList = new DsaArrayList<>();
        assert intDsaList.getCapacity() == 100;

        for (int i = 0; i < 100; i++) {
            intDsaList.add(0, i);
        }
        assert intDsaList.getCapacity() == 100;
        intDsaList.add(100);
        assert intDsaList.getCapacity() == 200;

        for (int i = 101; i < 200; i++) {
            intDsaList.add(0, i);
        }
        assert intDsaList.getCapacity() == 200;
        intDsaList.add(200);
        assert intDsaList.getCapacity() == 400;
    }

    @Test
    public void testListIndexof() {
        DsaList<Integer> intDsaList = new DsaArrayList<>();
        assert intDsaList.indexOf(1) == -1;

        Assertions.assertThrows(AssertionError.class, () -> intDsaList.indexOf(null));

        intDsaList.add(0, 10);
        intDsaList.add(20);
        intDsaList.add(0, 30);

        assert intDsaList.indexOf(20) == 2;
        assert intDsaList.indexOf(30) == 0;
    }

    @Test
    public void testListContains() {
        DsaList<String> intDsaList = new DsaArrayList<>();
        assert !intDsaList.contains("abc");

        intDsaList.add("hello");
        intDsaList.add(" ");
        intDsaList.add("world");

        assert intDsaList.contains("hello");

    }

    @Test
    public void testListSize() {
        DsaList<String> intDsaList = new DsaArrayList<>();
        assert intDsaList.size() == 0;

        intDsaList.add("hello");
        intDsaList.add(" ");
        intDsaList.add("world");

        assert intDsaList.size() == 3;

    }

    @Test
    public void testListIsEmpty() {
        DsaList<String> intDsaList = new DsaArrayList<>();
        assert intDsaList.isEmpty();

        intDsaList.add("hello");
        intDsaList.add(" ");
        intDsaList.add("world");

        assert !intDsaList.isEmpty();

    }

    @Test
    public void testListClear() {
        DsaList<String> intDsaList = new DsaArrayList<>();
        intDsaList.add("hello");
        intDsaList.add(" ");
        intDsaList.add("world");

        assert !intDsaList.isEmpty();
        intDsaList.clear();

        assert intDsaList.isEmpty();
        assert intDsaList.size() == 0;
        assert !intDsaList.contains("hello");
        assert intDsaList.indexOf("hello") == -1;
        Assertions.assertThrows(AssertionError.class, () -> intDsaList.get(0));
        assert intDsaList.getCapacity() == 100;

        intDsaList.add("ok");
        assert intDsaList.get(0) == "ok";

    }

    @Test
    public void testListRemove() {
        DsaList<String> intDsaList = new DsaArrayList<>();
        intDsaList.add("hello");
        intDsaList.add(" ");
        intDsaList.add("world");

        intDsaList.remove(" ");
        assert intDsaList.get(1) == "world";
        intDsaList.remove("hello");
        assert intDsaList.get(0) == "world";
        assert intDsaList.size() == 1;
        Assertions.assertThrows(AssertionError.class, () -> intDsaList.get(1));

        intDsaList.remove("world");
        assert intDsaList.indexOf("world") == -1;
        assert intDsaList.size() == 0;
        Assertions.assertThrows(AssertionError.class, () -> intDsaList.get(0));

        intDsaList.remove("abc");
    }

    @Test
    public void testListRemoveWithIndex() {
        DsaList<String> intDsaList = new DsaArrayList<>();
        Assertions.assertThrows(AssertionError.class, () -> intDsaList.remove(1));

        intDsaList.add("hello");
        intDsaList.add(" ");
        intDsaList.add("world");
        Assertions.assertThrows(AssertionError.class, () -> intDsaList.remove(3));

        intDsaList.remove(2);
        Assertions.assertThrows(AssertionError.class, () -> intDsaList.get(2));

        intDsaList.add(1," ");
        assert intDsaList.get(1) == " ";
        intDsaList.remove(0);
        assert intDsaList.get(0) == " ";

    }
}
