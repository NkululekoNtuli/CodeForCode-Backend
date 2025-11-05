package za.co.agentofcode.codeforcode.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic", "/queue");
        config.setApplicationDestinationPrefixes("/app");
    }

//    @Override
//    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        // For dev you can allow all origins. Later lock this to your frontend domain.
//        registry.addEndpoint("/ws").setAllowedOriginPatterns("*").withSockJS();
//    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) { // for frontend handshake
        registry.addEndpoint("/test/broadcast") // same path you used in frontend
                .setAllowedOrigins("http://localhost:5173")
                .withSockJS(); // enables /info, /iframe.html, etc.
    }

}

