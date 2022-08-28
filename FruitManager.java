package com.github.hubertwo.kata.stream;

import static java.util.stream.Collectors.toList;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FruitManager {

  public static List<Fruit> task1(Set<Fruit> fruits) {
    return fruits
      .stream()
      .sorted(Comparator.comparing(Fruit::getCalories).reversed())
      .limit(2)
      .collect(toList());
  }

  public static int task2(Set<Fruit> fruits) {
    return fruits
      .stream()
      .mapToInt((Fruit fruit) -> fruit.getCalories() / 2)
      .sum();
  }

  public static Map<Character, Set<Fruit>> task3(Set<Fruit> fruits) {
    // return Stream
    // .iterate(new long[]{1, 1}, (long[] results) -> new long[]{results[1], results[0] + results[1]})
    // .limit(sequenceIndex)
    // .reduce((a, b) -> b)
    // .orElse(new long[]{0, 0})[0];
    return fruits
      .stream()
      .collect(
        Collectors.groupingBy(
          (Fruit fruit) -> fruit.getName().charAt(0),
          Collectors.toSet()
        )
      );
  }

  public static List<Fruit> task4(List<List<Fruit>> fruitBaskets) {
    return fruitBaskets
      .stream()
      .flatMap(Collection::stream)
      .collect(Collectors.toList());
  }
}
