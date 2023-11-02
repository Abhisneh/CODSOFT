import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class Question {
    private String questionText;
    private List<String> options;
    private int correctOption;

    public Question(String questionText, List<String> options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }
}

public class QuizApplication {
    private List<Question> questions;
    private int currentQuestionIndex;
    private int score;
    private Timer timer;
    private boolean quizOver;

    public QuizApplication() {
        questions = new ArrayList<>();

        questions.add(new Question("What is the capital of France?", List.of("A) London", "B) Berlin", "C) Paris", "D) Madrid"), 2));
        questions.add(new Question("What is the capital of India?", List.of("A) Delhi", "B) Kolkata", "C) Bengaluru", "D) Chennai"), 0));
        questions.add(new Question("What is the capital of Bangladesh?", List.of("A) Chittagong", "B) Male", "C) Dhaka", "D) Neypida"), 2));
        questions.add(new Question("What is the capital of Australia?", List.of("A) Sydney", "B) Perth", "C) Melbourne", "D) Canberra"), 3));
        questions.add(new Question("What is the capital of United States of America?", List.of("A) New York", "B) Washington DC", "C) Mexico", "D) Florida"), 1));

        currentQuestionIndex = 0;
        score = 0;
        timer = new Timer();
        quizOver = false;
    }

    public void startQuiz() {
        if (!quizOver && currentQuestionIndex < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex);
            displayQuestion(currentQuestion);
            startTimer(currentQuestion);
        } else if (!quizOver) {
            quizOver = true;
            displayResult();
        }
    }

    private void displayQuestion(Question question) {
        System.out.println(question.getQuestionText());
        for (String option : question.getOptions()) {
            System.out.println(option);
        }
    }

    private void startTimer(Question question) {
        int timeLimit = 30;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time's up!");
                nextQuestion();
            }
        }, timeLimit * 1000);
    }

    private void getUserAnswer(Question question) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter your choice (A/B/C/D) or 'Q' to quit: ");
            String userChoice = scanner.nextLine().toUpperCase();

            if (userChoice.equals("Q")) {
                quizOver = true;
                displayResult();
            } else if (userChoice.equals("A") || userChoice.equals("B") || userChoice.equals("C") || userChoice.equals("D")) {
                int correctOptionIndex = question.getCorrectOption();
                if (userChoice.charAt(0) - 'A' == correctOptionIndex) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Incorrect! The correct answer is: " + question.getOptions().get(correctOptionIndex));
                }
                timer.cancel();
                nextQuestion();
            } else {
                System.out.println("Invalid choice. Please select A, B, C, D, or Q to quit.");
                getUserAnswer(question);
            }
        }
    }

    private void nextQuestion() {
        currentQuestionIndex++;
        startQuiz();
    }

    private void displayResult() {
        System.out.println("Quiz completed!");
        System.out.println("Your Score: " + score + "/" + questions.size());
        System.out.println("Correct Answers: " + score);
        System.out.println("Incorrect Answers: " + (questions.size() - score));
    }

    public static void main(String[] args) {
        QuizApplication quizApp = new QuizApplication();
        quizApp.startQuiz();
    }
}
