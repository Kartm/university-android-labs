package dma.pwr.lab3.ui.middle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dma.pwr.lab3.databinding.FragmentMiddleBinding
import android.R

import android.widget.EditText

import android.R.string.no
import android.text.Editable
import android.text.TextWatcher


class MiddleFragment : Fragment() {

    private lateinit var middleViewModel: MiddleViewModel
    private var _binding: FragmentMiddleBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        middleViewModel =
            ViewModelProvider(requireActivity()).get(MiddleViewModel::class.java)

        _binding = FragmentMiddleBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textMiddle
        middleViewModel.text.observe(viewLifecycleOwner, {
            textView.text = it
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}