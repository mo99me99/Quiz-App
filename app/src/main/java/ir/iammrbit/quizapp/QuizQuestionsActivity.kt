package ir.iammrbit.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import ir.iammrbit.quizapp.databinding.ActivityQuizQuestionsBinding

class QuizQuestionsActivity : AppCompatActivity() {

    private var progressBar : ProgressBar?= null
    private var tvProgressBar:TextView? = null
    private var tvQuestion : TextView? = null
    private var ivImage : ImageView? = null

    private var tvOptionOne:TextView? = null
    private var tvOptionTow:TextView? = null
    private var tvOptionThree:TextView? = null
    private var tvOptionFour:TextView? = null


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

        val questionList = Constants.getQuestion()
        progressBar = binding.progressBar
        tvProgressBar = binding.tvProgress
        tvQuestion = binding.tvQuestion
        ivImage = binding.ivFlagImage
        tvOptionOne = binding.optionOne
        tvOptionTow = binding.optionTow
        tvOptionThree = binding.optionThree
        tvOptionFour = binding.optionFour

        for (question in questionList){
            Log.e("Questions" , question.question)
        }
        var currentPosition = 1
        val question : Question = questionList[currentPosition-1]

        ivImage?.setImageResource(question.image)
        progressBar?.progress = currentPosition
        tvProgressBar?.text  = "$currentPosition / ${progressBar?.max}"

        tvQuestion?.text = question.question
        tvOptionOne?.text = question.optionOne
        tvOptionTow?.text = question.optionTow
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour


    }
}