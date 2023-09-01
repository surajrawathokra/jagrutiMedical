// import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
public class SaleMedicine {
      JFrame frame = new JFrame("Sale Medicine");
      JButton save = new JButton("Save");
      JButton cancel = new JButton("Cancel");
      JLabel MedicineIDLabel,MedicinePriceLabel,freeLabel;
      JTextField MedicineIDTextField,MedicinePriceTextField;
    
      SaleMedicine ()
      {   
        
               frame.setBounds(400, 200, 500, 500);
               frame.setVisible(true);

               MedicineIDLabel = new JLabel("MedicineID:");
               MedicinePriceLabel = new JLabel("MedicinePrice:");
               
              
               freeLabel = new JLabel("");

               MedicineIDTextField = new JTextField();
               MedicinePriceTextField = new JTextField();
               
               

               save.setBounds(200,400,80,30);
               cancel.setBounds(100,400,80,30);
               // SetBounds for labels
               MedicineIDLabel.setBounds(100,50,150,40);
               MedicinePriceLabel.setBounds(100,100,150,40);
               
             
               
               // SetBounds for TextFiels
               MedicineIDTextField.setBounds(200, 50, 150, 30);
              MedicinePriceTextField.setBounds(200, 100, 150, 30);
              
               frame.add(MedicineIDLabel);
               frame.add(MedicineIDTextField);
               frame.add(MedicinePriceLabel);
               frame.add(MedicinePriceTextField);
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
            String sql =  "insert into `salemedicine`"+"(`Medicine_ID`, `Medicine_Price`)"
             + "values('" + MedicineIDTextField.getText() + "','" + MedicinePriceTextField.getText() +  "')";
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