package com.Ens_Library.Ens_RunTheard;

import java.util.concurrent.Semaphore;

public abstract class RunTheard_Semaphore extends RunTheard_default {


    public RunTheard_Semaphore(Semaphore s) {
        semaphore = s;
        this.setThread(buldThread());


    }


    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    //Functions


    @Override
    protected Thread buldThread() {
        return new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    RunTheard_Semaphore.this.getSemaphore().acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }

                RunTheard_Semaphore.this.run();
                RunTheard_Semaphore.this.finsh();
            }
        };
    }

    //------------------------------------
    @Override
    public abstract void run();
    //---------------------------------

    //----------------------------------
    protected void finsh() {

        getSemaphore().release();
    }


    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    //Value

    //------------------------------------
    private final Semaphore semaphore;

    protected Semaphore getSemaphore() {
        return semaphore;
    }
}
