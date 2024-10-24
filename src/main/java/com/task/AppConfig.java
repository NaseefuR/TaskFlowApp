package com.task;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class AppConfig {
	
	@Autowired
	private Environment env;
	
	@Bean(name="javaMailSender")
	public JavaMailSender getJavaMailSender() {
		
		JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
		javaMailSenderImpl.setHost(env.getProperty("mail.host"));
		javaMailSenderImpl.setUsername(env.getProperty("mail.username"));
		javaMailSenderImpl.setPassword(env.getProperty("mail.password"));
		javaMailSenderImpl.setPort(getIntProperty("mail.port"));
		
		javaMailSenderImpl.setJavaMailProperties(getProperties());
		
		return javaMailSenderImpl;
	}
	
	
	int getIntProperty(String key) {
		
		String property = env.getProperty(key);
		return Integer.parseInt(property);
		
	}
	
	private Properties getProperties() {
		Properties mailProperties = new Properties();
		mailProperties.put("mail.smtp.starttls.enable", true);
		mailProperties.put("mail.smtp.ssl.trust","smtp.gmail.com");
		return mailProperties;
	}
	
	
}
