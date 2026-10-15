
// importing Java AWT class  
import java.awt.*;
  
public class Interface {

    public static void main(String args[]) {
        Car car = new Car();
        car.acc();
        car.brek();
        car.start();
        car.stop();
        A.greet();
        Main obj = new Main();
        obj.fun();
    }
}

class Main implements B {
	@Override
	public void display() {
		
	}

	@Override
	public void show() {
		
	}
}
interface A{
    default void fun(){
        System.out.println("this is default method in interface");
    }
    static void greet(){
        System.out.println("this is static method in interface");
    }
    void display();
}
interface B extends A{
    void show();
}

class Car implements Engine, Break, Media {
    public void start() {
        System.out.println("Car started");
    }

    public void stop() {
        System.out.println("Car stopped");
    }

    public void acc() {
        System.out.println("Car accelerating");
    }

    public void brek() {
        System.out.println("Car braking");
    }
}

interface Engine {
    void start();
    void stop();
    void acc();
}

interface Break {
    void brek();
}

interface Media {
    void start();
    void stop();

}




// extending Frame class to our class AWTExample1
class InterfaceFrame extends Frame {
    // initializing using constructor
    void Interface() {

        // creating a button
        Button b = new Button("Click Me!!");

        // setting button position on screen
        b.setBounds(30, 100, 80, 30);

        // adding button into frame
        add(b);

        // frame size 300 width and 300 height
        setSize(300, 300);

        // setting the title of Frame
        setTitle("This is our basic AWT example");

        // no layout manager
        setLayout(null);

        // now frame will be visible, by default it is not visible
        setVisible(true);
    }
}
