
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.FindBook.FindBookAdapter
import com.example.myapplication.FindBook.FindBookDummy
import com.example.myapplication.MainAdRvAdapter
import com.example.myapplication.Main_ad
import com.example.myapplication.R
import com.example.myapplication.TasteBook.TasteBookAdapter
import com.example.myapplication.TasteBook.TasteBookDummy
import com.example.myapplication.TodayBestseller.TodayBestsellerDummy
import com.example.myapplication.TodayBestseller.TodayBestsellerViewAdapter

class HomeFragment : Fragment() {
    private lateinit var rvMain : RecyclerView
    private lateinit var mAdapter: MainAdRvAdapter

    private lateinit var rvHomefindView: RecyclerView
    private lateinit var findBookAdapter: FindBookAdapter
    private val findBookDummy = FindBookDummy()

    private lateinit var rvHometasteView: RecyclerView
    private lateinit var tasteBookAdapter: TasteBookAdapter
    private val tasteBookDummy = TasteBookDummy()

    //오늘의 베스트
    private lateinit var rvTodayBestsellerView: RecyclerView
    private lateinit var todayBestsellerAdapter: TodayBestsellerViewAdapter
    private val todayBestsellerDummy = TodayBestsellerDummy()

    var mainadList = arrayListOf<Main_ad>(
        Main_ad("베스트 셀러를\n무제한으로 읽어보세요", "2개월 무료후 9,900원\n무한eBook서비스 최다 책 보유", "main_ad_img"),
        Main_ad("두번째 광고", "호호", "main_ad_img")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        // 처리

        //상단바(액션바)
        //supportActionBar!!.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
       //supportActionBar!!.setCustomView(R.layout.top_menu)     //layout폴더 menu가 상단바 구성
        //supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#255ad2")))        //상단바색깔

        rvMain = view.findViewById(R.id.rv_main_ad)
        mAdapter = MainAdRvAdapter(context!!, mainadList)
        rvMain.adapter = mAdapter

        var lm = LinearLayoutManager(context)
        rvMain.layoutManager = lm
        rvMain.setHasFixedSize(true)
        lm.setOrientation(LinearLayoutManager.HORIZONTAL)  //수평 스크롤

        //TodayBeatseller
        /*
        rvTodayBestsellerView=view.findViewById(R.id.rv_today_bestseller)

        todayBestsellerAdapter= TodayBestsellerViewAdapter( context!!)
        rvTodayBestsellerView.adapter=todayBestsellerAdapter

        rvTodayBestsellerView.layoutManager=lm
        rvTodayBestsellerView.setHasFixedSize(true)
        todayBestsellerAdapter.notifyDataSetChanged()

         */

         //PagerSnapHelper 추가
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(rvMain)


        initGitRepoList(view)



        return view
    }


    private fun initGitRepoList(v: View){

        var mainadList = arrayListOf<Main_ad>()

        //FindBoook
        // 다른 것과 같이 메모리로 가져오자.
        rvHomefindView = v.findViewById(R.id.rv_home_Find)
        // this 로 현재 context 를 전달하자.
        findBookAdapter = FindBookAdapter(context!!)
        // 어뎁터에 우리가 정의한 data 를 대입하고
        findBookAdapter.data = findBookDummy.bookList()
        // 우리의 recyclerView 에 우리의 adapter 로 세팅하자.
        rvHomefindView.adapter = findBookAdapter
        // viewHolder 들이 어떻게 배치될 지 설정하자.
        //rvHomefindView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        val lm = LinearLayoutManager(context)
        rvHomefindView.layoutManager = lm
        rvHomefindView.setHasFixedSize(true)
        lm.setOrientation(LinearLayoutManager.HORIZONTAL)
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(rvHomefindView)

        //TasteBoook
        rvHometasteView = v.findViewById(R.id.rv_home_taste)
        tasteBookAdapter = TasteBookAdapter(context!!)
        tasteBookAdapter.data = tasteBookDummy.bookTasteList()
        rvHometasteView.adapter = tasteBookAdapter
        rvHometasteView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        snapHelper.attachToRecyclerView(rvHometasteView)
        //val lm = LinearLayoutManager(context)
        /*
        rvHometasteView.layoutManager = lm
        rvHometasteView.setHasFixedSize(true)
        lm.setOrientation(LinearLayoutManager.HORIZONTAL)
        PagerSnapHelper()
        snapHelper.attachToRecyclerView(rvHometasteView)*/

        // 데이터를 변경했다고 알려줘서 리스트를 갱신하게 하자!
        //tasteBookAdapter.notifyDataSetChanged()

        //TodayBeatseller
        rvTodayBestsellerView=v.findViewById(R.id.rv_today_bestseller)
        todayBestsellerAdapter= TodayBestsellerViewAdapter(context!!)
        rvTodayBestsellerView.adapter=todayBestsellerAdapter
        val lm2 = LinearLayoutManager(context)
        rvTodayBestsellerView.layoutManager=lm2
        rvTodayBestsellerView.setHasFixedSize(true)
        lm2.setOrientation(LinearLayoutManager.HORIZONTAL)
        todayBestsellerDummy.TodayBestsellerList()
        todayBestsellerAdapter.notifyDataSetChanged()


    }
/*
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
        supportActionBar!!.setCustomView(R.layout.top_menu)     //layout폴더 menu가 상단바 구성
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


    }*/
}
