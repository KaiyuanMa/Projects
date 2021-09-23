import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface implements ActionListener {
    JFrame frame = new JFrame();
    JButton takeQuizButton = new JButton("Take a Quiz");
    JButton reportCardButton = new JButton("Show Report Card");
    JButton logoutButton = new JButton("Log Out");
    JLabel welcome = new JLabel();
    int id;
    String email;

    Interface (String email, int id) {
        this.id = id;
        this.email = email;
        welcome.setText("<html>Welcome," + "<br/>"+email +"<br/><br/>" +
                "What would you like to do today?</html>");
        welcome.setBounds(0,0,300,270);
        welcome.setFont(new Font(null, Font.BOLD,25));
        welcome.setForeground(Color.white);
        welcome.setBackground(new Color(169,5,50));
        welcome.setOpaque(true);
        welcome.setHorizontalAlignment(JLabel.CENTER);
        welcome.setVerticalAlignment(JLabel.CENTER);

        takeQuizButton.setBounds(375,70,140,25);
        takeQuizButton.addActionListener(this);
        takeQuizButton.setFocusable(false);

        reportCardButton.setBounds(375,120,140,25);
        reportCardButton.addActionListener(this);
        reportCardButton.setFocusable(false);

        logoutButton.setBounds(405,200,80,25);
        logoutButton.addActionListener(this);
        logoutButton.setFocusable(false);

        frame.setIconImage(new ImageIcon("src\\image\\logo.png").getImage());
        frame.add(welcome);
        frame.add(takeQuizButton);
        frame.add(reportCardButton);
        frame.add(logoutButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,300);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logoutButton) {
            frame.dispose();
            LoginPage l = new LoginPage();
        }
        else if (e.getSource() == takeQuizButton) {
            frame.dispose();
            ChooseSubjectPage c = new ChooseSubjectPage(email, id);
        }
        else if (e.getSource() == reportCardButton) {
            frame.dispose();
            ReportCard r = new ReportCard(email, id);
        }
    }
}
