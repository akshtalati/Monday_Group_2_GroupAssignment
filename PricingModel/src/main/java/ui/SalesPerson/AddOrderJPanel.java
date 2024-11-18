/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.SalesPerson;

import java.awt.CardLayout;
import model.Business.Business;
import model.CustomerManagement.CustomerProfile;
import model.OrderManagement.Order;
import model.OrderManagement.OrderItem;
import model.ProductManagement.Product;
import model.Supplier.Supplier;
import model.UserAccountManagement.UserAccount;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.SalesManagement.SalesPersonProfile;

/**
 *
 * @author varananavadiya
 */
public class AddOrderJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AddOrderJPanel
     */
    JPanel cardSequencePanel;
    Business business;
    UserAccount salesPerson;
    SalesPersonProfile sales;
    Order currentOrder;

    public AddOrderJPanel(JPanel cardSequencePanel, Business business, UserAccount userAccount) {
        initComponents();
        this.cardSequencePanel = cardSequencePanel;
        this.business = business;
        this.salesPerson = userAccount;
        this.sales = (SalesPersonProfile) salesPerson.getAssociatedPersonProfile();
        currentOrder = new Order();
        populateSupplierCombo();
        populateCustomerCombo();
        populateProductTable();
    }

    private void populateCustomerCombo() {
        cmbCustomer.removeAllItems();
        for (CustomerProfile customer : business.getCustomerDirectory().getCustomerList()) {
            cmbCustomer.addItem(customer);
        }
    }

    private void populateSupplierCombo() {
        cmbSupplier1.removeAllItems();
        for (Supplier supplier : business.getSupplierDirectory().getSupplierList()) {
            cmbSupplier1.addItem(supplier);
        }

    }

    private void populateProductTable() {
        DefaultTableModel dtm = (DefaultTableModel) tblProductCatalog.getModel();
        dtm.setRowCount(0);

        Supplier selectedSupplier = (Supplier) cmbSupplier1.getSelectedItem();
        if (selectedSupplier == null) {
            return;
        }
        selectedSupplier.getProductCatalog().getProductList().forEach(product -> {
            Object row[] = new Object[5];
            row[0] = product;
            row[1] = product.getFloorPrice();
            row[2] = product.getCeilingPrice();
            row[3] = product.getTargetPrice();
            row[4] = product.getRecommendedPrice();
            dtm.addRow(row);
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCustomer = new javax.swing.JLabel();
        cmbCustomer = new javax.swing.JComboBox();
        jScrollPaneItemsincart = new javax.swing.JScrollPane();
        tblCart = new javax.swing.JTable();
        lblProductCatalogue = new javax.swing.JLabel();
        jScrollPaneProductCatalog = new javax.swing.JScrollPane();
        tblProductCatalog = new javax.swing.JTable();
        txtNewQuantity = new javax.swing.JTextField();
        btnModifyQuantity = new javax.swing.JButton();
        lblSalesPrice = new javax.swing.JLabel();
        txtSalesPrice = new javax.swing.JTextField();
        btnRemoveOrderItem = new javax.swing.JButton();
        lblQuantity = new javax.swing.JLabel();
        btnCheckOut = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        spnQuantity = new javax.swing.JSpinner();
        lblSupplier = new javax.swing.JLabel();
        btnAddToCart = new javax.swing.JButton();
        cmbSupplier1 = new javax.swing.JComboBox();
        txtSearch = new javax.swing.JTextField();
        lblItemsInCart = new javax.swing.JLabel();
        btnSearchProduct = new javax.swing.JButton();
        btnSubmitOrder = new javax.swing.JButton();
        lblOrderPricePerfomance = new javax.swing.JLabel();
        txtOrderPricePerfomance = new javax.swing.JTextField();
        lblOrderTotal = new javax.swing.JLabel();
        txtOrderTotal = new javax.swing.JTextField();
        lblOrderAboveTarget = new javax.swing.JLabel();
        txtOrderAboveTarget = new javax.swing.JTextField();
        lblNumberOfOrdersAboveTarget = new javax.swing.JLabel();
        txtNumberOfOrderItemsAboveTarget = new javax.swing.JTextField();

        setBackground(new java.awt.Color(204, 204, 204));

        lblCustomer.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblCustomer.setText("Customer :");

        cmbCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCustomerActionPerformed(evt);
            }
        });

        tblCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Item Name", "Price", "Quantity", "Total Amount", "Margin Value"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPaneItemsincart.setViewportView(tblCart);

        lblProductCatalogue.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblProductCatalogue.setText("Product Catalog:");

        tblProductCatalog.setFont(new java.awt.Font("Lucida Grande", 0, 13)); // NOI18N
        tblProductCatalog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Name", "Floor Price", "Ceiling Price", "Target Price", "Recommended Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPaneProductCatalog.setViewportView(tblProductCatalog);

        btnModifyQuantity.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        btnModifyQuantity.setText("Modify Quantity");
        btnModifyQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyQuantityActionPerformed(evt);
            }
        });

        lblSalesPrice.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblSalesPrice.setText("Sales Price:");

        btnRemoveOrderItem.setBackground(new java.awt.Color(51, 153, 255));
        btnRemoveOrderItem.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        btnRemoveOrderItem.setForeground(new java.awt.Color(255, 255, 255));
        btnRemoveOrderItem.setText("Remove");
        btnRemoveOrderItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveOrderItemActionPerformed(evt);
            }
        });

        lblQuantity.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblQuantity.setText("Quantity:");

        btnCheckOut.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        btnCheckOut.setText("Analyze");
        btnCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckOutActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(51, 153, 255));
        btnBack.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        spnQuantity.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        lblSupplier.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblSupplier.setText("  Supplier :");

        btnAddToCart.setBackground(new java.awt.Color(51, 153, 255));
        btnAddToCart.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        btnAddToCart.setForeground(new java.awt.Color(255, 255, 255));
        btnAddToCart.setText("Add to Cart");
        btnAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToCartActionPerformed(evt);
            }
        });

        cmbSupplier1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSupplier1ActionPerformed(evt);
            }
        });

        lblItemsInCart.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblItemsInCart.setText("Items in cart:");

        btnSearchProduct.setBackground(new java.awt.Color(51, 153, 255));
        btnSearchProduct.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        btnSearchProduct.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchProduct.setText("Search Product");
        btnSearchProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchProductActionPerformed(evt);
            }
        });

        btnSubmitOrder.setBackground(new java.awt.Color(51, 153, 255));
        btnSubmitOrder.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        btnSubmitOrder.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmitOrder.setText("Submit Order");
        btnSubmitOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitOrderActionPerformed(evt);
            }
        });

        lblOrderPricePerfomance.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblOrderPricePerfomance.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblOrderPricePerfomance.setText("Order Price Perfomance :");

        lblOrderTotal.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblOrderTotal.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblOrderTotal.setText("Total Order:");

        lblOrderAboveTarget.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblOrderAboveTarget.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblOrderAboveTarget.setText("Is Order Above Target:");

        lblNumberOfOrdersAboveTarget.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblNumberOfOrdersAboveTarget.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblNumberOfOrdersAboveTarget.setText("Number Of Order Items Above Target :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSearchProduct)
                                .addGap(18, 18, 18)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblCustomer)
                                .addGap(18, 18, 18)
                                .addComponent(cmbCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmbSupplier1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jScrollPaneItemsincart, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPaneProductCatalog, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblProductCatalogue)
                                                    .addComponent(lblItemsInCart))
                                                .addGap(367, 367, 367))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnModifyQuantity)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtNewQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                                .addComponent(btnCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(86, 86, 86)
                                                .addComponent(btnSubmitOrder)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnRemoveOrderItem))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(lblSalesPrice)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtSalesPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lblQuantity)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(spnQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnAddToCart, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(lblOrderAboveTarget)
                                                .addComponent(lblNumberOfOrdersAboveTarget)
                                                .addComponent(lblOrderTotal)
                                                .addComponent(lblOrderPricePerfomance))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtNumberOfOrderItemsAboveTarget, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtOrderAboveTarget, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtOrderTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtOrderPricePerfomance, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addContainerGap(50, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cmbCustomer, cmbSupplier1});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblNumberOfOrdersAboveTarget, lblOrderAboveTarget, lblOrderPricePerfomance, lblOrderTotal});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCheckOut, btnSubmitOrder});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCustomer))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSupplier1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(lblProductCatalogue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneProductCatalog, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSalesPrice)
                    .addComponent(txtSalesPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQuantity)
                    .addComponent(spnQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddToCart))
                .addGap(18, 18, 18)
                .addComponent(lblItemsInCart)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneItemsincart, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModifyQuantity)
                    .addComponent(txtNewQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoveOrderItem)
                    .addComponent(btnSubmitOrder)
                    .addComponent(btnCheckOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOrderPricePerfomance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOrderPricePerfomance))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOrderTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOrderTotal))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOrderAboveTarget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOrderAboveTarget))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumberOfOrdersAboveTarget)
                    .addComponent(txtNumberOfOrderItemsAboveTarget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblOrderAboveTarget, lblOrderPricePerfomance, lblOrderTotal});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnModifyQuantity, txtNewQuantity});

    }// </editor-fold>//GEN-END:initComponents

    private void cmbCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCustomerActionPerformed
        // TODO add your handling code here:
        currentOrder = business.getMasterOrderList().newOrder((CustomerProfile) cmbCustomer.getSelectedItem(), sales);

    }//GEN-LAST:event_cmbCustomerActionPerformed

    private void btnModifyQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyQuantityActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblCart.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select an item from the cart", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        OrderItem oi = (OrderItem) tblCart.getValueAt(selectedRow, 0);
        int newQuantity = 0;
        try {
            newQuantity = Integer.parseInt(txtNewQuantity.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter valid quantity", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (newQuantity <= 0) {
            JOptionPane.showMessageDialog(null, "Quantity should be greater than 0", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        currentOrder.modifyQuantity(oi, newQuantity);
        populateCartTable();
        analyse();
    }//GEN-LAST:event_btnModifyQuantityActionPerformed

    private void btnRemoveOrderItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveOrderItemActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblCart.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select an item from the cart", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        OrderItem oi = (OrderItem) tblCart.getValueAt(selectedRow, 0);
        currentOrder.removeOrderItem(oi);
        populateCartTable();
        analyse();
    }//GEN-LAST:event_btnRemoveOrderItemActionPerformed

    private void btnCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckOutActionPerformed
        // TODO add your handling code here:
        analyse();
         }//GEN-LAST:event_btnCheckOutActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        backAction();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToCartActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblProductCatalog.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a product from the table", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Product product = (Product) tblProductCatalog.getValueAt(selectedRow, 0);
        int actualPrice = 0;
        int quant = 0;

        try {
            actualPrice = Integer.parseInt(txtSalesPrice.getText());
            quant = (int) spnQuantity.getValue();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter valid sales price and quantity", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (quant <= 0) {
            JOptionPane.showMessageDialog(null, "Quantity should be greater than 0", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        currentOrder.newOrderItem(product, actualPrice, quant);
        populateCartTable();
        analyse();

    }//GEN-LAST:event_btnAddToCartActionPerformed

    private void populateCartTable() {
        DefaultTableModel model = (DefaultTableModel) tblCart.getModel();
        model.setRowCount(0);
        for (OrderItem oi : currentOrder.getOrderItemList()) {
            Object row[] = new Object[5];
            row[0] = oi;
            row[1] = oi.getActualPrice();
            row[2] = oi.getQuantity();
            row[3] = oi.getQuantity() * oi.getActualPrice();
            row[4] = (oi.getQuantity() * oi.getActualPrice()) - oi.getOrderItemTargetTotal();
            model.addRow(row);
        }

    }

    private void cmbSupplier1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSupplier1ActionPerformed
        // TODO add your handling code here:
        populateProductTable();
    }//GEN-LAST:event_cmbSupplier1ActionPerformed

    private void btnSearchProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchProductActionPerformed
        // TODO add your handling code here:
        String productName = txtSearch.getText();
        populateProductTable(productName);
    }//GEN-LAST:event_btnSearchProductActionPerformed

    private void btnSubmitOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitOrderActionPerformed
        // TODO add your handling code here:
        currentOrder.Submit();
        backAction();
        //backAction();
    }//GEN-LAST:event_btnSubmitOrderActionPerformed

    private void populateProductTable(String productName) {
        DefaultTableModel model = (DefaultTableModel) tblProductCatalog.getModel();
        model.setRowCount(0);

        for (Supplier s : business.getSupplierDirectory().getSupplierList()) {
            for (Product p : s.getProductCatalog().getProductList()) {
                if (productName.equalsIgnoreCase(p.getProductName())) {
                    Object row[] = new Object[4];
                    row[0] = p;
                    row[1] = p.getFloorPrice();
                    row[2] = p.getCeilingPrice();
                    row[3] = p.getTargetPrice();
                    model.addRow(row);
                }
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToCart;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCheckOut;
    private javax.swing.JButton btnModifyQuantity;
    private javax.swing.JButton btnRemoveOrderItem;
    private javax.swing.JButton btnSearchProduct;
    private javax.swing.JButton btnSubmitOrder;
    private javax.swing.JComboBox cmbCustomer;
    private javax.swing.JComboBox cmbSupplier1;
    private javax.swing.JScrollPane jScrollPaneItemsincart;
    private javax.swing.JScrollPane jScrollPaneProductCatalog;
    private javax.swing.JLabel lblCustomer;
    private javax.swing.JLabel lblItemsInCart;
    private javax.swing.JLabel lblNumberOfOrdersAboveTarget;
    private javax.swing.JLabel lblOrderAboveTarget;
    private javax.swing.JLabel lblOrderPricePerfomance;
    private javax.swing.JLabel lblOrderTotal;
    private javax.swing.JLabel lblProductCatalogue;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblSalesPrice;
    private javax.swing.JLabel lblSupplier;
    private javax.swing.JSpinner spnQuantity;
    private javax.swing.JTable tblCart;
    private javax.swing.JTable tblProductCatalog;
    private javax.swing.JTextField txtNewQuantity;
    private javax.swing.JTextField txtNumberOfOrderItemsAboveTarget;
    private javax.swing.JTextField txtOrderAboveTarget;
    private javax.swing.JTextField txtOrderPricePerfomance;
    private javax.swing.JTextField txtOrderTotal;
    private javax.swing.JTextField txtSalesPrice;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    private void analyse() {
        txtOrderPricePerfomance.setText(String.valueOf(currentOrder.getOrderPricePerformance()));
        txtNumberOfOrderItemsAboveTarget.setText(String.valueOf(currentOrder.getNumberOfOrderItemsAboveTarget()));
        txtOrderAboveTarget.setText(String.valueOf(currentOrder.isOrderAboveTotalTarget()));
        txtOrderTotal.setText(String.valueOf(currentOrder.getOrderTotal()));
    }

    private void backAction() {
        cardSequencePanel.remove(this);
        CardLayout layout = (CardLayout) cardSequencePanel.getLayout();
        layout.previous(cardSequencePanel);
    }
}
