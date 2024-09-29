package com.amine.gateway.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.amine.gateway.config.UserRestClient;
import com.amine.gateway.util.JwtUtil;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

    @Autowired
    private RouteValidator validator;

    @Autowired
    private RestTemplate template;
    
    
    private UserRestClient userRestClient;
    @Autowired
    private JwtUtil jwtUtil;

    public AuthenticationFilter() {
		super(Config.class);
		
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            if (validator.isSecured.test(exchange.getRequest())) {
                //header contains token or not
            	if(exchange.getRequest().getHeaders().containsKey("Admin")) return  chain.filter(exchange) ;
                if (!exchange.getRequest().getHeaders().containsKey("token")) {
                    throw new RuntimeException("missing authorization header");
                }

                String authHeader = exchange.getRequest().getHeaders().get("token").get(0);
                System.out.println(authHeader+" 7");
                if (authHeader != null && authHeader.startsWith("Bearer ")) {
                    authHeader = authHeader.substring(7);
                }
                try {
                    jwtUtil.validateToken(authHeader);
                	//template.getForObject("http://localhost:8080//validate1?token="+authHeader, String.class);
                	//userRestClient.ValidateToken(authHeader);
                	
                } catch (Exception e) {
                    System.out.println("invalid access...!");
                    throw new RuntimeException("un authorized access to application");
                }
            }
            return chain.filter(exchange);
        });
    }

    public static class Config {

    }
}