import java.util.ArrayList;
import java.util.Arrays;

public class CustomAL {

    private int[] data;
    private static int DEFAULT_SIZE = 10;
    private int size = 0;

    public CustomAL() {
        this.data = new int[DEFAULT_SIZE];
    }

    public void add(int num) {
        if (isFull()) {
            resize();
        }
        data[size++] = num;
    }

    private void resize() {
        int[] temp = new int[size * 2];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    private boolean isFull() {
        return size == data.length;
    }

    public int remove(){
        if (size == 0) {
            return 0;
        }
        int removed = data[--size];
        return removed;
    }

    public int get(int index){
        if (index > size) {
            return 0;
        }
        return data[index];
    }

    public int size(){
        return size;
    }
 
    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    public static void main(String[] args) {
        CustomAL arr = new CustomAL();
        arr.add(12);
        arr.add(23);
        arr.add(34);
        arr.remove();
        System.out.println(arr.get(123));
        System.out.println(arr);

        CustomGenericAL<Integer> list = new CustomGenericAL<>();
        list.add(21);
        System.out.println(list);
    }
}

class CustomGenericAL<T> {
    private Object[] data;
    private static int DEFAULT_SIZE = 10;
    private int size = 0;

    public CustomGenericAL() {
        this.data = new Object[DEFAULT_SIZE];
    }

    public void add(int num) {
        if (isFull()) {
            resize();
        }
        data[size++] = num;
    }

    private void resize() {
        Object[] temp = new Object[size * 2];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    private boolean isFull() {
        return size == data.length;
    }

    public T remove(){
        if (size == 0) {
            return null;
        }
        T removed = (T)data[--size];
        return removed;
    }

    public T get(int index){
        if (index > size) {
            return null;
        }
        return (T)data[index];
    }

    public int size(){
        return size;
    }
 
    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}
