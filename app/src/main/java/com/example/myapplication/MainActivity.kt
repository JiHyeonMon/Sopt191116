package com.example.myapplication

import HomeFragment2.HomeFragment
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import androidx.recyclerview.widget.PagerSnapHelper
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.rv_main_ad


class MainActivity : AppCompatActivity() {

    private lateinit var rvMain : RecyclerView

    var mainadList = arrayListOf<Main_ad>(
        Main_ad("베스트 셀러를\n무제한으로 읽어보세요", "2개월 무료후 9,900원\n무한eBook서비스 최다 책 보유", "main_ad_img"),
        Main_ad("두번째 광고", "호호", "main_ad_img")
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //상단바(액션바)
        supportActionBar!!.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
        supportActionBar!!.setCustomView(R.layout.menu_top)     //layout폴더 menu가 상단바 구성
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#255ad2")))        //상단바색깔


        val mAdapter = MainAdRvAdapter(this, mainadList)
        rv_main_ad.adapter = mAdapter

        val lm = LinearLayoutManager(this)
        rv_main_ad.layoutManager = lm
        rv_main_ad.setHasFixedSize(true)
        lm.setOrientation(LinearLayoutManager.HORIZONTAL)  //수평 스크롤

        // PagerSnapHelper 추가
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(rv_main_ad)





        initGitRepoList()
    }

    private fun initGitRepoList(){

        var mainadList = arrayListOf<Main_ad>()


    }
}
