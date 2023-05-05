package com.task.service;

import com.task.consts.MsgConsts;
import com.task.enums.CustomExceptionType;
import com.task.exception.CustomException;
import org.springframework.stereotype.Service;

@Service
public class ExceptionService {

    public void authError(){
        throw new CustomException(CustomExceptionType.UNAUTHORIZED_ERROR);
    }

    public void systemBizError() {
        throw new CustomException(CustomExceptionType.SYSTEM_ERROR, MsgConsts.SYSTEM_ERROR);
    }

    /**
     * 服务层、模拟用户输入数据导致的校验异常
     */
    public void userBizError(int input) {
        if (input <= 0){
            throw new CustomException(CustomExceptionType.USER_INPUT_ERROR,MsgConsts.INPUT_ERROR);
        }
    }

}
