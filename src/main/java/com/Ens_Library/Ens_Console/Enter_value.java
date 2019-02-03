package com.Ens_Library.Ens_Console;

import java.util.Scanner;

public abstract class Enter_value<T> extends Enter_default<T> {


    public Enter_value(Scanner scanner ,String name, String coll, String callMessage, String callFormatIsFalse, String callFormatIsTrue,
                       String collExit,String exit,T defoultValue) {
        super(name, coll, callMessage);


        this.callFormatIsFalse = callFormatIsFalse;
        this.callFormatIsTrue = callFormatIsTrue;
        this.callExit = collExit;
        this.exit = exit;
        this.scanner = scanner;

        setObject(defoultValue);

    }


    public Enter_value(Scanner scanner ,
                       String name,
                       String coll,
                       String callMessage



                       ) {
        super(name, coll, callMessage);


        this.callFormatIsFalse = null;
        this.callFormatIsTrue = null;
        this.callExit = null;
        this.exit = null;
        this.scanner = scanner;

    }

    @Override
    public T action() {
     super.action();

     if(scanner == null){return null;}


     T t = null;
     do {
         String string = getScanner().nextLine();

        if(string == null ){

            t = null;
        }else {

            if(string.equals(getExit())){
                if(getCallExit() != null){System.out.println(getCallExit());}
                return null;

            }else {


                t = isTrueFormat(string);

            }

        }







             if(t == null){

                 if(getCallFormatIsFalse() != null){System.out.println(getCallFormatIsFalse());}

             }else {

                 if(getCallFormatIsTrue() != null){System.out.println(getCallFormatIsTrue());}

             }






     }while (t == null && (getExit() != null && !getExit().isEmpty()));


        setObject(t);
        return t;
    }

//--------------------------------------------

    @Override
    public StringBuffer infoOfObject() {

        if(getObject() == null)return null;

        StringBuffer sb = new StringBuffer();
        sb.append(getObject());


        return sb;
    }


    ///-----------------------------------------------Value-----------------------------------------





    //-----------------
    final private String exit;

    public String getExit() {
        return exit;
    }

    final private String callExit;

    public String getCallExit() {
        return callExit;
    }

    private Scanner scanner;

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {


        this.scanner = scanner;
    }

    protected abstract T isTrueFormat(String string);

    final private String callFormatIsTrue ;

    public String getCallFormatIsTrue() {
        return callFormatIsTrue;
    }


    final private String callFormatIsFalse;

    public String getCallFormatIsFalse() {
        return callFormatIsFalse;
    }



}
