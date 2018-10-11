package co.uk.ocelotcr.SpellBreakHelper.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {

    @RequestMapping("/")
    public String getRoot(Model model){
        model.addAttribute("messages","includedMessage");
        return "homepage";
    }


}
