package io.github.ycoulon.springbootcxftest.configuration;

import javax.xml.ws.Endpoint;

import de.codecentric.namespace.weatherservice.Weather;
import de.codecentric.namespace.weatherservice.WeatherService;
import io.github.ycoulon.springbootcxftest.endpoint.WeatherServiceEndpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebServiceConfiguration {
    @Autowired
    private Bus bus;

    @Bean
    public WeatherService weatherService() {
        return new WeatherServiceEndpoint();
    }

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, weatherService());
        // CXF JAX-WS implementation relies on the correct ServiceName as QName-Object with
        // the name-Attribute´s text <wsdl:service name="Weather"> and the targetNamespace
        // "http://www.codecentric.de/namespace/weatherservice/"
        // Also the WSDLLocation must be set
        endpoint.setServiceName(weather().getServiceName());
        endpoint.setWsdlLocation(weather().getWSDLDocumentLocation().toString());
        endpoint.publish("/WeatherSoapService_1.0");
        return endpoint;
    }

    @Bean
    public Weather weather() {
        // Needed for correct ServiceName & WSDLLocation to publish contract first incl. original WSDL
        return new Weather();
    }
}