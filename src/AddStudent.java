import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class AddStudent extends JFrame {
    File file = new File("Data.txt");
    ObjectOutputStream o = null;
    ObjectInputStream i = null;
    JTextField stdId;
    JTextField userName;
    JComboBox<String> gender;
    JRadioButton Age1;
    JRadioButton Age2;
    JRadioButton Age3;
    JRadioButton Age4;
    JCheckBox cricket;
    JCheckBox badminton;
    JCheckBox racing;
    JCheckBox gaming;
    ButtonGroup radioGroup1;
    String hobbies;
    String AgeGroup;
    JButton saveData;
    JButton back;
    JLabel status;
    ArrayList<Integer> idd  = new ArrayList<>();
    public static final String[] names = {"Male", "Female", "Prefer not say","TransGender"};
    ArrayList<StudentAttributes> SA = new ArrayList<>();

    public AddStudent() {
        super("Add Student Menu");
        setLayout(new BorderLayout());
        //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
        JPanel panel = new JPanel();
        JLabel title = new JLabel("Add Student Menu");
        title.setForeground(Color.RED);
        title.setFont(new Font("Monospaced", Font.ITALIC + Font.BOLD, 30));
        panel.add(title, BorderLayout.NORTH);
        //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
        Box b1 = Box.createHorizontalBox();
        Box b2 = Box.createHorizontalBox();
        Box b3 = Box.createHorizontalBox();
        Box b4 = Box.createHorizontalBox();
        Box b5 = Box.createHorizontalBox();
        //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
        JLabel StdIdL = new JLabel("Student ID :     ");
        StdIdL.setForeground(Color.BLACK);
        StdIdL.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 20));
        b1.add(StdIdL);
        //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
        stdId = new JTextField(20);
        stdId.setFont(new Font("Serif", Font.ITALIC, 16));
        stdId.setPreferredSize(new Dimension(400, 18));
        b1.add(stdId);
        panel.add(b1);
        //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
        JLabel nameLabel = new JLabel("Student Name: ");
        nameLabel.setForeground(Color.BLACK);
        nameLabel.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 20));
        b2.add(nameLabel);
        //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
        userName = new JTextField(20);
        userName.setFont(new Font("Serif", Font.ITALIC, 16));
        userName.setPreferredSize(new Dimension(400, 18));
        b2.add(userName);
        panel.add(b2);
        //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
        JLabel label6 = new JLabel("Gender ");
        label6.setForeground(Color.BLACK);
        label6.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 20));
        b3.add(label6);
        //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
        gender = new JComboBox<>(names);
        gender.setMaximumRowCount(3);
        gender.setBackground(Color.YELLOW);
        add(gender, BorderLayout.CENTER);
        b3.add(gender);
        panel.add(b3);
        //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
        JLabel label7 = new JLabel("Age Group");
        label7.setForeground(Color.BLACK);
        label7.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 20));
        b4.add(label7);
        Age1 = new JRadioButton("0 - 10");
        Age2 = new JRadioButton("10 - 20");
        Age3 = new JRadioButton("20 - 30");
        Age4 = new JRadioButton("30 - 40");
        b4.add(Age1);
        b4.add(Age2);
        b4.add(Age3);
        b4.add(Age4);
        radioGroup1 = new ButtonGroup();
        radioGroup1.add(Age1);
        radioGroup1.add(Age2);
        radioGroup1.add(Age3);
        radioGroup1.add(Age4);
        panel.add(b4);
        //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
        JLabel label8 = new JLabel("Hobbies");
        label8.setForeground(Color.BLACK);
        label8.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 20));
        b5.add(label8);
        cricket = new JCheckBox("Cricket");
        b5.add(cricket);
        badminton = new JCheckBox("Badminton");
        b5.add(badminton);
        racing = new JCheckBox("Racing");
        b5.add(racing);
        gaming = new JCheckBox("Gaming");
        b5.add(gaming);
        panel.add(b5);
        //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
        saveData = new JButton("Save Data");
        saveData.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 16));
        saveData.setForeground(Color.white);
        saveData.setBackground(Color.BLUE);
        panel.add(saveData,BorderLayout.SOUTH);
        //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
        status = new JLabel();
        status.setForeground(Color.RED);
        status.setHorizontalAlignment(JTextField.CENTER);
        panel.add(status);
        //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
        add(panel);
        back = new JButton("BACK");
        back.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 16));
        back.setForeground(Color.white);
        back.setBackground(Color.RED);
        add(back, BorderLayout.SOUTH);
        ind handler = new ind();
        saveData.addActionListener(handler);
        back.addActionListener(handler);
    }
        private class ind implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(file.isFile()){
                        i = new ObjectInputStream( new FileInputStream(file));
                        SA = (ArrayList<StudentAttributes>) i.readObject();
                        idd = (ArrayList<Integer>) i.readObject();
                        i.close();
                    }
                }catch (Exception q){
                    JOptionPane.showMessageDialog(saveData,"File is not read correctly");
                }

                if (e.getSource() == saveData) {
                    try {
                        int USERID =Integer.parseInt(stdId.getText());
                        String NAME = userName.getText();
                        String GENDER = gender.getSelectedItem().toString();
                        getAgeSelection();
                        getHobbySelection();
                        if(!idd.contains(USERID)){
                            StudentAttributes m = new StudentAttributes(NAME,USERID,GENDER,AgeGroup,hobbies);
                            SA.add(m);
                            idd.add(USERID);
                            o = new ObjectOutputStream(new FileOutputStream(file));
                            o.writeObject(SA);
                            o.writeObject(idd);
                            o.close();
                            status.setText("Record Added Successfully");
                        }
                        else{
                            status.setText("UserId Already Exists");
                        }

                        //setVisible(false);
                    }catch(IOException k)
                    {
                        JOptionPane.showMessageDialog(saveData,"File didn't close correctly");
                    }catch(Exception exception){
                        JOptionPane.showMessageDialog(saveData,"Please Enter The Details In Correct Format");
                    }
            }
                if(e.getSource() == back){
                    setVisible(false);
                    MainMenu m = new MainMenu();
                    m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    m.setSize(800, 125);
                    m.setVisible(true);
                }
        }
    public void getHobbySelection(){
        hobbies = "";
        if(cricket.isSelected()){
            hobbies += "Cricket ";
        }
        if(badminton.isSelected()){
            hobbies += "Badminton ";
        }
        if(racing.isSelected()){
            hobbies += "Racing ";
        }
        if(gaming.isSelected()){
            hobbies += "Gaming ";
        }
        else if(!gaming.isSelected() && !racing.isSelected() && !badminton.isSelected() && !cricket.isSelected()){
            hobbies += "No Hobby!";
        }
    }
    public void getAgeSelection(){
        AgeGroup = " ";
        if (Age1.isSelected()){
            AgeGroup = "0-10";
        }
        else if (Age2.isSelected()){
            AgeGroup = "10-20";
        }
        else if (Age3.isSelected()){
            AgeGroup = "20-30";
        }
        else if (Age4.isSelected()){
            AgeGroup = "30-40";
        }
    }
}
}
