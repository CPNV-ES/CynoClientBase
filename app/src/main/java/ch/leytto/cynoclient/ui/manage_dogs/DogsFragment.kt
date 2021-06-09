package ch.leytto.cynoclient.ui.manage_dogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import ch.leytto.cynoclient.CynoClientApplication
import ch.leytto.cynoclient.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ch.leytto.cynoclient.db.entities.Dog
import ch.leytto.cynoclient.viewmodels.DogViewModel
import ch.leytto.cynoclient.viewmodels.ViewModelFactory

class DogsFragment : Fragment() {

    private val dogViewModel: DogViewModel by viewModels {
        ViewModelFactory((requireActivity().application as CynoClientApplication).dogRepository)
    }
    private lateinit var dogsViewModel: DogsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_manage_dogs, container, false)
        val textView: TextView = root.findViewById(R.id.text_dogs)
        dogsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })


        val mFab = root.findViewById<FloatingActionButton>(R.id.fab_redirect_to_new_dog)
        mFab.setOnClickListener {
            val fragmentManager = activity?.supportFragmentManager
            val fragment = fragmentManager?.findFragmentById(R.id.nav_manage_dogs)
            println(fragmentManager)
            fragmentManager?.commit {
                replace(R.id.mobile_navigation, fragment!!)
                setReorderingAllowed(true)
                addToBackStack("Home")
            }
        }

        insertDog();
        listDog();
        return root
    }

    fun insertDog()  {
        val d = Dog(0,"MONPETITCHOU",true,"31.03.2222,",true,false,"brown",false,2,1,1)
        dogViewModel.insert(d)
        println()
    }


    fun listDog()
    {
        //Using observer to do something when data are modified
        //Observer doesn't need a coroutin cause room already do it
        dogViewModel.AllDogs.observe(viewLifecycleOwner) { dogs ->
            for (dog in dogs) {
                println(dog.noun)
            }
        }
    }


}