package 多线程.小练习;

public class 轮流打印123 {
    private int currentNumber = 1;
    private int maxNumber = 3;

    public static void main(String[] args) {
        轮流打印123 printing = new 轮流打印123();

        Thread t1 = new Thread(() -> printing.printNumber(1));
        Thread t2 = new Thread(() -> printing.printNumber(2));
        Thread t3 = new Thread(() -> printing.printNumber(3));

        t1.start();
        t2.start();
        t3.start();
    }

    private synchronized void printNumber(int targetNumber) {
        for (int i = 0; i < 10; i++) {
            while (currentNumber != targetNumber) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Thread " + targetNumber + " printing: " + targetNumber);
            currentNumber = currentNumber % maxNumber + 1;
            notifyAll();
        }
    }
}
