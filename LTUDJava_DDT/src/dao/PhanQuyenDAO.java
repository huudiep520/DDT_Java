/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.*;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class PhanQuyenDAO {
    private final SessionFactory sf = HibernateUtil.getSessionFactory();
    
    public List<Phanquyen> GetPermission(String user, String pass){
        Session ss = sf.getCurrentSession();
        ss.beginTransaction();
        Query qr = ss.createSQLQuery("CALL sp_GetPermission(:user, :pass)");
        qr.setString("user", user);
        qr.setString("pass", pass);
        List<Phanquyen> lstPQ = qr.list();
        
        ss.close();
        return lstPQ;
    }
}
