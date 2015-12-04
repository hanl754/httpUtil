package smilefish.sxy.test;

import org.junit.Assert;
import org.junit.Test;
import smilefish.xyz.util.HttpUtil;
import smilefish.xyz.util.impl.HttpUtilImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hanliang1 on 2015/12/4.
 */
public class TestHttpClient {

    private HttpUtil httpUtil = new HttpUtilImpl();

    @Test
    public void testGet() throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put("keyword", "kindle");
        String result = httpUtil.get("http://search.jd.com/Search", params);
        Assert.assertNotNull(result);
        System.out.println(result);
    }

    @Test
    public void testPost() throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put("log", "asd");
        params.put("pwd", "asd");
        String result = httpUtil.post("http://blog.com/wp-login.php", params);
        System.out.println(result);
    }

    @Test
    public void testName() throws Exception {
        System.out.println(this);
        System.out.println(TestHttpClient.class);
    }

}
