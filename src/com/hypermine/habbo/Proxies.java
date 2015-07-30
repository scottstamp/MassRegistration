package com.hypermine.habbo;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.util.List;

public class Proxies {
    public static List<Proxy> getProxies() {
        return getProxies(false, "");
    }

    public static List<Proxy> getProxies(Boolean filterType, String type) {
        try {
            JAXBContext jc = JAXBContext.newInstance(ProxyList.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            StreamSource src = new StreamSource(new File("/Users/scott/Documents/proxies.xml"));
            return ((ProxyList) unmarshaller.unmarshal(src)).getProxies();
        } catch (Throwable e) {
            return null;
        }
    }
}
