import javax.swing.*;

public class ActionRequiredPage  {
    JFrame frame = new JFrame();
    JLabel message1 = new JLabel("Please enter username");
    JLabel message2 = new JLabel("Please enter passcode");
    JLabel message3 = new JLabel("Incorrect email or passcode");
    JLabel message4 = new JLabel("Please enter a valid email");
    JLabel message5 = new JLabel("Please confirm the password");
    JLabel message6 = new JLabel("Please select a plan");
    JLabel message7 = new JLabel("Please enter a valid card number");
    JLabel message8 = new JLabel("Please select a month");
    JLabel message9 = new JLabel("Please enter a valid expiration year");
    JLabel message10 = new JLabel("Please enter a valid CCV");
    JLabel message11 = new JLabel("Sign up successful! Please login");
    JLabel message12 = new JLabel("Password does not match");
    JLabel message13 = new JLabel("Email already in use");

    ActionRequiredPage(int option)  {

            message1.setVerticalAlignment(JLabel.CENTER);
            message1.setHorizontalAlignment(JLabel.CENTER);

            message2.setVerticalAlignment(JLabel.CENTER);
            message2.setHorizontalAlignment(JLabel.CENTER);

            message3.setVerticalAlignment(JLabel.CENTER);
            message3.setHorizontalAlignment(JLabel.CENTER);

            message4.setVerticalAlignment(JLabel.CENTER);
            message4.setHorizontalAlignment(JLabel.CENTER);

            message5.setVerticalAlignment(JLabel.CENTER);
            message5.setHorizontalAlignment(JLabel.CENTER);

            message6.setVerticalAlignment(JLabel.CENTER);
            message6.setHorizontalAlignment(JLabel.CENTER);

            message7.setVerticalAlignment(JLabel.CENTER);
            message7.setHorizontalAlignment(JLabel.CENTER);

            message8.setVerticalAlignment(JLabel.CENTER);
            message8.setHorizontalAlignment(JLabel.CENTER);

            message9.setVerticalAlignment(JLabel.CENTER);
            message9.setHorizontalAlignment(JLabel.CENTER);

            message10.setVerticalAlignment(JLabel.CENTER);
            message10.setHorizontalAlignment(JLabel.CENTER);

            message11.setVerticalAlignment(JLabel.CENTER);
            message11.setHorizontalAlignment(JLabel.CENTER);

            message12.setVerticalAlignment(JLabel.CENTER);
            message12.setHorizontalAlignment(JLabel.CENTER);

            message13.setVerticalAlignment(JLabel.CENTER);
            message13.setHorizontalAlignment(JLabel.CENTER);

            if (option == 1) {
                frame.add(message1);
            } else if (option == 2) {
                frame.add(message2);
            } else if (option == 3) {
                frame.add(message3);
            } else if (option == 4) {
                frame.add(message4);
            } else if (option == 5) {
                frame.add(message5);
            } else if (option == 6) {
                frame.add(message6);
            } else if (option == 7) {
                frame.add(message7);
            } else if (option == 8) {
                frame.add(message8);
            } else if (option == 9) {
                frame.add(message9);
            } else if (option == 10) {
                frame.add(message10);
            } else if (option == 11) {
                frame.add(message11);
            } else if (option == 12) {
                frame.add(message12);
            } else if (option == 13) {
                frame.add(message13);
            }
            frame.setSize(250, 100);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setIconImage(new ImageIcon("src\\image\\exclamation mark.png").getImage());
            frame.setVisible(true);
        }
    }


