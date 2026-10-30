package LinkedList;

public class Main {
    public static void main(String[] args) {
        CustomLL list = new CustomLL();
        list.insertFirst(12);
        list.insertFirst(23);
        list.insertFirst(78);
        list.insertlast(99);
        list.insert(100, 10);
        list.diplay();
        System.out.println(list.deleteFirst());
        list.diplay();
        System.out.println(list.delete(4));
        list.diplay();
        System.out.println(list.getValue(3));
    }
}
