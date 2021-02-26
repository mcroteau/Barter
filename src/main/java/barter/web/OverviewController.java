package barter.web;

import barter.service.OverviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class OverviewController {

    @Autowired
    OverviewService overviewService;

    @RequestMapping(value="/overview", method= RequestMethod.GET)
    public String index(ModelMap modelMap){
        return overviewService.index(modelMap);
    }

}
