package com.Ens_Library.Ens_Console;

import java.util.Scanner;

public class Enter_Double extends Enter_value<Double> {

    public Enter_Double(Scanner scanner, String name, String coll, String callMessage, String callFormatIsFalse, String callFormatIsTrue, String collExit, String exit, Double defoultValue) {
        super(scanner, name, coll, callMessage, callFormatIsFalse, callFormatIsTrue, collExit, exit, defoultValue);
    }



    public Enter_Double(
            Scanner scanner,
            String name,
            String coll,
            String callMessage) {
        super(scanner, name, coll, callMessage);
    }


    @Override
    protected Double isTrueFormat(String string) {

        if(string == null || !string.matches("(-|\\+)?0*\\d+((E\\d+^[.])|([.]\\d+(E(-|\\+)?\\d+)?))?") ){
            return null;
        }

        return Double.valueOf(string);
    }
}
