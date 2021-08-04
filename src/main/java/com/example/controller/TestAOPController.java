package com.example.controller;

import com.example.annotation.ApiLog;
import com.example.annotation.IgnoreApiLog;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class TestAOPController {

    @GetMapping(value = "/queryTest1/{id}")
    public List<String> queryTest1( @PathVariable("id") String id){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        return list;
    }

    @PostMapping("addTest2")
    @ApiLog
    public Boolean addTest2(@RequestBody Map<String,Object> paramsMap) {
        return true;
    }


    @PostMapping("addTest3")
    @ApiLog
    @IgnoreApiLog
    public Boolean addTest3(@RequestBody Map<String,Object> paramsMap) {
        return true;
    }
}
