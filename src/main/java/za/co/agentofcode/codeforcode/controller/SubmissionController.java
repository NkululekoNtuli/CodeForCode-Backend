package za.co.agentofcode.codeforcode.controller;

import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.co.agentofcode.codeforcode.model.Matches;
import za.co.agentofcode.codeforcode.model.Users;
import za.co.agentofcode.codeforcode.service.SubmissionService;

import java.time.Instant;
import java.util.Map;

import io.github.cdimascio.dotenv.Dotenv;

@RestController
public class SubmissionController {
    private SubmissionService submissionService;


    public SubmissionController( SubmissionService submissionService ) {
        this.submissionService = submissionService;
    }

    @RequestMapping("/submit-code") // using post request for large code submissions
    public String submit(@RequestBody Map<String, Object> data) {


        Matches match = (Matches) data.get("match");
        Users user = (Users) data.get("user");
        String lang = data.get("programmingLanguage").toString();
        String code = data.get("code").toString();
        boolean verdict = (boolean) data.get("verdict");
        int runtimeMs = (Integer) data.get("runtimeMs");
        int memoryKb = (Integer) data.get("memorykb");
        int ingenuity = (Integer) data.get("ingenuity");
        int score = (Integer) data.get("score");
        Instant subTime = (Instant) data.get("submissionTime");

        submissionService.creatSubmission(match, user, lang, code, verdict, runtimeMs, memoryKb, ingenuity, score, subTime);

        return "submission";
    }


    @RequestMapping(value = "submit", method = RequestMethod.POST)
    public String sourceCode(@RequestBody Map<String, String> data){

        String lang = data.get("language_id");
        String code = data.get("source_code");
        String input = data.get("stdin");

        System.out.println("language: "+ lang +"\nsource code: "+ code);
        JSONObject response = submissionService.executeCodeSubmission(lang, code, input);
        return String.valueOf(submissionService.getData(response.get("token").toString()));
    }
}
