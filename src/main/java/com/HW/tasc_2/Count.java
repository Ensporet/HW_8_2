package com.HW.tasc_2;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

import java.util.concurrent.Exchanger;
import java.util.concurrent.locks.Lock;

public class Count {


    public Count(int work, int numbers, Exchanger<String> exs) {


        int i = numbers;
        int workers = work;
        int stepp = (i / workers);
        int res = i - ((i / workers) * workers);
        CountDownLatch countDownLatch = new CountDownLatch(work);
        Date date = new Date();

        for (int w = 1; w <= work; w++) {

            int pl = 0;

            if (w == workers) {

                pl = res;

            }


            int size = stepp + pl;
            int start = ((w - 1) * stepp) + 1;

            new Th(start, size) {


                @Override
                public void run() {
                    super.run();

                    addResult(this.plasSinCos(this.bild(this.getSize(), this.getStart())));

                    countDownLatch.countDown();

                }
            }.start();

        }


        new Thread() {
            @Override
            public void run() {
                try {
                    countDownLatch.await();
                    exs.exchange("endWork " + Count.this.getResult() + " time : " + (new Date().getTime() - date.getTime()) + " runThread : " + work);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }.start();


    }


    //-------------------------------------------------------------------
    private Lock lock = new java.util.concurrent.locks.ReentrantLock();

    public Lock getLock() {
        return lock;
    }

    //-------------------------------
    private double result;

    private void addResult(double d) {

        lock.lock();


        setResult(getResult() + d);

        lock.unlock();
    }


    public double getResult() {


        return result;
    }

    public void setResult(double result) {

        this.result = result;
    }
}
