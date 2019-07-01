package com.dxc.converter.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.ext.logging.LoggingFeature;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dxc.converter.service.PRMService;
import com.dxc.converter.service.impl.PRMServiceImpl;

/**
 * @Author yche2
 * @Date 3/22/2019 14:54
 * @Description TODO
 */
@Configuration
public class CXFConfig {

//    @Bean
//    public ServletRegistrationBean servletRegistrationBean() {
//        return new ServletRegistrationBean(new CXFServlet(), "/service/*");
//    }


	@Autowired
	private Bus cxfBus;
	
	@Bean(name = Bus.DEFAULT_BUS_ID)
	public SpringBus springBus() {
		SpringBus springBus = new SpringBus();
		LoggingFeature logFeature = new LoggingFeature();
		logFeature.setPrettyLogging(true);
		logFeature.initialize(springBus);
		springBus.getFeatures().add(logFeature);
		return springBus;
	}

    @Bean
    public PRMService prmService() {
        return new PRMServiceImpl();
    }

    @Bean
    public Endpoint endpoint2() {
        EndpointImpl endpointPrm = new EndpointImpl(springBus(), prmService());
        endpointPrm.publish("/converter/prm");
        return endpointPrm;
    }

}
