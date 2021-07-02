# 설정
## build.gradle에 Dagger 설정 정보 추가
**[build.gradle:Module]**
```
android {
    ...

    //DataBinding과 Dagger 함께 사용할때 Dagger관련 오류 발생 시 DataBinding에 대한 컴파일이 멈추고 오류메시도 100줄이상 출력
    // 에러 메시지를 더 확인하려면 다음과 같은 코드 추가로 설정 해야 함
    gradle.projectsEvaluated {
        tasks.withType(JavaCompile) {
            options.compilerArgs << "-Xmaxerrs" << "500"
        }
    }
}

dependencies {

    ...

    //Dagger 적용
    implementation 'com.google.dagger:dagger-android:2.35.1'
    implementation 'com.google.dagger:dagger-android-support:2.27'
    annotationProcessor 'com.google.dagger:dagger-android-processor:2.27'
    annotationProcessor 'com.google.dagger:dagger-compiler:2.27'
}
```

## MyModule.class 구현
## ExampleUnitTest에 UnitTest 구현
