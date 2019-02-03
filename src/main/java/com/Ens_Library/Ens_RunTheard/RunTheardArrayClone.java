package com.Ens_Library.Ens_RunTheard;



public class RunTheardArrayClone extends RunTheard_default {


    public RunTheardArrayClone(RunTheard_null runTheard_null, int sizeClone){

       setRunTheard_null(buldClones(runTheard_null,sizeClone));
       setThread(buldThread());



    }


    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    //Functions



    @Override
    public void run() {

        for(RunTheard_null r : getRunTheard_null()){
            r.start();

        }


    }
    //----------------------------------------


    @Override
    public Object clone() {
        RunTheardArrayClone runTheardArrayClone = (RunTheardArrayClone) super.clone();
            if(runTheardArrayClone == null){return null;}

            if(runTheardArrayClone.getRunTheard_null().length > 0 ) {
                runTheardArrayClone.setRunTheard_null(runTheardArrayClone.buldClones(
                        runTheardArrayClone.getRunTheard_null()[0],runTheardArrayClone.getRunTheard_null().length
                ));
            }

       return runTheardArrayClone;
    }

    //---------------------------------------------------------------------------------
    protected RunTheard_null[] buldClones(RunTheard_null r , int  rClonesSize){

        if(rClonesSize < 0){rClonesSize = 0;}

        RunTheard_null[] ret = new RunTheard_null[rClonesSize];

        for(int i = 0 ; i < rClonesSize ; i++){
            ret[i]= (RunTheard_null) r.clone();
        }

        return ret;
    }


    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    //Variable

    private RunTheard_null runTheard_null[];

    protected void setRunTheard_null(RunTheard_null[] runTheard_null){
        if(runTheard_null == null){
            this.runTheard_null = new RunTheard_null[0];
        }else {
            this.runTheard_null = runTheard_null;

        }
    }

    public RunTheard_null[] getRunTheard_null() {
        return runTheard_null;
    }
}
