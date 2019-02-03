package com.Ens_Library.Ens_Console;

import java.util.Scanner;

public abstract class Enter_ArrayList extends Enter_Array {
    public Enter_ArrayList(Scanner scanner, String name, String coll, String callMessage, String callFormatIsFalse, String callFormatIsTrue, String collExit, String exit, Enter_null... enters) {
        super(scanner, name, coll, callMessage, callFormatIsFalse, callFormatIsTrue, collExit, exit, null);

        Enter_null[] def         = buldDefoultEntered();
        int entersSize = (enters == null) ? 0 : enters.length;
        sizeDefaultEntered = (def == null) ? 0 : def.length;
        Enter_null[] enter_nulls = new Enter_null[entersSize + sizeDefaultEntered ];

        int i = 0 ;

        while (i < entersSize){

            enter_nulls[i] = enters[i];
            i ++;
        }
        int in = 0;
        while (in < sizeDefaultEntered){

            enter_nulls[i] = def[in];
            i++;
            in++;

        }
        setEnters(enter_nulls);

    }


    @Override
    protected Enter_null<Object> isTrueFormat(String string) {
        Enter_null enter_null =  super.isTrueFormat(string);

         if(enter_null != null && enter_null.getOrder() != Enter_Array.ORDER_NOT_SELCT){   setObject(enter_null);}

        return enter_null;
    }

    //----------------------------------------------------
    @Override
    public void addEnters(Enter_null<Object>... enters) {

        if(enters == null)return;

        Enter_null enter_null[] = new Enter_null[getEnters().length + enters.length];

        int i = 0;
        while (i < getEnters().length - sizeDefaultEntered){

            getEnters()[i].setCall("");
        enter_null[i] = getEnters()[i];
        i++;

        }



        int in = 0;
        while (in < enters.length  ){

            enter_null[i] = enters[in];
            i++;
            in++;

        }


in =getEnters().length - sizeDefaultEntered ;


        while (i < enter_null.length){

           enter_null[i] = getEnters()[in];
           i++;
           in++;

        }





        setEnters(enter_null);

    }

    //--------------------------------------------------------------------------------------
    protected Enter_null[] buldDefoultEntered(){

        Enter_null[] enter_null = new Enter_null[]{

                 new Enter_Separator("........................................................"),
         new Enter_default<Enter_null>("New", "n", "Create new object") {

            @Override
            public Enter_null action() {

                super.action();

                Enter_null enter_null1 = Enter_ArrayList.this.EnterNewObject();

                Enter_ArrayList.this.setObject(enter_null1);
                Enter_ArrayList.this.addEnters(enter_null1);

                Enter_ArrayList.this.actionOfNewObject(enter_null1.getObject());

                return enter_null1;
            }
        },
         new Enter_default("Delet", "d", "Object delet...") {

             @Override
             public int getOrder() {
                 return Enter_Array.ORDER_NOT_SELCT;
             }

             @Override
            public Object action() {
                super.action();

                if(Enter_ArrayList.this.getObject() == null){
                    System.out.println("Object is not select !");
                    return null;
                }else {


                   for(int i = 0; i < Enter_ArrayList.this.getEnters().length ; i++){

                       if(Enter_ArrayList.this.getEnters()[i].equals(Enter_ArrayList.this.getObject())){
                           removeEnter(i);
                           Enter_ArrayList.this.setObject(null);
                           Enter_ArrayList.this.actionOfDeletObject(i);

                           return null;
                       }

                   }




                 }


                return null;
            }
        }
};

return enter_null;
    }//--------------

    public void actionOfNewObject(Object obj){
        //--
    }
    public void actionOfDeletObject(int index){

        //--
    }


//---------------------------------------------------------------------------------
    @Override
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

            if(e.equals(Enter_ArrayList.this.getObject())){
                b += " <select>" ;
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

    //--------------------------------------------------------------------------

    protected abstract Enter_null EnterNewObject();



    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    //Value


    private final int sizeDefaultEntered ;

    public int getSizeDefaultEntered() {
        return sizeDefaultEntered;
    }
}
