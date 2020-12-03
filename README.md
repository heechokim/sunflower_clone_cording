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

1️⃣ __Build 파일에 라이브러리 Dependency 작성할 때 root build.gradle 파일에 버전 정리하고, app build.gradle 파일에서 사용하기!__

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
         constraintLayoutVersion = '2.0.0-beta3'
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
     ...
 }
 ~~~
    
2️⃣ __네이밍 스킬!__

* file 생성시 이름 짓기.

   * xml 파일은 __activity_main.xml__, __fragment_detail__ 처럼 activity, fragment를 앞으로 배치한다.
   
   * 클래스 파일은 __MainActivity.kt__, __DetailFragment__ 처럼 해당 xml 파일 이름의 순서를 바꾸어 파스칼법으로 작성한다.

* xml 파일에서 사용하는 id 는 snake 표기법으로 작성하자.

   * fragment의 id는 
   
      ~~~xml
      <fragment
        android:id="@+id/plant_detail_fragment"
        ...
      >
      ~~~
      
      __plant_detail_fragment__ 처럼 fragment를 맨 마지막에 붙인다.
   
   * layout의 id는
   
      ~~~xml
      <androidx.coordinatorlayout.widget.CoordinatorLayout
        android:id="@+id/coordinator_layout"
        android:layout_width="match_parent"
        android:layout_height="match_parent">
         
      ...
      </androidx.coordinatorlayout.widget.CoordinatorLayout>
      ~~~
      
      __coordinator_layout__ 과 같이 레이아웃의 고유 이름으로 작성한다. 만약 AppBarLayout을 배치했다면 id는 app_bar_layout 으로 작성하라는 것!
      
* 폴더명은 모두 소문자로 작성하고, 폴더 안에 저장할 파일들이 여러개면 폴더명 가장 마지막에 s(복수형)를 붙이자.

   * Adapter와 관련된 클래스들이 저장될 폴더는 __adapters__ 라고 이름 짓는다.
      
3️⃣ __width, height 값 작성 스킬!__

   * 자식 뷰를 가지는 부모 뷰의 width나 height 값은 wrap_content로 맞춰주자. (즉, 부모 뷰에서 width나 height 높이를 직접 dp 값으로 넣지 말자는 것!)
   
      ~~~xml
      <com.google.android.material.appbar.AppBarLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <com.google.android.material.appbar.MaterialToolbar
            android:id="@+id/topAppBar"
            android:layout_width="match_parent"
            android:layout_height="200dp"
                                                            
      </com.google.android.material.appbar.AppBarLayout>
      ~~~
      
      위 코드에서 부모 뷰인 AppBarLayout의 width는 match_parent로 맞췄지만(자식 뷰의 크기에 영향을 받지 않을 뷰이기 때문) height는 wrap_content로 맞추었다.
      
      자식 뷰인 MaterialToolBar의 height가 언제든지 변경될 수 있기 때문에 자식 뷰의 높이에 부모 뷰가 동적으로 맞춰지도록 한 것!
 
4️⃣ __주석 작성 스킬__

   * 영어로 작성할 때는 동사(첫 알파벳 대문자)로 시작하게끔 작성한다.
   
      예 ) // Initialize view objects
      
      예 ) // Set the icon and text for each tab

## SunFlower App 클론 코딩하며 공부한 것들

* [Build 파일 구성에 대해 공부하고 정리한 포스팅](https://choheeis.github.io/newblog//articles/2020-07/AppBuild)

* [CoordinatorLayout에 대해 공부하고 정리한 포스팅](https://choheeis.github.io/newblog//articles/2020-07/CoordinatorLayout)

* [AppBar에 대해서 공부한 포스팅](https://choheeis.github.io/newblog//articles/2020-10/AppBar)
   
* [ViewPager2에 대해서 공부한 포스팅](https://choheeis.github.io/newblog//articles/2020-08/ViewPager2)

* [Navigation에 대해서 공부한 포스팅](https://choheeis.github.io/newblog//articles/2020-08/navigation)

* [View Binding에 대해서 공부한 포스팅](https://choheeis.github.io/newblog//articles/2020-09/viewBinding)

* [Fragment Life Cycle에 대해서 공부한 포스팅](https://choheeis.github.io/newblog//articles/2020-09/fragment)

* [Data Binding에 대해서 공부한 포스팅](https://choheeis.github.io/newblog//articles/2020-10/dataBinding)

## Contributed

[Official SunFlower App](https://github.com/android/sunflower/pull/669) 의 Contributor가 되었다!

--> [Official SunFlower App의 Toolbar 이름 바꿈](https://github.com/android/sunflower/pull/669)


