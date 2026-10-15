public class Abstract {
    public static void main(String[] args) {
        // Parent mon = new Parent() {};        // cannot create object of abstract class because abstract menthods are not initialized 

        Son rahul = new Son();
        rahul.carrer("doctor");
        rahul.display();

        Daughter.show();
        Parent.show();;
    }
}

abstract class Parent {
    int age;
    final int VALUE = 000;
    static float data;

    abstract void carrer(String name);
    Parent(){}

    // abstract Parent(){}          // abstract constructer not allowed

    Parent(int age){
        this.age = age;
    }

    void display(){
        System.out.println("this is normal method in abstract class");
    }

    static void show(){
        System.out.println("this is static method in abstract class");
    }
}

class Son extends Parent{
    Son(){}
    Son(int age){
        super(age);
    }
    void carrer(String name){
        System.out.println("I want to be a " + name);
    }
}

class Daughter extends Parent{
    Daughter(){}
    Daughter(int age){
        super(age);
    }
    void carrer(String name){
        System.out.println("I want to be a " + name);
    }
}