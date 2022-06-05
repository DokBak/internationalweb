package db.pg.internationalweb;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InternationalController {
  
    @RequestMapping("/international")
    public String getInternationalPage() {
        return "international";
    }
    
    @ResponseBody
    @RequestMapping("/sessionClear")
    public String sessionClear(HttpSession ss) {
      ss.invalidate();
        return "OK";
    }
    
}