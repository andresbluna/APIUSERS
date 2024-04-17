package com.api.apirestuser.controller;

import java.util.stream.Stream;

public class SampleTest {

    public static void main(String[] args) {

        int n = 10;

        System.out.println("Fibonacci Secuence for the first" + n + "numbers");

        Stream.iterate(new int[]{0,1}, f -> new int []{f[1], f[0] + f[1]})
                .limit(n)
                .map(f -> f[0])
                .forEach(System.out::println);

    }
}

