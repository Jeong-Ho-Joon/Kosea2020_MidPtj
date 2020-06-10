import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Project extends JFrame {
	Vector v;
	Vector cols;
	JTable tab;

	public Project() {
		DAO dao = new DAO();
		v = dao.getList();
		System.out.println("v=" + v);
		cols = getColumn();

		DefaultTableModel model = new DefaultTableModel(v, cols);
		JTable tab = new JTable(model);
		JScrollPane pane = new JScrollPane(tab);
		add(pane);

		JFrame f1 = new JFrame("서울 맛집 검색");
		JFrame f2 = new JFrame("서울 맛집 검색");
		JLabel lb1 = new JLabel("지역을 선택하세요♪");
		JLabel lb2 = new JLabel("먹고싶은 음식종류는?!");
		JButton btn1 = new JButton("검색!");
		JButton btn2 = new JButton("뒤로가기");

		String[] area = { "강남구", "강동구", "강서구", "강북구", "관악구", "광진구", "구로구", "금천구", "노원구", "동대문구", "도봉구", "동작구", "마포구",
				"서대문구", "성동구", "성북구", "서초구", "송파구", "영등포구", "용산구", "양천구", "은평구", "종로구", "중구", "중랑구" };
		String[] type = { "고기류", "디저트", "분식", "양식", "일식", "중식", "채식", "한식" };

		JComboBox box1 = new JComboBox(area);
		JComboBox box2 = new JComboBox(type);

		f1.getContentPane().setLayout(null);
		f2.getContentPane().setLayout(null);

		// f1프레임

		f1.add(box1);
		f1.add(box2);
		f1.add(btn1);
		f1.add(lb1);
		f1.add(lb2);
		
		box1.setBounds(150, 250, 90, 30);
		box2.setBounds(150, 300, 90, 30);
		
		btn1.setBounds(360, 250, 100, 80);
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f1.setVisible(false);
				f2.setVisible(true);
			}
		});
		
		lb1.setBounds(10, 250, 150, 30);
		lb2.setBounds(10, 300, 150, 30);
		
		f1.setSize(500, 400);
		f1.setResizable(false);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setLocationRelativeTo(null);
		f1.setVisible(true);

		// f2프레임

		f2.add(tab);		
		tab.setBounds(0, 0, 1000, 400);
		
		f2.add(pane);
		f2.add(btn2);
		
		btn2.setBounds(870, 400, 100, 50);
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f1.setVisible(true);
				f2.setVisible(false);
			}
		});
		
		f2.setVisible(false);
		f2.setSize(1000, 500);
		f2.setResizable(false);
		f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f2.setLocationRelativeTo(null);

	}// end 생성자

	public Vector getColumn() {
		Vector col = new Vector();
		col.add("번호");
		col.add("종류");
		col.add("가게이름");
		col.add("주소");
		col.add("전화번호");
		col.add("대표메뉴");
		col.add("가게특징");

		return col;
	}// getColumn
	
	public void jTableRefresh() {

		DAO dao = new DAO();
		DefaultTableModel model = new DefaultTableModel(dao.getList(), getColumn());
		tab.setModel(model);

	}

	public static void main(String[] args) {
		new Project();
	}
}