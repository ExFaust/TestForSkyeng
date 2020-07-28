package com.exfaust.testforskyeng.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.SearchView
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exfaust.testforskyeng.R
import com.exfaust.testforskyeng.data.model.Meanings
import com.exfaust.testforskyeng.ui.searchDetail.SearchDetailFragment
import com.exfaust.testforskyeng.ui.setOnQueryTextListener
import com.exfaust.testforskyeng.data.model.Events

class SearchFragment : Fragment()  {

    lateinit var searchViewModel: SearchViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view:View = inflater.inflate(R.layout.fragment_search, container, false)
        val searchView = view.findViewById<SearchView>(R.id.searchView)
        val loading = view.findViewById<ProgressBar>(R.id.loading)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

        val toolbar = view.findViewById(R.id.toolbar) as Toolbar?

        val activity = activity as AppCompatActivity?
        if (activity != null) {
            activity.setSupportActionBar(toolbar)
            val actionBar = activity.supportActionBar
            if (actionBar != null) {
                actionBar.title = getString(R.string.search)
            }
        }

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                context,
                LinearLayoutManager.VERTICAL
            )
        )
        searchView.requestFocus()

        searchViewModel = ViewModelProvider(this)[SearchViewModel::class.java]

        searchViewModel.searchResult.observe(viewLifecycleOwner, Observer {
            val searchResultsAdapter =
                SearchResultsAdapter(it, object : SearchResultsAdapter.Callback {
                    override fun onItemClicked(item: Meanings) {
                        val bundle = Bundle()
                        bundle.putParcelable(SearchDetailFragment.ARG_SEARCH_RESULT, item)
                        bundle.putString(SearchDetailFragment.ARG_SEARCH_WORD, searchView.query.toString())
                        Navigation.findNavController(activity!!,R.id.nav_host_fragment)
                            .navigate(R.id.searchDetailFragment, bundle)
                    }
                })
            recyclerView.adapter = searchResultsAdapter
        })

        searchViewModel.search.observe(viewLifecycleOwner, Observer {
            if (searchView.query.toString() != it)
                searchView.setQuery(it,false)
        })

        searchViewModel.onEvent().observe(viewLifecycleOwner, Observer {
            when (it.event) {
                Events.ERROR -> {
                    showMessage(R.string.error_message)
                    loading.visibility = View.GONE
                    searchViewModel.onSearchChanged(searchView.setOnQueryTextListener())
                }
                Events.NO_CONNECTIVITY -> {
                    showMessage(R.string.no_connectivity_message)
                    loading.visibility = View.GONE
                    searchViewModel.onSearchChanged(searchView.setOnQueryTextListener())
                }
                Events.NOT_FOUND -> {
                    showMessage(R.string.not_found_message)
                    loading.visibility = View.GONE
                }
                Events.LOADING -> {
                    loading.visibility = View.VISIBLE
                }
                else -> {
                    loading.visibility = View.GONE
                }
            }
        })

        searchViewModel.onSearchChanged(searchView.setOnQueryTextListener())

        return view
    }

    private fun showMessage(@StringRes errorString: Int) {
        Toast.makeText(context, errorString, Toast.LENGTH_SHORT).show()
    }
}