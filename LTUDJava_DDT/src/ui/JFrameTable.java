/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import dao.BanGheDAO;
import entities.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
    static String idTab;
    private static JFrameTable instance;

    public static JFrameTable getInstance() {
        return instance;
    }

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
        //jButtonSelectTable.setText(idTab);
        LoadTable();
        
    }

    public void LoadTable() {
        
        jPanelTable.removeAll();
        List<Banghe> lstBG = this.bgd.GetAll();
        int temp = 6 - lstBG.size() % 6;
        if (lstBG.size() > 0) {

            for (int i = 0; i < lstBG.size(); i++) {
                JButton bt = new JButton();
                bt.setPreferredSize(new Dimension(150, 130));
                Border bd = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
                bt.setBorder(bd);
                Font f = new Font("Tamaho", Font.BOLD, 18);
                bt.setFont(f);
                bt.setVisible(true);
                jPanelTable.add(bt);

                bt.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jButtonSelectTable.setText(bt.getText());
                    }

                });

                bt.setText(lstBG.get(i).getMaBan());
                //  Trangthai tt = lstBG.get(i).getTrangthai();
                String maTrangThai = lstBG.get(i).getTrangthai().getMaTt();
                if (maTrangThai.equals("TTBG01")) {// bàn trống
                    bt.setBackground(Color.LIGHT_GRAY);
                } else if (maTrangThai.equals("TTBG02")) {// có khách
                    bt.setBackground(Color.RED);
                } else if (maTrangThai.equals("TTBG03")) {// Đang gọi món
                    bt.setBackground(Color.yellow);
                } else if (maTrangThai.equals("TTBG04")) {// đã đủ món
                    bt.setBackground(Color.GREEN);
                }
            }
            if (temp < 6) {
                for (int i = 0; i < temp; i++) {
                    JButton bt = new JButton();
                    bt.setPreferredSize(new Dimension(150, 130));
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
        jLabel2 = new javax.swing.JLabel();
        jPanelOptionTable = new javax.swing.JPanel();
        jButtonSelectTable = new javax.swing.JButton();
        jLabelOrder = new javax.swing.JLabel();
        jLabelInfor = new javax.swing.JLabel();
        jLabelJoninMove = new javax.swing.JLabel();
        jLabelProvisional = new javax.swing.JLabel();
        jLabelPayment = new javax.swing.JLabel();
        jPanelTable = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelOption.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tùy chọn", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jButton1.setText("Thoát");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout jPanelOptionLayout = new javax.swing.GroupLayout(jPanelOption);
        jPanelOption.setLayout(jPanelOptionLayout);
        jPanelOptionLayout.setHorizontalGroup(
            jPanelOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOptionLayout.createSequentialGroup()
                .addGroup(jPanelOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelOptionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelOptionLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel2)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanelOptionLayout.setVerticalGroup(
            jPanelOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOptionLayout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(jLabel2)
                .addGap(141, 141, 141)
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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelOrderMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelOrderMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelOrderMouseExited(evt);
            }
        });

        jLabelInfor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_thongtinban.png"))); // NOI18N
        jLabelInfor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelInforMouseClicked(evt);
            }
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
                .addGap(0, 0, Short.MAX_VALUE))
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Trạng thái bàn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jButton2.setBackground(java.awt.Color.white);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Bàn trống");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Bàn đang có khách");

        jButton3.setBackground(java.awt.Color.red);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Bàn đang gọi menu");

        jButton4.setBackground(java.awt.Color.yellow);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Bàn đã đủ menu");

        jButton5.setBackground(java.awt.Color.green);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(60, 60, 60)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(60, 60, 60)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(60, 60, 60)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addGap(50, 50, 50)
                        .addComponent(jPanelTable, javax.swing.GroupLayout.PREFERRED_SIZE, 986, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jPanelOptionTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanelOption, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelOptionTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelTable, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3))
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

    private void jLabelInforMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelInforMouseClicked
        idTab = jButtonSelectTable.getText();
        JDialogInfoTable jd = new JDialogInfoTable(this, true);
        //jd.setUndecorated(true);
        jd.setResizable(false);
        Toolkit tk = Toolkit.getDefaultToolkit();
        int x = (int) (tk.getScreenSize().getWidth()) / 2;
        int y = (int) (tk.getScreenSize().getHeight()) / 2;
        jd.setSize(x, y);
        // jd.setBackground(Color.yellow);
        jd.setLocationRelativeTo(null);
        jd.pack();

        jd.setVisible(true);

        //  this.setVisible(false);

    }//GEN-LAST:event_jLabelInforMouseClicked

    private void jLabelOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelOrderMouseClicked
        JDialogOrder jdo = new JDialogOrder(this, true);
        jdo.setResizable(false);
        jdo.setLocationRelativeTo(this);
        jdo.pack();
        jdo.setVisible(true);
    }//GEN-LAST:event_jLabelOrderMouseClicked

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
                JFrameTable frm = new JFrameTable();
                instance = frm;
                frm.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonSelectTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelInfor;
    private javax.swing.JLabel jLabelJoninMove;
    private javax.swing.JLabel jLabelOrder;
    private javax.swing.JLabel jLabelPayment;
    private javax.swing.JLabel jLabelProvisional;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelOption;
    private javax.swing.JPanel jPanelOptionTable;
    private javax.swing.JPanel jPanelTable;
    // End of variables declaration//GEN-END:variables
}
