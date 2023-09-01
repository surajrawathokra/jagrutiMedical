// import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
public class AddCustomer {
      JFrame frame = new JFrame("Add Customer");
      JButton save = new JButton("Save");
      JButton cancel = new JButton("Cancel");
      JLabel FirstNameLabel,LastNameLabel,NumberLabel,freeLabel;
      JTextField FirstNameTextField,LastNameTextField,NumberTextField;
      AddCustomer()
      {   
               frame.setBounds(400, 200, 500, 500);
               frame.setVisible(true);

               FirstNameLabel = new JLabel("FirstName :");
               LastNameLabel = new JLabel("LastName :");
                NumberLabel = new JLabel("Number :");
              
               freeLabel = new JLabel("");

               FirstNameTextField = new JTextField();
               LastNameTextField = new JTextField();
                NumberTextField = new JTextField();
               

               save.setBounds(200,400,80,30);
               cancel.setBounds(100,400,80,30);
               // SetBounds for labels
               FirstNameLabel.setBounds(100,50,150,40);
               LastNameLabel.setBounds(100,100,150,40);
                NumberLabel.setBounds(100,150,150,40);
             
               
               // SetBounds for TextFiels
               FirstNameTextField.setBounds(200, 50, 150, 30);
               LastNameTextField.setBounds(200, 100, 150, 30);
               NumberTextField.setBounds(200, 150, 150, 30);
              



               frame.add(FirstNameLabel);
               frame.add(FirstNameTextField);
               frame.add(LastNameLabel);
               frame.add(LastNameTextField);
               frame.add( NumberLabel);
               frame.add( NumberTextField);
               frame.add(cancel);
               frame.add(save);
               frame.add(freeLabel);
              

          save.addActionListener(new ActionListener() {
            
          @Override  
      
        public void actionPerformed(ActionEvent e){
        
            String DB_URL = "jdbc:mysql://localhost:3306/suraj";
            String USER = "root";
            String PASS = "";
             try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            String sql =  "insert into `cutomer`"+"(`first_Name`, `last_Name`, `phone_Number`)"
             + "values('" + FirstNameTextField.getText() + "','" + LastNameTextField.getText() + "','" + Long.parseLong(NumberTextField.getText())+ "')";
            stmt.executeUpdate(sql);
            System.out.println("Record Add successfully...");
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
                
        
// }