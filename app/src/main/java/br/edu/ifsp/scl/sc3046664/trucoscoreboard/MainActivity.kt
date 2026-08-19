package br.edu.ifsp.scl.sc3046664.trucoscoreboard

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    var team1Score = 0
    var team2Score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val team1Name = findViewById<EditText>(R.id.team1Name)
        val team1ScoreText = findViewById<TextView>(R.id.team1Score)
        val team1PlusOne = findViewById<Button>(R.id.team1PlusOne)
        val team1PlusThree = findViewById<Button>(R.id.team1PlusThree)

        val team2Name = findViewById<EditText>(R.id.team2Name)
        val team2ScoreText = findViewById<TextView>(R.id.team2Score)
        val team2PlusOne = findViewById<Button>(R.id.team2PlusOne)
        val team2PlusThree = findViewById<Button>(R.id.team2PlusThree)

        val resetButton = findViewById<Button>(R.id.resetButton)

        team1PlusOne.setOnClickListener {
            team1Score++

            team1ScoreText.text = team1Score.toString()

            team1PlusOne.isEnabled = team1Score < 12
            team1PlusThree.isEnabled = team1Score < 11

            if (team1Score == 11) {
                showMessage("${team1Name.text} está na mão de 11!")
            }

            if (team1Score == 12) {
                showMessage("${team1Name.text} venceu!")

                team1PlusOne.isEnabled = false
                team1PlusThree.isEnabled = false

                team2PlusOne.isEnabled = false
                team2PlusThree.isEnabled = false
            }
        }

        team1PlusThree.setOnClickListener {
            team1Score = minOf(team1Score + 3, 12)

            team1ScoreText.text = team1Score.toString()

            team1PlusOne.isEnabled = team1Score < 12
            team1PlusThree.isEnabled = team1Score < 11

            if (team1Score == 11) {
                showMessage("${team1Name.text} está na mão de 11!")
            }

            if (team1Score == 12) {
                showMessage("${team1Name.text} venceu!")

                team1PlusOne.isEnabled = false
                team1PlusThree.isEnabled = false

                team2PlusOne.isEnabled = false
                team2PlusThree.isEnabled = false
            }
        }

        team2PlusOne.setOnClickListener {
            team2Score++

            team2ScoreText.text = team2Score.toString()

            team2PlusOne.isEnabled = team2Score < 12
            team2PlusThree.isEnabled = team2Score < 11

            if (team2Score == 11) {
                showMessage("${team2Name.text} está na mão de 11!")
            }

            if (team2Score == 12) {
                showMessage("${team2Name.text} venceu!")

                team1PlusOne.isEnabled = false
                team1PlusThree.isEnabled = false

                team2PlusOne.isEnabled = false
                team2PlusThree.isEnabled = false
            }
        }

        team2PlusThree.setOnClickListener {
            team2Score = minOf(team2Score + 3, 12)

            team2ScoreText.text = team2Score.toString()

            team2PlusOne.isEnabled = team2Score < 12
            team2PlusThree.isEnabled = team2Score < 11

            if (team2Score == 11) {
                showMessage("${team2Name.text} está na mão de 11!")
            }

            if (team2Score == 12) {
                showMessage("${team2Name.text} venceu!")

                team1PlusOne.isEnabled = false
                team1PlusThree.isEnabled = false

                team2PlusOne.isEnabled = false
                team2PlusThree.isEnabled = false
            }
        }

        resetButton.setOnClickListener {
            team1Score = 0
            team2Score = 0

            team1ScoreText.text = "0"
            team2ScoreText.text = "0"

            team1PlusOne.isEnabled = true
            team1PlusThree.isEnabled = true
            team2PlusOne.isEnabled = true
            team2PlusThree.isEnabled = true
        }

    }

    private fun showMessage(message: String) {
        AlertDialog.Builder(this)
            .setMessage(message)
            .setPositiveButton("OK", null)
            .show()
    }
}