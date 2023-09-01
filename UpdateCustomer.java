// import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;





public class UpdateCustomer  {
    
      JFrame frame = new JFrame("Update Customer");
      JButton Update = new JButton("Update");
      JButton cancel = new JButton("Cancel");

     JLabel idLabel,FirstNameLabel,LastNameLabel,NumberLabel,freeLabel;
      JTextField idTextField,FirstNameTextField,LastNameTextField,NumberTextField;
      UpdateCustomer()
      {   
               frame.setBounds(400, 200, 500, 500);
               frame.setVisible(true);

                idLabel = new JLabel("id :");
               FirstNameLabel = new JLabel("FirstName :");
               LastNameLabel = new JLabel("LastName :");
                NumberLabel = new JLabel("Number :");
              
               freeLabel = new JLabel("");

               idTextField = new JTextField();
               FirstNameTextField = new JTextField();
               LastNameTextField = new JTextField();
                NumberTextField = new JTextField();
               

               Update.setBounds(200,400,80,30);
               cancel.setBounds(100,400,80,30);
               // SetBounds for labels
               idLabel.setBounds(100,20,150,40);
               FirstNameLabel.setBounds(100,70,150,40);
               LastNameLabel.setBounds(100,110,150,40);
                NumberLabel.setBounds(100,160,150,40);
             
               
               // SetBounds for TextFiels
               idTextField.setBounds(200, 20, 150, 30);
               FirstNameTextField.setBounds(200, 70, 150, 30);
               LastNameTextField.setBounds(200, 110, 150, 30);
               NumberTextField.setBounds(200, 160, 150, 30);
              

               frame.add(idLabel);
               frame.add(idTextField);
               frame.add(FirstNameLabel);
               frame.add(FirstNameTextField);
               frame.add(LastNameLabel);
               frame.add(LastNameTextField);
               frame.add( NumberLabel);
               frame.add( NumberTextField);
               frame.add(cancel);
               frame.add(Update);
               frame.add(freeLabel);
              

             
          Update.addActionListener(new ActionListener() {
            
            @Override  
        
          public void actionPerformed(ActionEvent e){
              int ID=Integer.parseInt(idTextField.getText());
              String DB_URL = "jdbc:mysql://localhost:3306/suraj";
              String USER = "root";
              String PASS = "";
               try {
              Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
              Statement stmt = conn.createStatement();
              String sql = "UPDATE cutomer set first_Name='"+FirstNameTextField.getText()+"' ,last_Name='"+LastNameTextField.getText()+"' ,phone_Number='"+Long.parseLong(NumberTextField.getText())+"' Where ID = "+ID;
              stmt.executeUpdate(sql);
              System.out.println("Record Update successfully...");
          } catch (Exception s) {
              s.printStackTrace();
          }
            }
          });
          cancel.addActionListener(event-> {
            
            frame.dispose();
          });
          }
        
}