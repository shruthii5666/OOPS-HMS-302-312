package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Patient_discharge extends JFrame {
    Patient_discharge(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,490);
        panel.setBackground(new Color(232	,74	,95));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("CHECK OUT");
        label.setBounds(100,20,150,20);
        label.setFont(new Font("Tahoma",Font.BOLD,20));
        label.setForeground(Color.WHITE);
        panel.add(label);

        JLabel label2 = new JLabel("Customer Id");
        label2.setBounds(30,80,150,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(200,80,150,25);
        panel.add(choice);

        try{
            conn c= new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from Patient_info");
            while(resultSet.next())
            {
                choice.add(resultSet.getString("number"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number");
        label3.setBounds(30,130,150,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JLabel RNo = new JLabel();
        RNo.setBounds(200,130,150,20);
        RNo.setFont(new Font("Tahoma",Font.BOLD,14));
        RNo.setForeground(Color.WHITE);
        panel.add(RNo);

        JLabel label4 = new JLabel("In Time");
        label4.setBounds(30,180,150,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JLabel INTime = new JLabel();
        INTime.setBounds(200,180,250,20);
        INTime.setFont(new Font("Tahoma",Font.BOLD,14));
        INTime.setForeground(Color.WHITE);
        panel.add(INTime);

        JLabel label5 = new JLabel("Out Time");
        label5.setBounds(30,230,150,20);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        Date date = new Date();

        JLabel OUTTime = new JLabel(""+date);
        OUTTime.setBounds(200,230,250,20);
        OUTTime.setFont(new Font("Tahoma",Font.BOLD,14));
        OUTTime.setForeground(Color.WHITE);
        panel.add(OUTTime);

        JButton discharge = new JButton("Discharge");
        discharge.setBounds(30,300,120,30);
        discharge.setBackground(Color.black);
        discharge.setForeground(Color.white);
        panel.add(discharge);
        discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c= new conn();
                try{
                    // Step 1: Retrieve Room_Number associated with the selected patient Number
                    ResultSet rs = c.statement.executeQuery("SELECT Room_Number FROM Patient_info WHERE Number='" + choice.getSelectedItem() + "'");
                    String roomNumber = null;
                    if (rs.next()) {
                        roomNumber = rs.getString("Room_Number");
                    }

// Step 2: Delete the row from Patient_info
                    c.statement.executeUpdate("DELETE FROM Patient_info WHERE Number='" + choice.getSelectedItem() + "'");

// Step 3: Update the Room table only if Room_Number was found
                    if (roomNumber != null) {
                        c.statement.executeUpdate("UPDATE Room SET Availability = 'Available' WHERE Room_No = '" + roomNumber + "'");
                    }

                    JOptionPane.showMessageDialog(null,"Done");
                    setVisible(false);

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });

        JButton Check = new JButton("Check");
        Check.setBounds(170,300,120,30);
        Check.setBackground(Color.black);
        Check.setForeground(Color.white);
        panel.add(Check);
        /*Check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c= new conn();
                try{
                    ResultSet resultSet = c.statement.executeQuery("select * from Patient_info where number='"+ choice.getSelectedItem()+"'");
                    while(resultSet.next()){
                        RNo.setText(resultSet.getString("Room"));
                        INTime.setText(resultSet.getString("Time"));
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });*/

        Check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                try {
                    ResultSet resultSet = c.statement.executeQuery("select * from Patient_info where number='" + choice.getSelectedItem() + "'");
                    if (resultSet.next()) {  // Use if since we expect a single row for the selected number
                        RNo.setText(resultSet.getString("Room_Number"));    // Make sure column name matches exactly in your database
                        INTime.setText(resultSet.getString("Time")); // Make sure column name matches exactly in your database
                    } else {
                        JOptionPane.showMessageDialog(null, "No record found for selected patient number.");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error fetching patient information: " + ex.getMessage());
                }
            }
        });


        JButton Back = new JButton("Back");
        Back.setBounds(300,300,120,30);
        Back.setBackground(Color.black);
        Back.setForeground(Color.white);
        panel.add(Back);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setUndecorated(true);
        setLayout(null);
        setSize(1000,500);
        setLocation(350,200);
        setVisible(true);


    }


    public static void main(String[] args) {
        new Patient_discharge();
    }
}



