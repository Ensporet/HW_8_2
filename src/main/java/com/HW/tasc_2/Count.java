/**
 * HW 8 2 Tack 2
 */
package com.HW.tasc_2;

import com.Ens_Library.Ens_RunTheard.RunTheard_Exchanger;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Exchanger;

/**
 * class for run (sin() + cos())
 */
public class Count {


    /**
     *
     */
    public Count() {
    }

    /**
     * Run tack 2
     *
     * @param workers   size Run Thread
     * @param sizeArray size for created array integer
     * @param e         Exchanger for return value in format String
     */
    public void sinCos(int workers, int sizeArray, Exchanger<String> e) {

        if (sizeArray < 1) {
            try {
                e.exchange(null);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }

        if (workers > sizeArray) {
            workers = sizeArray;
        }
        //----

        Date date = new Date(); //date os start
        double dabl = 0; //for plus all numbers (sin() + cos())

        if (workers < 2) {                                      //if workers one

            for (int i = 1; i <= sizeArray; i++) {

                //dabl += (double) i;

                // Other solutions
                dabl += Math.sin((double)i) + Math.cos((double)i) ;
                //dabl += new BigDecimal(Math.sin(i) + Math.cos(i)).setScale(10, RoundingMode.UP).doubleValue();
                // dabl =  new BigDecimal(dabl +Math.sin(i) + Math.cos(i)).setScale(10, RoundingMode.UP).doubleValue();
            }


        } else {                                                //if workers > one

            int stepp = (sizeArray / workers);
            int last = sizeArray - (stepp * workers);
            double[] re = new double[workers];
            CountDownLatch countDownLatch = new CountDownLatch(workers);

            int i = 1;
            while (i <= sizeArray) {


                int st = (stepp + ((last > 0) ? 1 : 0));
                last--;
                int in = i;
                int wor = workers;
                workers--;
                Thread thread = new Thread() {                              //run
                    final int st0 = st;
                    int in0 = in;
                    final int wor0 = (wor - 1);


                    @Override
                    public void run() {
                        super.run();

                        double d = 0;
                        int i = (in0 + st0);

                        while (in0 < i) {

                            d += (Math.sin((double) in0) + Math.cos((double) in0));

                            // Other solutions
                            //d += (double) in0;
                            //d += new BigDecimal(Math.sin(in0) + Math.cos(in0)).setScale(10, RoundingMode.DOWN).doubleValue();
                            //d = new BigDecimal(d + Math.sin(in0) + Math.cos(in0)).setScale(10, RoundingMode.DOWN).doubleValue();

                            in0++;
                        }

                        re[wor0] = d;
                        countDownLatch.countDown();


                        //System.out.println( "[" + st0 + "\nres:"+d +"\n"+ in0 + "]\n");

                    }
                };
                thread.setDaemon(!thread.isDaemon());
                thread.start();                                             //run start()

                i += (st);
            }


            Thread th = new Thread() {
                @Override
                public void run() {
                    super.run();
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }

                    double finDouble = 0;
                    for (double d0 : re) {
                        finDouble += d0;
                    }

                    finDouble = new BigDecimal(finDouble).setScale(10, RoundingMode.DOWN).doubleValue();
                    try {
                        e.exchange("Runner dan of : " + (new Date().getTime() - date.getTime()) + " milliseconds , return : " + finDouble);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
            };
            th.setDaemon(!th.isDaemon());
            th.start();

            return;
        }


        /**
         * return
         */
        new RunTheard_Exchanger<String>(e, "Runner dan of : " + (new Date().getTime() - date.getTime()) + " milliseconds , return : " +
                new BigDecimal(dabl).setScale(10, RoundingMode.DOWN).doubleValue()).start();

    }


}
