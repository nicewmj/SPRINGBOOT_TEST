package com.example.service.userAOP;

import com.example.entity.UserLogDTO;

public interface UserLogService {

    /**
     * 插入用户操作日志
     *
     * @param userLogDTO
     * @return
     */
    Boolean addSysLog(UserLogDTO userLogDTO);
}
