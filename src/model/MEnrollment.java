package model;

import java.time.LocalDateTime;

public class MEnrollment {
    private int studentId;
    private int lectureId;
    private LocalDateTime enrolledAt;

    public MEnrollment(int studentId, int lectureId, LocalDateTime enrolledAt) {
        this.studentId = studentId;
        this.lectureId = lectureId;
        this.enrolledAt = enrolledAt;
    }
}
