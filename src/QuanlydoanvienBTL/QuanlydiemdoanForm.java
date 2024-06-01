package QuanlydoanvienBTL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class QuanlydiemdoanForm extends javax.swing.JFrame {

    DbConnection db = new DbConnection();

    public QuanlydiemdoanForm() {
        initComponents();
        fetchAndDisplayData();
        populateComboBoxes();;
    }

    private void populateComboBoxes() {
        try (Connection conn = DbConnection.getConnect()) {
            String queryDoanVien = "SELECT id, hoten FROM doanvien";
            String queryHoatDong = "SELECT idhoatdong, tenhoatdong FROM hoatdong";

            Statement stmt = conn.createStatement();
            ResultSet rsDoanVien = stmt.executeQuery(queryDoanVien);
            selectDoanvien.removeAllItems();
            while (rsDoanVien.next()) {
                selectDoanvien.addItem(rsDoanVien.getString("hoten"));
            }

            ResultSet rsHoatDong = stmt.executeQuery(queryHoatDong);
            selecHoatDong.removeAllItems();
            while (rsHoatDong.next()) {
                selecHoatDong.addItem(rsHoatDong.getString("tenhoatdong"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fetchAndDisplayData() {
        try (Connection conn = DbConnection.getConnect()) {
            String queryHoatDong = "SELECT d.id, dv.hoten, hd.tenhoatdong FROM thamgia d "
                    + "JOIN doanvien dv ON d.iddoanvien = dv.id "
                    + "JOIN hoatdong hd ON d.idhoatdong = hd.idhoatdong";
            String queryDiem = "SELECT dv.id, dv.hoten, SUM(tg.diem) AS diem FROM doanvien dv "
                    + "LEFT JOIN thamgia tg ON dv.id = tg.iddoanvien "
                    + "GROUP BY dv.id, dv.hoten";

            Statement stmt = conn.createStatement();
            ResultSet rsHoatDong = stmt.executeQuery(queryHoatDong);
            DefaultTableModel tbHoatDong = (DefaultTableModel) tableHoatDong.getModel();
            tbHoatDong.setRowCount(0);  // Clear existing data
            while (rsHoatDong.next()) {
                Object[] row = {
                    rsHoatDong.getInt("id"),
                    rsHoatDong.getString("hoten"),
                    rsHoatDong.getString("tenhoatdong")
                };
                tbHoatDong.addRow(row);
            }

            ResultSet rsDiem = stmt.executeQuery(queryDiem);
            DefaultTableModel tbDiem = (DefaultTableModel) tableDiem.getModel();
            tbDiem.setRowCount(0);  // Clear existing data
            while (rsDiem.next()) {
                Object[] row = {
                    rsDiem.getInt("id"),
                    rsDiem.getString("hoten"),
                    rsDiem.getInt("diem")
                };
                tbDiem.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateDiemForDoanVien(int doanVienId, int diem) {
        try (Connection conn = DbConnection.getConnect()) {
            String queryDiem = "UPDATE doanvien SET diem = diem + ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(queryDiem);
            pstmt.setInt(1, diem);
            pstmt.setInt(2, doanVienId);
            pstmt.executeUpdate();
        } catch (Exception e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(this, "Lỗi khi cập nhật điểm: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        selectDoanvien = new javax.swing.JComboBox();
        selecHoatDong = new javax.swing.JComboBox();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableHoatDong = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableDiem = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        selectDoanvien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectDoanvienActionPerformed(evt);
            }
        });
        getContentPane().add(selectDoanvien, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 170, 30));

        selecHoatDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecHoatDongActionPerformed(evt);
            }
        });
        getContentPane().add(selecHoatDong, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 130, 180, 30));

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QuanlydoanvienBTL/Icon/them.png"))); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        getContentPane().add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 61, -1));

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QuanlydoanvienBTL/Icon/sua.png"))); // NOI18N
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        getContentPane().add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 61, 59));

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QuanlydoanvienBTL/Icon/xoa1.png"))); // NOI18N
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        getContentPane().add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 60, 60));

        tableHoatDong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Người tham gia", "Hoạt động"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableHoatDong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableHoatDongMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableHoatDong);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 340, 480, 210));

        tableDiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Tên đoàn viên", "Điểm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDiemMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableDiem);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 339, 450, 210));

        jLabel3.setText("Bảng họat động");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 419, -1, -1));

        jLabel4.setText("Bảng đoàn viên");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 387, -1, -1));

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QuanlydoanvienBTL/Icon/quaylai.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 61, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QuanlydoanvienBTL/Icon/qldiemdoan.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectDoanvienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectDoanvienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectDoanvienActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int selectedRow = tableHoatDong.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa!");
        return;
    }

    int thamGiaId = (int) tableHoatDong.getValueAt(selectedRow, 0);
    String newDoanVienName = selectDoanvien.getSelectedItem().toString();
    String newHoatDongName = selecHoatDong.getSelectedItem().toString();

    try (Connection conn = DbConnection.getConnect()) {
        String queryUpdate = "UPDATE thamgia SET iddoanvien = (SELECT id FROM doanvien WHERE hoten = ?), "
                + "idhoatdong = (SELECT idhoatdong FROM hoatdong WHERE tenhoatdong = ?) WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(queryUpdate);
        pstmt.setString(1, newDoanVienName);
        pstmt.setString(2, newHoatDongName);
        pstmt.setInt(3, thamGiaId);
        int affectedRows = pstmt.executeUpdate();
        if (affectedRows > 0) {
            fetchAndDisplayData();
            JOptionPane.showMessageDialog(this, "Sửa thành công!");
        } else {
            JOptionPane.showMessageDialog(this, "Không thể sửa dữ liệu, vui lòng thử lại.");
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Lỗi khi sửa dữ liệu: " + e.getMessage());
    }

    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try (Connection conn = DbConnection.getConnect()) {
            String doanVienName = selectDoanvien.getSelectedItem().toString();
            String hoatDongName = selecHoatDong.getSelectedItem().toString();
            if (doanVienName == null || hoatDongName == null) {
                JOptionPane.showMessageDialog(this, "Chọn đoàn viên và hoạt động trước khi thêm!");
                return;
            }

            // Kiểm tra xem đoàn viên đã tham gia hoạt động này chưa
            String queryCheckExist = "SELECT COUNT(*) AS count FROM thamgia tg "
                    + "JOIN doanvien dv ON tg.iddoanvien = dv.id "
                    + "JOIN hoatdong hd ON tg.idhoatdong = hd.idhoatdong "
                    + "WHERE dv.hoten = ? AND hd.tenhoatdong = ?";
            PreparedStatement pstmtCheck = conn.prepareStatement(queryCheckExist);
            pstmtCheck.setString(1, doanVienName);
            pstmtCheck.setString(2, hoatDongName);
            ResultSet rsCheck = pstmtCheck.executeQuery();
            if (rsCheck.next() && rsCheck.getInt("count") > 0) {
                JOptionPane.showMessageDialog(this, "Đoàn viên đã tham gia hoạt động này!");
                return;
            }
            String queryInsert = "INSERT INTO thamgia (iddoanvien, idhoatdong) "
                    + "SELECT dv.id, hd.idhoatdong FROM doanvien dv, hoatdong hd "
                    + "WHERE dv.hoten = ? AND hd.tenhoatdong = ?";
            PreparedStatement pstmt = conn.prepareStatement(queryInsert);
            pstmt.setString(1, doanVienName);
            pstmt.setString(2, hoatDongName);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                // Cập nhật điểm cho đoàn viên
                String queryDiem = "SELECT id FROM doanvien WHERE hoten = ?";
                pstmt = conn.prepareStatement(queryDiem);
                pstmt.setString(1, doanVienName);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    updateDiemForDoanVien(rs.getInt("id"), 10);
                }

                fetchAndDisplayData();
                JOptionPane.showMessageDialog(this, "Thêm thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Không thể thêm dữ liệu, vui lòng thử lại.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi thêm dữ liệu: " + e.getMessage());
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int selectedRow = tableHoatDong.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần xóa!");
            return;
        }

        int thamGiaId = (int) tableHoatDong.getValueAt(selectedRow, 0);

        try (Connection conn = DbConnection.getConnect()) {
            String queryDelete = "DELETE FROM thamgia WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(queryDelete);
            pstmt.setInt(1, thamGiaId);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                fetchAndDisplayData();
                JOptionPane.showMessageDialog(this, "Xóa thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Không thể xóa dữ liệu, vui lòng thử lại.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi xóa dữ liệu: " + e.getMessage());
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tableHoatDongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableHoatDongMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableHoatDongMouseClicked

    private void tableDiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDiemMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableDiemMouseClicked

    private void selecHoatDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecHoatDongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selecHoatDongActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        MenuForm newForm = new MenuForm();
        newForm.show();
        // Ẩn form đăng nhập hiện tại
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(QuanlydiemdoanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanlydiemdoanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanlydiemdoanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanlydiemdoanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanlydiemdoanForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox selecHoatDong;
    private javax.swing.JComboBox selectDoanvien;
    private javax.swing.JTable tableDiem;
    private javax.swing.JTable tableHoatDong;
    // End of variables declaration//GEN-END:variables
}
