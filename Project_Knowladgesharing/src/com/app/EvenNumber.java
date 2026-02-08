package com.app;

import java.util.Arrays;
import java.util.List;

public class EvenNumber{
    public static void main(String args[]) {
      List<Integer> list = Arrays.asList(10,15,8,49,25,98,32);
      list.stream().filter(n -> n%2 == 0).forEach(System.out::println);
        }
    }

