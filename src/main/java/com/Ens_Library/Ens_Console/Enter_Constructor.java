package com.Ens_Library.Ens_Console;

import java.util.Scanner;

public abstract class Enter_Constructor<T> extends Enter_default<T> {


    public Enter_Constructor(Scanner scanner , String name, String coll, String callMessage
            ,String exit ,String callNotCreatObject , String callCreateObject,Enter_null ... enters) {
        super(name, coll, callMessage);

        this.callCreateObject = callCreateObject;
        this.callNotCreatObject = callNotCreatObject;

        Enter_null enter_null [] = new Enter_null[(enters == null) ? 1 : (enters.length + 1)];

        if(enters!= null){
        for(int i = 0 ; i < enters.length;i++){

         enter_null[i] = enters[i];
        }}

        enter_null[ (enter_null.length - 1)] = new Enter_default<T>("Create","",null ){


            @Override
            public T action() {
                super.action();

                T t = buldObject();
                    if(t != null){
                        if(getCallCreateObject() != null){System.out.println(getCallCreateObject());}
                        setObject(t);
                    }else {
                        if(getCallNotCreatObject() != null){System.out.println(getCallNotCreatObject());}

                    }

                return t;
            }

            @Override
            public int getOrder() {

                return (getObject() == null) ? -1 : Enter_Array.ORDER_EXIT;
            }
        };

        enter_array = new Enter_Array(scanner,null,null,null,"Array param not have this command !",
                null," --->>>chancel<<<--- ",exit,enter_null);
    }



    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    //Function


    protected abstract T buldObject();

    //----------------------------------------------
    @Override
    public T action() {

        if(getCallMessage() != null){System.out.println(getCallMessage());}

        getEnter_array().action();

        if(getEnter_array().getEnters().length > 0){
            T t = (T)getEnter_array().getEnters()[getEnter_array().getEnters().length - 1].getObject();
            setObject(t);
            return t;
        }else {

            return null;
        }



    }


    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    //Value

    final private String callCreateObject;

    public String getCallCreateObject() {
        return callCreateObject;
    }

    //-------------------------------------
    final private String callNotCreatObject ;

    public String getCallNotCreatObject() {
        return callNotCreatObject;
    }

    //----------------------------
    final private Enter_Array enter_array ;

    public Enter_Array getEnter_array() {
        return enter_array;
    }
}
