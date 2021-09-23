import java.util.ArrayList;

public class Question {
    private String question;
    private ArrayList<String> choices;
    private String answer;
    private int difficulty;

    public Question() {
        ArrayList<String> a = new ArrayList<>();
        question = "";
        choices = a;
        answer = "";
        difficulty = 0;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<String> getChoices() {
        return choices;
    }

    public void setChoices(ArrayList<String> choices) {
        this.choices = choices;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answerIndex) {
        this.answer = answerIndex;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}