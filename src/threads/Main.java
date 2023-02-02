package threads;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadsTasks taks = new ThreadsTasks();

        Thread t1 = new Thread(taks);
        t1.start();
        t1.join();

        Thread t2 = new Thread(taks);
        t2.start();
        t2.join();

        Thread t3 = new Thread(taks);
        t3.start();
        t3.join();

        Thread t4 = new Thread(taks);
        t4.start();
        t4.join();

        for(Integer evenNumber : taks.evenNumbers) {
            System.out.print(evenNumber + " ");
        }

        System.out.print("\n");

        for(Integer oddNumber : taks.oddNumbers) {
            System.out.print(oddNumber + " ");
        }
    }
}
