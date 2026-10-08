// package OOPs;

public class Class_Object {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.marks = 90.6f;
        student1.rno = 10;
        student1.name = "venom";

        System.out.println(student1.marks);
    }
}

class Student {
    int rno;
    String name;
    float marks;
}
