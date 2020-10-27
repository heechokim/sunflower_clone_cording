# 🌻 초히의 SunFlower 클론 코딩 개발일지

[SunFlower](https://github.com/android/sunflower) 앱은 Android Jetpack을 잘 적용시키며 업데이트 중인 android 공식 샘플 앱이다.

Jetpack을 공부하기에 좋은 앱인 것 같아 클론 코딩해보기로 했다!

## 프로젝트 폴더 구조

* __MainActivity__
    * activity_main.xml
        * Navigation과 연결된 Fragment 한 개가 배치되어 있음
    * onCreate()
        * data binding을 사용하여 activity_main.xml 파일을 binding 함(활성 뷰로 설정)

## SunFlower App 클론 코딩하면서 나에게 적용하면 좋은 것들!

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

## SunFlower App 클론 코딩하며 공부한 것들

* [Build 파일 구성에 대해 공부하고 정리한 포스팅](https://choheeis.github.io/newblog//articles/2020-07/AppBuild)

* [CoordinatorLayout에 대해 공부하고 정리한 포스팅](https://choheeis.github.io/newblog//articles/2020-07/CoordinatorLayout)

* [AppBar에 대해서 공부한 포스팅](https://choheeis.github.io/newblog//articles/2020-08/AppBarTop)
   
* [ViewPager2에 대해서 공부한 포스팅](https://choheeis.github.io/newblog//articles/2020-08/ViewPager2)

* [Navigation에 대해서 공부한 포스팅](https://choheeis.github.io/newblog//articles/2020-08/navigation)

* [View Binding에 대해서 공부한 포스팅](https://choheeis.github.io/newblog//articles/2020-09/viewBinding)

* [Fragment Life Cycle에 대해서 공부한 포스팅](https://choheeis.github.io/newblog//articles/2020-09/fragment)

* [Data Binding에 대해서 공부한 포스팅](https://choheeis.github.io/newblog//articles/2020-10/dataBinding)
