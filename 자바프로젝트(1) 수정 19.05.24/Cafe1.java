package project_sample1;

public interface Cafe1 {
	public void mainMenu(); //전체메뉴
	
	//1.통합메뉴 - 회원가입 / 로그인 / 아이디검색
	public void memberMenu(); //통합메뉴
	public void member(); //회원가입
	public void login(); //로그인
	public void search(); //아이디검색
	public void logout(); //로그아웃
	public void remove(); //탈퇴하기
	
	
	
	
	//2. 메뉴 - 오늘의 메뉴 / 결제하기 / 주차권발행 / 
	public void menu(); // 커피메뉴
	public void dayRandom(); // 오늘의메뉴 랜덤
	public void parking(); // 주차권여부
	public void ticketDraw(); //주차권발행
	
	//3. 종료 후 파일로 저장
	public void save(); //파일저장
	
	//======================================
	
	
	
	
}
