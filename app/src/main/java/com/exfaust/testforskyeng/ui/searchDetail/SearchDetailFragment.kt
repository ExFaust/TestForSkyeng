package com.exfaust.testforskyeng.ui.searchDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.exfaust.testforskyeng.GlideApp
import com.exfaust.testforskyeng.R
import com.exfaust.testforskyeng.data.model.Meanings

class SearchDetailFragment : Fragment() {

    companion object {
        const val ARG_SEARCH_RESULT: String = "ARG_SEARCH_RESULT"
        const val ARG_SEARCH_WORD: String = "ARG_SEARCH_WORD"
    }

    lateinit var searchDetailViewModel: SearchDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)

        searchDetailViewModel = ViewModelProvider(this)[SearchDetailViewModel::class.java]

        if (requireArguments().containsKey(ARG_SEARCH_RESULT)
            && requireArguments().containsKey(ARG_SEARCH_WORD)) {
            val meanings: Meanings = requireArguments().getParcelable(ARG_SEARCH_RESULT)!!
            val word = requireArguments().getString(ARG_SEARCH_WORD)!!

            searchDetailViewModel.onGetArgs(meanings, word)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_search_detail, container, false)

        val toolbar = view.findViewById(R.id.toolbar) as Toolbar?

        (activity as AppCompatActivity).setSupportActionBar(toolbar)

        toolbar?.setNavigationOnClickListener { view ->
            view.findNavController().navigateUp()
        }

        searchDetailViewModel.wordLiveData.observe(viewLifecycleOwner, Observer {
            val activity = activity as AppCompatActivity?
            val actionBar = activity?.supportActionBar
            actionBar?.title = it
            actionBar?.setDisplayHomeAsUpEnabled(true)
        })

        searchDetailViewModel.meaningsLiveData.observe(viewLifecycleOwner, Observer {
            val textViewTranslation = view.findViewById<TextView>(R.id.textViewTranslation)
            textViewTranslation.text = it.translation.text

            val textViewTranscription = view.findViewById<TextView>(R.id.textViewTranscription)
            textViewTranscription.text = it.transcription

            val imageView = view.findViewById<ImageView>(R.id.imageView)
            GlideApp.with(this)
                .load("https:" + it.imageUrl)
                .into(imageView)
        })

        return view
    }

}
