package com.skill_factory.unit3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.skill_factory.unit3.adapter.Product
import com.skill_factory.unit3.adapter.ProductAdapter
import com.skill_factory.unit3.adapter.ProductDiff
import com.skill_factory.unit3.animator.MyItemAnimator
import com.skill_factory.unit3.databinding.ActivityMainBinding

val adapter = ProductAdapter(
    arrayListOf(
        Product(
            0,
            R.drawable.ic_apple,
            "Apple",
            "Juicy Apple fruit, which is eaten fresh, serves as a raw material in cooking and for making drinks."
        ),
        Product(
            1,
            R.drawable.ic_banana,
            "Banana",
            "It is one of the oldest food crops, and for tropical countries it is the most important food plant and the main export item."
        ),
        Product(
            2,
            R.drawable.ic_lemon,
            "Lemon",
            "Lemons are eaten fresh, and are also used in the manufacture of confectionery and soft drinks, in the liquor and perfume industry."
        ),
        Product(
            3,
            R.drawable.ic_pear,
            "Pear",
            "Under favorable conditions, the pear reaches a large size-up to 5-25 meters in height and 5 meters in diameter of the crown."
        ),
        Product(
            4,
            R.drawable.ic_strawberry,
            "Strawberry",
            "A perennial herbaceous plant 5-20 cm high, with a thick brown rhizome. \"Mustache\" is short. The stem is thin."
        ),
        Product(
            5,
            R.drawable.ic_orange,
            "Orange",
            "Orange juice is widely used as a drink in restaurants and cafes."
        )
    )
)

fun updateData(newList: ArrayList<Product>) {
    val oldList: ArrayList<Product> = adapter.data
    val productDiff = ProductDiff(oldList, newList)
    val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(productDiff)
    adapter.data = newList
    diffResult.dispatchUpdatesTo(adapter)
}


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.layoutManager =
            GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.itemAnimator = MyItemAnimator(applicationContext)




        binding.add.setOnClickListener {

            val newList: ArrayList<Product> = arrayListOf()
            newList.addAll(adapter.data)
            newList.set(
                getIndex(),
                Product(
                    adapter.data.size,
                    R.drawable.ic_apple,
                    "Apple",
                    "Orange juice is widely used as a drink in restaurants and cafes."
                )
            )
            updateData(newList)
        }

        binding.change.setOnClickListener {
            val newList: ArrayList<Product> = arrayListOf<Product>()
            newList.addAll(adapter.data)
            newList[getIndex()] = Product(
                adapter.data.size,
                R.drawable.ic_orange,
                "Orange",
                "sdjhfhjdshfjudshfdsjukhfdsjufhdus"
            )
            updateData(newList)
        }

        binding.remove.setOnClickListener {
            val newList: ArrayList<Product> = arrayListOf<Product>()
            newList.addAll(adapter.data)
            newList.removeAt(getIndex())
            updateData(newList)
        }


    }

    private fun getIndex(): Int {
        val itemIndex: EditText = binding.itemIndex
        return itemIndex.text.toString().toInt()
    }


}
