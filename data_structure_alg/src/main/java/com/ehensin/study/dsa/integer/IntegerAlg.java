package com.ehensin.study.dsa.integer;

public class IntegerAlg {
    /*
    题目：输入2个int型整数，它们进行除法计算并返回商，要求不得使用乘号'*'、除号'/'及求余符号'%'。当发生溢出时，返回最
    大的整数值。假设除数不为0。例如，输入15和2，输出15/2的结果，即7。
    n1/n2
    * */
    static int divide(int n1, int n2){
        assert n2 != 0;
        /*避免溢出*/
        if( n1 == Integer.MIN_VALUE && n2 == -1 ){
            return  Integer.MAX_VALUE;
        }
        if( n1 == Integer.MIN_VALUE && n2 == 1 ){
            return  Integer.MIN_VALUE;
        }
        /*负数处理，负数要转化成正数来处理*/
        int negative = 2;
        if( n1 < 0 ){
            n1 = -n1;
            negative--;
        }
        if( n2 < 0 ){
            n2 = -n2;
            negative--;
        }
        int result = 0;
        while(n1 > n2){
            /*计数器，用来记录指数*/
            int count = 1;
            int value = n2;
            while( value < Integer.MAX_VALUE / 2 && n1 > value + value  ){
                count += count;
                value += value;
            }
            n1 -= value;
            result += count;
        }
        return negative == 1 ? -result : result;
    }


    /*
    题目：输入两个表示二进制的字符串，请计算它们的和，并以
         二进制字符串的形式输出。例如，输入的二进制字符串分别
         是"11"和"10"，则输出"101"。
    * */
    public static String binaryStrAdd(String s1, String s2) {
       int i = s1.length() -1;
       int j = s2.length() - 1;
       StringBuilder sb = new StringBuilder();
       int carray = 0;
       while(i >= 0 || j >= 0){
           int b1 = i >= 0 ? s1.charAt(i--) - '0' : 0;
           int b2 = j >= 0 ? s2.charAt(j--) - '0' : 0;
           int sum = b1 + b2 + carray;
           carray = sum >= 2 ? 1 : 0;
           sum = sum >= 2 ? sum - 2: sum;
           sb.append(sum);
       }
       if( carray == 1 )
           sb.append(1);
       return sb.reverse().toString();
    }


    /*题目：输入一个非负数n，请计算0到n之间每个数字的二进制形
式中1的个数，并输出一个数组。例如，输入的n为4，由于0、1、
2、3、4的二进制形式中1的个数分别为0、1、1、2、1，因此输出数
组[0，1，1，2，1]。*/
    public static int[] calBitOne(int n) {
        assert n > 0;
        int[] result = new int[n + 1];
        /*for( int i = 1; i < n + 1 ; i++ ){
            *//*计算每个数字的二进制数里1的个数,通过循环除以2 看余数*//*
            int count = 0;
            int tmp = i;
            while( tmp > 0 ) {
                if (tmp % 2 != 0) {
                    count++;
                }
                tmp = tmp / 2;
            }
            result[i] = count;
        }*/
        /*more efficient alg */
        /*for( int i = 1; i < n + 1 ; i++ ){
            int tmp = i;
            while ( tmp != 0 ){
                result[i]++;
                tmp = tmp & tmp - 1;
            }
        }*/
        /*most efficient alg, i 1的个数是 i & i-1 个数 +1 */
        /*for( int i = 1; i < n + 1 ; i++ ){
            result[i] = result[ i & i -1] + 1;
        }*/
        /*i的1个数是i/2的1个数 + 1（i为奇数） 或 0（i为偶数）
        * i >> 1 == i/2 , i & 1 == i % 2*/
        for( int i = 1; i < n + 1 ; i++ ){
            result[i] = result[ i>>1] + (i & 1);
        }
        return result;
    }
    /*题目：输入一个整数数组，数组中只有一个数字出现了一次，
而其他数字都出现了3次。请找出那个只出现一次的数字。例如，如
果输入的数组为[0，1，0，1，0，1，100]，则只出现一次的数字是
100。*/
    public static int findOnlyOneNum(int[] ints) {
        int result = 0;
        /*low efficient*/
        /*for(int i = 0; i < ints.length; i++){
            boolean isRepeat = false;
            for( int j = 0; j < ints.length; j++){
                if( i != j){
                    if(ints[i] == ints[j]){
                        isRepeat = true;
                        break;
                    }
                }
            }
            if( !isRepeat ){
                result = ints[i];
                break;
            }
        }*/
        /*high efficient, 所有数的第i位进行3次加和，如果是出现三次的数字，
        则可得出该位累加三次后必能被3整除，而只出现一次的数字，该位累加后如果能被3整除，则该位
        一定是0 否则就是1*/
        /*integer is 32 bit in java*/
        int[] bitSums = new int[32];
        for(int i = 0 ; i < ints.length; i++ ){
            for( int j = 0 ; j < 32; j++ ){
                bitSums[j] += (ints[i] >> (31 - j)) & 1;
            }
        }
        for( int j = 0 ; j < 32; j++ ){
            result = (result << 1)  + bitSums[j] % 3;
        }

        return result;
    }
}
