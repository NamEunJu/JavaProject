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

	private List<CafeVO1> lists;// �󸶸��� �迭���� �� �� �𸣱� ������
	private String path = System.getProperty("user.dir");
	private File f = new File(path, "\\data\\cafeGo.txt");
	CafeExcep cafe = new CafeExcep();
	CafeVO1 vo = new CafeVO1();
	Scanner sc = new Scanner(System.in);

	String id = null;

	// ������
	public CafeImpl1() {

		try {
			if (!f.getParentFile().exists()) {
				f.getParentFile().mkdir();
			}

			if (f.exists()) {

				FileInputStream fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fis);

				lists = (ArrayList) ois.readObject(); // �ٿ�ĳ����

				fis.close();
				ois.close();
			}
		} catch (Exception e) {

		}
	}

	// ���θ޴�
	@Override
	public void mainMenu() {

		int ch;

		while (true) {

			do {

				if (id == null) {
					System.out.println("\n==============================================================================================================================================");
					System.out.println("           1.���ո޴�(ȸ������ / �α���)                            2.�޴�                                      3.����");
					System.out.print("==============================================================================================================================================\n���� : ");

				} else if (!(id == null)) {

					System.out.println("\n==============================================================================================================================================");
					System.out.println("           1.���ո޴�(ȸ������ / �α���)               2.�޴�                 3.����                  4.�α׾ƿ�                 5.ȸ��Ż��");
					System.out.print("==============================================================================================================================================\n���� : ");
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

	// ���ո޴�
	@Override
	public void memberMenu() {

		int ch;

		do {

			if (id == null) {

				System.out.println("==============================================================================================================================================");
				System.out.println("           1.ȸ������                              2.�α���                         3.���̵�˻�                4.����ȭ��");
				System.out.print("==============================================================================================================================================\n���� : ");

			} else if (!(id == null)) {

				System.out.println("\n==============================================================================================================================================");
				System.out.println("           3.�����                               4.����ȭ��                        5.�α׾ƿ�                  6.ȸ��Ż��");
				System.out.print("==============================================================================================================================================\n���� : ");
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

	// ȸ������
	@Override
	public void member() {
		Scanner sc = new Scanner(System.in);

		CafeVO1 vo = new CafeVO1();

		String rank = "�Ϲݵ��";
		int appen = 0;
		vo.setRank(rank);
		vo.setAppen(appen);

		// ������
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
		System.out.println("[ȸ������]");

		do {
			try {
				System.out.print("���̵� :");
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
				System.out.print("��й�ȣ :");
				str1 = sc.next();
				cafe.inputPwFormat(str1);
				pw = false;
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}

		}while(pw);

		do {
			try {
				System.out.print("��й�ȣȮ�� :");
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
				System.out.print("�̸� :");
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
				System.out.print("������� :");
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
				System.out.print("����[����/����] :");
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
				System.out.print("�̸��� :");
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
				System.out.print("��ȭ��ȣ: ");
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
		System.out.println("ȸ������ ���ϵ帳�ϴ�.");
		
	}

	// �α��� �޼ҵ�
	@Override
	public void login() {
		
		System.out.println();
		System.out.println("[�α���]");
		Iterator<CafeVO1> it = lists.iterator();
		String id = null;
		String pw = null;
		boolean check = true;

		do{

			System.out.print("���̵� :");
			id = sc.next();

/*			if(this.id.equals(id)){
				System.out.println("�α����� �Ǿ��ֽ��ϴ�.");
				
			}*/

			//}else{

			/*if(!id.equals(vo.getId())){
					System.out.println("ȸ�������� �����ϴ�.");
				}*/

			
			System.out.print("��й�ȣ :");
			pw = sc.next();

			while(it.hasNext()){
				vo = it.next();
				
				if(id.equals(vo.getId()) && pw.equals(vo.getPwd1())){
					System.out.println("==============================================================================================================================================");
					System.out.println(id + "���� �α����Ͽ����ϴ�.");
					this.id = id;
					check = false;
					return;
					
				}else if(!id.equals(vo.getId()) && !pw.equals(vo.getPwd1())){
					
					System.out.println("==============================================================================================================================================");
					System.out.println("ȸ�������� �������� �ʽ��ϴ�.");
					System.out.println();
					return;
					
				}else{
					
					System.out.println("==============================================================================================================================================");
					System.out.println("�α��� ������ Ʋ�Ƚ��ϴ�.");
					System.out.println();
					return;
					
				}
			}

		} while(check);


	}

	// �α׾ƿ�
	@Override
	public void logout() {

		System.out.println(id + "���� �α׾ƿ��Ͽ����ϴ�.");
		id = null;

	}

	// ���̵�˻� �޼ҵ�
	@Override
	public void search() {		

		Iterator<CafeVO1> it = lists.iterator();
		while(it.hasNext()){

			vo = it.next();

			if(id==null){
				System.out.println("�α��� ���ּ���");
				return;

			}else if(id.equals(vo.getId())){

				System.out.printf("���̵� : %4s �̸� : %4s ",vo.getId(),vo.getName());
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
				System.out.println("                 uEGE5   ,uuu         ["+vo.getAppen()+"��]   uuu,,,,,,   uXz9W                 ");
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

	// ȸ��Ż��
	@Override
	public void remove() {

		char yn;

		try {

			if (!(id == null)) {

				Iterator<CafeVO1> it = lists.iterator();

				while (it.hasNext()) {

					vo = it.next();

					if (id.equals(vo.getId())) {

						System.out.print("ȸ��Ż�� �Ͻðڽ��ϱ�? [Y/N]");

						yn = (char) System.in.read();

						if (yn == 'Y' || yn == 'y') {


							lists.remove(vo);
							System.out.println("�̿����ּż� �����մϴ�.");
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

	// Ŀ�Ǹ޴� �޼ҵ�
	@Override
	public void menu() {


		try {
			int ch = 0;
			int ch1;
			int sum = 0;
			int appen = 0;
			char yn=0;
			
			String menuplus = "                            ��                                ����������                              ��\n";
			do {
				System.out.println();
				System.out.println();
				System.out.println("                            �ȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢ�");
				System.out.println("                            ��                              ��1.������ �޴���                         ��");
				System.out.println("                            �ȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢ�");
				System.out.println("                            ��                              ��Ŀ�� �޴���                             ��");
				System.out.println("                            ��                                                                        ��");
				System.out.println("                            ��2. �Ƹ޸�ī��[3000]         3.ī���[4000]      4.ī���ī[5000]      ��");
				System.out.println("                            ��5. ���̽�Ŀ��[3000]         6.���ݸ�ũ��[5000]    7.�ñ״�ó���ݸ�[6000]��");
				System.out.println("                            ��8. �ڹ�Ĩ����Ǫġ��[5000]   9.�ڸ�������[7000]    10.��Ƽ[5000]       ��");
				System.out.println("                            �ȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢ�");
				System.out.println("                            ��            11.�����ϱ�                       12.���θ޴�               ��");
				System.out.println("                            �ȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢ�");	

				System.out.print("                             ���� :");
				ch = sc.nextInt();

				switch (ch) {

				case 1:
					dayRandom();
					break;
				case 2:
					sum += 3000;
					menuplus += "                            �ȾƸ޸�ī�� 3000��                                                       ��\n";
					break;
				case 3:
					sum += 4000;
					menuplus += "                            ��ī��� 4000��                                                         ��\n";
					break;
				case 4:	
					sum += 5000;
					menuplus += "                            ��ī���ī 5000��                                                         ��\n";
					break;
				case 5:
					sum += 3000;
					menuplus += "                            �Ⱦ��̽�Ŀ�� 3000��                                                       ��\n";
					break;
				case 6:
					sum += 5000;
					menuplus += "                            �����ݸ�ũ�� 5000��                                                       ��\n";
					break;
				case 7:
					sum += 6000;
					menuplus += "                            �Ƚñ״�ó���ݸ� 6000��                                                   ��\n";
					break;
				case 8:
					sum += 5000;
					menuplus += "                            ���ڹ�Ĩ����Ǫġ�� 5000��                                                 ��\n";
					break;
				case 9:
					sum += 7000;
					menuplus += "                            ���ڸ������� 7000��                                                       ��\n";
					break;
				case 10:
					sum += 5000;
					menuplus += "                            �Ⱥ�Ƽ 5000��                                                           ��\n";
					break;
				case 11:
					System.out.println();
					System.out.println("                            �ȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢ�");
					System.out.print(menuplus);
					System.out.println("                            ���Ѱ� : "	+ sum + "��                                                          ��");
					System.out.println("                            ��========================================================================��");
					System.out.print("                            �Ȱ����Ͻðڽ��ϱ�? [Y/N] :");
					//System.out.println("                            �ȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢ�");


					yn = (char) System.in.read();

					if (yn != 'Y' && yn != 'y') {						
						menu();
						break;
					}

					System.in.skip(2);
					System.out.println("                            �Ȱ����� �Ϸ�Ǿ����ϴ�.                                                  ��");
					System.out.println("                            �ȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢ�");

					Iterator<CafeVO1> it = lists.iterator();

					while (it.hasNext()) {
						vo = it.next();

						if (id.equals(vo.getId())) {
							appen = vo.getAppen();
							appen += 1;
							vo.setAppen(appen);

							if (appen < 5) {
								vo.setRank("�Ϲݵ��");
							} else if (appen >= 5 && 10 > appen) {
								vo.setRank("�ǹ����");
							} else if (appen >= 10 && 15 > appen) {
								vo.setRank("�����");
							} else if (appen >= 15) {
								vo.setRank("VIP���");
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
			String[] name = { "�Ƹ޸�ī��", "ī���", "ī���ī", "���̽�Ŀ��", "���ݸ�ũ��",
					"�ñ״�ó���ݸ�", "�ڹ�Ĩ����Ǫġ��", "�ڸ�������", "��Ƽ" };

			int nansu;
			nansu = rd.nextInt(8);

			System.out.println();
			System.out.print("                            ��ٷ��ּ���");
			tr.start();
			tr.join();
			System.out.println();
			System.out.println("                            �ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ�");
			System.out.println("                                           �١ڿ����� �޴��� " + name[nansu]+ "�Դϴ�.�ڡ�                             ");
			System.out.println("                            �ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ�");
			System.out.println();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	// �����ǹ��࿩�� ����� �޼ҵ�
	@Override
	public void parking() {

		char yn = 0;
		do {
			try {

				System.out.print("                              ������ �����Ͻðڽ��ϱ�? [Y/N]");

				yn = (char) System.in.read();

				if (yn != 'Y' && yn != 'y') {
					System.out.println();
					System.out.println("                            �̿����ּż� �����մϴ�.");
					System.out.println();
					mainMenu();
					break;
				}

				System.in.skip(2);

				System.out.printf("                              %1$tF %1$tT => ", Calendar.getInstance());
				System.out.println("�������� ����Ǿ����ϴ�.");
				System.out.println();
				System.out.println("                            �ȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢ�");
				System.out.println("                            ��                            ��1.���� �������                           ��");
				System.out.println("                            �ȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢ�");
				System.out.println("                            ��                               10�� - 2000                              ��");
				System.out.println("                            �ȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢ�");
				System.out.println("                            ��                               20�� - 4000                              ��");
				System.out.println("                            �ȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢ�");
				System.out.println("                            ��                               30�� - 6000                              ��");
				System.out.println("                            �ȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢ�");
				System.out.println();
				ticketDraw();
			} catch (Exception e) {

			}
		} while (yn != 'Y' && yn != 'y');

	}

	// �����ǹ���
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

	// ����ϱ� �޼ҵ�
	@Override
	public void save() {
		try {

			if (lists != null) {

				FileOutputStream fos = new FileOutputStream(f);
				ObjectOutputStream oos = new ObjectOutputStream(fos);

				oos.writeObject(lists);

				fos.close();
				oos.close();
				System.out.println("���� ���� ����");

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}



}



