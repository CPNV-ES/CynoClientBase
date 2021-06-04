package ch.leytto.cynoclient.ui.manage_dogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import ch.leytto.cynoclient.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DogsFragment : Fragment() {

    private lateinit var dogsViewModel: DogsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dogsViewModel =
            ViewModelProvider(this).get(DogsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_manage_dogs, container, false)
        val textView: TextView = root.findViewById(R.id.text_dogs)
        dogsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        val mFab = root.findViewById<FloatingActionButton>(R.id.fab_redirect_to_new_dog)
        mFab.setOnClickListener {
            root.findNavController().navigate(R.id.form_create_dog)
        }

        return root
    }

}