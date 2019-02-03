package com.Ens_Library.Ens_Console;

import java.util.Scanner;

public class Enter_Object<T> extends Enter_value<T> {


    public Enter_Object(Scanner scanner, String name, String coll, String callMessage, String callFormatIsFalse, String callFormatIsTrue, String collExit, String exit,T defaultValue,T... obj) {
        super(scanner, name, coll, callMessage, callFormatIsFalse, callFormatIsTrue, collExit, exit,defaultValue);

        setObjArray(obj);
    }
    public Enter_Object(Scanner scanner, String name, String coll, String callMessage, String callFormatIsFalse, String callFormatIsTrue, String collExit, String exit,T... obj) {
        super(scanner, name, coll, callMessage, callFormatIsFalse, callFormatIsTrue, collExit, exit,null);

        setObjArray(obj);
    }

    public Enter_Object(Scanner scanner,
                        String name,
                        String coll,
                        String callMessage,



                        String exit,
                        T... obj
    ) {
        super(scanner, name, coll, callMessage, "Array not have this command !", null, " >-----< cancel >-----< ", exit,null);
        setObjArray(obj);
    }





    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    //Function

    @Override
    public String getCallMessage() {



        String s =  super.getCallMessage();
            if(s == null){

                return  "" + info();

            }else {


                return s + "\n" + info();
            }
    }


    //------------------------------------------

    public StringBuffer info(){

        StringBuffer sb =new StringBuffer();

        int number = 0;

        for(Object o : getObjArray()){

            sb.append("[");
            sb.append(number);
            sb.append("] : ");

            sb.append(o.toString());
            sb.append("\n");
            number++;

        }

if(getExit() != null ) {
    sb.append("[");
    sb.append( (getExit().isEmpty()) ? number : getExit());
    sb.append("] : ");

    sb.append("Exit");
    sb.append("\n");
}


    return     sb;
    }


    //-------------------------------------------

    @Override
    protected T isTrueFormat(String string) {

        if(string == null || string.isEmpty()){return null;}

        for(int i = 0; i < getObjArray().length ; i++){

            if(string.equals(""+i)){ return getObjArray()[i];}

        }

        for(int i = 0; i < getObjArray().length ; i++){

            if(string.equals(getObjArray()[i].toString())){ return getObjArray()[i];}

        }



        return null;
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    //Value


    private T [] objArray ;

    public void setObjArray(T[] objArray) {


        this.objArray = objArray;
    }

    public T[] getObjArray() {
        return objArray;
    }
}
