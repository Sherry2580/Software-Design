package score_system;

public class Record {
    private final String name;
    private final String subject;
    private int score;

    public Record(String name, String subject, int score) {
        this.name = name;
        this.subject = subject;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public int getScore() {
        return score;
    }
    
    public void setScore(int score) {
        this.score = score; // 提供修改分數的方法
    }
}
