package cbd.com.vn.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping()
    public String view(Model model) {
        model.addAttribute("value", "hello");
        return "/user/layouts/home";
    }

}
