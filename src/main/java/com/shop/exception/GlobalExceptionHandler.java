package com.shop.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Handle exceptions across the whole application
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    public static final String DEFAULT_ERROR_VIEW = "error";
    public static final String EXCEPTION = "exception";
    public static final String URL = "url";

    /**
     *
     * @param request provide request information for HTTP servlets
     * @param e custom error message from Exception class
     * @return a ModelAndView object used for mapping a web page, a jsp file with the same name
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception {
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) throw e;

        ModelAndView mav = new ModelAndView();
        mav.addObject(EXCEPTION, e);
        mav.addObject(URL, request.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        logger.error("This is an error log entry");
        return mav;
    }
}
