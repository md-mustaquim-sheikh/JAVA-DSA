// package OOPs;
public class Inheritance {

    public static void main(String[] args){
        BoxWeight bw = new BoxWeight(1,2,3,4);
        System.out.println(bw.weight);
        bw.display();

        // Box box1 = new BoxWeight();
        // System.out.println(box1.wight);      // Not able to access bcoz box class have no idea about weight
        // BoxWeight box2 = new Box(2);         // Not Allowed bcoz weight variable not initialized
    }
}

// Simple Inheritance concept
class Box {
    double h;
    double w;
    double l;
    Box(){
        this.h = -1;
        this.w = -1;
        this.l = -1;
    }

    Box(double h, double w, double l){
        this.h = h;
        this.w = w;
        this.l = l;
    }

    Box(double side){
        this.h = side;
        this.w = side;
        this.l = side;
    }

    void message(){
        System.out.println(this.h + " " + this.l + " " + this.w);
    }
}
class BoxWeight extends Box{
    double weight;

    BoxWeight(){
        this.weight = -1;
    }

    BoxWeight(double h, double w, double l, double weight){                              // Uses of Super Keyword in Inheritance
        super(h,w,l);                                                                    // 1. Use to acess the parent class constructor
        this.weight = weight;
    }

    void display(){
        System.out.println(super.h +" "+ super.l +" "+ super.w +" "+ this.weight);      // 2. Use to access parent class variable
        super.message();                                                                // 3. Use to access parent class method 
    }

}

class A{
    public void display(){
        System.out.println("This is class A");
    }
}
class B extends A{
    public void show(){
        System.out.println("This is class B");
    } 
}

class C extends B{
    public void print(){
        System.out.println("This is class C");
        super.display();
        super.show();
    }
}