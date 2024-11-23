package hospital.management.system;

import hospital.management.system.conn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener
{
    JFrame f;

    JTextField txtfield;

    JPasswordField pwfield;

    JButton b1,b2;


    login() {
        f = new JFrame("Login");
        f.setLayout(null);
        f.setTitle("Health Desk");
        f.setLocation(300, 250);
        f.setSize(750, 300);
        f.getContentPane().setBackground(new Color(	232	,74	,95));


        JLabel username = new JLabel("Username: ");
        username.setBounds(40,20,100,30);
        username.setForeground(new Color(235, 240, 239));
        username.setFont(new Font("Tahoma",Font.BOLD,16));
        f.add(username);


        JLabel password = new JLabel("Password: ");
        password.setBounds(40,70,100,30);
        password.setForeground(new Color(235, 240, 239));
        password.setFont(new Font("Tahoma",Font.BOLD,16));
        f.add(password);


        txtfield=new JTextField();
        txtfield.setBounds(150,20,150,30);
        f.add(txtfield);


        pwfield=new JPasswordField();
        pwfield.setBounds(150,70,150,30);
        f.add(pwfield);


        b1=new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(new Color(42,54, 59));
        b1.setForeground(Color.WHITE);
        f.add(b1);
        f.setVisible(true);

        b2=new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(new Color(42,54, 59));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        f.add(b2);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()== b1)
        {
            try{
                conn c= new conn();
                String user= txtfield.getText();
                String pass= pwfield.getText();

                String q="select * from login where ID = '"+user+"' and PW = '"+pass+"'";
                ResultSet resultSet=c.statement.executeQuery(q);

                if(resultSet.next()){
                    new Reception();
                    f.setVisible(false);
                    dispose();

                }
                else {
                    JOptionPane.showMessageDialog(null,"Invalid");
                }


            } catch (Exception E) {
                E.printStackTrace();
            }
        }
        else{
            System.exit(10);
        }
    }


    public static void main(String[] arg) {

        new login();
    }


}
