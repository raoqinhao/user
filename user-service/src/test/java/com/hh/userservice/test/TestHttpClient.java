package com.hh.userservice.test;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class TestHttpClient {

    private static String requestPath = "http://localhost:9001/findUserInfo/1";

    @Test
    public void useHttpClient() {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse httpResponse = null;
        try {
            HttpGet httpGet = new HttpGet(requestPath);
            httpClient = HttpClients.createDefault();
            httpResponse = httpClient.execute(httpGet);
            HttpEntity entity = httpResponse.getEntity();
            System.out.println(entity);
            System.out.println();
            System.out.println(entity.toString());
            System.out.println();
            // 获取返回数据
//            String result = EntityUtils.toString(entity);
            System.out.println("----------");
            byte[] bytes = EntityUtils.toByteArray(entity);
            JSONObject jsonObject = JSONObject.parseObject(new String(bytes, "utf-8"));
            System.out.println(jsonObject.getString("id"));
            System.out.println(jsonObject.getString("username"));
            System.out.println("----------");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (httpResponse != null)
                    httpResponse.close();
                if (httpClient != null)
                    httpClient.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void useRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        Map map = restTemplate.getForObject(requestPath, Map.class);
        System.out.println(map);
        Object id = map.get("id");
        Object username = map.get("username");
        System.out.println(id);
        System.out.println(username);
    }


    @Test
    public void useHttpURLConnection() {
        // JDK自带的请求
        HttpURLConnection connection = null;
        BufferedReader bufferedReader = null;
        InputStream inputStream = null;
        StringBuffer result = new StringBuffer();
        try {
            URL url = new URL(requestPath);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(10000);
            connection.connect();
            if (connection.getResponseCode() == 200) {
                inputStream = connection.getInputStream();
                if (inputStream != null) {
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                    String line = null;
                    while ((line = bufferedReader.readLine()) != null) {
                        result.append(line);
                    }
                }
            }

            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //关闭远程连接
            if (connection != null)
                connection.disconnect();
        }
    }


}
