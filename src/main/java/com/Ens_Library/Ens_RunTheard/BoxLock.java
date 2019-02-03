package com.Ens_Library.Ens_RunTheard;

import java.util.concurrent.locks.Lock;

public abstract class BoxLock {

    public void begin(){

        lock.lock();
        action();
        lock.unlock();


    }

    protected abstract void action();


    //------------------------------------------------------------------


    private Lock lock = new java.util.concurrent.locks.ReentrantLock();

    public Lock getLock() {
        return lock;
    }
}
