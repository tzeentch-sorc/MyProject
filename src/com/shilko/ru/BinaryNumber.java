package com.shilko.ru;

import static java.lang.Math.*;

public class BinaryNumber {
    private int n;
    private int size;
    public BinaryNumber(int n,int size) {
        this.n = n;
        this.size = size;
    }
    public int get() {
        return n;
    }
    public int getSize() {
        return size;
    }
    public BinaryNumber sum(BinaryNumber b) {
        return new BinaryNumber(n+b.get(),size);
    }
    public BinaryNumber ror(int n) {
        return new BinaryNumber(this.n/(int)(pow(2,n)),size);
    }
    public  BinaryNumber rol(int n) {
        return new BinaryNumber(this.n*(int)(pow(2,n)),size);
    }
    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        int n = Math.abs(this.n);
        for (int i = 1; i < size; ++i) {
            s.append(n % 2);
            n /= 2;
            if (i % 4 == 0)
                s.append("'");
        }
        s.append(".");
        s.append(n >= 0 ? 0 : 1);
        s = s.reverse();
        if (this.n<0) {
            boolean b = false;
            for (int i = s.length()-1; i >= 0; --i) {
                if (b) {
                    if (s.charAt(i)=='1')
                        s.setCharAt(i,'0');
                    else if (s.charAt(i)=='0')
                        s.setCharAt(i,'1');
                }
                if (s.charAt(i)=='1') {
                    b = true;
                }
            }
        }
        return s.toString();
    }
}
