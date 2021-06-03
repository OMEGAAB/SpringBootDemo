package com.in28minutes.springboot.web.controller;

import com.in28minutes.springboot.web.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
// @SessionAttributes("name")
public class WelcomeController {
    // @Autowired
    // LoginService ls;
    @RequestMapping("/")
    public String showWelcomePage(ModelMap model) {
        model.put("name", getLoggedInUSerName());
        return "welcome";
    }

    private String getLoggedInUSerName() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }
        return principal.toString();
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
