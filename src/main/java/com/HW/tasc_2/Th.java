package com.HW.tasc_2;

public class Th extends Thread {


    public Th(int start, int size) {
        Start = start;
        Size = size;
    }

    private final int Start;

    public int getStart() {
        return Start;
    }

    private final int Size;

    public int getSize() {
        return Size;
    }


    public double plasSinCos(int[] integ) {

        double d = 0.0;
        for (int i : integ) {

            //d += i;
            d += Math.cos(((double) i))+ Math.sin(((double)i) );
        }

        return d;
    }


    //----------------------------------------

    public int[] bild(int size, int star) {

        int[] r = new int[size];
        for (int i = 0; i < r.length; i++) {
            r[i] = star + i;

        }
        return r;
    }
}
