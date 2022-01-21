package inventorymanagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class CustomerProfile extends JPanel implements ActionListener{
    JLabel jlb_username,jlb_password,jlb_mail;
    JTextField jtf_username,jtf_password,jtf_mail;
    JButton jb_update;
    Font f2 = new Font(Font.DIALOG,Font.BOLD,15);
    Border blackline = BorderFactory.createRaisedSoftBevelBorder();
    public CustomerProfile(String username) {
        setSize(740,520);
        setLayout(null);
        setLocation(100,50);
        setBorder(blackline);
        jlb_username = new JLabel("Username");jlb_username.setBounds(200,150,100,25);
        jlb_username.setFont(f2);
        jlb_password = new JLabel("Password");jlb_password.setBounds(200,200,100,25);
        jlb_password.setFont(f2);
        jlb_mail = new JLabel("Mail");jlb_mail.setBounds(200,250,100,25);
        jlb_mail.setFont(f2);
        jtf_username = new JTextField();jtf_username.setBounds(300,150,200,25);
        jtf_username.setEditable(false);
        jtf_password = new JTextField();jtf_password.setBounds(300,200,200,25);
        jtf_mail = new JTextField();jtf_mail.setBounds(300,250,200,25);
        jb_update = new JButton("UPDATE");jb_update.setBounds(200,300,100,25);
        jb_update.setFont(f2);
        jb_update.setBackground(Color.lightGray);
        jb_update.addActionListener(this);
        try {
            Connection co = DriverConnection.getConnection();
            String query  = "select * from users where username = '"+username+"'";
            PreparedStatement pstmt = co.prepareStatement(query);
            ResultSet rst = pstmt.executeQuery();
            while(rst.next()){
                jtf_username.setText(rst.getString("username"));
                jtf_password.setText(rst.getString("userpass"));
                jtf_mail.setText(rst.getString("usermail"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        add(jlb_username);
        add(jlb_password);
        add(jlb_mail);
        add(jtf_username);
        add(jtf_password);
        add(jtf_mail);
        add(jb_update);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object ob_event = e.getSource();
        if(ob_event.equals(jb_update)){
            String username = jtf_username.getText();
            String userpass = jtf_password.getText();
            String usermail = jtf_mail.getText();
            try {
                Connection co = DriverConnection.getConnection();
                String query = "update users set userpass = '"+userpass+"',usermail = '"+usermail+"'where userid = '"+username+"'";
                PreparedStatement pstmt = co.prepareStatement(query);
                pstmt.executeUpdate();
                System.out.println("success");
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }
}