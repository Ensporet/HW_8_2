package com.Ens_Library.Ens_Console;



public  class Enter_default<T> implements Enter_null<T> {



    public Enter_default(String name , String coll,String callMessage){

        this.name = name;
        this.call =coll ;
        this.callMessage = callMessage;

    };

//---------------------------------------------------------------


//-------------------------------------------------------------
@Override
public StringBuffer infoOfObject(){




return null;
}



//--------------------------------------------

    @Override
    public T action() {

        if(getCallMessage() != null){System.out.println(getCallMessage());}


        return null;
    }


    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    //Value


    //....................................

    final private String callMessage ;

    public String getCallMessage() {
        return callMessage;
    }

    private String name ;
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void SetName(String newName) {

    }

    private String call;

    @Override
    public String getCall(){return call;}


    @Override
    public void setCall(String call) {
        this.call = call;
    }


    private T object ;

    @Override
    public T getObject() {
        return object;
    }

    @Override
    public void setObject(T object) {
        this.object = object;
    }

    //--------------------------------------------------------------

    private Enter_null enter_null = this;

    @Override
    public void exchang(Enter_Array enter_array) {

        enter_array.put(get(),enter_array.searchEnter(this));

    }

    @Override
    public Enter_null get() {
        return enter_null;
    }

    @Override
    public void set(Enter_null enter_null) {
        this.enter_null = enter_null;

    }
}
