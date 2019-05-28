package project_sample1;

import java.util.regex.Pattern;

public class CafeExcep{

	public void inputFormat(String str) throws Exception{

		/*		if(str.length()<8||str.length()>15){ //d	
			throw new Exception("8~15�ڸ� �Է��ϼ���.");
		}
		int eng = 0;
		int num = 0;

		for(int i=0; i<str.length(); i++){
			char ch = str.charAt(i);

			if((ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z'))
				eng++; //�̰� 0�̸� ������ �Ⱦ�
			else if(ch>='0'&&ch<='9')
				num++; //�̰� 1�̸� ���� �Ⱦ�

		}
		if(eng==0||num==0){
			throw new Exception("������ ���� ȥ���ϼ���");
		}*/
		if(str.length()<8 ||15<str.length()){
			throw new Exception("8~15�ڸ� �Է����ּ���");	
		}

		int cnt1 = 0;
		int cnt2 = 0;

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122))
				cnt1=1;
			else if (ch >= 48 && ch <= 57)
				cnt2=1;

		}
		if (cnt1 == 0 || cnt2 == 0) {
			throw new Exception("���̵�� �����ڿ� ���ڸ� ȥ���ؼ� ������ּ���");
		}
	}
	//�̸� ����ó��(���ڿ� ����� ����� �� �����ϴ�)
	public void nameFormat(String name)throws Exception{
		boolean patt = Pattern.matches("^[��-����-�R]*$", name);

		if(!patt){
			throw new Exception("�ѱ۸� �Է����ּ���");
		}

		int cnt1=0;
		int cnt2=0;

		for (int i = 0; i < name.length(); i++) {
			char ch = name.charAt(i);
			if ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122))
				cnt1=1;
			else if (ch >= 48 && ch <= 57)
				cnt2=1;

		}
		if (cnt1 != 0 || cnt2 != 0) {
			throw new Exception("�����ڿ� ���ڴ� ����� �� �� �����ϴ�");
		}

	}



	//���� ����ó��
	//���ڸ��� ������� ȥ������ , @������ ����
	public void mailFormat(String mail) throws Exception{

		String pattern = "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$";
		String email = mail;

		boolean bl = Pattern.matches(pattern, email);

		if(bl == false){            
			throw new Exception("�ùٸ��� �ʽ��ϴ�. �ٽ� �Է��Ͻñ� �ٶ��ϴ�.");
		}


	}

	//�ֹι�ȣ 931026 �ܿ��� ����x
	public void juminFormat(String  jumin) throws Exception{
		if(jumin.length()!=6){
			throw new Exception("6�ڸ� �Է����ּ���[931026]?");	
		}
		int cnt1=0;

		if (cnt1==1) {
			throw new Exception("���ڸ��� �Է��ϼ���");
		}

	}
	//��й�ȣ ����ó�� ��й�ȣ ==��й�ȣȮ���� ���ƾ��Ѵ�
	public void passFormat1(String str1, String str2) throws Exception{

		if(!str1.equals(str2)){
			throw new Exception("��ġ�����ʽ��ϴ�.");
		}
	}
	public void inputPwFormat(String str) throws Exception {

		int eng = 0;
		int num = 0;
		int achic = 0;

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
				eng++; // �̰� 0�̸� ������ �Ⱦ�
			} else if (ch >= '0' && ch <= '9') {
				num++; // �̰� 0�̸� ���� �Ⱦ�
			} else if (ch == '!' || ch == '@' || ch == '#' || ch == '^'
					|| ch == '*') {
				achic++;
			}

		}
		if (eng == 0 || num == 0 || achic == 0) {
			throw new Exception("������, ����, Ư����ȣ(!,@,#,^,*) ȥ���ϼ���");
		}
		
	}



	//����
	public void genderForamt(String gender) throws Exception{

		if(gender.length()!=2){
			throw new Exception("���� / ���ڸ� �Է����ּ���");	
		}

		String man="����";
		String woman="����";

		if(!gender.equals(man)   && !gender.equals(woman)) {
			throw new Exception("�ѱ۷�[����],[����]�� �Է°����ؿ�");	
		}
	}

	public void telFormat(String  tel) throws Exception{
		
		if(tel.length()!=11){
			throw new Exception("11�ڸ� �Է����ּ���[-����]");	
		}


	}

}



