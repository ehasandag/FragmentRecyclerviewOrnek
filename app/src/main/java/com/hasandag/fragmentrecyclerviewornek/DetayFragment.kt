package com.hasandag.fragmentrecyclerviewornek

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hasandag.fragmentrecyclerviewornek.databinding.FragmentDetayBinding
import com.hasandag.fragmentrecyclerviewornek.databinding.FragmentListeBinding


private var _binding: FragmentDetayBinding? = null
private val binding get() = _binding!!

class DetayFragment : Fragment() {

    private var ogrenci : Ogrenci? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            ogrenci = it.getSerializable("ogrenci") as Ogrenci

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding =   FragmentDetayBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textAd.text = ogrenci?.ad
        binding.textSoyad.text = ogrenci?.soyad
        binding.textYas.text = ogrenci?.yas.toString()
        binding.textSinif.text = ogrenci?.sinif
        binding.textOkulNo.text = ogrenci?.okulNo


    }

    companion object {
        fun newInstance(ogrenci: Ogrenci) = DetayFragment().apply {
            arguments = Bundle().apply {
                putSerializable("ogrenci", ogrenci)
            }
        }
    }
}