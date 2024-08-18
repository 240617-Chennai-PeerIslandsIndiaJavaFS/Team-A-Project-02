package org.revature.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "UserActivityReport")
public class UserActivityReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userName;
    private String activity;
}
