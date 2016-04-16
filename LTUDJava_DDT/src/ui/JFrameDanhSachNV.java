/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import javax.swing.table.DefaultTableModel;
import entities.*;
import dao.*;

/**
 *
 * @author VCAT
 */
public class JFrameDanhSachNV extends javax.swing.JFrame {
    NhanVienDAO nvd = new NhanVienDAO();
    /**
     * Creates new form JFrameDanhSachNV
     */
    public JFrameDanhSachNV() {
        initComponents();
        LoadDSNV();
    }
    public void LoadDSNV(){
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Mã NV");
        dtm.addColumn("Họ tên");
        dtm.addColumn("Ngày sinh");
        dtm.addColumn("Điện thoại");
        dtm.addColumn("CMND");
        dtm.addColumn("Mật khẩu");
        dtm.addColumn("Câu hỏi bí mật");
        dtm.addColumn("Đáp án câu hỏi bí mật");
        dtm.addColumn("Mã vị trí");
        dtm.addColumn("Mã trình độ vi tính");
        dtm.addColumn("Ngày vào");
        dtm.addColumn("Trang phục");
        dtm.addColumn("Lương theo ca");
        dtm.addColumn("Nghỉ việc");
        for(Nhanvien nv :nvd.LayDanhSachNV()){
            dtm.addRow(new Object[]{nv.getMaNhanVien(),nv.getHoTen(),nv.getSinhNhat(),
            nv.getSodt(),nv.getCmnd(),nv.getMatKhau(),nv.getCauHoiBaoMat(),
            nv.getDapAnBaoMat(),nv.getVitrinhanvien().getTenGoi(),nv.getTrinhdovitinh().getTenGoi(),
            nv.getNgayBatDau(),nv.isTrangPhuc(),nv.getLuongTheoCa(),nv.isNghiViec()});
        }
        jTableDSNV.setModel(dtm);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelDSNV = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDSNV = new javax.swing.JTable();
        jPanelChucNangDSNV = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Danh Sách Nhân Viên");

        jPanelDSNV.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách nhân viên"));
        jPanelDSNV.setToolTipText("");

        jTableDSNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableDSNV);

        javax.swing.GroupLayout jPanelDSNVLayout = new javax.swing.GroupLayout(jPanelDSNV);
        jPanelDSNV.setLayout(jPanelDSNVLayout);
        jPanelDSNVLayout.setHorizontalGroup(
            jPanelDSNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDSNVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1294, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelDSNVLayout.setVerticalGroup(
            jPanelDSNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDSNVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelChucNangDSNV.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng"));
        jPanelChucNangDSNV.setToolTipText("");

        javax.swing.GroupLayout jPanelChucNangDSNVLayout = new javax.swing.GroupLayout(jPanelChucNangDSNV);
        jPanelChucNangDSNV.setLayout(jPanelChucNangDSNVLayout);
        jPanelChucNangDSNVLayout.setHorizontalGroup(
            jPanelChucNangDSNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelChucNangDSNVLayout.setVerticalGroup(
            jPanelChucNangDSNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelChucNangDSNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDSNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanelDSNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelChucNangDSNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanelChucNangDSNV.getAccessibleContext().setAccessibleName("Chức năng");

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(JFrameDanhSachNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameDanhSachNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameDanhSachNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameDanhSachNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameDanhSachNV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelChucNangDSNV;
    private javax.swing.JPanel jPanelDSNV;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDSNV;
    // End of variables declaration//GEN-END:variables
}
