import java.io.*;
import java.util.*;


class Reminder extends Student{
    Timer timer;

    public Reminder(int seconds) {
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds*1000);
  }

    class RemindTask extends TimerTask {
        public void run() {
            System.out.println("Time's up!");
            System.out.println("You could not complete the test in time!");
            timer.cancel(); //Terminate the timer thread
            System.exit(0);
        }
    } 
}