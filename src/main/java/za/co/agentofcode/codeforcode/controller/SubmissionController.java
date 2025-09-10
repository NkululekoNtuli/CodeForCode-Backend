package za.co.agentofcode.codeforcode.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.agentofcode.codeforcode.service.SubmissionService;

@RestController
public class SubmissionController {
    private SubmissionService submissionService;

    public SubmissionController( SubmissionService submissionService ) {
        this.submissionService = submissionService;
    }

    @RequestMapping("/submit")
    public String submit() {
        return "submission";
    }
}
