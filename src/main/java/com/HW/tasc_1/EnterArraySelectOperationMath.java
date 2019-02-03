package com.HW.tasc_1;

import com.Ens_Library.Ens_Console.Enter_Array;

import com.Ens_Library.Ens_Console.Enter_default;
import com.Ens_Library.Ens_Console.Enter_null;
import com.Ens_Library.Ens_RunTheard.RunTheard_Exchanger;


import java.util.Scanner;
import java.util.concurrent.Exchanger;

public class EnterArraySelectOperationMath extends Enter_Array {


    public EnterArraySelectOperationMath(
            Scanner scanner,
            Enter_null<Double> numberOne,
            Enter_null<Double> numberTwo,
            Exchanger<String> exchanger
    ) {
        super(scanner,
                "Mathematical actions (tack 1)",
                "",
                "Select mathematical actions :",
                "Not have this action",
                null, "cancel", "x", null
        );

        enter_value0 = numberOne;
        enter_value1 = numberTwo;
        this.exchanger = exchanger;

        addEnters(

                new Enter_default("+", "", null) {//+..............................................

                    @Override
                    public int getOrder() {
                        return Enter_Array.ORDER_EXIT;
                    }

                    @Override
                    public String action() {

                        double d0 = EnterArraySelectOperationMath.this.enter_value0.getObject();
                        double d1 = EnterArraySelectOperationMath.this.enter_value1.getObject();

                        EnterArraySelectOperationMath.this.getEnter_value0();

                        this.setObject(String.valueOf(d0 + d1));
                        return (String) this.getObject();
                    }
                },
                new Enter_default("-", "", null) {//-..............................................

                    @Override
                    public int getOrder() {
                        return Enter_Array.ORDER_EXIT;
                    }

                    @Override
                    public String action() {

                        double d0 = EnterArraySelectOperationMath.this.enter_value0.getObject();
                        double d1 = EnterArraySelectOperationMath.this.enter_value1.getObject();


                        this.setObject(String.valueOf(d0 - d1));
                        return (String) this.getObject();
                    }
                },
                new Enter_default("*", "", null) {//*..............................................

                    @Override
                    public int getOrder() {
                        return Enter_Array.ORDER_EXIT;
                    }

                    @Override
                    public String action() {

                        double d0 = EnterArraySelectOperationMath.this.enter_value0.getObject();
                        double d1 = EnterArraySelectOperationMath.this.enter_value1.getObject();


                        this.setObject(String.valueOf(d0 * d1));
                        return (String) this.getObject();
                    }
                },
                new Enter_default("/", "", null) {//_/.............................................

                    @Override
                    public int getOrder() {
                        return Enter_Array.ORDER_EXIT;
                    }

                    @Override
                    public String action() {

                        double d0 = EnterArraySelectOperationMath.this.enter_value0.getObject();
                        double d1 = EnterArraySelectOperationMath.this.enter_value1.getObject();


                        this.setObject(String.valueOf((d1 == 0.0 || d0 == 0.0) ? 0 : d0 / d1));
                        return (String) this.getObject();
                    }
                },
                new Enter_default("%", "", null) {//%..............................................

                    @Override
                    public int getOrder() {
                        return Enter_Array.ORDER_EXIT;
                    }

                    @Override
                    public String action() {

                        double d0 = EnterArraySelectOperationMath.this.enter_value0.getObject();
                        double d1 = EnterArraySelectOperationMath.this.enter_value1.getObject();


                        this.setObject(String.valueOf(((d1 == 0 || d0 == 0) ? 0 : d0 % d1)));
                        return (String) this.getObject();
                    }
                },
                new Enter_default("==", "", null) {//==............................................

                    @Override
                    public int getOrder() {
                        return Enter_Array.ORDER_EXIT;
                    }

                    @Override
                    public String action() {

                        double d0 = EnterArraySelectOperationMath.this.enter_value0.getObject();
                        double d1 = EnterArraySelectOperationMath.this.enter_value1.getObject();


                        this.setObject((d0 == d1) ? "True" : "False");
                        return (String) this.getObject();
                    }
                },
                new Enter_default("<", "", null) {//<..............................................

                    @Override
                    public int getOrder() {
                        return Enter_Array.ORDER_EXIT;
                    }

                    @Override
                    public String action() {

                        double d0 = EnterArraySelectOperationMath.this.enter_value0.getObject();
                        double d1 = EnterArraySelectOperationMath.this.enter_value1.getObject();


                        this.setObject((d0 < d1) ? "True" : "False");
                        return (String) this.getObject();
                    }
                },
                new Enter_default(">", "", null) {//>..............................................

                    @Override
                    public int getOrder() {
                        return Enter_Array.ORDER_EXIT;
                    }

                    @Override
                    public String action() {

                        double d0 = EnterArraySelectOperationMath.this.enter_value0.getObject();
                        double d1 = EnterArraySelectOperationMath.this.enter_value1.getObject();


                        this.setObject((d0 > d1) ? "True" : "False");
                        return (String) this.getObject();
                    }
                }

        );


    }


    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    @Override
    public StringBuffer infoOfObject() {
        if (getObject() == null) {
            return null;
        } else {
            return new StringBuffer(getObject().getName());
        }
    }


    //--------------------------------------------

    @Override
    public Enter_null<Object> action() {
        Enter_null enter_null = super.action();


        if (enter_null != null) {//A new thread is created only for exchanging the string.

            new RunTheard_Exchanger<String>(EnterArraySelectOperationMath.this.getExchanger(), (String) enter_null.getObject()).start();
        }

        return enter_null;
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    final private Exchanger<String> exchanger;

    public Exchanger<String> getExchanger() {
        return exchanger;
    }

    final private Enter_null<Double> enter_value0;

    public Enter_null<Double> getEnter_value0() {
        return enter_value0;
    }

    final private Enter_null<Double> enter_value1;

    public Enter_null<Double> getEnter_value1() {
        return enter_value1;
    }
}
