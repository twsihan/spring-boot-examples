package com.twsihan.examples.configuration;

import com.twsihan.examples.jobs.ExampleJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobConfiguration
{
    private static final String EXAMPLE_JOB_NAME = "example";


    @Bean
    public JobDetail exampleJobDetail()
    {
        return JobBuilder.newJob(ExampleJob.class).withIdentity(EXAMPLE_JOB_NAME).storeDurably().build();
    }

    @Bean
    public Trigger exampleJobTrigger()
    {
        return TriggerBuilder.newTrigger()
            .forJob(exampleJobDetail())
            .withIdentity(EXAMPLE_JOB_NAME)
            .withSchedule(CronScheduleBuilder.cronSchedule("*/5 * * * * ?"))
            .build();
    }

   // @Bean(name = "exampleJobDetail")
   // webStatic JobDetailFactoryBean uploadJobDetail()
   // {
   //     JobDetailFactoryBean jobDetail = new JobDetailFactoryBean();
   //     jobDetail.setDurability(true);
   //     jobDetail.setJobClass(ExampleJob.class);
   //     return jobDetail;
   // }
   //
   // @Bean(name = "exampleJobTrigger")
   // webStatic CronTriggerFactoryBean updateTriggerFactoryBean(JobDetail exampleJobDetail)
   // {
   //     CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
   //     trigger.setCronExpression("0/5 * * * * ?");
   //     trigger.setJobDetail(exampleJobDetail);
   //     return trigger;
   // }
}
