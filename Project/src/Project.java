import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Project {
	public static void main(String[] args) {
		JFrame f = new JFrame("서울 맛집 검색");
		JFrame f2 = new JFrame("서울 맛집 검색");
		JButton btn = new JButton("검색!");
		JButton btn2 = new JButton("뒤로가기");
		String[] area = { "강남구", "강동구", "강서구", "강북구", "관악구", "광진구", "구로구", "금천구", "노원구", "동대문구", "도봉구", "동작구", "마포구",
				"서대문구", "성동구", "성북구", "서초구", "송파구", "영등포구", "용산구", "양천구", "은평구", "종로구", "중구", "중랑구" };
		String[] type = { "고기류", "디저트", "분식", "양식", "일식", "중식", "채식", "한식" };
		
		JComboBox box1 = new JComboBox(area);
		JComboBox box2 = new JComboBox(type);
		Container ct1 = f.getContentPane();
		ct1.setLayout(new FlowLayout());
		Container ct2 = f2.getContentPane();
		ct2.setLayout(new FlowLayout());

		f.add(box1);
		f.add(box2);
		f.add(btn);
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				f2.setVisible(true);
			}
		});
		f.setSize(400, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setVisible(true);

		f2.setVisible(false);
		f2.add(btn2);
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(true);
				f2.setVisible(false);
			}
		});
		f2.setSize(500, 500);
		f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f2.setLocationRelativeTo(null);
	}
}