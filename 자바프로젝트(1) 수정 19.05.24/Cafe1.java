package project_sample1;

public interface Cafe1 {
	public void mainMenu(); //��ü�޴�
	
	//1.���ո޴� - ȸ������ / �α��� / ���̵�˻�
	public void memberMenu(); //���ո޴�
	public void member(); //ȸ������
	public void login(); //�α���
	public void search(); //���̵�˻�
	public void logout(); //�α׾ƿ�
	public void remove(); //Ż���ϱ�
	
	
	
	
	//2. �޴� - ������ �޴� / �����ϱ� / �����ǹ��� / 
	public void menu(); // Ŀ�Ǹ޴�
	public void dayRandom(); // �����Ǹ޴� ����
	public void parking(); // �����ǿ���
	public void ticketDraw(); //�����ǹ���
	
	//3. ���� �� ���Ϸ� ����
	public void save(); //��������
	
	//======================================
	
	
	
	
}
