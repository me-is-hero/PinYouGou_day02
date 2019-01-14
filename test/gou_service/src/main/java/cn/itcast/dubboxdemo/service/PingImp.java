package cn.itcast.dubboxdemo.service;

import com.alibaba.dubbo.config.annotation.Service;

@Service
public class PingImp implements Ping {
    public String find() {
        return  "enen";
    }
}
