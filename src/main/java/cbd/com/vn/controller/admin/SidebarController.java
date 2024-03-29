package cbd.com.vn.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SidebarController {
    @GetMapping("/admin/tong-quan")
    public String dashBoard(Model model) {
        model.addAttribute("activePage", "dashboard");
        return "/admin/index";
    }

    @GetMapping("/admin/khoa-hoc")
    public String course(Model model) {
        model.addAttribute("activePageDrop", "course");
        return "admin/course";
    }
}
