// import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;



public class AddMedicine  {
  
      JFrame frame = new JFrame("Add Medicine");
      JButton Save = new JButton("Save");
      JButton cancel = new JButton("Cancel");

      JLabel MedicineNameLabel,MedicinePriceLabel,QuantityLabel,freeLabel;
      JTextField MedicineNameTextField,MedicinePriceTextField,QuantityTextField;
      int id;
      AddMedicine()
      {   
               frame.setBounds(400, 200, 500, 500);
               frame.setVisible(true);

               MedicineNameLabel = new JLabel("MedicineName :");
               MedicinePriceLabel = new JLabel("MedicinePrice:");
               QuantityLabel = new JLabel("Quantity:");
              
               freeLabel = new JLabel("");

               MedicineNameTextField = new JTextField();
               MedicinePriceTextField = new JTextField();
                QuantityTextField = new JTextField();
               

              Save.setBounds(200,400,80,30);
               cancel.setBounds(100,400,80,30);
               // SetBounds for labels
               MedicineNameLabel.setBounds(100,50,150,40);
                MedicinePriceLabel.setBounds(100,100,150,40);
                QuantityLabel.setBounds(100,150,150,40);
             
               
               // SetBounds for TextFiels
               MedicineNameTextField.setBounds(200, 50, 150, 30);
               MedicinePriceTextField.setBounds(200, 100, 150, 30);
               QuantityTextField.setBounds(200, 150, 150, 30);
              



               frame.add(MedicineNameLabel);
               frame.add(MedicineNameTextField);
               frame.add(MedicinePriceLabel);
               frame.add(MedicinePriceTextField);
               frame.add( QuantityLabel);
               frame.add( QuantityTextField);
               frame.add(cancel);
               frame.add(Save);
               frame.add(freeLabel);
              
            
          Save.addActionListener(new ActionListener() {
            
            @Override  
        
          public void actionPerformed(ActionEvent e){
          
              String DB_URL = "jdbc:mysql://localhost:3306/suraj";
              String USER = "root";
              String PASS = "";
               try {
              Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
              Statement stmt = conn.createStatement();
              String sql =  "insert into `medicine`"+"(`Medicine_name`, `Medicine_price`, `Quantity`)"
               + "values('" + MedicineNameTextField.getText() + "','" + MedicinePriceTextField.getText() + "','" + Long.parseLong(QuantityTextField.getText())+ "')";
              stmt.executeUpdate(sql);
              System.out.println("Record Save successfully...");
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