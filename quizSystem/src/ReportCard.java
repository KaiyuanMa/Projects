import ReadMe.MysqlDeveloper;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ReportCard implements ActionListener {
    MysqlDeveloper developer = new MysqlDeveloper();
    Connection connection = null;
    Statement statement = null;
    ResultSet rs = null;
    String email;
    int id;
    String sortBy = "date desc";
    String subject = "";
    JPanel recordPanel = new JPanel();
    JFrame frame = new JFrame();
    JLabel subjectLabel = new JLabel("Subject");
    String[] subjectArr = {"All","Math","CS", "Geography"};
    JComboBox<String> subjectBox = new JComboBox<>(subjectArr);

    JLabel sortByLabel = new JLabel("Sort By");
    String[] sort = {"Date","Score","Subject", "Difficulty"};
    JComboBox<String> sortByBox = new JComboBox<>(sort);
    JButton previousButton = new JButton("Previous");
    JButton nextButton = new JButton("Next");
    int totalPage;
    int currentPage = 0;
    JLabel pageLabel = new JLabel();

    JButton main = new JButton("Main Menu");




    ReportCard(String email, int id) {
        this.email = email;
        this.id = id;
        addQuizzes(0,"","q.date");


        subjectLabel.setBounds(325,10,50,20);
        subjectBox.addActionListener(this);
        subjectBox.setBounds(380,10,90,20);
        subjectBox.setFocusable(false);

        sortByLabel.setBounds(325,35,50,20);
        sortByBox.addActionListener(this);
        sortByBox.setBounds(380,35,90,20);
        sortByBox.setFocusable(false);

        previousButton.addActionListener(this);
        previousButton.setBounds(25,427,85,25);
        previousButton.setEnabled(false);
        previousButton.setFocusable(false);

        nextButton.addActionListener(this);
        nextButton.setBounds(230,427,85,25);
        nextButton.setFocusable(false);

        if (totalPage > 0) {
            pageLabel.setText((currentPage+1)+"/"+totalPage);
        }
        else if (totalPage == 0) {
            pageLabel.setText(currentPage+"/"+totalPage);
            nextButton.setEnabled(false);
        }
        pageLabel.setBounds(164,427,50,25);

        main.addActionListener(this);
        main.setBounds(550,427,100,25);
        main.setFocusable(false);

        frame.setIconImage(new ImageIcon("src\\image\\logo.png").getImage());
        frame.add(main);
        frame.add(sortByLabel);
        frame.add(subjectLabel);
        frame.add(pageLabel);
        frame.add(nextButton);
        frame.add(previousButton);
        frame.add(sortByBox);
        frame.add(subjectBox);
        frame.setSize(700,500);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    public void addQuizzes(int currentPage, String subject, String sortBy) {
//        frame.remove(recordPanel);
        recordPanel.removeAll();
        recordPanel.setBounds(20,5,300,420);
        recordPanel.setBackground(Color.WHITE);
        recordPanel.setLayout(new BoxLayout(recordPanel,BoxLayout.PAGE_AXIS));
        ArrayList<Integer> score = new ArrayList<>();
        ArrayList<String> difficulty = new ArrayList<>();
        ArrayList<String> date = new ArrayList<>();
        ArrayList<String> subjectName = new ArrayList<>();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:"+developer.getHostname()+"/quiz_system_database", developer.getUser(), developer.getPassword());
            statement = connection.createStatement();
            rs = statement.executeQuery(
                    "Select q.grade, d.name As difficulty, q.date, s.name As subject\n" +
                            "From quizzes q\n" +
                            "Join clients c On q.client_id = c.client_id\n" +
                            "Join subject s on s.subject_id = q.subject_id\n" +
                            "Join difficulty d on d.difficulty_id = q.difficulty_id\n" +
                            "where q.client_id =" + id + subject + "\n" +
                            "Order by "+sortBy);
            while (rs.next()) {
                score.add(rs.getInt("grade"));
                difficulty.add(rs.getString("difficulty"));
                date.add(rs.getString("date"));
                subjectName.add(rs.getString("subject"));
            }
            if (score.size()%6 == 0) {
                totalPage = score.size() /6;
            }
            else {
                totalPage = score.size()/6 +1;
            }
            for (int i = currentPage*6, j = 0; j < 6 && i < score.size(); i++, j++) {
                JLabel scoreTextLabel = new JLabel();
                Font scoreTextFont = new Font(null, Font.PLAIN, 10);
                scoreTextLabel.setText("SCORE");
                scoreTextLabel.setFont(scoreTextFont);
                scoreTextLabel.setBounds(25,6,50,7);

                JLabel scoreLabel = new JLabel();
                String scoreText = score.get(i) + "/10";
                if (score.get(i) == 10) {
                    scoreLabel.setBounds(5,22,80,25);
                    scoreLabel.setForeground(new Color(121, 243, 115));
                }
                else if (score.get(i) == 9) {
                    scoreLabel.setBounds(15,22,80,25);
                    scoreLabel.setForeground(new Color(121, 243, 115));
                }
                else if (score.get(i) < 9 && score.get(i) > 6) {
                    scoreLabel.setBounds(15,22,80,25);
                    scoreLabel.setForeground(new Color(186, 212, 26));
                }
                else if (score.get(i) <7) {
                    scoreLabel.setBounds(15,22,80,25);
                    scoreLabel.setForeground(new Color(253, 122, 26));
                }
                scoreLabel.setText(scoreText);
                Font scoreFont = new Font("Helvetica", Font.ITALIC,30);
                scoreLabel.setFont(scoreFont);

                JLabel dateLabel = new JLabel();
                dateLabel.setText("Date :");
                dateLabel.setBounds(115,5,35,15);

                JLabel dateInputLabel = new JLabel();
                dateInputLabel.setText(date.get(i));
                dateInputLabel.setBounds(180,5,80,15);


                JLabel subjectLabel = new JLabel();
                subjectLabel.setText("Subject :");
                subjectLabel.setBounds(115,25,50,15);

                JLabel subjectInputLabel = new JLabel();
                subjectInputLabel.setText(subjectName.get(i));
                subjectInputLabel.setBounds(180,25,110,15);

                JLabel difficultyLabel = new JLabel();
                difficultyLabel.setText(difficulty.get(i));
                difficultyLabel.setHorizontalAlignment(JLabel.CENTER);
                difficultyLabel.setBounds(243,48,46,15);
                difficultyLabel.setOpaque(true);
                switch (difficulty.get(i)) {
                    case "Easy" -> difficultyLabel.setBackground(new Color(121, 243, 115));
                    case "Medium" -> difficultyLabel.setBackground(new Color(186, 212, 26));
                    case "Hard" -> difficultyLabel.setBackground(new Color(253, 122, 26));
                }

                JLabel colorLabel = new JLabel();
                colorLabel.setBackground(new Color(165, 172, 239));
                colorLabel.setBounds(0,0,290,2);
                colorLabel.setOpaque(true);
                JPanel questionPanel = new JPanel();

                questionPanel.add(difficultyLabel);
                questionPanel.add(subjectLabel);
                questionPanel.add(subjectInputLabel);
                questionPanel.add(dateLabel);
                questionPanel.add(dateInputLabel);
                questionPanel.add(scoreLabel);
                questionPanel.add(colorLabel);
                questionPanel.add(scoreTextLabel);
                questionPanel.setLayout(null);
                questionPanel.setMaximumSize(new Dimension(290,64));
                questionPanel.setBackground(Color.WHITE);
                questionPanel.setBorder(new LineBorder(Color.LIGHT_GRAY));
                recordPanel.add(Box.createRigidArea(new Dimension(6,5)));
                recordPanel.add(questionPanel);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try{connection.close();} catch (Exception e) {}
        }
        recordPanel.validate();
        recordPanel.repaint();
        frame.add(recordPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == previousButton) {
            currentPage = currentPage -1;
            addQuizzes(currentPage, subject, sortBy);
        }
        else if (e.getSource() == nextButton) {
            currentPage = currentPage + 1;
            addQuizzes(currentPage, subject, sortBy);
        }
        else if (e.getSource() == subjectBox) {
            currentPage = 0;
            if (subjectBox.getSelectedIndex() == 0) {
                subject = "";
                addQuizzes(currentPage, subject,sortBy);
            }
            else if (subjectBox.getSelectedIndex() == 1) {
                subject = " && q.subject_id = 1";
                addQuizzes(currentPage, subject,sortBy);
            }
            else if (subjectBox.getSelectedIndex() == 2) {
                subject = " && q.subject_id = 2";
                addQuizzes(currentPage, subject,sortBy);
            }
            else if (subjectBox.getSelectedIndex() == 3) {
                subject = " && q.subject_id = 3";
                addQuizzes(currentPage, subject,sortBy);
            }
        }
        else if (e.getSource() == sortByBox) {
            currentPage = 0;
            if (sortByBox.getSelectedIndex() == 0) {
                sortBy = "date desc";
                addQuizzes(currentPage, subject,sortBy);
            }
            else if (sortByBox.getSelectedIndex() == 1) {
                sortBy = "grade desc";
                addQuizzes(currentPage, subject,sortBy);
            }
            else if (sortByBox.getSelectedIndex() == 2) {
                sortBy = "q.subject_id";
                addQuizzes(currentPage, subject,sortBy);
            }
            else if (sortByBox.getSelectedIndex() == 3) {
                sortBy = "q.difficulty_id";
                addQuizzes(currentPage, subject,sortBy);
            }
        }
        else if (e.getSource() == main) {
            frame.dispose();
            Interface i = new Interface(email, id);
        }


        if (totalPage > 0) {
            pageLabel.setText((currentPage+1)+"/"+totalPage);
        }
        else if (totalPage == 0) {
            pageLabel.setText(currentPage+"/"+totalPage);
        }
        if (currentPage > 0) {
            previousButton.setEnabled(true);
        }
        else if (currentPage == 0) {
            previousButton.setEnabled(false);
        }
        if (currentPage+1 == totalPage) {
            nextButton.setEnabled(false);
        }
        else if (currentPage+1 < totalPage) {
            nextButton.setEnabled(true);
        }
    }
}
