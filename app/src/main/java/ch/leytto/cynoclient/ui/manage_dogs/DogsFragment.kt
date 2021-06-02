package ch.leytto.cynoclient.ui.manage_dogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import ch.leytto.cynoclient.CynoClientApplication
import ch.leytto.cynoclient.R
import ch.leytto.cynoclient.db.entities.Dog
import ch.leytto.cynoclient.viewmodels.DogViewModel
import ch.leytto.cynoclient.viewmodels.ViewModelFactory
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

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
        val textView: TextView = root.findViewById(R.id.text_dogs)
        dogsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        insertDog();

        return root
    }

    fun insertDog() = GlobalScope.async {
        launch {
            val d = Dog(15,"Andi",true,"31.03.2222,",true,false,"brown",false,2,1,1)
            dogViewModel.insert(d)
            dogViewModel.AllDogs.observe(viewLifecycleOwner, Observer<List<Dog>>{
                it.forEach()
                {
                    println(it.noun)
                }
            })
        }



    }
    fun getDogs(root: View) = GlobalScope.async {
        println("GetDogs...")
        launch {

          /*  dogViewModel.AllDogs.forEach(){ dogs ->
                dogs.let { println(it.noun) }
            }*/
        }



    }


}