package org.example.model;

public class ResourceB {

    //3 instances max
    int resourceInstance;

    public ResourceB(int resourceInstance) {
        this.resourceInstance = resourceInstance;
    }

    public int getResourceInstance() {
        return resourceInstance;
    }
}
