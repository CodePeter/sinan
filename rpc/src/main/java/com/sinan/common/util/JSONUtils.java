package com.sinan.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Nullable;
import java.io.IOException;
import java.util.Optional;
import java.util.TimeZone;

/**
 * 提供java对象和json转换相关的方法
 * <p />
 * 这段代码是基于Jackson实现的，Jackson是一个相当优秀的json库，
 * 若对这部分代码有疑问，请查询Jackson的相关文档。
 * <p />
 * 大部分json输出格式上的问题，可以通过添加Jackson相关注解解决。
 *
 * @author KONG Xiangxin
 */
public class JSONUtils {
    private static final ObjectMapper MAPPER = getMapper();

    private static ObjectMapper getMapper() {
        return new ObjectMapper()
                .registerModule(new Jdk8Module())
                .registerModule(new JavaTimeModule())
                // 当json字符串中含有未知的属性时不会抛出异常
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .setTimeZone(TimeZone.getDefault());
    }

    /**
     * 将json字符串转换为对象
     * <p />
     * 当传入的json包括未知属性时不会报错；
     * 当传入的json格式有误时，返回空Optional；
     *
     * @param json json字符串
     * @param klass 要转换的对象的类型
     * @return 转换为的对象的Optional封装
     */
    public static <T> Optional<T> fromJsonWithoutException(@Nullable String json, Class<T> klass) {
        if (StringUtils.isEmpty(json)) {
            return Optional.empty();
        }
        try {
            return Optional.of(fromJson(json, klass));
        } catch (Exception e) {
//        } catch (JsonException e) {
            return Optional.empty();
        }
    }

    /**
     * 将json字符串转换为对象
     * <p />
     * 当传入的json包括未知属性时不会报错；
     * 当传入的json格式有误时，将抛出RuntimeException；
     *
     * @param json json字符串
     * @param klass 要转换的对象的类型
     * @return 转换为的对象的Optional封装
     */
    public static <T> T fromJson(String json, Class<T> klass) {
        try {
            return MAPPER.readValue(json, klass);
        } catch (IOException e) {
//            throw new JsonException("解析json失败", e, json);
            return null;
        }
    }

    /**
     * 将json字符串转换为对象，该方法可以防止从json转换为集合对象时丢失集合内容的类型
     * <p />
     * 当传入的json包括未知属性时不会报错；
     * 当传入的json格式有误时，返回空Optional；
     *
     * @param json json字符串
     * @param type 要转换的对象的类型
     * @return 转换为的对象的Optional封装
     */
    public static <T> Optional<T> fromJsonWithoutException(@Nullable String json, TypeReference<T> type) {
        if (StringUtils.isEmpty(json)) {
            return Optional.empty();
        }
        try {
            return Optional.of(fromJson(json, type));
        } catch (Exception e) {
//        } catch (JsonException e) {
            return Optional.empty();
        }
    }

    /**
     * 将json字符串转换为对象，该方法可以防止从json转换为集合对象时丢失集合内容的类型
     * <p />
     * 当传入的json包括未知属性时不会报错；
     * 当传入的json格式有误时，将抛出RuntimeException；
     *
     * @param json json字符串
     * @param type 要转换的对象的类型
     * @return 转换为的对象的Optional封装
     */
    public static <T> T fromJson(String json, TypeReference<T> type) {
        try {
            return MAPPER.readValue(json, type);
        } catch (IOException e) {
//            throw new JsonException("解析json失败", e, json);
            return null;
        }
    }

    /**
     * 将对象转换为json字符串
     *
     * @param value 要转换的对象
     * @return 转换为的字符串
     */
    public static <T> String toJson(T value) {
        try {
            return MAPPER.writeValueAsString(value);
        } catch (JsonProcessingException e) {
//            throw new JsonException("生成json失败", e);
            return null;
        }
    }

    /**
     * 将对象转换为人类可读的格式化json
     *
     * @param value 要转换的对象
     * @return 转换为的字符串
     */
    public static <T> String toPrettyJson(T value) {
        try {
            return MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(value);
        } catch (JsonProcessingException e) {
//            throw new JsonException("生成json失败", e);
            return null;
        }
    }
}
