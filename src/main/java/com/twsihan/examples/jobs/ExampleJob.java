package com.twsihan.examples.jobs;

import com.twsihan.examples.entities.mongodb.Example;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class ExampleJob extends QuartzJobBean
{
    private static Logger logger = LogManager.getLogger(ExampleJob.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    protected void executeInternal(JobExecutionContext var1)
    {
        try {
            logger.info("hello job");
            Example example = new Example();
            example.setName("springboot-examples-val");
            mongoTemplate.save(example);
            stringRedisTemplate.opsForValue().set("springboot-examples-key", mongoTemplate.findAll(Example.class).toString());
            logger.info(stringRedisTemplate.opsForValue().get("springboot-examples-key"));
        } catch (Exception e) {
            logger.error("job fail: " + e);
        }
    }
}
