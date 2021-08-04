package com.example.service.userAOP;

import com.example.entity.UserLogDO;
import com.example.entity.UserLogDTO;
import com.example.mapper.UserLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLogServiceImpl implements UserLogService{

    @Autowired
    private UserLogMapper userLogMapper;

    @Override
    public Boolean addSysLog(UserLogDTO userLogDTO) {
        UserLogDO userLogDO = new UserLogDO();
        userLogDO.setModuleCode(userLogDTO.getModuleCode());
        userLogDO.setType(userLogDTO.getType());
        userLogDO.setTitle(userLogDTO.getTitle());
        userLogDO.setOperatorId(userLogDTO.getOperatorId());
        userLogDO.setOperateTime(userLogDTO.getOperateTime());
        userLogDO.setContent(userLogDTO.getContent());

        if(userLogMapper.insertUserLog(userLogDO) > 0){
            return true;
        }
        return false;
    }
}
