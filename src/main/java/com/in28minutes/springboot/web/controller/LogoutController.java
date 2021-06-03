package com.in28minutes.springboot.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.in28minutes.springboot.web.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
// @SessionAttributes("name")
public class LogoutController {
    // @Autowired
    // LoginService ls;
    @RequestMapping("/logout")
    public String showWelcomePage(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/";
    }



    //Deprecated
    //  @RequestMapping(value="/login", method = RequestMethod.POST)
    //  public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password) {
    //      boolean valid = ls.isValid(name, password);
    //      if(valid) {
    //          model.put("name", name);
    //          return "welcome";
    //      } else {
    //          model.put("emsg", "Please enter valid credentials");
    //          return "login";
    //      }
    //  }


    
}
