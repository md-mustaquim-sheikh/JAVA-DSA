package LinkedList;

public class Main {
    public static void main(String[] args) {
        DLL list = new DLL();
        list.insertFirst(12);
        list.insertFirst(23);
        list.insertFirst(78);
        list.insertFirst(42);
        list.insertlast(99);
        list.insertlast(100);
        list.insert(33, 3);
        list.insertAfter(100, 89);
        list.insertAfter(42, 45);
        list.diplay();
        list.diplayReverse();
        
        System.out.println(list.getValue(124));
        
    }
}
