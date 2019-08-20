package com.sinan.common.httpcomponent;

import com.sinan.common.util.JSONUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HttpCommonRequest extends HttpEntityEnclosingRequestBase {

    public final static String METHOD_NAME = "GET/POST";

    public String methodName;

    public HttpCommonRequest() {
        super();
    }

    public HttpCommonRequest(final URI uri) {
        super();
        setURI(uri);
    }

    /**
     * @throws IllegalArgumentException if the uri is invalid.
     */
    public HttpCommonRequest(final String uri) {
        super();
        setURI(URI.create(uri));
    }

    @Override
    public String getMethod() {
        return methodName;
    }

    public String getMethodName() {
        return methodName;
    }

    public HttpCommonRequest setMethodName(String methodName) {
        this.methodName = methodName;
        return this;
    }


}
