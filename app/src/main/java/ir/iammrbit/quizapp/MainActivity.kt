package ir.iammrbit.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import ir.iammrbit.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //FullScreen
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //binding setup
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//        code of application
        val btn_start = binding.btnStart
        val et_name = binding.etName

        btn_start.setOnClickListener {
            if (et_name.text?.isEmpty()  == true)
                Toast.makeText(this , "Please enter your name!", Toast.LENGTH_SHORT).show()
            else{
                val intent = Intent(this , QuizQuestionsActivity::class.java)
                startActivity(intent)
                //finish()

            }
        }



    }
}
