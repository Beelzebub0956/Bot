package Bot;

import java.awt.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.text.*;
import java.net.*;

public class Chat_Bot implements ActionListener {
    
    static JFrame f = new JFrame();
    JPanel a1;
    static Box vertical = Box.createVerticalBox();
    static DataOutputStream dout;
    JTextField text; 
    
    Chat_Bot() {
        f.setTitle("Chat_Bot");
        f.setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setBackground(Color.black);
        p1.setBounds(0, 0, 450, 70);
        p1.setLayout(null);
        f.add(p1);
        
        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/3.png"));
        Image i2 = i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel back = new JLabel(i3);
        back.setBounds(5, 20, 25, 25);
        p1.add(back);
        
        back.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent ae) {
                System.exit(0);
            }
        });
        
        JLabel name = new JLabel("Chat Bot");
        name.setBounds(180, 25, 100, 18);
        name.setForeground(Color.yellow);
        name.setFont(new Font("san_serif", Font.BOLD, 22));
        p1.add(name);
        
        a1 = new JPanel();
        a1.setBounds(5, 75, 440, 570);
        a1.setLayout(new BoxLayout(a1, BoxLayout.Y_AXIS));
        a1.setBackground(Color.darkGray);
        f.add(a1);
        
        text = new JTextField();
        text.setBounds(5, 655, 310, 40);
        text.setBackground(Color.DARK_GRAY);
        text.setFont(new Font("san_serif", Font.PLAIN, 16));
        text.setForeground(Color.green);
        f.add(text);
        
        JButton send = new JButton("send");
        send.setBounds(320, 655, 123, 40);
        send.setBackground(Color.lightGray);
        send.setForeground(Color.red);
        send.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        send.addActionListener(this);
        f.add(send);
        
        f.setSize(450, 700);
        f.setLocation(550, 50);
        f.setUndecorated(true);
        f.getContentPane().setBackground(Color.DARK_GRAY);
        f.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        try {
            String out = text.getText();
            
            JPanel p2 = formatLabel(out);
            
            JPanel right = new JPanel(new BorderLayout());
            right.add(p2, BorderLayout.LINE_END);
            vertical.add(right);
            vertical.add(Box.createVerticalStrut(15));
            
            a1.add(vertical, BorderLayout.PAGE_START);
            a1.revalidate();
            
            dout.writeUTF(out);
            
            text.setText("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static JPanel formatLabel(String out) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        JLabel output = new JLabel(out);
        output.setFont(new Font("Tahoma", Font.PLAIN, 16));
        output.setOpaque(true);
        output.setBorder(new EmptyBorder(15, 15, 15, 30));
        
        panel.add(output);
        
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        
        JLabel time = new JLabel();
        time.setText(sdf.format(cal.getTime()));
        
        panel.add(time);
        
        return panel;
    }
    
    public static void main(String[] args) {
        new Chat_Bot();
        try {
            ServerSocket skt = new ServerSocket(6001);
            while (true) {
                Socket s = skt.accept();
                DataInputStream din = new DataInputStream(s.getInputStream());
                dout = new DataOutputStream(s.getOutputStream());
                
                while (true) {
                    String msg = din.readUTF();
                    JPanel panel = formatLabel(msg);
                    
                    JPanel left = new JPanel(new BorderLayout());
                    left.add(panel, BorderLayout.LINE_START);
                    vertical.add(left);
                    f.revalidate();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
