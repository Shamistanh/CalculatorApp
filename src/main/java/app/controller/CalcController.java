package app.controller;

import app.service.CalcService;
import app.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Log4j2
@Controller
@RequestMapping("/")
public class CalcController {

    private final CalcService calcService;
    private final UserService userService;

    public CalcController(CalcService calcService, UserService userService) {
        this.calcService = calcService;
        this.userService = userService;
    }

    @GetMapping("calc")
    public String handle_get_calc(Model model) {
        return "calc";
    }

    @GetMapping("login")
    public String handle_get_login(Model model) {
        return "login";
    }


    @PostMapping("calc")
    public String handle_post_calc(Model model, @RequestParam("op")String operation) {

        final Double res = calcService.calc(operation);
        model.addAttribute("result",res);
        userService.saveToDB(operation , res);
        return "calc";
    }
}
