package com.example.codePractice;

public class Task implements Runnable {
    private boolean running = true;

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        long count = 0;
        while (running) {
            count++;
        }
        System.out.println("Loop exited. Final count: " + count);
    }

    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();
        Thread thread = new Thread(task);
        thread.start();

        Thread.sleep(100); // Allow the thread to run for a bit
        task.stop();       // Attempt to stop the thread
        thread.join();     // Wait for the thread to finish
    }
}
