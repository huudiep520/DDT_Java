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
        
        return lstNV;
    }
    public List<Nhanvien> LayDanhSachNV(){
        List<Nhanvien> lstNV = null;
        try {
            //Session ss = sf.getCurrentSession();
            Session ss = sf.openSession();
            //ss.beginTransaction();
        
            Query qr = ss.createSQLQuery("CALL sp_GetNhanVien()").addEntity(Nhanvien.class);
            lstNV = qr.list();

        } catch (Exception e) {
            e.printStackTrace();
        }
       return lstNV;
    }
    public Nhanvien GetNV_ByID(String maNV){
        Nhanvien nv = new Nhanvien();
        try {
             //Session ss = sf.getCurrentSession();
             //ss.beginTransaction();
             Session ss = sf.openSession();
             Query qr = ss.createSQLQuery("CALL sp_GetNhanVienByID(:manv)").addEntity(Nhanvien.class);
             //Query qr = ss.createSQLQuery("CALL sp_GetNhanVienByID(:manv)");
             qr.setString("manv", maNV);
             nv = (Nhanvien)qr.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nv;
    }

    public boolean DeleteNV_ByID(Nhanvien nv){
        try {
            //sf.getCurrentSession().beginTransaction();
            Session ss = sf.openSession();
            ss = sf.getCurrentSession();
            ss.getTransaction().begin();
            Query qr = ss.createSQLQuery("CALL sp_DeleteNV_ByID(:manv)").addEntity(Nhanvien.class);
            qr.setString("manv", nv.getMaNhanVien());
            qr.executeUpdate();
            ss.getTransaction().commit();
            return true;
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            return false;
        }
    }
    public boolean UpdateNV_ByID(Nhanvien nv){
        try {
            Session ss = sf.openSession();
            ss = sf.getCurrentSession();
            ss.getTransaction().begin();
            Query qr = ss.createSQLQuery("CALL sp_UpdateNV(:manv,:hoten,:sinhnhat,:sdt,:ngayvao,:cmnd,:luongtheoca)").addEntity(Nhanvien.class);
            qr.setString("manv", nv.getMaNhanVien());
            qr.setString("hoten", nv.getHoTen());
            qr.setDate("sinhnhat", nv.getSinhNhat());
            qr.setInteger("sdt", nv.getSodt());
            qr.setDate("ngayvao", nv.getNgayBatDau());
            qr.setInteger("cmnd", nv.getCmnd());
            qr.setInteger("luongtheoca", nv.getLuongTheoCa());
            qr.executeUpdate();
            ss.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.toString();
            sf.getCurrentSession().getTransaction().rollback();
            return false;
        }
    }
}
