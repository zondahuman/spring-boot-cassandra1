package com.abin.lee.spring.cassandra.batch.test;

import com.abin.lee.spring.cassandra.common.util.HttpClientUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by abin on 2018/2/5 17:04.
 * spring-boot-cassandra1
 * com.abin.lee.spring.cassandra.batch.test
 */
public class BatchLibraryAddTest {


    private static final String httpURL = "http://localhost:8099/cassandra/insert";
    @Test
    public void testBatch1(){
        for (int i = 0; i <1000 ; i++) {
            testAnnotationAdd();
        }
        
    }
    @Test
    public void testAnnotationAdd() {
        try {
            CloseableHttpClient httpClient = HttpClientUtil.getHttpClient();
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            nvps.add(new BasicNameValuePair("id", UUID.randomUUID().toString()));
//            String randomString = new RandomStringGenerator.Builder().build().generate(10);
//            nvps.add(new BasicNameValuePair("question", randomString));
            nvps.add(new BasicNameValuePair("question", RandomStringUtils.randomAlphabetic(5)));
            HttpPost httpPost = new HttpPost(httpURL);

            httpPost.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));
            System.out.println("Executing request: " + httpPost.getRequestLine());
            HttpResponse response = httpClient.execute(httpPost);
            System.out.println("----------------------------------------");
            System.out.println(response.getStatusLine());
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }




}
