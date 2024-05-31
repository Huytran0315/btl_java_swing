/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanlydoanvienBTL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class FormDangKy extends javax.swing.JFrame {

    /**
     * Creates new form FormDangKy
     */
    public FormDangKy() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTenDangKy = new javax.swing.JTextField();
        txtDKMatKhau = new javax.swing.JPasswordField();
        txtDKXacNhanMatKhau = new javax.swing.JPasswordField();
        btnXacNhanDangKy = new javax.swing.JButton();
        btnBackTologin = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tạo Tài Khoản");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTenDangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenDangKyActionPerformed(evt);
            }
        });
        getContentPane().add(txtTenDangKy, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 308, 34));

        txtDKMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDKMatKhauActionPerformed(evt);
            }
        });
        getContentPane().add(txtDKMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 308, 34));

        txtDKXacNhanMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDKXacNhanMatKhauActionPerformed(evt);
            }
        });
        getContentPane().add(txtDKXacNhanMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 308, 35));

        btnXacNhanDangKy.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnXacNhanDangKy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QuanlydoanvienBTL/Icon/tichv.png"))); // NOI18N
        btnXacNhanDangKy.setText("Xác Nhận");
        btnXacNhanDangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanDangKyActionPerformed(evt);
            }
        });
        getContentPane().add(btnXacNhanDangKy, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 370, -1, 81));

        btnBackTologin.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnBackTologin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QuanlydoanvienBTL/Icon/quaylai2.png"))); // NOI18N
        btnBackTologin.setText("Trở về");
        btnBackTologin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackTologinActionPerformed(evt);
            }
        });
        getContentPane().add(btnBackTologin, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 180, 81));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QuanlydoanvienBTL/Icon/DangKi.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTenDangKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenDangKyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenDangKyActionPerformed

    private void txtDKMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDKMatKhauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDKMatKhauActionPerformed

    private void btnBackTologinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackTologinActionPerformed
        Login newForm = new Login();
        newForm.show();
        // Ẩn form đăng nhập hiện tại
        this.dispose();
    }//GEN-LAST:event_btnBackTologinActionPerformed

    private void btnXacNhanDangKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanDangKyActionPerformed
        String username = txtTenDangKy.getText();
        String password = new String(txtDKMatKhau.getPassword());
        String confirmPassword = new String(txtDKXacNhanMatKhau.getPassword());

        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin.");
            return;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Mật khẩu không khớp.");
            return;
        }

        if (isUserExist(username)) {
            JOptionPane.showMessageDialog(this, "Tên đăng nhập đã tồn tại.");
            return;
        }

        if (registerUser(username, password)) {
            JOptionPane.showMessageDialog(this, "Đăng ký thành công.");
            String sql = "SELECT * FROM taikhoan ORDER BY id DESC LIMIT 1;";
            try (Connection conn = DbConnection.getConnect();
                    PreparedStatement stmt = conn.prepareStatement(sql)) {
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt("id");
                    registerDoanvien(id);
                } else {
                    System.out.println("No records found.");
                }
            } catch (SQLException e) {
                e.printStackTrace();

            }
            this.dispose();
            Login newForm = new Login();
            newForm.show();
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Đăng ký thất bại. Vui lòng thử lại.");
        }
        this.dispose();
    }

    private boolean isUserExist(String username) {
        String sql = "SELECT * FROM taikhoan WHERE taikhoan = ?";
        try (Connection conn = DbConnection.getConnect();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean registerDoanvien(int IDtaikhoan) {
        String sql = "INSERT INTO doanvien (hoten, gioitinh, quequan,ngaysinh, IDtaikhoan) VALUES ('', '','','2000-01-01', ?)";
        try (Connection conn = DbConnection.getConnect();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, IDtaikhoan);
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean registerUser(String username, String password) {
        String sql = "INSERT INTO taikhoan (taikhoan, matkhau) VALUES (?, ?)";
        try (Connection conn = DbConnection.getConnect();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }//GEN-LAST:event_btnXacNhanDangKyActionPerformed

    private void txtDKXacNhanMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDKXacNhanMatKhauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDKXacNhanMatKhauActionPerformed

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
            java.util.logging.Logger.getLogger(FormDangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormDangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormDangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormDangKy().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackTologin;
    private javax.swing.JButton btnXacNhanDangKy;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField txtDKMatKhau;
    private javax.swing.JPasswordField txtDKXacNhanMatKhau;
    private javax.swing.JTextField txtTenDangKy;
    // End of variables declaration//GEN-END:variables
}