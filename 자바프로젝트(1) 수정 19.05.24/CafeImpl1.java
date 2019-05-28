package project_sample1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CafeImpl1 implements Cafe1 {

	private List<CafeVO1> lists;// 얼마만의 배열값이 들어갈 지 모르기 때문에
	private String path = System.getProperty("user.dir");
	private File f = new File(path, "\\data\\cafeGo.txt");
	CafeExcep cafe = new CafeExcep();
	CafeVO1 vo = new CafeVO1();
	Scanner sc = new Scanner(System.in);

	String id = null;

	// 생성자
	public CafeImpl1() {

		try {
			if (!f.getParentFile().exists()) {
				f.getParentFile().mkdir();
			}

			if (f.exists()) {

				FileInputStream fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fis);

				lists = (ArrayList) ois.readObject(); // 다운캐스팅

				fis.close();
				ois.close();
			}
		} catch (Exception e) {

		}
	}

	// 메인메뉴
	@Override
	public void mainMenu() {

		int ch;

		while (true) {

			do {

				if (id == null) {
					System.out.println("\n==============================================================================================================================================");
					System.out.println("           1.통합메뉴(회원가입 / 로그인)                            2.메뉴                                      3.종료");
					System.out.print("==============================================================================================================================================\n선택 : ");

				} else if (!(id == null)) {

					System.out.println("\n==============================================================================================================================================");
					System.out.println("           1.통합메뉴(회원가입 / 로그인)               2.메뉴                 3.종료                  4.로그아웃                 5.회원탈퇴");
					System.out.print("==============================================================================================================================================\n선택 : ");
				}
				ch = sc.nextInt();

			} while (ch < 1);

			switch (ch) {
			case 1:
				memberMenu();
				break;
			case 2:
				menu();
				break;
			case 3:
				save();
				break;
			case 4:
				logout();
				break;
			default:
				remove();
				break;
			}

		}
	}

	// 통합메뉴
	@Override
	public void memberMenu() {

		int ch;

		do {

			if (id == null) {

				System.out.println("==============================================================================================================================================");
				System.out.println("           1.회원가입                              2.로그인                         3.아이디검색                4.메인화면");
				System.out.print("==============================================================================================================================================\n선택 : ");

			} else if (!(id == null)) {

				System.out.println("\n==============================================================================================================================================");
				System.out.println("           3.멤버쉽                               4.메인화면                        5.로그아웃                  6.회원탈퇴");
				System.out.print("==============================================================================================================================================\n선택 : ");
			}
			ch = sc.nextInt();

		} while (ch < 1);

		switch (ch) {
		case 1:
			member();
			break;
		case 2:
			login();
			break;
		case 3:
			search();
			break;
		case 4:
			mainMenu();
			break;
		case 5:
			logout();
			break;
		default:
			remove();
			break;
		}

	}

	// 회원가입
	@Override
	public void member() {
		Scanner sc = new Scanner(System.in);

		CafeVO1 vo = new CafeVO1();

		String rank = "일반등급";
		int appen = 0;
		vo.setRank(rank);
		vo.setAppen(appen);

		// 변수란
		// --------------------------------------------------------------------------------
		String str = null;
		String str1 = null;
		String str2 = null;
		boolean id = true;
		boolean pw = true;

		String mail = null;
		boolean mail1 = true;

		String gender = null;
		boolean gender1 = true;

		String jumin = null;
		boolean jum = true;

		String name = null;
		boolean name1 = true;
		
		String tel = null;
		boolean tel1 = true;

		// ------------------------------------------------------------------------------

		System.out.println();
		System.out.println("[회원가입]");

		do {
			try {
				System.out.print("아이디 :");
				str = sc.next();
				cafe.inputFormat(str);
				id = false;
				vo.setId(str);
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		} while (id);
		do{
			try {
				System.out.print("비밀번호 :");
				str1 = sc.next();
				cafe.inputPwFormat(str1);
				pw = false;
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}

		}while(pw);

		do {
			try {
				System.out.print("비밀번호확인 :");
				str2 = sc.next();
				cafe.passFormat1(str1, str2);
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		} while (!str1.equals(str2));

		vo.setPwd1(str1);


		try {

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		do {
			try {
				System.out.print("이름 :");
				name = sc.next();
				cafe.nameFormat(name);

				name1 = false;
				vo.setName(name);
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		} while (name1);

		do {
			try {
				System.out.print("생년월일 :");
				jumin = sc.next();
				cafe.juminFormat(jumin);
				jum = false;
				vo.setBirth(jumin);
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		} while (jum);

		do {
			try {
				System.out.print("성별[남자/여자] :");
				gender = sc.next();

				cafe.genderForamt(gender);
				gender1 = false;
				vo.setGender(gender);

			} catch (Exception e) {
				System.out.println(e.toString());
			}
		} while (gender1);

		do {
			try {
				System.out.print("이메일 :");
				mail = sc.next();

				cafe.mailFormat(mail);
				mail1 = false;
				vo.setEmail(mail);

			} catch (Exception e) {
				System.out.println(e.toString());
			}
		} while (mail1);
     
		
		do{
			try {
				System.out.print("전화번호: ");
				tel = sc.next();
				cafe.telFormat(tel);
				tel1 = false;
				vo.setTel(tel);
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}	
			
		}while(tel1);


		if (lists == null) {
			lists = new ArrayList<CafeVO1>();
		}

		lists.add(vo);
		System.out.println("회원가입 축하드립니다.");
		
	}

	// 로그인 메소드
	@Override
	public void login() {
		
		System.out.println();
		System.out.println("[로그인]");
		Iterator<CafeVO1> it = lists.iterator();
		String id = null;
		String pw = null;
		boolean check = true;

		do{

			System.out.print("아이디 :");
			id = sc.next();

/*			if(this.id.equals(id)){
				System.out.println("로그인이 되어있습니다.");
				
			}*/

			//}else{

			/*if(!id.equals(vo.getId())){
					System.out.println("회원정보가 없습니다.");
				}*/

			
			System.out.print("비밀번호 :");
			pw = sc.next();

			while(it.hasNext()){
				vo = it.next();
				
				if(id.equals(vo.getId()) && pw.equals(vo.getPwd1())){
					System.out.println("==============================================================================================================================================");
					System.out.println(id + "님이 로그인하였습니다.");
					this.id = id;
					check = false;
					return;
					
				}else if(!id.equals(vo.getId()) && !pw.equals(vo.getPwd1())){
					
					System.out.println("==============================================================================================================================================");
					System.out.println("회원정보가 존재하지 않습니다.");
					System.out.println();
					return;
					
				}else{
					
					System.out.println("==============================================================================================================================================");
					System.out.println("로그인 정보가 틀렸습니다.");
					System.out.println();
					return;
					
				}
			}

		} while(check);


	}

	// 로그아웃
	@Override
	public void logout() {

		System.out.println(id + "님이 로그아웃하였습니다.");
		id = null;

	}

	// 아이디검색 메소드
	@Override
	public void search() {		

		Iterator<CafeVO1> it = lists.iterator();
		while(it.hasNext()){

			vo = it.next();

			if(id==null){
				System.out.println("로그인 해주세요");
				return;

			}else if(id.equals(vo.getId())){

				System.out.printf("아이디 : %4s 이름 : %4s ",vo.getId(),vo.getName());
				System.out.println();
				System.out.println("                                       **                                       ");
				System.out.println("                                      ** *                                      ");
				System.out.println("                                      *  **                                     ");
				System.out.println("                                     **   **                                    ");
				System.out.println("                                    ee    ,X                                    ");
				System.out.println("                                   ze      uX                                   ");
				System.out.println("                                  WeK  ,    WX                                  ");
				System.out.println("                                  eE         yy                                 ");
				System.out.println("                                 ee     ,,,   5u                                ");
				System.out.println("                                ee   ,, ,,,,  ,5u                               ");
				System.out.println("                               #eD  ,uu,u,u,   uX                               ");
				System.out.println("                              yeE  ,uu,,uuu,,   uX                              ");
				System.out.println("                             uee    ,,,,,uu,,,   uu                             ");
				System.out.println("                    uW5D#EeeEDGD    ,,,,uuuuuu,  uGeeeeeGzXW,                   ");
				System.out.println("       ,WXD#9GeeGG9zXyWK,        ,,,,,,,,uuuuuu,,     ,KyXzEeeeeeeeeeE#XW       ");
				System.out.println("    5eey                        ,,,,,,,,,,,,,,,,,                     ,,KeeE    ");
				System.out.println("       eG     ,,,u,, ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,     yEy      ");
				System.out.println("        KeeK   uuuuuuu,,,,,,,uuu,,,,,,,,,,,,,,,,,,u,,,,,,,,,,,,,,    DeD        ");
				System.out.println("          5eeW   uuuuuuuuu,,,,,,,,,,,,,,,,,,,,,,,,,,,,u,,,u,,,,    DGD          ");
				System.out.println("            zeGW   ,uuuuuu,,,,,,,,,,,,,,,,,,,,,,,,,,,,u,,,,,,   ,XG9            ");
				System.out.println("              EeGy   ,uuuuuu,,,,,                 uu,,,,,,,   uz9E,             ");
				System.out.println("                EeE5   ,uuuuu                               uD#Eu               ");
				System.out.println("                 uEGE5   ,uuu         ["+vo.getAppen()+"번]   uuu,,,,,,   uXz9W                 ");
				System.out.println("                   WeE#D   uuu      ["+vo.getRank()+"]         ,,yzDED                   ");
				System.out.println("                     K9XGX uuuu                      uuy5#D                     ");
				System.out.println("                      yGG  uuuuuuuuuuuuuuuuuuuuuuuuKuu   K                      ");
				System.out.println("                      eGy uuuKuuuu,,uuuuuuu,,,uuuuKKuu,,,X                      ");
				System.out.println("                      ee  uuuuuuuuuuu,uuuuuuuuuuuuKuuuu,,Wy                     ");
				System.out.println("                     ye# ,uuKuuuuuuuuuuuuuuuuuuuuuKKuuu, uD                     ");
				System.out.println("                     Ge, uuuKuuuuuuuuu,   ,u,uuu,uuKuuuu ,X                     ");
				System.out.println("                     eE ,uuKKuuuuuu,    K   ,uKKKuuuKKKu, yW                    ");
				System.out.println("                    Keu uuKKuuuu,,   K5y#Ey   ,uKuu,uuuuu KX                    ");
				System.out.println("                    ee ,uuKKuu,   ,WXD#XDeGEzK   uuuu,uuu,,D                    ");
				System.out.println("                    eX uKKWu    KXz#zW    u#eeGX    ,uu,u  5K                   ");
				System.out.println("                   ue  KKK   K5z9#u           zeeE5    ,,  KX                   ");
				System.out.println("                   ee ,,   Wz9zK                ,#ee9K     ,#                   ");
				System.out.println("                   eu   uDE#W                      ,9eez    yK                  ");
				System.out.println("                   e  DG9K                             9ee5  W                  ");
				System.out.println("                  eeD#K                                  ,9eez                  ");
				System.out.println("                  e,                                        ,eK                 ");
				System.out.println("");

			}


		}


	}

	// 회원탈퇴
	@Override
	public void remove() {

		char yn;

		try {

			if (!(id == null)) {

				Iterator<CafeVO1> it = lists.iterator();

				while (it.hasNext()) {

					vo = it.next();

					if (id.equals(vo.getId())) {

						System.out.print("회원탈퇴 하시겠습니까? [Y/N]");

						yn = (char) System.in.read();

						if (yn == 'Y' || yn == 'y') {


							lists.remove(vo);
							System.out.println("이용해주셔서 감사합니다.");
							id = null;
							break;

						}
						System.in.skip(2);

						mainMenu();

					}

				}

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	// 커피메뉴 메소드
	@Override
	public void menu() {


		try {
			int ch = 0;
			int ch1;
			int sum = 0;
			int appen = 0;
			char yn=0;
			
			String menuplus = "                            ▥                                ＊영수증＊                              ▥\n";
			do {
				System.out.println();
				System.out.println();
				System.out.println("                            ▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥");
				System.out.println("                            ▥                              ★1.오늘의 메뉴★                         ▥");
				System.out.println("                            ▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥");
				System.out.println("                            ▥                              ★커피 메뉴★                             ▥");
				System.out.println("                            ▥                                                                        ▥");
				System.out.println("                            ▥2. 아메리카노[3000]         3.카페라떼[4000]      4.카페모카[5000]      ▥");
				System.out.println("                            ▥5. 아이스커피[3000]         6.초콜릿크림[5000]    7.시그니처초콜릿[6000]▥");
				System.out.println("                            ▥8. 자바칩프라푸치노[5000]   9.자몽피지오[7000]    10.블랙티[5000]       ▥");
				System.out.println("                            ▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥");
				System.out.println("                            ▥            11.결제하기                       12.메인메뉴               ▥");
				System.out.println("                            ▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥");	

				System.out.print("                             선택 :");
				ch = sc.nextInt();

				switch (ch) {

				case 1:
					dayRandom();
					break;
				case 2:
					sum += 3000;
					menuplus += "                            ▥아메리카노 3000원                                                       ▥\n";
					break;
				case 3:
					sum += 4000;
					menuplus += "                            ▥카페라떼 4000원                                                         ▥\n";
					break;
				case 4:	
					sum += 5000;
					menuplus += "                            ▥카페모카 5000원                                                         ▥\n";
					break;
				case 5:
					sum += 3000;
					menuplus += "                            ▥아이스커피 3000원                                                       ▥\n";
					break;
				case 6:
					sum += 5000;
					menuplus += "                            ▥초콜릿크림 5000원                                                       ▥\n";
					break;
				case 7:
					sum += 6000;
					menuplus += "                            ▥시그니처초콜릿 6000원                                                   ▥\n";
					break;
				case 8:
					sum += 5000;
					menuplus += "                            ▥자바칩프라푸치노 5000원                                                 ▥\n";
					break;
				case 9:
					sum += 7000;
					menuplus += "                            ▥자몽피지오 7000원                                                       ▥\n";
					break;
				case 10:
					sum += 5000;
					menuplus += "                            ▥블랙티 5000원                                                           ▥\n";
					break;
				case 11:
					System.out.println();
					System.out.println("                            ▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥");
					System.out.print(menuplus);
					System.out.println("                            ▥총값 : "	+ sum + "원                                                          ▥");
					System.out.println("                            ▥========================================================================▥");
					System.out.print("                            ▥결제하시겠습니까? [Y/N] :");
					//System.out.println("                            ▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥");


					yn = (char) System.in.read();

					if (yn != 'Y' && yn != 'y') {						
						menu();
						break;
					}

					System.in.skip(2);
					System.out.println("                            ▥결제가 완료되었습니다.                                                  ▥");
					System.out.println("                            ▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥");

					Iterator<CafeVO1> it = lists.iterator();

					while (it.hasNext()) {
						vo = it.next();

						if (id.equals(vo.getId())) {
							appen = vo.getAppen();
							appen += 1;
							vo.setAppen(appen);

							if (appen < 5) {
								vo.setRank("일반등급");
							} else if (appen >= 5 && 10 > appen) {
								vo.setRank("실버등급");
							} else if (appen >= 10 && 15 > appen) {
								vo.setRank("골드등급");
							} else if (appen >= 15) {
								vo.setRank("VIP등급");
							}
							// vo.setAppen(appen);
						}

					}

					parking();
					break;
				case 12:
					mainMenu();
					break;
				} 
			}while (1 < ch || ch < 11);
		}catch (Exception e) {
			// TODO: handle exception
		}





	}



	@Override
	public void dayRandom() {

		try {

			MyThread tr = new MyThread();

			Random rd = new Random();
			String[] name = { "아메리카노", "카페라떼", "카페모카", "아이스커피", "초콜릿크림",
					"시그니처초콜릿", "자바칩프라푸치노", "자몽피지오", "블랙티" };

			int nansu;
			nansu = rd.nextInt(8);

			System.out.println();
			System.out.print("                            기다려주세요");
			tr.start();
			tr.join();
			System.out.println();
			System.out.println("                            ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
			System.out.println("                                           ☆★오늘의 메뉴는 " + name[nansu]+ "입니다.★☆                             ");
			System.out.println("                            ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
			System.out.println();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	// 주차권발행여부 요금제 메소드
	@Override
	public void parking() {

		char yn = 0;
		do {
			try {

				System.out.print("                              주차권 발행하시겠습니까? [Y/N]");

				yn = (char) System.in.read();

				if (yn != 'Y' && yn != 'y') {
					System.out.println();
					System.out.println("                            이용해주셔서 감사합니다.");
					System.out.println();
					mainMenu();
					break;
				}

				System.in.skip(2);

				System.out.printf("                              %1$tF %1$tT => ", Calendar.getInstance());
				System.out.println("주차권이 발행되었습니다.");
				System.out.println();
				System.out.println("                            ▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥");
				System.out.println("                            ▥                            ★1.주차 요금제★                           ▥");
				System.out.println("                            ▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥");
				System.out.println("                            ▥                               10분 - 2000                              ▥");
				System.out.println("                            ▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥");
				System.out.println("                            ▥                               20분 - 4000                              ▥");
				System.out.println("                            ▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥");
				System.out.println("                            ▥                               30분 - 6000                              ▥");
				System.out.println("                            ▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥");
				System.out.println();
				ticketDraw();
			} catch (Exception e) {

			}
		} while (yn != 'Y' && yn != 'y');

	}

	// 주차권발행
	@Override
	public void ticketDraw() {

		try {

			MyThread1 tr = new MyThread1();

			tr.start();
			tr.join();
			
			mainMenu();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	// 출력하기 메소드
	@Override
	public void save() {
		try {

			if (lists != null) {

				FileOutputStream fos = new FileOutputStream(f);
				ObjectOutputStream oos = new ObjectOutputStream(fos);

				oos.writeObject(lists);

				fos.close();
				oos.close();
				System.out.println("파일 저장 성공");

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}



}



