package com.peaksoft.restapipractice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;


@Entity
@Table(name = "groups")
@Getter
@Setter
@NoArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "group_seq")
    @SequenceGenerator(name = "group_seq", sequenceName = "group_seq", allocationSize = 1)
    private Long id;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "date_of_start")
    private LocalDate dateOfStart;

    @Column
    private String image;

    @ManyToMany(cascade = {DETACH, MERGE, REFRESH},
            fetch = FetchType.LAZY,mappedBy = "groups")
    private List<Course> courses;
    public void addCourse(Course course){
        if (courses == null){
            courses = new ArrayList<>();
        }
        courses.add(course);
    }

    @OneToMany(cascade = {DETACH, MERGE, REFRESH, PERSIST},fetch = FetchType.LAZY, mappedBy = "group")
    private List<Student>students;

    public void addStudent(Student student){
        if (students == null){
            students = new ArrayList<>();
        }
        students.add(student);
        courses.get(0).getCompany().plusStudent();
    }

    public void assignStudent(Student student){
        if (students == null){
            students = new ArrayList<>();
        }
        students.add(student);
    }


}
