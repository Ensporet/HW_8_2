package com.Ens_Library.Ens_Console;

import com.Ens_Library.Ens_File.File_default;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Enter_newFile extends Enter_Constructor<File> {
    public Enter_newFile(Scanner scanner,


                         String coll,

                         String exit,
                         String defaultPatch,
                         String defaultName,
                         String defaultMod,
                         Boolean defaultIsFile


                         ) {


        super(scanner,
                "New",
                coll,
                "Create a new file :",
                exit,
                "File is not create !",
                "File is create ",
                new Enter_String(scanner,"Patch","","New pach :",null),// 0
                new Enter_String(scanner,"Name","","New name for file :",null),// 1
                new Enter_String(scanner,"Mode","","New mod for file :",null),// 2
                new Enter_Boolean(scanner,"Is File","","Is file : ",null)

        ); // 3

        //defoult param

        getEnter_array().getEnters()[0].setObject( (defaultPatch == null) ? new File("").getAbsolutePath() : defaultPatch);
        getEnter_array().getEnters()[1].setObject( (defaultName == null) ? "New File" : defaultName);
        if(defaultMod != null){getEnter_array().getEnters()[2].setObject( defaultMod);}
        getEnter_array().getEnters()[3].setObject( (defaultIsFile == null) ? false : defaultIsFile);


    }

    public Enter_newFile(Scanner scanner,


                         String coll,

                         String exit,
                         File file,
                         Boolean defaultIsFile


    ) {


        super(scanner,
                "New",
                coll,
                "Create a new file :",
                exit,
                "File is not create !",
                "File is create ",
                new Enter_String(scanner,"Patch","","New pach :",null),// 0
                new Enter_String(scanner,"Name","","New name for file :",null),// 1
                new Enter_String(scanner,"Mode","","New mod for file :",null),// 2
                new Enter_Boolean(scanner,"Is File","","Is file : ",null)

        ); // 3

        //defoult param

        if(file == null){file = new File("").getAbsoluteFile();}

        String pach = file.getParent();
        String name = file.getName();
            int posEnd = name.lastIndexOf('.');
        String mod = null;

            if(posEnd > -1){
        mod =  name.substring(posEnd + 1);
        name = name.substring(0,posEnd);
            }

            getEnter_array().getEnters()[0].setObject(pach);
        getEnter_array().getEnters()[1].setObject(name);
        getEnter_array().getEnters()[2].setObject(mod);
        getEnter_array().getEnters()[3].setObject( (defaultIsFile == null) ? ((posEnd > -1) ? true : false ): defaultIsFile);




    }



    @Override
    protected File buldObject() {

        Object ob = getEnter_array().getEnters()[0].getObject();

        String _patch = (ob == null) ? null : (String)ob;

        ob = getEnter_array().getEnters()[1].getObject();
        String _name = (ob == null) ? null : (String)ob;

        ob = getEnter_array().getEnters()[2].getObject();
        String _mode = (ob == null) ? null : (String)ob;

        ob = getEnter_array().getEnters()[3].getObject();
        boolean _isFile = (ob != null) && (boolean) ob;

        File f = null;
        try{ f = new File_default().newFile( _isFile,_patch,_name,_mode );}catch (IOException e){
            e.printStackTrace();
        }





        return f;
    }
}
