import java.util.Arrays;

public class ObjectCloning {
    public static void main(String[] args) throws CloneNotSupportedException {
        Human kunal = new Human(12, "kunal");
        Human twin = new Human(kunal);                  // High processing time due to new keyword
        Human clone = (Human) kunal.clone();

        System.out.println(twin.age + " " + twin.name);
        System.out.println(clone.age + " " + clone.name);

        clone.arr[0] = 100;
        
        System.out.println(Arrays.toString(clone.arr));
        System.out.println(Arrays.toString(kunal.arr));
    }
}

class Human implements Cloneable {
    int age;
    String name;
    int[] arr;

    Human(int age, String name) {
        this.age = age;
        this.name = name;
        this.arr = new int[]{2,3,4,5,1};
    }

    Human(Human other) {
        this.age = other.age;
        this.name = other.name;
    }

    // public Object clone() throws CloneNotSupportedException {
    //     // this is shallow copy of an object
    //     return super.clone();
    // }

    public Object clone() throws CloneNotSupportedException {
        // this is deep copy of an object
        Human twin = (Human)super.clone();

        twin.arr = new int[twin.arr.length];
        for (int i = 0; i < twin.arr.length; i++) {
            twin.arr[i] = this.arr[i];
        }
        return twin;
    }

}
