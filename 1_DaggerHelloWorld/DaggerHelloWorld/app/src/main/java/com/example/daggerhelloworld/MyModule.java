package com.example.daggerhelloworld;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

@Module
public class MyModule {
    private static final String TAG = MyModule.class.getSimpleName();

    @Provides
    String provideHelloWorld(){
        return "Hello World";
    }

    @Component(modules = MyModule.class)
    public interface MyComponent {
        String getString(); // Provision 메서드, 바인드된 모듈로부터 의존성 제공
    }


}
