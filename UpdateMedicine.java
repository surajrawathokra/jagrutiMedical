// import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;



public class UpdateMedicine  {
   
      JFrame frame = new JFrame("Update Medicine");
      JButton Update = new JButton("Update");
      JButton cancel = new JButton("Cancel");

      JLabel idLabel,MedicineNameLabel,MedicinePriceLabel,QuantityLabel,freeLabel;
      JTextField idTextField,MedicineNameTextField,MedicinePriceTextField,QuantityTextField;
      UpdateMedicine()
      {   
               frame.setBounds(400, 200, 500, 500);
               frame.setVisible(true);

               idLabel = new JLabel("id :");
               MedicineNameLabel = new JLabel("MedicineName :");
               MedicinePriceLabel = new JLabel("MedicinePrice:");
               QuantityLabel = new JLabel("Quantity:");
              
               freeLabel = new JLabel("");
               
               idTextField = new JTextField();
               MedicineNameTextField = new JTextField();
               MedicinePriceTextField = new JTextField();
                QuantityTextField = new JTextField();
               

               Update.setBounds(200,400,80,30);
               cancel.setBounds(100,400,80,30);
               // SetBounds for labels
               idLabel.setBounds(100,20,150,40);
               MedicineNameLabel.setBounds(100,70,150,40);
                MedicinePriceLabel.setBounds(100,110,150,40);
                QuantityLabel.setBounds(100,160,150,40);
             
               
               // SetBounds for TextFiels
               idTextField.setBounds(200, 20, 150, 30);
               MedicineNameTextField.setBounds(200, 70, 150, 30);
               MedicinePriceTextField.setBounds(200, 110, 150, 30);
               QuantityTextField.setBounds(200, 160, 150, 30);
              

               frame.add(idLabel);
               frame.add(idTextField);

               frame.add(MedicineNameLabel);
               frame.add(MedicineNameTextField);
               frame.add(MedicinePriceLabel);
               frame.add(MedicinePriceTextField);
               frame.add( QuantityLabel);
               frame.add( QuantityTextField);
               frame.add(cancel);
               frame.add(Update);
               frame.add(freeLabel);
              

              Update.addActionListener(new ActionListener() {
            
                @Override  
            
              public void actionPerformed(ActionEvent e){
                int id=Integer.parseInt(idTextField.getText());
                  String DB_URL = "jdbc:mysql://localhost:3306/suraj";
                  String USER = "root";
                  String PASS = "";
                   try {
                  Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                  Statement stmt = conn.createStatement();
                  String sql =  "UPDATE medicine set Medicine_name='"+MedicineNameTextField.getText()+"' ,Medicine_price='"+MedicinePriceTextField.getText()+"' ,Quantity='"+Long.parseLong(QuantityTextField.getText())+"' Where id = "+id;
                  stmt.executeUpdate(sql);
                  System.out.println("Record UPDATE successfully...");
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