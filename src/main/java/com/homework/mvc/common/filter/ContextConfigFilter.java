package com.homework.mvc.common.filter;

import com.homework.mvc.common.config.ConfigLocation;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class ContextConfigFilter implements Filter {
    public ContextConfigFilter() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        //데이터 접속 설정 정보 파일의 경로가 비어있는 경우 초기화
        if(ConfigLocation.CONNECTION_CONFIG_LOCATION == null){
            String root = request.getServletContext().getRealPath("/");
            String coonectionInfoPath = request.getServletContext().getInitParameter("connection-info");

            ConfigLocation.CONNECTION_CONFIG_LOCATION = root + coonectionInfoPath;
            System.out.println("config Location : " + ConfigLocation.CONNECTION_CONFIG_LOCATION);
        }

        if(ConfigLocation.MAPPER_LOCATION == null){
            String root = request.getServletContext().getRealPath("/");
            String mapperLocation = request.getServletContext().getInitParameter("mapper-location");

            System.out.println("매퍼 경로 설정 완료");
            ConfigLocation.MAPPER_LOCATION = root +mapperLocation;
            System.out.println("mapper location : " + ConfigLocation.MAPPER_LOCATION);
        }

        chain.doFilter(request,response);
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }


}
