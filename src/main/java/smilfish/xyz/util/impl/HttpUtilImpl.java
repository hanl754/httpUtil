package smilfish.xyz.util.impl;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.DefaultedHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.springframework.stereotype.Service;
import smilfish.xyz.util.HttpUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by hanliang1 on 2015/12/4.
 */
@Service("httpUtil")
public class HttpUtilImpl implements HttpUtil {
    private final HttpClient httpClient = new DefaultHttpClient();

    public String get(String baseUrl, Map<String, String> params) {
        String response = null;
        String url = buildUrl(baseUrl, params);
        HttpGet httpGet = new HttpGet(url);
        //设置请求头
//        httpGet.setHeader("", "");
        try {
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            response = httpClient.execute(httpGet, responseHandler);
        } catch (Exception e) {
            System.out.println("--->调用httpClient get获取信息出错.");
            e.printStackTrace();
        }
        return response;
    }

    public String post(String baseUrl, Map<String, String> params) {
        String response = null;
        HttpPost httpPost = new HttpPost(baseUrl);
        //设置请求头
        httpPost.setHeader("", "");
        //设置参数
        List<NameValuePair> nameValuePairList = new ArrayList<NameValuePair>();
        for(Map.Entry<String, String> entry:params.entrySet()) {
            nameValuePairList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        //ISO-8859-1
        httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairList, HTTP.DEF_CONTENT_CHARSET));
        try {
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            response = httpClient.execute(httpPost, responseHandler);
        } catch (Exception e) {
            System.out.println("--->调用httpClient post获取信息出错.");
            e.printStackTrace();
        }
        return response;
    }

    /**
     * 构建url
     * @param baseUrl
     * @param params
     * @return
     */
    private String buildUrl(String baseUrl, Map<String, String> params) {
        String url = baseUrl + "?";
        for(Map.Entry<String, String> entry : params.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            String param = key + "=" + value + "&";
            url+=param;
        }
        return url.substring(0, url.length()-1);
    }
}
