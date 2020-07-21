package com.rba.darkthemedemo.main

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.rba.darkthemedemo.R
import com.rba.darkthemedemo.base.BaseFragment
import com.rba.darkthemedemo.model.MenuModel
import com.rba.darkthemedemo.util.Constant
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment() {

    private lateinit var mainAdapter: MainAdapter
    override fun layout() = R.layout.fragment_main

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainAdapter = MainAdapter(::onClickMain)
        mainAdapter.list = getData()
        menuRecyclerView.adapter = mainAdapter

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
            themeSwitch.visibility = View.VISIBLE
            themeSwitch.isChecked = sharedPreferencesUtil.getDarkTheme()
            themeSwitch.setOnCheckedChangeListener { _, isChecked ->
                sharedPreferencesUtil.saveDarkTheme(isChecked)
                changeTheme()
            }
        }

    }

    private fun onClickMain(menuModel: MenuModel) {
        val bundle = bundleOf(Constant.KEY to menuModel)
        findNavController().navigate(R.id.action_MainFragment_to_DetailFragment, bundle)
    }

    private fun getData(): List<MenuModel> {
        val list = arrayListOf<MenuModel>()
        list.add(MenuModel(
            R.drawable.ic_profile, getString(
                R.string.profile
            )))
        list.add(MenuModel(
            R.drawable.ic_music, getString(
                R.string.music
            )))
        list.add(MenuModel(
            R.drawable.ic_chat, getString(
                R.string.chat
            )))
        return list
    }

}