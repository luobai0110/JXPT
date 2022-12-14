package edu.cuit.jxpt2.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper = true)
public class TClass2 extends TClass {
    private Integer tClassId;
    private Integer teacherId;
    private Integer CourseId;
    private String tClassName;
    private Integer classId;
    private String teacherName;
    private String courseName;
    private String majorName;

}
