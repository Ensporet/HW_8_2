package com.Ens_Library.Ens_Console;

import java.util.Scanner;

public class Enter_Array extends Enter_value<Enter_null> {


    public final static int ORDER_EXIT = 0;
    public final static int ORDER_NOT_SELCT = 1;


    public Enter_Array(Scanner scanner, String name, String coll,
                        String callMessage, String callFormatIsFalse,
                        String callFormatIsTrue, String collExit,
                        String exit , Enter_null... enters) {




        super(scanner, name, coll, callMessage, callFormatIsFalse, callFormatIsTrue, collExit, exit,null);


        this.setEnters(enters);
    }

    public Enter_Array(Scanner scanner, String name, String coll,
                       String callMessage, String callFormatIsFalse,
                       String callFormatIsTrue, String collExit,
                       String exit ,int selectedIndex, Enter_null... enters) {




        super(scanner, name, coll, callMessage, callFormatIsFalse, callFormatIsTrue, collExit, exit,null);

        int l ;
        if(enters != null && selectedIndex > -1 && selectedIndex < (l = enters.length)){
            this.setObject(enters[selectedIndex]);
        }


        this.setEnters(enters);
    }


    public Enter_Array(Scanner scanner, String name, String coll,
                       String callMessage,
                      Enter_null... enters) {




        super(scanner, name, coll, callMessage, "Is array not have this command !", "", ">-----< Chancel >-----<", "x",null);


        this.setEnters(enters);
    }

    public Enter_Array(Scanner scanner, String name,

                       Enter_null... enters) {




        super(scanner, name, "", "", "Is array not have this command !", "", ">-----< Chancel >-----<", "x",null);


        this.setEnters(enters);
    }

//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<function>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>



    public Enter_null put(Enter_null enter_null , int index){

        if(index < 0 || index > getEnters().length){

            return null;
        }

        Enter_null e = getEnters()[index];
        getEnters()[index] = enter_null;
        //this.setEnters(this.getEnters());
        System.out.println(infoSelect());
        return e;
    }

    //---------------------------------------------------------
    public int searchEnter(Enter_null enter_null){

        //System.out.println(""+enter_null.getClass().getName());


            for(int i = 0 ; i <getEnters().length; i++){


                if(getEnters()[i].getClass().getTypeName().equals(enter_null.getClass().getTypeName())){
//System.out.println("eeae");
                    return i;

                }

            }





        return -1;
    }



    //------------------------------------------------------------



    //.......................................................
    protected String infoSelect(){

       String b = "";

if(getEnters().length == 0){

    b = "Array's empty ...";
}else {



        for(Enter_null e : this.getEnters()){


            if(e.getCall() != null && !e.getCall().isEmpty()){
            b += '[';
            b += e.getCall();
            b += "] : ";}

            b += e.getName();

            if(e.getObject() != null && e.infoOfObject() != null){

                b += " (";
                b += e.infoOfObject();
                b += ")";
            }


            b += '\n';


        }}

        //.......Exit
        b += '[';
        b += getExit();
        b += "] : ";

        b += "Exit";
        b +='\n';




    return b;
    }
    //........................................



    //...........................................


    protected void notCopyCall(){




        for(int i = 0 ; i < getEnters().length ; i++){



            int numb = -1;
            if(getEnters()[i].getCall() != null){


                if(this.getEnters()[i].getCall().equals(getExit())){
                    this.getEnters()[i].setCall("");
                }

                boolean isCallPresent ;
                do {


                    if(numb == -1 && this.getEnters()[i].getCall().isEmpty()){isCallPresent = true;}else {

                    isCallPresent = false;
                    for (int in = 0; in < getEnters().length; in++) {

                        if(in != i){

                        if (numb == -1) {
                            if (getEnters()[i].getCall().equals(getEnters()[in].getCall())) {
                                isCallPresent = true;
                                break;
                            }
                        } else {





                            if ((getEnters()[i].getCall() + numb).equals(getEnters()[in].getCall())) {
                                isCallPresent = true;
                                break;
                            }
                        }
                    }}}


                    if (isCallPresent) {
                        numb++;
                    }

                }while (isCallPresent);

                if(numb != -1){
                getEnters()[i].setCall(getEnters()[i].getCall()+numb);

                }


        }}


    }




    //-------------------------



    //-----------------------------




    //---------------------------------------------------------------------------

    @Override
    public Enter_null<Object> action() {


        if(getCallMessage() != null){System.out.println(getCallMessage());}

        if(getScanner() ==null){return null;}

        //System.out.println(infoSelect());

        Enter_null t = null;
        do {

            System.out.println(infoSelect());

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


                t.action();

                switch (t.getOrder()){

                    case ORDER_EXIT :
                        setObject(t);
                        return t;

                    default: break;
                }

            }




            //System.out.println(infoSelect());

        }while (getExit() != null || !getExit().isEmpty());

       if(t != null && t.getOrder() == Enter_Array.ORDER_NOT_SELCT) {return getObject();}
       setObject(t);
        return t;
    }

    //---------------------------------------------------------------------------
    @Override
    protected Enter_null<Object> isTrueFormat(String string) {

        if(string != null && !string.isEmpty()){



            for(Enter_null obj : getEnters() ){

                if(string.equals(obj.getCall())){return obj;}

            }

            for(Enter_null obj : getEnters() ){

                if(string.equals(obj.getName())){return obj;}

            }



        }

        return null;
    }
    //------------------------------------------------------------------------------------------------------------------

    public void cleanEnters(){


        setEnters(null);
    }

    //------------------------------------------------------------------------------------------------------------------

    public void removeEnter(int pos ){



        Enter_null[] array = new Enter_null[this.enters.length - 1];


        int i = 0;
        int i0 = 0;
        while (i < enters.length){
            if(i != pos){

                array[i0] = this.enters[i];
                i0++;
            }

            i++;
        }

        setEnters(array);
    }

    //------------------------------------------------------------------------------------------------------------------

    public void addEnters(Enter_null<Object>... enters){

        if(enters == null)return;


        Enter_null[] array = new Enter_null[
               enters.length + this.enters.length
                ];




        int i = 0 ;
        while (i < this.enters.length){array[i] = this.enters[i];i++;}

        int i0 = 0;
        while (i < array.length){array[i] = enters[i0];i++;i0++;}




        this.setEnters(array);

    }


    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<value>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>




    //----------------------------------------
    private Enter_null[] enters = new Enter_null[0];

    public Enter_null[] getEnters() {
        return enters;
    }

    protected void setEnters(Enter_null[] enters) {


        if(enters == null){
            this.enters = new Enter_null[0];
        }else {
        this.enters = enters;
        notCopyCall();
        }


    }
    //---------------------------------------------------------------------------




}
