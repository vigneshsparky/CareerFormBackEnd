package com.career;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfiguration {
    @Bean
    JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com"); // Set your SMTP server (e.g., Gmail)
        mailSender.setPort(587); // Set the port (587 for TLS)
        mailSender.setUsername("vigneshwaran2020win@gmail.com"); // Set your email address
        mailSender.setPassword("ijpbjulsnsonxdgs"); // Set your email password

        // Additional properties (if needed)
        // mailSender.getJavaMailProperties().put("mail.smtp.auth", "true");
        // mailSender.getJavaMailProperties().put("mail.smtp.starttls.enable", "true");  
     // Additional properties (if needed)
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); 
        return mailSender;
    }
}
