package com.example.wordle

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.github.jinatonic.confetti.CommonConfetti
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    var  counter =1 ;
    var randomWord = FourLetterWordList.getRandomFourLetterWord()

    /**
     * Parameters / Fields:
     *   wordToGuess : String - the target word the user is trying to guess
     *   guess : String - what the user entered as their guess
     *
     * Returns a String of 'O', '+', and 'X', where:
     *   'O' represents the right letter in the right place
     *   '+' represents the right letter in the wrong place
     *   'X' represents a letter not in the target word
     */
    private fun checkGuess(guess: String,wordToGuess:String) : String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                print(guess[i] in wordToGuess)
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //variables
        val correctTextView = findViewById<TextView>(R.id.correctWord);
        val textInput =  findViewById<EditText>(R.id.editTextTextPersonName)
        val enterButton =  findViewById<Button>(R.id.enterButton);
        val resetButton =  findViewById<Button>(R.id.resetButton);
        val card =  findViewById<CardView>(R.id.cardView)
        correctTextView.text = randomWord

        enterButton.setOnClickListener {
            var guess =  textInput.text.toString().uppercase();
            if(textInput.text.length<4||textInput.text.length>4){
                Toast.makeText(this,"Your word must  have 4 charactters",Toast.LENGTH_LONG).show();

            }else{
                var result = checkGuess(guess.uppercase(), randomWord)
                if(result=="OOOO"){
                    correctTextView.visibility = View.VISIBLE;
                    card.visibility = View.VISIBLE;
                    enterButton.isEnabled = false;
                    resetButton.isEnabled =true;
                    correctTextView.visibility = View.VISIBLE;
                    card.visibility = View.VISIBLE;
                    enterButton.isEnabled = false;
                    resetButton.isEnabled =true;
                    findViewById<TextView>(R.id.guess1_sign).visibility =View.VISIBLE
                    findViewById<TextView>(R.id.guess1checks).visibility = View.VISIBLE
                    findViewById<TextView>(R.id.guess1checkResult).visibility = View.VISIBLE
                    findViewById<TextView>(R.id.guess1).visibility = View.VISIBLE
                    //setters
                    findViewById<TextView>(R.id.guess1).text =  textInput.text
                    findViewById<TextView>(R.id.guess1checkResult).text = result
                    hide()
                    val snack = Snackbar.make(it,"CONGRATULATIONS , You Guessed!",Snackbar.LENGTH_LONG)
                    CommonConfetti.rainingConfetti(findViewById(R.id.ccc),intArrayOf( Color.rgb(33, 146, 255),Color.rgb(56, 229, 77),Color.rgb(156, 255, 46),Color.rgb(253, 255, 0),Color.rgb(255, 30, 30),Color.rgb(255, 198, 0)) )
                        .stream(10500)
                    snack.setBackgroundTint(Color.rgb(0, 51, 124))
                    snack.setTextColor(Color.rgb(3, 201, 136))
                    snack.show()
                }
                else{
                    when (counter) {
                        1 -> {
                            findViewById<TextView>(R.id.guess1_sign).visibility =View.VISIBLE
                            findViewById<TextView>(R.id.guess1checks).visibility = View.VISIBLE
                            findViewById<TextView>(R.id.guess1checkResult).visibility = View.VISIBLE
                            findViewById<TextView>(R.id.guess1).visibility = View.VISIBLE
                            //setters
                            findViewById<TextView>(R.id.guess1).text =  textInput.text
                            findViewById<TextView>(R.id.guess1checkResult).text = result



                        }
                        2 -> {
                            findViewById<TextView>(R.id.guess2_sign).visibility =View.VISIBLE
                            findViewById<TextView>(R.id.guess2checks).visibility = View.VISIBLE
                            findViewById<TextView>(R.id.guess2checkResult).visibility = View.VISIBLE
                            findViewById<TextView>(R.id.guess2).visibility = View.VISIBLE
                            //setters
                            findViewById<TextView>(R.id.guess2).text =  textInput.text
                            findViewById<TextView>(R.id.guess2checkResult).text = result



                        }
                        3 -> {
                            findViewById<TextView>(R.id.guess3_sign).visibility =View.VISIBLE
                            findViewById<TextView>(R.id.guess3checks).visibility = View.VISIBLE
                            findViewById<TextView>(R.id.guess3checkResult).visibility = View.VISIBLE
                            findViewById<TextView>(R.id.guess3).visibility = View.VISIBLE
                            //setters
                            findViewById<TextView>(R.id.guess3).text =  textInput.text
                            findViewById<TextView>(R.id.guess3checkResult).text = result



                        }
                        4->{
                            Toast.makeText(this,"You have used your attempts",Toast.LENGTH_LONG).show();
                        }

                    }
                    counter++;
                    //close the keyboard
                   hide()
                    textInput.text.clear();
                    if(counter==4){
                        correctTextView.visibility = View.VISIBLE;
                        card.visibility = View.VISIBLE;
                        enterButton.isEnabled = false;
                        resetButton.isEnabled =true;


                    }
                }


            }


        }
        findViewById<Button>(R.id.resetButton).setOnClickListener{

            counter =1;
            randomWord =FourLetterWordList.getRandomFourLetterWord()
            textInput.text.clear()
            correctTextView.text = randomWord
            correctTextView.visibility =View.INVISIBLE
            card.visibility = View.INVISIBLE;



            findViewById<TextView>(R.id.guess1_sign).visibility =View.INVISIBLE
            findViewById<TextView>(R.id.guess1checks).visibility = View.INVISIBLE
            findViewById<TextView>(R.id.guess1checkResult).visibility = View.INVISIBLE
            findViewById<TextView>(R.id.guess1).visibility = View.INVISIBLE
            //sets
            findViewById<TextView>(R.id.guess1).text =  ""
            findViewById<TextView>(R.id.guess1checkResult).text = " "
            findViewById<TextView>(R.id.guess2_sign).visibility =View.INVISIBLE
            findViewById<TextView>(R.id.guess2checks).visibility = View.INVISIBLE
            findViewById<TextView>(R.id.guess2checkResult).visibility = View.INVISIBLE
            findViewById<TextView>(R.id.guess2).visibility = View.INVISIBLE
            //sets
            findViewById<TextView>(R.id.guess2).text =  " "
            findViewById<TextView>(R.id.guess2checkResult).text = " "
            findViewById<TextView>(R.id.guess3_sign).visibility =View.INVISIBLE
            findViewById<TextView>(R.id.guess3checks).visibility = View.INVISIBLE
            findViewById<TextView>(R.id.guess3checkResult).visibility = View.INVISIBLE
            findViewById<TextView>(R.id.guess3).visibility = View.INVISIBLE
            //SETTS
            findViewById<TextView>(R.id.guess3).text = ""
            findViewById<TextView>(R.id.guess3checkResult).text = ""
            enterButton.isEnabled = true;
            resetButton.isEnabled =false;

        }

    }

    fun hide(){
        val imm: InputMethodManager =
            this.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        //Find the currently focused view, so we can grab the correct window token from it.
        //Find the currently focused view, so we can grab the correct window token from it.
        var view: View? = this.getCurrentFocus()
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = View(this)
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }

}