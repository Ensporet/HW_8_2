package com.Ens_Library.Ens_RunTheard;

import java.util.concurrent.Exchanger;

public class RunTheard_Exchanger<T> extends RunTheard_default{


    public RunTheard_Exchanger(Exchanger<T> exchanger,T objectForExchang) {
        this.exchanger = exchanger;

        setObject(objectForExchang);
    }

    @Override
    public void run() {


        try {
            setObject(getExchanger().exchange(getObject()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }



    //------------------------------------------------------------------
   private final Exchanger<T> exchanger;

    public Exchanger<T> getExchanger() {
        return exchanger;
    }
    //-------------------------------------------------------

    private T object ;


    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
