package com.shilko.ru;

import java.util.*;
import java.util.stream.Collectors;

/*ввод в виде   3
                A B C
                B C D
                E D F
 */
public class Main {
    static void mul(List<List<String>> l) {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < l.get(0).size(); ++i)
            for (int j = 0; j < l.get(1).size(); ++j) {
                String s = l.get(0).get(i) + l.get(1).get(j);
                temp.add(s);
            }
        l.remove(0);
        l.remove(0);
        l.add(temp);
    }
    static boolean find(String a, String b) { //находит в а b
        if (a.length() < b.length())
            return false;
        for (int i = 0; i < b.length(); ++i)
            if (!a.contains(new String(new char[]{b.charAt(i)})))
                return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("/*ввод в виде   \n\t3"
                +"\n\tA B C"
                +"\n\tB C D"
                +"\n\tE D F"
 +"\n*/");
        System.out.print("Введите количество покрываемых вершин: ");
        int numberOfPik = in.nextInt();
        in.nextLine();
        List<List<String>> a = new ArrayList<>(numberOfPik);
        for (int i = 0; i < numberOfPik; ++i) {
            System.out.print("Введите кубы для "+i+"ой вершины: ");
            String s = in.nextLine();
            List<String> l = new ArrayList<>();
            for (int j = 0; j < s.length(); ++j)
                if (Character.toUpperCase(s.charAt(j)) != ' ')
                l.add(new String(new char[]{Character.toUpperCase(s.charAt(j))}));
            a.add(l);
        }
        System.out.println("Bведите пары букв и их Sa, а программа найдет минимальные покрытия");
        System.out.println("Для конца ввода введите $\nФормат ввода: Буква цена Sa\n Q 4\n e 2\n$\nВвод:");
        Map<Character,Integer> m = new HashMap<>();
        char c = 'p';
        while (c != '$') {
            c = in.next().charAt(0);
            if (c == '$')
                break;
            int n = in.nextInt();
            m.put(Character.toUpperCase(c),n);
        }
        while (a.size()>1) {
            mul(a);
        }
        List<String> r = new ArrayList<>(a.get(0));
        for (int i = 0; i < r.size(); ++i) {
            List<Character> list = new ArrayList<>();
            for (int j = 0; j < r.get(i).length(); ++j) {
                list.add(r.get(i).charAt(j));
                Collections.sort(list);
                for (int k = 0; k < list.size()-1; ++k)
                    if (list.get(k) == list.get(k + 1)) {
                        list.remove(k);
                        k--;
                    }
            }
            StringBuilder s = new StringBuilder();
            for (Character w: list)
                s.append(w);
            r.set(i,s.toString());
        }
        Collections.sort(r);
        //List<Integer> q = new ArrayList<>();
        for (int k = 0; k < r.size()-1; ++k)
            if (r.get(k).equals(r.get(k + 1))) {
                r.remove(k);
                k--;
            }
            boolean b = false;
        while (!b) {
            b = true;
            for (int i = 0; i < r.size(); ++i)
                for (int j = 0; j < r.size(); ++j)
                    if (i != j && find(r.get(i), r.get(j))) {
                        //q.add(i);
                        r.remove(i);
                        b = false;
                        break;
                    }
        }
                /*else if (i != j && find(r.get(j),r.get(i)))
                    q.add(j);*/
        /*Collections.sort(q);
        for (int k = 0; k < q.size()-1; ++k)
            if (q.get(k) == q.get(k + 1)) {
                q.remove(k);
                k--;
            }
        for (int i = q.size()-1; i >= 0; --i)
            r.remove(q.get(i)+0);*/
        /*int min = r.get(0).length();
        for (int i = 1; i < r.size(); ++i) {
            if (r.get(i).length() < min)
                min = r.get(i).length();
        }
        final int emin = min;
        r = r.stream().filter(s->s.length()==emin).collect(Collectors.toList());*/
        Map<String,Integer> result = new HashMap<>();
        for (int i = 0; i < r.size(); ++i) {
            int sum = r.get(i).length();
            for (int j = 0; j < r.get(i).length(); ++j)
                sum += m.get(r.get(i).charAt(j));
            result.put(r.get(i),sum);
        }
        int min = Integer.MAX_VALUE;
        for (String s: result.keySet()) {
            if (result.get(s) < min)
                min = result.get(s);
        }
        final int fmin = min;
        System.out.println("Найдено "+result.size()+" покрытий");
        result.keySet().stream().forEach(n->System.out.println(n+" Sa = "+(result.get(n)-n.length())+" Sb = "+result.get(n)));
        System.out.println("\nНайдено "+result.keySet().stream().filter(n->result.get(n)==fmin).count()+" минимальных покрытий");
        result.keySet().stream().filter(n->result.get(n)==fmin).forEach(n->System.out.println(n+" Sa = "+(result.get(n)-n.length())+" Sb = "+result.get(n)));
    }
}