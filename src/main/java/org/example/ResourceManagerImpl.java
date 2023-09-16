package org.example;

import org.example.model.ResourceA;
import org.example.model.ResourceB;

import java.util.PrimitiveIterator;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class ResourceManagerImpl implements ResourceManager {

    private static  ResourceManagerImpl instance;
    private Semaphore semaphoreA;

    private Semaphore semaphoreB;

    private int counterA;

    private int counterB;

    public ResourceManagerImpl(int limitA, int limitB, int counterA, int counterB) {
        this.semaphoreA = new Semaphore(limitA);
        this.semaphoreB = new Semaphore(limitB);
        this.counterA = counterA;
        this.counterB = counterB;
    }

    public synchronized ResourceA acquireResourceA() throws InterruptedException {
            semaphoreA.acquire();
            counterA++;
            return new ResourceA(counterA);
    }

    public ResourceB acquireResourceB() throws InterruptedException {
        semaphoreB.acquire();
        counterB++;
        return new ResourceB( counterB);
    }

    public void releaseA() {
            semaphoreA.release();
            counterA--;
        }

    public void releaseB() {
        semaphoreB.release();
        counterB--;
    }
    public synchronized int availableLimitA() {
           return semaphoreA.availablePermits();
        }

    public int availableLimitB() {
        return semaphoreB.availablePermits();
    }

    public boolean tryAcquireA() {
        return semaphoreA.tryAcquire();
    }
}
