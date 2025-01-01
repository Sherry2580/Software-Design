package score_system;

import java.util.List;

public class ShowHandler implements CommandHandler {
    private final RecordManager recordManager;

    public ShowHandler(RecordManager recordManager) {
        this.recordManager = recordManager;
    }

    @Override
    public String handle(String[] parts) {
        List<Record> records = recordManager.getAllRecords();
        if (records.isEmpty()) {
            return "尚未輸入成績";
        }

        StringBuilder result = new StringBuilder();
        for (Record record : records) {
            result.append(String.format("姓名: %s 科目: %s 分數: %d%n", 
                                         record.getName(), record.getSubject(), record.getScore()));
        }
        return result.toString();
    }
}