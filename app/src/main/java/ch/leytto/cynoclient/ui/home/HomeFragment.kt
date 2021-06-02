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

    /**
     * GRR :
     * Call the model factory
     */
    private val dogViewModel: DogViewModel by viewModels {
        ViewModelFactory((requireActivity().application as CynoClientApplication).dogRepository)
    }

    /**
     * GRR :
     * This function is called when fragment is created
     * @return View element
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        getDogs(root);





        return root
    }

    /**
     * GRR :
     * Get all dogs name and print it in the console. (this function must be async)
     * @param View View object
     * @return the new size of the group.
     */
    fun getDogs(root: View) = GlobalScope.async {
        launch {
            val recyclerView = root.findViewById<RecyclerView>(R.id.dogsList)
            val adapter = DogListAdapter()
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(context)
            dogViewModel.AllDogs.forEach(){ dogs ->
                dogs.let { println(it.noun) }
            }
        }



    }
}