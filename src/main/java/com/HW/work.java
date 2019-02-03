package com.HW;


import com.Ens_Library.Ens_Console.*;
import com.Ens_Library.Ens_RunTheard.RunTheard_default;
import com.HW.tasc_1.EnterArraySelectOperationMath;
import com.HW.tasc_2.Count;
import org.apache.log4j.Logger;


import java.util.Scanner;
import java.util.concurrent.Exchanger;

public class work {

    private final static Logger logger = Logger.getLogger(work.class);

    public static void main(String[] args) {


        logger.info("Start HW_8_2");
        Scanner scanner = new Scanner(System.in);
        Exchanger<String> exchanger = new Exchanger<>();

        //select numbers 1 - 2
        Enter_Double enter_double = new Enter_Double(scanner, "Number one", "", "Enter number Double", "Not correct number Double!",
                null, "cancel", "x", 0.0);
        Enter_Double enter_double1 = new Enter_Double(scanner, "Number two", "", "Enter number Double", "Not correct number Double!",
                null, "cancel", "x", 0.0);

        new RunTheard_default() {//new runThread
            @Override
            public void run() {
                Enter_Array array = //Array console select action
                        new Enter_Array(scanner,
                                null,
                                null,
                                "HW_8_2",
                                "Console not have this command ! Try agan (You can ysed a [ simbol ] or name of command)",
                                null,
                                "Exit...",
                                "x",
                                enter_double,// 0
                                enter_double1, // 1
                                new EnterArraySelectOperationMath(scanner, enter_double, enter_double1, exchanger),//Object Mathematical actions
                                new Enter_Separator("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>")


                        ) {
                            @Override
                            public Enter_null<Object> action() {// exit from the program by exiting the array of actions using the "x".
                                                                // The line processor defines the string as a command to exit the entire system
                                super.action();

                                try {
                                    exchanger.exchange("exit");
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                                return null;
                            }
                        };


//......................................................................................................................
//Creating and configuring an object to perform task flow 2
                Enter_Integer tack2_run = new Enter_Integer(
                        scanner,
                        "Tack 2",
                        "t",
                        "Enter number of repetitions :",
                        "Is not good format . You nid a Integer format only plus numbers 0 1 2 3 .... .Try agan or enter \"x\" for exit",
                        "Run tack 2...",
                        "cancel",
                        "x",
                        null
                ) {

                    @Override
                    protected Integer isTrueFormat(String string) {//correct format
                        Integer i = super.isTrueFormat(string);

                        if (i != null) {
                            if (i < 0) {
                                return null;
                            }

                        }

                        return i;
                    }

                    @Override
                    public StringBuffer infoOfObject() {//not information of select last value
                        return null;
                    }

                    @Override
                    public Integer action() {// run tack 2 of new thread
                        Integer integer = super.action();

                        Exchanger<String> exchanger1 = new Exchanger<>();
                        int sizeTestArray = 80000000;
                        this.exchang(array);

                        new Thread() {
                            @Override
                            public void run() {
                                super.run();
                                String s = "Tack 2 :";
                                for (int i = 0; i < getObject(); i++) {


                                    Count c = new Count(1, sizeTestArray, exchanger1);
                                    try {
                                        s += "\n" + exchanger1.exchange(null);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    Count c2 = new Count(10, sizeTestArray, exchanger1);
                                    try {
                                        s += "\n" + exchanger1.exchange(null);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }

                                logger.info(s);


                                get().exchang(array);

                            }
                        }.start();


                        return integer;
                    }
                };

                //.....................................................................................................................
                //Creating and configuring an object to cancel task 2 execution flow
                Enter_default tack2_cancel = new Enter_default("Cancel Tack 2", "c", "Cancel...") {

                    @Override
                    public Object action() {
                        Object obj = super.action();

                        tack2_run.setObject(0);


                        //this.exchang(ConsoleElement.this.getEnter_array());

                        return obj;
                    }
                };

//......................................................................................................................
//Setting up and launching a sheet with a choice of commands in a separate thread
                tack2_run.set(tack2_cancel);
                tack2_cancel.set(tack2_run);

                array.addEnters(new Enter_null[]{tack2_run});


                array.action();
            }
        }.start();

//----------------------------------------------------------------------------------------------------------------------
//Receive data for task 1

        while (true) {

            try {
                String s = exchanger.exchange(null);


                if (s != null) {
                    if (s.equals("exit")) {
                        logger.info("System exit");
                        scanner.close();
                        System.exit(0);

                    } else {

                        logger.info("Exchange result : " + s);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }

}
