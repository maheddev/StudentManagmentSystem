import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;

public class MainMenu extends JFrame {
    ArrayList<StudentAttributes> SA  = new ArrayList<>();
    File file = new File("Data.txt");
    ObjectOutputStream o =null;
    ObjectInputStream i = null;
    JLabel status = new JLabel();
    JButton add, delete, update, Search, signOut;
    AddStudent adds;
    ListIterator li=null;
    public MainMenu(){
        super("Students Management System");
        //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
        setLayout(new BorderLayout());
        //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
        JPanel panel = new JPanel();
        //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
        add = new JButton(" Add Student ");
        add.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 16));
        add.setForeground(Color.white);
        add.setBackground(Color.BLUE);
        panel.add(add);
        //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
        delete = new JButton("Delete Student");
        delete.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 16));
        delete.setForeground(Color.white);
        delete.setBackground(Color.BLUE);
        panel.add(delete);
        //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
        Search = new JButton("Search Student");
        Search.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 16));
        Search.setForeground(Color.white);
        Search.setBackground(Color.BLUE);
        panel.add(Search);
        //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
        update = new JButton("Update Student");
        update.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 16));
        update.setForeground(Color.white);
        update.setBackground(Color.BLUE);
        panel.add(update);
        //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
        signOut = new JButton("Sign out");
        signOut.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 16));
        signOut.setForeground(Color.white);
        signOut.setBackground(Color.RED);
        signOut.setSize(10,20);
        add(signOut,BorderLayout.SOUTH);
        //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
        status.setForeground(Color.red);
        panel.add(status);
        add(panel,BorderLayout.CENTER);
        innerClass handeler =new innerClass();
        add.addActionListener(handeler);
        delete.addActionListener(handeler);
        update.addActionListener(handeler);
        Search.addActionListener(handeler);
        signOut.addActionListener(handeler);
    }
    private class innerClass implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String s;
            try{
                if(file.isFile()){
                    i = new ObjectInputStream(new FileInputStream(file));
                    SA = (ArrayList<StudentAttributes>) i.readObject();
                    i.close();
                }
            }
            catch (Exception j){
                status.setText("File Not Found");
            }
            if (e.getSource() == add){
                setVisible(false);
                adds = new AddStudent();
                adds.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                adds.setSize(480,350);
                adds.setVisible(true);
            }
            else if(e.getSource() == delete){
                s = JOptionPane.showInputDialog("Enter the ID no. to Delete");
                li = SA.listIterator();
                while(li.hasNext()){
                    StudentAttributes sa = (StudentAttributes)li.next();
                    if(sa.getsId() == Integer.parseInt(s)){
                        SA.remove(sa);
                        try{
                            o = new ObjectOutputStream(new FileOutputStream(file));
                            o.writeObject(SA);
                            o.close();
                            JOptionPane.showMessageDialog(null,"Student Deleted Successfully");
                        }
                        catch (Exception k){
                            JOptionPane.showInputDialog(null, "File Not Found");
                        }
                    }
                    else{
                        add(new JLabel("ID not Found"));
                    }
                }

            }
            else if (e.getSource() == update){
                setVisible(false);
                s = JOptionPane.showInputDialog("Enter the User ID, You want to update");
                li = SA.listIterator();
                while (li.hasNext()){
                    StudentAttributes sa = (StudentAttributes) li.next();
                    if(sa.getsId() == Integer.parseInt(s)){
                        adds = new AddStudent();
                        adds.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        adds.setSize(500,270);
                        adds.setVisible(true);
                        adds.stdId.setText(sa.getsId()+"");
                        adds.stdId.setEditable(false);
                        adds.userName.setText(sa.getsName()+"");
                        adds.gender.setSelectedItem(sa.getsGender()+"");
                        SA.remove(sa);

                        try{
                            o = new ObjectOutputStream(new FileOutputStream(file));
                            o.writeObject(SA);
                            o.close();
                            add(new JLabel("Data Updated"));
                        }
                        catch (Exception E){
                            add(new JLabel("Data not Updated"));
                        }
                    }
                    else {
                        add(new JLabel("ID not Found"));
                    }
                }
            }
            else if(e.getSource() == Search){
                s = JOptionPane.showInputDialog("Enter User Id you want to Search");
                li = SA.listIterator();
                while (li.hasNext()){
                    StudentAttributes sa = (StudentAttributes) li.next();
                    if(sa.getsId() == Integer.parseInt(s)){
                        JOptionPane.showMessageDialog(null,sa);
                        break;
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"ID not Found");
                        break;
                    }
                }
            }
            else if(e.getSource() == signOut){
                setVisible(false);
                AdminLoginPage A = new AdminLoginPage();
                A.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                A.setSize(850,175);
                A.setVisible(true);
            }
        }
    }
}