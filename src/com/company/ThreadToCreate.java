package com.company;

public class ThreadToCreate extends Thread{
    public ThreadToCreate(Runnable target) {
        super(target);
    }
}
