package org.rapidpm.frp.v006;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    Optional<Integer> apply = service().doWork("1");

    if (apply.isPresent()) {
      //do something usefull
      final Integer intA = apply.get();

    }
    else {
      //do something ???
    }

    final Integer intB1 = apply.orElseGet(() -> - 1);
    final Integer intB2 = apply.orElse(- 1);
    final Integer intB3 = apply.orElseThrow(() -> new RuntimeException("panic ;-)"));

    apply.ifPresent(v -> {
      System.out.println("v = " + v);
    });

    //since 9
    apply.ifPresentOrElse(v -> {
      System.out.println("v = " + v);
    } , () -> {
      System.out.println("value not present");
    });

    apply.or(() -> Optional.of(Integer.MAX_VALUE));

    final Stream<Integer> stream = apply.stream();




  }
}
