package kr.ac.kopo.vo;

public class BoardVO {
    
    private int no;              // 게시글 번호
    private String title;        // 제목
    private String writer;       // 작성자명
    private String content;      // 내용
    private String regDate;      // 작성일
    private int viewCnt;         // 조회수
    private int whoseNo;     // 부모 게시글 번호 (null 가능)

    // 기본 생성자
    public BoardVO() {}

    // 생성자
    public BoardVO(int no, String title, String writer, String content, String regDate, int viewCnt, int whoseNo) {
        this.no = no;
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.regDate = regDate;
        this.viewCnt = viewCnt;
        this.whoseNo = whoseNo;
    }

    // Getter and Setter
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public int getViewCnt() {
        return viewCnt;
    }

    public void setViewCnt(int viewCnt) {
        this.viewCnt = viewCnt;
    }

    public Integer getWhoseNo() {
        return whoseNo;
    }

    public void setWhoseNo(Integer whoseNo) {
        this.whoseNo = whoseNo;
    }

    @Override
    public String toString() {
        return "BoardVO [no=" + no + ", title=" + title + ", writer=" + writer + ", content=" + content 
               + ", regDate=" + regDate + ", viewCnt=" + viewCnt + ", whoseNo=" + whoseNo + "]";
    }
}
