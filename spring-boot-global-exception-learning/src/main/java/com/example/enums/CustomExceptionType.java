package com.example.enums;

import com.example.consts.CodeConsts;
import com.example.consts.MsgConsts;
import lombok.Getter;

@Getter
public enum CustomExceptionType {

    /**
     * 客户端异常
     */
    USER_INPUT_ERROR(CodeConsts.CLIENT_ERROR_CODE, MsgConsts.INPUT_ERROR),
    /**
     * 服务器
     */
    SYSTEM_ERROR(CodeConsts.SYSTEM_ERROR_CODE, MsgConsts.SYSTEM_ERROR),
    /**
     * 未知异常
     */
    OTHER_ERROR(CodeConsts.OTHER_ERROR_CODE, MsgConsts.OTHER_ERROR),
    UNAUTHORIZED_ERROR(CodeConsts.UNAUTHORIZED_ERROR_CODE, MsgConsts.UNAUTHORIZED_ERROR),
    PARAM_ERROR(CodeConsts.PARAM_ERROR_CODE, MsgConsts.PARAM_ERROR);

    CustomExceptionType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private final int code;
    private final String desc;
}
