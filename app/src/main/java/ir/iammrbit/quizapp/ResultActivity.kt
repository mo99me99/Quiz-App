package ir.iammrbit.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)



        val tvUserName :TextView = findViewById(R.id.tv_userName)
        val tvScore : TextView = findViewById(R.id.tv_score)
        val btnFinish : TextView = findViewById(R.id.btn_finish)

        tvUserName.text = intent.getStringExtra(Constants.USER_NAME)
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS , 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS , 0)
        intent.putExtra(Constants.CHECK_LIST , ArrayList<Boolean>(totalQuestions))
        tvScore.text  = "Your Score is $correctAnswers out of $totalQuestions"
        btnFinish.setOnClickListener{
            startActivity(Intent(this , MainActivity::class.java))
        }


    }
}