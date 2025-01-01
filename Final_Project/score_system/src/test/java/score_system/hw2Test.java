package score_system;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class hw2Test {
    private Hw2App app;

    @BeforeEach
    public void setUp() {
        app = new Hw2App(); // 每次測試新建一個 Hw2App 對象，確保環境清潔
    }

    @Test
    public void testAddCommandValidInput() {
        String input = "add John math 90";
        String result = app.executeCommand(input);
        assertEquals("成功登錄: John math 90", result);
    }

    @Test
    public void testAddCommandInvalidScore() {
        String input = "add John math 110"; // 分數超出範圍
        String result = app.executeCommand(input);
        assertEquals("分數輸入錯誤", result);
    }

    @Test
    public void testAddCommandDuplicate() {
        app.executeCommand("add John math 90"); // 第一次成功
        String result = app.executeCommand("add John math 90"); // 再次輸入
        assertEquals("該成績已被登錄過", result);
    }

    @Test
    public void testDelCommandExistingRecord() {
        app.executeCommand("add John math 90");
        String result = app.executeCommand("del John math");
        assertEquals("成功刪除: John math", result);
    }

    @Test
    public void testDelCommandNonExistingRecord() {
        String result = app.executeCommand("del John math");
        assertEquals("該成績尚未被登錄過", result);
    }

    @Test
    public void testSearchByPerson() {
        app.executeCommand("add John math 90");
        app.executeCommand("add John science 80");
        String result = app.executeCommand("search -p John");
        assertTrue(result.contains("John同學總成績平均: 85")); // 測試輸出包含正確的平均分數
    }

    @Test
    public void testSearchBySubject() {
        app.executeCommand("add John math 90");
        app.executeCommand("add Jane math 80");
        String result = app.executeCommand("search -s math");
        assertTrue(result.contains("math平均分數: 85")); // 測試輸出包含正確的平均分數
    }

    @Test
    public void testShowCommand() {
        app.executeCommand("add John math 90");
        app.executeCommand("add Jane science 80");
        String result = app.executeCommand("show");
        assertTrue(result.contains("姓名: John 科目: math 分數: 90"));
        assertTrue(result.contains("姓名: Jane 科目: science 分數: 80"));
    }
    
    @Test
    public void testEditCommandValidInput() {
        app.executeCommand("add John math 90");
        String input = "edit John math 95"; // 修改分數
        String result = app.executeCommand(input);
        assertEquals("成功修改: John math 分數為 95", result);
    }

    @Test
    public void testEditCommandNonExistingRecord() {
        String input = "edit John math 95"; // 試圖修改不存在的記錄
        String result = app.executeCommand(input);
        assertEquals("無法修改該成績，請輸入add新增或重新輸入", result);
    }

    @Test
    public void testExitCommand() {
        String result = app.executeCommand("exit");
        assertEquals("登記結束", result);
    }
    
    @Test
    public void testHelpCommand() {
        String input = "help";
        String result = app.executeCommand(input);
        assertTrue(result.contains("add 人 科目 分數")); // 確認指令集內有此指令說明
        assertTrue(result.contains("exit")); // 確認指令集內有 exit 說明
    }
    
    @Test
    public void testInvalidCommand() {
        String input = "sdd john math 89"; // 非法指令
        String result = app.executeCommand(input);
        assertEquals("指令輸入錯誤", result);
    }
}