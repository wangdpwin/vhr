package org.sang.service;

import com.alibaba.fastjson.JSONArray;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.sang.imserver.CheckSumBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IMServer {

  private DefaultHttpClient httpClient;

  private static final String APPKEY = "8531bb68eaa593798b23615d11f14fc3";
  private static final String APPSECRET = "680c0ccdd9f4";
  private static final String BATHPATH = "https://api.netease.im/nimserver";

  public void createUser() throws Exception {
    DefaultHttpClient httpClient = new DefaultHttpClient();
    String url = BATHPATH + "/user/create.action";
    HttpPost httpPost = new HttpPost(url);

    String appSecret = "680c0ccdd9f4";
    String nonce = "12345";
    String curTime = String.valueOf((new Date()).getTime() / 1000L);
    String checkSum =
        CheckSumBuilder.getCheckSum(appSecret, nonce, curTime); // 参考 计算CheckSum的java代码

    // 设置请求的header
    httpPost.addHeader("AppKey", APPKEY);
    httpPost.addHeader("Nonce", nonce);
    httpPost.addHeader("CurTime", curTime);
    httpPost.addHeader("CheckSum", checkSum);
    httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

    // 设置请求的参数
    List<NameValuePair> nvps = new ArrayList<NameValuePair>();
    nvps.add(new BasicNameValuePair("accid", "helloworld"));

    httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
    // 执行请求
    HttpResponse response = httpClient.execute(httpPost);
    // token   6e9a958de19bdb328b3c76c313fcdc27
    // 打印执行结果
    System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
  }

  public void getUserInfo() throws Exception {
    DefaultHttpClient httpClient = new DefaultHttpClient();
    String url = BATHPATH + "/user/getUinfos.action";
    HttpPost httpPost = new HttpPost(url);

    String appSecret = "680c0ccdd9f4";
    String nonce = "12345";
    String curTime = String.valueOf((new Date()).getTime() / 1000L);
    String checkSum =
        CheckSumBuilder.getCheckSum(appSecret, nonce, curTime); // 参考 计算CheckSum的java代码

    // 设置请求的header
    httpPost.addHeader("AppKey", APPKEY);
    httpPost.addHeader("Nonce", nonce);
    httpPost.addHeader("CurTime", curTime);
    httpPost.addHeader("CheckSum", checkSum);
    httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

    // 设置请求的参数
    List<NameValuePair> nvps = new ArrayList<NameValuePair>();
    JSONArray jsonArray = new JSONArray();
    jsonArray.add("helloworld");

    nvps.add(new BasicNameValuePair("accids", jsonArray.toJSONString()));
    httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
    // 执行请求
    HttpResponse response = httpClient.execute(httpPost);
    // token   6e9a958de19bdb328b3c76c313fcdc27
    // 打印执行结果
    System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
  }

}
