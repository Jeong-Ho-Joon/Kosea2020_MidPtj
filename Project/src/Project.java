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
      Frame f = new Frame("서울 맛집 조회 프로그램");
      Frame f2 = new Frame("?구 맛집 열람");
      Button b = new Button("확인");
      Label text = new Label("맛집을 찾으실 구역을 지정해주세요");
      f.setSize(500, 300);
      f.setLayout(null);
      f.addWindowListener(this);

      Toolkit tk = Toolkit.getDefaultToolkit();
      Dimension screenSize = tk.getScreenSize();

      Choice res = new Choice();
      res.add("강남구");
      res.add("강동구");
      res.add("강서구");
      res.add("강북구");
      res.add("관악구");
      res.add("광진구");
      res.add("구로구");
      res.add("금천구");
      res.add("노원구");
      res.add("동대문구");
      res.add("도봉구");
      res.add("동작구");
      res.add("마포구");
      res.add("서대문구");
      res.add("성동구");
      res.add("성북구");
      res.add("서초구");
      res.add("송파구");
      res.add("영등포구");
      res.add("용산구");
      res.add("양천구");
      res.add("은평구");
      res.add("종로구");
      res.add("중구");
      res.add("중랑구");

      res.setSize(100, 120);
      res.setLocation(200, 100);
      b.setSize(50, 30);
      b.setLocation(225, 150);
      text.setBounds(160, 20, 200 ,60);

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