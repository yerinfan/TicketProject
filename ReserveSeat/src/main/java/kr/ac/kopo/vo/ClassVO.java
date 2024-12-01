package kr.ac.kopo.vo;

public class ClassVO {

    private String seatNo;     // 좌석 번호
    private String classNo;    // 강의실 번호
    private String regTime;    // 예약 시간대
    private int seatRow;       // 좌석 행
    private int seatCol;       // 좌석 열
    private String isEmpty;    // 좌석 선점 여부 (Y/N)
    private String classType;  // 강의실 구조

    // 기본 생성자
    public ClassVO() {
    }

    // 생성자
    public ClassVO(String classNo, String regTime) {
        this.classNo = classNo;
        this.regTime = regTime;
    }

    // Getter & Setter
    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    public int getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(int seatRow) {
        this.seatRow = seatRow;
    }

    public int getSeatCol() {
        return seatCol;
    }

    public void setSeatCol(int seatCol) {
        this.seatCol = seatCol;
    }

    public String getIsEmpty() {
        return isEmpty;
    }

    public void setIsEmpty(String isEmpty) {
        this.isEmpty = isEmpty;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

	@Override
	public String toString() {
		return "ClassVO [seatNo=" + seatNo + ", classNo=" + classNo + ", regTime=" + regTime + ", seatRow=" + seatRow
				+ ", seatCol=" + seatCol + ", isEmpty=" + isEmpty + ", classType=" + classType + "]";
	}
}
