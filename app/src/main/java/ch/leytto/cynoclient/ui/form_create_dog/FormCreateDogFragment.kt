package ch.leytto.cynoclient.ui.form_create_dog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ch.leytto.cynoclient.BreedListAdapter
import ch.leytto.cynoclient.CynoClientApplication
import ch.leytto.cynoclient.R
import ch.leytto.cynoclient.db.entities.Dog
import ch.leytto.cynoclient.viewmodels.BreedViewModel
import ch.leytto.cynoclient.viewmodels.DogViewModel
import ch.leytto.cynoclient.viewmodels.ViewModelFactory


class FormCreateDogFragment : Fragment() {

    private val dogViewModel: DogViewModel by viewModels {
        ViewModelFactory((requireActivity().application as CynoClientApplication).dogRepository)
    }

    private val breedViewModel: BreedViewModel by viewModels {
        ViewModelFactory((requireActivity().application as CynoClientApplication).breedRepository)
    }

    private lateinit var formCreateDogViewModel: FormCreateDogViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        formCreateDogViewModel =
            ViewModelProvider(this).get(FormCreateDogViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_form_create_dog, container, false)

        // Display breeds in a recycler view
        val listViewBreeds = root.findViewById<RecyclerView>(R.id.list_view_breeds)
        val adapterBreeds = BreedListAdapter()
        listViewBreeds.adapter = adapterBreeds
        listViewBreeds.layoutManager = LinearLayoutManager(context)
        breedViewModel.AllBreeds.observe(viewLifecycleOwner) { breeds ->
            breeds.let{ adapterBreeds.submitList(it) }
        }

        // On click create the dog
        val btnCreate = root.findViewById<Button>(R.id.button_create_dog)
        btnCreate.setOnClickListener(View.OnClickListener {
            // Get textView from view
            val inputDogName = root.findViewById<TextView>(R.id.input_dog_name) as EditText
            val inputBirthdate = root.findViewById<TextView>(R.id.input_birthdate) as EditText
            val inputDogColor = root.findViewById<TextView>(R.id.input_dog_color) as EditText

            // Get checkBox from view
            val checkboxSterilized = root.findViewById(R.id.checkbox_sterilized) as CheckBox
            val checkboxChemical = root.findViewById(R.id.checkbox_chemical) as CheckBox

            // Get radio from radioGroup from view
            val radioGroup = root.findViewById<RadioGroup>(R.id.radio_dog_gender);
            // Get selected radio button from radioGroup
            val selectedId: Int = radioGroup.checkedRadioButtonId

            // Find the radiobutton by returned id
            val radioButton = root.findViewById(selectedId) as RadioButton

            // Dog who is going to be created
            val d = Dog(0,
                inputDogName.text.toString(),
                (radioButton.text == getString(R.string.form_create_dog_radio_female)),
                inputBirthdate.text.toString(),
                checkboxSterilized.isChecked,
                checkboxChemical.isChecked,
                inputDogColor.text.toString(),
                false,
                2, // TODO
                1,  // TODO
                1  // TODO
            )

            // Create the dog
            dogViewModel.insert(d)
        })

        return root
    }
}