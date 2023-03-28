package com.example.util;

import com.example.enums.CustomExceptionType;
import com.example.exception.CustomException;
import lombok.Data;

@Data
public class AjaxResponse {
    private int code;
    private String message;
    private Object data;

    private AjaxResponse(){

    }

    public static AjaxResponse error(CustomException e){
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setCode(e.getCode());
        resultBean.setMessage(e.getMessage());
        return resultBean;
    }

    public static AjaxResponse error(CustomExceptionType customExceptionType,String errorMessage){
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setCode(customExceptionType.getCode());
        resultBean.setMessage(errorMessage);
        return resultBean;
    }

    /**
     * 用于删除、修改、新增接口
     * @return
     */
    public static AjaxResponse success(){
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setCode(200);
        resultBean.setMessage("请求响应成功");
        return resultBean;
    }

    /**
     * 用于查询接口
     * @return
     */
    public static AjaxResponse success(Object obj){
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setCode(200);
        resultBean.setData(obj);
        resultBean.setMessage("请求响应成功");
        return resultBean;
    }

    public static AjaxResponse success(Object obj,String message){
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setCode(200);
        resultBean.setData(obj);
        resultBean.setMessage(message);
        return resultBean;
    }


}
