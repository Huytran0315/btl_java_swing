package QuanlydoanvienBTL;

import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DbConnection {

    public static Connection getConnect() {
        String url = "jdbc:mysql://localhost:3306/qldv";
        String user = "root";
        String pass = "";
        Connection ketnoi = null;

        try {
            ketnoi = DriverManager.getConnection(url, user, pass);
            System.out.println("Kết nối thành công!");
        } catch (SQLException e) {
            System.out.println("Lỗi " + e.toString());
        }
        return ketnoi;
    }

    //hàm đọc dữ liệu
    public ResultSet getData(String sql) {
        ResultSet kq = null;
        try {
            Statement st = getConnect().createStatement();
            kq = st.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("Lỗi " + e.toString());
        }
        return kq;
    }

    public ResultSet getThongTinDoanVien() {
        String sql = "SELECT d.id,d.hoten,d.gioitinh,d.quequan,d.ngaysinh,t.trangthai  FROM doanvien as d, taikhoan as t WHERE t.id = d.IDTaikhoan";
        return getData(sql);
    }

    public ResultSet getThongTinHoatDong() {
        String sql = "SELECT * from hoatdong";
        return getData(sql);
    }

    public ResultSet getDiem() {
        String sql = "SELECT * fromdiem ";
        return getData(sql);
    }

    public void loadTable(ResultSet kq, JTable tb) {
        int n = tb.getColumnCount();
        Object hang[] = new Object[n]; // Khai báo 1 bảng gồm n cột
        DefaultTableModel model = (DefaultTableModel) tb.getModel();
        //Đưa về bảng rỗng
        model.setRowCount(0);
        try {
            while (kq.next()) {
                for (int i = 0; i < n; i++) {
                    hang[i] = kq.getString(i + 1);
                }
                model.addRow(hang);
            }
        } catch (SQLException e) {
            System.out.println("Lỗi: " + e.toString());
        }
    }

    public void updateData(String sql) {
        try {
            Statement st = getConnect().createStatement();
            st.executeUpdate(sql);

        } catch (SQLException e) {
            System.out.println("Lỗi " + e.toString());
        }
    }

    public void xoaDoanVien(String manv) {
        String sql = "delete from doanvien where id = '" + manv + "'";
        updateData(sql);
    }

    public void xoaHoatDong(String idhoatdong) {
        String sql = "delete from hoatdong where idhoatdong = '" + idhoatdong + "'";
        updateData(sql);
    }

    public void xoaDiem(String id) {
        String sql = "delete from hoatdong where id = '" + id + "'";
        updateData(sql);
    }

    public void themDoanVien(String id, String hoten, String gioitinh, String quequan, Date ngaysinh) {
        String sql = "INSERT INTO doanvien (id, hoten, gioitinh,quequan, ngaysinh) VALUES ('" + id + "', '" + hoten + "','" + gioitinh + "' ,'" + quequan + "', '" + ngaysinh + "')";
        updateData(sql);
    }

    public void suaDoanVien(String id, String hoten, String gioitinh, String quequan, Date ngaysinh) {
        String sql = "UPDATE doanvien SET hoTen = '" + hoten + "',gioitinh = '" + gioitinh + "' ,quequan = '" + quequan + "', ngaysinh = '" + ngaysinh + "' WHERE id = '" + id + "'";
        updateData(sql);
    }

    public boolean checkTrungIDDoanVien(String id) {
        String sql = "select * from doanvien where id = '" + id + "'";
        ResultSet kq = getData(sql);
        try {
            if (kq.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Lỗi : " + e.toString());
        }
        return false;
    }
}
