package com.funzuqiu.ffu.home.common.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.funzuqiu.commons.mapper.JsonMapper;
import com.funzuqiu.ffu.home.common.exception.BaseException;
import com.funzuqiu.ffu.home.common.exception.server.BusinessException;
import com.funzuqiu.ffu.home.common.web.entity.HttpResult;
import com.google.common.net.HttpHeaders;

@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(BaseException.class)
    public ModelAndView businessExceptionHandler(BaseException ex, HttpServletRequest request,
            HttpServletResponse response) {
        log(ex);
        return response(ex, request, response);
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(Exception ex, HttpServletRequest request, HttpServletResponse response) {
        log(ex);
        return response(new BusinessException(), request, response);
    }

    private void log(Exception ex) {
        log.error(ExceptionUtils.getStackTrace(ex));
    }

    private ModelAndView response(BaseException ex, HttpServletRequest request, HttpServletResponse response) {
        boolean isAjax = StringUtils.equalsIgnoreCase("XMLHttpRequest",
                request.getHeader(HttpHeaders.X_REQUESTED_WITH));

        ModelAndView mv = new ModelAndView();
        if (isAjax) {
            HttpResult result = HttpResult.error(ex.getCode(), ex.getMessage()).setData(ex.getData());
            mv.setView(new MappingJackson2JsonView(JsonMapper.getInstance()));
            mv.addAllObjects(result.toMap());
        } else {
            mv.addObject("error", ex.getMessage());
            mv.setViewName("error/error");
        }
        return mv;
    }

}
