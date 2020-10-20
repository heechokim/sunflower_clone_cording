# 🌻 초히의 SunFlower 클론 코딩 개발일지

[SunFlower](https://github.com/android/sunflower) 프로젝트는 안드로이드 developer 사이트에서 추천하는 앱이다.

SunFlower 앱은 Android Jetpack을 잘 사용하고 있어 Jetpack을 공부하기에 좋은 앱인 것 같아 클론 코딩해보기로 했다!

## 앱 소개

    이 앱은 꽃 리스트를 보고 자신의 정원에 심고 싶은 꽃을 선택에 자신의 정원에 추가하는 기능이 주기능인 앱이다. 간단한 앱이지만 여러 Jetpack 라이브러리가 사용되었기 때문에 몇 개의 라이브러리만 사용해본 나에게는 정말 많은 공부가 될 것 같다..! 심지어 구글에서 현재까지도 계속 업데이트를 시키고 있는 앱이다.

    이 앱은 단 하나의 Activity만 사용하였고, 나머지는 모두 Fragment이다. 그래서 Fragment간의 교체는 Jetpack의 Navigation을 사용되었다.

    또한 Fragment들은 ConstraintLayout을 사용하여 작성되었고, data binding이 사용되었다.

    꽃 리스트들을 저장하는 곳은 Room을 사용하였다.

    그리고 UI를 업데이트 하는데에는 ViewModel과 LiveData가 사용되었다.

    앱 테스트는 JUnit과 익스프레소가 사용되었다.

<br>

## 🍉 SunFlower App 클론 코딩하면서 나에게 적용하면 좋은 것들!

1. __Build 파일에 라이브러리 Dependency 작성할 때 root build.gradle 파일에 버전 정리하고, app build.gradle 파일에서 사용하기!__

    ~~~kotlin
    // 1. root build.gradle 파일 
    buildscript {
        // Define versions in a single place
        ext {
            // Sdk and tools
            compileSdkVersion = 30
            minSdkVersion = 21
            targetSdkVersion = 30

            // App dependencies
            appCompatVersion = '1.1.0'
            assistedInjectVersion = '0.5.2'
            constraintLayoutVersion = '2.0.0-beta3'
            coreTestingVersion = '2.0.0'
            coroutinesVersion = "1.3.0-M2"
            espressoVersion = '3.1.1'
            fragmentVersion = '1.1.0-alpha09'
            glideVersion = '4.10.0'
            gradleVersion = '4.1.0'
            gsonVersion = '2.8.2'
            hiltVersion = '2.28.3-alpha'
            ...
        }

        repositories {
            google()
            jcenter()
        }
        
        ...
    }
    ~~~
    
    ~~~kotlin
    // 2. app build.gradle 파일 예시
    ...
    dependencies {
        implementation "androidx.appcompat:appcompat:$rootProject.appCompatVersion"
        implementation "androidx.constraintlayout:constraintlayout:$rootProject.constraintLayoutVersion"
        implementation "androidx.core:core-ktx:$rootProject.ktxVersion"
        implementation "androidx.fragment:fragment-ktx:$rootProject.fragmentVersion"
        ...

        // Testing dependencies
        kaptAndroidTest "com.google.dagger:hilt-android-compiler:$rootProject.hiltVersion"
        androidTestImplementation "androidx.arch.core:core-testing:$rootProject.coreTestingVersion"
        androidTestImplementation "androidx.test.espresso:espresso-contrib:$rootProject.espressoVersion"
        ...
    }
    ~~~

## 🍉 SunFlower App 클론 코딩하며 공부한 것들

* [Build 파일 구성에 대해 공부하고 정리한 포스팅](https://choheeis.github.io/newblog//articles/2020-07/AppBuild)

* [CoordinatorLayout에 대해 공부하고 정리한 포스팅](https://choheeis.github.io/newblog//articles/2020-07/CoordinatorLayout)

* [AppBar에 대해서 공부한 포스팅](https://choheeis.github.io/newblog//articles/2020-08/AppBarTop)
   
* [ViewPager2에 대해서 공부한 포스팅](https://choheeis.github.io/newblog//articles/2020-08/ViewPager2)

* [Navigation에 대해서 공부한 포스팅](https://choheeis.github.io/newblog//articles/2020-08/navigation)

* [View Binding에 대해서 공부한 포스팅](https://choheeis.github.io/newblog//articles/2020-09/viewBinding)

* [Fragment Life Cycle에 대해서 공부한 포스팅](https://choheeis.github.io/newblog//articles/2020-09/fragment)
