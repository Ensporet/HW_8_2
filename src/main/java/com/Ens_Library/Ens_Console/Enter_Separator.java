package com.Ens_Library.Ens_Console;

public class Enter_Separator implements Enter_null {



    public Enter_Separator(String separator){
        this.separator = separator;

    }

    @Override
    public Object action() {
        return null;
    }


    private String separator ;



    @Override
    public String getName() {
        return separator;
    }

    @Override
    public void SetName(String newName) {
        this.separator = newName;
    }

    @Override
    public String getCall() {
        return null;
    }

    @Override
    public void setCall(String newCall) {
        //
    }

    @Override
    public Object getObject() {
        return null;
    }

    @Override
    public void setObject(Object o) {
//-------
    }

    @Override
    public StringBuffer infoOfObject() {
        return null;
    }


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
