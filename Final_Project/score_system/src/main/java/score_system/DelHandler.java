package score_system;

public class DelHandler implements CommandHandler {
    private final RecordManager recordManager;

    public DelHandler(RecordManager recordManager) {
        this.recordManager = recordManager;
    }

    @Override
    public String handle(String[] parts) {
        if (parts.length != 3) return "指令格式錯誤";
        String name = parts[1];
        String subject = parts[2];

        boolean success = recordManager.deleteRecord(name, subject);
        return success ? String.format("成功刪除: %s %s", name, subject) : "該成績尚未被登錄過";
    }
}
