package com.Ens_Library.Ens_RunTheard;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public abstract class RunTheard_CyclicBarrier extends RunTheard_default {


    public RunTheard_CyclicBarrier(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }


    @Override
    protected  Thread buldThread(){

        return new Thread() {
            @Override
            public void run() {
                super.run();

                RunTheard_CyclicBarrier.this.run();
                try {
                    RunTheard_CyclicBarrier.this.getCyclicBarrier().await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }


            }
        };

    };


    //----------------------------------------------------
    private final CyclicBarrier cyclicBarrier;

    public CyclicBarrier getCyclicBarrier() {
        return cyclicBarrier;
    }
}
