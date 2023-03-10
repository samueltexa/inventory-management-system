/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainFrames;
import Tables.Products_Table;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

    /**
    The AddProduct class extends the javax.swing.JFrame class to provide
    a GUI window for adding a new products to a database.
    The AddProduct class includes the following components:
    A lblName for displaying the product name field label.
    A txtPrice and lblPrice for entering and displaying the product price respectively.
    A lblCategory for displaying the product category field label.
    A lblQuantity for displaying the product quantity field label.
    A btnSave for saving and  submitting the product information.
    A btnClear for clearing all the text fields.
    The AddProducts class also includes methods for setting and getting
    the customer name and address, as well as for submitting the product information to a database.
    @author woola
     */
public final class AddProducts extends javax.swing.JFrame {
     /**
     Declaring connection Variable
     */
    Connection con;

    /**
     Declaring Prepared statement Variable
     */
    PreparedStatement statement;

    /**
     Declaring statement Variable
     */
    Statement st;

    /**
     Declaring local host Variable
     */
    String cs;

    /**
     Declaring connection user Variable
     */
    String user;

    /**
     Declaring connection password Variable
     */
    String password;

    /**
     Declaring MySQL query Variable
     */
    String query;

    /**
     Declaring result Variable
     */
    ResultSet rs;
    /**
     Declaring count Variable
     */
    int count = 0;

    /**
     * Creates new form AddProducts
     */
    public AddProducts() {
        // Initializing the user interface components:
        con = null;
        st = null;
        cs = "jdbc:mysql://localhost:3306/inventorydatabase";
        user = "root";
        password = "";
        initComponents();
        AddDataToSupplier();
        AddDataToCategory();
    }

    /**
     This loads supplier name from the database and adds it to the supplier comboBox
     */
    public void AddDataToSupplier(){
        // Connect to the database and execute a query to add products:
        try {
            Class.forName("com.mysql.jdbc.Driver"); //register the driver
            con = DriverManager.getConnection(cs, user, password);
            query = "SELECT Name FROM suplier";
            st = con.createStatement();           
            statement = con.prepareStatement(query);
            rs = st.executeQuery(query);
             // Iterate over the result set and add items to the comboBox
            while(rs.next()){
                box1.addItem(rs.getString("Name"));   
            }
             box1.setSelectedItem(null);
             txtsupplier.setText(null);
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                con.close();
                statement.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
    }
    
    /**
      This loads product category from the database and adds it to the category comboBox
     */
    public void AddDataToCategory(){
        try {
            Class.forName("com.mysql.jdbc.Driver"); //register the driver
            con = DriverManager.getConnection(cs, user, password);
            query = "SELECT Category FROM product_category";
            st = con.createStatement();           
            statement = con.prepareStatement(query);
            rs = st.executeQuery(query);
            while(rs.next()){
                box2.addItem(rs.getString("Category"));   
            }
             box2.setSelectedItem(null);
             txtcategory.setText(null);
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                con.close();
                statement.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, ex);
            }
        
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

        namelbl = new javax.swing.JLabel();
        pricelbl = new javax.swing.JLabel();
        numberlbl = new javax.swing.JLabel();
        lblquantity = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        txtprice = new javax.swing.JTextField();
        txtnumber = new javax.swing.JTextField();
        txtquantity = new javax.swing.JTextField();
        btnsave = new javax.swing.JButton();
        btnback = new javax.swing.JButton();
        btnclear = new javax.swing.JButton();
        lbldistrict = new javax.swing.JLabel();
        box1 = new javax.swing.JComboBox<>();
        txtsupplier = new javax.swing.JTextField();
        lblcategory = new javax.swing.JLabel();
        txtcategory = new javax.swing.JTextField();
        box2 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Add New Products");

        namelbl.setText("Name");

        pricelbl.setText("Price");

        numberlbl.setText("Number");

        lblquantity.setText("Quantity");

        txtnumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumberActionPerformed(evt);
            }
        });

        btnsave.setBackground(new java.awt.Color(102, 255, 102));
        btnsave.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        btnsave.setForeground(new java.awt.Color(255, 255, 255));
        btnsave.setText("Save");
        btnsave.setToolTipText("click to  add new products");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        btnback.setText("Back");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        btnclear.setText("Clear All");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });

        lbldistrict.setText("Supplier");

        box1.setToolTipText("Select Your Didtrict");
        box1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box1ActionPerformed(evt);
            }
        });

        lblcategory.setText("Category");

        box2.setToolTipText("Select Your Didtrict");
        box2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnback)
                        .addGap(12, 12, 12)
                        .addComponent(namelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnsave))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pricelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numberlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblquantity, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(box2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(btnclear))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 79, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbldistrict, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtprice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtquantity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtsupplier)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(box1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnback)
                        .addComponent(btnsave))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(namelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pricelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(numberlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(box2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblquantity, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtquantity, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(lbldistrict, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(box1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(txtsupplier))
                .addGap(27, 27, 27)
                .addComponent(btnclear)
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumberActionPerformed
    /**
        Handles the event when the "save" button is clicked.
        <p>This method is called when the user clicks the "save" button in the user interface.
        It saves and submits the product data to the database once clicked.</p>
        @param evt the ActionEvent object representing the event will occur
    */
    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
         //declaring variables and iniatializing variables
        String s1 = txtname.getText();
        String s2 = txtprice.getText();
        String s3 = txtnumber.getText();
        String s4 = txtcategory.getText();
        String s5 = txtquantity.getText();
        String s6 = txtsupplier.getText();
        try{
            Class.forName("com.mysql.jdbc.Driver"); //register the driver
            con = DriverManager.getConnection(cs, user, password);
            st = con.createStatement();           
            query = "SELECT * FROM product where Name = '" + s1 + "'";
            ResultSet re1 = st.executeQuery(query);
            if(!s1.equals("") && !s2.equals("") && !s3.equals("") && !s4.equals("")){
                if(re1.next()){
                    JOptionPane.showMessageDialog(null, "Product name already exists");
                }
                else{
                    query = "INSERT INTO product(Name, Price, Number, Category, Quantity, Supplier) VALUES('" + s1 + "','" + s2 +"','" + s3 +"','" + s4 +"','" + s5 +"', '" + s6 +"')";
                    st.executeUpdate(query);// savings
                    JOptionPane.showMessageDialog(null, "Product saved Successfully");
                    txtname.setText("");//make empty
                    txtprice.setText("");//make empty
                    txtnumber.setText("");//make empty
                    txtcategory.setText("");//make empty
                    txtquantity.setText("");//make empty
                     txtsupplier.setText("");//make empty
                    //set focus to txtname
                    txtname.requestFocus();
                }
            }
            else{
            JOptionPane.showMessageDialog(null, "All fields must be filled");
            }
        }
        catch (SQLException | ClassNotFoundException ex){
        }
        finally{
            try {
                if (st != null){
                    st.close();
                }
                if (con != null){
                    con.close();
                }
            }
            catch (SQLException ex){
            }
        }
    }//GEN-LAST:event_btnsaveActionPerformed
    /**
      Handles the event when the "back" button is clicked.
      <p>This method is called when the user clicks the "back" button in the user interface.
      It returns the user to the Product List.</p>
      @param evt the ActionEvent object representing the event will occur occurred
     */
    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        //calling the Products_Table form
        Products_Table product_table = new Products_Table();
        product_table.show();
        dispose();
    }//GEN-LAST:event_btnbackActionPerformed
    /**
      Handles the event when the "clear" button is clicked.
      <p>This method is called when the user clicks the "clear" button in the user interface.
      It clears all  the data in the text fields:.</p>
      @param evt the ActionEvent object representing the event will occur occurred
     */
    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        //clearing all text fields:
        txtname.setText("");//make empty
        txtprice.setText("");//make empty
        txtnumber.setText("");//make empty
        txtcategory.setText("");//make empty
        txtquantity.setText("");//make empty
        txtsupplier.setText("");//make empty
        //set focus to txtname
        txtname.requestFocus();
    }//GEN-LAST:event_btnclearActionPerformed
/**
  Handles the selection of an item in the JComboBox.
  @param evt is the ActionEvent object that trigger this method
 */
    private void box1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box1ActionPerformed
        //sets the data selected from the combo box to the supplier tex field:
        txtsupplier.setText((String) box1.getSelectedItem());

    }//GEN-LAST:event_box1ActionPerformed
/**
  Handles the selection of an item in the JComboBox.
  @param evt is the ActionEvent object that trigger this method
 */
    private void box2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box2ActionPerformed
        //sets the data from the comboBox to the category tex field:
         txtcategory.setText((String) box2.getSelectedItem());
    }//GEN-LAST:event_box2ActionPerformed

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
            java.util.logging.Logger.getLogger(AddProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AddProducts().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> box1;
    private javax.swing.JComboBox<String> box2;
    private javax.swing.JButton btnback;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btnsave;
    private javax.swing.JLabel lblcategory;
    private javax.swing.JLabel lbldistrict;
    private javax.swing.JLabel lblquantity;
    private javax.swing.JLabel namelbl;
    private javax.swing.JLabel numberlbl;
    private javax.swing.JLabel pricelbl;
    private javax.swing.JTextField txtcategory;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtnumber;
    private javax.swing.JTextField txtprice;
    private javax.swing.JTextField txtquantity;
    private javax.swing.JTextField txtsupplier;
    // End of variables declaration//GEN-END:variables
}
