package lesson_4_hw;

public class ABC {
    static final Object mon = new Object();
    private volatile char currentLetter = 'A';

    public static void main(String[] args) {
        ABC ABCobj = new ABC();
        Thread threadA = new Thread(ABCobj::printA);
        Thread threadB = new Thread(ABCobj::printB);
        Thread threadC = new Thread(ABCobj::printC);

        threadA.start();
        threadB.start();
        threadC.start();
    }

    public void printA() {
        synchronized (mon) {
            for (int i = 0; i < 5; i++) {
                while (currentLetter != 'A') {
                    try {
                        mon.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print('A');
                currentLetter = 'B';
                mon.notifyAll();
            }
        }
    }

    public void printB() {
        synchronized (mon) {
            for (int i = 0; i < 5; i++) {
                while (currentLetter != 'B') {
                    try {
                        mon.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print('B');
                currentLetter = 'C';
                mon.notifyAll();
            }
        }
    }

    public void printC() {
        synchronized (mon) {
            for (int i = 0; i < 5; i++) {
                while (currentLetter != 'C') {
                    try {
                        mon.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print('C');
                currentLetter = 'A';
                mon.notifyAll();
            }
        }
    }
}
