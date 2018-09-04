package com.ldlywt.hello.bean;

import com.zhouyou.http.model.ApiResult;

/**
 * <pre>
 *     author : lex
 *     e-mail : ldlywt@163.com
 *     time   : 2018/09/04
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class BaseResult<T> extends ApiResult<T> {

    private String errorMsg;
    private int errorCode;

    @Override
    public int getCode() {
        return errorCode;
    }

    @Override
    public void setCode(int code) {
        errorCode = code;
    }

    @Override
    public String getMsg() {
        return errorMsg;
    }

    @Override
    public void setMsg(String msg) {
        errorMsg = msg;
    }
   /* @Override
    public boolean isOk() {
        return errorCode==200;//如果不是0表示成功，请重写isOk()方法。
    }*/
}
