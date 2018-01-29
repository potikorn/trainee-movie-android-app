package com.example.potikorn.testcoopapp.fragment
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.potikorn.testcoopapp.R
import com.example.potikorn.testcoopapp.adapter.AdapterPoster
import com.example.potikorn.testcoopapp.contracter.MainContractor
import com.example.potikorn.testcoopapp.models.Movie
import com.example.potikorn.testcoopapp.models.Television
import com.example.potikorn.testcoopapp.models.YouVidData
import com.example.potikorn.testcoopapp.presenter.MainPresenter
import kotlinx.android.synthetic.main.fragment_fragment_movie.*
open class FragmentMovie : Fragment(), MainContractor.View {

    private val movieAdapter: AdapterPoster by lazy { AdapterPoster(listOf()) }
    private var presenter: MainContractor.Presenter? = MainPresenter(this)
    override fun callBackData(arr: List<Movie>?, arrTv: List<Television>?, resultsYoutube: List<YouVidData>?) {
        arr?.let { movieAdapter.setItem(it) }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater!!.inflate(R.layout.fragment_fragment_movie, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        moviesList?.layoutManager = LinearLayoutManager(context)
        moviesList.adapter = movieAdapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter?.callBackData()
    }

}