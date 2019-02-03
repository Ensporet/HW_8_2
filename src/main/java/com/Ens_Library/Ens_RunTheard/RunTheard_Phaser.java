package com.Ens_Library.Ens_RunTheard;

import java.util.concurrent.Phaser;

public abstract class RunTheard_Phaser extends RunTheard_default {



    public RunTheard_Phaser(Phaser phaser){

        this.phaser = phaser;

    }



    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    //Function

    public abstract void runBegin();


    @Override
    public void run() {

        runBegin();
        getPhaser().arriveAndAwaitAdvance();
        runEnd();
    }

    public abstract void runEnd();




    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    //Value

    private final Phaser phaser;

    public Phaser getPhaser() {
        return phaser;
    }
}
