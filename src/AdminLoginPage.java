import javax.swing.*;
import java.awt.*;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Scanner;

public class AdminLoginPage extends JFrame {
    public AdminLoginPage() {
        //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
        super("Admin Login");
        //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
        setLayout(new BorderLayout());
        //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
        Box horizontalBox1 = Box.createHorizontalBox();
        Box horizontalBox2 = Box.createHorizontalBox();
        //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
        JLabel title = new JLabel("Students Management System");
        title.setForeground(Color.BLUE);
        title.setHorizontalAlignment(JTextField.CENTER);
        title.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 30));
        panel2.add(title);
        //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
        add(panel2,BorderLayout.NORTH);
        //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
        JLabel nameLabel = new JLabel("User Name: ");
        nameLabel.setForeground(Color.BLACK);
        nameLabel.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 20));
        horizontalBox1.add(nameLabel);
        //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
        JTextField userName = new JTextField(20);
        userName.setFont(new Font("Serif", Font.ITALIC, 16));
        userName.setPreferredSize(new Dimension(400, 18));
        horizontalBox1.add(userName);
        panel.add(horizontalBox1,BorderLayout.EAST);
        //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setForeground(Color.BLACK);
        passwordLabel.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 20));
        horizontalBox2.add(passwordLabel);
        //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
        JPasswordField password = new JPasswordField(20);
        password.setFont(new Font("Serif", Font.ITALIC, 16));
        horizontalBox2.add(password);
        //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
        JCheckBox showPassword = new JCheckBox("Show Password");
        horizontalBox2.add(showPassword);
        //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
        panel.add(horizontalBox2,BorderLayout.EAST);
        JLabel statusBar = new JLabel();
        statusBar.setForeground(Color.RED);
        panel.add(statusBar,BorderLayout.CENTER);
        add(panel,BorderLayout.CENTER);
        //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
        JButton logInButton = new JButton("Login here!");
        logInButton.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 16));
        logInButton.setForeground(Color.white);
        logInButton.setBackground(Color.BLUE);
        add(logInButton,BorderLayout.SOUTH);
        //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
        showPassword.addItemListener(
                e -> {
                    if(showPassword.isSelected()){
                        password.setEchoChar((char)0);
                    }
                    else{
                        password.setEchoChar('*');
                    }
                }
        );
        //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
        logInButton.addActionListener(
                ae -> {
                    try {
                        Scanner file = new Scanner(Paths.get("password.txt"));
                        while (file.hasNextLine()) {
                            String entry = file.nextLine();
                            String[] array = entry.split(",");
                            boolean user = array[0].equalsIgnoreCase(userName.getText());
                            boolean pass = Objects.equals(array[1], password.getText());
                            if (user && pass) {
                                setVisible(false);
                                MainMenu m = new MainMenu();
                                m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                m.setSize(800, 150);
                                m.setVisible(true);
                            } else {
                                if (!user && !pass) {
                                    statusBar.setText("In-correct UserName and Password");
                                } else if (!user) {
                                    statusBar.setText("In-Correct Username!");
                                } else {
                                    statusBar.setText("In-Correct Password!");
                                }
                            }
                        }
                    } catch (Exception i) {
                        statusBar.setText("System Error!!");
                    }
                }
        );
    }
}
