package RentalService;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class Gui{
	public static void main(String[] args) throws Exception {
		ServiceStart s=new ServiceStart(); //초기화면
		//ManagerOrUser s1= new ManagerOrUser(); //관리자 or 고객
		//CheckInOrOut u=new CheckInOrOut(); // 체크인 or 체크아웃
		//UserRental u1= new UserRental(); // 고객 체크인
		//UserReturn u2= new UserReturn(); //고객 체크아웃
		//UserOrProduct m= new UserOrProduct(); //물품관리 or 고객관리
		//ManageProduct m1 = new ManageProduct(); //물품관리
		//ManageUser m2 = new ManageUser(); //고객관리
		
	}
}

//초기화면(렌탈샵 들어올건지 나갈건지) R E N T A L S H O P.
class ServiceStart extends JFrame{
	private static final long serialVersionUID = -8765880744317455457L;
	
	JFrame frame;
	private JButton exitBtn; //나가기 버튼
	private JButton enterBtn; //들어가기 버튼
	
	public ServiceStart() {
		Dimension dim = new Dimension(500,500);
		frame = new JFrame("RentalService");
	    frame.setLocation(100, 100);
	    frame.setPreferredSize(dim);
	    
	    //텍스트
	    JLabel lblNewLabel = new JLabel("R E N T A L S H O P");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 30));
		lblNewLabel.setBounds(64, 60, 358, 76);
		frame.getContentPane().add(lblNewLabel);
		//텍스트
		JLabel lblNewLabel_1 = new JLabel("원하시는 서비스를 선택해 주세요",JLabel.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(108, 220, 266, 65);
		frame.getContentPane().add(lblNewLabel_1);
		
		//나가기 버튼
		exitBtn = new JButton("EXIT");
		exitBtn.setBounds(50, 407, 91, 23);
		exitBtn.addActionListener(new exitActionListener());
		frame.getContentPane().add(exitBtn);
		//들어오기 버튼
		enterBtn = new JButton("ENTER");
		enterBtn.setBounds(342, 407, 91, 23);
		enterBtn.addActionListener(new enterActionListener());
		frame.getContentPane().add(enterBtn);
		
		frame.getContentPane().setLayout(null);	    	    
	    frame.pack();
	    
	    frame.setVisible(true);    
	}
	
	//EXIT 버튼 눌렀을때 처리 될 이벤트
	private class exitActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==exitBtn) {
				System.exit(0); //프로그램 종료
			}					            
		}
	}
	
	//ENTER 버튼 눌렀을때 처리 될 이벤트
    private class enterActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==enterBtn) {			
				new ManagerOrUser(); //관리자인지 사용자인지 물어보는 화면으로 전환
				frame.setVisible(false);
			}					            
		}
	}
    
}

//두번째 화면, 관리자인지 사용자인지 물어보는 프레임 (WHO ARE YOU?)
class ManagerOrUser extends JFrame{
	private static final long serialVersionUID = -1443060063965434829L;
	
	JFrame frame;

	private JButton manageBtn; //관리자 버튼
	private JButton userBtn; //고객 버튼
	
	public ManagerOrUser() {
		Dimension dim = new Dimension(500,500);
		frame = new JFrame("RentalService");
	    frame.setLocation(100, 100);
	    frame.setPreferredSize(dim);
		
	    //텍스트
		JLabel lblNewLabel = new JLabel("WHO ARE YOU?");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 30));
		lblNewLabel.setBounds(122, 60, 250, 76);
		frame.getContentPane().add(lblNewLabel);
		JLabel lblNewLabel_1 = new JLabel("<html><body style='text-align:center;'>서비스 이용하실 고객은<br />사용자 버튼을 눌러주십시오</body></html>");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(147, 188, 189, 65);
		frame.getContentPane().add(lblNewLabel_1);
		JLabel lblNewLabel_1_1 = new JLabel("<html><body style='text-align:center;'>렌탈샵을 관리하실 관리자는<br />관리자 버튼을 눌러주십시오</body></html>");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(147, 281, 189, 65);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		//관리자 버튼
		manageBtn = new JButton("관리자");
		manageBtn.setBounds(50, 407, 91, 23);
		manageBtn.addActionListener(new manageActionListener());
		frame.getContentPane().add(manageBtn);
		//고객버튼
		userBtn = new JButton("사용자");
		userBtn.setBounds(342, 407, 91, 23);
		userBtn.addActionListener(new userActionListener());
		frame.getContentPane().add(userBtn);
		
		frame.getContentPane().setLayout(null);	    	    
	    frame.pack();
	    
	    frame.setVisible(true);	    
	}
	
	//관리자 버튼 눌렀을때 처리될 이벤트
	private class manageActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==manageBtn) {		
				new UserOrProduct(); //관리자가 유저관리 할건지 물품관리 할건지 물어보는 프레임으로 전환
				frame.setVisible(false);    
			}					            
		}
	}
	
	//사용자 버튼 눌렀을때 처리될 이벤트
	private class userActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==userBtn) {			
				new CheckInOrOut();//사용자가 체크인 할건지 체크아웃 할건지 물어보는 프레임으로 전환
				frame.setVisible(false);    
			}					            
		}
	}
	
}


//사용자 버튼 눌렀을 때 (체크인 or 체크아웃) 물어보는 화면
class CheckInOrOut extends JFrame{
	private static final long serialVersionUID = 4528468258959964955L;
	
	JFrame frame;
	private JButton checkOutBtn; //체크아웃 버튼
	private JButton checkInBtn; //체크인 버튼
	
	public CheckInOrOut() {
		Dimension dim = new Dimension(500,500);
		frame = new JFrame("RentalService");
	    frame.setLocation(100, 100);
	    frame.setPreferredSize(dim);
	    
	    //텍스트
	    JLabel lblNewLabel = new JLabel("반갑습니다 고객님");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 30));
		lblNewLabel.setBounds(64, 60, 358, 76);
		frame.getContentPane().add(lblNewLabel);
		JLabel lblNewLabel_1 = new JLabel("버튼을 누르면 해당 서비스로 이동합니다",JLabel.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(108, 220, 266, 65);
		frame.getContentPane().add(lblNewLabel_1);
		
		//체크아웃 버튼
		checkOutBtn = new JButton("체크아웃");
		checkOutBtn.setBounds(50, 407, 91, 23);
		checkOutBtn.addActionListener(new checkOutBtnActionListener());
		frame.getContentPane().add(checkOutBtn);
		//체크인 버튼
		checkInBtn = new JButton("체크인");
		checkInBtn.setBounds(342, 407, 91, 23);
		checkInBtn.addActionListener(new checkInBtnActionListener());
		frame.getContentPane().add(checkInBtn);
		
		frame.getContentPane().setLayout(null);	    	    
	    frame.pack();
	    
	    frame.setVisible(true);    
	}
	
	//체크아웃 버튼 눌렀을때 처리 될 이벤트
	private class checkOutBtnActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==checkOutBtn) {
				try {
					new UserReturn(); //체크아웃 프레임으로 이동
					frame.setVisible(false);					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "오류!","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				}
			}					            
		}
	}
	
	//체크인 버튼 눌렀을때 처리 될 이벤트
	private class checkInBtnActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==checkInBtn) {
				try {
					new UserRental(); //체크인 프레임으로 전환
					frame.setVisible(false);   
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "오류!","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				}
				
			}					            
		}
	}
	
}

//고객 상품 렌탈하는 프레임 (체크인)
class UserRental extends JFrame{
	private static final long serialVersionUID = 5982358401420003692L;
	
	    JFrame frame;
		ObjectOutputStream out=null;
		ObjectInputStream in=null;
		Manager act=null;
		
		private JTable table; //테이블
		private JTable Rtable; //대여 테이블

		//버튼
		private JButton choiceBtn; //물품 선택 버튼
		private JButton checkInBtn;//체크인 + 파일 저장 버튼
		private JButton cancelBtn;//물품 취소 버튼
		private JButton searchBtn; //검색 버튼
		private JButton f5Btn; //새로고침 버튼
		private JButton returnBtn; //뒤로가기 버튼
		//텍스트 필드
		private JTextField tName;
		private JTextField tPhone;
		private JTextField tReturnDay;
		private JTextField search;
		
		Calendar getToday = Calendar.getInstance(); //오늘 날짜
	 	String rentalDay = new SimpleDateFormat("yyyy-MM-dd").format(getToday.getTime());// 대여 일자 입력하기
	 	
		private String inputStr[]=new String[4];
		private String stockArr[]=new String[4];
		
		int choiceCount=0; //물품 선택 개수에 제한둘때 사용할 변수
		
		public UserRental() throws Exception {
			Dimension dim = new Dimension(500,660);
			frame = new JFrame("RentalService");
		    frame.setLocation(100, 100);
		    frame.setPreferredSize(dim);
		    
			String header[] = {"상품이름","상품코드","가격","재고"};
		    String contents[][] = {};
		      
		    DefaultTableModel model = new DefaultTableModel(contents, header);
		    table = new JTable(model); //재고 물품 보여줄 테이블
		    JScrollPane scrollpane = new JScrollPane(table);
		    scrollpane.setBounds(49, 36, 386, 127); //스크롤펜
		    frame.getContentPane().add(scrollpane);
		    
		    String header1[] = {"상품이름","상품코드","가격","수량"};
		    String contents1[][] = {};
		      
		    DefaultTableModel model1 = new DefaultTableModel(contents1, header1);
		    Rtable = new JTable(model1); //대여 물품 보여줄 테이블
		    JScrollPane scrollpane1 = new JScrollPane(Rtable);
		    scrollpane1.setBounds(49, 280, 386, 72); //스크롤펜
		    frame.getContentPane().add(scrollpane1);   
		    
		    //검색 버튼
		    searchBtn = new JButton("검색");
		    searchBtn.setBounds(280, 180, 80, 23);
		    searchBtn.addActionListener(new searchActionListener());
		    frame.getContentPane().add(searchBtn);
		    //새로고침 버튼
		    f5Btn = new JButton("🔃");
		    f5Btn.setBounds(90, 15, 55, 15);
		    f5Btn.addActionListener(new f5ActionListener());
		    frame.getContentPane().add(f5Btn);
		    //물품 선택 버튼
		    choiceBtn = new JButton("물품선택");
		    choiceBtn.setBounds(197, 210, 91, 23);
		    choiceBtn.addActionListener(new choiceActionListener());
		    frame.getContentPane().add(choiceBtn);   	     
		    //체크인 버튼 
		    checkInBtn = new JButton("체크인");
		    checkInBtn.setBounds(370, 570, 91, 23);
		    checkInBtn.addActionListener(new chechInActionListener());
		    frame.getContentPane().add(checkInBtn);		    
		    //뒤로 가기 버튼
		    returnBtn = new JButton("뒤로가기");
		    returnBtn.setBounds(50,570, 91, 23);
		    returnBtn.addActionListener(new returnActionListener());
		    frame.getContentPane().add(returnBtn);
		    //물품 취소 버튼
		    cancelBtn = new JButton("취소");
		    cancelBtn.setBounds(200, 380, 80, 23);
		    cancelBtn.addActionListener(new cancelActionListener());
		    frame.getContentPane().add(cancelBtn);
		    
		    //물품 목록 텍스트
		    JLabel lblNewLabel_4 = new JLabel("물품목록");
		    lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabel_4.setBounds(203, 11, 68, 15);
		    frame.getContentPane().add(lblNewLabel_4);	    	 
		    //고객 이름 텍스트
		    JLabel LabelName = new JLabel("이름");
		    LabelName.setHorizontalAlignment(SwingConstants.CENTER);
		    LabelName.setBounds(290, 417, 68, 20);
		    frame.getContentPane().add(LabelName);
		    //전화번호 텍스트
		    JLabel LabelPhone = new JLabel("전화번호");
		    LabelPhone.setHorizontalAlignment(SwingConstants.CENTER);
		    LabelPhone.setBounds(290, 452, 68, 20);
		    frame.getContentPane().add(LabelPhone); 
		    //오늘 날짜 텍스트
		    JLabel LabelPrice = new JLabel("오늘 날짜 : " + rentalDay);
		    LabelPrice.setHorizontalAlignment(SwingConstants.CENTER);
		    LabelPrice.setBounds(110, 485,150, 20);
		    frame.getContentPane().add(LabelPrice);
		    //반납 예정 일자 텍스트
		    JLabel LabelReturnDay = new JLabel("반납 예정 일자");
		    LabelReturnDay.setHorizontalAlignment(SwingConstants.CENTER);
		    LabelReturnDay.setBounds(265, 523, 150, 20);
		    frame.getContentPane().add(LabelReturnDay);
		    //장바구니 텍스트
		    JLabel lblNewLabel_5 = new JLabel("장바구니");
		    lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabel_5.setBounds(203, 250, 68, 15);
		    frame.getContentPane().add(lblNewLabel_5);
		    		    
		    //고객 이름 받는 텍스트 필드
		    tName = new JTextField(5);
		    tName.setBounds(120, 415, 165, 25);
		    frame.getContentPane().add(tName);
		    //전화번호 받는 텍스트 필드
		    tPhone = new JTextField(3);
		    tPhone.setBounds(120, 450, 165, 25);
		    frame.getContentPane().add(tPhone);
		    //반납 예정 일자 받는 텍스트 필드
		    tReturnDay = new JTextField(3);
		    tReturnDay.setBounds(120, 520, 165, 25);
		    frame.getContentPane().add(tReturnDay);
		    //검색 받는 텍스트 필드
		    search = new JTextField(5);
		    search.setBounds(120, 180, 150, 21);
		    frame.getContentPane().add(search);
		    
		    frame.getContentPane().setLayout(null);	    	    
		    frame.pack();
		    
		    try {
				in=new ObjectInputStream(new FileInputStream("output.dat"));// 오브젝트 입력 스트림을 생성
				act = new Manager(100, 100, in); // 매니저 생성자에게 전달
				in.close();//파일 닫음
			}
			catch (FileNotFoundException e) { //파일을 찾을 수 없을 때 예외처리
				act = new Manager(100, 100);
			}
		    
		    //고객에게 보여지는 상품 테이블은 재고가 0인 상품을 제외시켜야 함
		    for(int i=0; i<act.getProductCount(); i++) {
		    	if(act.productAt(i).isEmpty() == false) // 재고가 0일 경우
		    		continue; //for문 탈출
		    	else { // 재고가 0이 아닐 경우
		    		String arr[]= new String[4]; //String 받을 배열 선언하기
			    	
			    	//파일이 불러와졌을때 ProductList에 있던 내용이 테이블에 보여져야하기 때문에 각 항목을 arr[]에 저장
			    	arr[0]=act.productAt(i).getName();
			    	arr[1]=act.productAt(i).getCode();
			    	arr[2]=Integer.toString(act.productAt(i).getPrice());
			    	arr[3]=Integer.toString(act.productAt(i).getNumber());
			    	
			    	//이를 행에 추가함
			    	model.addRow(arr);
		    	}		    	
		    }    
		    //창 보이게 함
		    frame.setVisible(true);	    
		}
		
		//물품 취소 버튼 이벤트 처리
		private class cancelActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e){
				if(e.getSource()==cancelBtn) {		
					try {
						int row = Rtable.getSelectedRow(); //(클릭으로) 선택한 줄
						
						String code =act.productAt(act.searchCode((String)Rtable.getModel().getValueAt(row,1))).getCode();         	
		            	Product p = act.getProductList().get(act.searchCode(code)); //해당 인덱스의 product 객체
						p.addNumber(); //물품 다시 추가하기
						choiceCount--; //선택 물품 가능 개수 줄이기
						
						DefaultTableModel model1=(DefaultTableModel)table.getModel();
						model1.setNumRows(0); //테이블 비우기
						
						//재고 물품 테이블 재정비 (수량 올린 pdlist 불러와서 재고 물품 목록에 뿌려주기)
						for(int i=0; i<act.getProductCount(); i++) {
							if(act.productAt(i).isEmpty() == false) // 재고가 0일 경우 넘어가기
					    		continue;
							else {
								String arr[]= new String[4]; //String 받을 배열 선언하기
						    	
						    	//파일이 불러와졌을때 ProductList에 있던 내용이 테이블에 보여져야하기 때문에 각 항목을 arr[]에 저장
						    	arr[0]=act.productAt(i).getName();
						    	arr[1]=act.productAt(i).getCode();
						    	arr[2]=Integer.toString(act.productAt(i).getPrice());
						    	arr[3]=Integer.toString(act.productAt(i).getNumber());
						    	
						    	//이를 행에 추가함
						    	model1.addRow(arr);
							}	
						}
						
						//대여 물품 테이블에서 행 없애는거 처리
						if(Rtable.getSelectedRow() == -1) {
							return;
				        }
						else {
				            DefaultTableModel model=(DefaultTableModel)Rtable.getModel();
				            //담은 물품이 같은 종류로 여러개라면, 행 삭제가 아닌 수량 -1 감소처리
				            if(Integer.parseInt((String)model.getValueAt(row, 3))>1) {
				            	model.setValueAt(Integer.toString(
				            			Integer.parseInt((String)model.getValueAt(row, 3))-1), row, 3);
				            }
				            else {		            	
				            	model.removeRow(Rtable.getSelectedRow());//한개일때는 그냥 삭제
				            }				            	
						}
					}
					catch(Exception e1) {
						//취소 경고창
						JOptionPane.showMessageDialog(null, "취소할 물품이 없습니다!","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
					}					
				}
			}
		}

		//물품 선택 버튼 이벤트 처리
		private class choiceActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e){
				if(e.getSource()==choiceBtn) {
					try {	
						int row = table.getSelectedRow(); //(클릭으로)선택한 줄
						//table의 한 줄을 선택하고 그 줄의 값들을 stockArr에 저장한 뒤 Rtable에 추가함
			            stockArr[0] = (String)table.getModel().getValueAt(row,0); //입력받은 텍스트 배열로 가져오기
			            stockArr[1] = (String)table.getModel().getValueAt(row,1); //입력받은 텍스트 배열로 가져오기
			            stockArr[2] = (String)table.getModel().getValueAt(row,2); //입력받은 텍스트 배열로 가져오기
			            stockArr[3] = Integer.toString(1); //입력받은 텍스트 배열로 가져오기
			            
			            DefaultTableModel model=(DefaultTableModel)Rtable.getModel(); //렌트 테이블
			            DefaultTableModel model1=(DefaultTableModel)table.getModel(); //물품 테이블
			            
			            //같은 물품 3개 대여했을시에 테이블에 3개 추가되는게 아니라 수량이 1->2->3 으로 늘어나게 구현함
			            //물품 선택 버튼을 누르면 choiceCount가 1씩 증가함 (3 넘어가면 예외처리시킴)
			            if(choiceCount<3) {
			            	if(act.productAt(act.searchCode((String)table.getModel().
			            			getValueAt(row,1))).getNumber()>=1) { //대여할 물품이 있을시에
				            	model1.setValueAt(act.productAt(act.searchCode((String)table.getModel().
				            			getValueAt(row,1))).getNumber()-1,row, 3);//수량 1 줄이기
				            	
				            	String code =act.productAt(act.searchCode((String)table.getModel().getValueAt(row,1))).getCode(); //선택한 줄의 코드 가져오기        	
				            	Product p = act.getProductList().get(act.searchCode(code)); //해당 인덱스의 product 객체
								p.subNumber(); // 대여가 가능한지 확인 후 빌리기 (재고 1개 삭제)
								
								model.addRow(stockArr); //테이블에 줄 추가하기 (보이기)	
								choiceCount++;
								for(int k=0; k<model.getRowCount()-1; k++) {
									if(model.getRowCount()==1) { //처음 장바구니 추가 됐을때는 중복 검사 할 필요 없음
										continue; //for문 탈출
									}
									for(int j=0; j<model.getRowCount()-1;j++) {
										if(code.equals(model.getValueAt(k, 1))) { //두번째 부터는 중복 검사 해줘야 함																			
											model.removeRow(model.getRowCount()-1);//중복이라면 그 줄 삭제
											//기존 동일 대여 물품에 수량 +1 해주기
											model.setValueAt(Integer.toString(Integer.parseInt((String)model.getValueAt(k, 3))+1), k, 3); //수량 +1된 값으로 수정하기
										}
									}	
								}		
				            }
				            else
				            	throw new Exception ("0보다 작아짐"); //재고가 0보다 작은데 빌리려고 한다면 예외처리
			            }
			            else
			            	throw new Exception ("물품은 3개까지만"); //choiceCount 수가 3보다 커지면 예외처리
      
					}			
					//예외처리
					catch (Exception e2) {
						if(e2.getMessage()=="0보다 작아짐")
							JOptionPane.showMessageDialog(null, "재고가 없습니다.","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);										
						else if(e2.getMessage()=="물품은 3개까지만")
							JOptionPane.showMessageDialog(null, "대여는 3개까지 가능합니다.","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);										
						else
							JOptionPane.showMessageDialog(null, "물품을 선택해주세요!","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);				
					}					            
				}
			}
		}
	
		//체크인 이벤트 처리
		private class chechInActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e){
				if(e.getSource()==checkInBtn) {
				try {
					//고객 정보 입력 받기
					inputStr[0] = tName.getText(); //입력받은 텍스트 배열로 가져오기
		            inputStr[1] = tPhone.getText(); //입력받은 텍스트 배열로 가져오기
		            inputStr[2] = tReturnDay.getText(); //입력받은 텍스트 배열로 가져오기
		            
		            User u1; //유저 객체 생성
					u1= new User(inputStr[0], inputStr[1], rentalDay, inputStr[2]);
		            act.checkPhone(u1); //동일한 유저가 아닌지 체크
		            
					tName.setText(""); //상품 추가 후 텍스트 박스 공백으로 만들기
		            tPhone.setText(""); //상품 추가 후 텍스트 박스 공백으로 만들기
		            tReturnDay.setText(""); //상품 추가 후 텍스트 박스 공백으로 만들기
		            
		            DefaultTableModel model=(DefaultTableModel)Rtable.getModel(); //렌트 테이블
					for(int i = 0; i < choiceCount; i++)
					{
						//같은 항목 물품 개수가 2개 이상이라면
						if(Integer.parseInt(String.valueOf(model.getValueAt(i, 3)))>1) {
							String rentalCode = (String)model.getValueAt(i, 1); //코드
							int amount =  Integer.parseInt((String)model.getValueAt(i, 2)); //금액
							u1.addProduct(rentalCode, amount); // 대여 물품 배열에 추가
							model.setValueAt(Integer.parseInt(String.valueOf(model.getValueAt(i, 3)))-1, i, 3); //수량 1 줄여주기
							//같은 항목 물품 개수가 1개 이상이므로
							//테이블의 같은 줄을 한번 더 돌면서 addProduct 해주어야 하기 때문에 i값과 choiceCount값을 1 줄임
							i--;
							choiceCount--;
						}
						//동일 물품 없이 물품 수량이 1이라면
						else {
							String rentalCode = (String)model.getValueAt(i, 1); //코드
							int amount =  Integer.parseInt((String)model.getValueAt(i, 2));//금액
							u1.addProduct(rentalCode, amount); // 대여 물품 배열에 추가
						}
					}				
					act.addUser(u1); // 체크인 하기
					
					//체크인 시 파일 저장 (체크인 한 사람 데이터 날아가면 안됨, 파일 저장 필요)
					out=new ObjectOutputStream(new FileOutputStream("output.dat"));
					act.saveToFile(out);
					
					model.setNumRows(0); //렌탈 테이블 비우기 (체크인이 완료되었기 때문)
					JOptionPane.showMessageDialog(null, "체크인이 완료되었습니다!","INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);				
					new ServiceStart(); //시작화면으로 돌아감
					frame.setVisible(false); //프레임 안보이게 하기					
					}
					//예외처리
					catch(IOException ioe){
						//파일 저장 경고창
						JOptionPane.showMessageDialog(null, "파일 저장에서 오류가 발생했습니다!","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
					}				
					//가격에 문자 넣었을때 예외처리 (ex. int 부분에 string 넣었을때)
					catch(NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "잘못된 입력입니다!","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
					}
					//동일한 핸드폰 고객 등록하였을때 예외처리
					catch (Exception e2) {
						if(e2.getMessage()=="checkPhone에서 오류 발생");
							JOptionPane.showMessageDialog(null, "이미 체크인 된 고객입니다!","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);				
					}			
					finally {
						try  {
							out.close();//파일 닫기
						}
						catch (Exception e1) {
						}
					}	
				}
			}
		}
		
		
		//검색 버튼 이벤트 처리
		private class searchActionListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==searchBtn) {
					try {
						String searchName = search.getText(); //입력받은 텍스트 배열로 가져오기
						search.setText("");//텍스트 필드 빈칸 만들어주기				
						DefaultTableModel model=(DefaultTableModel)table.getModel();
						
						//검색결과와 일치하는 행 추가하기
						for(int i=0; i<act.getProductCount();i++) {
							if(act.productAt(i).getName().contains(searchName)||act.productAt(i).getCode().contains(searchName)){ //물품 이름 검색으로 수정 + 물품 코드로 검색 추가 (12/01)
								model.setNumRows(0); //테이블 비우기
								String arr[]= new String[4];
								//파일이 불러와졌을때 ProductList에 있던 내용이 테이블에 보여져야하기 때문에 각 항목을 arr[]에 저장
						    	arr[0]=act.productAt(i).getName();
						    	arr[1]=act.productAt(i).getCode();
						    	arr[2]=Integer.toString(act.productAt(i).getPrice());
						    	arr[3]=Integer.toString(act.productAt(i).getNumber());					    	
						    	//이를 행에 추가함
						    	model.addRow(arr);		
							}
						}												
					}
					//예외처리
					catch(Exception e1) {
						//검색 경고창
						JOptionPane.showMessageDialog(null, "해당 상품이 존재하지 않습니다!","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		}
		
		//새로고침 버튼 이벤트 처리
		private class f5ActionListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==f5Btn) {
					DefaultTableModel model=(DefaultTableModel)table.getModel();
					model.setNumRows(0); //테이블 비우기
						for(int i=0; i<act.getProductCount(); i++) {
							if(act.productAt(i).isEmpty() == false) // 재고가 0일 경우
					    		continue;
							else {
								String arr[]= new String[4]; //String 받을 배열 선언하기
						    	
						    	//파일이 불러와졌을때 ProductList에 있던 내용이 테이블에 보여져야하기 때문에 각 항목을 arr[]에 저장
						    	arr[0]=act.productAt(i).getName();
						    	arr[1]=act.productAt(i).getCode();
						    	arr[2]=Integer.toString(act.productAt(i).getPrice());
						    	arr[3]=Integer.toString(act.productAt(i).getNumber());
						    	
						    	//이를 행에 추가함
						    	model.addRow(arr);
							}					    	
						}
				}    
			}
		}
		
		
		//뒤로 가기 버튼 이벤트 처리
		private class returnActionListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==returnBtn) {
					new CheckInOrOut(); //체크인 or 체크아웃 물어보는 화면으로 back
					frame.setVisible(false);	  
				}
			}
		}
		
		
 
}


//고객 상품 반납하는 프레임 (체크아웃)
class UserReturn extends JFrame{
	private static final long serialVersionUID = 5982358401420003692L;
		
	    JFrame frame;
		ObjectOutputStream out=null;
		ObjectInputStream in=null;
		Manager act=null;
		
		private JTable table; //대여 테이블

		//버튼
		private JButton checkOutBtn;//체크아웃 + 파일 저장 버튼
		private JButton returnBtn; //뒤로가기 버튼
		
		private String phone; //고객 핸드폰 번호 받을 변수
		Calendar getToday = Calendar.getInstance();
		//대여 일자 입력하기
	 	String rentalDay = new SimpleDateFormat("yyyy-MM-dd").format(getToday.getTime());
	 	
		private String arr[]= new String[4]; //String 받을 배열 선언하기
		
		public UserReturn() throws Exception {
			try {
				in=new ObjectInputStream(new FileInputStream("output.dat"));// 오브젝트 입력 스트림을 생성
				act = new Manager(100, 100, in); // 매니저 생성자에게 전달
				in.close();//파일 닫음
				
				phone = JOptionPane.showInputDialog("핸드폰 번호를 입력하세요."); //핸드폰 번호 받아오기
				if(phone==null) { //cancel 버튼 눌렀을때 null을 반환함
					throw new Exception ("cancel"); //메인화면으로 돌아가게 익셉션 처리
				}
				act.searchUser(phone); //해당 핸드폰 번호가 유저 리스트에 존재하는지 검사 (없으면 익셉션)

				Dimension dim = new Dimension(500,500);
				frame = new JFrame("RentalService");
			    frame.setLocation(100, 100);
			    frame.setPreferredSize(dim);
			    
			    //뒤로가기 버틈
				returnBtn = new JButton("RETURN");
				returnBtn.setBounds(50, 407, 91, 23);
				returnBtn.addActionListener(new returnActionListener());
				frame.getContentPane().add(returnBtn);
				//체크아웃 버튼
				checkOutBtn = new JButton("체크아웃");
				checkOutBtn.setBounds(342, 407, 91, 23);
				checkOutBtn.addActionListener(new chechOutActionListener());
				frame.getContentPane().add(checkOutBtn);    

				//고객 정보 텍스트
			    JLabel lblNewLabel_4 = new JLabel("고객정보");
			    lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 20));
			    lblNewLabel_4.setBounds(203, 15, 100, 50);
			    frame.getContentPane().add(lblNewLabel_4);		    
			    //대여 물품 리스트 텍스트
			    JLabel lblNewLabel_5 = new JLabel("대여 물품 리스트");
			    lblNewLabel_5.setBounds(198, 48, 150, 30);
			    frame.getContentPane().add(lblNewLabel_5);
			    		    
			    //대여 상품 출력해줄 테이블
			    String header[] = {"상품이름","상품코드","가격","수량"};
			    String contents[][] = {};
			      
			    DefaultTableModel model = new DefaultTableModel(contents, header);
			    table = new JTable(model);
			    JScrollPane scrollpane = new JScrollPane(table);
			    scrollpane.setBounds(49, 80, 386, 71); //스크롤펜
			    frame.getContentPane().add(scrollpane);
			    
			    //대여 물품 테이블에 보여주기
			    for(int i=0; i<act.userAt(act.searchUser(phone)).getRentalCount(); i++) {
			    	//파일이 불러와졌을때 ProductList에 있던 내용이 테이블에 보여져야하기 때문에 각 항목을 arr[]에 저장
					arr[0]=act.productAt(act.searchCode(act.userAt(act.searchUser(phone)).codeAt(i))).getName(); //대여 물품 이름
					arr[1]=act.userAt(act.searchUser(phone)).codeAt(i); //대여 물품 코드
					arr[2]=Integer.toString(act.userAt(act.searchUser(phone)).payAt(i)); //대여 물품 가격
					arr[3]=Integer.toString(1); //대여 물품 개수
					    	
					 //이를 행에 추가함
					 model.addRow(arr);	
			    } 	
				
				//이름 출력 텍스트
			    JLabel userName = new JLabel("이름: "+act.userAt(act.searchUser(phone)).getName());
			    userName.setBounds(50, 170, 150, 30);
			    userName.setFont(new Font("굴림", Font.BOLD, 15));
			    frame.getContentPane().add(userName);
			    //핸드폰 번호 출력 텍스트
			    JLabel userPhone = new JLabel("핸드폰 번호: "+act.userAt(act.searchUser(phone)).getPhone());
			    userPhone.setBounds(50, 220, 300, 30);
			    userPhone.setFont(new Font("굴림", Font.BOLD, 15));
			    frame.getContentPane().add(userPhone);
			    //대여일 출력 텍스트
			    JLabel rentalDay = new JLabel("대여일: "+act.userAt(act.searchUser(phone)).getRentalDay());
			    rentalDay.setBounds(50, 270, 150, 30);
			    rentalDay.setFont(new Font("굴림", Font.BOLD, 15));
			    frame.getContentPane().add(rentalDay);
			    //반납 예정일 출력 텍스트
			    JLabel returnDay = new JLabel("반납 예정일: "+act.userAt(act.searchUser(phone)).getReturnDay());
			    returnDay.setBounds(50, 320, 300, 30);
			    returnDay.setFont(new Font("굴림", Font.BOLD, 15));
			    frame.getContentPane().add(returnDay);
			    //계산된 가격 출력 텍스트 (최종금액)
			    JLabel money = new JLabel("납부하실 금액: "+act.userAt(act.searchUser(phone)).pay());
			    money.setBounds(270, 300, 150, 30);
			    money.setFont(new Font("굴림", Font.BOLD, 15));
			    frame.getContentPane().add(money);
			    
			    int Tmoney = 0; //물품 합산 가격만 담는 변수
				for(int i = 0; i < act.userAt(act.searchUser(phone)).getRentalCount(); i++)
				{
					Tmoney += act.userAt(act.searchUser(phone)).payAt(i); //물품 합산 가격 계산
				}

				getToday.setTime(new Date());
				
				// 대여 일자 불러오기
				Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(act.userAt(act.searchUser(phone)).getRentalDay());
				Calendar rentalDate = Calendar.getInstance();
				rentalDate.setTime(date1);
				
				// 반납 예정 일자 불러오기
				Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(act.userAt(act.searchUser(phone)).getReturnDay());
				Calendar returnDate = Calendar.getInstance();
				returnDate.setTime(date2);
				
				//계산된 가격 출력 텍스트
			    JLabel Receipt = new JLabel("~~~ 전자 영수증 ~~~");
			    Receipt.setFont(new Font("굴림", Font.BOLD, 15));
			    Receipt.setBounds(255, 170, 200, 30);
			    frame.getContentPane().add(Receipt);
			    
				int day1 = (int) ((returnDate.getTimeInMillis() - rentalDate.getTimeInMillis()) / (1000 * 60 * 60 * 24));
				int day2 = (int) ((getToday.getTimeInMillis() - rentalDate.getTimeInMillis()) / (1000 * 60 * 60 * 24));				
				
				if (day1 == day2) { //반납 예정 날짜에 반납
					//계산된 가격 출력 텍스트
				    JLabel receipt = new JLabel("정상반납입니다. 대여일수: "+(day1 + 1));
				    receipt.setBounds(250, 240, 300, 30);
				    frame.getContentPane().add(receipt);
				}
				else if (day1 > day2) { //반납 예정 날짜보다 빨리 반납
					//계산된 가격 출력 텍스트
				    JLabel receipt = new JLabel("정상반납입니다. 대여일수: "+(day2 + 1));
				    receipt.setBounds(250, 240, 300, 30);
				    frame.getContentPane().add(receipt);
				}
				else { //반납 예정 날짜보다 늦게 반납
					//계산된 가격 출력 텍스트
				    JLabel receipt = new JLabel("연체반납입니다. 연체료(하루 대여료)가 추가됩니다. 계산된 대여일수: "+(day2 + 2));
				    receipt.setBounds(250, 240, 300, 30);
				    frame.getContentPane().add(receipt);
				}
							
				//계산된 가격 출력 텍스트
			    JLabel mainReceipt = new JLabel("물건 값: "+ Tmoney);
			    mainReceipt.setBounds(250, 220, 300, 30);
			    frame.getContentPane().add(mainReceipt);
			    //계산된 가격 출력 텍스트
			    JLabel mainReceipt1 = new JLabel(" 최종 금액 계산: "+Tmoney+" * 대여일수");
			    mainReceipt1.setBounds(247, 270, 300, 30);
			    frame.getContentPane().add(mainReceipt1);
			    
			    
			    frame.getContentPane().setLayout(null);	    	    
			    frame.pack();
			    //창 보이게 함
			    frame.setVisible(true);	    
			}
			catch (FileNotFoundException e) { //파일을 찾을 수 없을 때 예외처리
				act = new Manager(100, 100);
			}
			catch(Exception e2) {
				if(e2.getMessage()=="cancel");
					new CheckInOrOut();	
				if(e2.getMessage()=="고객 객체 검색 함수에서 오류 발생") {
					JOptionPane.showMessageDialog(null, "해당 고객이 존재하지 않습니다","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
					new CheckInOrOut();
				}	
			} 		    
		}
		

		//체크아웃 + 파일저장 이벤트 처리
		private class chechOutActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e){
				if(e.getSource()==checkOutBtn) {
					try {				
						act.subUser(act.searchUser(phone)); //체크아웃 시키기
						//파일 저장
						out=new ObjectOutputStream(new FileOutputStream("output.dat"));
						act.saveToFile(out);
						//알림창 출력
						JOptionPane.showMessageDialog(null, "체크아웃이 완료되었습니다.", "메시지", JOptionPane.INFORMATION_MESSAGE);
						frame.setVisible(false);
						new ServiceStart(); //시작화면으로 돌아가기
					}
					catch(IOException ioe){
						//파일 저장 경고창
						JOptionPane.showMessageDialog(null, "파일 저장에서 오류가 발생했습니다!","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
					}
					catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "오류!","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
					}
					finally {
						try  {
							out.close();//파일 닫기
						}
						catch (Exception e1) {
						}
					}					
				}
			}
		}
		
		//뒤로 가기 버튼 이벤트 처리
		private class returnActionListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==returnBtn) {
					new CheckInOrOut(); //체크인 or 체크아웃 물어보는 화면으로 back
					frame.setVisible(false);	  
				}
			}
		}
		
		
}

//(관리자)고객관리인지 물품관리인지 물어보는 프레임
class UserOrProduct extends JFrame{
	private static final long serialVersionUID = 654121017666148896L;
	
	JFrame frame;
	
	private JButton userBtn;//고객관리 버튼
	private JButton productBtn;//물품관리 버튼
	
	public UserOrProduct() {
		Dimension dim = new Dimension(500,500);
		frame = new JFrame("RentalService");
	    frame.setLocation(100, 100);
	    frame.setPreferredSize(dim);
	    
	    //텍스트
	    JLabel lblNewLabel = new JLabel("관리자 전용 화면입니다");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 30));
		lblNewLabel.setBounds(64, 60, 358, 76);
		frame.getContentPane().add(lblNewLabel);
		JLabel lblNewLabel_1 = new JLabel("버튼을 누르면 해당 서비스로 이동합니다",JLabel.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(108, 220, 266, 65);
		frame.getContentPane().add(lblNewLabel_1);
		
		//고객관리 버튼
		userBtn = new JButton("고객관리");
		userBtn.setBounds(50, 407, 91, 23);
		userBtn.addActionListener(new userActionListener());
		frame.getContentPane().add(userBtn);
		//물품관리 버튼
		productBtn = new JButton("물품관리");
		productBtn.setBounds(342, 407, 91, 23);
		productBtn.addActionListener(new productActionListener());
		frame.getContentPane().add(productBtn);
		
		frame.getContentPane().setLayout(null);	    	    
	    frame.pack();
	    
	    frame.setVisible(true);    
	}
	
	//유저관리 버튼 눌렀을때 처리 될 이벤트
	private class userActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==userBtn) {	
				try {
					new ManageUser();//고객관리 프레임으로 전환
					frame.setVisible(false);
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "오류!","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				}			
			}					            
		}
	}
	
	//물품관리 버튼 눌렀을때 처리 될 이벤트
    private class productActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==productBtn) {
				try {
					new ManageProduct(); //물품 관리 프레임으로 전환
					frame.setVisible(false);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "오류!","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				}				
			}					            
		}
	}
 
}


//매니저 물품 관리 프레임
class ManageProduct extends JFrame{
	private static final long serialVersionUID = 5982358401420003692L;
	
	JFrame frame;
	ObjectOutputStream out=null;
	ObjectInputStream in=null;
	Manager act=null;
	
	private JTable table; //테이블

	//버튼
	private JButton deleteBtn; //삭제 버튼
	private JButton addBtn; //추가 버튼
	private JButton fileSaveBtn;//파일 저장 버튼
	private JButton correctBtn;//물품 수정 버튼
	private JButton increaseBtn;//재고 증가 버튼
	private JButton decreaseBtn; //재고 삭제 버튼
	private JButton returnBtn; //뒤로 가기 버튼
	private JButton searchBtn; //검색 버튼
	private JButton f5Btn; //새로고침 버튼
	
	//텍스트 필드
	private JTextField tName;
	private JTextField tCode;
	private JTextField tPrice;
	private JTextField tCount;
	private JTextField search;
	private JTextField stock;
	
	private String inputStr[]=new String[4];
		
	public ManageProduct() throws Exception {
		try {
			in=new ObjectInputStream(new FileInputStream("output.dat"));// 오브젝트 입력 스트림을 생성
			act = new Manager(100, 100, in); // 매니저 생성자에게 전달
			in.close();//파일 닫음
		}
		catch (FileNotFoundException e) { //파일을 찾을 수 없을 때 예외처리
			act = new Manager(100, 100);
		}
		
		//물품 관리 테이블
		Dimension dim = new Dimension(500,500);
		frame = new JFrame("RentalService");
	    frame.setLocation(100, 100);
	    frame.setPreferredSize(dim);

		String header[] = {"상품이름","상품코드","가격","재고"};
	    String contents[][] = {};
	      
	    DefaultTableModel model = new DefaultTableModel(contents, header);
	    table = new JTable(model);
	    JScrollPane scrollpane = new JScrollPane(table);
	    scrollpane.setBounds(49, 36, 386, 127); //스크롤펜
	    frame.getContentPane().add(scrollpane);
	    
	    //물품 삭제 버튼
	    deleteBtn = new JButton("물품삭제");
	    deleteBtn.setBounds(50, 180, 91, 23);
	    deleteBtn.addActionListener(new delActionListener());
	    frame.getContentPane().add(deleteBtn);
	    //물품 추가 버튼
	    addBtn = new JButton("물품추가");
	    addBtn.setBounds(130, 374, 91, 23);
	    addBtn.addActionListener(new AddActionListener());
	    frame.getContentPane().add(addBtn);	    
	    //파일 저장 버튼 
	    fileSaveBtn = new JButton("파일저장");
	    fileSaveBtn.setBounds(370, 423, 91, 23);
	    fileSaveBtn.addActionListener(new saveActionListener());
	    frame.getContentPane().add(fileSaveBtn);	    
	    //물품 수정 버튼
	    correctBtn = new JButton("물품수정");
	    correctBtn.setBounds(230, 374, 91, 23);
	    correctBtn.addActionListener(new correctActionListener());
	    frame.getContentPane().add(correctBtn);	    
	    //재고 증가 버튼	
	    increaseBtn = new JButton("재고증가");
	    increaseBtn.setBounds(250, 180, 91, 23);
	    increaseBtn.addActionListener(new increaseActionListener());
	    frame.getContentPane().add(increaseBtn);	    
	    //재고 감소 버튼 
	    decreaseBtn = new JButton("재고삭제");
	    decreaseBtn.setBounds(350, 180, 91, 23);
	    decreaseBtn.addActionListener(new decreaseActionListener());
	    frame.getContentPane().add(decreaseBtn);	    
	    //뒤로 가기 버튼
	    returnBtn = new JButton("뒤로가기");
	    returnBtn.setBounds(370,390, 91, 23);
	    returnBtn.addActionListener(new returnActionListener());
	    frame.getContentPane().add(returnBtn);
	    //검색 버튼
	    searchBtn = new JButton("검색");
	    searchBtn.setBounds(375, 15, 60, 15);
	    searchBtn.addActionListener(new searchActionListener());
	    frame.getContentPane().add(searchBtn);
	    //새로고침 버튼
	    f5Btn = new JButton("🔃");
	    f5Btn.setBounds(90, 15, 55, 15);
	    f5Btn.addActionListener(new f5ActionListener());
	    frame.getContentPane().add(f5Btn);
	    
	    //물품 목록 텍스트
	    JLabel lblNewLabel_4 = new JLabel("물품목록");
	    lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_4.setBounds(203, 11, 68, 15);
	    frame.getContentPane().add(lblNewLabel_4);	    
	    //물품추가&수정 텍스트
	    JLabel lblNewLabel_5 = new JLabel("물품추가&수정");
	    lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_5.setBounds(176, 229, 106, 15);
	    frame.getContentPane().add(lblNewLabel_5);       
	    //상품이름 텍스트
	    JLabel LabelName = new JLabel("상품이름");
	    LabelName.setHorizontalAlignment(SwingConstants.CENTER);
	    LabelName.setBounds(290, 253, 68, 15);
	    frame.getContentPane().add(LabelName);
	    //상품코드 텍스트
	    JLabel LabelCode = new JLabel("상품코드");
	    LabelCode.setHorizontalAlignment(SwingConstants.CENTER);
	    LabelCode.setBounds(290, 284, 68, 15);
	    frame.getContentPane().add(LabelCode);
	    //가격 텍스트
	    JLabel LabelPrice = new JLabel("가격");
	    LabelPrice.setHorizontalAlignment(SwingConstants.CENTER);
	    LabelPrice.setBounds(290, 315, 68, 15);
	    frame.getContentPane().add(LabelPrice);
	    //개수 텍스트
	    JLabel LabelCount = new JLabel("개수");
	    LabelCount.setHorizontalAlignment(SwingConstants.CENTER);
	    LabelCount.setBounds(290, 346, 68, 15);
	    frame.getContentPane().add(LabelCount);
	    //재고 몇개 텍스트
	    JLabel LabelStock = new JLabel("개");
	    LabelStock.setHorizontalAlignment(SwingConstants.CENTER);
	    LabelStock.setBounds(200, 184, 68, 15);
	    frame.getContentPane().add(LabelStock);
	    //오늘의 매출액 텍스트
	    JLabel LabelRevenue= new JLabel("오늘의 매출액: "+act.getRevenue()+"원");
	    LabelRevenue.setHorizontalAlignment(SwingConstants.CENTER);
	    LabelRevenue.setBounds(5, 423, 150, 15);
	    frame.getContentPane().add(LabelRevenue);
	    
	    //물품이름 받는 텍스트 필드
	    tName = new JTextField(5);
	    tName.setBounds(182, 250, 100, 21);
	    frame.getContentPane().add(tName);
	    //물품코드 받는 텍스트 필드
	    tCode = new JTextField(3);
	    tCode.setBounds(182, 281, 100, 21);
	    frame.getContentPane().add(tCode);
	    //가격 받는 텍스트 필드
	    tPrice = new JTextField(3);
	    tPrice.setBounds(182, 312, 100, 21);
	    frame.getContentPane().add(tPrice);
	    //개수 받는 텍스트 필드
	    tCount = new JTextField(3);
	    tCount.setBounds(182, 343, 100, 21);
	    frame.getContentPane().add(tCount);
	    //검색 받는 텍스트 필드
	    search = new JTextField(5);
	    search.setBounds(300, 15, 68, 15);
	    frame.getContentPane().add(search);
	    //재고 몇개 텍스트 필드
	    stock = new JTextField(5);
	    stock.setBounds(175, 182, 50, 20);
	    frame.getContentPane().add(stock);
	    
	    frame.getContentPane().setLayout(null);	    	    
	    frame.pack();
	    
	    
	    
	    for(int i=0; i<act.getProductCount(); i++) {
	    	String arr[]= new String[4]; //String 받을 배열 선언하기
	    	
	    	//파일이 불러와졌을때 ProductList에 있던 내용이 테이블에 보여져야하기 때문에 각 항목을 arr[]에 저장
	    	arr[0]=act.productAt(i).getName();
	    	arr[1]=act.productAt(i).getCode();
	    	arr[2]=Integer.toString(act.productAt(i).getPrice());
	    	arr[3]=Integer.toString(act.productAt(i).getNumber());
	    	
	    	//이를 행에 추가함
	    	model.addRow(arr);
	    }    
	    //창 보이게 함
	    frame.setVisible(true);	    
	}
	
	//물품 추가 버튼 이벤트 처리
	private class AddActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==addBtn) {
				try {
	            inputStr[0] = tName.getText(); //입력받은 텍스트 배열로 가져오기
	            inputStr[1] = tCode.getText(); //입력받은 텍스트 배열로 가져오기
	            inputStr[2] = tPrice.getText(); //입력받은 텍스트 배열로 가져오기
	            inputStr[3] = tCount.getText(); //입력받은 텍스트 배열로 가져오기
	            
	            //상품 추가하기
	            Product p1; //product 객체 만들기
            	p1 = new Product(inputStr[0], inputStr[1], 
					Integer.parseInt(inputStr[3]), Integer.parseInt(inputStr[2]));			
				act.addProduct(p1); //상품 추가하기
				
	            DefaultTableModel model=(DefaultTableModel)table.getModel();
	            model.addRow(inputStr); //테이블에 줄 추가하기 (보이기)
	            
	            tName.setText(""); //상품 추가 후 텍스트 박스 공백으로 만들기
	            tCode.setText("");//상품 추가 후 텍스트 박스 공백으로 만들기
	            tPrice.setText("");//상품 추가 후 텍스트 박스 공백으로 만들기
	            tCount.setText("");//상품 추가 후 텍스트 박스 공백으로 만들기               
	            	
				}
				//가격에 문자 넣었을때 예외처리 (int 부분에 string 넣었을때)
				catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "잘못된 입력입니다!","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				}
				//동일한 코드 상품 등록하였을때 예외처리
				catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "같은 코드의 상품은 추가 할 수 없습니다!","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);				
				}					            
			}
		}
	}
	
	//물품 삭제 버튼 이벤트 처리
	private class delActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==deleteBtn) {
				try {
					int row = table.getSelectedRow(); //(클릭으로) 선택한 줄
					//선택한 줄의 1번 내용 가져오기 (여기서는 물품코드임)
					//파라메터로 상품 코드 받아서 ProductList 에서 물품 삭제하기
					act.subProduct((String)table.getModel().getValueAt(row,1)); 
					if(table.getSelectedRow() == -1) {
						return;
			        }
					else {
			            DefaultTableModel model=(DefaultTableModel)table.getModel();
						model.removeRow(table.getSelectedRow());
					}
				}
				catch(Exception e1) {
					//파일 삭제 경고창
					JOptionPane.showMessageDialog(null, "삭제할 물품이 없습니다!","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				}
			
			}
		}
	}
	
	//파일 저장 이벤트 처리
	private class saveActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==fileSaveBtn) {
				try {					
					out=new ObjectOutputStream(new FileOutputStream("output.dat")); //오브젝트 아웃 스트림으로 변경
					act.saveToFile(out);
				}
				catch(IOException ioe){
					//파일 저장 경고창
					JOptionPane.showMessageDialog(null, "파일 저장에서 오류가 발생했습니다!","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				}
				finally {
					try  {
						out.close();//파일 닫기
					}
					catch (Exception e1) {
					}
				}			
			}
		}
	}
	
	//물품 수정 버튼 이벤트 처리
	private class correctActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==correctBtn) {
				try {
					int row = table.getSelectedRow(); //(클릭으로)선택한 줄
					inputStr[0] = tName.getText(); //입력받은 텍스트 배열로 가져오기
		            inputStr[1] = tCode.getText(); //입력받은 텍스트 배열로 가져오기
		            inputStr[2] = tPrice.getText(); //입력받은 텍스트 배열로 가져오기
		            inputStr[3] = tCount.getText(); //입력받은 텍스트 배열로 가져오기
		            
		            //상품 추가하기
		            Product p1; //product 객체 만들기
	            	p1 = new Product(inputStr[0], inputStr[1], 
						Integer.parseInt(inputStr[3]), Integer.parseInt(inputStr[2]));			
					act.setProduct(act.searchCode((String)table.getModel().getValueAt(row,1)),p1); //상품 수정한거 ProductList에 업데이트
		            DefaultTableModel model=(DefaultTableModel)table.getModel();
		            
		            //테이블에서row 위치에 새로운 행을 추가시키고
		            //뒤로 밀려난 기존의 행을 삭제시킴
		            model.insertRow(row, inputStr);
		            model.removeRow(row+1);
		            
		            //상품 추가 후 텍스트 박스 공백으로 만들기
		            tName.setText("");
		            tCode.setText("");
		            tPrice.setText("");
		            tCount.setText(""); 
				}
				catch(Exception e1) {
					//파일 수정 경고창
					JOptionPane.showMessageDialog(null, "상품을 수정하지 못했습니다!","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				}		
			}
		}
	}
	
	//재고 증가 버튼 이벤트 처리
	private class increaseActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==increaseBtn) {
				try {
					int row = table.getSelectedRow(); //(클릭으로)선택한 줄
					String stockcount = stock.getText(); //입력받은 텍스트 배열로 가져오기
					act.increaseStock(act.searchCode((String)table.getModel().getValueAt(row,1))
							,Integer.parseInt(stockcount)); //재고 증가 (ProductList에 반영)
					stock.setText(""); //텍스트 필드 빈칸 만들어주기
					int finalStock=Integer.parseInt((String)table.getValueAt(row,3))+Integer.parseInt(stockcount); //증가한 재고 수 계산하는
					table.setValueAt(Integer.toString(finalStock), row, 3); //테이블 재고 값 수정해서 보여주기
				}
				catch(Exception e1) {
					//재고 증가 경고창
					JOptionPane.showMessageDialog(null, "재고 증가가 불가능합니다!","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				}			
			}
		}
	}
	
	//재고 감소 버튼 이벤트 처리
	private class decreaseActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==decreaseBtn) {
				try {
					int row = table.getSelectedRow(); //(클릭으로)선택한 줄
					String stockcount = stock.getText(); //입력받은 텍스트 배열로 가져오기
					act.decreaseStock(act.searchCode((String)table.getModel().getValueAt(row,1)),
							Integer.parseInt(stockcount)); //재고 감소 (ProductList에 반영)
					stock.setText("");//텍스트 필드 빈칸 만들어주기
					int finalStock=Integer.parseInt((String)table.getValueAt(row,3))-Integer.parseInt(stockcount); //감소한 재고 수 계산하는
					table.setValueAt(Integer.toString(finalStock), row, 3);//테이블 재고 값 수정해서 보여주기
				}
				catch(Exception e1) {
					//재고 감소 경고창
					JOptionPane.showMessageDialog(null, "재고 감소가 불가능합니다!","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				}			
			}
		}
	}
	
	
	
	
	//검색 버튼 이벤트 처리
	private class searchActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==searchBtn) {
				try {
					String searchName = search.getText(); //입력받은 텍스트 배열로 가져오기
					search.setText("");//텍스트 필드 빈칸 만들어주기		
					DefaultTableModel model=(DefaultTableModel)table.getModel();
										
					//검색결과와 일치하는 행 추가하기
					for(int i=0; i<act.getProductCount();i++) {
						if(act.productAt(i).getName().contains(searchName)||act.productAt(i).getCode().contains(searchName)){ //물품 이름 검색으로 수정 + 물품 코드로 검색 추가 (12/01)
							model.setNumRows(0); //테이블 비우기
							String arr[]= new String[4];
							//파일이 불러와졌을때 ProductList에 있던 내용이 테이블에 보여져야하기 때문에 각 항목을 arr[]에 저장
					    	arr[0]=act.productAt(i).getName();
					    	arr[1]=act.productAt(i).getCode();
					    	arr[2]=Integer.toString(act.productAt(i).getPrice());
					    	arr[3]=Integer.toString(act.productAt(i).getNumber());					    	
					    	//이를 행에 추가함
					    	model.addRow(arr);		
						}
					}
					
					
				}
				catch(Exception e1) {
					//검색 경고창
					JOptionPane.showMessageDialog(null, "해당 상품이 존재하지 않습니다!","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				}
			}
		}
	}
	
	
	
	
	
	//새로고침 버튼 이벤트 처리
	private class f5ActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==f5Btn) {
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				model.setNumRows(0); //테이블 비우기
				for(int i=0; i<act.getProductCount(); i++) {
			    	String arr[]= new String[4]; //String 받을 배열 선언하기
			    	
			    	//파일이 불러와졌을때 ProductList에 있던 내용이 테이블에 보여져야하기 때문에 각 항목을 arr[]에 저장
			    	arr[0]=act.productAt(i).getName();
			    	arr[1]=act.productAt(i).getCode();
			    	arr[2]=Integer.toString(act.productAt(i).getPrice());
			    	arr[3]=Integer.toString(act.productAt(i).getNumber());
			    	
			    	//이를 행에 추가함
			    	model.addRow(arr);
			    }    
			}
		}
	}
	
	
	//뒤로 가기 버튼 이벤트 처리
	private class returnActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==returnBtn) {
				new UserOrProduct(); //고객관리 or 물품관리 물어보는 창으로 back
				frame.setVisible(false);	  
			}
		}
	}


}

//관리자 고객 관리 프레임
class ManageUser extends JFrame{
	private static final long serialVersionUID = -8504264415513989554L;
	
	JFrame frame;
	ObjectOutputStream out=null;
	ObjectInputStream in=null;
	Manager act=null;
	
	private JTable table; //테이블

	//버튼
	private JButton deleteBtn; //삭제 버튼
	private JButton fileSaveBtn;//파일 저장 버튼
	private JButton returnBtn; //뒤로 가기 버튼
	private JButton searchBtn; //검색 버튼
	private JButton f5Btn; //새로고침 버튼
	//텍스트 필드
	private JTextField search;
		
	public ManageUser() throws Exception {
		try {
			in=new ObjectInputStream(new FileInputStream("output.dat"));// 오브젝트 입력 스트림을 생성
			act = new Manager(100, 100, in); // 매니저 생성자에게 전달
			in.close();//파일 닫음
		}
		catch (FileNotFoundException e) { //파일을 찾을 수 없을 때 예외처리
			act = new Manager(100, 100);
		}
		//물품 관리 테이블
		Dimension dim = new Dimension(500,500);
		frame = new JFrame("RentalService");
	    frame.setLocation(100, 100);
	    frame.setPreferredSize(dim);

		String header[] = {"고객이름","전화번호","대여일자","반납일자"};
	    String contents[][] = {};
	      
	    DefaultTableModel model = new DefaultTableModel(contents, header);
	    table = new JTable(model);
	    JScrollPane scrollpane = new JScrollPane(table);
	    scrollpane.setBounds(49, 80, 386, 127); //스크롤펜
	    frame.getContentPane().add(scrollpane);
	    
	    //고객 삭제 버튼 
	    deleteBtn = new JButton("고객삭제");
	    deleteBtn.setBounds(200, 255, 91, 23);
	    deleteBtn.addActionListener(new delActionListener());
	    frame.getContentPane().add(deleteBtn);	    
	    //뒤로 가기 버튼
	    returnBtn = new JButton("뒤로가기");
	    returnBtn.setBounds(370,390, 91, 23);
	    returnBtn.addActionListener(new returnActionListener());
	    frame.getContentPane().add(returnBtn);
	    //검색 버튼
	    searchBtn = new JButton("검색");
	    searchBtn.setBounds(260, 220, 60, 23);
	    searchBtn.addActionListener(new searchActionListener());
	    frame.getContentPane().add(searchBtn);
	    //파일 저장 버튼 
	    fileSaveBtn = new JButton("파일저장");
	    fileSaveBtn.setBounds(370, 423, 91, 23);
	    fileSaveBtn.addActionListener(new saveActionListener());
	    frame.getContentPane().add(fileSaveBtn);
	    //새로고침 버튼
	    f5Btn = new JButton("🔃");
	    f5Btn.setBounds(90, 50, 55, 15);
	    f5Btn.addActionListener(new f5ActionListener());
	    frame.getContentPane().add(f5Btn);
	    
	    //고객 목록 텍스트
	    JLabel lblNewLabel_4 = new JLabel("고객목록");
	    lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_4.setBounds(203, 50, 68, 15);
	    frame.getContentPane().add(lblNewLabel_4);
	    //오늘의 매출액 텍스트
	    JLabel LabelRevenue= new JLabel("오늘의 매출액: "+act.getRevenue()+"원");
	    LabelRevenue.setHorizontalAlignment(SwingConstants.CENTER);
	    LabelRevenue.setBounds(5, 423, 150, 15);
	    frame.getContentPane().add(LabelRevenue);
	    
	    //검색 받는 텍스트 필드
	    search = new JTextField(5);
	    search.setBounds(150, 220, 100, 23);
	    frame.getContentPane().add(search);    
	    
	    frame.getContentPane().setLayout(null);	    	    
	    frame.pack();
	    
	    
	    
	    for(int i=0; i<act.getUserCount(); i++) {
	    	String arr[]= new String[4]; //String 받을 배열 선언하기
	    	
	    	//파일이 불러와졌을때 userList에 있던 내용이 테이블에 보여져야하기 때문에 각 항목을 arr[]에 저장
	    	arr[0]=act.userAt(i).getName();
	    	arr[1]=act.userAt(i).getPhone();
	    	arr[2]=act.userAt(i).getRentalDay();
	    	arr[3]=act.userAt(i).getReturnDay();
	    	
	    	//이를 행에 추가함
	    	model.addRow(arr);
	    }    
	    //창 보이게 함
	    frame.setVisible(true);	    
	}
	
	//고객 삭제 버튼 이벤트 처리
	private class delActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==deleteBtn) {
				try {
					int row = table.getSelectedRow(); //(클릭으로) 선택한 줄
					int index = act.searchUser((String)table.getModel().getValueAt(row,1)); //고객 인덱스 찾기
					act.subUser(index); //고객 삭제 (강제 체크아웃)
					
					if(table.getSelectedRow() == -1) {
						return;
			        }
					else {
			            DefaultTableModel model=(DefaultTableModel)table.getModel();
						model.removeRow(table.getSelectedRow()); //줄 삭제
					}
				}
				catch(Exception e1) {
					//파일 삭제 경고창
					JOptionPane.showMessageDialog(null, "삭제할 고객이 없습니다!","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				}
			
			}
		}
	}
	
	//파일 저장 이벤트 처리
	private class saveActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==fileSaveBtn) {
				try {					
					out=new ObjectOutputStream(new FileOutputStream("output.dat"));
					act.saveToFile(out);
				}
				catch(IOException ioe){
					//파일 저장 경고창
					JOptionPane.showMessageDialog(null, "파일 저장에서 오류가 발생했습니다!","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				}
				finally {
					try  {
						out.close();//파일 닫기
					}
					catch (Exception e1) {
					}
				}			
			}
		}
	}
	
	//검색 버튼 이벤트 처리
	private class searchActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==searchBtn) {
				try {
					String searchUser = search.getText(); //입력받은 텍스트 배열로 가져오기
					search.setText("");//텍스트 필드 빈칸 만들어주기				
					act.searchUser(searchUser); //userList에 존재하는 번호인지 검사하기 (없으면 익셉션)
					DefaultTableModel model=(DefaultTableModel)table.getModel();
					model.setNumRows(0); //테이블 비우기
					
					//검색결과와 일치하는 행 추가하기
					for(int i=0; i<act.getUserCount();i++) {
						if(act.userAt(i).getPhone().contains(searchUser)){
							String arr[]= new String[4];
							arr[0]=act.userAt(i).getName();
					    	arr[1]=act.userAt(i).getPhone();
					    	arr[2]=act.userAt(i).getRentalDay();
					    	arr[3]=act.userAt(i).getReturnDay();				    	
					    	//이를 행에 추가함
					    	model.addRow(arr);		
						}
					}
				}
				catch(Exception e1) {
					//검색 경고창
					JOptionPane.showMessageDialog(null, "해당 고객이 존재하지 않습니다!","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				}
			}
		}
	}
	
	
	//새로고침 버튼 이벤트 처리
	private class f5ActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==f5Btn) {
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				model.setNumRows(0); //테이블 비우기
				for(int i=0; i<act.getUserCount(); i++) {
			    	String arr[]= new String[4]; //String 받을 배열 선언하기
			    	
			    	arr[0]=act.userAt(i).getName();
			    	arr[1]=act.userAt(i).getPhone();
			    	arr[2]=act.userAt(i).getRentalDay();
			    	arr[3]=act.userAt(i).getReturnDay();	
			    	
			    	//이를 행에 추가함
			    	model.addRow(arr);
			    }    
			}
		}
	}

	
	//뒤로 가기 버튼 이벤트 처리
	private class returnActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==returnBtn) {
				new UserOrProduct(); //고객관리 or 물품관리 물어보는 창으로 back
				frame.setVisible(false);	  
			}
		}
	}
  
}