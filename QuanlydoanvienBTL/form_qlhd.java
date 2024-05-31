/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanlydoanvienBTL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class form_qlhd extends javax.swing.JFrame {

    DbConnection db = new DbConnection();

    private void fetchAndDisplayData() {
        try (Connection conn = DbConnection.getConnect()) {
            String query = "SELECT * FROM hoatdong";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            DefaultTableModel model = (DefaultTableModel) tableHoatDongDoan.getModel();
            model.setRowCount(0);  // Clear existing data

            while (rs.next()) {
                Object[] row = {
                    rs.getInt("idhoatdong"),
                    rs.getString("tenhoatdong"),
                    rs.getDate("ngaytochuc")
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public form_qlhd() {
        initComponents();
        fetchAndDisplayData();
    }

//    public void showDetail() {
//        int selectedRow = tableHoatDongDoan.getSelectedRow(); // Sửa đổi: dùng tableDoanVien thay vì nv
//        if (selectedRow < 0) {
//            return;
//        }
//        String id = tableHoatDongDoan.getValueAt(selectedRow, 0).toString();
//        String tenHoatDong = tableHoatDongDoan.getValueAt(selectedRow, 1).toString();
//        String ngayToChuc = tableHoatDongDoan.getValueAt(selectedRow, 2).toString();
//
//     //   txtMaHD.setText(id);
//        txtTenHD.setText(tenHoatDong);
//        txtNgayToChuc.setText(ngayToChuc);
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableHoatDongDoan = new javax.swing.JTable();
        btnTroVe = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        txtTenHD = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNgayToChuc = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableHoatDongDoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Tên hoạt động", "Ngày Tổ Chức"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableHoatDongDoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableHoatDongDoanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableHoatDongDoan);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 900, 180));

        btnTroVe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QuanlydoanvienBTL/Icon/quaylai.png"))); // NOI18N
        btnTroVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTroVeActionPerformed(evt);
            }
        });
        getContentPane().add(btnTroVe, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 65, -1));

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QuanlydoanvienBTL/Icon/them.png"))); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        getContentPane().add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 65, -1));

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QuanlydoanvienBTL/Icon/sua.png"))); // NOI18N
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        getContentPane().add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 65, 59));

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QuanlydoanvienBTL/Icon/xoa1.png"))); // NOI18N
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        getContentPane().add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, 65, 59));

        txtTenHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenHDActionPerformed(evt);
            }
        });
        getContentPane().add(txtTenHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 300, 30));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 142, -1, -1));

        txtNgayToChuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgayToChucActionPerformed(evt);
            }
        });
        getContentPane().add(txtNgayToChuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 300, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QuanlydoanvienBTL/Icon/qlhdd.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTroVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTroVeActionPerformed
        MenuForm newForm = new MenuForm();
        newForm.show();
        // Ẩn form đăng nhập hiện tại
        this.dispose();
    }//GEN-LAST:event_btnTroVeActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try (Connection conn = DbConnection.getConnect()) {
            if (txtTenHD.getText().isEmpty() || txtNgayToChuc.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin.");
            } else {
                String sql = "INSERT INTO hoatdong ( tenhoatdong, ngaytochuc) VALUES (?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, txtTenHD.getText());
                ps.setDate(2, java.sql.Date.valueOf(txtNgayToChuc.getText()));
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Thêm hoạt động thành công!");
                    // Đặt các ô văn bản về rỗng sau khi thêm thành công
                    txtTenHD.setText("");
                    txtNgayToChuc.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Không thể thêm hoạt động.");
                }
                fetchAndDisplayData();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi. Vui lòng thử lại.");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void txtNgayToChucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgayToChucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayToChucActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int so_hang_chon = tableHoatDongDoan.getSelectedRowCount();
        if (so_hang_chon == 0) {
            JOptionPane.showMessageDialog(this, "Chưa chọn hàng cần xoá?");
        } else {
            int a = JOptionPane.showConfirmDialog(this, "Có thực sự muốn xoá không?", "Chú ý", JOptionPane.YES_NO_OPTION);
            if (a == JOptionPane.YES_OPTION) {
                int cs_hang_xoa = tableHoatDongDoan.getSelectedRow();
                String mnv_can_xoa = (String) tableHoatDongDoan.getValueAt(cs_hang_xoa, 0).toString();
                db.xoaHoatDong(mnv_can_xoa);
                ResultSet kq = db.getThongTinHoatDong();
                if (kq != null) {
                    db.loadTable(kq, tableHoatDongDoan);
                    JOptionPane.showMessageDialog(this, "Xóa thành công!");
                  //  txtMaHD.setText("");
                    txtTenHD.setText("");
                    txtNgayToChuc.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Không thể xóa.");
                }
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        try (Connection conn = DbConnection.getConnect()) {
            String query = "UPDATE hoatdong SET tenhoatdong = ?, ngaytochuc = ? WHERE idhoatdong = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, txtTenHD.getText());
            pstmt.setDate(2, java.sql.Date.valueOf(txtNgayToChuc.getText()));  // Adjust format if needed
        //    pstmt.setInt(3, Integer.parseInt(txtMaHD.getText()));
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Cập nhật thông tin thành công!");
                // Đặt các ô văn bản về rỗng sau khi sửa thành công
                txtTenHD.setText("");
                txtNgayToChuc.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy hoạt động với ID này.");
            }
            fetchAndDisplayData();  // Refresh data on table
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi. Vui lòng thử lại.");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void tableHoatDongDoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableHoatDongDoanMouseClicked
        DefaultTableModel model = (DefaultTableModel) tableHoatDongDoan.getModel();
        int i = tableHoatDongDoan.getSelectedRow();
      //  txtMaHD.setText(String.valueOf(model.getValueAt(i, 0)));
        txtTenHD.setText(String.valueOf(model.getValueAt(i, 1)));
        txtNgayToChuc.setText(String.valueOf(model.getValueAt(i, 2)));
    }//GEN-LAST:event_tableHoatDongDoanMouseClicked

    private void txtTenHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenHDActionPerformed

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
            java.util.logging.Logger.getLogger(form_qlhd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_qlhd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_qlhd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_qlhd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_qlhd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTroVe;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableHoatDongDoan;
    private javax.swing.JTextField txtNgayToChuc;
    private javax.swing.JTextField txtTenHD;
    // End of variables declaration//GEN-END:variables
}
