package org.example.backend.common.utils;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.NameValuePair;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.URI;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

/**
 * @Description: httpclient工具类
 * @Author: liwu3
 * @Date: 2021/6/10 16:45
 */
@Slf4j
public class HttpClientUtil {

    private static final int maxTotal = 500;
    private static final int maxPerRoute = 100;
    private static final int socketTimeout = 120 * 1000;
    private static final int connectTimeout = 120 * 1000;
    private static final int connectionRequestTimeout = 600 * 1000;
    private static final int defaultRetryCount = 3;
    private final static Charset defaultCharset = StandardCharsets.UTF_8;
    private volatile static CloseableHttpClient httpClient = null;

    private HttpClientUtil() {
    }

    /**
     * @param url
     * @return
     */
    public static String doGet(String url) {
        return doGet(url, null);
    }

    /**
     * @param url
     * @param params
     * @return
     */
    public static String doGet(String url, Map<String, String> params) {
        CloseableHttpClient httpclient = getHttpClient();
        String resultString = "";
        CloseableHttpResponse response = null;
        try {
            URIBuilder builder = new URIBuilder(url);
            if (params != null && !params.isEmpty()) {
                params.forEach((key, val) -> builder.addParameter(key, val));
            }
            URI uri = builder.build();
            HttpGet httpGet = new HttpGet(uri);
            response = httpclient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                return EntityUtils.toString(entity, defaultCharset);
            }
        } catch (Exception e) {
            log.error("http get请求异常, url:" + url, e);
        } finally {
            closeResponse(response);
        }
        return resultString;
    }

    /**
     * @param url
     * @return
     */
    public static String doPost(String url) {
        return doPost(url, null);
    }

    /**
     * @param url
     * @param params
     * @return
     */
    public static String doPost(String url, Map<String, String> params) {
        CloseableHttpClient httpClient = getHttpClient();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            HttpPost httpPost = new HttpPost(url);
            if (params != null && !params.isEmpty()) {
                List<NameValuePair> nameValuePairs = Lists.newArrayList();
                params.forEach((key, val) -> nameValuePairs.add(new BasicNameValuePair(key, val)));
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(nameValuePairs, defaultCharset);
                httpPost.setEntity(entity);
            }
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                resultString = EntityUtils.toString(entity, defaultCharset);
            }
        } catch (Exception e) {
            log.error("http post请求异常, url:" + url, e);
        } finally {
            closeResponse(response);
        }
        return resultString;
    }

    /**
     * @param url
     * @param json
     * @return
     */
    public static String doPostByJson(String url, String json) {
        CloseableHttpClient httpClient = getHttpClient();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            HttpPost httpPost = new HttpPost(url);
            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);
            response = httpClient.execute(httpPost);
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                resultString = EntityUtils.toString(responseEntity, defaultCharset);
            }
        } catch (Exception e) {
            log.error("http post请求异常, url:" + url, e);
        } finally {
            closeResponse(response);
        }
        return resultString;
    }

    private static void closeResponse(CloseableHttpResponse response) {
        try {
            if (response != null) {
                response.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static CloseableHttpClient getHttpClient() {
        if (null == httpClient) {
            synchronized (HttpClientUtil.class) {
                if (null == httpClient) {
                    init();
                }
            }
        }
        return httpClient;
    }

    private static void init() {
        //配置同时支持http和https
        ConnectionSocketFactory plainSf = PlainConnectionSocketFactory.getSocketFactory();
        LayeredConnectionSocketFactory sslSf = SSLConnectionSocketFactory.getSocketFactory();
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", plainSf).register("https", sslSf).build();
        //初始化连接管理器
        PoolingHttpClientConnectionManager poolConnManager = new PoolingHttpClientConnectionManager(registry);
        //最大连接数
        poolConnManager.setMaxTotal(maxTotal);
        //每个路由基础的连接
        poolConnManager.setDefaultMaxPerRoute(maxPerRoute);
        //请求重试处理
        HttpRequestRetryHandler httpRequestRetryHandler = (exception, executionCount, context) -> {
            if (executionCount >= defaultRetryCount) {
                return false;
            }
            if (exception instanceof NoHttpResponseException) {//如果服务器丢掉了连接，那么就重试
                return true;
            }
            if (exception instanceof SSLHandshakeException) {//不要重试SSL握手异常
                return false;
            }
            if (exception instanceof InterruptedIOException) {//超时
                return false;
            }
            if (exception instanceof UnknownHostException) {//目标服务器不可达
                return false;
            }
            if (exception instanceof SSLException) {//SSL握手异常
                return false;
            }
            HttpClientContext clientContext = HttpClientContext.adapt(context);
            HttpRequest request = clientContext.getRequest();
            //如果请求是幂等的，就再次尝试
            return !(request instanceof HttpEntityEnclosingRequest);
        };

        //请求器的配置
        RequestConfig requestConfig = RequestConfig.custom()
                //建立链接超时时间,ms毫秒
                .setConnectTimeout(connectTimeout)
                //读取超时时间,ms毫秒
                .setSocketTimeout(socketTimeout)
                //从池中获取链接超时时间,ms毫秒
                .setConnectionRequestTimeout(connectionRequestTimeout)
                //关闭自动重定向
                .setRedirectsEnabled(false)
                .build();
        httpClient = HttpClients.custom()
                //设置连接池管理
                .setConnectionManager(poolConnManager)
                //设置请求配置
                .setDefaultRequestConfig(requestConfig)
                //设置重试
                .setRetryHandler(httpRequestRetryHandler)
                .build();
    }

}
