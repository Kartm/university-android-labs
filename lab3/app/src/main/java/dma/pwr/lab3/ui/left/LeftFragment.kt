package dma.pwr.lab3.ui.left

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import dma.pwr.lab3.databinding.FragmentLeftBinding
import dma.pwr.lab3.ui.middle.MiddleViewModel

class LeftFragment : Fragment() {

    private lateinit var leftViewModel: LeftViewModel
    private lateinit var middleViewModel: MiddleViewModel
    private var _binding: FragmentLeftBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        leftViewModel =
            ViewModelProvider(this).get(LeftViewModel::class.java)

        _binding = FragmentLeftBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textLeft
        leftViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

//        middleViewModel =
//            ViewModelProvider(requireActivity()).get(MiddleViewModel.class);


        middleViewModel = ViewModelProvider(requireActivity()).get(MiddleViewModel::class.java)

        val editText: EditText = binding.myEditText;
        editText.setText(middleViewModel.text.value);
        editText.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                middleViewModel.setText(s.toString());
            }
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}