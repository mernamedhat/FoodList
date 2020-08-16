package com.example.foodlist

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.food_ticket.*
import kotlinx.android.synthetic.main.food_ticket.view.*
import kotlinx.android.synthetic.main.food_ticket.view.name
import kotlinx.android.synthetic.main.title_ticket.view.*

class MainActivity : AppCompatActivity() {
    var Adapter:foodAdabter?=null

    var listoffood= ArrayList<food>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadoffood()

        Adapter= foodAdabter(listoffood,this)
        Gvfoods.adapter=Adapter
    }
    fun loadoffood(){
        //listoffood.add(food(name ="titleApp",des="General",image=R.drawable.merna))
        listoffood.add(food(name =" Coffee",des = "Coffee preparation   in  the the  process of  turning  coffe  beans ",
            image = R.drawable.merna
        ))
        listoffood.add(food(name =" Espreso",des = "Is a coffee-making method of Italian origin, in which a small amount of nearly boiling water is forced under pressure. ",
            image = R.drawable.maged
        ))
       // listoffood.add(food(name ="titleApp",des="Beverage",image=R.drawable.merna))
        listoffood.add(food(name =" Honey",des = " Is a eusocial flying insect within the genus Apis of the bee clade, all native to Eurasia but spread to four other continents by human beings. ",
            image = R.drawable.marit
        ))
        listoffood.add(food(name =" Tea",des = "Tea is an aromatic beverage commonly prepared by pouring hot or boiling water over cured. ",
            image = R.drawable.medhat
        ))

    }
   inner class foodAdabter:BaseAdapter {
        var context:Context?=null
        var listoffoodLocal= ArrayList<food>()
        constructor( listoffood: ArrayList<food> ,context:Context){
            listoffoodLocal=listoffood
            this.context=context

        }
        override fun getView(p0: Int, convertView: View?, parent: ViewGroup?): View {
            val food = listoffoodLocal[p0]
            /*if(food.name=="titleApp"){
                val inflator =
                    context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                val foodveiw = inflator.inflate(R.layout.title_ticket , null)
                foodveiw.txt.text=food.des
                return  foodveiw
            }else{*/
            val inflator =
                context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val foodveiw = inflator.inflate(R.layout.food_ticket, null)
            foodveiw.name.text = food.name!!
           // foodveiw.des.text = food.des!!
            foodveiw.merna.setImageResource(food.image!!)
            foodveiw.merna.setOnClickListener {
                val intent=Intent(context,foodActivity::class.java)
                intent.putExtra("name"  , food.name!!)
                intent.putExtra("des"  , food.des!!)
                intent.putExtra("merna"  , food.image!!)

                context!!.startActivity(intent)

              // delete(p0)
//                add(p0)
            }
            return foodveiw
           // }
        }

        override fun getItem(p0: Int): Any {
    return listoffoodLocal[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {

            return  listoffoodLocal.size
        }
  }

        fun delete(index:Int){
            listoffood.removeAt(index)
            Adapter!!.notifyDataSetChanged()

        }
    fun add(index: Int){
        listoffood.add(index,listoffood[index])
        Adapter!!.notifyDataSetChanged()
    }

    }


