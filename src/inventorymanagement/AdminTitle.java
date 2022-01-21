package inventorymanagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class AdminTitle extends JPanel implements ActionListener{
    JButton jb_logout;
    JPanel jp_Admin;
    static JPanel jp_login;
    static void getLogin(JPanel jp_panel1) {
        jp_login=jp_panel1;
    }
    Border b = BorderFactory.createLineBorder(Color.black);
    Font f2 = new Font(Font.DIALOG,Font.BOLD,15);
    public AdminTitle(JPanel jp_Admin) {
        this.jp_Admin=jp_Admin;
        setLayout(null);
        setSize(840,50);
        setBorder(b);
        jb_logout = new JButton("Log Out");jb_logout.setBounds(700,10,100,25);
        jb_logout.setBorder(b);
        jb_logout.setFont(f2);
        jb_logout.setBackground(Color.lightGray);
        jb_logout.addActionListener(this);
        add(jb_logout);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object ob_event = e.getSource();
        if(ob_event.equals(jb_logout)){
            jp_Admin.setVisible(false);
            jp_login.setVisible(true);
        }
    }
}
