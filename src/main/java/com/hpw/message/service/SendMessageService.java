package com.hpw.message.service;

import com.hpw.message.service.MsgSend;
import com.hpw.message.entity.Result;
import com.hpw.message.tool.SendSoap;
import org.dom4j.Document;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class SendMessageService implements MsgSend {

    @Override
    public Result sendSms(String url, String xml) {
        SendSoap sendSoap = new SendSoap();
        Result result = sendSoap.send(url, xml);
        return result;
    }
}
