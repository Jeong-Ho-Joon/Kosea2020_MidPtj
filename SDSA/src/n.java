//import java.util.Vector;
//
//import javax.swing.JFrame;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.table.DefaultTableModel;
//
//public class n {
//	Vector v;
//	Vector cols;
//	DefaultTableModel model;
//	JTable tab;
//	JScrollPane pane;
//
//	public n() {
//		JFrame f1 = new JFrame("서울 맛집 검색");
//		DAO dao = new DAO();
//		v = dao.getList();
//		System.out.println("v=" + v);
//		cols = getColumn();
//		System.out.println("cols=" + cols);
//
//		model = new DefaultTableModel(v, cols);
////		System.out.println(model.getRowCount());
//		
//		tab = new JTable(model);
//		pane = new JScrollPane(tab);
//		f1.add(pane); 
//
//		f1.setSize(1000, 500);
//		f1.setVisible(true);
//		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	}// end 생성자
//
//	public Vector getColumn() {
//		System.out.println("getColumn() -----------------");
//		Vector col = new Vector();
//		col.add("번호");
//		col.add("종류");
//		col.add("가게이름");
//		col.add("주소");
//		col.add("전화번호");
//		col.add("대표메뉴");
//		col.add("가게특징");
//
//		return col;
//	}// getColumn
//
//	// Jtable 내용 갱신 메서드
////	public void jTableRefresh() {
////		System.out.println("jTabRefresh-------------");
////		DAO dao = new DAO();
////		DefaultTableModel model = new DefaultTableModel(dao.getList(), getColumn());
////		jTable.setModel(model);
////
////	}
//
//	public static void main(String[] args) {
//		new n();
//	}// main
//}