package com.android4dev.navigationview.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android4dev.navigationview.R
import kotlinx.android.synthetic.main.fragment_inbox.view.*

class TrashFragment : Fragment() {

    companion object {
        fun newInstance(): Fragment {
            return TrashFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_inbox, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.textTitle.text = getString(R.string.trash)

    }
}