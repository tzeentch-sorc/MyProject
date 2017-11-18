package com.shilko.ru;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < size; ++i)
            a.add(in.nextInt());
    }
}
        /*List<B> l = new ArrayList<>();
        fsuper(l);
        fextends(l);
        System.out.print(i);
        l.stream().forEach(System.out::print);
    }
    static void fsuper(List<? super B> a) {
        a.add(new C());
        //a.get(1).f();
        B b = (B)a.get(0);
        b.f();
    }
    static void fextends(List<? extends B> a) {
        //a.add(new A());
        ArrayList ar = new ArrayList();
        ar.add(new B());
        a.addAll(ar);
        a.get(0).f();
    }
}

class A{ public String toString() {return "A";} public void f(){System.out.print("a");};}
class B extends A{ public String toString() {return "B";} public void f(){System.out.print("b");};}
class C extends B{ public String toString() {return "C";} public void f(){System.out.print("c");};}*/