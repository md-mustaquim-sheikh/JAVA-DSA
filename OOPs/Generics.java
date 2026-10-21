public class Generics implements GenericsInterface<Integer>{
    public static void main(String[] args) {
        Generics obj = new Generics();
        obj.display(23);
        // obj.display("marks");    
        // obj.display(43.69f);
    }

    @Override
    public void display(Integer value) {
        System.out.println(value);
    }
}


interface GenericsInterface<T> {
    void display(T value);  
}