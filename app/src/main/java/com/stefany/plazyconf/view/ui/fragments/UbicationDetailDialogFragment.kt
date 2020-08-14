package com.stefany.plazyconf.view.ui.fragments

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.stefany.plazyconf.R
import com.stefany.plazyconf.model.Ubication
import kotlinx.android.synthetic.main.fragment_shedule_detail.*
import kotlinx.android.synthetic.main.fragment_ubication_detail_dialog.*

class UbicationDetailDialogFragment : DialogFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL,R.style.FullScreenDialogStyle)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ubication_detail_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbarUbication.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.ic_close)
        toolbarUbication.setTitleTextColor(Color.WHITE)
        toolbarUbication.setNavigationOnClickListener {
            dismiss()
        }
        val ubication=Ubication()

        toolbarUbication.title=ubication.name

        itemNombrelugar.text=ubication.name
        tvitemubicacionDireccion.text=ubication.address
        itemubicaciotelefono.text=ubication.phone
        itemubicacionsitioweb.text=ubication.website

        lltelefonolugar.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data= Uri.parse("tel:${ubication.phone}")
            }
            startActivity(intent)
        }
        llsitioweb.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data=Uri.parse(ubication.website)
            startActivity(intent)
        }
   }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)
    }
}