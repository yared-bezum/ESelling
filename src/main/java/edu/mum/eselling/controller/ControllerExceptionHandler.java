package edu.mum.eselling.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.eselling.exceptionhandling.ProductNotFoundException;



@ControllerAdvice
public class ControllerExceptionHandler {
	
	
@ExceptionHandler(ProductNotFoundException.class)
		public ModelAndView handleError(HttpServletRequest req, ProductNotFoundException exception) {
			 ModelAndView mav = new ModelAndView();
			 mav.addObject("invalidProductId", exception.getFullMessage());
 			 mav.setViewName("productNotFound");
			 return mav;
		}

@ExceptionHandler(value = Exception.class)
public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
  
    if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null)
        throw e;

    // Otherwise setup and send the user to a default error-view.
    ModelAndView mav = new ModelAndView();
    mav.addObject("exception", e);
    mav.addObject("url", req.getRequestURL());
    mav.setViewName("error");
    return mav;
}
	
}
