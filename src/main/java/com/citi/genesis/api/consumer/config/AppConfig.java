package com.citi.genesis.api.consumer.config;

import com.citi.genesis.api.consumer.factory.MessageProcessorsFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Autowired
  private BeanFactory beanFactory;

  public ServiceLocatorFactoryBean serviceLocatorFactoryBean() {
    final ServiceLocatorFactoryBean locatorFactoryBean = new ServiceLocatorFactoryBean();
    locatorFactoryBean.setBeanFactory(beanFactory);
    locatorFactoryBean.setServiceLocatorInterface(MessageProcessorsFactory.class);
    return locatorFactoryBean;
  }

  @Bean
  public MessageProcessorsFactory messageProcessorsFactory() {
    final ServiceLocatorFactoryBean locatorFactoryBean = serviceLocatorFactoryBean();
    locatorFactoryBean.afterPropertiesSet();
    return (MessageProcessorsFactory)locatorFactoryBean.getObject();
  }
}
