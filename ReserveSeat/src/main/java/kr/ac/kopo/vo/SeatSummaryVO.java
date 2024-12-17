package kr.ac.kopo.vo;

public class SeatSummaryVO {
    private int roomId;
    private String className;
    private int totalSeats;
    private int remainingSeats;

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getRemainingSeats() {
        return remainingSeats;
    }

    public void setRemainingSeats(int remainingSeats) {
        this.remainingSeats = remainingSeats;
    }

    @Override
    public String toString() {
        return "SeatSummaryVO{" +
                "roomId=" + roomId +
                ", className='" + className + '\'' +
                ", totalSeats=" + totalSeats +
                ", remainingSeats=" + remainingSeats +
                '}';
    }
}
