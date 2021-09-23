import ReadMe.MysqlDeveloper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class LoginPage implements ActionListener {
    MysqlDeveloper developer = new MysqlDeveloper();
    Connection connection = null;
    Statement statement = null;
    ResultSet rs = null;
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton signUpButton = new JButton("Sign Up");
    JTextField emailText = new JTextField();
    JPasswordField passwordText = new JPasswordField();
    JLabel emailLabel = new JLabel("Email");
    JLabel passwordLabel = new JLabel("Password");
    JLabel messageLabel = new JLabel();
    LoginPage() {


        emailLabel.setBounds(350,60,75,25);
        passwordLabel.setBounds(350,110,75,25);
        emailText.setBounds(420,60,110,25);
        passwordText.setBounds(420,110,110,25);

        loginButton.setBounds(345,170,90,25);
        loginButton.addActionListener(this);
        loginButton.setFocusable(false);

        signUpButton.setBounds(455,170,90,25);
        signUpButton.addActionListener(this);
        signUpButton.setFocusable(false);

        messageLabel.setBounds(0,0,300,300);
        messageLabel.setFont(new Font(null, Font.BOLD,25));
        messageLabel.setForeground(Color.white);
        messageLabel.setText("<html>Welcome to <br/>Quiz System</html>");
        messageLabel.setBackground(new Color(169,5,50));
        messageLabel.setOpaque(true);
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        messageLabel.setVerticalAlignment(JLabel.CENTER);

        frame.setIconImage(new ImageIcon("src\\image\\logo.png").getImage());
        frame.add(signUpButton);
        frame.add(loginButton);
        frame.add(emailText);
        frame.add(passwordText);
        frame.add(messageLabel);
        frame.add(emailLabel);
        frame.add(passwordLabel);
        frame.setSize(600,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);



    }
    public static byte[] getSHA(String input) throws NoSuchAlgorithmException
    {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String toHexString(byte[] hash)
    {
        BigInteger number = new BigInteger(1, hash);
        StringBuilder hexString = new StringBuilder(number.toString(16));
        while (hexString.length() < 32)
        {
            hexString.insert(0, '0');
        }
        return hexString.toString();
    }
    public boolean loginCheck (String email, String password){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:"+developer.getHostname()+"/quiz_system_database", developer.getUser(), developer.getPassword());
            statement = connection.createStatement();
            rs = statement.executeQuery("Select passcode From clients c Where c.email =" + "'" +email+"'");
            rs.next();
            return rs.getString("passcode").equals(toHexString(getSHA("'"+password+"'")));
        }
        catch (Exception e) {
            return false;
        }
        finally {
            try{connection.close();}catch (Exception e) {}
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String email = emailText.getText();
            String password = String.valueOf(passwordText.getPassword());
            if (email.equals("")) {
                ActionRequiredPage a = new ActionRequiredPage(1);
            } else if (password.equals("")) {
                ActionRequiredPage a = new ActionRequiredPage(2);
            } else if (!loginCheck(email, password)) {
                        ActionRequiredPage a = new ActionRequiredPage(3);
                    }
            else if (loginCheck(email, password)) {
                try {
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:"+developer.getHostname()+"/quiz_system_database", developer.getUser(), developer.getPassword());
                    statement = connection.createStatement();
                    rs = statement.executeQuery("Select client_id From clients c Where c.email =" + "'" + email + "'");
                    rs.next();
                    int id = rs.getInt("client_id");
                    frame.dispose();
                    Interface i = new Interface(email, id);
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
                finally {
                    try {connection.close();} catch (Exception ex) {}
                }
            }
                }
        else if (e.getSource() == signUpButton) {
            frame.dispose();
            SignUpPage s = new SignUpPage();
        }
    }
}
