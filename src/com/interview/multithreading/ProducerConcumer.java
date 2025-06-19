package com.interview.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConcumer {

    public static void main(String[] args) {

        BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);

        Thread producer = new Thread(() -> {
           try {
               for(int i = 0; i < 5; i++) {
                   String msg = "Message " + i;
                   queue.put(msg);
                   System.out.println("Produced: " + msg);
                   Thread.sleep(1000);
               }
           } catch (InterruptedException e) {
               Thread.currentThread().interrupt();
           }
        });

        Thread concumer = new Thread(() -> {
            try {
                for(int i = 0; i < 5; i++) {
                    String msg  = queue.take();
                    System.out.println("Consumed: " + msg);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        concumer.start();
    }
}
