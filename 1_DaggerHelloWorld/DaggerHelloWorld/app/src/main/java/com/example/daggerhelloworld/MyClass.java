package com.example.daggerhelloworld;

import javax.inject.Inject;

import dagger.Component;

// 두번째, Member-Injection methods 구현
public class MyClass {
    private static final String TAG = MyClass.class.getSimpleName();

//    @Inject
//    int injectInt;
//
//    public int getInjectInteger(){
//        return injectInt;
//    }

    @Inject
    String injectionStr;

    public String getInjectString(){
        return injectionStr;
    }
}
