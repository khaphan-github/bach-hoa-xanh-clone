package com.bhx.webconfig.error;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null && status.toString().equals("403") || status.toString().equals("401")) {
            return "error/accessdenied"; // Return the name of your custom 401 error page HTML file
        }
        return "error/404"; // Return the name of your default error page HTML file
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
