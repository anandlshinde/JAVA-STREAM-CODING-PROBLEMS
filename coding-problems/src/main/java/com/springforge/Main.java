package com.springforge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //01:: Given a sentence find the word that has the highest length.

        String str="I am learning java stream in java";

        String ans=Arrays.stream(str.split(" ")).max(Comparator.comparing(String::length))
                .get();

        System.out.println(ans);


        //02:: Remove duplicates from the string and return in same order.

        String duplicateStr="dabaafde";
        duplicateStr.chars().distinct().mapToObj(c -> (char)c).forEach(System.out::println);

        String removedDuplicates=Arrays.stream(duplicateStr.split("")).distinct()
                .collect(Collectors.joining());

        System.out.println(removedDuplicates);


        //03:: Find the word that has the second-highest length
        String secondHighestLengthWord=Arrays.stream(str.split(" ")).sorted(Comparator.comparing(String::length).reversed())
                .skip(1).findFirst().get();

        System.out.println(secondHighestLengthWord);


        //04:: Given a sentence, find the occurrence of each word.

        Map<String,Long> occurrence=Arrays.stream(str.split(" "))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        System.out.println(occurrence);

        //05:: Given a sentence, find the words with a specified number of vowels.

        Arrays.stream(str.split(" "))
                .filter(s -> s.replaceAll("[^aeiouAEIOU]","").length()==2)
                .forEach(System.out::println);


        //06:: Divide given integer list into of even and odd numbers.

        int [] num={1,2,3,4,7,6,8};

        List<Integer> numList = Arrays.stream(num).boxed().collect(Collectors.toList());

        List<List<Integer>> numResult = numList.stream()
                .collect(Collectors.groupingBy(x -> x % 2 == 0, Collectors.toList()))
                .entrySet().stream()
                .map(x -> x.getValue())
                .collect(Collectors.toList());

        System.out.println(numResult);

    }
}