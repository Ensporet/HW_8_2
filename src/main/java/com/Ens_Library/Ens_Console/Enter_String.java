package com.Ens_Library.Ens_Console;

import java.util.Scanner;

public class Enter_String extends Enter_value<String> {

    public Enter_String(Scanner scanner, String name, String coll, String callMessage, String callFormatIsFalse, String callFormatIsTrue, String collExit, String exit,String defaultValue) {
        super(scanner, name, coll, callMessage, callFormatIsFalse, callFormatIsTrue, collExit, exit,defaultValue);
    }

    public Enter_String(Scanner scanner, String name, String coll, String callMessage, String callFormatIsFalse, String callFormatIsTrue, String collExit, String exit) {
        super(scanner, name, coll, callMessage, callFormatIsFalse, callFormatIsTrue, collExit, exit,null);
    }


    public Enter_String(Scanner scanner, String name, String coll,
                        String callMessage
                        , String exit) {
        super(scanner, name, coll, callMessage, null, null,">-----< cancel >-----<", exit,null);
    }

    public Enter_String(Scanner scanner, String name, String coll,

            String exit) {
        super(scanner, name, coll, null, null, null,">-----< cancel >-----<", exit,null);
    }



    @Override
    protected String isTrueFormat(String string) {
        return string;
    }
}
