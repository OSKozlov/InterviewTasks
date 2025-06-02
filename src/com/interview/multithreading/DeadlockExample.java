package com.interview.multithreading;

public class DeadlockExample {

    public static void main(String[] args) {
        String resource1 = "Resource1";
        String resource2 = "Resource2";

        Thread thread1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1: Заблокировал Resource 1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    ;
                }
                System.out.println("Thread 1: Ожидает Resource 2");
                synchronized (resource2) {
                    System.out.println("Thread 1: Заблокировал Resource 2");
                }
                ;
            }
        }, "Thread-1");

        Thread thread2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2: Заблокировал Resource 2");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Thread 2: Ожидает Resource 1");
                synchronized (resource1) {
                    System.out.println("Thread 2: Заблокировал Resource 1");
                }
                ;
            }
        }, "Thread-2");

        thread1.start();
        thread2.start();
    }

}
