package ch.leytto.cynoclient.ui.form_create_dog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ch.leytto.cynoclient.R

class FormCreateDogFragment : Fragment() {

    private lateinit var formCreateDogViewModel: FormCreateDogViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        formCreateDogViewModel =
            ViewModelProvider(this).get(FormCreateDogViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_form_create_dog, container, false)
        return root
    }

}