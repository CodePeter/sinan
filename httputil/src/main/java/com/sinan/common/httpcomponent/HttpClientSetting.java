package com.sinan.common.httpcomponent;

import com.fasterxml.jackson.core.type.TypeReference;
import com.sinan.common.util.JSONUtils;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HttpClientSetting {

    private final PoolingHttpClientConnectionManager manager;
    private final CloseableHttpClient client;
    private SinanResponseHandler responseHandler;

    public HttpClientSetting() {
        manager = new PoolingHttpClientConnectionManager(60, TimeUnit.SECONDS);
        manager.setDefaultMaxPerRoute(100);
        manager.setMaxTotal(500);
        client = HttpClients.custom()
                .setConnectionManager(manager)
                .build();
    }

    public HttpClientSetting(SinanResponseHandler responseHandler) {
        manager = new PoolingHttpClientConnectionManager(60, TimeUnit.SECONDS);
        manager.setDefaultMaxPerRoute(100);
        manager.setMaxTotal(500);
        client = HttpClients.custom()
                .setConnectionManager(manager)
                .build();
        this.responseHandler = responseHandler;
    }

    /**
     * 调整连接池配置
     *
     * @param perRouteSize 每个域名的连接数限制
     * @param totalSize 总的连接数限制
     */
    public void setPoolSize(int perRouteSize, int totalSize) {
        manager.setDefaultMaxPerRoute(perRouteSize);
        manager.setMaxTotal(totalSize);
    }

    /**
     * 执行一个http请求
     *
     * @param request http请求信息
     * @return http请求结果
     */
    public CloseableHttpResponse execute(HttpRequestBase request) throws IOException {
        CloseableHttpResponse response = client.execute(request);
        return response;
    }

    public <T> T execute0(HttpRequestBase request, SinanResponseHandler<T> responseHandler) throws IOException {
        return client.execute(request, responseHandler);
    }

}
