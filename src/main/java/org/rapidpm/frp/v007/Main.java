package org.rapidpm.frp.v007;


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

    String value = "";
    service()
        .doWork(value)
        .or(() -> Optional.of(0))  // per definition
        .map((Function<Integer, Function<Integer, String>>) integer -> (valueToAdd) -> integer + valueToAdd + " was calculated")
        .ifPresentOrElse(
            fkt -> System.out.println("f(10) ==> = " + fkt.apply(10)) ,
            () -> System.out.println("value not present (usless here)"));
  }
}
