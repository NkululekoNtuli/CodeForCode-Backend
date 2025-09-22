package za.co.agentofcode.codeforcode.websocket;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MatchSocketHandler {
    private final SimpMessagingTemplate messagingTemplate;

    public void broadcastToMatch(String matchId, Object payload) {
        messagingTemplate.convertAndSend("/topic/match/" + matchId, new MatchEvent("EVENT", payload));
    }

    @Data
    @AllArgsConstructor
    public static class MatchEvent {
        private String type;
        private Object data;
    }
}

