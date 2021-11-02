package dma.pwr.lab3.ui.right

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dma.pwr.lab3.databinding.FragmentRightBinding

class RightFragment : Fragment() {

    private lateinit var rightViewModel: RightViewModel
    private var _binding: FragmentRightBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rightViewModel =
            ViewModelProvider(this).get(RightViewModel::class.java)

        _binding = FragmentRightBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textRight
        rightViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}