package com.sinan.common.httpcomponent;

import com.fasterxml.jackson.core.type.TypeReference;
import com.sinan.common.util.JSONUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

/**
 * GET/POST 请求都可以从URL(xxx=xxx&xxx=xxx)
 * 和BODY(json/form-data/)中获取参数
 *
 * @author CH.CH
 */
public class HttpCommonBuilder {

    /** 从连接池中获取连接的超时时间 */
    private int connectionRequestTimeout = 1000;

    /** 建立连接的超时时间 */
    private int connectTimeout = 1000;

    /** 获取数据的超时时间 */
    private int timeout = 2000;

    /** 代理服务器地址 */
    private HttpHost proxy = null;

    /** 是否允许请求重定向 */
    private boolean redirectEnabled;

    /** url */
    private String url;

    /** 返回值编码，一般情况会自动判断，若对方没有设置，会使用该值作为默认值 */
//    private String responseCharset = SystemConstants.SYS_ENC;

    /** 请求头 */
    private List<Header> headers = new ArrayList<>();

    /** cookie */
    private List<NameValuePair> cookies = new ArrayList<>();

    /** url中的参数 */
    private List<NameValuePair> urlParams = new ArrayList<>();

    private ContentType contentType = ContentType.APPLICATION_JSON;

    private String requestBody;
    private List<NameValuePair> bodyParams = new ArrayList<>();
    private String methodName;

    private HttpClientSetting setting;
    private HttpEntityEnclosingRequestBase request;

    public HttpCommonBuilder(HttpClientSetting setting) {
        this.setting = setting;
    }

    public HttpRequestBase generateRequestInfo() {
        String url = getNormalizedUrl();
        HttpEntity entity = generateEntity();
        request = new HttpCommonRequest(url).setMethodName(methodName);
        request.setEntity(entity);
        request.setConfig(generateRequestConfig());
        return request;
    }

    protected String getNormalizedUrl() {
        try {
            URL parsedUrl;
            if (urlParams.isEmpty()) {
                parsedUrl = new URL(url);
            } else {
                parsedUrl = new URIBuilder(url).addParameters(urlParams).build().toURL();
            }
            return parsedUrl.toString();
        } catch (URISyntaxException | MalformedURLException e) {
//            LOGGER.warn("http: illegal url {}", url);
//            throw new IllegalUrlException(url, e);
            return null;
        }
    }

    private HttpEntity generateEntity() {
        if (StringUtils.isNotBlank(requestBody)) {
            return new StringEntity(requestBody, contentType);
        }
        String mimeType = contentType.getMimeType();
        if ("application/json".equalsIgnoreCase(mimeType)) {
            Map<String, Object> params = new LinkedHashMap<>();
            for (NameValuePair bodyParam : bodyParams) {
                params.put(bodyParam.getName(), bodyParam.getValue());
            }
            requestBody = JSONUtils.toJson(params);
            return new StringEntity(requestBody, contentType);
        }
        if ("multipart/form-data".equalsIgnoreCase(mimeType)) {
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            for (NameValuePair bodyParam : bodyParams) {
                builder.addTextBody(bodyParam.getName(), bodyParam.getValue());
            }
            requestBody = bodyParams.toString();
            return builder.build();
        }
        requestBody = URLEncodedUtils.format(bodyParams, contentType.getCharset());
        return new StringEntity(requestBody, contentType);
    }

    public <T> T query(TypeReference<T> type) throws IOException {
        generateRequestInfo();
        CloseableHttpResponse response = setting.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();
        try {
            HttpEntity entity = response.getEntity();
            String body = EntityUtils.toString(entity, "utf-8");
            T value = JSONUtils.fromJson(body, type);
            return value;
        } catch (Exception e) {

        } finally {
            HttpClientUtils.closeQuietly(response);
        }
        return null;
    }

    private RequestConfig generateRequestConfig() {
        return RequestConfig.custom().setConnectionRequestTimeout(connectionRequestTimeout)
                .setConnectTimeout(connectTimeout).setSocketTimeout(timeout).setProxy(proxy)
                .setRedirectsEnabled(redirectEnabled).build();
    }

    public String getUrl() {
        return url;
    }

    public HttpCommonBuilder setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getMethodName() {
        return methodName;
    }

    public HttpCommonBuilder setMethodName(String methodName) {
        this.methodName = methodName;
        return this;
    }

    public List<NameValuePair> getUrlParams() {
        return urlParams;
    }

    public HttpCommonBuilder setUrlParams(List<NameValuePair> urlParams) {
        this.urlParams = urlParams;
        return this;
    }

    public List<NameValuePair> getBodyParams() {
        return bodyParams;
    }

    public HttpCommonBuilder setBodyParams(List<NameValuePair> bodyParams) {
        this.bodyParams = bodyParams;
        return this;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public HttpCommonBuilder setRequestBody(String requestBody) {
        this.requestBody = requestBody;
        return this;
    }

    public HttpCommonBuilder addUrlParam(String name, String value) {
        this.urlParams.add(new BasicNameValuePair(name, value));
        return this;
    }

    public HttpCommonBuilder addBodyParam(String name, String value) {
        this.bodyParams.add(new BasicNameValuePair(name, value));
        return this;
    }

}
