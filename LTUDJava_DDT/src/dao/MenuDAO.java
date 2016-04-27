/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.hibernate.SessionFactory;
import entities.Menu;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
/**
 *
 * @author xFactor520
 */
public class MenuDAO {
    private final SessionFactory sf = HibernateUtil.getSessionFactory();
    
    public List<Menu> GetMenu(){
        Session ss = sf.getCurrentSession();
        ss.beginTransaction();
        Query qr = ss.createSQLQuery("CALL sp_GetFoodList()").addEntity(Menu.class);
        List<Menu> lstMN = qr.list();
        ss.close();
       return lstMN;
    }
}
