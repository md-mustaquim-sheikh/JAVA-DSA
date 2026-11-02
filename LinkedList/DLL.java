package LinkedList;

public class DLL {

    private Node head;
    private Node tail;
    private int size;

    public DLL(){
        this.size = 0;
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;   
        if (tail == null) {
            tail = head;
        }
        size += 1;
    }

    public void insertlast(int val){
        if (tail == null) {
            insertFirst(val);
            return ;
        }

        Node node = new Node(val);
        tail.next = node;
        node.prev = tail;
        node.next = null;
        tail = node;
        size += 1;
    }

    public void insert(int val, int index){
        if (index == 0) {
            insertFirst(val);
            return ;
        }
        if (index >= size) {
            insertlast(val);
            return ;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(val, temp.next, temp);
        temp.next.prev = node;
        temp.next = node;
    }

    public void insertAfter(int after, int val){
        Node preNode = find(after);

        if (preNode == null) {
            System.out.println("Node not exist");
            return ;
        }
        if (preNode.next == null) {
            insertlast(val);
            return ;
        }
        
        Node node = new Node(val, preNode.next, preNode);  
        preNode.next.prev = node;
        preNode.next = node;
    }

    public void diplay(){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void diplayReverse(){
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.prev;
        }
        System.out.println("START");
    }

    public int getValue(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node node = get(index);
        return node.value;
    }

    private Node get(int index){
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private Node find(int value){
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    private class Node {
        
        private int value;
        private Node next;
        private Node prev;

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next, Node prev){
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
