package com.gadsphasetwoproject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.gadsphasetwoproject.adapter.SkillIQAdapter
import com.gadsphasetwoproject.databinding.FragmentSkillIQBinding
import com.gadsphasetwoproject.utils.CustomProgressDialog
import com.gadsphasetwoproject.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SkillIQFragment : Fragment() {

    private var binding: FragmentSkillIQBinding by autoCleared()

    @Inject
    lateinit var progressDialog: CustomProgressDialog
    private lateinit var recyclerAdapter: SkillIQAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSkillIQBinding.inflate(inflater)
        progressDialog = CustomProgressDialog(requireActivity())
        with(binding) {
            recyclerAdapter = SkillIQAdapter(requireContext())
            skillRecyclerView.layoutManager = LinearLayoutManager(requireContext())
            skillRecyclerView.adapter = recyclerAdapter
        }
        return binding.root
    }

    /*private fun loadData() {
        progressDialog.showDialog()
        val apiInterface = ApiInterface.create().getLearnersIq()
        apiInterface.enqueue(object : Callback<List<UserIq>> {
            override fun onResponse(call: Call<List<UserIq>>?, response: Response<List<UserIq>>?) {
                if (response!!.isSuccessful) {
                    progressDialog.hideDialog()
                    if (response.body() != null) {
                        binding.skillEmptyStateImg.visibility = View.INVISIBLE
                        binding.skillEmptyStateText.visibility = View.INVISIBLE
                        binding.skillRecyclerView.visibility = View.VISIBLE
                        recyclerAdapter.setUserIqIqListItems(response.body()!!)
                        binding.skillRecyclerView.adapter!!.notifyDataSetChanged()
                    }
                }
            }

            override fun onFailure(call: Call<List<UserIq>>?, t: Throwable?) {
                progressDialog.hideDialog()
            }
        })
    }*/

    companion object {
        @JvmStatic
        fun newInstance() = SkillIQFragment()
    }
}