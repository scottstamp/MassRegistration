package com.hypermine.habbo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "proxies")
public class ProxyList {
    @XmlElement(name = "proxy")
    private List<Proxy> proxyList = new ArrayList<>();
    public List<Proxy> getProxies() { return proxyList; }
    public void setProxies(List<Proxy> proxyList) { this.proxyList = proxyList; }
}
