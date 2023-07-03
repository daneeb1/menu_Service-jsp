package com.homework.menu.model.service;

import com.homework.menu.model.dao.MenuDAO;
import com.homework.menu.model.dto.MenuDTO;

import java.sql.Connection;
import java.util.List;

import static com.homework.mvc.common.jdbc.JDBCTemplate.close;
import static com.homework.mvc.common.jdbc.JDBCTemplate.getConnection;

public class MenuService {

    private final MenuDAO menuDAO;

    public MenuService() {
        menuDAO = new MenuDAO();
    }

    public List<MenuDTO> selectAllMenu(){

        Connection con = getConnection();

        List<MenuDTO> menuList = menuDAO.selectAllMenu(con);

        close(con);

        return menuList;
    }

}
