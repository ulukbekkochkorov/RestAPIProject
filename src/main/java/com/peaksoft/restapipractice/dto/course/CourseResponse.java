package com.peaksoft.restapipractice.dto.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

public class CourseResponse {
    private Long id;
    private String courseName;
    private String duration;
    private String description;
}
