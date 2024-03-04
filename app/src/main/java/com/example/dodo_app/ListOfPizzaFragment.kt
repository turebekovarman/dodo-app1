package com.example.dodo_app

import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dodo_app.databinding.FragmentListOfPizzaBinding
import com.example.dodo_app.model.Pizza

class ListOfPizzaFragment:BaseFragment<FragmentListOfPizzaBinding>(FragmentListOfPizzaBinding::inflate) {
    override fun onBindView() {
        super.onBindView()
        val adapter = PizzaAdapter()
        binding.listPizza.adapter = adapter
        binding.listPizza.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        adapter.submitList(getList())
        adapter.itemClick = {it ->
            findNavController().navigate(ListOfPizzaFragmentDirections.actionListOfPizzaFragmentToPizzaDetailsFragment(it.title, it.img, it.desc,it.price, it.size))
        }
        binding.editText.setOnEditorActionListener(TextView.OnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH){
                if(binding.editText.text!!.isNotEmpty()){
                    adapter.submitList(searchPizza(binding.editText.text.toString()))
                }
                else{
                    Toast.makeText(requireContext(), "Enter the pizza name", Toast.LENGTH_SHORT).show()
                }
            }

            false
        })
    }

    private fun getList():List<Pizza>{
        return listOf(
            Pizza("Chorizo fresh", R.drawable.img, "Spicy chorizo, sweet pepper, mozzarella cheese, marinara sauce", 2900, "Medium" ),
            Pizza("Chicken ", R.drawable.img_1, "Double chicken, mozzarella cheese, Alfredo sauce", 2500, "Medium" ),
            Pizza("Bavarian ", R.drawable.img_2, "Spicy chorizo, pickles, red onion, tomatoes, mustard sauce, mozzarella cheese, marinara sauce", 3500, "Large" ),
            Pizza("Ham & Cheese", R.drawable.img_3, "Chicken ham, mozzarella cheese, Alfredo sauce", 2000, "Small" ),
            Pizza("Ham & Cheese", R.drawable.img_3, "Chicken ham, mozzarella cheese, Alfredo sauce", 2000, "Small" ),
            Pizza("Ham & Cheese", R.drawable.img_3, "Chicken ham, mozzarella cheese, Alfredo sauce", 2000, "Small" ),
            Pizza("Ham & Cheese", R.drawable.img_3, "Chicken ham, mozzarella cheese, Alfredo sauce", 2000, "Small" ),
            Pizza("Ham & Cheese", R.drawable.img_3, "Chicken ham, mozzarella cheese, Alfredo sauce", 2000, "Small" ),
            Pizza("Ham & Cheese", R.drawable.img_3, "Chicken ham, mozzarella cheese, Alfredo sauce", 2000, "Small" ),
        )
    }
    private fun searchPizza(input: String):List<Pizza>{
        val pizzas = getList()
        return pizzas.filter{pizza->
            pizza.title.contains(input, ignoreCase = true)
        }
    }
}