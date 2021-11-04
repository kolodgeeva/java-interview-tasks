package com.mariana;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UniqueHashtags {

  /*
  EPAM public interview Sr Java Developer
  https://www.youtube.com/watch?v=160QH3Gi56Y

  Implement a method, which returns the list of unique hashtags used in these messages.
  Result hashtags should be sorted by usage frequency

  List<String> twits = new ArrayList<>();
  twits.add("#Java and #Scala are the languages of cognitive and AI development. IBM sees cognitive development is the future.");
  twits.add("Some more info on the IBM investment in #Scala and ligthband");
  twits.add("IBM and @ligthband are building an integrated platform for #Java and #Scala #cognitive #cognitive app development");

  Result: ["Scala", "Java", "cognitive"]
 */
  public static void main(String[] args) {

    List<String> twits = new ArrayList<>();
    twits.add("#Java and #Scala are the languages of cognitive and AI development. IBM sees cognitive development is the future.");
    twits.add("Some more info on the IBM investment in #Scala and ligthband");
    twits.add("IBM and @ligthband are building an integrated platform for #Java and #Scala #cognitive #cognitive app development");

    System.out.println(getHashtags(twits));

  }

  public static List<String> getHashtags(List<String> twits) {

    return twits.stream()
        .flatMap(twit -> Arrays.stream(twit.split(" ")))
        .filter(word -> word.startsWith("#"))
        .map(hashtag -> hashtag.replace("#", ""))
        .collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()))
        .entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());

  }
}
