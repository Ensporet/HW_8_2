package com.Ens_Library.Ens_RunTheard;

public abstract class RunTheard_default implements RunTheard_null {


    public RunTheard_default(){

        setThread(buldThread());
    }


    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    //Functions

    @Override
    public void start() {
        getThread().start();
    }


    //---------------------------------------------

    @Override
    public Object clone() {

        try {

            RunTheard_default runTheard_default = (RunTheard_default) super.clone();
            runTheard_default.setThread(runTheard_default.buldThread());

            return runTheard_default;

        }catch (CloneNotSupportedException cnse){
            cnse.printStackTrace();

        }
        return null;
    }



    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    //Value

    private Thread thread ;

    protected void setThread(Thread th){
        thread = th;
    }

    protected  Thread buldThread(){

        return new Thread() {
            @Override
            public void run() {
                super.run();

                RunTheard_default.this.run();

            }
        };

    };

    public Thread getThread() {

        return thread;
    }
}
