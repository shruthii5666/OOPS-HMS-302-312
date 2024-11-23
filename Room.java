package hospital.management.system;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Room extends JFrame{
    JTable table;
    Choice choice;
    Room()
    {
        JPanel panel=new JPanel();
        panel.setBounds(5,5,890,490);
        panel.setBackground(new Color(232	,74	,95));
        panel.setLayout(null);
        add(panel);

        JLabel status=new JLabel("Status: ");
        status.setBounds(600,60,186,31);
        status.setForeground(new Color(42,54, 59));
        status.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(status);

        JLabel For=new JLabel("Search For Room");
        For.setBounds(250,11,250,34);
        For.setForeground(new Color(42,54, 59));
        For.setFont(new Font("Tahoma",Font.BOLD,24));
        panel.add(For);

        choice =new Choice();
        choice.setBounds(680,65,120,20);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);


        table=new JTable();
        table.setBounds(40,100,500,330);
        table.setBackground(new Color(232	,74	,95));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try{
            conn c=new conn();
            String q="Select * from Room";
            ResultSet rs= c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        JLabel label1=new JLabel("Room No");
        label1.setBounds(42,70,80,15);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        label1.setForeground(new Color(42,54, 59));
        panel.add(label1);

        JLabel label2=new JLabel("Availability");
        label2.setBounds(170,70,80,15);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setForeground(new Color(42,54, 59));
        panel.add(label2);

        JLabel label3=new JLabel("Price");
        label3.setBounds(295,70,80,15);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setForeground(new Color(42,54, 59));
        panel.add(label3);

        JLabel label4=new JLabel("Room Type");
        label4.setBounds(420,70,80,15);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(new Color(42,54, 59));
        panel.add(label4);


        JButton search=new JButton("Search");
        search.setBounds(200,440,120,30);
        search.setBackground(new Color(42,54, 59));
        search.setForeground(Color.WHITE);
        panel.add(search);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q="Select * from Room where Availability ='"+choice.getSelectedItem()+"'";
                try{
                    conn c= new conn();
                    ResultSet rs=c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(rs));

                }catch (Exception E)
                {
                    E.printStackTrace();

                }
            }
        });

        JButton back=new JButton("Back");
        back.setBounds(350,440,120,30);
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
        setSize(900,500);
        setLayout(null);
        setLocation(400,200);
        setVisible(true);
    }
    public static void main(String[] arg)
    {
        new Room();

    }
}
