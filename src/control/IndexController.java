package control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/index")
    public String handleRequest(Model model) throws Exception {
        model.addAttribute("message","这是第一个SpringMVC网页");
        return "index";
    }




}
