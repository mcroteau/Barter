package barter.service;

import org.apache.commons.collections.ArrayStack;
import org.springframework.ui.Model;
import barter.common.Constants;
import barter.model.*;
import barter.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.NumberFormat;
import java.util.*;

@Service
public class BasicService {

    @Autowired
    AuthService authService;


    public String index(ModelMap modelMap) {
        if(authService.isAuthenticated()){
            return "review";
        }
        return "base/signin";
    }

    public String showSignin() {
        if(authService.isAuthenticated()){
            return "redirect:/overview";
        }
        return "base/signin";
    }

    public String showSignup() {
        authService.signout();
        return "base/signup";
    }

}
