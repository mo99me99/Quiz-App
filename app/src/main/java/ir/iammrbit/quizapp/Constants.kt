package ir.iammrbit.quizapp

import android.graphics.drawable.Drawable
import android.graphics.drawable.TransitionDrawable
import android.widget.ImageView
import androidx.core.util.rangeTo

object Constants {

    fun getQuestion():ArrayList<Question>{

       val questionsList = ArrayList<Question>()
        val que1 = Question(
            1,"What country does this flag belongs to ?",
            R.drawable.ic_flag_of_djibouti,
            "Djibouti" ,"Germany",
            "Qatar"  , "Afghanistan",
            1
        )
       
        val que2 = Question(
            2,"What country does this flag belongs to ?",
            R.drawable.ic_flag_of_us,
            "France", "Germany"  ,
            "Poland", "US",
            4
        )
       
        val que3 = Question(
            3,"What country does this flag belongs to ?",
            R.drawable.ic_flag_of_jamaica,
            "Libya" ,"Fiji",
            "Jamaica"  , "Peru",
            3
        )
       
        val que4 = Question(
            4,"What country does this flag belongs to ?",
            R.drawable.ic_flag_of_belarus,
            "Greece" ,"Ghana",
            "Zambia"  , "Belarus",
            4
        )
       
        val que5 = Question(
            5,"What country does this flag belongs to ?",
            R.drawable.ic_flag_of_croatia,
            "Croatia" ,"Netherlands",
            "Slovakia"  , "Ostrich",
            1
        )
       
        val que6 = Question(
            6,"What country does this flag belongs to ?",
            R.drawable.ic_flag_of_colombia,
            "Estonia" ,"Colombia",
            "New Zealand"  , "Mongolia",
            2
        )
       
        val que7 = Question(
            7,"What country does this flag belongs to ?",
            R.drawable.ic_flag_of_israel,
            "Bahrain" ,"Israel",
            "Syria"  , "Palestine",
            2
        )
       
        val que8 = Question(
            8,"What country does this flag belongs to ?",
            R.drawable.ic_flag_of_zambia,
            "Ghana" ,"Zambia",
            "Yemen"  , "Angola",
            2
        )
       
        val que9 = Question(
            9,"What country does this flag belongs to ?",
            R.drawable.ic_flag_of_libya,
            "Nigeria" ,"Pakistan",
            "Libya"  , "Turkey",
            3
        )
       
        val que10 = Question(
            1,"What country does this flag belongs to ?",
            R.drawable.ic_flag_of_iceland,
            "Finland" ,"Iceland",
            "Sweden"  , "England",
            2
        )
        
        questionsList.add(que1)
        questionsList.add(que2)
        questionsList.add(que3)
        questionsList.add(que4)
        questionsList.add(que5)
        questionsList.add(que6)
        questionsList.add(que7)
        questionsList.add(que8)
        questionsList.add(que9)
        questionsList.add(que10)
        return questionsList
    }

}