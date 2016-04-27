/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.*;
import java.sql.PreparedStatement;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author xFactor520
 */
public class BanGheDAO {
    private final SessionFactory sf = HibernateUtil.getSessionFactory();
    
    public List<Banghe> GetAll(){
        Session ss = sf.getCurrentSession();
        ss.beginTransaction();
        Query qr = ss.createSQLQuery("CALL sp_GetBanGhe").addEntity(Banghe.class);
        List<Banghe> lstBG = qr.list();
        ss.close();
        return lstBG;
    }
    
    public Banghe GetBanGheById(String maBan){
        Session ss = sf.getCurrentSession();
        ss.beginTransaction();
        Query qr = ss.createSQLQuery("CALL sp_GetBanGheById(:maBan)").addEntity(Banghe.class);
        qr.setString("maBan",maBan);
        List<Banghe> lstBG = qr.list();
        Banghe bg = lstBG.get(0);
        //Trangthai tt = bg.getTrangthai();
        //Nhanvien nv = bg.getNhanvien();
        ss.close();
        return bg;
    }
    
    public boolean UpdateStatusTable(String idST, String maBan){
        Session ss = sf.getCurrentSession();
        ss.beginTransaction();
        try {
            Query qr = ss.createSQLQuery("CALL sp_UpdateStatusTable(:idST, :maBan)").addEntity(Banghe.class);
            qr.setString("idST", idST);
            qr.setString("maBan", maBan);
//            List<Banghe> bg = qr.list();
            qr.executeUpdate();
            ss.getTransaction().commit();
//            if(bg.size()>0){
//                ss.close();
//                return true; 
//            }
            //ss.close();
            return true;
            
        } catch (Exception e) {
            ss.close();
            return false;
        }
 
    }
}
