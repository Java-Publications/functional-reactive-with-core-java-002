package org.rapidpm.frp.v005;

import java.util.Optional;
import java.util.function.Function;

/**
 *
 */
public class Main {

  @FunctionalInterface
  public static interface Service extends Function<String, Optional<Integer>> {
    public default Optional<Integer> doWork(String value) {
      return apply(value);
    }
  }

  static Service service() {
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

    Optional<Integer> applyA = service().apply("1");

    Optional<Integer> applyB = service().doWork("1");
  }
}
