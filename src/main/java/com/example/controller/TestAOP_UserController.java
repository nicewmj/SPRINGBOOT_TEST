package com.example.controller;

import com.example.annotation.UserLog;
import com.example.entity.UserLogDTO;
import com.example.enumEntiy.ModuleEnum;
import com.example.enumEntiy.OperationEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * AOP 用户行为日志的打印 入库操作（用户操作那个方法 参数等等 用户行为
 */

@Slf4j
@RestController
public class TestAOP_UserController {

    @UserLog(module = ModuleEnum.USER, title = "批量更新用户", type = OperationEnum.MODIFY)
    @PostMapping("updateBatchUser")
    public Boolean updateBatchUser(@RequestBody Map<String,Object> paramsMap) {
        return true;
    }

    @UserLog(module = ModuleEnum.USER, title = "新增用户", type = OperationEnum.ADD)
    @PostMapping("insertUser")
    public Boolean insertUser(@RequestBody UserLogDTO user) {
        return true;
    }
}
