package org.example.test;

import org.example.ResourceManager;
import org.example.ResourceManagerImpl;
import org.example.Task;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

public class ResourceTest {

    ResourceManager resourceManager;

    @Test
    public void resourceManagerTest() {
        resourceManager = new ResourceManagerImpl(5,3, 0, 0);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        for (int i = 1; i <= 10; i++) {
            Task task = new Task("Task " + i, resourceManager);
            executor.execute(task);
        }
    }
}
