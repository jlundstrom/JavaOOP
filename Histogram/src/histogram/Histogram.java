/*
 * University of Central Florida
 * COP3330 - Fall 2015
 * Author:  Jonathan Lundstrom
 */
package histogram;

import java.io.File;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Histogram extends javax.swing.JFrame {

   /**
    * Creates new form HistoFrame
    */
   public Histogram() {
      initComponents();
      this.setTitle("Sentence Histograms by Jonathan Lundstrom");
   }

   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      topPanel = new javax.swing.JPanel();
      loadButton = new javax.swing.JButton();
      showButton = new javax.swing.JButton();
      numField = new javax.swing.JTextField();
      mainPanel = new javax.swing.JPanel();
      jSplitPane1 = new javax.swing.JSplitPane();
      jScrollPane1 = new javax.swing.JScrollPane();
      sourceArea = new javax.swing.JTextArea();
      outPanel = new histogram.HistogramPanel();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      topPanel.setBackground(new java.awt.Color(230, 240, 255));
      topPanel.setPreferredSize(new java.awt.Dimension(686, 40));

      loadButton.setText("Load File");
      loadButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            loadButtonActionPerformed(evt);
         }
      });
      topPanel.add(loadButton);

      showButton.setText("Show Histo for Sentence");
      showButton.setEnabled(false);
      showButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            showButtonActionPerformed(evt);
         }
      });
      topPanel.add(showButton);

      numField.setColumns(3);
      numField.setEnabled(false);
      numField.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            numFieldActionPerformed(evt);
         }
      });
      topPanel.add(numField);

      getContentPane().add(topPanel, java.awt.BorderLayout.PAGE_START);

      mainPanel.setLayout(new javax.swing.BoxLayout(mainPanel, javax.swing.BoxLayout.X_AXIS));

      jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

      sourceArea.setColumns(20);
      sourceArea.setLineWrap(true);
      sourceArea.setRows(5);
      jScrollPane1.setViewportView(sourceArea);

      jSplitPane1.setLeftComponent(jScrollPane1);

      outPanel.setBackground(new java.awt.Color(230, 230, 230));
      outPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
         public void componentResized(java.awt.event.ComponentEvent evt) {
            outPanelComponentResized(evt);
         }
      });

      javax.swing.GroupLayout outPanelLayout = new javax.swing.GroupLayout(outPanel);
      outPanel.setLayout(outPanelLayout);
      outPanelLayout.setHorizontalGroup(
         outPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 128, Short.MAX_VALUE)
      );
      outPanelLayout.setVerticalGroup(
         outPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 256, Short.MAX_VALUE)
      );

      jSplitPane1.setRightComponent(outPanel);

      mainPanel.add(jSplitPane1);

      getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

      pack();
   }// </editor-fold>//GEN-END:initComponents
   
   private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
        //Handle open button action.
        sourceArea.setText("");
        if (evt.getSource() == loadButton) {
            JFileChooser fDialog = new JFileChooser();
            int returnVal = fDialog.showOpenDialog(this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fDialog.getSelectedFile();
                showButton.setEnabled(true);
                numField.setEnabled(true);
                sourceArea.setText(outPanel.readFile(file));
            } else {
                showButton.setEnabled(false);
                numField.setEnabled(false);
            } 
       }

   }//GEN-LAST:event_loadButtonActionPerformed

   private void showButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showButtonActionPerformed
       String numIn = numField.getText();
       int i;
       try
       {
            i = Integer.parseInt(numIn);
            outPanel.showHisto(i, true);
       } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Text field is not an integer");
       }
   }//GEN-LAST:event_showButtonActionPerformed

   private void numFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numFieldActionPerformed
      showButtonActionPerformed( evt );
   }//GEN-LAST:event_numFieldActionPerformed

   private void outPanelComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_outPanelComponentResized
      outPanel.showHisto();
   }//GEN-LAST:event_outPanelComponentResized

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
      } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(Histogram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      
        //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new Histogram().setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JSplitPane jSplitPane1;
   private javax.swing.JButton loadButton;
   private javax.swing.JPanel mainPanel;
   private javax.swing.JTextField numField;
   private histogram.HistogramPanel outPanel;
   private javax.swing.JButton showButton;
   private javax.swing.JTextArea sourceArea;
   private javax.swing.JPanel topPanel;
   // End of variables declaration//GEN-END:variables


}