package bitlab.techorda.springboot.Sprinttask2.Models;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "app_requests")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="username")
    private String userName;

    @Column(name="course_name")
    private String courseName;

    @Column(name="commentary")
    private String commentary;

    @Column(name="phone")
    private String phone;

    @Column(name="handled")
    private boolean handled;
}
