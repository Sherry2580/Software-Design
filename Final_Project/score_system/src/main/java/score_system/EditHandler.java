package score_system;

public class EditHandler implements CommandHandler {
    private final RecordManager recordManager;

    public EditHandler(RecordManager recordManager) {
        this.recordManager = recordManager;
    }

    @Override
    public String handle(String[] parts) {
        if (parts.length != 4) return "指令格式錯誤";

        String name = parts[1];
        String subject = parts[2];
        int newScore;

        try {
            newScore = Integer.parseInt(parts[3]);
        } catch (NumberFormatException e) {
            return "分數格式錯誤";
        }

        if (newScore < 0 || newScore > 100) return "分數輸入錯誤";

        Record record = recordManager.getRecord(name, subject);
        if (record == null) {
            return "無法修改該成績，請輸入add新增或重新輸入";
        }

        record.setScore(newScore); // 修改記錄中的分數
        return String.format("成功修改: %s %s 分數為 %d", name, subject, newScore);
    }
}
