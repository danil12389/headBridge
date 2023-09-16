package org.example;

import org.example.model.ResourceA;
import org.example.model.ResourceB;

import java.time.LocalDateTime;

public class Task implements Runnable {

    private final String name;

    private ResourceManager resourceManager;

    public Task(String name, ResourceManager resourceManager) {
        this.name = name;
        this.resourceManager = resourceManager;
    }

    @Override
    public void run() {
            try {
                if (resourceManager.availableLimitA() > 0){
                    createAndGetAInstance();
                } else {
                    while(!resourceManager.tryAcquireA()){
                        continue;
                    }
                    createAndGetAInstance();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        System.out.println("Task [" + name + "] executed on : " + LocalDateTime.now().toString());
    }

    private void createAndGetAInstance() throws InterruptedException {
        ResourceA resourceA = resourceManager.acquireResourceA();
        System.out.println("Thread " +Thread.currentThread() + " got Resource A " + resourceA.getResourceId());
        Thread.sleep(500);
        resourceManager.releaseA();}

}
