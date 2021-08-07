package com.example.unquote;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int currentQuestionIndex;
    int totalCorrect;
    int totalQuestions;
    ImageView questionImageView;
    TextView questionTextView;
    TextView questionsRemainingTextView;
    Button answer0Button;
    Button answer1Button;
    Button answer2Button;
    Button answer3Button;
    ArrayList<Question> questions;
    Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // TODO Show app icon in ActionBar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_unquote_icon);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setElevation(0);

        setContentView(R.layout.activity_main);

        // TODO  assign View member variables
        questionImageView = findViewById(R.id.iv_main_question_image);
        questionTextView = findViewById(R.id.tv_main_question_title);
        questionsRemainingTextView = findViewById(R.id.tv_main_questions_remaining_count);
        answer0Button = findViewById(R.id.btn_main_answer_0);
        answer1Button = findViewById(R.id.btn_main_answer_1);
        answer2Button = findViewById(R.id.btn_main_answer_2);
        answer3Button = findViewById(R.id.btn_main_answer_3);
        submitButton = findViewById(R.id.btn_main_submit_answer);
        // TODO  set onClickListener for each answer Button
        answer0Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAnswerSelected(0);
            }
        });
        answer1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAnswerSelected(1);
            }
        });
        answer2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAnswerSelected(2);
            }
        });
        answer3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAnswerSelected(3);
            }
        });

        // TODO  set onClickListener for the submit  answer Button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onAnswerSubmission();
            }
        });

        startNewGame();
    }

    // TODO  displayQuestion(Question question) {...}
    public void displayQuestion(Question question) {
        questionImageView.setImageResource(question.imageId);
        questionTextView.setText(question.questionText);
        answer0Button.setText(question.answer0);
        answer1Button.setText(question.answer1);
        answer2Button.setText(question.answer2);
        answer3Button.setText(question.answer3);

    }
    //
    public  void displayQuestionsRemaining(int questionRemaining) {
        questionsRemainingTextView.setText(String.valueOf(questionRemaining));

    }
    // onAnswerSelected(int answerSelected) {...}
    @SuppressLint("SetTextI18n")
    public void onAnswerSelected(int answerSelected) {
        Question currentQuestion = getCurrentQuestion();
        currentQuestion.playerAnswer = answerSelected;
        if (answerSelected == 0) {
            answer0Button.setText("✔ " + currentQuestion.answer0);
            answer1Button.setText(currentQuestion.answer1);
            answer2Button.setText(currentQuestion.answer2);
            answer3Button.setText(currentQuestion.answer3);
         }
        else if (answerSelected == 1) {
            answer1Button.setText("✔ " + currentQuestion.answer1);
            answer0Button.setText(currentQuestion.answer0);
            answer2Button.setText(currentQuestion.answer2);
            answer3Button.setText(currentQuestion.answer3);
           }
        else if (answerSelected == 2) {
            answer2Button.setText("✔ " + currentQuestion.answer2);
            answer0Button.setText(currentQuestion.answer0);
            answer1Button.setText(currentQuestion.answer1);
            answer3Button.setText(currentQuestion.answer3);
        }
        else if (answerSelected == 3){
            answer3Button.setText("✔ " + currentQuestion.answer3);
            answer0Button.setText(currentQuestion.answer0);
            answer1Button.setText(currentQuestion.answer1);
            answer2Button.setText(currentQuestion.answer2);
        }

    }


    public void startNewGame() {
        Question question0 = new Question(R.drawable.img_quote_0,
                "How tall is the Eiffel tower?",
                "1024 ft",
                "1063 ft",
                "1124 ft",
                "1163 ft",
                1);
        Question question1 = new Question(R.drawable.img_quote_1,
                "Who invented the computer algorithm?",
                "Charles Babbage",
                "John Carmack",
                "Alan Turing",
                "Ada Lovelace",
                3);
        Question question2 = new Question(R.drawable.img_quote_2,
                "What is the name for the patch of skin found on your elbow?",
                "Elbow Skin",
                "Fascia Elbora",
                "Wenis",
                "Todd",
                2);
        Question question3  = new Question(R.drawable.img_quote_3, "Insanely inspiring, Insanely correct (maybe). Who is the true source of this inspiration?",
                "Nelson Mandela",
                "Harriet Tubman",
                "Mahatma Gandhi",
                "Nicholas Klein",
                3);
        Question question4 = new Question(R.drawable.img_quote_4,
                "A peace worth striving for ------ who actually reminded us of this?",
                "Malala Yousafzai",
                "Martin Luther King Jr.",
                "Liu Xiaobo",
                "Dalai Lama",
                1);
        Question question5 = new Question(R.drawable.img_quote_5,
                "Unfortunately true- but did Marilyn Monroe convey it or did someone else?",
                "Laurel Thatcher Ulrich",
               "Eleanor Roosevelt",
                "Marilyn Monroe",
                "Queen Victoria",
                0);
        Question question6 = new Question(R.drawable.img_quote_6,
                "Here's the truth, Will Smith did say this, but in which movie?",
                "Independence Day",
                "Bad Boys",
                "Men In Black",
                "The Pursuit of Happyness",
                2
                );
        Question question7 = new Question(R.drawable.img_quote_7,
                "Which TV funny gal actually quipped this one liner?",
                "Ellen Degeneres",
                "Amy Poehler",
                "Betty White",
                "Tina Fey",
                3);
        Question question8 = new Question(R.drawable.img_quote_8,
                "This mayor wont get my vote - but did he actually give this piece of advice? And if not, who did?",
                "Forrest Gump, Forrest Gump",
                "Dory, Finding Nemo",
                "Esther Williams",
                "The Mayor, Jaws",
                1);
        Question question9 = new Question(R.drawable.img_quote_9,
                "Her heart will go on, but whose heart is it?",
                "Whitney Houston",
                "Diana Ross",
                "Celine Dion",
                "Mariah Carey",
                0);
        Question question10 = new Question(R.drawable.img_quote_10,
                "He's the king of something alright- to whom does this self-titling line belong?",
                "Tony Montana, Scarface",
                "Joker, The Dark Knight",
                "Lex Luthor, Batman v Superman",
                "Jack, Titanic",
                3);
        Question question11 = new Question(R.drawable.img_quote_11,
        "Is \"Grey\" synonymous with \"wise\"? If so, maybe Gandalf did preach this advice. If not, who did?",
                "Yoda, Star Wars",
                "Gandalf the Grey, Lord of the Rings",
                "Dumbledore, Harry Potter",
                "Uncle Ben, Spiderman",
                0);
        Question question12 = new Question(R.drawable.img_quote_12,
                "Houston, we have a problem with this quote - which space-traveler does this catch-phrase actually belong to?",
                "Han Solo, Star Wars",
                "Captain Kirk, Star Trek",
                "Buzz Lightyear, Toy Story",
                "Jim Lovell, Apollo 13",
                2);

        questions = new ArrayList<Question>();
        questions.add(question0);
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);
        questions.add(question5);
        questions.add(question6);
        questions.add(question7);
        questions.add(question8);
        questions.add(question9);
        questions.add(question10);
        questions.add(question11);
        questions.add(question12);
        totalCorrect = 0;
        for (int i = 0; i < 7; i++) {
            int randomNumber = generateRandomNumber(questions.size());
            questions.remove(questions.get(randomNumber));
        }
        totalQuestions = questions.size();



        Question firstQuestion = chooseNewQuestion();
displayQuestion(firstQuestion);
 displayQuestionsRemaining(questions.size());
    }
    //
    public Question chooseNewQuestion() {
        int questionIndex = generateRandomNumber(questions.size());
        currentQuestionIndex = questionIndex;
        return questions.get(currentQuestionIndex);
    }
    //
    public Question getCurrentQuestion() {
        return questions.get(currentQuestionIndex);
    }
    //
    void onAnswerSubmission() {
        Question currentQuestion = getCurrentQuestion();
        if (currentQuestion.playerAnswer == -1) {
            return;

        }        if (currentQuestion.isCorrect()) {
            totalCorrect++;
        }
        questions.remove(currentQuestion);

        // TODO Uncomment the line below after implementing displayQuestionsRemaining(int)
         displayQuestionsRemaining(questions.size());

        if (questions.size() == 0) {
            String gameOverMessage = getGameOverMessage(totalCorrect, totalQuestions);

            // TODO  Show a popup instead
            AlertDialog.Builder gameOverDialogBuilder = new AlertDialog.Builder(MainActivity.this);
            gameOverDialogBuilder.setCancelable(false);
            gameOverDialogBuilder.setTitle("Game Over!");
            gameOverDialogBuilder.setMessage(getGameOverMessage(totalCorrect, totalQuestions));
            gameOverDialogBuilder.setPositiveButton("Play Again!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    startNewGame();
                }
            });
            gameOverDialogBuilder.create().show();
        } else {
            chooseNewQuestion();

            // TODO  uncomment after implementing displayQuestion(Question)
             displayQuestion(getCurrentQuestion());
        }
    }

    int generateRandomNumber(int max) {
        double randomNumber = Math.random();
        double result = max * randomNumber;
        return (int) result;
    }

    String getGameOverMessage(int totalCorrect, int totalQuestions) {
        if (totalCorrect == totalQuestions) {
            return "You got all " + totalQuestions + " right! You won!";
        } else {
            return "You got " + totalCorrect + " right out of " + totalQuestions + ". Better luck next time!";
        }
    }
}