package com.itkaptein.sample;

import java.util.Collections;

import org.apache.catalina.Context;
import org.apache.tomcat.util.descriptor.web.JspConfigDescriptorImpl;
import org.apache.tomcat.util.descriptor.web.JspPropertyGroup;
import org.apache.tomcat.util.descriptor.web.JspPropertyGroupDescriptorImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MacroSampleMaven1Application {

	public static void main(String[] args) {
		SpringApplication.run(MacroSampleMaven1Application.class, args);
	}

	
	@Bean 
    public ConfigurableServletWebServerFactory configurableServletWebServerFactory ( ) { 
        return new TomcatServletWebServerFactory() { 
            @Override 
            protected void postProcessContext(Context context) {
                super.postProcessContext(context); 
                

            	context.addWelcomeFile("/index.jsp");
            	
                JspPropertyGroup jspPropertyGroup = new JspPropertyGroup(); 
                jspPropertyGroup.addUrlPattern("*.jsp");
//                jspPropertyGroup.addUrlPattern("*.jspf");
                jspPropertyGroup.setPageEncoding("UTF-8");
//                jspPropertyGroup.setScriptingInvalid("true");
//                jspPropertyGroup.addIncludePrelude("/WEB-INF/jsp/base.jspf");
//                jspPropertyGroup.setTrimWhitespace("true");
                jspPropertyGroup.setDefaultContentType("text/html"); 
                JspPropertyGroupDescriptorImpl jspPropertyGroupDescriptor = new JspPropertyGroupDescriptorImpl(jspPropertyGroup); 
                context.setJspConfigDescriptor(new JspConfigDescriptorImpl(Collections.singletonList(jspPropertyGroupDescriptor), Collections.emptyList())); 
            } 
        }; 
    }
}
