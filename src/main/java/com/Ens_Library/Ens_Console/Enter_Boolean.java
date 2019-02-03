package com.Ens_Library.Ens_Console;

import java.util.Scanner;

public class Enter_Boolean extends Enter_Object<Boolean> {


    public Enter_Boolean(Scanner scanner, String name, String coll, String callMessage, String callFormatIsFalse, String callFormatIsTrue, String collExit, String exit,Boolean defaultValue) {
        super(scanner, name, coll, callMessage, callFormatIsFalse, callFormatIsTrue, collExit, exit,defaultValue,new Boolean[]{true,false});
    }

    public Enter_Boolean(
            Scanner scanner,
            String name,
            String coll,
            String callMessage,



            String exit) {
        super(scanner, name, coll, callMessage, "You nid select 0 or 1 !",null, ">-----< cancel >-----<", exit,null, new Boolean[]{true,false});
    }

    public Enter_Boolean(
            Scanner scanner,
            String name,
            String coll,
            String callMessage



            ) {
        super(scanner, name, coll, callMessage, "You nid select 0 , true , 1 , false !",null, ">-----< cancel >-----<", "x",null, new Boolean[]{true,false});
    }


}
