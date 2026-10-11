public class polymorphism {
    public static void main(String[] args) {
        System.out.println(sum(1.0, 2));
        System.out.println(sum(1, 2, 3.5));

        Shapes shapes = new Shapes();
        Circle circle = new Circle();
        Square square = new Square();
        Shapes obj = new Circle();

        shapes.display();
        circle.display();
        square.display();
        obj.display();
    }
    
    // Type 1 - Compile time / Static Polymorphism (Method Overloading)
    static int sum(int a, int b) {
        return a + b;
    }
    static double sum(double a, double b) {
        return a + b;
    }
    static int sum(int a, int b, int c) {
        return a + b + c;
    }
    static double sum(int a, int b, double c) {
        return a + b + c;
    }
    static void fun(int a) {
        System.out.println(a);
    }
    static void fun(String a) {
        System.out.println(a);
    }
}

// Type 2 - Run time / Dynamic Polymorphism (Method Overloading)
class Shapes {
    void display(){                                     // Late Binding because compiler is not free here
        System.out.println("this is shape class");
    }

    final void display1(){                              // Early Binding because compiler free here but this method can't be overriden
        System.out.println("this is shape class");
    }

    static void display2() {                            // static method cannot be overriden because overriden stuff depends upon the object but static doesnot depend upon the object
        System.out.println("this is shape class");
    }
}
class Circle extends Shapes {
    @Override 
    void display(){
        System.out.println("this is circle class");
    }
}
class Square extends Shapes {
    @Override
    void display(){
        System.out.println("this is square class");
    }
}
