package com.Ens_Library.Ens_Console;

import java.util.Scanner;

public class Enter_Integer extends Enter_value<Integer> {


    public Enter_Integer(Scanner scanner, String name, String coll, String callMessage, String callFormatIsFalse, String callFormatIsTrue, String collExit, String exit,Integer defaultValue) {
        super(scanner, name, coll, callMessage, callFormatIsFalse, callFormatIsTrue, collExit, exit,defaultValue);
    }


    public Enter_Integer(
            Scanner scanner,
            String name,
            String coll,
            String callMessage
    ) {
        super(scanner, name, coll, callMessage, "Is not format integer", null, ">-----<Cancel>-----<","x",null);
    }
    public Enter_Integer(
            Scanner scanner,
            String name,
            String coll,
            String callMessage,
            Integer defaultValue
    ) {
        super(scanner, name, coll, callMessage, "Is not format integer", null, ">-----<Cancel>-----<","x",defaultValue);
    }



    @Override
    protected Integer isTrueFormat(String string) {
        char ch ;
        int l = string.length();

        if(string == null || string.isEmpty() ||
                !string.matches(
                        "((\\+?0*"                             +
                                "(([1]\\d\\d\\d\\d\\d\\d\\d\\d\\d)|"  +
                                "([2][0]\\d\\d\\d\\d\\d\\d\\d\\d)|"   +
                                "([2][1][0-3]\\d\\d\\d\\d\\d\\d\\d)|" +
                                "([2][1][4][0-6]\\d\\d\\d\\d\\d\\d)|" +
                                "([2][1][4][7][0-3]\\d\\d\\d\\d\\d)|" +
                                "([2][1][4][7][4][0-7]\\d\\d\\d\\d)|" +
                                "([2][1][4][7][4][8][0-2]\\d\\d\\d)|" +
                                "([2][1][4][7][4][8][3][0-5]\\d\\d)|" +
                                "([2][1][4][7][4][8][3][6][0-3]\\d)|" +
                                "([2][1][4][7][4][8][3][6][4][0-7])|" +
                                "(\\d\\d?\\d?\\d?\\d?\\d?\\d?\\d?\\d?)))|("+

                                "(-)0*"                               +
                                "(([1]\\d\\d\\d\\d\\d\\d\\d\\d\\d)|"  +
                                "([2][0]\\d\\d\\d\\d\\d\\d\\d\\d)|"   +
                                "([2][1][0-3]\\d\\d\\d\\d\\d\\d\\d)|" +
                                "([2][1][4][0-6]\\d\\d\\d\\d\\d\\d)|" +
                                "([2][1][4][7][0-3]\\d\\d\\d\\d\\d)|" +
                                "([2][1][4][7][4][0-7]\\d\\d\\d\\d)|" +
                                "([2][1][4][7][4][8][0-2]\\d\\d\\d)|" +
                                "([2][1][4][7][4][8][3][0-5]\\d\\d)|" +
                                "([2][1][4][7][4][8][3][6][0-3]\\d)|" +
                                "([2][1][4][7][4][8][3][6][4][0-8])|" +
                                "(\\d\\d?\\d?\\d?\\d?\\d?\\d?\\d?\\d?))))"
                )
        ){

            return null;

        }


        return Integer.valueOf(string);
    }
}
