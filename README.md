# 🌻 초히의 SunFlower 클론 코딩 개발일지

[SunFlower](https://github.com/android/sunflower) 프로젝트는 안드로이드 developer 사이트에서 추천하는 앱이다.

SunFlower 앱은 Android Jetpack을 잘 사용하고 있어 Jetpack을 공부하기에 좋은 앱인 것 같아 클론 코딩해보기로 했다!

## 앱 소개

    이 앱은 꽃 리스트를 보고 자신의 정원에 심고 싶은 꽃을 선택에 자신의 정원에 추가하는 기능이 주기능인 앱이다. 간단한 앱이지만 여러 Jetpack 라이브러리가 사용되었기 때문에 몇 개의 라이브러리만 사용해본 나에게는 정말 많은 공부가 될 것 같다..!

    이 앱은 단 하나의 Activity만 사용하였고, 나머지는 모두 Fragment이다. 따ㅏㄹ서 Fragment간의 교체는 Jetpack의 Navigation을 사용하였다.

    또한 Fragment들은 ConstraintLayout을 사용하여 작성되었고, data binding이 사용되었다.

    꽃 리스트들을 저장하는 곳은 Room을 사용하였다.

    그리고 UI를 업데이트 하는데에는 ViewModel과 LiveData가 사용되었다.

    앱 테스트는 JUnit과 익스프레소가 사용되었다.

<br>

## 커밋 메시지 형식

* Add Codes - 새로운 코드를 추가했을 경우

* Implement Features - 새로운 기능을 추가하거나 완성했을 경우

* Refactor Codes - 기존에 작성한 코드를 수정했을 경우

* Fix Bugs - 오류를 해결했을 경우

* Create UI XML - 새로운 xml 파일을 생성했을 경우

<br>

### 2020/07/23 목

* 프로젝트 생성한 날!

* 프로젝트 구조를 보기 위해 layout들을 슥 봐보니 activity_main 하나와 나머지들은 모두 fragment로 작성되어 있었다.

    activity_main는 프래그먼트들의 교체를 위한 xml이고 실제 뷰들을 보고 싶다면 fragment들을 보아야 할 것 같았다.

    가장 먼저 layout을 클론코딩 해보기로 했고, fragment들 중 가장 먼저 만들어야할 것 같다고 생각한 fragment_view_pager.xml을 따라 작성해보기로 결정했다.

    > 일단 뷰 페이저를 만들어야 화면을 양 옆으로 넘길 수 있고, 뷰 페이저 위에 다른 fragment들이 올려져야 한다고 생각했기 때문이다! 또 다른 fragment들은 recyclerview가 있어(꽃 리스트 같은 데이터를 표현하는 layout) 실제 데이터들을 가지고 와야했기 때문에 kotlin 파일까지 만들어야 하나의 흐름이 끝난다고 생각했기 때문이다.

* fragment_view_pager.xml을 보자마자 멘붕...

    나는 그동안 xml파일을 생성할 때 바로 ConstraintLayout으로 생성했기 때문에 

    <img width="525" alt="01" src="https://user-images.githubusercontent.com/31889335/88261137-acbd4280-cd00-11ea-9985-b225a5584965.png">

    이런식으로 xml파일 최상단에 바로 ConstraintLayout 태그가 오기 마련이였다.

    하지만 SunFlower 프로젝트는 xml 파일을 생성할 때 바로 ConstraintLayout으로 생성하지 않고, layout으로 생성한 파일이였다.

    <img width="825" alt="02" src="https://user-images.githubusercontent.com/31889335/88261394-29502100-cd01-11ea-8bf6-1dfc762e992a.png">

    이렇게 Root element를 constraintLayout이 아닌 layout으로 하여 파일을 생성하면 

    <img width="479" alt="03" src="https://user-images.githubusercontent.com/31889335/88261533-7633f780-cd01-11ea-94c2-f67481971129.png">

    위와 같이 최상위 태그가 \<layout></layout> 이 된다.

<br>

### 2020/07/27 월
   
* fragment_view_pager.xml 에서 CoordinatorLayout을 사용하려 빌드 파일에 종속성 추가하려던 찰나 build 파일 구성하는 것에 꽂혀서 build 파일에 대해 공부하고 root project 수준의 build.gradle 파일에 모듈에서 사용될 라이브러리 버전들 명시했다.

* [build 파일 구성에 대해 공부하고 정리한 포스팅](https://choheeis.github.io/newblog//articles/2020-07/AppBuild)

<br>

### 2020/08/03 월

* fragment_view_pager.xml로 돌아와서 xml 구조를 살펴보았다. 가장 부모 태그는 \<layout> 태그였는데 이 태그는 데이터 바인딩과 관련이 있는 것 같아 \<layout> 태그를 일단 무시하고 가장 큰 부모 태그를 \<CoordinatorLayout> 태그로 작성하였다.

* CoordinatorLayout 에 대해 공부해보았다.

* [CoordinatorLayout에 대해 공부하고 정리한 포스팅](https://choheeis.github.io/newblog//articles/2020-07/CoordinatorLayout)

<br>

### 2020/08/04 화

* xml 속성 중 android:fitsSystemWindow 라는 속성이 사용되었길래 찾아보았더니 status bar를 투명 상태로 했을 경우 status bar와 다른 뷰들이 겹쳐 보이는 문제가 발생하는 것을 방지하기 위함이였다!

* __android:fitsSystemWindow__ 라는 속성은 [View](https://developer.android.com/reference/android/view/View) 클래스에 속해있는 속성으로 status bar나 안드로이드 화면 하단의 홈, 뒤로가기 버튼이 있는 layout과 같은 안드로이드 시스템 윈도우의 내부에 해당 layout이 배치되게 해주는 속성이다.

    만약

    <img width="606" alt="01" src="https://user-images.githubusercontent.com/31889335/89292941-18f05c80-d698-11ea-98cb-3e6afcb84f71.png">

    AppTheme Style 에 위와 같이 status bar를 투명하게 하는 속성을 추가했다고 가정하자.

    이 경우, activity_main.xml 이 다음과 같다면

    <img width="477" alt="02" src="https://user-images.githubusercontent.com/31889335/89293214-7edce400-d698-11ea-99aa-0dac7939daf3.png">

    렌더링된 화면은 

    <img width="328" alt="03" src="https://user-images.githubusercontent.com/31889335/89293309-ad5abf00-d698-11ea-9345-119e4422aac6.png">

    이렇게 status bar와 TextView가 겹쳐 보이게 된다.

    따라서 이 때, 아래의  코드처럼 __android:fitsSystemWindow__ 라는 속성을 TextView에 추가하게 되면 TextView는 

    <img width="468" alt="04" src="https://user-images.githubusercontent.com/31889335/89293685-44277b80-d699-11ea-92a3-3d65f816e29f.png">

    status bar 내부에 존재하는 화면을 기준으로 맞춰지게 된다.

    <img width="324" alt="05" src="https://user-images.githubusercontent.com/31889335/89293805-7b962800-d699-11ea-8c84-1cb46b35c42a.png">

    <br>
