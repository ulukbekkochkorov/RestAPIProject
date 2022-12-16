package com.peaksoft.restapipractice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "lessons")
@Getter
@Setter
@NoArgsConstructor
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lesson_seq")
@SequenceGenerator(name = "lesson_seq", sequenceName = "lesson_seq", allocationSize = 1)
    private Long id;

    @Column
    private String lessonName;

    @ManyToOne(cascade = {MERGE,DETACH,PERSIST,REFRESH}, fetch = FetchType.EAGER)
    private Course course;

    @OneToMany(cascade = {ALL}, fetch = FetchType.LAZY, mappedBy = "lesson")
    private List<Task> tasks;
    public void addTask(Task task){
        if (tasks == null){
            tasks = new ArrayList<>();
        }
        tasks.add(task);
    }

}
