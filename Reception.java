package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//JButton bt1;

class Reception extends JFrame {
    Reception(){
        JPanel panel1= new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(0,155,1525,670);
        panel1.setBackground(new Color(	42,54, 59));
        add(panel1);

        JPanel panel2= new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(0,0,1525,150);
        panel2.setBackground(new Color(	232	,74	,95));
        add(panel2);

        JButton bt1= new JButton(("Add New Patient"));
        bt1.setBounds(30,25,200,30);
        bt1.setBackground(new Color(255,255,255));
        bt1.setForeground(Color.BLACK);
        bt1.setFont(new Font("Tahoma",Font.BOLD,16));
        panel1.add(bt1);
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new New_patient();
            }
        });

        JButton bt2 = new JButton("Room");
        bt2.setBounds(30,75,200,30);
        bt2.setBackground(new Color(255,255,255));
        bt2.setForeground(Color.BLACK);
        bt2.setFont(new Font("Tahoma",Font.BOLD,16));
        panel1.add(bt2);
        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Room();
            }
        });

        JButton bt3 = new JButton("Employee Info");
        bt3.setBounds(30,125,200,30);
        bt3.setBackground(new Color(255,255,255));
        bt3.setForeground(Color.BLACK);
        bt3.setFont(new Font("Tahoma",Font.BOLD,16));
        panel1.add(bt3);
        bt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Employee_info();
            }
        });

        JButton bt4 = new JButton("Patient Info");
        bt4.setBounds(30,175,200,30);
        bt4.setBackground(new Color(255,255,255));
        bt4.setForeground(Color.BLACK);
        bt4.setFont(new Font("Tahoma",Font.BOLD,16));
        panel1.add(bt4);
        bt4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new  Patient_info();
            }
        });

        JButton bt5 = new JButton("Patient Discharge");
        bt5.setBounds(30,225,200,30);
        bt5.setBackground(new Color(255,255,255));
        bt5.setForeground(Color.BLACK);
        bt5.setFont(new Font("Tahoma",Font.BOLD,16));
        panel1.add(bt5);
        bt5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Patient_discharge();
            }
        });

        JButton bt6 = new JButton("Logout");
        bt6.setBounds(30,275,200,30);
        bt6.setBackground(new Color(255,255,255));
        bt6.setForeground(Color.BLACK);
        bt6.setFont(new Font("Tahoma",Font.BOLD,16));
        panel1.add(bt6);
        bt6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //new Logout();
                setVisible(false);
                new login();
            }
        });

       // setSize(1500,750);
        setBounds(-5,0,1500,750);
        getContentPane().setBackground(new Color(225,225,225));
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Reception();
    }
}
