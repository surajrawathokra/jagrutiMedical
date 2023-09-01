import javax.swing.*;
//import javax.awt.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

// import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {

     public static void main(String[] args) throws Exception {

          JFrame f = new JFrame("Medical Store");
          JMenuBar mb = new JMenuBar();
          JMenu menu1 = new JMenu("Customer");
          JMenuItem cuostmer1 = new JMenuItem("Add cuostmer");
          JMenuItem cuostmer2 = new JMenuItem("Update cuostmer");
          JMenuItem cuostmer3 = new JMenuItem("Delete cuostmer");
          JMenuItem cuostmer4 = new JMenuItem("View All cuostmer");
          menu1.add(cuostmer1);
          menu1.add(cuostmer2);
          menu1.add(cuostmer3);
          menu1.add(cuostmer4);

          JMenu menu2 = new JMenu("Medicine");
          JMenuItem Medicine1 = new JMenuItem("Add Medicine");
          JMenuItem Medicine2 = new JMenuItem("Update Medicine");
          JMenuItem Medicine3 = new JMenuItem("Delete Medicine");
          JMenuItem Medicine4 = new JMenuItem("View Medicine");
          menu2.add(Medicine1);
          menu2.add(Medicine2);
          menu2.add(Medicine3);
          menu2.add(Medicine4);

          JMenu menu3 = new JMenu("Invetry");
          JMenuItem Invetry1 = new JMenuItem("Sale Medicine");
          JMenuItem Invetry2 = new JMenuItem("View Medicine");

          menu3.add(Invetry1);
          menu3.add(Invetry2);

          mb.add(menu1);
          mb.add(menu2);
          mb.add(menu3);
          f.setJMenuBar(mb);

          f.setSize(400, 400);
          f.setLayout(null);
          f.setVisible(true);
          cuostmer1.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                    new AddCustomer();

               }

          });
          cuostmer2.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {

                    new UpdateCustomer();
               }

          });
         

          cuostmer3.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {

                    new DeleteCustomer();
               }

          });
          
         
             cuostmer4.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e){
               
          
          // Start ShowAllSides Query     
         
               String url = "jdbc:mysql://localhost:3306/suraj";
               String username = "root";
               String password = "";

               try {
                    JFrame viewFrameCUstomer = new JFrame("view all Customer");
                    Connection connection = DriverManager.getConnection(url, username, password);
                    String query1 = "select * from `cutomer`";
                    PreparedStatement preparedStatement = connection.prepareStatement(query1);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    DefaultTableModel tableModal = new DefaultTableModel();
                    tableModal.addColumn("ID");
                    tableModal.addColumn("first_Name");
                    tableModal.addColumn("last_Name");
                    tableModal.addColumn("phone_Number");
                    

                    while (resultSet.next()) {
                         int showID = resultSet.getInt("ID");
                         String first_Name = resultSet.getString("first_Name");
                         String last_Name = resultSet.getString("last_Name");
                         String phone_Number = resultSet.getString("phone_Number");
                        

                         tableModal.addRow(new Object[] { showID, first_Name, last_Name, phone_Number });
                    }
                    JTable sideTable = new JTable(tableModal);
                    JScrollPane scrollPane = new JScrollPane(sideTable);
                    // Assuming 'fram' in your Frame
                    viewFrameCUstomer.getContentPane().removeAll();
                    // Remove Previos Content           
                    viewFrameCUstomer.getContentPane().add(scrollPane);
                    viewFrameCUstomer.revalidate();// Refrash JFrame
                    resultSet.close();
                    preparedStatement.close();
                    connection.close();
                    viewFrameCUstomer.setSize(600, 400);
                    viewFrameCUstomer.setTitle("Customer List");
                    viewFrameCUstomer.setVisible(true);
                   // System.out.println("yes");
                    // fram.setVisible(true);     
                    // fram.setSize(600, 400);
               } catch (SQLException ex) {
                    ex.printStackTrace();
                    System.out.println("no");

               
          }}
          });


          Medicine1.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                    new AddMedicine();

               }

          });
          Medicine2.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {

                    new UpdateMedicine();
               }

          });
          Medicine3.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {

                    new DeleteMedicine();
               }

          });

         Medicine4.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e){
               
          
          // Start ShowAllSides Query     
         
               String url = "jdbc:mysql://localhost:3306/suraj";
               String username = "root";
               String password = "";

               try {
                    JFrame viewFrameCUstomer = new JFrame("view all Medicine");
                    Connection connection = DriverManager.getConnection(url, username, password);
                    String query1 = "select * from `medicine`";
                    PreparedStatement preparedStatement = connection.prepareStatement(query1);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    DefaultTableModel tableModal = new DefaultTableModel();
                    tableModal.addColumn("id");
                    tableModal.addColumn("Medicine_name");
                    tableModal.addColumn("Medicine_price");
                    tableModal.addColumn("Quantity");
                    

                    while (resultSet.next()) {
                         int showid = resultSet.getInt("id");
                         String Medicine_name = resultSet.getString("Medicine_name");
                         String Medicine_price = resultSet.getString("Medicine_price");
                         String Quantity= resultSet.getString("Quantity");
                        

                         tableModal.addRow(new Object[] { showid, Medicine_name, Medicine_price, Quantity });
                    }
                    JTable sideTable = new JTable(tableModal);
                    JScrollPane scrollPane = new JScrollPane(sideTable);
                    // Assuming 'fram' in your Frame
                    viewFrameCUstomer.getContentPane().removeAll();
                    // Remove Previos Content           
                    viewFrameCUstomer.getContentPane().add(scrollPane);
                    viewFrameCUstomer.revalidate();// Refrash JFrame
                    resultSet.close();
                    preparedStatement.close();
                    connection.close();
                    viewFrameCUstomer.setSize(600, 400);
                    viewFrameCUstomer.setTitle("Medicine List");
                    viewFrameCUstomer.setVisible(true);
                   // System.out.println("yes");
                    // fram.setVisible(true);     
                    // fram.setSize(600, 400);
               } catch (SQLException ex) {
                    ex.printStackTrace();
                    System.out.println("no");

               
          }}
          });


          Invetry1.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {

                    new SaleMedicine();
               }

          });

          Invetry2.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e){
               
          
          // Start ShowAllSides Query
         
               String url = "jdbc:mysql://localhost:3306/suraj";
               String username = "root";
               String password = "";

               try {
                    JFrame viewFrameCUstomer = new JFrame("view Sale Medicine");
                    Connection connection = DriverManager.getConnection(url, username, password);
                    String query1 = "select * from `SaleMedicine`";
                    PreparedStatement preparedStatement = connection.prepareStatement(query1);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    DefaultTableModel tableModal = new DefaultTableModel();
                    tableModal.addColumn("ID");
                    tableModal.addColumn("Medicine_ID");
                    tableModal.addColumn("Medicine_Price");
                    

                    while (resultSet.next()) {
                         int showID = resultSet.getInt("ID");
                         String Medicine_ID = resultSet.getString("Medicine_ID");
                         String Medicine_Price = resultSet.getString("Medicine_Price");
                         

                         tableModal.addRow(new Object[] { showID, Medicine_ID, Medicine_Price});
                    }
                    JTable sideTable = new JTable(tableModal);
                    JScrollPane scrollPane = new JScrollPane(sideTable);
                    // Assuming 'fram' in your Frame
                    viewFrameCUstomer.getContentPane().removeAll();
                    // Remove Previos Content           
                    viewFrameCUstomer.getContentPane().add(scrollPane);
                    viewFrameCUstomer.revalidate();// Refrash JFrame
                    resultSet.close();
                    preparedStatement.close();
                    connection.close();
                    viewFrameCUstomer.setSize(600, 400);
                    viewFrameCUstomer.setTitle("SaleMedicine List");
                    viewFrameCUstomer.setVisible(true);
                   // System.out.println("yes");
                    // fram.setVisible(true);     
                    // fram.setSize(600, 400);
               } catch (SQLException ex) {
                    ex.printStackTrace();
                    System.out.println("no");

               
          }}
          });

     }
}
