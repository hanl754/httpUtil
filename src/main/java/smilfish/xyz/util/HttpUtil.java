package smilfish.xyz.util;

import java.util.Map;

/**
 * Created by hanliang1 on 2015/12/4.
 */
public interface HttpUtil {

    /**
     * get方式请求
     * @param baseUrl baseUrl
     * @param params 参数
     * @return
     */
    String get(String baseUrl, Map<String, String> params);

    /**
     * post 方式请求
     * @param baseUrl
     * @param params
     * @return
     */
    String post(String baseUrl, Map<String, String> params);
}
