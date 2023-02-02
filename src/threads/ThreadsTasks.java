package threads;

import java.util.ArrayList;

public class ThreadsTasks implements Runnable {
    private int numbers;

    public ThreadsTasks() {
        this.numbers = 0;
    }

    ArrayList<Integer> evenNumbers = new ArrayList<>();
    ArrayList<Integer> oddNumbers = new ArrayList<>();
    @Override
    public void run() {
        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/

        for (int i=numbers; i<=numbers+2500; i++) {
              if(i%2==0) {
                  evenNumbers.add(i);
              } else {
                  oddNumbers.add(i);
              }
          }

          this.numbers += 2500;

    }

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }
}
