package com.elfalt.ledo.ui

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.elfalt.ledo.R


class Users : Fragment(),View.OnClickListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_user_profile, container, false)

        return v
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.log_out){
            Toast.makeText(context,"log_out",Toast.LENGTH_SHORT).show()
        }
    }


/*    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_profile,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.log_out){

        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        fun newInstance(): Users =
            Users()
    }*/

}