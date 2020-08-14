package com.stefany.plazyconf.view.ui.fragments

import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.stefany.plazyconf.R
import com.stefany.plazyconf.model.Conference
import com.stefany.plazyconf.view.adapter.ScheduleAdapter
import com.stefany.plazyconf.view.adapter.ScheduleListener
import com.stefany.plazyconf.viewmodel.ScheduleViewModel
import kotlinx.android.synthetic.main.fragment_scheadule.*


class ScheaduleFragment : Fragment(), ScheduleListener {

    private lateinit var scheaduleAdapter: ScheduleAdapter
    private lateinit var viewModel:ScheduleViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_scheadule, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=ViewModelProviders.of(this).get(ScheduleViewModel::class.java)
        viewModel.refresh()
        scheaduleAdapter= ScheduleAdapter(this)

        rvScheadule.apply {
            layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL,false)
            adapter=scheaduleAdapter
        }
        observeViewModel() //observa la informacion del recycler view
    }

     fun observeViewModel() {
        viewModel.listSchedule.observe(this, Observer<List<Conference>>{schedule->
            scheaduleAdapter.updateData(schedule)
        })
         viewModel.isLoading.observe(this,Observer<Boolean>{
             if (it!=null)
                 rlbaseSchedule.visibility=View.INVISIBLE //Cuando los daros terminan de cargar, desaparece la carga
         })
    }

    override fun onConferenceClicked(conference: Conference, position: Int) {
        val bundle = bundleOf("conference" to conference)
        findNavController().navigate(R.id.scheduleDetailFragment,bundle)
    }

}