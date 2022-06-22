package com.group2.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 */
@Controller
public class PayController {

    //创建支付宝支付需要的常量值

    // 应用标识， 需要使用支付宝扫码登录《支付宝沙箱环境地址》中查看
    private final String APP_ID = "2021000121602552";
    // 应用私钥， 需要安装支付宝开放平台助手，在助手中---生成密钥 找
    private final String APP_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDF03xGHhgGnFdCtBzeCClei/fejUPC2kbC0+E6b0z9n/KjQl439rtdMKwS5La0M7mL2KD7FcuGcDMeLihWfXGl9ezrOw0Ru28wccrAXsuiRCoi/m/kDMC0T3NvcPyLooL7iuCAn4yeeEze/eACIyqZJGMV4W7kFCDzklpg/19tdE6CFmz1xUX3+PXpqtHbuh7JRE+3KVglXwrm0TnwkJZ4nahJSmX7tPuq37bGKWW3a5m7Bu1UKzKBU66ys3uVNc0Lw2Z1xoQD3ER195pRn3gc3wGAqIJUK8qOTNEy/rFfJGsqOxjPco0RCyJFzPgWk/QlRGU0aWfA57O9m7B68kQHAgMBAAECggEAIAYROwSKHR/X3FttxN+LWtvLn0I88uEEzWshLaVw0CnBTH5k5ChTwk0rvc86aEdrROEnhh3MGZI2JC+SphWefSAnXxjrD7DI2g3BpYxy6GyiaZHIqSELXOTzqdmfeDcxfujHWOr7B3gv8XUlexMYRTwnshYRLmi3wNYzPTp5xyzgsrNuS4obulplK5qKI9mxI/Xzh2FkxiufiKkhME/uUI6LNcepw7ovYEqAuGHMQ6aE9b+z0YSw0grWtAQfge08QLZseOMHrxaDPUzrlsiCP1Z6506DP7E8+mP28ElzmIvkrsuzIN8wW0s4bhTS7M8q8LeTsIcizhrT63hVRPOmUQKBgQDxYyKCuGouK0vlwMEUJtPHd2CBgFIdpN0uBvNPnM4l3FdbD3N4k+aC6H1P4Hrdpv7og/G3oMXtkP154hOz9P3dcBepwXqW/XrOrETxNbwkEy11rsIUhoxIi2n9m8n+KSv78EFHnspii4YI9loFvM+xe3BzUlJBkJr2lNoNGODA2QKBgQDRzUShp+4pYSXSy8z1p9+VtJr3zp+IHbUlq1Gf38L0o/nD9s7nJXLxQVycQJ3wM0xd6Q2YUQ07tAr/cR63rKbiKy62eJwfKkg2NWmSdSTqAyknrwWFCTB92H1+q2TFTwe6R5mu6Tkcuz6YqeJCpDsiEOBpFcg13h7LPoQWdFAf3wKBgQDhVBIuBmoPyRjjUsipwAjnZRdwK9H7nB9fzNsp0Q1aqFHfThATWbTPNKlte/YVnMLNWAW2zVyWBEeplBGiZiron69nJpYCBoKyFHuS0v9aiZBhD45aTLL9MS7yr4+iMtq9Jqw5aBAyZ13qVdT5ECSs37a73/eq/oq5bYASw8tiGQKBgGFamg1Vipti/BUsAui/RG4Ih5yUIc0c0/Et5UuFnsa8zGqVvX7fDs5KoTnUdjV+6GHvgiJ7AeQBcNUF3dYnZK0wkpWTtAZ2LVoSQPH4L+/zFYbXnX0VPY44BkvgJnu0Z4aWMQdMK/dcH/jhZB++a74sDKZWuDfe4XU4hjyRLpkLAoGBAIpXGRwg8w9XLPOgpBXzJy80LnchQlxE1/YvQC23TrUu860Hk2rKvsn/vRmmmALX/6U+HRj0f3lSLfjp0ixRR9bI13z6bmhNWo5jxJoEckTSkps0QWFHTF5Z5qOyas49p97Po7cwraNlQnMqOZnI8QS1P/GYh30r9m9WddQJv1iT";
    // 编码格式
    private final String CHARSET = "UTF-8";
    // 支付宝公钥
    private final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxdN8Rh4YBpxXQrQc3ggpXov33o1DwtpGwtPhOm9M/Z/yo0JeN/a7XTCsEuS2tDO5i9ig+xXLhnAzHi4oVn1xpfXs6zsNEbtvMHHKwF7LokQqIv5v5AzAtE9zb3D8i6KC+4rggJ+MnnhM3v3gAiMqmSRjFeFu5BQg85JaYP9fbXROghZs9cVF9/j16arR27oeyURPtylYJV8K5tE58JCWeJ2oSUpl+7T7qt+2xillt2uZuwbtVCsygVOusrN7lTXNC8NmdcaEA9xEdfeaUZ94HN8BgKiCVCvKjkzRMv6xXyRrKjsYz3KNEQsiRcz4FpP0JURlNGlnwOezvZuwevJEBwIDAQAB";
    // 沙箱路径接口，正式路径应为https://openapi.alipay.com/gateway.do
    private final String GATEWAY_URL = "https://openapi.alipaydev.com/gateway.do";
    // 参数返回格式
    private final String FORMAT = "JSON";
    // 签名方式
    private final String SIGN_TYPE = "RSA2";
    // 支付宝异步通知路径，付款完毕后会异步调用本项目的方法，必须为公网地址
    private final String NOTIFY_URL = "http://127.0.0.1/notifyURL";
    // 支付宝同步通知路径，也就是当付款完毕后跳转本项目的页面，可以不是公网地址

    //这里你写一个你自己项目的地址路径，这样的话，消费者支付成功之后，支付宝那边就会调用你这里写的这个地址
//    private final String RETURN_URL = "http://127.0.0.1/returnURL";
    private final String RETURN_URL = "http://localhost:8081/portal/success.html";


    @RequestMapping("/alipay")
    public void alipay(HttpServletResponse response) throws Exception{

        //1. 调用支付宝API，将我们的商品相关的信息传递给支付宝方

        //2.支付宝会给我们返回一个大的HTML字符串

        //3.我们将该HTML字符串直接打印给前端浏览器


        // 实例化客户端,填入所需参数
        // 网关地址 应用标识 应用私钥 传输格式 编码格式 支付宝公钥 签名类型
        AlipayClient alipayClient = new DefaultAlipayClient(GATEWAY_URL, APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE);
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        //在公共参数中设置回跳和通知地址
        request.setReturnUrl(RETURN_URL);
        request.setNotifyUrl(NOTIFY_URL);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        //生成随机Id
        String out_trade_no = UUID.randomUUID().toString();
        //付款金额，必填
        String total_amount =Integer.toString(100);
        //订单名称，必填
        String subject ="奥迪A8 2016款 A8L 60 TFSl quattro豪华型";
        //商品描述，可空
        String body = "尊敬的会员欢迎购买奥迪A8 2016款 A8L 60 TFSl quattro豪华型";
        request.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        String form = "";
        try {
            //这个返回的内容就是一个HTML的字符串，我们就需要将该字符串打给浏览器
            form = alipayClient.pageExecute(request).getBody(); // 调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=" + CHARSET);
        response.getWriter().write(form);// 直接将完整的表单html输出到页面
        response.getWriter().flush();
        response.getWriter().close();
    }
}
