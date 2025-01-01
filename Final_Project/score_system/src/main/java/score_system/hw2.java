package score_system;
import java.util.Scanner;

public class hw2 {
	public static void main(String args[]) {
		String instruc;
		int a = 0;// 控制add存取順序
		int b = 0;// 控制exit流程
		int c = 0;// 控制add流程
		int d = 0;// 控制del流程
		int f = 0;// 控制del 流程
		int g = 0;// 控制edit
		int h = 0;// 控制search流程
		int i = 0;// 控制add for
		int j = 0;// 控制del for
		int k = 0;// 控制edit for
		int l = 0;// 控制search -p for
		int m = 0;// 控制search -s for
		int n = 0;// 控制show
		int o = 0;// 控制search流程(p)
		int p = 0;// 控制show顯示無
		int q = 0;// 控制add顯示科目與分數輸入錯誤
		int sc;// catch非數字
		int sc2 = 0;// 最終使用的分數
		double scSearchSub = 0;// 搜尋科目，算平均
		double scSearchP = 0;// 搜尋人，算平均
		String[] name = new String[101];
		String[] subject = new String[101];
		String[] score = new String[101];

		System.out.println("");
		System.out.println("歡迎使用成績管理系統");
		System.out.println("以下為基本指令集");
		System.out.println("*************************************");
		System.out.println("add 人 科目 分數");
		System.out.println("-登記某人的某科目分數至列表中");
		System.out.println("");
		System.out.println("del 人 科目");
		System.out.println("-刪除某個人的某科目分數");
		System.out.println("");
		System.out.println("edit 人 科目 分數");
		System.out.println("-可編輯某人已登記科目的分數");
		System.out.println("");
		System.out.println("help");
		System.out.println("-列出所有指令集，並說明各個指令的功能");
		System.out.println("");
		System.out.println("show");
		System.out.println("-列出所有成績紀錄，內容包括名字、科目跟科目分數");
		System.out.println("");
		System.out.println("search -p 人");
		System.out.println("-顯示這個人所有已登記科目和成績及各科加總分數平均");
		System.out.println("");
		System.out.println("search -s 科目");
		System.out.println("-列出此科目所有人的名字跟分數以及此科目的平均分數");
		System.out.println("");
		System.out.println("exit");
		System.out.println("-退出系統，結束指令輸入");
		System.out.println("***************************************");
		System.out.println("!!注意:所有指令請以數字及英文小寫字母輸入，並以半行空格隔開，否則將會造成錯誤，需重新輸入!!");
		System.out.println("***************************************");

		while (b == 0 || c == 1 || f == 1) {

			b = 0;
			c = 0;
			d = 0;
			f = 0;
			g = 0;
			h = 0;
			i = 0;
			o = 0;
			p = 0;
			scSearchP = 0;
			scSearchSub = 0;
			System.out.println("");
			System.out.print("請輸入指令");
			Scanner scanner = new Scanner(System.in);// 使用者輸入指令
			instruc = scanner.nextLine();
			// String[] AfterSplit = instruc.split(" ");
			String[] AfterSplit = new String[5];
			AfterSplit = instruc.split(" ");

			if (AfterSplit[0].equals("add") && AfterSplit.length == 4) { /////// 輸入 add 指令後////////

				// 分數偵錯
				try {
					sc = Integer.parseInt(AfterSplit[3]);
				} catch (NumberFormatException e) {
					sc = -1;
				}
				// 分數偵錯結束
				if (!(sc == 0)) {
					String scString = Integer.toString(sc);// sc轉字串
					String scStringFix = scString.replaceFirst("^0+", "");
					sc2 = Integer.parseInt(scStringFix);
				} else {
					sc2 = 0;
				}

				if ((!((sc2 <= 100) && (sc2 >= 0)) && (!(AfterSplit[2].equals("math") || AfterSplit[2].equals("chinese")
						|| AfterSplit[2].equals("science") || AfterSplit[2].equals("english")
						|| AfterSplit[2].equals("social_science"))))) {
					System.out.println("科目與分數輸入錯誤，請重新輸入");
					continue;
				}

				if ((sc2 <= 100 && sc2 >= 0)) {// sc2

					c = 0;
					if (!(AfterSplit[2].equals("math") || AfterSplit[2].equals("chinese")
							|| AfterSplit[2].equals("science") || AfterSplit[2].equals("english")
							|| AfterSplit[2].equals("social_science"))) {
						System.out.println("科目輸入錯誤，請重新輸入");
						c++;
					}
					for (i = 0; i < name.length; i++) {

						if (AfterSplit[1].equals(name[i]) && AfterSplit[2].equals(subject[i])) {
							System.out.println("該成績已被登錄過，請輸入edit修改或重新輸入");
							c++;

						} else {
							continue;
						}

					} // end of for
					if (c == 0) {
						String scFinal = Integer.toString(sc2);
						name[a] = AfterSplit[1];
						subject[a] = AfterSplit[2];
						score[a] = scFinal;
						if (name[a].equals("")) {
							name[a] = null;
							subject[a] = null;
							score[a] = null;
							System.out.println("指令輸入錯誤，請重新輸入");
						}

						a++;
					}

				} // end of sc2
				else
					System.out.println("分數輸入錯誤，請重新輸入");// 糾正分數錯誤
			}

			else if (AfterSplit[0].equals("del") && AfterSplit.length == 3) {////////// 輸入del 指令後////////////
				f = 0;
				if (!(AfterSplit[2].equals("math") || AfterSplit[2].equals("chinese") || AfterSplit[2].equals("science")
						|| AfterSplit[2].equals("english") || AfterSplit[2].equals("social_science"))) {// 科目偵錯
					System.out.println("科目輸入錯誤，請重新輸入");
					f++;
				}
				if (f == 0) {

					for (j = 0; j < name.length; j++) {

						if (AfterSplit[1].equals(name[j]) && AfterSplit[2].equals(subject[j])) {
							name[j] = (null);
							subject[j] = (null);
							score[j] = (null);
							d++;
							break;
						} else {
							continue;
						}

					} // end of for

					if (!(d == 1)) {
						System.out.println("該成績尚未被登錄過，請輸入add新增或重新輸入");
					} else {
						d = 0;
					}
				} // end of subject error
			} // end of del

			else if (AfterSplit[0].equals("edit") && AfterSplit.length == 4) {/////////// 輸入edit 指令後/////////////////

				// 分數偵錯
				try {
					sc = Integer.parseInt(AfterSplit[3]);
				} catch (NumberFormatException e) {
					sc = -1;
				}
				// 分數偵錯結束

				if ((!((sc <= 100) && (sc >= 0)) && (!(AfterSplit[2].equals("math") || AfterSplit[2].equals("chinese")
						|| AfterSplit[2].equals("science") || AfterSplit[2].equals("english")
						|| AfterSplit[2].equals("social_science"))))) {
					System.out.println("科目與分數輸入錯誤，請重新輸入");
					continue;
				}

				if (sc <= 100 && sc >= 0) {// sc
					g = 0;
					if (!(AfterSplit[2].equals("math") || AfterSplit[2].equals("chinese")
							|| AfterSplit[2].equals("science") || AfterSplit[2].equals("english")
							|| AfterSplit[2].equals("social_science"))) {
						System.out.println("科目輸入錯誤，請重新輸入");
						g++;
					}
					for (k = 0; k < name.length; k++) {

						if (AfterSplit[1].equals(name[k]) && AfterSplit[2].equals(subject[k])) {
							String sc1 = String.valueOf(sc);
							score[k] = (sc1);
							g++;
							break;

						} else {
							continue;
						}

					} // end of for

					if (g == 0) {
						System.out.println("無法修改該成績，請輸入add 新增或重新輸入");
					}

				} // end of sc
				else
					System.out.println("分數輸入錯誤，請重新輸入");
			} // end of edit

			else if (AfterSplit[0].equals("search") && AfterSplit.length == 3) {//////// 輸入search指令後
				if (AfterSplit[1].equals("-p")) {////////// 搜尋名字

					for (l = 0; l < name.length; l++) {

						if (AfterSplit[2].equals(name[l])) {
							System.out.println("姓名 : " + name[l] + "  科目 : " + subject[l] + "  分數: " + score[l]);
							scSearchP += Integer.parseInt(score[l]);
							o++;
							continue;
						} else {

							continue;
						}

					} // end of for
					if (o == 0) {
						System.out.println("無法搜尋此人，請輸入add新增或重新輸入");
					} else {
						System.out.println(AfterSplit[2] + "同學" + "總成績平均" + Math.round(scSearchP / o));
					}
				} // end of if

				else if (AfterSplit[1].equals("-s")) {//////////// 搜尋科目
					for (m = 0; m < name.length; m++) {

						if (AfterSplit[2].equals(subject[m])) {
							// System.out.println("可搜尋");
							System.out.println("科目 : " + subject[m] + "  姓名 : " + name[m] + "  分數 : " + score[m]);
							scSearchSub += Integer.parseInt(score[m]);
							h++;
							continue;
						} else {
							continue;
						}

					} // end of for
					if (h == 0) {
						System.out.println("無法搜尋，請輸入add新增或重新輸入");
					} else {
						System.out.println("");
						System.out.println(AfterSplit[2] + "平均" + Math.round(scSearchSub / h));// 印出搜尋科目的平均(四捨五入到整數)
					}
				} else {
					System.out.println("指令輸入錯誤，請重新輸入");
				}
			} // end of search

			else if (AfterSplit[0].equals("show")) {/////////////// 輸入show指令後

				for (n = 0; n < name.length; n++) {
					if (!(name[n] == null)) {
						System.out.println("姓名 : " + name[n] + "  科目 : " + subject[n] + "  分數 : " + score[n]);
						p++;
					}
				}
				if (p == 0) {
					System.out.println("尚未輸入成績");
				}

			} // end of show

			else if (AfterSplit[0].equals("exit") && AfterSplit.length == 1) {/////////////// 輸入exit指令後
				System.out.println("登記結束");
				b++;
				System.exit(0);
			} // end of exit

			else if (AfterSplit[0].equals("help")) {
				System.out.println("以下為基本指令集");
				System.out.println("*************************************");
				System.out.println("add 人 科目 分數");
				System.out.println("-登記某人的某科目分數至列表中");
				System.out.println("");
				System.out.println("del 人 科目");
				System.out.println("-刪除某個人的某科目分數");
				System.out.println("");
				System.out.println("edit 人 科目 分數");
				System.out.println("-可編輯某人已登記科目的分數");
				System.out.println("");
				System.out.println("help");
				System.out.println("-列出所有指令集，並說明各個指令的功能");
				System.out.println("");
				System.out.println("show");
				System.out.println("-列出所有成績紀錄，內容包括名字、科目跟科目分數");
				System.out.println("");
				System.out.println("search -p 人");
				System.out.println("-顯示這個人所有已登記科目和成績及各科加總分數平均");
				System.out.println("");
				System.out.println("search -s 科目");
				System.out.println("-列出此科目所有人的名字跟分數以及此科目的平均分數");
				System.out.println("");
				System.out.println("exit");
				System.out.println("-退出系統，結束指令輸入");
				System.out.println("***************************************");
				System.out.println("!!注意:所有指令請以數字及英文小寫字母輸入，並以半行空格隔開，否則將會造成錯誤，需重新輸入!!");
				System.out.println("***************************************");

			} else {
				System.out.println("指令輸入錯誤，請重新輸入(若要查看說明請輸入help)");
				System.out.println("");
			}
		} // end of while
	}// end of main
}// end of class
