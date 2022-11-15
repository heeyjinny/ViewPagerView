package com.heeyjinny.viewpagerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.heeyjinny.viewpagerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //뷰바인딩
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //1
        //뷰를 사용하는 뷰페이저 만들기
        //뷰를 사용하여 뷰페이저 구현 : 하나의 아이템 레이아웃 사용, 반복적으로 동일한 구조의 뷰를 보여줄 때 사용
        //목록을 가로로 스와이프해서 보여줄 필요가 있을 때 사용(ex. 사진갤러리 앱 동작방식)
        //프래그먼트를 사용하여 뷰페이저 구현 : 각 화면들이 독립적으로 구성될 때 사용

        //1-1
        //하나의 뷰에서 사용할 아이템 레이아웃 생성
        //res - layout디렉터리 우클릭 - New - Layout Resource File
        //item_viewpager 파일 생성

        //2
        //뷰페이저에 사용할데이터(텍스트뷰의 값) 생성 후 변수(testList)생성하여 담기
        val textList = listOf("뷰1","뷰2","뷰3","뷰4")

        //2-1
        //데이터와 뷰페이저를 연결해줄 어댑터인 커스텀 어댑터 생성
        val customAdapter = CustomPagerAdapter()

        //2-2
        //어댑터에 있는 textList변수에 데이터 전달(오버라이드)
        customAdapter.textList = textList

        //2-3
        //뷰페이저에 어댑터 연결
        binding.viewPager.adapter = customAdapter

        //3
        //탭레이아웃에 메뉴명으로 사용할 이름들 배열에 저장
        val tabTitle = listOf("탭1","탭2","탭3","탭4")

        //3-1
        //TabLayoutMediator를 사용하여 탭레이아웃과 뷰페이저 연결
        //코드블록으로 전달되는 tab파라미터의 text속성에 메뉴명 입력하고
        //마지막으로 attach()메서드를 호출하여 적용
        TabLayoutMediator(binding.tabLayout, binding.viewPager){tab, position ->
            tab.text = tabTitle[position]
        }.attach()

    }//onCreate
}//MainActivity