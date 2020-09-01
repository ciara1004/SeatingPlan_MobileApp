package ie.wit.seatingplan.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import ie.wit.seatingplan.R
import ie.wit.seatingplan.main.MainActivity
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    lateinit var app: MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        app = activity?.application as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val homeFragment = inflater.inflate(R.layout.fragment_home, container, false)
        activity?.title = getString(R.string.action_home)
        setButtonListener(homeFragment)
        return homeFragment
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            HomeFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    private fun setButtonListener(layout: View) {
        layout.table1.setOnClickListener {

            var fr = fragmentManager?.beginTransaction()
            fr?.replace(R.id.homeFrame, TableLayoutFragment())
            fr?.commit()
        }
    }

}
