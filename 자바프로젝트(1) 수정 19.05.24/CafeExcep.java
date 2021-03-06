package project_sample1;

import java.util.regex.Pattern;

public class CafeExcep{

	public void inputFormat(String str) throws Exception{

		/*		if(str.length()<8||str.length()>15){ //d	
			throw new Exception("8~15자를 입력하세요.");
		}
		int eng = 0;
		int num = 0;

		for(int i=0; i<str.length(); i++){
			char ch = str.charAt(i);

			if((ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z'))
				eng++; //이게 0이면 영문자 안씀
			else if(ch>='0'&&ch<='9')
				num++; //이게 1이면 숫자 안씀

		}
		if(eng==0||num==0){
			throw new Exception("영문자 숫자 혼용하세요");
		}*/
		if(str.length()<8 ||15<str.length()){
			throw new Exception("8~15자를 입력해주세요");	
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
			throw new Exception("아이디는 영문자와 숫자를 혼용해서 만들어주세요");
		}
	}
	//이름 예외처리(숫자와 영어는 사용할 수 없습니다)
	public void nameFormat(String name)throws Exception{
		boolean patt = Pattern.matches("^[ㄱ-ㅎ가-힣]*$", name);

		if(!patt){
			throw new Exception("한글만 입력해주세요");
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
			throw new Exception("영문자와 숫자는 사용을 할 수 없습니다");
		}

	}



	//메일 예외처리
	//앞자리는 영어숫자 혼동가능 , @무조건 포함
	public void mailFormat(String mail) throws Exception{

		String pattern = "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$";
		String email = mail;

		boolean bl = Pattern.matches(pattern, email);

		if(bl == false){            
			throw new Exception("올바르지 않습니다. 다시 입력하시기 바랍니다.");
		}


	}

	//주민번호 931026 외에는 가능x
	public void juminFormat(String  jumin) throws Exception{
		if(jumin.length()!=6){
			throw new Exception("6자를 입력해주세요[931026]?");	
		}
		int cnt1=0;

		if (cnt1==1) {
			throw new Exception("숫자만을 입력하세요");
		}

	}
	//비밀번호 예외처리 비밀번호 ==비밀번호확인인 같아야한다
	public void passFormat1(String str1, String str2) throws Exception{

		if(!str1.equals(str2)){
			throw new Exception("일치하지않습니다.");
		}
	}
	public void inputPwFormat(String str) throws Exception {

		int eng = 0;
		int num = 0;
		int achic = 0;

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
				eng++; // 이게 0이면 영문자 안씀
			} else if (ch >= '0' && ch <= '9') {
				num++; // 이게 0이면 숫자 안씀
			} else if (ch == '!' || ch == '@' || ch == '#' || ch == '^'
					|| ch == '*') {
				achic++;
			}

		}
		if (eng == 0 || num == 0 || achic == 0) {
			throw new Exception("영문자, 숫자, 특수기호(!,@,#,^,*) 혼용하세요");
		}
		
	}



	//성별
	public void genderForamt(String gender) throws Exception{

		if(gender.length()!=2){
			throw new Exception("남자 / 여자를 입력해주세요");	
		}

		String man="남자";
		String woman="여자";

		if(!gender.equals(man)   && !gender.equals(woman)) {
			throw new Exception("한글로[남자],[여자]만 입력가능해요");	
		}
	}

	public void telFormat(String  tel) throws Exception{
		
		if(tel.length()!=11){
			throw new Exception("11자를 입력해주세요[-제외]");	
		}


	}

}



