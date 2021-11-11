package com.hpw.message.service;

import java.io.IOException;

import com.hpw.message.entity.Result;

public interface MsgSend {

    /**
     * 发送请求
     * 返回0是成功，返回1是失败
     * @param url
     * @param xml
     * @return
     * @throws IOException
     */
    Result sendSms(String url, String xml) throws IOException;
}
