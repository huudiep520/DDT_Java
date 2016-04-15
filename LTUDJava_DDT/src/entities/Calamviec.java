package entities;
// Generated Apr 15, 2016 4:34:07 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Calamviec generated by hbm2java
 */
public class Calamviec  implements java.io.Serializable {


     private String maCa;
     private Date gioBatDau;
     private Date gioKetThuc;
     private Set lichcalamviecs = new HashSet(0);

    public Calamviec() {
    }

	
    public Calamviec(String maCa, Date gioBatDau, Date gioKetThuc) {
        this.maCa = maCa;
        this.gioBatDau = gioBatDau;
        this.gioKetThuc = gioKetThuc;
    }
    public Calamviec(String maCa, Date gioBatDau, Date gioKetThuc, Set lichcalamviecs) {
       this.maCa = maCa;
       this.gioBatDau = gioBatDau;
       this.gioKetThuc = gioKetThuc;
       this.lichcalamviecs = lichcalamviecs;
    }
   
    public String getMaCa() {
        return this.maCa;
    }
    
    public void setMaCa(String maCa) {
        this.maCa = maCa;
    }
    public Date getGioBatDau() {
        return this.gioBatDau;
    }
    
    public void setGioBatDau(Date gioBatDau) {
        this.gioBatDau = gioBatDau;
    }
    public Date getGioKetThuc() {
        return this.gioKetThuc;
    }
    
    public void setGioKetThuc(Date gioKetThuc) {
        this.gioKetThuc = gioKetThuc;
    }
    public Set getLichcalamviecs() {
        return this.lichcalamviecs;
    }
    
    public void setLichcalamviecs(Set lichcalamviecs) {
        this.lichcalamviecs = lichcalamviecs;
    }




}


