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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ch.leytto.cynoclient.CynoClientApplication
import ch.leytto.cynoclient.DogListAdapter
import ch.leytto.cynoclient.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ch.leytto.cynoclient.db.entities.Dog
import ch.leytto.cynoclient.ui.form_create_dog.FormCreateDogViewModel
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
        dogsViewModel =
            ViewModelProvider(this).get(DogsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_manage_dogs, container, false)
        val recyclerView = root.findViewById<RecyclerView>(R.id.list_dogs)
        val adapter = DogListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        dogViewModel.AllDogs.observe(viewLifecycleOwner, Observer { dogs ->
            dogs?.let { adapter.submitList(it) }
        })



        val mFab = root.findViewById<FloatingActionButton>(R.id.fab_redirect_to_new_dog)
        mFab.setOnClickListener {
            root.findNavController().navigate(R.id.nav_home_page)
        }

        //insertDog();
        return root
    }

    private fun insertDog()  {
        val d = Dog(0,"MONPETITCHOU",true,"31.03.2222,",true,false,"brown",false,2,1,1)
        dogViewModel.insert(d)
        println()
    }

}