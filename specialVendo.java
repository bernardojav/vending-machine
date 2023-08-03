
import java.util.HashMap;
import java.util.Map;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author molin
 */
public class specialVendo extends javax.swing.JFrame {
    
    private Map<String, Integer> itemQuantities;

    
    /**
     * Creates new form specialVendo
     */
    public specialVendo() {
        initComponents();
        
        itemQuantities = new HashMap<>();
        itemQuantities.put("Tocino", 5); // Initialize with initial quantities
        itemQuantities.put("Corn Beef", 5);
        itemQuantities.put("Hotdog", 5);
        itemQuantities.put("Tapa", 5);
        itemQuantities.put("Coke", 5);
        itemQuantities.put("Sprite", 5);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        butToc = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        butCor = new javax.swing.JRadioButton();
        butHot = new javax.swing.JRadioButton();
        butTapa = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        radCoke = new javax.swing.JRadioButton();
        radSpri = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        radKet = new javax.swing.JRadioButton();
        radGar = new javax.swing.JRadioButton();
        radVin = new javax.swing.JRadioButton();
        butOrder = new javax.swing.JButton();
        butClear = new javax.swing.JButton();
        but_return = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel1.setText("Special Vending Machine");

        butToc.setText("Tocino (150 Calories) - P 200");
        butToc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butTocActionPerformed(evt);
            }
        });

        jRadioButton2.setText("jRadioButton2");

        butCor.setText("Corn Beef (150 Calories) - P 200");
        butCor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butCorActionPerformed(evt);
            }
        });

        butHot.setText("Hotdog (150 Calories) - P 200");
        butHot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butHotActionPerformed(evt);
            }
        });

        butTapa.setText("Tapa (150 Calories) - P 200");
        butTapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butTapaActionPerformed(evt);
            }
        });

        jLabel2.setText("Ulam");

        jLabel3.setText("Drinks");

        radCoke.setText("Coke (100 Calories) - P200");
        radCoke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radCokeActionPerformed(evt);
            }
        });

        radSpri.setText("Sprite (100 Calories) - P200");
        radSpri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radSpriActionPerformed(evt);
            }
        });

        jLabel4.setText("Condiments");

        radKet.setText("Ketchup");

        radGar.setText("Fried Garlic");

        radVin.setText("Vinegar ");

        butOrder.setText("Order");
        butOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butOrderActionPerformed(evt);
            }
        });

        butClear.setText("Clear");
        butClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butClearActionPerformed(evt);
            }
        });

        but_return.setText("Main Menu");
        but_return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_returnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(radCoke)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radSpri))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(butOrder))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(radKet)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radGar)
                                .addGap(18, 18, 18)
                                .addComponent(radVin))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(butClear)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                                .addComponent(but_return)))))
                .addGap(100, 100, 100))
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(butToc)
                    .addComponent(butHot))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(butCor)
                    .addComponent(butTapa))
                .addGap(51, 51, 51))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(210, Short.MAX_VALUE)
                    .addComponent(jRadioButton2)
                    .addContainerGap(210, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butToc)
                    .addComponent(butCor))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butHot)
                    .addComponent(butTapa))
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radCoke)
                    .addComponent(radSpri))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radGar)
                            .addComponent(radVin)
                            .addComponent(radKet))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(butOrder)
                            .addComponent(butClear)
                            .addComponent(but_return))
                        .addGap(42, 42, 42))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(179, Short.MAX_VALUE)
                    .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(201, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void butTocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butTocActionPerformed
                if(butToc.isSelected())
            butTapa.setSelected(false);
        butHot.setSelected(false);
        butCor.setSelected(false);
    }//GEN-LAST:event_butTocActionPerformed

    private void butHotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butHotActionPerformed
        if(butHot.isSelected())
            butTapa.setSelected(false);
        butToc.setSelected(false);
        butCor.setSelected(false);
    }//GEN-LAST:event_butHotActionPerformed

    private void butCorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butCorActionPerformed
        if(butCor.isSelected())
            butTapa.setSelected(false);
        butToc.setSelected(false);
        butHot.setSelected(false);
    }//GEN-LAST:event_butCorActionPerformed

    private void butTapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butTapaActionPerformed
        if(butTapa.isSelected())
            butHot.setSelected(false);
        butToc.setSelected(false);
        butCor.setSelected(false);
    }//GEN-LAST:event_butTapaActionPerformed

    private void radCokeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radCokeActionPerformed
        if(radCoke.isSelected())
            radSpri.setSelected(false);
    }//GEN-LAST:event_radCokeActionPerformed

    private void radSpriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radSpriActionPerformed
        if(radSpri.isSelected())
            radCoke.setSelected(false);
    }//GEN-LAST:event_radSpriActionPerformed

    private void decrementQuantity(String itemName) {
        if (itemQuantities.containsKey(itemName)) {
            int currentQuantity = itemQuantities.get(itemName);
            if (currentQuantity > 0) {
                itemQuantities.put(itemName, currentQuantity - 1);
            }
        }
    }
    
    /**
     *
     * @param itemName
     * @return
     */
    public int getItemQuantity(String itemName) {
        if (itemQuantities.containsKey(itemName)) {
            return itemQuantities.get(itemName);
        }
        return 0; // Default to 0 if item not found
    }
    
    private void butOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butOrderActionPerformed
       // enter order procced to payment 
       
               double price = 200; // for fried rice and egg
        double calories = 60;
        
        if (butToc.isSelected()) {
    price += 200;
    calories += 150;
    decrementQuantity("Tocino");
} 
        if (butHot.isSelected()) {
    price += 200;
    calories += 150;
    decrementQuantity("Hotdog");
} 
        if (butCor.isSelected()) {
    price += 200;
    calories += 150;
    decrementQuantity("Corned Beef");
} 
        if (butTapa.isSelected()) {
    price += 200;
    calories += 150;
    decrementQuantity("Tapa");
} 
        if (radCoke.isSelected()) {
    price += 200;
    calories += 100;
    decrementQuantity("Coke");
} 
        if (radSpri.isSelected()) {
    price += 200;
    calories += 100;
    decrementQuantity("Sprite");
} 
        if (radKet.isSelected()){
            calories += 10;
        }
        
        if (radGar.isSelected()){
            calories += 10;
        }
        if (radVin.isSelected()){
            calories += 10;
        }
        

        
       
        payment pay = new payment();

// Set text in t_Price and t_Cal fields
pay.getT_Price().setText(String.valueOf(price));
pay.getT_Cal().setText(String.valueOf(calories));

        pay.show();
        
    }//GEN-LAST:event_butOrderActionPerformed

    private void butClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butClearActionPerformed
        butTapa.setSelected(false);
        butToc.setSelected(false);
        butHot.setSelected(false);
        radSpri.setSelected(false);
         radCoke.setSelected(false);
         butCor.setSelected(false);
         radKet.setSelected(false);
         radVin.setSelected(false);
         radGar.setSelected(false);
        
    }//GEN-LAST:event_butClearActionPerformed

    private void but_returnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_returnActionPerformed
        mainGUI.getInstance().setVisible(true); // Show the mainGUI instance
    dispose(); // Close the current window
    }//GEN-LAST:event_but_returnActionPerformed

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
            java.util.logging.Logger.getLogger(specialVendo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(specialVendo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(specialVendo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(specialVendo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new specialVendo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butClear;
    private javax.swing.JRadioButton butCor;
    private javax.swing.JRadioButton butHot;
    private javax.swing.JButton butOrder;
    private javax.swing.JRadioButton butTapa;
    private javax.swing.JRadioButton butToc;
    private javax.swing.JButton but_return;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton radCoke;
    private javax.swing.JRadioButton radGar;
    private javax.swing.JRadioButton radKet;
    private javax.swing.JRadioButton radSpri;
    private javax.swing.JRadioButton radVin;
    // End of variables declaration//GEN-END:variables
}
