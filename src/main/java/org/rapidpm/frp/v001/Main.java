package org.rapidpm.frp.v001;

/**
 *
 */
public class Main {

  public interface DemoInterface {
    static void doMore() {
      System.out.println(DemoInterface.class.getSimpleName() + " : " + "doMore");
    }

    default void doSomething() {
      System.out.println(DemoInterface.class.getSimpleName() + " : " + "doSomething");
    }
  }

  public interface InterfaceA extends DemoInterface {
    default void doSomething() {
      System.out.println(InterfaceA.class.getSimpleName() + " : " + "doSomething");
    }
  }

  public interface InterfaceB  {
    default void doSomething() {
      System.out.println(InterfaceB.class.getSimpleName() + " : " + "doSomething");
    }
  }


  public static class ImplA implements DemoInterface, InterfaceA {}

  public static class ImplB implements DemoInterface, InterfaceB {

    @Override
    public void doSomething() {
      System.out.println(ImplB.class.getSimpleName() + " : " + "doSomething");
    }
  }


  public static void main(String[] args) {
    DemoInterface.doMore();
    new ImplA().doSomething();
//    ImplA.doMore(); //cannot find symbol "doMore()"
    new ImplB().doSomething();
  }

}
