package org.revature.springboot.service;

import org.revature.springboot.dao.TaskRepository;
import org.revature.springboot.dao.UserRepository;
import org.revature.springboot.model.TaskCompletionReport;
import org.revature.springboot.model.UserActivityReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskRepository taskRepository;

    public List<UserActivityReport> getUserActivityReport() {
        // Implement logic to generate user activity report
        return new ArrayList<>();
    }

    public List<TaskCompletionReport> getTaskCompletionReport() {
        // Implement logic to generate task completion report
        return new ArrayList<>();
    }
}

