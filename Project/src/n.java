import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class n extends JFrame {

	Vector v;
	Vector cols;
	DefaultTableModel model;
	JTable jTable;
	JScrollPane pane;
	JPanel pbtn;
	JButton btnInsert;

	public n() {
		super("서울 맛집 검색");
		DAO dao = new DAO();
		v = dao.getList();
		System.out.println("v=" + v);
		cols = getColumn();

		model = new DefaultTableModel(v, cols);

		jTable = new JTable(model);
		pane = new JScrollPane(jTable);
		add(pane);

		setSize(1000, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
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

	// Jtable 내용 갱신 메서드
	public void jTableRefresh() {

		DAO dao = new DAO();
		DefaultTableModel model = new DefaultTableModel(dao.getList(), getColumn());
		jTable.setModel(model);

	}

	public static void main(String[] args) {
		new n();
	}// main
}