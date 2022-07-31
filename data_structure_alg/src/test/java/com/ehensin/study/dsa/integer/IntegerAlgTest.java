package com.ehensin.study.dsa.integer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Objects;

public class IntegerAlgTest {
    @Test
    public void testDivide(){
        assert IntegerAlg.divide(15,2) == 7;
        assert IntegerAlg.divide(15,-2) == -7;
        assert IntegerAlg.divide(-15,2) == -7;
        assert IntegerAlg.divide(-15,-2) == 7;
        assert IntegerAlg.divide(Integer.MIN_VALUE,-1) == Integer.MAX_VALUE;
        assert IntegerAlg.divide(Integer.MIN_VALUE,1) == Integer.MIN_VALUE;

    }
    @Test
    public void testBinaryStrAdd(){
        assert Objects.equals(IntegerAlg.binaryStrAdd("1","1") , "10");
        assert Objects.equals(IntegerAlg.binaryStrAdd("10","110") , "1000");
    }

    @Test
    public void testCalculateBitOne(){
        assert Arrays.equals(IntegerAlg.calBitOne(1), new int[]{0,1});
        assert Arrays.equals(IntegerAlg.calBitOne(4), new int[]{0,1,1,2,1});
        assert Arrays.equals(IntegerAlg.calBitOne(7), new int[]{0,1,1,2,1,2,2,3});
    }

    @Test
    public void testFindOnlyOneNum(){
        assert IntegerAlg.findOnlyOneNum(new int[]{0,0,0,1}) == 1;
        assert IntegerAlg.findOnlyOneNum(new int[]{0,1,1,1}) == 0;
        assert IntegerAlg.findOnlyOneNum(new int[]{0,1,0,1,1,0,100}) == 100;
    }
}
