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
       // String per="";
        Query qr = ss.createSQLQuery("CALL sp_GetPermission(:user, :pass)").addEntity(Phanquyen.class);
        qr.setString("user", user);
        qr.setString("pass", pass);
        //qr.setString("per", per);
        
        List<Phanquyen> lstPQ = qr.list();
        //per = lstPQ.get(0).toString();
        //qr.executeUpdate();
        ss.close();
        return lstPQ;
    }
}
