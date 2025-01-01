package score_system;

import java.util.List;

public class SearchHandler implements CommandHandler {
    private final RecordManager recordManager;

    public SearchHandler(RecordManager recordManager) {
        this.recordManager = recordManager;
    }

    @Override
    public String handle(String[] parts) {
        if (parts.length != 3) return "指令格式錯誤";

        String option = parts[1];
        String keyword = parts[2];

        if ("-p".equals(option)) {
            return searchByPerson(keyword);
        } else if ("-s".equals(option)) {
            return searchBySubject(keyword);
        } else {
            return "搜尋選項錯誤";
        }
    }

    private String searchByPerson(String name) {
        List<Record> records = recordManager.getAllRecords();
        StringBuilder result = new StringBuilder();
        int totalScore = 0;
        int count = 0;

        for (Record record : records) {
            if (record.getName().equals(name)) {
                result.append(String.format("姓名: %s 科目: %s 分數: %d%n", 
                                             record.getName(), record.getSubject(), record.getScore()));
                totalScore += record.getScore();
                count++;
            }
        }

        if (count == 0) {
            return "無法搜尋此人，請輸入add新增或重新輸入";
        }

        result.append(String.format("%s同學總成績平均: %d", name, totalScore / count));
        return result.toString();
    }

    private String searchBySubject(String subject) {
        List<Record> records = recordManager.getAllRecords();
        StringBuilder result = new StringBuilder();
        int totalScore = 0;
        int count = 0;

        for (Record record : records) {
            if (record.getSubject().equals(subject)) {
                result.append(String.format("科目: %s 姓名: %s 分數: %d%n", 
                                             record.getSubject(), record.getName(), record.getScore()));
                totalScore += record.getScore();
                count++;
            }
        }

        if (count == 0) {
            return "無法搜尋此科目，請輸入add新增或重新輸入";
        }

        result.append(String.format("%s平均分數: %d", subject, totalScore / count));
        return result.toString();
    }
}
