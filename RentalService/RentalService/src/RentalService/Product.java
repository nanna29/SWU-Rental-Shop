package RentalService;

public class Product implements java.io.Serializable {
	private static final long serialVersionUID = 3069744850893399713L;
	
	private String productName; // 상품 이름
	private String productCode; // 상품 코드
	private int productNumber; // 상품 개수
	private int price;// 상품 가격
	
	
	// 인수 있는 생성자
	Product(String productName, String productCode, int productNumber, int price)
	{
		this.productName = productName;
		this.productCode = productCode;
		this.productNumber = productNumber;
		this.price = price;
	}
	
	//인수 없는 빈 생성자
	Product() {}
	
	Product(String productCode) //search 함수에 넣을 객체 위해 만든 생성자
	{
		this.productCode = productCode;
	}

	//equal 클래스
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Product)) //Product 객체가 아닌 경우 비교 불가
	         return false;
		Product p = (Product) obj;
		
		return p.getCode().equals(getCode()); //true false 반환
	}
	
	// 상품 이름 반환
	public String getName()
	{
		return productName;
	}
	
	// 상품 코드 반환
	public String getCode()
	{
		return productCode;
	}
	
	// 상품 개수 반환
	public int getNumber()
	{
		return productNumber;
	}
	
	// 상품 개수 추가
	public void addNumber()
	{
		productNumber++;
	}
	
	// 상품 대여 가능한지 확인 후 상품 개수 1개 삭제
	public void subNumber() throws Exception{
		if(productNumber < 1) // 재고 개수가 1보다 작을 경우 
			throw new Exception("잘못된 방법의 체크인입니다."); // 익셉션 발생
		else // 재고 물건 숫자가 1이상일 경우
			productNumber--; // 재고 수 1개 감소
	}
	
	// 상품 가격 반환
	public int getPrice()
	{
		return price;
	}
	
	// 재고 검색 함수 (재고가 있으면 true, 아니면 false 반환)
	public boolean isEmpty()
	{
		if(productNumber > 0)
			return true;
		else
			return false;
	}
	
	/*// 파일에 상품 정보를 직접 저장
	void saveToFile(DataOutputStream dos) throws IOException //파일 write
	{
		try {
			//dos 객체에 write 하고싶은 data를 write 한다.   
			dos.writeUTF(productName); //상품명을 write
			dos.writeUTF(productCode); //상품코드를 write
			dos.writeInt(productNumber); //상품개수를 write
			dos.writeInt(price); //상품가격을 write
		}
		catch(IOException e) {
			throw new IOException ("product클래스 saveToFile에서 오류 발생");		
		}	
	}
	
	// 파일에 유저 정보를 직접 읽기
	void readFromFile(DataInputStream dis) throws Exception //파일 read
	{
		//새롭게 변수 선언하는거라서 형 지정도 해주어야 함
		this.productName=dis.readUTF(); //productName read 해오기
		this.productCode=dis.readUTF();//productCode read 해오기
		this.productNumber=dis.readInt();//productNumber read 해오기
		this.price=dis.readInt();//price read 해오기
	}*/	
}