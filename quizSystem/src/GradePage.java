import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradePage implements ActionListener {
    JFrame frame = new JFrame();
    JLabel gradeLabel = new JLabel();
    JLabel messageLabel1 = new JLabel();
    JLabel messageLabel2 = new JLabel();
    JButton anotherQuiz = new JButton();
    JButton mainMenu = new JButton();
    JPanel buttons = new JPanel();
    String email;
    int id;

    GradePage(String email, int id, int score) {
        this.email = email;
        this.id = id;

        messageLabel1.setText("Score :");
        messageLabel1.setBounds(150,10,90,25);
        Font messageFont = new Font("Helvetica", Font.BOLD,20);
        messageLabel1.setFont(messageFont);
        gradeLabel.setText(score+"/10");
        Font gradeFont = new Font("Helvetica", Font.ITALIC,80);
        gradeLabel.setFont(gradeFont);
        messageLabel2.setBounds(10,150,300,20);
        Font messageFont2 = new Font("Helvetica", Font.BOLD,15);
        messageLabel2.setFont(messageFont2);

        if (score == 10) {
            gradeLabel.setBounds(80,60,220,65);
            gradeLabel.setForeground(new Color(121, 243, 115));
            messageLabel2.setText("Excellent! You are the best!");
        }
        else if (score == 9) {
            gradeLabel.setBounds(110,60,220,75);
            gradeLabel.setForeground(new Color(121, 243, 115));
            messageLabel2.setText("Excellent! You are the best!");
        }
        else if (score < 9 && score > 6) {
            gradeLabel.setBounds(110,60,220,70);
            gradeLabel.setForeground(new Color(186, 212, 26));
            messageLabel2.setText("Good Job! You can do better!");
        }
        else if (score < 7) {
            gradeLabel.setBounds(110,50,220,70);
            gradeLabel.setForeground(new Color(253, 122, 26));
            messageLabel2.setText("You can do better next time.");
        }

        buttons.setLayout(null);
        buttons.setBackground(new Color(169,5,50));
        buttons.setOpaque(true);
        buttons.setBounds(0,200,390,200);

        anotherQuiz.setText("Take another quiz");
        anotherQuiz.setFocusable(false);
        anotherQuiz.addActionListener(this);
        anotherQuiz.setBounds(120,40,140,25);

        mainMenu.setText("Main Menu");
        mainMenu.setFocusable(false);
        mainMenu.addActionListener(this);
        mainMenu.setBounds(120,90,140,25);

        buttons.add(anotherQuiz);
        buttons.add(mainMenu);

        frame.setIconImage(new ImageIcon("src\\image\\logo.png").getImage());
        frame.add(buttons);
        frame.add(messageLabel1);
        frame.add(messageLabel2);
        frame.add(gradeLabel);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setResizable(false);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == anotherQuiz) {
            frame.dispose();
            ChooseSubjectPage c = new ChooseSubjectPage(email, id);
        }
        else if (e.getSource() == mainMenu) {
            frame.dispose();
            Interface i = new Interface(email, id);
        }
    }
}
