package com.elfalt.ledo.ui

import android.os.Bundle
import android.view.*
import android.widget.PopupMenu
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.elfalt.ledo.R
import kotlinx.android.synthetic.main.control_app_bar.view.*
import kotlinx.android.synthetic.main.fragment_user_profile.view.*


class Users : Fragment(), PopupMenu.OnMenuItemClickListener{

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_user_profile, container, false)

        v.control_app_bar.menu_profile.setOnClickListener {
            popUpShow(it)
        }

        return v
    }

    fun popUpShow(v : View){
        val popupMenu = PopupMenu(context,v)
        popupMenu.setOnMenuItemClickListener(this)
        popupMenu.inflate(R.menu.menu_profile)
        popupMenu.show()
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.log_out -> Toast.makeText(context,"log_out",Toast.LENGTH_SHORT).show()
        }
        return true
    }

    companion object {
        fun newInstance(): Users =
            Users()
    }

}