package com.wfr.base.framework.common.utils;

import cn.hutool.http.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * 基于 {@link cn.hutool.http.HttpUtil} 工具类, 简化 HTTP 请求工具
 * <p>
 * 依赖: hutool-all、fastjson
 * </p>
 *
 * @author wangfarui
 * @since 2022/9/28
 */
@SuppressWarnings("unchecked")
public abstract class HttpUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpUtils.class);

    /**
     * 发送post请求
     *
     * @param url     请求完整路径
     * @param body    body请求对象
     * @param header  请求头header
     * @param resType 响应对象类型
     * @param <T>     body请求对象类型
     * @param <R>     响应对象类型
     * @return 响应对象实体
     */
    public static <T, R> R post(String url, T body, Map<String, String> header, Object resType) {
        HttpWrapRequest<?> request = createRequest().setUrl(url).setBody(body).setHeader(header);
        return post(request, resType);
    }

    /**
     * 发送post请求
     *
     * @param request 请求对象
     * @param resType 响应类型
     * @param <T>     请求对象body类型
     * @param <R>     响应对象类型
     * @return 响应对象实体
     */
    public static <T, R> R post(HttpWrapRequest<T> request, Object resType) {
        String url = request.url;
        T body = request.getBody();
        Map<String, String> header = request.getHeader();

        HttpRequest httpRequest = HttpUtil.createPost(url).body(JSON.toJSONString(body), ContentType.JSON.getValue());
        if (request.getCharset() != null) {
            httpRequest.charset(request.getCharset());
        }
        if (!header.isEmpty()) {
            for (Map.Entry<String, String> entry : header.entrySet()) {
                httpRequest.header(entry.getKey(), entry.getValue());
            }
        }
        try {
            String resStr = httpRequest.execute().body();
            if (resType instanceof TypeReference) {
                TypeReference<R> typeReference = (TypeReference<R>) resType;
                return JSON.parseObject(resStr, typeReference);
            } else if (resType instanceof Class) {
                Class<R> typeClazz = (Class<R>) resType;
                return JSON.parseObject(resStr, typeClazz);
            } else {
                return (R) resStr;
            }
        } catch (HttpException e) {
            LOGGER.error(String.format("HTTP远程调用请求异常, url: %s, req: %s, header: %s", url, JSON.toJSONString(body), header), e);
            throw e;
        } catch (Throwable e) {
            LOGGER.error(String.format("HTTP调用请求异常, url: %s, req: %s, header: %s", url, JSON.toJSONString(body), header), e);
            throw e;
        }
    }

    public static <T> HttpWrapRequest<T> createRequest() {
        return new HttpWrapRequest<>();
    }

    public static class HttpWrapRequest<T> {

        /**
         * TODO 暂时无用. 默认只执行post请求
         */
        private Method method;

        private String url;

        private T body;

        private Map<String, String> header = new HashMap<>();

        /**
         * 字符编码默认为 UTF-8
         */
        private Charset charset;

        public HttpWrapRequest() {
        }

        public Method getMethod() {
            return method;
        }

        public HttpWrapRequest<T> setMethod(Method method) {
            this.method = method;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public HttpWrapRequest<T> setUrl(String url) {
            this.url = url;
            return this;
        }

        public T getBody() {
            return body;
        }

        public HttpWrapRequest<T> setBody(T body) {
            this.body = body;
            return this;
        }

        public Map<String, String> getHeader() {
            return header;
        }

        public HttpWrapRequest<T> setHeader(Map<String, String> header) {
            this.header = header;
            return this;
        }

        public Charset getCharset() {
            return charset;
        }

        public HttpWrapRequest<T> setCharset(Charset charset) {
            this.charset = charset;
            return this;
        }

        /**
         * 配置授权token
         *
         * @param authorization 授权token
         * @return HttpWrapRequest
         */
        public HttpWrapRequest<T> setAuthorization(String authorization) {
            this.header.put(Header.AUTHORIZATION.getValue(), authorization);
            return this;
        }

        /**
         * 增加请求头参数 (默认覆盖重复key)
         *
         * @param key   请求头key
         * @param value 请求头value
         * @return HttpWrapRequest
         */
        public HttpWrapRequest<T> addHeaderParam(String key, String value) {
            this.header.put(key, value);
            return this;
        }

        /**
         * 使用 POST 方式调用, 返回指定响应对象类型
         *
         * @param resClazz 响应对象类型
         * @param <R>      响应对象类型
         * @return 响应对象
         */
        public <R> R executePost(Class<R> resClazz) {
            return post(this.url, this.body, this.header, resClazz);
        }

        /**
         * 使用 POST 方式调用, 返回指定响应对象类型（处理多级泛型对象）
         *
         * @param typeReference 响应对象类型引用
         * @param <R>           响应对象类型
         * @return 响应对象
         */
        public <R> R executePost(TypeReference<R> typeReference) {
            return post(this.url, this.body, this.header, typeReference);
        }

        /**
         * 使用 POST 方式调用
         *
         * @return 字符串形式的响应结果
         */
        public String executePost() {
            return executePost(String.class);
        }
    }
}
