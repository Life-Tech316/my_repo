package com.ibm.asset.ib.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebPageController {
    @RequestMapping("/mt")
    public String mt(Model model) {
        return "forward:/";
    }
    @RequestMapping("/admin")
    public String admin(Model model) {
        return "forward:/";
    }
}
