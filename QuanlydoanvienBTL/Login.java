package QuanlydoanvienBTL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.beans.binding.Bindings;
//import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class Login extends javax.swing.JFrame {

    static int idtaikhoan;

    public Login() {
        initComponents();
    }

    private String checkLogin(String taikhoan, String matkhau) {
        String sql = "SELECT * FROM taikhoan WHERE taikhoan = ? AND matkhau = ?";
        String sql2 = "SELECT * FROM doanvien WHERE IDTaikhoan = ?";

        try (Connection conn = DbConnection.getConnect();
                PreparedStatement stmt1 = conn.prepareStatement(sql);
                PreparedStatement stmt2 = conn.prepareStatement(sql2)) {

            stmt1.setString(1, taikhoan);
            stmt1.setString(2, matkhau);
            ResultSet rs1 = stmt1.executeQuery();

            if (rs1.next()) {
                int idtaikhoan = rs1.getInt("id");
                String trangthai = rs1.getString("trangthai");
                Login.idtaikhoan = idtaikhoan;
                stmt2.setInt(1, idtaikhoan);
                ResultSet rs2 = stmt2.executeQuery();
                String phanquyen = rs1.getString("phanquyen");
                if (trangthai.equals("Đã duyệt")) {
                    if (rs2.next()) {
                        String hoten = rs2.getString("hoten");
                        System.out.println("hoten" + hoten);
                        if (hoten.isEmpty()) {
                            return "Chưa nhập thông tin";
                        } else {
                            return String.valueOf(phanquyen);
                        }
                    } else {
                        return "";
                    }
                } else {
                    return trangthai;
                }
            } else {
                return "";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "";
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtDangNhap = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnDangKy = new javax.swing.JButton();
        btnDangNhap = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng Nhập");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(204, 204, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 145, -1, -1));

        txtDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDangNhapActionPerformed(evt);
            }
        });
        getContentPane().add(txtDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 330, 32));

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 330, 32));

        btnDangKy.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnDangKy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QuanlydoanvienBTL/Icon/cham.png"))); // NOI18N
        btnDangKy.setText("Đăng ký");
        btnDangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangKyActionPerformed(evt);
            }
        });
        getContentPane().add(btnDangKy, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, -1, -1));

        btnDangNhap.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnDangNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QuanlydoanvienBTL/Icon/tichv.png"))); // NOI18N
        btnDangNhap.setText("Đăng nhập");
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });
        getContentPane().add(btnDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 320, -1, 80));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QuanlydoanvienBTL/Icon/Login.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDangNhapActionPerformed

    }//GEN-LAST:event_txtDangNhapActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        String taikhoan = txtDangNhap.getText();
        String matkhau = new String(txtPassword.getPassword());
        System.out.println(checkLogin(taikhoan, matkhau));
        if (checkLogin(taikhoan, matkhau).equals("Chưa nhập thông tin")) {
            FormDVNhapTT newForm = new FormDVNhapTT();
            newForm.show();
            this.dispose();
        } else if (checkLogin(taikhoan, matkhau).equals("0")) {
            DoanVienUserMenuForm newForm = new DoanVienUserMenuForm();
            newForm.show();
            this.dispose();
        }else if (checkLogin(taikhoan, matkhau).equals("1")) {
            MenuForm newForm = new MenuForm();
            newForm.show();
            this.dispose();
        }
        else if (checkLogin(taikhoan, matkhau).equals("Từ chối")) {
            FormTuChoi newForm = new FormTuChoi();
            newForm.show();
            this.dispose();
        } else {
//            JOptionPane.showMessageDialog(this, "Đăng nhập thất bại");
            FormChuaDuyet newForm = new FormChuaDuyet();
            newForm.show();
            this.dispose();
        }
//        this.dispose();
    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void btnDangKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangKyActionPerformed
        FormDangKy newForm = new FormDangKy();
        newForm.show();
        // Ẩn form đăng nhập hiện tại
        this.dispose();

    }//GEN-LAST:event_btnDangKyActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangKy;
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtDangNhap;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
