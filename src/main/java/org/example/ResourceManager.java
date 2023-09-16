package org.example;

import org.example.model.ResourceA;
import org.example.model.ResourceB;

public interface ResourceManager {

    ResourceA acquireResourceA() throws InterruptedException;

    ResourceB acquireResourceB() throws InterruptedException;

    void releaseA();

    void releaseB();

    int availableLimitA();

    int availableLimitB();

    boolean tryAcquireA();
}
