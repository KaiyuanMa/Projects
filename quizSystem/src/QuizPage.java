import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class QuizPage implements ActionListener {
    Connection connection = null;
    Statement statement = null;
    ResultSet rs = null;
    char[] userAnswer = new char[10];
    char[] answer = new char[10];
    ArrayList<Question> QuestionArray = new ArrayList<>();
    String email;
    int id;
    String subject;
    int Difficulty = 0;
    int currentQuestion = 0;
    int progress = 0;
    int grade = 0;
    Font questionFont = new Font(null, Font.PLAIN,18);
    Font choiceFont = new Font(null, Font.PLAIN, 15);
    Font answerQuestion = new Font(null, Font.PLAIN, 12);



    JFrame frame = new JFrame();
    JPanel questionPanel = new JPanel();
    JTextArea questionText = new JTextArea(500,80);
    JLabel questionNumLabel = new JLabel();
    JRadioButton choiceA = new JRadioButton();
    JRadioButton choiceB = new JRadioButton();
    JRadioButton choiceC = new JRadioButton();
    JRadioButton choiceD = new JRadioButton();
    ButtonGroup group = new ButtonGroup();
    JButton nextButton = new JButton();
    JButton previousButton = new JButton();
    JButton submitButton = new JButton();
    JProgressBar timerBar = new JProgressBar();
    JProgressBar progressBar = new JProgressBar();
    Border questionBorder = BorderFactory.createLineBorder(Color.LIGHT_GRAY);

    JPanel allQuestionPanel = new JPanel();
    JLabel questionsLabel = new JLabel("Questions");
    JButton question1 = new JButton("Question 1  ");
    JButton question2 = new JButton("Question 2  ");
    JButton question3 = new JButton("Question 3  ");
    JButton question4 = new JButton("Question 4  ");
    JButton question5 = new JButton("Question 5  ");
    JButton question6 = new JButton("Question 6  ");
    JButton question7 = new JButton("Question 7  ");
    JButton question8 = new JButton("Question 8  ");
    JButton question9 = new JButton("Question 9  ");
    JButton question10 = new JButton("Question 10");

    JFrame submitFrame = new JFrame();
    JButton okButton = new JButton();
    JButton cancelButton = new JButton();
    JLabel submitLabel = new JLabel();
    
    Timer timer;

    QuizPage(String email, int id, String subject){
        this.id = id;
        this.subject = subject;
        this.email = email;
        try {
            buildQuiz();
        } catch (IOException e) {
            e.printStackTrace();
        }
        timerBar.setValue(0);
        timerBar.setBounds(10,5,550,15);
        timerBar.setString("Timer");
        timerBar.setStringPainted(true);
        timerBar.setMaximum(59);
        progressBar.setValue(0);
        progressBar.setBounds(10,25,550,15);
        progressBar.setString("Progress");
        progressBar.setStringPainted(true);
        progressBar.setMaximum(10);

        ActionListener listener = new ActionListener() {
            int counter = 0;
            public void actionPerformed(ActionEvent ae) {
                counter++;
                timerBar.setValue(counter);
                if (counter>= 60) {
                    okButton.doClick();
                    timer.stop();
                }
            }
        };
        timer = new Timer(30000, listener);
        timer.start();

        questionNumLabel.setText("Question 1");
        questionNumLabel.setFont(new Font(null,Font.PLAIN,25));
        questionNumLabel.setBounds(0,0,550,30);
        questionNumLabel.setBackground(Color.LIGHT_GRAY);
        questionNumLabel.setOpaque(true);
        questionNumLabel.setHorizontalAlignment(JLabel.CENTER);

        questionText.setText(QuestionArray.get(currentQuestion).getQuestion());
        questionText.setFont(questionFont);
        questionText.setBounds(10,35,500,65);
        questionText.setLineWrap(true);
        questionText.setEditable(false);
        questionText.setFocusable(false);
        questionText.setWrapStyleWord(true);
        questionText.setLayout(null);
        questionText.setBackground(new Color(238,238,238));
        questionText.setOpaque(true);
        group.add(choiceA);
        group.add(choiceB);
        group.add(choiceC);
        group.add(choiceD);
        choiceA.setText(QuestionArray.get(currentQuestion).getChoices().get(0));
        choiceA.setBounds(10,100,400,50);
        choiceA.setFont(choiceFont);
        choiceA.addActionListener(this);
        choiceA.setFocusable(false);
        choiceB.setText(QuestionArray.get(currentQuestion).getChoices().get(1));
        choiceB.setBounds(10,150,400,50);
        choiceB.setFont(choiceFont);
        choiceB.addActionListener(this);
        choiceB.setFocusable(false);
        choiceC.setText(QuestionArray.get(currentQuestion).getChoices().get(2));
        choiceC.setBounds(10,200,400,50);
        choiceC.setFont(choiceFont);
        choiceC.addActionListener(this);
        choiceC.setFocusable(false);
        choiceD.setText(QuestionArray.get(currentQuestion).getChoices().get(3));
        choiceD.setBounds(10,250,400,50);
        choiceD.setFont(choiceFont);
        choiceD.addActionListener(this);
        choiceD.setFocusable(false);
        questionPanel.setLayout(null);

        nextButton.setText("Next");
        nextButton.setBounds(390,350,90,25);
        nextButton.addActionListener(this);
        nextButton.setFocusable(false);

        previousButton.setText("Previous");
        previousButton.setBounds(280,350,90,25);
        previousButton.addActionListener(this);
        previousButton.setVisible(false);
        previousButton.setFocusable(false);

        submitButton.setText("Submit");
        submitButton.setBounds(390,350,90,25);
        submitButton.addActionListener(this);
        submitButton.setFocusable(false);

        questionPanel.add(questionNumLabel);
        questionPanel.add(questionText);
        questionPanel.add(choiceA);
        questionPanel.add(choiceB);
        questionPanel.add(choiceC);
        questionPanel.add(choiceD);
        questionPanel.add(nextButton);
        questionPanel.add(previousButton);
        questionPanel.add(submitButton);
        questionPanel.setBounds(10,50,550,400);
        questionPanel.setBorder(questionBorder);


        question1.setFocusable(false);
        question1.addActionListener(this);
        question2.setFocusable(false);
        question2.addActionListener(this);
        question3.setFocusable(false);
        question3.addActionListener(this);
        question4.setFocusable(false);
        question4.addActionListener(this);
        question5.setFocusable(false);
        question5.addActionListener(this);
        question6.setFocusable(false);
        question6.addActionListener(this);
        question7.setFocusable(false);
        question7.addActionListener(this);
        question8.setFocusable(false);
        question8.addActionListener(this);
        question9.setFocusable(false);
        question9.addActionListener(this);
        question10.setFocusable(false);
        question10.addActionListener(this);


        allQuestionPanel.setLayout(new BoxLayout(allQuestionPanel,BoxLayout.PAGE_AXIS));
        allQuestionPanel.add(questionsLabel);
        questionsLabel.setFont(new Font(null, Font.BOLD,15));
        allQuestionPanel.add(Box.createRigidArea(new Dimension(10,20)));
        allQuestionPanel.add(question1);
        allQuestionPanel.add(Box.createRigidArea(new Dimension(0,8)));
        allQuestionPanel.add(question2);
        allQuestionPanel.add(Box.createRigidArea(new Dimension(0,8)));
        allQuestionPanel.add(question3);
        allQuestionPanel.add(Box.createRigidArea(new Dimension(0,8)));
        allQuestionPanel.add(question4);
        allQuestionPanel.add(Box.createRigidArea(new Dimension(0,8)));
        allQuestionPanel.add(question5);
        allQuestionPanel.add(Box.createRigidArea(new Dimension(0,8)));
        allQuestionPanel.add(question6);
        allQuestionPanel.add(Box.createRigidArea(new Dimension(0,8)));
        allQuestionPanel.add(question7);
        allQuestionPanel.add(Box.createRigidArea(new Dimension(0,8)));
        allQuestionPanel.add(question8);
        allQuestionPanel.add(Box.createRigidArea(new Dimension(0,8)));
        allQuestionPanel.add(question9);
        allQuestionPanel.add(Box.createRigidArea(new Dimension(0,8)));
        allQuestionPanel.add(question10);
        allQuestionPanel.setBorder(questionBorder);
        allQuestionPanel.setOpaque(true);
        allQuestionPanel.setBounds(565,50,115,400);

        okButton.addActionListener(this);
        cancelButton.addActionListener(this);

        frame.setIconImage(new ImageIcon("src\\image\\logo.png").getImage());
        frame.add(timerBar);
        frame.add(progressBar);
        frame.add(questionPanel);
        frame.add(allQuestionPanel);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,500);

        frame.setVisible(true);
    }


    public void buildQuiz() throws IOException{
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_system_database", "root", "123456");
            statement = connection.createStatement();
            rs = statement.executeQuery("Select " + subject + "_difficulty From clients Where client_id ="+id);
            rs.next();
            Difficulty = rs.getInt(subject + "_difficulty");
            ResultSet questions = statement.executeQuery(
                    "Select question, choice_A, choice_B, choice_C, choice_D, answer, difficulty_id "  +
                            "From " + subject + "_questions " +
                            "Where difficulty_id =" + Difficulty +" " +
                            "Order by rand() " +
                            "Limit 10");
            int counter = 0;
            while (questions.next()) {
                Question tmp = new Question();
                ArrayList<String> choices = new ArrayList<>();
                choices.add(questions.getString("choice_A"));
                choices.add(questions.getString("choice_B"));
                choices.add(questions.getString("choice_C"));
                choices.add(questions.getString("choice_D"));
                tmp.setChoices(choices);
                tmp.setAnswer(questions.getString("answer"));
                answer[counter] = questions.getString("answer").charAt(0);
                counter++;
                tmp.setQuestion(questions.getString("question"));
                tmp.setDifficulty(questions.getInt("difficulty_id"));
                QuestionArray.add(tmp);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try{connection.close();}catch (Exception e){}
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        submitButton.setVisible(false);
        previousButton.setVisible(true);
        nextButton.setVisible(true);
        if (e.getSource() == choiceA) userAnswer[currentQuestion] = 'A';
        else if (e.getSource() == choiceB) userAnswer[currentQuestion] = 'B';
        else if (e.getSource() == choiceC) userAnswer[currentQuestion] = 'C';
        else if (e.getSource() == choiceD) userAnswer[currentQuestion] = 'D';

        else if (e.getSource() == question1) currentQuestion = 0;
        else if (e.getSource() == question2) currentQuestion = 1;
        else if (e.getSource() == question3) currentQuestion = 2;
        else if (e.getSource() == question4) currentQuestion = 3;
        else if (e.getSource() == question5) currentQuestion = 4;
        else if (e.getSource() == question6) currentQuestion = 5;
        else if (e.getSource() == question7) currentQuestion = 6;
        else if (e.getSource() == question8) currentQuestion = 7;
        else if (e.getSource() == question9) currentQuestion = 8;
        else if (e.getSource() == question10) currentQuestion = 9;
        else if (e.getSource() == nextButton) currentQuestion = currentQuestion + 1;
        else if (e.getSource() == previousButton) currentQuestion = currentQuestion - 1;
        else if (e.getSource() == submitButton) {

            submitLabel.setText("Do you want to submit?");
            submitLabel.setBounds(60,20,200,25);

            okButton.setText("OK");
            okButton.setBounds(40,60,80,25);
            okButton.setFocusable(false);

            cancelButton.setText("Cancel");
            cancelButton.setBounds(150,60,80,25);
            cancelButton.setFocusable(false);

            submitFrame.add(okButton);
            submitFrame.add(cancelButton);
            submitFrame.add(submitLabel);

            submitFrame.setLayout(null);
            submitFrame.setSize(300,150);
            submitFrame.setResizable(false);
            submitFrame.setLocationRelativeTo(null);
            submitFrame.setVisible(true);
        }
        else if (e.getSource() == cancelButton) {
            submitFrame.dispose();
        }
        else if (e.getSource() == okButton) {
            for (int i = 0; i < 10; i++) {
                if (answer[i] == userAnswer[i]) grade = grade+1;
            }
            int nextQuizDiff = Difficulty;
            if (grade >= 9) {
                if (nextQuizDiff != 3) {
                    nextQuizDiff = nextQuizDiff +1;
                }
            }
            else if (grade < 7) {
                if (nextQuizDiff != 1) {
                    nextQuizDiff = nextQuizDiff-1;
                }
            }
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_system_database", "root", "123456");
                statement = connection.createStatement();
                timer.stop();
                statement.executeUpdate("UPDATE quiz_system_database.clients SET " +subject+"_difficulty =" +nextQuizDiff+ " WHERE client_id =" + id);
                switch (subject) {
                    case "math" -> subject = "1";
                    case "cs" -> subject = "2";
                    case "ge" -> subject = "3";
                }
                statement.executeUpdate("Insert Into quizzes Values (Default,"+id+","+"'"+timeStamp+"'"+","+Difficulty+","+grade+",'"+Integer.parseInt(subject)+"'"+")");
                frame.dispose();
                submitFrame.dispose();
                GradePage g = new GradePage(email, id, grade);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            finally {
                try{connection.close();} catch (Exception ex) {}
            }
        }
        if (currentQuestion == 0) previousButton.setVisible(false);
        if (currentQuestion == 9) {
            nextButton.setVisible(false);
            submitButton.setVisible(true);
        }



        int questionNum = currentQuestion + 1;
        if (userAnswer[questionNum-1] == 0) group.clearSelection();
        else {
            if (userAnswer[questionNum - 1] == 'A') choiceA.setSelected(true);
            else if (userAnswer[questionNum - 1] == 'B') choiceB.setSelected(true);
            else if (userAnswer[questionNum - 1] == 'C') choiceC.setSelected(true);
            else if (userAnswer[questionNum - 1] == 'D') choiceD.setSelected(true);
            switch (currentQuestion) {
                case 0 -> question1.setFont(answerQuestion);
                case 1 -> question2.setFont(answerQuestion);
                case 2 -> question3.setFont(answerQuestion);
                case 3 -> question4.setFont(answerQuestion);
                case 4 -> question5.setFont(answerQuestion);
                case 5 -> question6.setFont(answerQuestion);
                case 6 -> question7.setFont(answerQuestion);
                case 7 -> question8.setFont(answerQuestion);
                case 8 -> question9.setFont(answerQuestion);
                case 9 -> question10.setFont(answerQuestion);
            }
        }
        int tmp = 0;
        for (int i : userAnswer) {
            if (i != 0) tmp = tmp +1;
        }
        progress = tmp;
        progressBar.setValue(progress);

        questionNumLabel.setText("Question " + questionNum);
        questionText.setText(QuestionArray.get(currentQuestion).getQuestion());
        choiceA.setText(QuestionArray.get(currentQuestion).getChoices().get(0));
        choiceB.setText(QuestionArray.get(currentQuestion).getChoices().get(1));
        choiceC.setText(QuestionArray.get(currentQuestion).getChoices().get(2));
        choiceD.setText(QuestionArray.get(currentQuestion).getChoices().get(3));

    }
}
