package com.rba.darkthemedemo.detail

import android.os.Bundle
import android.view.View
import com.rba.darkthemedemo.R
import com.rba.darkthemedemo.base.BaseFragment
import com.rba.darkthemedemo.model.MenuModel
import com.rba.darkthemedemo.util.Constant
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : BaseFragment() {

    override fun layout() = R.layout.fragment_detail

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val menuModel = arguments?.getParcelable<MenuModel>(Constant.KEY)

        menuModel?.let {
            logoImageView.setImageResource(it.icon)
            descriptionTextView.text = it.description
        }

    }
}