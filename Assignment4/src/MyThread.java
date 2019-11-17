public class MyThread implements Runnable {

    public void run(){
        try{
            System.out.println ("Thread " +
                    Thread.currentThread().getId() +
                    " is running (mythread method)");
        }
        catch (Exception e)
        {
            // Throwing an exception
            System.out.println ("Exception is caught");
        }
    }
}
