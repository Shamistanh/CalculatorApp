package app.controller;


import app.repo.CalcRepo;
import app.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/")
public class HistoryController {

    @Autowired
    private UserService userService;

    @Autowired
    private CalcRepo calcRepo;

    @GetMapping("history")
    public String handle_get_history(Model model) {
        model.addAttribute("ops", calcRepo.findAllByUsername(userService.logged_user().getUsername()));
        return "history";
    }
}
