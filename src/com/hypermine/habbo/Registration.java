package com.hypermine.habbo;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.util.EntityUtils;
import java.util.concurrent.Callable;

public class Registration implements Callable<String> {
    private final Proxy proxy;

    public Registration(Proxy proxy) {
        this.proxy = proxy;
    }

    @Override
    public String call() {
        try {
            DefaultProxyRoutePlanner routePlanner = new DefaultProxyRoutePlanner(proxy.getHttpHost());
            CloseableHttpClient httpClient = HttpClients.custom()
                    .setRoutePlanner(routePlanner)
                    .setRetryHandler(new DefaultHttpRequestRetryHandler(0, false))
                    .build();

            HttpGet httpGet = new HttpGet("http://ipchicken.com");
            CloseableHttpResponse response = httpClient.execute(httpGet);

            try {
                System.out.println(response.getStatusLine());
                HttpEntity entity = response.getEntity();
                EntityUtils.consume(entity);
            } finally {
                response.close();
            }
        } catch (Throwable e) {

        }

        return null;
    }
}
