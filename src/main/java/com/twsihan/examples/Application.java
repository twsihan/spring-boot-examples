package com.twsihan.examples;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class Application implements CommandLineRunner
{
    private static Logger logger = LogManager.getLogger(Application.class);


    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args)
    {
        logger.info("服务启动完成！！！");
    }

    @RequestMapping("/")
    public String index()
    {
        return "redirect:countries";
    }
}
