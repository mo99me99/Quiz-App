package ir.iammrbit.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import ir.iammrbit.quizapp.databinding.ActivityQuizQuestionsBinding
import kotlin.math.log

class QuizQuestionsActivity : AppCompatActivity(),View.OnClickListener {

    private var mUserName : String? = null
    private var mCorrectAnswers : Int = 0

    private var mCurrentPosition : Int = 1
    private var mQuestionList : ArrayList<Question>? = null
    private var mSelectedOptionPosition : Int = 0
    private var mCheckList :ArrayList<Boolean> = ArrayList()

    private var progressBar : ProgressBar?= null
    private var tvProgressBar:TextView? = null
    private var tvQuestion : TextView? = null
    private var ivImage : ImageView? = null

    private var tvOptionOne:TextView? = null
    private var tvOptionTow:TextView? = null
    private var tvOptionThree:TextView? = null
    private var tvOptionFour:TextView? = null


    private var btnSubmit :Button? =null


    private lateinit var binding: ActivityQuizQuestionsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //FullScreen
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //binding setup
        binding = ActivityQuizQuestionsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        mCurrentPosition = 1
        progressBar = binding.progressBar
        tvProgressBar = binding.tvProgress
        tvQuestion = binding.tvQuestion
        ivImage = binding.ivFlagImage
        tvOptionOne = binding.optionOne
        tvOptionTow = binding.optionTow
        tvOptionThree = binding.optionThree
        tvOptionFour = binding.optionFour
        btnSubmit = binding.btnSubmit

        tvOptionOne?.setOnClickListener(this)
        tvOptionTow?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        mQuestionList = Constants.getQuestions()
        for (i in 1..mQuestionList!!.size){
            mCheckList.add(false)
        }
        setQuestion()
        defaultOptionView()


    }

    private fun setQuestion() {
        defaultOptionView()
        val question: Question = mQuestionList!![mCurrentPosition - 1]
        ivImage?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        tvProgressBar?.text = "$mCurrentPosition / ${progressBar?.max}"

        tvQuestion?.text = question.question
        tvOptionOne?.text = question.optionOne
        tvOptionTow?.text = question.optionTow
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour

        if (mCurrentPosition == mQuestionList!!.size){
            btnSubmit?.text  = "FINISH"
        }else{
            btnSubmit?.text = "SUBMIT"
        }
    }

    private fun defaultOptionView(){
        val options = ArrayList<TextView>()
        tvOptionOne?.let {
            options.add(0 , it)
        }
        tvOptionTow?.let {
            options.add(1 , it)
        }
        tvOptionThree?.let {
            options.add(2 , it)
        }
        tvOptionFour?.let {
            options.add(3 , it)
        }
        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this , R.drawable.default_option_border_bg
            )
        }
    }

    private fun selectedOptionView(tv : TextView, selectedOptionNum : Int){
        defaultOptionView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface , Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_bg
        )
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.option_one -> {tvOptionOne?.let {selectedOptionView(it,1)}}
            R.id.option_tow -> {tvOptionTow?.let {
                selectedOptionView(it,2)
                 }
            }
            R.id.option_three -> {tvOptionThree?.let {selectedOptionView(it,3)}}
            R.id.option_four -> {tvOptionFour?.let {selectedOptionView(it,4)}}
            R.id.btn_submit -> {
                if(mSelectedOptionPosition == 0 || mCheckList[mCurrentPosition-1]){
                    mCurrentPosition++
                    if (mCurrentPosition <= mQuestionList!!.size){
                        setQuestion()
                    }else{
                       val intent = Intent(this , ResultActivity::class.java)
                        intent.putExtra(Constants.USER_NAME , mUserName)
                        intent.putExtra(Constants.CORRECT_ANSWERS ,mCorrectAnswers )
                        intent.putExtra(Constants.TOTAL_QUESTIONS , mQuestionList?.size)
                        intent.putExtra(Constants.CHECK_LIST, mCheckList)
                        startActivity(intent)
                        finish()
                    }
                }else{
                    val question = mQuestionList?.get(mCurrentPosition-1)
                    if (question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition , R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer , R.drawable.correct_option_border_bg)
                    if(mCurrentPosition == mQuestionList!!.size){
                        btnSubmit?.text = "FINISH"
                    }else{
                        btnSubmit?.text = "NEXT"
                    }
                    mCheckList[mCurrentPosition-1] = true
                    mSelectedOptionPosition = 0
                }
            }
        }

    }
    private fun answerView(answer : Int , drawableView : Int){
        when(answer){
            1 -> tvOptionOne!!.background = ContextCompat.getDrawable( this, drawableView)
            2 -> tvOptionTow!!.background = ContextCompat.getDrawable(this , drawableView)
            3 -> tvOptionThree!!.background = ContextCompat.getDrawable(this , drawableView)
            4 -> tvOptionFour!!.background = ContextCompat.getDrawable(this , drawableView)

        }
    }
}



