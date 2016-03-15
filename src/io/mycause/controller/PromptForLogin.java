package io.mycause.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PromptForLogin {

        @RequestMapping("/login")
        public ModelAndView promptLogin()
        {
            return new ModelAndView("login", "message", "");
        }
}