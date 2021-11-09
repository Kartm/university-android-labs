package dma.pwr.lab4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


/**
 * A simple [Fragment] subclass.
 * Use the [CardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CardFragment : Fragment() {
    private var counter: Int? = null
    private val COLOR_MAP = intArrayOf(
        R.color.purple_200, R.color.purple_500, R.color.purple_700, R.color.teal_200, R.color.teal_700,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            counter = requireArguments().getInt(ARG_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_card, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setBackgroundColor(ContextCompat.getColor(requireContext(), COLOR_MAP[counter!!]))
        val textViewCounter = view.findViewById<TextView>(R.id.tv_counter)
        textViewCounter.text = "Fragment ${counter!! +  1}"


        val tabLayout: TabLayout = requireActivity().findViewById(R.id.tab_layout)
        val viewPager: ViewPager2 = requireActivity().findViewById(R.id.view_pager)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = "TAB ${(position + 1)}"
        }.attach()
    }

    companion object {
        // kinda 'static' from Java
        private const val ARG_COUNT = "param1"
        fun newInstance(counter: Int?): CardFragment {
            val fragment = CardFragment()
            val args = Bundle()
            args.putInt(ARG_COUNT, counter!!)
            fragment.arguments = args
            return fragment
        }
    }
}