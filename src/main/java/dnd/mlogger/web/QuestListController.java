package dnd.mlogger.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/questlist")
public class QuestListController {

    @GetMapping
    public String questList(){
        return "questlist";
    }
}
