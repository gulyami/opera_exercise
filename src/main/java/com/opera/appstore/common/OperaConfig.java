package com.opera.appstore.common;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.opera.appstore.common.StaticData.BrowserType;

/**
 * Created with IntelliJ IDEA.
 * User: IGulyam
 * Date: 29.07.14
 * Time: 13:44
 * To change this template use File | Settings | File Templates.
 */
@Component
public class OperaConfig {

    private static final Logger logger = Logger.getLogger(OperaConfig.class);
    private BrowserType browser;
    private String fireFoxBrowserPath;
    private String images;
    private String url;
    private String thumbNails;
    private String apkPath;
    private String password;
    private String login;

    @Autowired
    public OperaConfig(@Value("#{environment['browser'] }") String browser,
                       @Value("#{properties['ff.browser.path']}") String browserPath,
                       @Value("#{properties['img.path']}") String images,
                       @Value("#{properties['app.url']}") String url,
                       @Value("#{properties['apk.path']}") String apkPath,
                       @Value("#{properties['thumb.path']}") String thumbNails,
                       @Value("#{properties['password']}") String password,
                       @Value("#{properties['login']}") String login
    ) {
        this.browser = BrowserType.valueOf(browser);
        this.fireFoxBrowserPath = browserPath;
        this.images = images;
        this.url = url;
        this.thumbNails = thumbNails;
        this.apkPath = apkPath;
        this.password = password;
        this.login = login;
    }

    public BrowserType getBrowser() {
        return browser;
    }

    public String getFireFoxBrowserPath() {
        return fireFoxBrowserPath;
    }

    public String getImages() {
        return images;
    }

    public String getUrl() {
        return url;
    }

    public String getThumbNails() {
        return thumbNails;
    }

    public String getApkPath() {
        return apkPath;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }
}
