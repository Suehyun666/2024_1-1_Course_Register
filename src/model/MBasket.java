package model;

import java.time.LocalDateTime;

public class MBasket {
    private int studentId;
    private int lectureId;
    private LocalDateTime createdAt;

    public MBasket(int studentId, int lectureId, LocalDateTime createdAt) {
        this.studentId = studentId;
        this.lectureId = lectureId;
        this.createdAt = createdAt;
    }
}
