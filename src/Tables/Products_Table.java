/**
  The Tables package provides classes for creating and manipulating tables of data.
  This includes classes for defining table structures, inserting and deleting rows and columns, 
  and querying and modifying data in tables.
 */
package Tables;
import MainFrames.Menu;
import MainFrames.AddProducts;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
/**
 The Product_Table class represents a graphical user interface for displaying product data in a table format.
  It extends the javax.swing.JFrame class to create a window for displaying the data.
  This class includes methods for setting up the table, adding data to it, and updating the view.
  <p>This class is designed to be used in conjunction with a database system that stores product data.</p>
  @author woola
 */
public class Products_Table extends javax.swing.JFrame {
     //Declaring Variables

    /**
     *
     */
    Connection con;

    /**
     *
     */
    PreparedStatement statement;

    /**
     *
     */
    Statement st;

    /**
     *
     */
    String cs;

    /**
     *
     */
    String user;

    /**
     *
     */
    String password;

    /**
     *
     */
    String query;

    /**
     *
     */
    ResultSet rs;

    /**
     *
     */
    String records;

    /**
     *
     */
    int count = 0;

    /**
     *
     */
    DefaultTableModel model;

    /**
     Constructs a new Products_Table object and initializes the user interface components.
     */
    public Products_Table() {
         // Initializing the user interface components
        con = null;
        st = null;
        cs = "jdbc:mysql://localhost:3306/inventorydatabase";
        user = "root";
        password = "";
        initComponents();
         //Connect to the database and execute a query to retrieve product data and display it into a table.
         try{
            Class.forName("com.mysql.jdbc.Driver"); //register the driver
            con = DriverManager.getConnection(cs, user, password);
            st = con.createStatement();
            query = "SELECT Name, Price, Number, Category, Quantity, Supplier FROM product";
            rs = st.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            int cols = rsmd.getColumnCount();
            String[] colName = new String[cols];
            for (int i = 0; i < cols; i++) {
            colName[i] = rsmd.getColumnName(i+1);
            }
            model = new DefaultTableModel();
            model.setColumnIdentifiers(colName); // setting the column headers
            table.setModel(model); // setting the table model on JTable
            String Name, Price, Number, Category, Quantity, Supplier;
            while (rs.next()){
                Name = rs.getString(1);
                Price = rs.getString(2);
                Number = rs.getString(3);
                Category = rs.getString(4);
                Quantity = rs.getString(5);
                Supplier = rs.getString(6);
                String[] row = {Name, Price, Number, Category, Quantity, Supplier};
            model.addRow(row);
            }
            st.close();
            con.close();
            }
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Products_Table.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnaddnewproducts = new javax.swing.JButton();
        btnback = new javax.swing.JButton();
        line = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table);

        btnaddnewproducts.setBackground(new java.awt.Color(102, 255, 102));
        btnaddnewproducts.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        btnaddnewproducts.setForeground(new java.awt.Color(255, 255, 255));
        btnaddnewproducts.setText("Add New Products");
        btnaddnewproducts.setToolTipText("click to  add new products");
        btnaddnewproducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddnewproductsActionPerformed(evt);
            }
        });

        btnback.setText("Back");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        line.setBackground(java.awt.Color.blue);
        line.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnaddnewproducts))
            .addComponent(line, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnaddnewproducts, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(line, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
      Handles the event when the "addNewProduct" button is clicked.
      <p>This method is called when the user clicks the "add new product" button in the user interface.
      It opens the add new product form once clicked.</p>
      @param evt the ActionEvent object representing the event will occur
     */
    private void btnaddnewproductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddnewproductsActionPerformed
        //calling the add product from:
        AddProducts addproducts = new AddProducts();
        addproducts.show();
        dispose();
    }//GEN-LAST:event_btnaddnewproductsActionPerformed
    /**
      Handles the event when the "back" button is clicked.
      <p>This method is called when the user clicks the "back" button in the user interface.
      It closes the product form and loads the menu form.</p>
      @param evt the ActionEvent object represent the event that will occur
     */
    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        //calling the menu form:
        Menu menu = new Menu();
        menu.show();
        dispose();

    }//GEN-LAST:event_btnbackActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Products_Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Products_Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Products_Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Products_Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Products_Table().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaddnewproducts;
    private javax.swing.JButton btnback;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator line;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
