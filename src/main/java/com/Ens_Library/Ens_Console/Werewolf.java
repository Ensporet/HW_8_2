package com.Ens_Library.Ens_Console;

import java.util.Scanner;

public interface Werewolf<T extends Enter_null & Werewolf> {


    void exchang(Enter_Array enter_array);

    T get();

    void set(T t);


}
