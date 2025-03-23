package com.hasandag.fragmentrecyclerviewornek

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.hasandag.fragmentrecyclerviewornek.databinding.FragmentListeBinding
class ListeFragment : Fragment() {

        private var _binding: FragmentListeBinding? = null
        private val binding get() = _binding!!

        private lateinit var ogrenciAdapter: OgrenciAdapter

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            _binding = FragmentListeBinding.inflate(inflater, container, false)
            // Öğrenciler listesi oluşturuluyor
            val ogrenciListesi = listOf(
                Ogrenci("Mahmut", "Özdemir", "123", 12, "7-A"),
                Ogrenci("Neşe", "Yılmaz", "745", 10, "5-B"),
                Ogrenci("Salih", "Çelik", "351", 17, "11-C"),
                Ogrenci("Atıf", "Değirmen", "234", 8, "2-A"),
                Ogrenci("Rasim", "Fatih", "366", 15, "10-B")
            )
            // Adapter'ı başlatıyoruz
            ogrenciAdapter = OgrenciAdapter(ogrenciListesi) { ogrenci ->
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, DetayFragment.newInstance(ogrenci))
                    .addToBackStack(null)
                    .commit()
            }

            // RecyclerView'u başlatıyoruz
            binding.recyclerView.layoutManager = LinearLayoutManager(context)
            binding.recyclerView.adapter = ogrenciAdapter

            return binding.root
        }

        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null // Hafıza sızıntısını önlemek için
        }
    }
