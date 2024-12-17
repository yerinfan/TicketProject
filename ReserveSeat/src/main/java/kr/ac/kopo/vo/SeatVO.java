package kr.ac.kopo.vo;

public class SeatVO {

    private int seatId;       // 좌석 고유 ID
    private int roomId;       // 강의실 ID
    private int rowNumber;    // 좌석의 행 번호
    private int columnNumber; // 좌석의 열 번호
    private String status;    // 좌석 상태 (available, reserved, broken)
    private String seatKey;   // 좌석 고유 키 (예: "1-1")

    // Getters and Setters

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSeatKey() {
        return seatKey;
    }

    public void setSeatKey(String seatKey) {
        this.seatKey = seatKey;
    }

    @Override
    public String toString() {
        return "SeatVO{" +
                "seatId=" + seatId +
                ", roomId=" + roomId +
                ", rowNumber=" + rowNumber +
                ", columnNumber=" + columnNumber +
                ", status='" + status + '\'' +
                ", seatKey='" + seatKey + '\'' +
                '}';
    }
}
