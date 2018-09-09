package dao;

import util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdministratorDao {
    String admiName = "root";
    String psw = "123456";
    public boolean isAdministrator_(String admiName,String psw){
        if(admiName.equals(this.admiName) && psw.equals(this.psw))
            return true;
        return  false;
    }
    public boolean isAdministrator(String admiName,String psw){
        boolean flag = false;
        String sql = "SELECT * FROM `adm` WHERE `adm`.`admname` = "+ admiName;
        try (Connection c = DBUtil.getConnection(); Statement st = c.createStatement()) {

            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String ps = rs.getString("password");
                if(ps.equals(psw))
                    flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
