package com.cassi.fragmentkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.cassi.fragmentkotlin.databinding.Fragment1Binding

class Fragment1 : Fragment() {         // Fragment com o View Pager

    private lateinit var viewPager : ViewPager2
    private lateinit var pagerAdapter: ViewPagerAdapter

    private var _binding: Fragment1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = Fragment1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pagerAdapter = ViewPagerAdapter()
        binding.viewPager.adapter = pagerAdapter
    }
}

class ViewPagerAdapter : RecyclerView.Adapter<ViewHolder>(){
    private val itemList = listOf("Sed ut perspiciatis unde omnis iste natus error sit.",
        "Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit.",
        "Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet.")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment1_layout, parent, false)
        return com.cassi.fragmentkotlin.ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val item = itemList[position]
        holder.bind(item)
    }


}

class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    private val pagerText: TextView = itemView.findViewById(R.id.pageText)
    fun bind(item:String){
        pagerText.text = item
    }
}