
package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Patient_info extends JFrame {

    Patient_info(){

        JPanel panel=new JPanel();
        panel.setBounds(5,5,990,490);
        panel.setBackground(new Color(232	,74	,95));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,45,980,400);
        table.setBackground(new Color(232	,74	,95));
        panel.add(table);

        try{
            conn c= new conn();
            String q= "select * from Patient_info";
            ResultSet resultSet= c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));


        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("ID");
        label1.setBounds(31,11,100,14);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2= new JLabel("Name");
        label2.setBounds(145,11,100,14);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

        JLabel label3 = new JLabel("Number");
        label3.setBounds(265,11,100,14);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label3);

        JLabel label4 = new JLabel("Gender");
        label4.setBounds(380,11,100,14);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label4);

        JLabel label5 = new JLabel("Disease");
        label5.setBounds(500,11,100,14);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label5);

        JLabel label6 = new JLabel("Room Number");
        label6.setBounds(625,11,110,14);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label6);

        JLabel label7 = new JLabel("Time");
        label7.setBounds(745,11,100,14);
        label7.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label7);

        JLabel label8 = new JLabel("Deposit");
        label8.setBounds(870,11,100,14);
        label8.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label8);

        JButton but= new JButton("Back");
        but.setBounds(450,510,120,30);
        but.setBackground(Color.BLACK);
        but.setForeground(Color.WHITE);
        panel.add(but);
        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        setUndecorated(true);

        setUndecorated(true);
        setLayout(null);
        setSize(1000,500);
        setLocation(350,200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Patient_info();

    }
}
