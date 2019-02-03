package com.Ens_Library.Ens_RunTheard;

import java.util.concurrent.CountDownLatch;

public abstract class RunTheard_CountDownLatch extends RunTheard_default {

    public RunTheard_CountDownLatch(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }




    protected  Thread buldThread(){

        return new Thread() {
            @Override
            public void run() {
                super.run();

                RunTheard_CountDownLatch.this.run();

            }
        };

    };




    private final CountDownLatch countDownLatch;

    public CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }
}
