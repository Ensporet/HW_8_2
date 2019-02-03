package com.Ens_Library.Ens_Console;

import com.Ens_Library.Ens_File.File_default;

import java.io.File;
import java.util.Scanner;

public class Enter_File_0 extends Enter_default<File> {



    public Enter_File_0(
                        Scanner scanner,
                        String name,
                        String coll,
                        String callMessage,
                        String exit,
                        String collExit,
                        File defoultObject
                        ) {
        super(name, coll, callMessage);

        this.enter_array = new Enter_Array(scanner,name,coll,callMessage,null,null,collExit,exit,null){


            @Override
            protected Enter_null<Object> isTrueFormat(String string) {
                Enter_null en =  super.isTrueFormat(string);

                if(en == null){

                    en = Enter_File_0.this.buldEnterOfFile(new File(string));



                }


                return en;
            }

            @Override
            protected String infoSelect() {

                System.out.println( "Select : " + ((Enter_File_0.this.getObject() == null) ? "null" : Enter_File_0.this.getObject().getAbsolutePath()) );

                return super.infoSelect();
            }
        };


        this.setObject((defoultObject == null) ? null : defoultObject.getAbsoluteFile());

    }


    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    //Function


    @Override
    public void setObject(File object) {
        if(object == null)
        {super.setObject(new File("").getAbsoluteFile());}else {

        super.setObject(object);}

        Enter_File_0.this.getEnter_array().setEnters(Enter_File_0.this.buldEnters());
    }

    //------------------------------------------------------------------------------------------------------------------
    @Override
    public File action() {


        getEnter_array().action();



     return getObject();
    }


    //------------------------------------------------------------------------------------------------------------------

    //..........................
    protected Enter_null [] buldEnters(){

        Enter_null [] ent0 = buldEnterOfFiles();
        Enter_null [] ent1 = buldEnterDefault();

        Enter_null array [] = new Enter_null[ent0.length + ent1.length];


        int i = 0;
        while (i < ent0.length){array[i] = ent0[i];i++;}
        int i0 = 0;
        while (i < array.length){array[i] = ent1[i0];i++;i0++;}



        return array;
    }
//-----------------------------------------------------------------------------


    protected Enter_null [] buldEnterDefault(){

        return  new Enter_null[]{

                new Enter_Separator("<<<<<<<<<<<<<<<>>>>>>>>>>>>>>><<<<<<<<<<<<<<<>>>>>>>>>>>>>>><<<<<<<<<<<<<<<>>>>>>>>>>>>>>><<<<<<<<<<<<<<<>>>>>>>>>>>>>>>")

                , new Enter_default("Up", "u", null){
            @Override
            public Object action() {

              String s = Enter_File_0.this.getObject().getAbsolutePath();
                int en = s.lastIndexOf(File.separatorChar);



             File f = new File(s.substring(0,(en > -1) ? ((en == s.length()) ? en : (en +1))  : s.length()));
             Enter_File_0.this.setObject(f);


             return null;
            }
        }
                , (Enter_File_0.this.getObject().exists()) ? new Enter_newFile( Enter_File_0.this.enter_array.getScanner(),"n",
                                    Enter_File_0.this.getEnter_array().getExit(),
                (Enter_File_0.this.getObject().exists()) ? Enter_File_0.this.getObject().getAbsolutePath() : Enter_File_0.this.getObject().getParent(),
                ( (Enter_File_0.this.getObject().exists()) ? "New" : Enter_File_0.this.getObject().getName()),
                null,
                false


                ){




            @Override
            public File action() {
                File f  = super.action();

                if(f != null){
                Enter_File_0.this.setObject(f);}

                return f;
            }
        } :

                new Enter_newFile( Enter_File_0.this.enter_array.getScanner(),"n",
                        Enter_File_0.this.getEnter_array().getExit(),
                        Enter_File_0.this.getObject(),

                        null


                ){
                    @Override
                    public File action() {
                        File f  = super.action();

                        if(f != null){
                            Enter_File_0.this.setObject(f);}

                        return f;
                    }
                }


                , new Enter_default("Delete","d",null){


            @Override
            public Object action() {


                new File_default().deleteFile(Enter_File_0.this.getObject());

                Enter_File_0.this.setObject(Enter_File_0.this.getObject().getParentFile());

                return null;
            }
        }


        };

    }

//------------------------------------------------------------------------------------------------------------

    protected Enter_default<File> buldEnterOfFile(File file){



        Enter_default <File> ent = new Enter_default<File>(file.getAbsolutePath(),"",null){


            @Override
            public File action() {
                File f =  super.action();

                Enter_File_0.this.setObject(this.getObject());


                return f;
            }

            @Override
            public StringBuffer infoOfObject() {
                StringBuffer sb = new StringBuffer();

                if( this.getObject().exists() ){
                    if( this.getObject().isFile()){
                        sb.append("File");
                    }else {sb.append("Directory");}}else {
                    sb.append("not exist");
                }


                return sb;
            }


        };
        ent.setObject(file);


        return ent;
    }


    //------------------------------------------------------------------------------------------------------------------
    protected Enter_default<File>[] buldEnterOfFiles(){


     File files [] = listOfFile(getObject());
     Enter_default[] enter_defaults = new Enter_default[files.length];


     for(int i = 0; i < files.length;i++){

         enter_defaults[i] = buldEnterOfFile(files[i]);



    }

    return enter_defaults;

    }

//----------------------------------------------------------------------------------------------------------

    protected File[] listOfFile(File file){

     File fs[] ;
     File f = file;

     if( f == null){f = new File("");}

     fs = new File( file.getAbsolutePath()).listFiles();

     if(fs == null || fs.length == 0){
         fs = new File[]{f};

     }

     return fs;
    }


    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    //Value


    final private Enter_Array  enter_array ;

    public Enter_Array getEnter_array() {
        return enter_array;
    }


}
