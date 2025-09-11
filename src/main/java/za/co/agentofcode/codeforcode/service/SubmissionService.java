package za.co.agentofcode.codeforcode.service;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import za.co.agentofcode.codeforcode.repository.SubmissionRepository;

@Service
public class SubmissionService {
    private SubmissionRepository submissionRepository;

    public SubmissionService(SubmissionRepository submissionRepository) {
        this.submissionRepository = submissionRepository;
    }
}
