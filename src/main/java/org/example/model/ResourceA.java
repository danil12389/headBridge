package org.example.model;

import java.util.concurrent.atomic.AtomicInteger;

public class ResourceA {

    //5 instances max

    int  resourceId;

    public ResourceA(int resourceId) {
        this.resourceId = resourceId;
    }

    public int getResourceId() {
        return resourceId;
    }
}
