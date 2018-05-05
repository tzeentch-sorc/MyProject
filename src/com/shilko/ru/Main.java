package com.shilko.ru;

import java.io.*;
import java.util.*;

import javafx.util.Pair;

import java.sql.*;
import java.util.concurrent.Executor;

class Binary {
    public static String binary(int n, int size) {
        StringBuilder s = new StringBuilder();
        while (size > 0) {
            s.append(" ");
            s.append(n % 2);
            n /= 2;
            --size;
        }
        return s.reverse().toString();
    }
}

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new FileReader("Словарь.txt"));
             PrintWriter out = new PrintWriter(new FileWriter("ОСОБЕННОСТИ_РАС.txt"));) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < 125000; ++i)
                list.add(in.nextLine());
            out.println("INSERT INTO ОСОБЕННОСТИ_РАС(НАЗВАНИЕ_ОСОБЕННОСТИ,ОПИСАНИЕ ОСОБЕННОСТИ) VALUES");
            for (int i = 0; i < 250000; ++i) {
                Random random = new Random();
                String name = list.get(random.nextInt(125000)) + " " + list.get(random.nextInt(125000));
                String describing = list.get(random.nextInt(125000)) + " " + list.get(random.nextInt(125000)) + " " + list.get(random.nextInt(125000)) + " " + list.get(random.nextInt(125000)) + " " + list.get(random.nextInt(125000));
                out.println("\t('"+name+"','"+describing+"'),");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
