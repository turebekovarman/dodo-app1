package com.example.dodo_app

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.dodo_app.databinding.FragmentPizzaDetailsBinding

class PizzaDetailsFragment:BaseFragment<FragmentPizzaDetailsBinding>(FragmentPizzaDetailsBinding::inflate) {

    /*override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_pizza_details, container, false)

        val smallSize = rootView.findViewById<TextView>(R.id.small_size)
        smallSize.setOnClickListener {
            val cd = smallSize.background as ColorDrawable
            val colorCode = cd.color
            if(smallSize.background.)
        }

        val mediumSize = rootView.findViewById<Button>(R.id.medium_size)
        mediumSize.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Clicked",
                Toast.LENGTH_SHORT
            ).show()
        }

        val largeSize = rootView.findViewById<Button>(R.id.large_size)
        largeSize.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Clicked",
                Toast.LENGTH_SHORT
            ).show()
        }

        return rootView
    }
    */

    private val args : PizzaDetailsFragmentArgs by navArgs()
    override fun onBindView() {
        super.onBindView()
        with(binding){
            title.text = args.title
            mainImg.setImageResource(args.img)
            price.text = "Add to cart for "+args.price+" KZT"
            desc.text = args.desc
            size.text = args.size
            backBtn.setOnClickListener {
                findNavController().popBackStack()
            }
            price.setOnClickListener {
                Toast.makeText(requireContext(), "Pizza is added to your cart", Toast.LENGTH_SHORT).show()
            }
        }
    }
}