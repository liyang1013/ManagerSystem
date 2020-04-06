package com.example.demo.config;



import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;


public class MyLocalResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
       String lang= httpServletRequest.getParameter("lang");
       Locale locale=Locale.getDefault();
       if(!StringUtils.isEmpty(lang)){
          String[] split= lang.split("_");
          locale=new Locale(split[0],split[1]);
       }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
