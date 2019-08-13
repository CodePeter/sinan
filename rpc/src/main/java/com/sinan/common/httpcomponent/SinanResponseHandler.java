package com.sinan.common.httpcomponent;

import com.fasterxml.jackson.core.type.TypeReference;
import com.sinan.common.util.JSONUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.core.util.JsonUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.ref.Reference;
import java.nio.charset.Charset;

public class SinanResponseHandler<T> implements ResponseHandler<T> {

    private TypeReference<T> type;

    public SinanResponseHandler(TypeReference<T> type) {
        this.type = type;
    }

    @Override
    public T handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
        StatusLine statusLine = response.getStatusLine();
        HttpEntity entity = response.getEntity();
        if (statusLine.getStatusCode() >= 300) {
            throw new HttpResponseException(
                    statusLine.getStatusCode(),
                    statusLine.getReasonPhrase());
        }
        if (entity == null) {
            throw new ClientProtocolException("Response contains no content");
        }
//        Gson gson = new GsonBuilder().create();
        ContentType contentType = ContentType.getOrDefault(entity);
        Charset charset = contentType.getCharset();
        String content = EntityUtils.toString(entity, charset);
//        Reader reader = new InputStreamReader(entity.getContent(), charset);
//        TypeReference<T> type = new TypeReference<>();
//        return JsonUtils.fromJson(content, );
        return JSONUtils.fromJson(content, type);
//        return content;
    }

//    public T getValue(HttpResponse response, TypeReference<T> type) throws IOException {
//        return JSONUtils.fromJson(handleResponse(response), type);
//    }


}
