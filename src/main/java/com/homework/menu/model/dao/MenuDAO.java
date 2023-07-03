package com.homework.menu.model.dao;

import com.homework.menu.model.dto.MenuDTO;
import com.homework.mvc.common.config.ConfigLocation;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.homework.mvc.common.jdbc.JDBCTemplate.close;

public class MenuDAO {

    private final Properties prop;

    public MenuDAO() {
        prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream
                    (ConfigLocation.MAPPER_LOCATION
                            + "menu-mapper.xml"));
            System.out.println("prop DAO : " + ConfigLocation.MAPPER_LOCATION + "menu-mapper.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public List<MenuDTO> selectAllMenu(Connection con) {
        Statement stmt = null;
        ResultSet rset = null;

        List<MenuDTO> menuList = null;

        String query = prop.getProperty("selectAllMenu");
        System.out.println(query);
        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);

            menuList = new ArrayList<>();

            while (rset.next()){
                MenuDTO menu = new MenuDTO();
                menu.setMenuName(rset.getString("MENU_NAME"));
                menu.setMenuPrice(rset.getInt("MENU_PRICE"));

                menuList.add(menu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(rset);
            close(stmt);
        }
        return menuList;
    }
}
