package RentalService;
import java.io.*;
import java.util.*;
public class Manager {	
	private ArrayList<Product> productList=null;
	private ArrayList<User> userList=null;
	
	private int revenue=0; //매출
	private int pCount=0; //물품 리스트 카운트
	private int uCount=0; //유저 리스트 카운트
	

	//초기 구동과 초기 구동이 아닐때 생성자 다르게 쓸 거라 2개 만들었음
	//초기 구동일때는 읽어올 파일이 필요가 없기때문에 ois 객체 없음
	
	// 생성자 (상품 배열, 대여 배열 크기 설정) ois 객체 없음
	Manager(int maxProductCount, int maxUserCount){
		productList=new ArrayList<Product>(maxProductCount);// 상품 배열 크기 설정
		userList=new ArrayList<User>(maxUserCount);// 대여 배열 크기 설정
	}
	
	// 생성자 (상품 배열, 대여 배열 크기 설정, ois 객체)
	Manager (int maxProductCount, int maxUserCount, ObjectInputStream ois) throws Exception{
		productList=new ArrayList<Product>(maxProductCount);// 상품 배열 크기 설정
		userList=new ArrayList<User>(maxUserCount);// 대여 배열 크기 설정
		try {
			readFromFile(ois);
		}
		catch(Exception e) {
			throw new IOException ("오류");
		}	
	}
	
	void saveToFile(ObjectOutputStream oos) throws IOException { // 파일 write 구현
		try {
			pCount=productList.size();//productList 인덱스 몇까지 있는지 = productCount
			uCount=userList.size();//userList 인덱스 몇까지 있는지 = userCount
			
			oos.writeObject(Integer.valueOf(revenue)); //매출 액수 래핑해서 보내기
			oos.writeObject(Integer.valueOf(productList.size()));//물품 리스트 인덱스 몇까지 있는지 래핑해서 보내기
			oos.writeObject(Integer.valueOf(userList.size()));//유저 리스트 인덱스 몇까지 있는지 래핑해서 보내기
						
			for(int i=0; i<pCount; i++) {
				oos.writeObject(productList.get(i));//productList 정보 하나씩 읽어와서 write
			}		
			for(int i=0; i<uCount; i++) {
				oos.writeObject(userList.get(i));//userList 정보 하나씩 읽어와서 write
			}
		}
		catch(IOException e) {
			throw new IOException ("manager 클래스 saveToFile에서 오류 발생");		
		}		
	}
	
	
	void readFromFile(ObjectInputStream ois) throws Exception { // 파일 read 구현
		try {
			//순서주의! write한 순서대로 read 해야함
			//인티저 형으로 온거 int 형으로 오픈하기, 강제 오픈보다는 int형으로 변환해주는 멤버함수를 사용
			this.revenue=((Integer)ois.readObject()).intValue(); 
			this.pCount=((Integer)ois.readObject()).intValue();
			this.uCount=((Integer)ois.readObject()).intValue();
			
			for (int i=0; i<pCount; i++) {
				Product p1 = new Product();
				p1=(Product)ois.readObject();
				addProduct(p1);
			}
			for(int i=0; i<uCount; i++) {
				User u1 = new User();
				u1=(User)ois.readObject();
				addUser(u1);
			}
		}
		catch(IOException e) { //Exception 처리
			throw new IOException ("manager 클래스 saveToFile에서 오류 발생");		
		}
	}
	
	//상품 리스트의 index 번째 상품객체의 재고가 n개 이상일 경우 재고를 n개 제거
	void decreaseStock(int index, int n) throws Exception {
		if(productList.get(index).getNumber()>=n) {
			productList.set(index , new Product(productList.get(index).getName(),productList.get(index).getCode()
					,productList.get(index).getNumber()-n,productList.get(index).getPrice()));
		}
		else {
			throw new Exception ("substock에서 오류 발생");
		}
	}
 
	//상품 리스트의 index 번째 상품객체의 재고를 n개 증가
	void increaseStock(int index, int n) {
		productList.set(index,new Product(productList.get(index).getName(),productList.get(index).getCode()
				,productList.get(index).getNumber()+n,productList.get(index).getPrice()));
	}

	// 코드 중복 검색
	public void checkCode(Product p) throws Exception {
		if(productList.contains(p))
		{
			throw new Exception ("checkCode에서 오류 발생"); // 중복된 코드일 경우 익셉션 발생
		}
	}
	
	//productList에 원소 추가
	public void addProduct(Product p)throws Exception {
		try{
			checkCode(p);
			productList.add(p);
		}
		catch(NumberFormatException e1) {
			throw new Exception ("NumberFormatException 오류 발생");
		}
		catch(Exception e) {
			throw new Exception ("addProduct에서 오류");
		}
	}
	
	//productList에 원소 수정
	public void setProduct(int count, Product p)throws Exception {
		try{
			checkCode(p);
			productList.set(count, p);
		}catch(Exception e) {
			throw new Exception ("addProduct에서 오류");
		}
	}

	// 상품 삭제, 상품 배열에 productCode 인덱스 찾아서 삭제
	public void subProduct(String productCode)throws Exception {
		try {
			// 상품 삭제, 배열 정리하기
			productList.remove(productList.indexOf(new Product(productCode)));
		}
		catch(Exception e) {
			throw new Exception ("subProduct에서 오류");
		}
		
	}

	//상품 객체 검색 (코드) 
	public int searchCode(String productCode) throws Exception {
		int index=productList.indexOf(new Product(productCode)); //Product 객체로 넣어주기
		if(index==-1) //인덱스 -1=상품을 찾지 못했음
		{
			throw new Exception ("상품 객체(코드) 검색 함수에서 오류 발생");
		}
		return index; //productCode의 인덱스 반환
				
	}
	
	//상품 객체 검색 (이름)
	public int searchName(String productName) throws Exception {
		int index=productList.indexOf(new Product(productName)); //Product 객체로 넣어주기
		if(index==-1) //인덱스 -1=상품을 찾지 못했음
		{
			throw new Exception ("상품 객체(이름) 검색 함수에서 오류 발생");
		}
		return index; //productCode의 인덱스 반환
				
	}
		
	// 상품 배열 i번째 리턴
	public Product productAt(int i) {
		try {
			return productList.get(i); // 대여 배열 i번째 유저 객체 return
		}
		catch(IndexOutOfBoundsException e) { 
			return null;
		}
	}
	
	//productList size 값 반환
	public int getProductCount() {
		return productList.size();
	}
	
	//productList 반환
	public ArrayList<Product> getProductList() {
		return productList;
	}
	
//====================================================================================

	// 전화번호 중복 검색
	public void checkPhone(User u) throws Exception {
		if(userList.contains(u))
		{
			throw new Exception ("checkPhone에서 오류 발생"); // 중복된 전화번호일 경우 익셉션 발생
		}
	}

	
	//체크인
	public void addUser(User u) throws Exception {
		try {
			userList.add(u);//배열에 대여 정보 넣기
		}
		catch(Exception e) {
			throw new Exception("checkIn 함수에서 오류발생.");
		}
	}
	
	

	//유저 배열 i번째 리턴
	public User userAt(int i)
	{
		try {
			return userList.get(i);
		}
		catch(IndexOutOfBoundsException e) { 
			return null;
		}	
	}
	
	//핸드폰 번호로 유저 해당 index 찾기
	public int searchUser(String phone) throws Exception {
		int index= userList.indexOf(new User(phone)); //User 객체로 찾기
		if(index==-1) //목록에서 못 찾으면 indexOf -1 반환
		{
			throw new Exception ("고객 객체 검색 함수에서 오류 발생"); // 중복된 전화번호일 경우 익셉션 발생
		}
		return index; //유저 phone의 인덱스 반환
	}
	
	// 상품 재고 다시 추가
	public void addStock(int index) throws Exception {
		User u = userAt(index);
		for(int i = 0; i < u.getRentalCount(); i++) {
			String code = u.codeAt(i); // 해당 User 객체의 i번째 대여 물품 코드
			try {
				int number = searchCode(code); // productList에서 해당 코드의 인덱스 번호 검색
				productAt(number).addNumber(); //해당 인덱스의 product 객체의 재고 추가하기
			}
			catch (Exception e) {
				throw new Exception ("잘못된 방법의 체크아웃입니다.");
			}
		}
	}
	
	// 체크아웃
	public void subUser(int index) throws Exception{
		try{
			addStock(index);// 상품 재고 다시 추가하기
			int money = userList.get(index).pay();// 금액 반환받기
			userList.remove(index); // userList에서 삭제, 배열 정리하기
			revenue += money; // 매출에 추가하기
		}
		catch(Exception e) {
			throw new Exception ("잘못된 방법의 체크아웃입니다.");
		}
	}
	
	// 재고 개수에서 대여 개수 제외
	public void subStock(User u) throws Exception {
		// 재고 개수에서 대여 개수 제외하기
		for(int i = 0; i < u.getRentalCount(); i++)
		{
			String code = u.codeAt(i); // 해당 User 객체의 i번째 대여 물품 코드
			int searchNum;
			try {
				searchNum = searchCode(code); // productList에서 해당 코드의 인덱스 번호 검색
			} 
			catch (Exception e) {
				throw new Exception("잘못된 방법의 체크인입니다.");
			}
			Product p = productList.get(searchNum); //해당 인덱스의 product 객체
			p.subNumber(); // 대여가 가능한지 확인 후 빌리기 (재고 1개 삭제)
		}
	}
	
	// 매출 반환
	public int getRevenue() {
		return revenue;
	}
	
	// userList size 값 반환
	public int getUserCount() {
		return userList.size();
	}
	
	//userList 반환
	public ArrayList<User> getUserList() {
		return userList;
	}
	
	
	
}
