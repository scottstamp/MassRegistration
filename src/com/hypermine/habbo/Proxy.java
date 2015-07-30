package com.hypermine.habbo;

import org.apache.http.HttpHost;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "ip",
        "port",
        "type",
        "anonymity",
        "country"
})
public class Proxy {
    public String ip;
    public int port;
    public String type;
    public String anonymity;
    public String country;

    public HttpHost getHttpHost() {
        if (type.equals("HTTP"))
            return new HttpHost(ip, port);
        else
            return new HttpHost(ip, port);
    }
}
