package cn.itcast.dubboxdemo.controller;


import cn.itcast.dubboxdemo.service.Ping;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class PingController {

    @Reference
    private Ping ping;

    @RequestMapping("/showName.do")
    @ResponseBody
    public String showName(){
        return ping.find();
    }
}

