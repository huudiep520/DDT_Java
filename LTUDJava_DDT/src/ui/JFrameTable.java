/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import dao.BanGheDAO;
import entities.*;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author xFactor520
 */
public class JFrameTable extends javax.swing.JFrame {
    private final Nhanvien nv; // lưu thông tin nhân viên
    private final BanGheDAO bgd = new BanGheDAO();
    
    public JFrameTable() {
        this.setUndecorated(true);
        //this.setAlwaysOnTop(true);
        this.setResizable(false);
        this.setVisible(true);
        
        initComponents();
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = (int) tk.getScreenSize().getWidth();
        int ySize = (int) tk.getScreenSize().getHeight();
        
        this.setSize(xSize, ySize);
        
        nv = JFrameLogin.nv;
        
        LoadTable();
        
    }

    private void LoadTable(){
       
        List<Banghe> lstBG = this.bgd.GetAll();
        int temp = 5 - lstBG.size()%5;
        if(lstBG.size()>0){
            
            for(int i=0; i<lstBG.size();i++){
                JButton bt = new JButton();
                bt.setPreferredSize(new Dimension(170, 150));
                Border bd = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
                bt.setBorder(bd);
                Font f = new Font("Tamaho", Font.BOLD, 18);
                bt.setFont(f);
                bt.setVisible(true);
                jPanelTable.add(bt);
                
                bt.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jButtonSelectTable.setText(bt.getText());
                    }
                    
                });
                
                bt.setText(lstBG.get(i).getMaBan());
                
            }
            if(temp<5){
                for(int i=0;i<temp;i++){
                    JButton bt = new JButton();
                    bt.setPreferredSize(new Dimension(170, 150));
                    Border bd = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
                    bt.setBorder(bd);
                    bt.setVisible(true);
                    jPanelTable.add(bt);
                }
            }
            
        }

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelOption = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanelOptionTable = new javax.swing.JPanel();
        jButtonSelectTable = new javax.swing.JButton();
        jLabelOrder = new javax.swing.JLabel();
        jLabelInfor = new javax.swing.JLabel();
        jLabelJoninMove = new javax.swing.JLabel();
        jLabelProvisional = new javax.swing.JLabel();
        jLabelPayment = new javax.swing.JLabel();
        jPanelTable = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelOption.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tùy chọn", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jButton1.setText("Thoát");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelOptionLayout = new javax.swing.GroupLayout(jPanelOption);
        jPanelOption.setLayout(jPanelOptionLayout);
        jPanelOptionLayout.setHorizontalGroup(
            jPanelOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOptionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanelOptionLayout.setVerticalGroup(
            jPanelOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOptionLayout.createSequentialGroup()
                .addGap(297, 297, 297)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelOptionTable.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thao tác bàn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jButtonSelectTable.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonSelectTable.setForeground(new java.awt.Color(255, 51, 0));
        jButtonSelectTable.setText("0");
        jButtonSelectTable.setEnabled(false);

        jLabelOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_goimon.png"))); // NOI18N
        jLabelOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelOrderMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelOrderMouseExited(evt);
            }
        });

        jLabelInfor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_thongtinban.png"))); // NOI18N
        jLabelInfor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelInforMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelInforMouseExited(evt);
            }
        });

        jLabelJoninMove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_gop_chuyen.png"))); // NOI18N
        jLabelJoninMove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelJoninMoveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelJoninMoveMouseExited(evt);
            }
        });

        jLabelProvisional.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_tamtinh.png"))); // NOI18N
        jLabelProvisional.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelProvisionalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelProvisionalMouseExited(evt);
            }
        });

        jLabelPayment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_thanhtoan.png"))); // NOI18N
        jLabelPayment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelPaymentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelPaymentMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelOptionTableLayout = new javax.swing.GroupLayout(jPanelOptionTable);
        jPanelOptionTable.setLayout(jPanelOptionTableLayout);
        jPanelOptionTableLayout.setHorizontalGroup(
            jPanelOptionTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOptionTableLayout.createSequentialGroup()
                .addComponent(jButtonSelectTable, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabelOrder)
                .addGap(50, 50, 50)
                .addComponent(jLabelInfor)
                .addGap(50, 50, 50)
                .addComponent(jLabelJoninMove)
                .addGap(50, 50, 50)
                .addComponent(jLabelProvisional)
                .addGap(50, 50, 50)
                .addComponent(jLabelPayment)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanelOptionTableLayout.setVerticalGroup(
            jPanelOptionTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOptionTableLayout.createSequentialGroup()
                .addComponent(jButtonSelectTable, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
            .addGroup(jPanelOptionTableLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanelOptionTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPayment)
                    .addComponent(jLabelProvisional)
                    .addComponent(jLabelJoninMove)
                    .addComponent(jLabelInfor)
                    .addComponent(jLabelOrder))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanelOptionTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jPanelTable, javax.swing.GroupLayout.PREFERRED_SIZE, 938, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelOption, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelOptionTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelTable, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabelOrderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelOrderMouseEntered
        ImageIcon II = new ImageIcon(getClass().getResource("/Images/btn_hover_goimon.png"));
        jLabelOrder.setIcon(II);
    }//GEN-LAST:event_jLabelOrderMouseEntered

    private void jLabelOrderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelOrderMouseExited
        
        ImageIcon II = new ImageIcon(getClass().getResource("/Images/btn_goimon.png"));
        jLabelOrder.setIcon(II);
    }//GEN-LAST:event_jLabelOrderMouseExited

    private void jLabelInforMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelInforMouseEntered
        ImageIcon II = new ImageIcon(getClass().getResource("/Images/btn_hover_thongtinban.png"));
        jLabelInfor.setIcon(II);
    }//GEN-LAST:event_jLabelInforMouseEntered

    private void jLabelInforMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelInforMouseExited
        ImageIcon II = new ImageIcon(getClass().getResource("/Images/btn_thongtinban.png"));
        jLabelInfor.setIcon(II);
    }//GEN-LAST:event_jLabelInforMouseExited

    private void jLabelJoninMoveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelJoninMoveMouseEntered
        ImageIcon II = new ImageIcon(getClass().getResource("/Images/btn_hover_gop_chuyen.png"));
        jLabelJoninMove.setIcon(II);
    }//GEN-LAST:event_jLabelJoninMoveMouseEntered

    private void jLabelJoninMoveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelJoninMoveMouseExited
         ImageIcon II = new ImageIcon(getClass().getResource("/Images/btn_gop_chuyen.png"));
        jLabelJoninMove.setIcon(II);
    }//GEN-LAST:event_jLabelJoninMoveMouseExited

    private void jLabelProvisionalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProvisionalMouseEntered
         ImageIcon II = new ImageIcon(getClass().getResource("/Images/btn_hover_tamtinh.png"));
        jLabelProvisional.setIcon(II);
    }//GEN-LAST:event_jLabelProvisionalMouseEntered

    private void jLabelProvisionalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProvisionalMouseExited
         ImageIcon II = new ImageIcon(getClass().getResource("/Images/btn_tamtinh.png"));
        jLabelProvisional.setIcon(II);
    }//GEN-LAST:event_jLabelProvisionalMouseExited

    private void jLabelPaymentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPaymentMouseEntered
        ImageIcon II = new ImageIcon(getClass().getResource("/Images/btn_hover_thanhtoan.png"));
        jLabelPayment.setIcon(II);
    }//GEN-LAST:event_jLabelPaymentMouseEntered

    private void jLabelPaymentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPaymentMouseExited
         ImageIcon II = new ImageIcon(getClass().getResource("/Images/btn_thanhtoan.png"));
        jLabelPayment.setIcon(II);
    }//GEN-LAST:event_jLabelPaymentMouseExited

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
            java.util.logging.Logger.getLogger(JFrameTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonSelectTable;
    private javax.swing.JLabel jLabelInfor;
    private javax.swing.JLabel jLabelJoninMove;
    private javax.swing.JLabel jLabelOrder;
    private javax.swing.JLabel jLabelPayment;
    private javax.swing.JLabel jLabelProvisional;
    private javax.swing.JPanel jPanelOption;
    private javax.swing.JPanel jPanelOptionTable;
    private javax.swing.JPanel jPanelTable;
    // End of variables declaration//GEN-END:variables
}
