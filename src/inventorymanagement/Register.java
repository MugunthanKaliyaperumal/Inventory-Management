package inventorymanagement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import java.sql.*;

public class Register extends JPanel implements ActionListener{
    JLabel jlb_username,jlb_userpass,jlb_register,jlb_mail;
    JTextField jtf_username,jtf_userpass,jtf_mail;
    JButton jb_submit,jb_clear,jb_cancel;
    static JPanel jp_login ;
    static void getLogin(JPanel jp_panel1) {
        jp_login=jp_panel1;
    }
    Border blackline = BorderFactory.createRaisedSoftBevelBorder();
    Font f1 = new Font(Font.SERIF,Font.BOLD,15);
    Font f2 = new Font(Font.DIALOG,Font.BOLD,15);
    int OTP;
    Register(){
        int x = 20;
        int y = 70;
        setLayout(null);
        jlb_register = new JLabel("  Register");jlb_register.setBounds(120+230+x,50+y,80,25);
        jlb_register.setFont(f1);
        jlb_register.setBorder(blackline);
        jlb_register.setForeground(Color.BLACK);
        
        jlb_username = new JLabel("Username   ");jlb_username.setBounds(20+230+x,150+y,100,25);
        jlb_username.setFont(f2);
        
        jlb_userpass = new JLabel("Password  ");jlb_userpass.setBounds(20+230+x,200+y,100,25);
        jlb_userpass.setFont(f2);
        
        jlb_mail = new JLabel("Mail ID   ");jlb_mail.setBounds(20+230+x,300+y,200,25);
        jlb_mail.setFont(f2);
        
        jtf_username = new JTextField();jtf_username.setBounds(120+230+x,150+y,180,25);
        jtf_username.addActionListener(this);
        
        jtf_userpass = new JTextField();jtf_userpass.setBounds(120+230+x,200+y,180,25);
        jtf_userpass.addActionListener(this);
        
        jtf_mail = new JTextField();jtf_mail.setBounds(120+230+x,300+y,180,25);

        jb_submit = new JButton("Submit");jb_submit.setBounds(110+230+x,350+y,100,25);
        jb_submit.addActionListener(this);
        jb_submit.setBackground(Color.lightGray);
        jb_submit.setFont(f2);
        
        jb_clear = new JButton("Clear");jb_clear.setBounds(220+230+x,350+y,100,25);
        jb_clear.addActionListener(this);
        jb_clear.setBackground(Color.lightGray);
        jb_clear.setFont(f2);
        
        jb_cancel = new JButton("Cancel");jb_cancel.setBounds(0+230+x,350+y,100,25);
        jb_cancel.addActionListener(this);
        jb_cancel.setBackground(Color.lightGray);
        jb_cancel.setFont(f2);
        
        add(jlb_register);
        add(jlb_username);
        add(jlb_userpass);
        add(jtf_username);
        add(jtf_userpass);
        add(jb_submit);
        add(jb_clear);
        add(jb_cancel);
        add(jlb_mail);
        add(jtf_mail);
        setSize(850,600);
        setBorder(blackline);
        setVisible(false);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(jtf_username)){
            jtf_userpass.requestFocus();
        }
        if(e.getSource().equals(jtf_userpass)){
            jtf_mail.requestFocus();
        }
        if(e.getSource().equals(jb_submit)){
//            String getotp;
//            try {
//                // Construct data
//                String apiKey = "apikey=" + "NGI3MzZlNDM2ZTQ4NGE0ZTc4MzM0ZDcyNGI2MzRkNTc=";
//                String message = "&message=" + "Hey " + .getText() + "! Your OTP for our Inventory is "+ OTP + ". Please don't share it with anyone.";
//                String sender = "&sender=" + "Inventory Manager";
//                String numbers = "&numbers=" + .getText();
//
//                // Send data
//                HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
//                String data = apiKey + numbers + message + sender;
//                conn.setDoOutput(true);
//                conn.setRequestMethod("POST");
//                conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
//                conn.getOutputStream().write(data.getBytes("UTF-8"));
//                final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//                final StringBuffer stringBuffer = new StringBuffer();
//                String line;
//                while ((line = rd.readLine()) != null) {
//                    stringBuffer.append(line);
//                }
//                rd.close();
//                JOptionPane.showMessageDialog(null,"OTP sent successfully!");
//                getotp = JOptionPane.showInputDialog("Enter OTP");
//                if(Integer.parseInt(getotp) == OTP){
//                    JOptionPane.showMessageDialog(null,"Verification Successfull!");
//                    try{
//                        PreparedStatement pst;
//                        Connection con;
//                        ResultSet rs;
//                        String sql = "insert into users_tab values(?,?,?)";
//                        con = DriverConnection.getConnection();
//                        pst = con.prepareStatement(sql);
//                        pst.setString(1,.getText());
//                        pst.setString(2,jtf_userpass.getText());
//                        pst.setString(3,"user");
//                        pst.executeUpdate();
//                        con.setAutoCommit(true);
//                        .setText("");
//                        jtf_userpass.setText("");
//                        JOptionPane.showMessageDialog(null,"Registration Success!");
//                    }catch(Exception exe){
//                        exe.printStackTrace();
//                    }
//                }
//                else if(Integer.parseInt(getotp) != OTP){
//                    JOptionPane.showMessageDialog(null,"Invalid OTP");
//                }
//            } catch (Exception ab) {
//                    System.out.println("Error SMS "+ab);
//            }
//        }
            SendMailOtp newotp = new SendMailOtp();
            newotp.OTP(jtf_mail.getText());
            String otp = String.valueOf(SendMailOtp.ot);
            String getotp = JOptionPane.showInputDialog("Enter OTP");
            if(otp.equals(getotp)){
                JOptionPane.showMessageDialog(null, "Verified");
                try{
                    PreparedStatement pst;
                    Connection con;
                    String sql = "insert into users values(?,?,?,?)";
                    con = DriverConnection.getConnection();
                    pst = con.prepareStatement(sql);
                    pst.setString(1,jtf_username.getText());
                    pst.setString(2,jtf_userpass.getText());
                    pst.setString(3,jtf_mail.getText());
                    pst.setString(4,"user");
                    pst.executeUpdate();
                    con.setAutoCommit(true);
//                    jtf_username.setText("");
//                    jtf_userpass.setText("");
//                    jtf_mail.setText("");
                    this.setVisible(false);
                    jp_login.setVisible(true);
                    JOptionPane.showMessageDialog(null,"Success");
                }catch(Exception exe){
                    exe.printStackTrace();
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid otp");
            }   
       }
       if(e.getSource().equals(jb_clear)) {
            jtf_username.setText("");
            jtf_userpass.setText("");
            jtf_mail.setText("");
       }
       if(e.getSource().equals(jb_cancel)){
            this.setVisible(false);
            jp_login.setVisible(true);
            jtf_username.setText("");
            jtf_userpass.setText("");
            jtf_mail.setText("");
       }
    }
}
