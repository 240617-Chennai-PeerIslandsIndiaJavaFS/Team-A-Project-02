package org.revature.springboot.controller;

import org.revature.springboot.model.TaskCompletionReport;
import org.revature.springboot.model.UserActivityReport;
import org.revature.springboot.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping("/user-activity")
    public ResponseEntity<List<UserActivityReport>> getUserActivityReport() {
        List<UserActivityReport> report = reportService.getUserActivityReport();
        return new ResponseEntity<>(report, HttpStatus.OK);
    }

    @GetMapping("/task-completion")
    public ResponseEntity<List<TaskCompletionReport>> getTaskCompletionReport() {
        List<TaskCompletionReport> report = reportService.getTaskCompletionReport();
        return new ResponseEntity<>(report, HttpStatus.OK);
    }

}

