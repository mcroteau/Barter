package barter.service;

import org.springframework.ui.ModelMap;

public class OverviewService {

    public String index(ModelMap modelMap){
        return "overview";
    }

}
