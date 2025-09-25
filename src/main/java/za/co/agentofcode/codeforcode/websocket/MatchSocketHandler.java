package za.co.agentofcode.codeforcode.websocket;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MatchSocketHandler {
    private final SimpMessagingTemplate messagingTemplate;

//    public void broadcastToMatch(String matchId, Object payload) {
//        messagingTemplate.convertAndSend("/topic/match/" + matchId, new MatchEvent("EVENT", payload));
//    }
//
//    @Data
//    @AllArgsConstructor
//    public static class MatchEvent {
//        private String type;
//        private Object data;
//    }

//    private final SimpMessagingTemplate messagingTemplate;

    /**
     * Broadcast an event to every WebSocket client subscribed to /topic/match/{matchId}.
     *
     * @param matchId  The unique match identifier.
     * @param payload  Any object you want to send (will be converted to JSON).
     */
    public void broadcastToMatch(String matchId, Object payload) {
        MatchEvent event = new MatchEvent("BROADCAST", payload);
        // /topic/match/{matchId} must match what the frontend subscribes to.
        messagingTemplate.convertAndSend("/topic/match/" + matchId, event);
    }

    @Data
    @AllArgsConstructor
    public static class MatchEvent {
        private String type;   // e.g. STARTED, UPDATED, RESULT
        private Object data;   // arbitrary data (map, DTO, string, etc.)
    }
}

