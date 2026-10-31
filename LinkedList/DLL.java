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
        size += 1;
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
