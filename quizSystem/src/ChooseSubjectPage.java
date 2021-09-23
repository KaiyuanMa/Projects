import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChooseSubjectPage implements ActionListener {
    JFrame frame = new JFrame();
    JLabel messageLabel = new JLabel();
    JButton MathButton = new JButton("Math");
    JButton ComputerScienceButton = new JButton("Computer Science");
    JButton GeographyButton = new JButton("Geography");
    JButton menuButton = new JButton("Main Menu");
    JFrame readyFrame = new JFrame();
    JLabel readyMessage = new JLabel();
    JButton readyButton = new JButton();
    int count = 0;
    String subject = "";
    int id;
    String email;

    ChooseSubjectPage(String email, int id) {
        this.id = id;
        this.email = email;
        messageLabel.setBounds(0,0,290,90);
        messageLabel.setFont(new Font(null, Font.BOLD,20));
        messageLabel.setForeground(Color.white);
        messageLabel.setText("Please choose a subject");
        messageLabel.setBackground(new Color(169,5,50));
        messageLabel.setOpaque(true);
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        messageLabel.setVerticalAlignment(JLabel.CENTER);


        MathButton.setBounds(70,120,140,25);
        MathButton.addActionListener(this);
        MathButton.setFocusable(false);

        ComputerScienceButton.setBounds(70,160,140,25);
        ComputerScienceButton.addActionListener(this);
        ComputerScienceButton.setFocusable(false);

        GeographyButton.setBounds(70,200,140,25);
        GeographyButton.addActionListener(this);
        GeographyButton.setFocusable(false);

        menuButton.setBounds(180, 230, 100,20);
        menuButton.addActionListener(this);
        menuButton.setFocusable(false);

        readyButton.addActionListener(this);
        readyButton.setBackground(Color.GRAY);

        frame.add(messageLabel);
        frame.add(MathButton);
        frame.add(ComputerScienceButton);
        frame.add(GeographyButton);
        frame.add(menuButton);
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
        readyFrame.setSize(500,400);
        readyFrame.setLocationRelativeTo(null);
        readyFrame.setResizable(false);
        readyFrame.setLayout(null);
        readyFrame.getContentPane().setBackground(Color.WHITE);

        readyButton.setBounds(340,310,120,25);
        readyButton.setFocusable(false);
        readyButton.setText("I am ready ("+count+")");

        readyMessage.setText("<html>You have chosen " + subject +
                "<br/>Before you take quiz, please note the following :" +
                "<br/><br/>1. The quiz will take 30 minutes, but you can submit upon finish." +
                "<br/><br/>2. Please make sure you are at a quite place, and will not be Interrupted." +
                "<br/><br/>3. Once start, you will not be able to stop or pause the quiz. If you exit during the quiz, your answers will not be saved." +
                "<br/><br/>4. The quiz will automatically submit upon 30 minute mark.");
        readyMessage.setIcon(new ImageIcon("src\\image\\img_4.png"));
        readyMessage.setVerticalTextPosition(JLabel.BOTTOM);
        readyMessage.setHorizontalTextPosition(JLabel.CENTER);
        readyMessage.setBounds(50,10,380,280);

        readyFrame.add(readyMessage);
        readyFrame.add(readyButton);
        readyFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                count = 0;
                readyButton.setForeground(Color.BLACK);
                readyButton.setBackground(Color.GRAY);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == MathButton) {
            subject = "math";
            count = 0;
            readyButton.setText("I am ready ("+count+")");
            readyFrame.setVisible(true);
        }
        else if (e.getSource() == ComputerScienceButton) {
            subject = "cs";
            count = 0;
            readyButton.setText("I am ready ("+count+")");
            readyFrame.setVisible(true);
        }
        else if (e.getSource() == GeographyButton) {
            subject = "ge";
            count = 0;
            readyButton.setText("I am ready ("+count+")");
            readyFrame.setVisible(true);
        }
        else if (e.getSource() == menuButton) {
            frame.dispose();
            Interface i = new Interface(email, id);
        }
        if (e.getSource() == readyButton) {
            count++;
            if (count == 3) {
                    readyFrame.dispose();
                    frame.dispose();
                    QuizPage q = new QuizPage(email,id,subject);
            }
            else if (count < 3) {
                if (count == 1) {
                    readyButton.setForeground(Color.ORANGE);
                    readyButton.setText("I am ready ("+count+")");
                }
                else if (count == 2) {
                    readyButton.setForeground(Color.ORANGE);
                    readyButton.setBackground(Color.red);
                    readyButton.setText("I am ready ("+count+")");
                }

            }
        }
    }
}
