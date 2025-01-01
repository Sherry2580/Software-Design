package score_system;

import java.util.ArrayList;
import java.util.List;

public class RecordManager {
    private final List<Record> records;

    public RecordManager() {
        records = new ArrayList<>();
    }

    public boolean addRecord(String name, String subject, int score) {
        if (getRecord(name, subject) != null) return false; // 重複
        records.add(new Record(name, subject, score));
        return true;
    }

    public boolean deleteRecord(String name, String subject) {
        Record record = getRecord(name, subject);
        if (record != null) {
            records.remove(record);
            return true;
        }
        return false;
    }

    public Record getRecord(String name, String subject) {
        for (Record record : records) {
            if (record.getName().equals(name) && record.getSubject().equals(subject)) {
                return record;
            }
        }
        return null;
    }

    public List<Record> getAllRecords() {
        return records;
    }
}