package hospital.management.system;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employee_info extends JFrame {
    Employee_info() {
        JPanel panel=new JPanel();
        panel.setBounds(5,5,990,490);
        panel.setBackground(new Color(232,74	,95));
        panel.setLayout(null);
        add(panel);

        JTable table=new JTable();
        table.setBounds(10,45,980,400);
        table.setBackground(new Color(232	,74	,95));
        table.setForeground(Color.WHITE);
        table.setFont(new Font("Tahoma",Font.BOLD,12));
        panel.add(table);

        try
        {
            conn c=new conn();
            String q="select * from emp_info";
            ResultSet rs= c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        JLabel label1= new JLabel("Name");
        label1.setBounds(40,15,70,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        label1.setForeground(new Color(42,54, 59));
        panel.add(label1);

        JLabel label2= new JLabel("Age");
        label2.setBounds(180,15,70,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setForeground(new Color(42,54, 59));
        panel.add(label2);

        JLabel label3= new JLabel("Phone Number");
        label3.setBounds(340,15,150,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setForeground(new Color(42,54, 59));
        panel.add(label3);

        JLabel label4= new JLabel("Salary");
        label4.setBounds(505,15,70,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(new Color(42,54, 59));
        panel.add(label4);

        JLabel label5= new JLabel("Gmail");
        label5.setBounds(670,15,70,20);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        label5.setForeground(new Color(42,54, 59));
        panel.add(label5);

        JLabel label6= new JLabel("Aadhar Number");
        label6.setBounds(830,15,150,20);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        label6.setForeground(new Color(42,54, 59));
        panel.add(label6);

        JButton back=new JButton("Back");
        back.setBounds(430,440,120,30);
        back.setBackground(new Color(42,54, 59));
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(1000,500);
        setLocation(350,200);
        setLayout(null);
        setVisible(true);

    }
    public static void main(String[] args)
    {
        new Employee_info();
    }
}
