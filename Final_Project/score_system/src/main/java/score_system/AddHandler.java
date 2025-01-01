package score_system;

public class AddHandler implements CommandHandler {
    private final RecordManager recordManager;

    public AddHandler(RecordManager recordManager) {
        this.recordManager = recordManager;
    }

    @Override
    public String handle(String[] parts) {
        if (parts.length != 4) return "指令格式錯誤";
        String name = parts[1];
        String subject = parts[2];
        int score;

        try {
            score = Integer.parseInt(parts[3]);
        } catch (NumberFormatException e) {
            return "分數格式錯誤";
        }

        if (score < 0 || score > 100) return "分數輸入錯誤";

        boolean success = recordManager.addRecord(name, subject, score);
        return success ? String.format("成功登錄: %s %s %d", name, subject, score) : "該成績已被登錄過";
    }
}
