package com.example.daggerhelloworld;

import javax.inject.Inject;

import dagger.Component;
import dagger.MembersInjector;
import dagger.Module;
import dagger.Provides;

// 첫번째, 기본 예제
@Module
public class MyModule {
    private static final String TAG = MyModule.class.getSimpleName();
    static int count = 0;
    @Provides
    String provideHelloWorld() {
        count++;
        return "count == " + count;
    }

    @Component(modules = MyModule.class)
    public interface MyComponent {
        String getString(); // Provision 메서드, 바인드된 모듈로부터 의존성
        void inject(MyClass myClass); // MyClass.java에 먼저 inject 관련 선언 - 1
        MembersInjector<MyClass> getInjector(); // injectMembers(T)호출하면 멤버-인젝션 메서드와 동일한 작업 수행// -2
    }
}