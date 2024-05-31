package QuanlydoanvienBTL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class QuanLyDoanVienForm extends javax.swing.JFrame {

    DbConnection db = new DbConnection();

    private void fetchAndDisplayData() {
        try (Connection conn = DbConnection.getConnect()) {
            String query = "SELECT d.id,d.hoten,d.gioitinh,d.quequan,d.ngaysinh,t.trangthai,d.IDTaikhoan  FROM doanvien as d, taikhoan as t WHERE t.id = d.IDTaikhoan";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            DefaultTableModel model = (DefaultTableModel) tableDoanVien.getModel();
            model.setRowCount(0);  // Clear existing data
            while (rs.next()) {
                Object[] row = {
                    rs.getInt("id"),
                    rs.getString("hoten"),
                    rs.getString("gioitinh"),
                    rs.getString("quequan"),
                    rs.getDate("ngaysinh"),
                    rs.getString("trangthai"),
                    rs.getString("IDTaikhoan")

                };
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public QuanLyDoanVienForm() {
        initComponents();
        fetchAndDisplayData();
    }

//    public void showDetail() {
//        int selectedRow = tableDoanVien.getSelectedRow(); // Sửa đổi: dùng tableDoanVien thay vì nv
//        if (selectedRow < 0) {
//            return;
//        }
//        String id = tableDoanVien.getValueAt(selectedRow, 0).toString();
//        String hoTen = tableDoanVien.getValueAt(selectedRow, 1).toString();
//        String quequan = tableDoanVien.getValueAt(selectedRow, 2).toString();
//        String gioiTinh = tableDoanVien.getValueAt(selectedRow, 3).toString();
//        String ngaysinh = tableDoanVien.getValueAt(selectedRow, 4).toString();
//        String trangthai = tableDoanVien.getValueAt(selectedRow, 5).toString();
//        String idtaikhoan = tableDoanVien.getValueAt(selectedRow, 6).toString();
//
//        txtID.setText(id);
//        txtHoTen.setText(hoTen);
//        txtQueQuan.setText(quequan);
//        cbGioiTinh.setSelectedItem(gioiTinh);
//        txtNgaySinh.setText(ngaysinh);
//        cbTrangthai.setSelectedItem(trangthai);
//        txtIDTaikhoan.setText(idtaikhoan);
//
//        System.out.println("txtID.getText();" + txtID.getText());
//        System.out.println("txtHoTen.getText();" + txtHoTen.getText());
//
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTroVe = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDoanVien = new javax.swing.JTable();
        txtHoTen = new javax.swing.JTextField();
        cbGioiTinh = new javax.swing.JComboBox();
        txtQueQuan = new javax.swing.JTextField();
        txtNgaySinh = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbTrangthai = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtIDTaikhoan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTroVe.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnTroVe.setForeground(new java.awt.Color(255, 255, 255));
        btnTroVe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QuanlydoanvienBTL/Icon/quaylai.png"))); // NOI18N
        btnTroVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTroVeActionPerformed(evt);
            }
        });
        getContentPane().add(btnTroVe, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 60, 60));

        tableDoanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Họ và tên", "Giới tính", "Quê quán", "Ngày sinh", "Trạng thái", "ID Tài khoản"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDoanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDoanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableDoanVien);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 950, 163));

        txtHoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoTenActionPerformed(evt);
            }
        });
        getContentPane().add(txtHoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 200, 35));

        cbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nam", "Nữ" }));
        cbGioiTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbGioiTinhActionPerformed(evt);
            }
        });
        getContentPane().add(cbGioiTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 130, 83, 36));

        txtQueQuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQueQuanActionPerformed(evt);
            }
        });
        getContentPane().add(txtQueQuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 200, 35));

        txtNgaySinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgaySinhActionPerformed(evt);
            }
        });
        getContentPane().add(txtNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 200, 200, 36));

        btnThem.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QuanlydoanvienBTL/Icon/them.png"))); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        getContentPane().add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 343, 60, -1));

        btnSua.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QuanlydoanvienBTL/Icon/sua.png"))); // NOI18N
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        getContentPane().add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 60, 60));

        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QuanlydoanvienBTL/Icon/xoa1.png"))); // NOI18N
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        getContentPane().add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, 60, 60));

        jLabel1.setText("Trạng thái");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 420, -1, 20));

        cbTrangthai.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Chưa duyệt", "Đã duyệt", "Từ chối" }));
        getContentPane().add(cbTrangthai, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 446, -1, 20));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QuanlydoanvienBTL/qldv.png"))); // NOI18N
        jLabel3.setToolTipText("");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });
        getContentPane().add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 340, 110, -1));

        txtIDTaikhoan.setVisible(false);
        txtIDTaikhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDTaikhoanActionPerformed(evt);
            }
        });
        getContentPane().add(txtIDTaikhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 280, 110, -1));

        jLabel2.setText("id doanvien");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 320, -1, -1));

        jLabel4.setText("id tai khoan");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 240, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTroVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTroVeActionPerformed
        MenuForm newForm = new MenuForm();
        newForm.show();
        // Ẩn form đăng nhập hiện tại
        this.dispose();
    }//GEN-LAST:event_btnTroVeActionPerformed

    private void cbGioiTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGioiTinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbGioiTinhActionPerformed

    private void txtQueQuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQueQuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQueQuanActionPerformed

    private void txtHoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoTenActionPerformed

    private void txtNgaySinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgaySinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgaySinhActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try (Connection conn = DbConnection.getConnect()) {
            if (txtHoTen.getText().isEmpty() || txtQueQuan.getText().isEmpty() || txtNgaySinh.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin.");
            } else {
                String sql = "INSERT INTO doanvien (hoten, gioitinh, quequan, ngaysinh) VALUES (?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, txtHoTen.getText());
                ps.setString(2, cbGioiTinh.getSelectedItem().toString());
                ps.setString(3, txtQueQuan.getText());
                ps.setDate(4, java.sql.Date.valueOf(txtNgaySinh.getText()));
//                ps.setString(5, cbTrangthai.getSelectedItem().toString());

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Thêm đoàn viên thành công!");
                    // Đặt các ô văn bản về rỗng sau khi thêm thành công
                    txtHoTen.setText("");
                    txtQueQuan.setText("");
                    txtNgaySinh.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Không thể thêm đoàn viên.");
                }
                fetchAndDisplayData();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi. Vui lòng thử lại.");
        }

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int so_hang_chon = tableDoanVien.getSelectedRowCount();
        if (so_hang_chon == 0) {
            JOptionPane.showMessageDialog(this, "Chưa chọn hàng cần xoá?");
        } else {
            int a = JOptionPane.showConfirmDialog(this, "Có thực sự muốn xoá không?", "Chú ý", JOptionPane.YES_NO_OPTION);
            if (a == JOptionPane.YES_OPTION) {
                int cs_hang_xoa = tableDoanVien.getSelectedRow();
                String mnv_can_xoa = (String) tableDoanVien.getValueAt(cs_hang_xoa, 0).toString();
                db.xoaDoanVien(mnv_can_xoa);
                ResultSet kq = db.getThongTinDoanVien();
                if (kq != null) {
                    db.loadTable(kq, tableDoanVien);
                    JOptionPane.showMessageDialog(this, "Xóa đoàn viên thành công!");
                    //   txtID.setText("");
                    txtHoTen.setText("");
                    txtQueQuan.setText("");
                    txtNgaySinh.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Không thể xóa đoàn viên.");
                }
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        try (Connection conn = DbConnection.getConnect()) {
            // Câu lệnh cập nhật bảng doanvien
//            String query = "UPDATE doanvien SET hoten = ?, gioitinh = ?, quequan = ?, ngaysinh = ? WHERE id = ?";
            // Câu lệnh cập nhật bảng taikhoan
            String query2 = "UPDATE taikhoan SET trangthai = ? WHERE id = ?";
            String query = "UPDATE doanvien SET hoten = ?, gioitinh = ?, quequan = ?, ngaysinh = ? WHERE id = ?";

            // Tạo PreparedStatement cho bảng doanvien
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(1, txtHoTen.getText()); // Thiết lập giá trị cho tham số đầu tiên (hoten)
            pstmt.setString(2, cbGioiTinh.getSelectedItem().toString()); // Thiết lập giá trị cho tham số thứ hai (gioitinh)
            pstmt.setString(3, txtQueQuan.getText()); // Thiết lập giá trị cho tham số thứ ba (quequan)
            pstmt.setDate(4, java.sql.Date.valueOf(txtNgaySinh.getText())); // Thiết lập giá trị cho tham số thứ tư (ngaysinh)
            pstmt.setInt(5, Integer.parseInt(txtID.getText())); // Thi
            // Thực thi câu lệnh cập nhật bảng doanvien
            System.out.println("txtHoTen.getText()" + pstmt);
            int rowsAffected = pstmt.executeUpdate();

            // Nếu cập nhật bảng doanvien thành công, tiếp tục cập nhật bảng taikhoan
            if (rowsAffected > 0) {
                // Tạo PreparedStatement cho bảng taikhoan
                PreparedStatement pstm = conn.prepareStatement(query2);
                // Thiết lập giá trị cho các tham số
                pstm.setString(1, cbTrangthai.getSelectedItem().toString()); // Thiết lập giá trị cho tham số thứ hai (gioitinh)

                pstm.setInt(2, Integer.parseInt(txtIDTaikhoan.getText()));  // Thiết lập giá trị cho tham số id

                // Thực thi câu lệnh cập nhật bảng taikhoan
                int rowsAffected2 = pstm.executeUpdate();

                // Kiểm tra kết quả cập nhật bảng taikhoan
                if (rowsAffected2 > 0) {
                    // Hiển thị thông báo cập nhật thành công
                    JOptionPane.showMessageDialog(this, "Cập nhật thông tin đoàn viên và tài khoản thành công!");
                    // Đặt các ô văn bản về rỗng sau khi sửa thành công
                    txtHoTen.setText("");
                    txtQueQuan.setText("");
                    txtNgaySinh.setText("");
                } else {
                    // Hiển thị thông báo nếu không tìm thấy tài khoản với ID này
                    JOptionPane.showMessageDialog(this, "Không tìm thấy tài khoản với ID này.");
                }
            } else {
                // Hiển thị thông báo nếu không tìm thấy đoàn viên với ID này
                JOptionPane.showMessageDialog(this, "Không tìm thấy đoàn viên với ID này.");
            }

            // Làm mới dữ liệu trên bảng
            fetchAndDisplayData();
        } catch (Exception e) {
            e.printStackTrace();
            // Hiển thị thông báo lỗi
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi. Vui lòng thử lại.");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void tableDoanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDoanVienMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tableDoanVien.getModel();
        int i = tableDoanVien.getSelectedRow();
        txtID.setText(String.valueOf(model.getValueAt(i, 0)));
        txtHoTen.setText(String.valueOf(model.getValueAt(i, 1)));
        cbGioiTinh.setSelectedItem(String.valueOf(model.getValueAt(i, 3)));
        txtQueQuan.setText(String.valueOf(model.getValueAt(i, 2)));
        txtNgaySinh.setText(String.valueOf(model.getValueAt(i, 4)));
        cbTrangthai.setSelectedItem(String.valueOf(model.getValueAt(i, 5)));
        txtIDTaikhoan.setText(String.valueOf(model.getValueAt(i, 6)));

    }//GEN-LAST:event_tableDoanVienMouseClicked

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void txtIDTaikhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDTaikhoanActionPerformed
         
    }//GEN-LAST:event_txtIDTaikhoanActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLyDoanVienForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyDoanVienForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyDoanVienForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyDoanVienForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyDoanVienForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTroVe;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox cbGioiTinh;
    private javax.swing.JComboBox cbTrangthai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableDoanVien;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIDTaikhoan;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtQueQuan;
    // End of variables declaration//GEN-END:variables
}
