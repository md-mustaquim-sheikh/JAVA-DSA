public class Threading{

    public static void main(String[] args) throws InterruptedException{
        A obj = new A();
        obj.start();

        for (int i = 0; i < 5; i++) {

            System.out.println("Main class is running..");
            Thread.sleep(1000);
        }

    }
}

class A extends Thread{

    @Override
    public void run() {

       try{

           for (int i = 0; i < 5; i++) {
               
               System.out.println("Thread is running...");
               Thread.sleep(1000);
            }
        }
        catch(InterruptedException e){
            System.out.println("Exception :"+ e);
        }
    }
}
