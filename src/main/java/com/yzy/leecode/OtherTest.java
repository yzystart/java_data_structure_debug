package com.yzy.leecode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class OtherTest {


    public int reverseBits(int n) {

        /**
         * 101010 -> 010101
         *
         * 000000
         * 000000
         * 000001
         *
         */
        int r =0;
        for (int i = 0; i < 32; i++) {
            r <<=1;
            r |= n & 1; // r与n最低位做或运算
            n >>= 1;
        }
        return r;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res =new ArrayList<>();
        List<Integer> row =new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            row.add(0,1);
            for (int j = 1; j < row.size()-1; j++) {
                row.set(j,row.get(j)+row.get(j+1));
            }

            res.add(new ArrayList<>(row));
        }
        return res;
    }


    @Test
    public void testgenerate(){
        System.out.println(generate(5));
    }

    public List<Integer> get(int n){
        return n==0?null:get(n-1);
    }



    @Test
    public void testreverseBits(){
        System.out.println(reverseBits(2));
    }



    @Test
    public void testhammingDistance(){
        System.out.println(hammingDistance(1, 3));
    }


    public int hammingDistance(int x, int y) {
        int j = x ^ y;
        int c =0;
        for (int i = 0; i < 32; i++) {
            if (((j>>>i)& 1)==1){
                c++;
            }
        }
        return c;
    }



}
