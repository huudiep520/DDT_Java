/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Banghe;
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
}
