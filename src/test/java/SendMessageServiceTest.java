import com.hpw.message.service.SendMessageService;
import com.hpw.message.entity.Result;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.junit.Test;

import java.util.List;


public class SendMessageServiceTest {

    private SendMessageService sendMessageService = new SendMessageService();

    @Test
    public void test() {
        String url = "http://10.133.3.52/SmgaMsg/SmgaMsgService.asmx";
        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <weixinjubaoSendSM xmlns=\"http://10.133.3.3/\">\n" +
                "      <textMobile>18050808209</textMobile>\n" +
                "      <textContext>postman测试5</textContext>\n" +
                "      <txtSmTime></txtSmTime>\n" +
                "      <textSmId></textSmId>\n" +
                "      <txtSrcId></txtSrcId>\n" +
                "    </weixinjubaoSendSM>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>\n";
        Result result = sendMessageService.sendSms(url, xml);
        System.out.println("返回代码：" + result.getCode());
        System.out.println("返回信息：" + result.getMsg());
    }

    @Test
    public void testJiexi() throws DocumentException {
        String result = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n" +
                "    <soap:Body>\n" +
                "        <weixinjubaoSendSMResponse xmlns=\"http://10.133.3.3/\">\n" +
                "            <weixinjubaoSendSMResult>发送成功</weixinjubaoSendSMResult>\n" +
                "        </weixinjubaoSendSMResponse>\n" +
                "    </soap:Body>\n" +
                "</soap:Envelope>";

        Document document = DocumentHelper.parseText(result);
        String a = document.asXML();
    }
}
