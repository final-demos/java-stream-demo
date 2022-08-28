package com.github.hubertwo.kata.stream.basics;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.hubertwo.kata.stream.Fruit;
import com.github.hubertwo.kata.stream.FruitManager;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@SuppressWarnings("SimplifyStreamApiCallChains")
@DisplayName("Stream basics")
class BasicsTest {

  private static final Fruit BANANA = new Fruit("Banana", 105);
  private static final Fruit PAPAYA = new Fruit("Papaya", 109);
  private static final Fruit KIWI = new Fruit("Kiwi", 46);
  private static final Fruit MANGO = new Fruit("Mango", 107);
  private static final Fruit PEACH = new Fruit("Peach", 48);

  private static final Set<Fruit> FRUITS = Set.of(
    PAPAYA,
    BANANA,
    KIWI,
    MANGO,
    PEACH
  );

  @Test
  @DisplayName("Task: Find 2 fruits with biggest amount of calories")
  void task1() {
    List<Fruit> mostCaloricFruits = FruitManager.task1(FRUITS);

    assertThat(mostCaloricFruits).containsExactly(PAPAYA, MANGO);
  }

  @Test
  @DisplayName(
    "Task: Take half of each fruit calories and get the sum of calories"
  )
  void task2() {
    final int sumOfCalories = FruitManager.task2(FRUITS);

    assertThat(sumOfCalories).isEqualTo(206);
  }

  @Test
  @DisplayName("Task: Group fruits by first letter")
  void task3() {
    final Map<Character, Set<Fruit>> mapOfFruits = FruitManager.task3(FRUITS);

    assertThat(mapOfFruits.keySet()).contains('B', 'K', 'M', 'P');
    assertThat(mapOfFruits.get('B')).hasSize(1);
    assertThat(mapOfFruits.get('K')).hasSize(1);
    assertThat(mapOfFruits.get('M')).hasSize(1);
    assertThat(mapOfFruits.get('P')).hasSize(2);
  }

  @Test
  @DisplayName("Task: Put all fruits into one basket")
  void task4() {
    final List<List<Fruit>> fruitBaskets = List.of(
      List.of(BANANA, PAPAYA),
      List.of(MANGO, PEACH)
    );

    final List<Fruit> basketWithAllFruits = FruitManager.task4(fruitBaskets);

    assertThat(basketWithAllFruits).contains(BANANA, PAPAYA, MANGO, PEACH);
    assertThat(basketWithAllFruits).doesNotContain(KIWI);
  }
}
