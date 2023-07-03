package com.homework.menu.controller;

import com.homework.menu.model.dto.MenuDTO;
import com.homework.menu.model.service.MenuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/menu/list")
public class SelectAllMenuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        MenuService menuService = new MenuService();
        List<MenuDTO> menuList = menuService.selectAllMenu();

        for(MenuDTO menu : menuList){
            System.out.println(menu);
        }

        String path = "";
        if(menuList != null){
            path = "/WEB-INF/views/menu/menuList.jsp";
            req.setAttribute("menuList", menuList);
        }else{
            path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "메뉴 조회 실패");
        }

        req.getRequestDispatcher(path).forward(req,resp);
    }
}
