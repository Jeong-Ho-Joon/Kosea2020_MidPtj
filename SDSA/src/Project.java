import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Project {

	Vector v;
	Vector cols;
	DefaultTableModel model;
	JTable tab;
	JScrollPane pane;

	public Project() {
		JFrame f1 = new JFrame("서울 맛집 검색");
		JFrame f2 = new JFrame("서울 맛집 검색");
		JPanel p1 = new JPanel();
		JLabel lb1 = new JLabel("지역을 지정해주세요 ♪");
		JLabel lb2 = new JLabel("먹고싶은 음식종류는 ?!");
		JLabel imagelb1 = new JLabel();
		JButton btn1 = new JButton("검색 !");
		JButton btn2 = new JButton("전체조회");
		JButton btn3 = new JButton("뒤로가기");
		JButton btn4 = new JButton("랜덤조회");
		ImageIcon imageIcon1 = new ImageIcon("C:\\Users\\user\\Desktop\\사진\\chinese-icon-orange.png");

		String[] area = { "강남구", "강동구", "강서구", "강북구", "구로구", "동대문구", "마포구", "서초구", "송파구", "영등포구", "종로구" };
		String[] type = { "고기류", "디저트", "분식", "양식", "일식", "중식", "한식" };

		JComboBox<String> box1 = new JComboBox<String>(area);
		JComboBox<String> box2 = new JComboBox<String>(type);

		// f1프레임

		f1.add(box1);
		f1.add(box2);
		f1.add(btn1);
		f1.add(btn2);
		f1.add(btn4);
		f1.add(lb1);
		f1.add(lb2);
		f1.add(imagelb1);
		imagelb1.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\사진\\8.jpg"));
		imagelb1.setBounds(0, 0, 500, 400);

		box1.setBounds(150, 10, 120, 30);
		box2.setBounds(150, 50, 120, 30);
		box1.setFont(new Font("배찌체", Font.BOLD, 15));
		box2.setFont(new Font("배찌체", Font.BOLD, 15));

		btn1.setBounds(305, 10, 150, 70);
		btn1.setBorderPainted(false);
		btn1.setFont(new Font("배찌체", Font.BOLD, 25));
		btn2.setBounds(270, 325, 200, 25);
		btn2.setBorderPainted(false);
		btn2.setFont(new Font("배찌체", Font.BOLD, 20));
		btn4.setBounds(10, 325, 200, 25);
		btn4.setBorderPainted(false);
		btn4.setFont(new Font("배찌체", Font.BOLD, 20));

		cols = getColumn();
		model = new DefaultTableModel(cols, 0) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};
		tab = new JTable(model);
		pane = new JScrollPane(tab);
		tab.setFont(new Font("배찌체", Font.PLAIN, 15));
		
		//일반조회 버튼
		
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.setNumRows(0);
				String boxset1 = (String) box1.getSelectedItem();
				String boxset2 = (String) box2.getSelectedItem();
				System.out.println(boxset1);
				System.out.println(boxset2);
				DAO dao = new DAO();
				v = dao.getList1(boxset1, boxset2);
				System.out.println("v=" + v);
				model.setDataVector(v, cols);

				tab.getColumnModel().getColumn(0).setPreferredWidth(0);
				tab.getColumnModel().getColumn(1).setPreferredWidth(0);
				tab.getColumnModel().getColumn(2).setPreferredWidth(50);
				tab.getColumnModel().getColumn(3).setPreferredWidth(250);
				tab.getColumnModel().getColumn(4).setPreferredWidth(50);
				tab.getColumnModel().getColumn(5).setPreferredWidth(100);
				tab.getColumnModel().getColumn(6).setPreferredWidth(250);

				f2.add(pane);
				f1.setVisible(false);
				f2.setVisible(true);
			}
		});

		//전체조회 버튼
		
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.setNumRows(0);
				System.out.println("ALL");
				DAO dao = new DAO();
				v = dao.getList2();
				System.out.println("v=" + v);
				model.setDataVector(v, cols);

				tab.getColumnModel().getColumn(0).setPreferredWidth(0);
				tab.getColumnModel().getColumn(1).setPreferredWidth(0);
				tab.getColumnModel().getColumn(2).setPreferredWidth(50);
				tab.getColumnModel().getColumn(3).setPreferredWidth(250);
				tab.getColumnModel().getColumn(4).setPreferredWidth(50);
				tab.getColumnModel().getColumn(5).setPreferredWidth(100);
				tab.getColumnModel().getColumn(6).setPreferredWidth(250);

				f2.add(pane);
				f1.setVisible(false);
				f2.setVisible(true);
			}
		});
		
		//랜덤조회 버튼
		
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.setNumRows(0);
				System.out.println("RANDOM");
				DAO dao = new DAO();
				v = dao.getList3();
				System.out.println("v=" + v);
				model.setDataVector(v, cols);

				tab.getColumnModel().getColumn(0).setPreferredWidth(0);
				tab.getColumnModel().getColumn(1).setPreferredWidth(0);
				tab.getColumnModel().getColumn(2).setPreferredWidth(50);
				tab.getColumnModel().getColumn(3).setPreferredWidth(250);
				tab.getColumnModel().getColumn(4).setPreferredWidth(50);
				tab.getColumnModel().getColumn(5).setPreferredWidth(100);
				tab.getColumnModel().getColumn(6).setPreferredWidth(250);

				f2.add(pane);
				f1.setVisible(false);
				f2.setVisible(true);
			}
		});

		lb1.setBounds(10, 10, 150, 30);
		lb2.setBounds(10, 50, 150, 30);
		lb1.setFont(new Font("배찌체", Font.PLAIN, 18));
		lb2.setFont(new Font("배찌체", Font.PLAIN, 18));

		Image image = imageIcon1.getImage();
		f1.setIconImage(image);
		f1.setSize(500, 400);
		f1.setResizable(false);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setLocationRelativeTo(null);
		f1.setVisible(true);

		// f2프레임

		p1.add(btn3);
		btn3.setFont(new Font("배찌체", Font.BOLD, 20));
		btn3.setBorderPainted(false);
		f2.add(btn3, BorderLayout.SOUTH);

		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f1.setVisible(true);
				f2.setVisible(false);
			}
		});

		f2.setIconImage(image);
		f2.setSize(1300, 400);
		f2.setVisible(false);
		f2.setResizable(false);
		f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f2.setLocationRelativeTo(null);

	}

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
	}

	public static void main(String[] args) {
		new Project();
	}
}