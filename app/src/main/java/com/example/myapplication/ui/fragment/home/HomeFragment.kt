
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.ui.fragment.home.FindBook.FindBookAdapter
import com.example.myapplication.MainAdRvAdapter
import com.example.myapplication.Main_ad
import com.example.myapplication.R
import com.example.myapplication.data.BookData
import com.example.myapplication.data.HashData
import com.example.myapplication.network.RequestURL
import com.example.myapplication.network.enqueue
import com.example.myapplication.ui.fragment.home.TasteBook.TasteBookAdapter
import com.example.myapplication.ui.fragment.home.TasteBook.TasteBookDummy
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    private lateinit var rvMain : RecyclerView
    private lateinit var mAdapter: MainAdRvAdapter

    private lateinit var rvHomefindView: RecyclerView
    private lateinit var findBookAdapter: FindBookAdapter
    private lateinit var findBookResponseData : BookData
    private lateinit var tasteBookResponseData : BookData
    private lateinit var hashResponseData : HashData

    private lateinit var rvHometasteView: RecyclerView
    private lateinit var tasteBookAdapter: TasteBookAdapter
    private val tasteBookDummy =
        TasteBookDummy()
    val requestURL = RequestURL

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

         //PagerSnapHelper 추가
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(rvMain)


        initGitRepoList(view)



        return view
    }

    private fun requestFindData(){
        val requestFindData = requestURL.service.getFindBookData("library")
        requestFindData.enqueue(
            onResponse = {
                response ->
                if(response.isSuccessful){
                    findBookResponseData = response.body()!!
                    Log.d("hj",response.body()!!.toString())
                    findBookAdapter.data = findBookResponseData.data
                    findBookAdapter.notifyDataSetChanged()
                }
            }
        )
    }
    private fun requestTasteData(){
        val requestTasteData = requestURL.service.getTasteBookData("jungmin")
        requestTasteData.enqueue(
            onResponse = {
                    response ->
                if(response.isSuccessful){
                    tasteBookResponseData = response.body()!!
                    Log.d("hj",response.body()!!.toString())
                    tasteBookAdapter.data = tasteBookResponseData.data
                    tasteBookAdapter.notifyDataSetChanged()
                }
            }
        )
    }
    private fun requestHashData(){
        val requestHashData = requestURL.service.getHash("sopt")
        requestHashData.enqueue(
            onResponse = {
                    response ->
                if(response.isSuccessful){
                    hashResponseData = response.body()!!
                    Log.d("hj",response.body()!!.toString())
                    Glide.with(this).load(hashResponseData.data.get(0).image).into(img_custom_keyword)
                    txt_keyword.text = hashResponseData.data.get(0).main_keyword
                    txt_hashtag.text = hashResponseData.data.get(0).keywords
                }
            }
        )
    }
    private fun initGitRepoList(v: View){

        requestFindData()
        requestTasteData()
        //FindBoook
        // 다른 것과 같이 메모리로 가져오자.
        rvHomefindView = v.findViewById(R.id.rv_home_Find)
        // this 로 현재 context 를 전달하자.
        findBookAdapter =
            FindBookAdapter(context!!)
        // 어뎁터에 우리가 정의한 data 를 대입하고
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
        tasteBookAdapter =
            TasteBookAdapter(context!!)
        tasteBookAdapter.data = tasteBookDummy.bookTasteList()
        rvHometasteView.adapter = tasteBookAdapter
        rvHometasteView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        snapHelper.attachToRecyclerView(rvHometasteView)

        //hashtag
        requestHashData()
    }
}
