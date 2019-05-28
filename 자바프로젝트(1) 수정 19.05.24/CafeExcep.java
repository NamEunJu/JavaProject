package project_sample1;

import java.util.regex.Pattern;

public class CafeExcep{

	public void inputFormat(String str) throws Exception{

		/*		if(str.length()<8||str.length()>15){ //d	
			throw new Exception("8~15ÀÚ¸¦ ÀÔ·ÂÇÏ¼¼¿ä.");
		}
		int eng = 0;
		int num = 0;

		for(int i=0; i<str.length(); i++){
			char ch = str.charAt(i);

			if((ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z'))
				eng++; //ÀÌ°Ô 0ÀÌ¸é ¿µ¹®ÀÚ ¾È¾¸
			else if(ch>='0'&&ch<='9')
				num++; //ÀÌ°Ô 1ÀÌ¸é ¼ýÀÚ ¾È¾¸

		}
		if(eng==0||num==0){
			throw new Exception("¿µ¹®ÀÚ ¼ýÀÚ È¥¿ëÇÏ¼¼¿ä");
		}*/
		if(str.length()<8 ||15<str.length()){
			throw new Exception("8~15ÀÚ¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä");	
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
			throw new Exception("¾ÆÀÌµð´Â ¿µ¹®ÀÚ¿Í ¼ýÀÚ¸¦ È¥¿ëÇØ¼­ ¸¸µé¾îÁÖ¼¼¿ä");
		}
	}
	//ÀÌ¸§ ¿¹¿ÜÃ³¸®(¼ýÀÚ¿Í ¿µ¾î´Â »ç¿ëÇÒ ¼ö ¾ø½À´Ï´Ù)
	public void nameFormat(String name)throws Exception{
		boolean patt = Pattern.matches("^[¤¡-¤¾°¡-ÆR]*$", name);

		if(!patt){
			throw new Exception("ÇÑ±Û¸¸ ÀÔ·ÂÇØÁÖ¼¼¿ä");
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
			throw new Exception("¿µ¹®ÀÚ¿Í ¼ýÀÚ´Â »ç¿ëÀ» ÇÒ ¼ö ¾ø½À´Ï´Ù");
		}

	}



	//¸ÞÀÏ ¿¹¿ÜÃ³¸®
	//¾ÕÀÚ¸®´Â ¿µ¾î¼ýÀÚ È¥µ¿°¡´É , @¹«Á¶°Ç Æ÷ÇÔ
	public void mailFormat(String mail) throws Exception{

		String pattern = "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$";
		String email = mail;

		boolean bl = Pattern.matches(pattern, email);

		if(bl == false){            
			throw new Exception("¿Ã¹Ù¸£Áö ¾Ê½À´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇÏ½Ã±â ¹Ù¶ø´Ï´Ù.");
		}


	}

	//ÁÖ¹Î¹øÈ£ 931026 ¿Ü¿¡´Â °¡´Éx
	public void juminFormat(String  jumin) throws Exception{
		if(jumin.length()!=6){
			throw new Exception("6ÀÚ¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä[931026]?");	
		}
		int cnt1=0;

		if (cnt1==1) {
			throw new Exception("¼ýÀÚ¸¸À» ÀÔ·ÂÇÏ¼¼¿ä");
		}

	}
	//ºñ¹Ð¹øÈ£ ¿¹¿ÜÃ³¸® ºñ¹Ð¹øÈ£ ==ºñ¹Ð¹øÈ£È®ÀÎÀÎ °°¾Æ¾ßÇÑ´Ù
	public void passFormat1(String str1, String str2) throws Exception{

		if(!str1.equals(str2)){
			throw new Exception("ÀÏÄ¡ÇÏÁö¾Ê½À´Ï´Ù.");
		}
	}
	public void inputPwFormat(String str) throws Exception {

		int eng = 0;
		int num = 0;
		int achic = 0;

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
				eng++; // ÀÌ°Ô 0ÀÌ¸é ¿µ¹®ÀÚ ¾È¾¸
			} else if (ch >= '0' && ch <= '9') {
				num++; // ÀÌ°Ô 0ÀÌ¸é ¼ýÀÚ ¾È¾¸
			} else if (ch == '!' || ch == '@' || ch == '#' || ch == '^'
					|| ch == '*') {
				achic++;
			}

		}
		if (eng == 0 || num == 0 || achic == 0) {
			throw new Exception("¿µ¹®ÀÚ, ¼ýÀÚ, Æ¯¼ö±âÈ£(!,@,#,^,*) È¥¿ëÇÏ¼¼¿ä");
		}
		
	}



	//¼ºº°
	public void genderForamt(String gender) throws Exception{

		if(gender.length()!=2){
			throw new Exception("³²ÀÚ / ¿©ÀÚ¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä");	
		}

		String man="³²ÀÚ";
		String woman="¿©ÀÚ";

		if(!gender.equals(man)   && !gender.equals(woman)) {
			throw new Exception("ÇÑ±Û·Î[³²ÀÚ],[¿©ÀÚ]¸¸ ÀÔ·Â°¡´ÉÇØ¿ä");	
		}
	}

	public void telFormat(String  tel) throws Exception{
		
		if(tel.length()!=11){
			throw new Exception("11ÀÚ¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä[-Á¦¿Ü]");	
		}


	}

}



