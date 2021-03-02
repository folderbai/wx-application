package com.github.folderbai.wx.mini;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@SpringBootApplication
@Slf4j
public class WxMaApplication {

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(WxMaApplication.class, args);
        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");
        log.info(
                "\n-------------------------------------------------\n\n" +
                "\t【wx-application-mini】应用启动完成\n" +
                "\t Local: \thttp://localhost:" + port + path + "\n" +
                "\t External: \thttp://" + ip + ":" + port + path + "\n" +
                "\n-------------------------------------------------\n"
        );
    }
}
