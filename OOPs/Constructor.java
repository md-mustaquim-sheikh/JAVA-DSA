

public class Constructor {

    public static void main(String[] args) {
        System.out.println("Main method started");
        // Creating objects using different constructors   
        Student s1 = new Student();
        Student s2 = new Student("Alice", 101);
        Student s3 = new Student(s2);
        System.out.println("Student 1: " + s1.name + ", Roll No: " + s1.rollno);
        System.out.println("Student 2: " + s2.name + ", Roll No: " + s2.rollno);
        s3.display();
        System.out.println("Total students created: " + Student.count);

        final Student newStudent = new Student();
        newStudent.name = "mustaquim";                          // This is Allowed bcoz you are changing value of non primitive type
        newStudent = new Student("akash", 24);     // This is not Allowed bcoz you cant reassign it again
    }
}

class Student {
    String name;
    int rollno;
    static int count = 0;

    static {
        System.out.println("Static block executed");
    }
     
    // Default constructor
    Student() {
        name = "Unknown";
        rollno = 0;
        count++;
    } 
    Student(String name) {
        this.name = name;
        rollno = 0;
        count++;
    }

    //  Parameterized constructor
    Student(String name, int rollno) {
        this.name = name;
        this.rollno = rollno;
        count++;
    }

    // Copy constructor
    Student(Student s){
        this.name = s.name;
        this.rollno = s.rollno;
        count++;
    }

    // Call Another constructor
    // Student() {
    //     this ("unknown",0);
    // }

    // Method to display Student information
    public void display() {
        System.out.println(this.name + " " + this.rollno);
    }
    
}