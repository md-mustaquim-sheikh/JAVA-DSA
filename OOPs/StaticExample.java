// package OOPs;
// import OOPs.InnerStaticExample.Test;

public class StaticExample {
    public static void main(String[] args) {
        // Test a = new Test("venom");
        // Test b = new Test("kunal");
        SingleTon demo = SingleTon.singletonInstance();
        System.out.println(demo);
        SingleTon demo2 = SingleTon.singletonInstance();
        System.out.println(demo2);
    }

}

class InnerStaticExample { // Outisde class cannot be static while inside class will be static

    static class Test {
        String name;

        Test(String name) {
            this.name = name;
        }
    }

}

class Rule1 {
    // Inside static method we dont use non static method

    void greeting() {
        System.out.println("Hello World");
    }

    static void fun() {
        // greeting();         // Cant use it, because it requires instance
    }
}

class Rule2 {
    // Inside non static method we can use static method

    void greeting() {
        fun();          // Can use it
    }

    static void fun() {
        Rule2 obj = new Rule2();    // by creating instance we can access it
        obj.greeting();
    }
}

class Staticblock {
    static int a = 4;
    static int b;

    static {
        System.out.println("Run once, when first object is created");
        b = a*4;
    }

}

class SingleTon {                   // Only one object of the class will be created
    private SingleTon(){}           // Private canstroctor
    static SingleTon instance;

    public static SingleTon singletonInstance() {
        if (instance == null) {
            instance = new SingleTon();
        }
        return instance;
    }
}