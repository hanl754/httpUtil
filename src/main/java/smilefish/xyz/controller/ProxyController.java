package smilefish.xyz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import smilefish.xyz.util.HttpUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hanliang1 on 2015/12/7.
 */
@Controller
@RequestMapping(value="/proxy")
public class ProxyController {
    private HttpUtil httpUtil;

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseBody
    public Object doPost(@RequestParam String baseUrl, @RequestParam String params, @RequestParam String extras) {

        return null;
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ResponseBody
    public Object doGet(@RequestParam String baseUrl, @RequestParam String params, @RequestParam String extras) {

        return null;
    }

    private Map<String, String> parseParams(String params) {
        Map<String, String> result = new HashMap<String, String>();
        String[] paramsArr = params.split("\\r\\n");
        for(int i=0; i<paramsArr.length; i++) {
            String paramLine = paramsArr[i].trim();

        }
        return result;
    }

    public void setHttpUtil(HttpUtil httpUtil) {
        this.httpUtil = httpUtil;
    }
}
