/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Nhanvien;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;



public class NhanVienDAO {
    private final SessionFactory sf = HibernateUtil.getSessionFactory();
    
    
    public List<Nhanvien> CheckLogin(String maNV, String mkNV){
        Session ss = sf.getCurrentSession();
        ss.beginTransaction(); // khởi tạo ss
        
        /*gọi store*/
        Query qr = ss.createSQLQuery("CALL sp_CheckLogin(:maNV, :mkNV)").addEntity(Nhanvien.class);
        qr.setString("maNV", maNV);
        qr.setString("mkNV", mkNV);
        
        /*thực thi store -> kq*/
        List<Nhanvien> lstNV = qr.list();
        
        ss.close();
        
        return lstNV;
    }
    public List<Nhanvien> LayDanhSachNV(){
        Session ss = sf.getCurrentSession();
        ss.beginTransaction();
        Query qr = ss.createSQLQuery("CALL sp_GetNhanVien()").addEntity(Nhanvien.class);
        List<Nhanvien> lstNV = qr.list();
        ss.close();
        return lstNV;
    }
    public Nhanvien GetNhanVienById(String maNV){
        Session ss = sf.getCurrentSession();
        ss.beginTransaction();
        Query qr = ss.createSQLQuery("CALL sp_GetNhanVienById(:manv)").addEntity(Nhanvien.class);
        qr.setString("manv", maNV);
        List<Nhanvien> lstNV = qr.list();
        Nhanvien nv = lstNV.get(0);
        ss.close();
        return nv;
    }
}
