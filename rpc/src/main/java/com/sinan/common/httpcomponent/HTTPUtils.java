package com.sinan.common.httpcomponent;

import com.fasterxml.jackson.core.type.TypeReference;
import com.sinan.common.data.HelloDTO;
import com.sinan.common.data.ResultPlatformModel;
import com.sinan.common.util.JSONUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class HTTPUtils {

    private static HttpClientSetting setting = new HttpClientSetting();
//    private static HttpCommonBuilder builder = new HttpCommonBuilder();

    public static HttpCommonBuilder create() {
        return new HttpCommonBuilder(setting);
    }


    public static void main(String[] args) throws IOException {
//        ResultPlatformModel ret = HTTPUtils.createGet("http://localhost:8081/hello/helloworld5?message=hi5", new TypeReference<ResultPlatformModel>() {
//        });
//        System.out.println(JSONUtils.toJson(ret));
//        String url = "http://localhost:8081/hello/helloworld31";
//        String url = "http://localhost:8081/hello/helloworld32";
//        url += "?bizId=123";
//        HelloDTO helloDTO = new HelloDTO();
//        helloDTO.setLang("1");
//        helloDTO.setProductId(1);
//        helloDTO.setPath("/data/log");
//        helloDTO.setResumeNumber("YZ001");
//        ResultPlatformModel<HelloDTO> ret = HTTPUtils.create()
//                .setUrl(url)
//                .setMethodName("POST")
//                .setRequestBody(JSONUtils.toJson(helloDTO))
//                .query(new TypeReference<ResultPlatformModel<HelloDTO>>(){});
//        System.out.println(JSONUtils.toJson(ret));
        HttpClientSetting setting1 = HTTPUtils.setting;
        HttpClientSetting setting2 = HTTPUtils.setting;
        System.out.println(setting1);
        System.out.println(setting2);
    }

}
