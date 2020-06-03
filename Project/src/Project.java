import java.awt.Button;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Project extends WindowAdapter {

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public Project() {
		Frame f = new Frame("���� ���� ��ȸ ���α׷�");
		Frame f2 = new Frame("?�� ���� ����");
		Button b = new Button("Ȯ��");
		Label text = new Label("������ ã���� ������ �������ּ���");
		f.setSize(500, 300);
		f.setLayout(null);
		f.addWindowListener(this);

		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();

		Choice res = new Choice();
		res.add("�����강남구");
		res.add("������");
		res.add("������");
		res.add("���ϱ�");
		res.add("���Ǳ�");
		res.add("������");
		res.add("���α�");
		res.add("��õ��");
		res.add("�����");
		res.add("���빮��");
		res.add("������");
		res.add("���۱�");
		res.add("������");
		res.add("���빮��");
		res.add("������");
		res.add("���ϱ�");
		res.add("���ʱ�");
		res.add("���ı�");
		res.add("��������");
		res.add("��걸");
		res.add("��õ��");
		res.add("����");
		res.add("���α�");
		res.add("�߱�");
		res.add("�߶���");

		res.setSize(100, 120);
		res.setLocation(200, 100);
		b.setSize(50, 30);
		b.setLocation(225, 150);
		text.setBounds(160, 20, 200, 60);

		f.add(res);
		f.add(b);
		f.add(text);
		f.setLocation(screenSize.width / 2 - 150, screenSize.height / 2 - 100);
		f.setVisible(true);

		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f2.setVisible(true);
			}
		});

		f2.setSize(500, 300);
		f2.setLocation(200, 100);
		f2.setLayout(null);
		f2.setLocation(screenSize.width / 2 - 150, screenSize.height / 2 - 100);
		f2.addWindowListener(this);
	}

	public static void main(String[] args) {
		Project p = new Project();
	}
}