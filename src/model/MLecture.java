package model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class MLecture {
    private int lectureId;
    private int deptId;
    private String title;
    private String professor;
    private int credits;
    private int capacity;
    private int enrolledCount;
    private int basketCount;
    private List<Schedule> schedules = new ArrayList<>();

    public static class Schedule {
        private String dayOfWeek;
        private LocalTime startTime;
        private LocalTime endTime;

        public Schedule(String dayOfWeek, LocalTime startTime, LocalTime endTime) {
            this.dayOfWeek = dayOfWeek;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public String getDayOfWeek() { return dayOfWeek; }
        public LocalTime getStartTime() { return startTime; }
        public LocalTime getEndTime() { return endTime; }

        public boolean isOverlapping(Schedule other) {
            if (!this.dayOfWeek.equals(other.dayOfWeek)) {
                return false;
            }
            return this.startTime.isBefore(other.endTime) && other.startTime.isBefore(this.endTime);
        }
    }

    public MLecture(int lectureId, int deptId, String title, String professor, int credits, int capacity) {
        this.lectureId = lectureId;
        this.deptId = deptId;
        this.title = title;
        this.professor = professor;
        this.credits = credits;
        this.capacity = capacity;
        this.schedules = new ArrayList<>();
    }

    public void addSchedule(String dayOfWeek, LocalTime startTime, LocalTime endTime) {
        schedules.add(new Schedule(dayOfWeek, startTime, endTime));
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public boolean isOverlapping(MLecture other) {
        for (Schedule s1 : this.schedules) {
            for (Schedule s2 : other.schedules) {
                if (s1.isOverlapping(s2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getLectureId() { return lectureId; }
    public int getDeptId() { return deptId; }
    public String getTitle() { return title; }
    public String getProfessor() { return professor; }
    public int getCredits() { return credits; }
    public int getCapacity() { return capacity; }
    
    public int getEnrolledCount() { return enrolledCount; }
    public void setEnrolledCount(int enrolledCount) { this.enrolledCount = enrolledCount; }
    
    public int getBasketCount() { return basketCount; }
    public void setBasketCount(int basketCount) { this.basketCount = basketCount; }
}
