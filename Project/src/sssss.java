import javax.swing.*;

public class sssss {
	public static void main(String[] args) {
		JFrame f = new JFrame("테이블 예제");
		String data[][] = { { "101", "사원", "1500000" },
							{ "102", "대리", "2000000" },
							{ "103", "과장", "2500000" } 
							};

		String column[] = { "번호", "직책", "월급" };

		JTable jt = new JTable(data, column);
		jt.setCellSelectionEnabled(false);
		JScrollPane sp = new JScrollPane(jt);
		f.add(sp);
		f.setSize(300, 200);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
