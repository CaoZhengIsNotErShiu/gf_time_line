package per.sc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zheng
 * @version : 1.0
 * @desc :
 * @date : 2020/5/22 14:03
 */
@RestController
@RequestMapping("/admin")
public class AdminController {


    @GetMapping("/greeting")
    public String greeting() {
        return "Hello,World!";
    }

    @GetMapping("/login")
    public String login() {

        return "login sucess";
    }
}