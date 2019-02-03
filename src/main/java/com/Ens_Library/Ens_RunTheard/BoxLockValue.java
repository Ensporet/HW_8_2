package com.Ens_Library.Ens_RunTheard;

import java.util.concurrent.locks.Lock;
public abstract  class BoxLockValue <T>  {

    public void begin(T t){

        lock.lock();
        action(t);
        lock.unlock();


    }

    protected abstract void action(T t);


    //------------------------------------------------------------------


    private Lock lock = new java.util.concurrent.locks.ReentrantLock();

    public Lock getLock() {
        return lock;
    }
}

