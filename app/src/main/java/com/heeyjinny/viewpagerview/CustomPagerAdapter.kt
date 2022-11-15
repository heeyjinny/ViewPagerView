package com.heeyjinny.viewpagerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.heeyjinny.viewpagerview.databinding.ItemViewpagerBinding
import kotlinx.coroutines.NonDisposableHandle.parent

//1
//item_viewpager를 사용하는 어댑터
//RecyclerView.Adapter를 상속받아 사용
//상속 받기 전 RecyclerView.ViewHolder를 상속받는 클래스 생성

//2
////RecyclerView.Adapter를 상속받고 제네릭으로 Holder클래스 지정
class CustomPagerAdapter: RecyclerView.Adapter<Holder>() {

    //2-2
    //어댑터에서 사용할 textList변수 선언 후 배열로 초기화
    //각 페이지에서 보여줄 텍스트 전달, 나중에 activity에서 오버라이드하여 값 입력 함
    var textList = listOf<String>()

    //2-1
    //3개 메서드 오버라이드
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        //2-4
        //바인딩 생성 후 Holder클래스에 전달
        val binding = ItemViewpagerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        //2-5
        //textList의 값 중 현재 포지션 값을 변수 text를 만들어 저장하고
        //Holder 클래스의 setText()메서드 호출, 변수 값 파라미터로 전달하여 화면에 출력
        val text = textList[position]
        holder.setText(text)
    }

    override fun getItemCount(): Int {
        //2-3
        //페이지 개수 결정하여 반환
        return textList.size
    }

    //3
    //어댑터를 연결할 화면 작성
    //activity_main.xml 파일 수정

}

//1-1
//RecyclerView.ViewHolder를 상속받는 클래스(Holder) 생성
//홀더 클래스의 binding 파라미터로 onCreateViewHoler에서 생성할 바인딩 전달
//홀더에서 binding을 전역변수로 사용하기 위해 val키워드 필수***
class Holder(val binding: ItemViewpagerBinding): RecyclerView.ViewHolder(binding.root){

    //1-2
    //메서드(setText())를 만들어 item_viewpager레이아웃의 텍스트뷰에 값을 입력하는 코드 작성
    //setText()메서드의 파라미터는 가상으로 text:String으로 미리 정의
    fun setText(text:String){

        //문자열(String)을 받는 변수 text의 값을 전달받아서 레이아웃 텍스트뷰에 값을 넣음
        binding.textView.text = text
    }

}