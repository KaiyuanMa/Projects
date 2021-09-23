import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

public class SignUpPage implements ActionListener {
    Connection connection = null;
    Statement statement = null;
    ResultSet rs = null;

    int Plan = 0;
    JFrame frame = new JFrame();
    JLabel text = new JLabel();
    JLabel emailLabel = new JLabel("Email");
    JLabel passwordLabel = new JLabel("Password");
    JLabel confirmPasswordLabel = new JLabel("Confirm Password");
    JLabel CardLabel = new JLabel("Credit Card Number");
    JLabel DateLabel = new JLabel("Expiration Date");
    JLabel monthLabel = new JLabel("Month");
    JLabel yearLabel = new JLabel("Year");
    JLabel CCVLabel = new JLabel("CCV");
    JLabel planLabel = new JLabel("Please choose a plan :");

    JRadioButton plan1Button;
    JRadioButton plan2Button;
    JRadioButton plan3Button;
    JButton SignupButton = new JButton("Sign Up");
    JButton GoBackButton = new JButton("Login Page");

    JTextField emailField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JPasswordField confirmPasswordField = new JPasswordField();
    JTextField cardField = new JTextField(16);
    JTextField yearField = new JTextField(4);

    String[] month = {"","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct",
    "Nov","Dec"};
    JComboBox<String> monthBox = new JComboBox<>(month);
    JTextField CCVField = new JTextField(3);

    JFrame GoBackFrame = new JFrame();
    JLabel GoBackMessage = new JLabel("<html>Do you want to go back to login Page?<br/>Information entered will not be saved</html>");
    JButton okButton = new JButton("OK");
    JButton cancelButton = new JButton("Cancel");

    SignUpPage(){
        text.setBounds(0,0,200,462);
        text.setText("<html>Please<br/>enter<br/>your<br/>information</html>");
        text.setFont(new Font(null, Font.BOLD,30));
        text.setForeground(Color.white);
        text.setBackground(new Color(169,5,50));
        text.setOpaque(true);
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setVerticalAlignment(JLabel.CENTER);

        emailLabel.setBounds(220,20,50,25);
        emailField.setBounds(220,40,150,25);

        passwordLabel.setBounds(220,70,70,25);
        passwordField.setBounds(220,90,150,25);

        confirmPasswordLabel.setBounds(220,120,110,25);
        confirmPasswordField.setBounds(220,140,150,25);

        planLabel.setBounds(220,180,150,25);
        ButtonGroup group = new ButtonGroup();
        plan1Button = new JRadioButton("Plan 1:  $5 for 1 month");
        plan2Button = new JRadioButton("Plan 2:  $12 for 3 months");
        plan3Button = new JRadioButton("Plan 3:  $40 for 1 year");
        plan1Button.addActionListener(this);
        plan2Button.addActionListener(this);
        plan3Button.addActionListener(this);
        group.add(plan1Button);
        group.add(plan2Button);
        group.add(plan3Button);
        plan1Button.setBounds(240,200,160,25);
        plan2Button.setBounds(240,220,180,25);
        plan3Button.setBounds(240,240,160,25);

        CardLabel.setBounds(220,280,140,25);
        cardField.setBounds(220,300,150,25);

        DateLabel.setBounds(220,330,100,25);
        monthLabel.setBounds(220,355,50,25);
        monthBox.setBounds(220,375,50,25);
        yearLabel.setBounds(300,355,50,25);
        yearField.setBounds(300,375,50,25);
        CCVLabel.setBounds(220,400,50,25);
        CCVField.setBounds(220,420,50,25);

        SignupButton.setBounds(370,420,100,25);
        SignupButton.setFocusable(false);
        SignupButton.addActionListener(this);

        GoBackButton.setBounds(370,390,100,25);
        GoBackButton.setFocusable(false);
        GoBackButton.addActionListener(this);

        cancelButton.addActionListener(this);
        cancelButton.setFocusable(false);

        okButton.addActionListener(this);
        okButton.setFocusable(false);

        frame.setIconImage(new ImageIcon("src\\image\\logo.png").getImage());
        frame.add(text);
        frame.add(emailLabel);
        frame.add(emailField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(confirmPasswordLabel);
        frame.add(confirmPasswordField);
        frame.add(planLabel);
        frame.add(plan1Button);
        frame.add(plan2Button);
        frame.add(plan3Button);
        frame.add(CardLabel);
        frame.add(cardField);
        frame.add(DateLabel);
        frame.add(monthLabel);
        frame.add(monthBox);
        frame.add(yearLabel);
        frame.add(yearField);
        frame.add(CCVLabel);
        frame.add(CCVField);
        frame.add(SignupButton);
        frame.add(GoBackButton);
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public boolean EmailInUse(String email) throws FileNotFoundException {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_system_database", "root", "123456");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("Select * From clients c Where c.email =" +email);
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
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

    @Override
    public void actionPerformed(ActionEvent e) {
        int month = monthBox.getSelectedIndex();
        if (e.getSource() == plan1Button) {
            Plan = 1;
        }
        else if (e.getSource() == plan2Button) {
            Plan = 2;
        }
        else if (e.getSource() == plan3Button) {
            Plan = 3;
        }

        if (e.getSource() == SignupButton) {
            String email = "'" +emailField.getText()+ "'";
            String password = "'" +String.valueOf(passwordField.getPassword())+ "'";
            String confirmPassword = "'"+String.valueOf(confirmPasswordField.getPassword())+"'";
            String cardNumber = "'" +cardField.getText()+ "'";
            String year = yearField.getText();
            String expDate ="'" + year+"-"+String.format("%02d",month)+"-"+"01"+ "'";
            int CVV =  (CCVField.getText().equals("")) ? 0 : Integer.parseInt(CCVField.getText());
            if (!(email.contains("@") && (email.contains(".com")) || email.contains(".edu"))) {
                ActionRequiredPage a = new ActionRequiredPage(4);
            }
            else {
                try {
                    if (EmailInUse(email)) {
                        ActionRequiredPage a = new ActionRequiredPage(13);
                    }
                    else if (password.equals("''")) {
                        ActionRequiredPage a = new ActionRequiredPage(2);
                    } else if (confirmPassword.equals("''")) {
                        ActionRequiredPage a = new ActionRequiredPage(5);
                    } else if (!confirmPassword.equals(password)) {
                        ActionRequiredPage a = new ActionRequiredPage(12);
                    } else if (!plan1Button.isSelected() && !plan2Button.isSelected() && !plan3Button.isSelected()) {
                        ActionRequiredPage a = new ActionRequiredPage(6);
                    } else if (cardNumber.equals("''") || cardNumber.length() != 18) {
                        ActionRequiredPage a = new ActionRequiredPage(7);
                    } else if (month == 0) {
                        ActionRequiredPage a = new ActionRequiredPage(8);
                    } else if (year.equals("") || year.length() != 4) {
                        ActionRequiredPage a = new ActionRequiredPage(9);
                    } else if (CVV == 0 || CCVField.getText().length() != 3) {
                        ActionRequiredPage a = new ActionRequiredPage(10);
                    } else {
                        try {
                            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_system_database", "root", "123456");
                            statement = connection.createStatement();
                            statement.executeUpdate("Insert Into clients Values (Default,"+email+","+
                                    "'"+toHexString(getSHA(password))+"'"+","+Plan+","+cardNumber+","+expDate+","+CVV+","+"Default,Default,Default)");
                        }
                        catch (Exception ex) {
                            ex.printStackTrace();
                        } finally {
                            try{ connection.close();} catch (Exception ex) {}
                        }
                        frame.dispose();
                        LoginPage loginPage = new LoginPage();
                        ActionRequiredPage a = new ActionRequiredPage(11);
                    }
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
        }
        else if (e.getSource() == GoBackButton) {
            GoBackFrame.setLayout(null);
            GoBackMessage.setBounds(25,10,250,50);

            okButton.setBounds(25,70,80,25);

            cancelButton.setBounds(180,70,80,25);

            GoBackFrame.add(GoBackMessage);
            GoBackFrame.add(okButton);
            GoBackFrame.add(cancelButton);
            GoBackFrame.setSize(300, 150);
            GoBackFrame.setResizable(false);
            GoBackFrame.setLocationRelativeTo(null);
            GoBackFrame.setIconImage(new ImageIcon("src\\image\\exclamation mark.png").getImage());
            GoBackFrame.setVisible(true);
        }
        if (e.getSource() == okButton) {
            frame.dispose();
            GoBackFrame.dispose();
            LoginPage l = new LoginPage();
        }
        else if (e.getSource() == cancelButton) {
            GoBackFrame.dispose();
        }

    }
}
