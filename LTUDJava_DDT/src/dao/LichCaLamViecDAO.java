/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Lichcalamviec;
import entities.Nhanvien;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author VCAT
 */
public class LichCaLamViecDAO {
    private final SessionFactory sf = HibernateUtil.getSessionFactory();
    public List<Lichcalamviec> LayDSLichLam(Nhanvien nv){
        List<Lichcalamviec> lstNV = null;
        try {
            Session ss = sf.openSession();
            ss.getTransaction().begin();
            Query qr = ss.createSQLQuery("CALL sp_XemLichLamNV_ByID(:manv)").addEntity(Lichcalamviec.class);
            qr.setString("manv", nv.getMaNhanVien());
            lstNV = qr.list();
        } catch (Exception e) {
            e.toString();
        }
        return lstNV;
    }
}
