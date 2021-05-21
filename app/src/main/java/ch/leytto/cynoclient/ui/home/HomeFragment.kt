package ch.leytto.cynoclient.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ch.leytto.cynoclient.DogListAdapter
import ch.leytto.cynoclient.viewmodels.DogViewModel
import ch.leytto.cynoclient.CynoClientApplication
import ch.leytto.cynoclient.R
import ch.leytto.cynoclient.model.DogRepository
import ch.leytto.cynoclient.viewmodels.ViewModelFactory
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private val dogViewModel: DogViewModel by viewModels {
        ViewModelFactory((requireActivity().application as CynoClientApplication).dogRepository)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        println("HEY THERE !!!");
        getDogs(root);





        return root
    }
    fun getDogs(root: View) = GlobalScope.async {
        println("GetDogs...")
        launch {
            val recyclerView = root.findViewById<RecyclerView>(R.id.dogsList)
            val adapter = DogListAdapter()
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(context)
            println("HEY HEY THIS IS A DOG")
            println(dogViewModel.AllDogs)
            dogViewModel.AllDogs.forEach(){ dogs ->
                dogs.let { println(it.noun) }
            }
        }



    }
}