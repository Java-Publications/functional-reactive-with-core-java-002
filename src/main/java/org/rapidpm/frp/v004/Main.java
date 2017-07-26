package org.rapidpm.frp.v004;

import java.util.Optional;
import java.util.function.Function;

/**
 *
 */
public class Main {

  @FunctionalInterface
  public static interface Service {
    public Optional<Integer> doWork(String value);
  }


  static Function<String, Optional<Integer>> service() {
    return (value) -> {
      try {
        return Optional.of(Integer.valueOf(value));
      } catch (NumberFormatException e) {
        e.printStackTrace();
      }
      return Optional.empty();
    };
  }

  public static void main(String[] args) {

    Optional<Integer> apply = service().apply("1");

  }

}
