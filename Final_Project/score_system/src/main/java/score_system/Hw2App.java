package score_system;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hw2App {
	private final RecordManager recordManager;
    private final Map<String, CommandHandler> commandHandlers;

    public Hw2App() {
        recordManager = new RecordManager();
        commandHandlers = new HashMap<>();
        commandHandlers.put("add", new AddHandler(recordManager));
        commandHandlers.put("del", new DelHandler(recordManager));
        commandHandlers.put("search", new SearchHandler(recordManager));
        commandHandlers.put("show", new ShowHandler(recordManager));
        commandHandlers.put("exit", new ExitHandler());
        commandHandlers.put("help", new HelpHandler());
        commandHandlers.put("edit", new EditHandler(recordManager));
    }

    public String executeCommand(String commandLine) {
        String[] parts = commandLine.split(" ");
        String command = parts[0];
        CommandHandler handler = commandHandlers.get(command);

        if (handler != null) {
            return handler.handle(parts);
        } else {
            return "指令輸入錯誤";
        }
    }
    public static void main(String[] args) {
        Hw2App app = new Hw2App();
        Scanner scanner = new Scanner(System.in);

        System.out.println("歡迎使用成績管理系統！");
        System.out.println("""
                以下為基本指令集:
                *************************************
                add 人 科目 分數
                - 登記某人的某科目分數至列表中

                del 人 科目
                - 刪除某個人的某科目分數

                edit 人 科目 分數
                - 可編輯某人已登記科目的分數

                help
                - 列出所有指令集，並說明各個指令的功能

                show
                - 列出所有成績記錄，內容包括名字、科目跟科目分數

                search -p 人
                - 顯示這個人所有已登記科目和成績及各科加總分數平均

                search -s 科目
                - 列出此科目所有人的名字跟分數以及此科目的平均分數

                exit
                - 退出系統，結束指令輸入
                ***************************************
                !!注意:所有指令請以數字及英文小寫字母輸入，並以半行空格隔開，否則將會造成錯誤，需重新輸入!!
                ***************************************
                """);

        while (true) {
            System.out.print("請輸入指令: ");
            String input = scanner.nextLine();
            String result = app.executeCommand(input);
            System.out.println(result);

            if ("exit".equals(input.trim())) {
                break;
            }
        }

        scanner.close();
    }
}
