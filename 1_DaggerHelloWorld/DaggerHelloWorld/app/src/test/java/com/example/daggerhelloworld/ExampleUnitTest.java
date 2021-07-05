package com.example.daggerhelloworld;

import org.junit.Test;

import dagger.MembersInjector;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testHelloWorld() {
        System.out.println("*****testHelloWorld START*****");
        MyModule.MyComponent myComponent = DaggerMyModule_MyComponent.create();
        System.out.println("result = " + myComponent.getString());
    }

    @Test
    public void testMemberInjection() {
        System.out.println("*****testMemberInjection START*****");
        MyClass myClass = new MyClass();
        String str = myClass.getInjectString(); // myClass의 getInjectionString 가져옴
//        assertNotNull("조회 결과 null", str); // null이 아님을 확인, 근데 null 이야
        System.out.println("result str = " + str);
        MyModule.MyComponent myComponent = DaggerMyModule_MyComponent.create(); // Component 생성
        myComponent.inject(myClass);
        str = myClass.getInjectString();
        System.out.println("result str = " + str);
//        assertEquals("hello world", str); // str = hello world
    }

    @Test
    public void tetMemberInjector() {
        System.out.println("*****tetMemberInjector START*****");
        MyClass myClass = new MyClass();
        String str = myClass.getInjectString(); // myClass의 getInjectionString 가져옴
        System.out.println("result str = " + str);
        MyModule.MyComponent myComponent = DaggerMyModule_MyComponent.create(); // Component 생성
//        myComponent.inject(myClass);
        MembersInjector<MyClass> injector = myComponent.getInjector();
        injector.injectMembers(myClass); // injectMembers(T) 메서드 호출하면 멤버-인젝션 메서드와 동일한 작업 수행 가능
        str = myClass.getInjectString();
        System.out.println("result str = " + str);
    }
}