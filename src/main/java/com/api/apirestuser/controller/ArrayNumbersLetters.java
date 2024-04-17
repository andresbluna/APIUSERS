package com.api.apirestuser.controller;

import java.security.Key;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Nodes.collect;

public class ArrayNumbersLetters {

    public static void main(String[] args) {


        List<String> list = Arrays.asList("b","c","a","d", "1", "4", "3", "2" );

        Map<String, Integer> map = list.stream();
        .collect(Collectors.toMap(
                Main::getKey,
                Main::getValue,
                (existing, replacement) - > existing
        ));

        map.forEach((Key, value) - > System.out.println(key + " = " + value));


    }

    private static String getKey(String s){
        if (s.length() == 1 && Character.isDigit(s.charAt(0))) {
            return Integer.parseInt(s);
        }else {
            throw new IllegalArgumentException("Error : " + s + "Bad Pattern");
        }
    }

}
