import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.*;

class MyClient implements ActionListener
{

    Socket s;
    DataInputStream dis;
    DataOutputStream dos;
    JButton sendButton;
    JButton logoutButton;
    JButton loginButton;
    JButton exitButton;
    JFrame chatWindow;
    JTextArea txtBroadcast;
    JTextArea txtMessage;
    JList usersList;

    public void displayGUI()
    {
        chatWindow = new JFrame();
        txtBroadcast = new JTextArea(5, 30);
        txtBroadcast.setEditable(false);
        txtMessage = new JTextArea(2, 20);
        usersList = new JList();
        sendButton = new JButton("Send");
        logoutButton = new JButton("Log out");
        loginButton = new JButton("Log in");
        exitButton = new JButton("Exit");
        JPanel jpanel = new JPanel();
        jpanel.setLayout(new BorderLayout());
        jpanel.add(new JLabel("Broad Cast messages from all online users", 0), "North");
        jpanel.add(new JScrollPane(txtBroadcast), "Center");
        JPanel jpanel1 = new JPanel();
        jpanel1.setLayout(new FlowLayout());
        jpanel1.add(new JScrollPane(txtMessage));
        jpanel1.add(sendButton);
        JPanel jpanel2 = new JPanel();
        jpanel2.setLayout(new FlowLayout());
        jpanel2.add(loginButton);
        jpanel2.add(logoutButton);
        jpanel2.add(exitButton);
        JPanel jpanel3 = new JPanel();
        jpanel3.setLayout(new GridLayout(2, 1));
        jpanel3.add(jpanel1);
        jpanel3.add(jpanel2);
        JPanel jpanel4 = new JPanel();
        jpanel4.setLayout(new BorderLayout());
        jpanel4.add(new JLabel("Online Users", 0), "East");
        jpanel4.add(new JScrollPane(usersList), "South");
        chatWindow.add(jpanel4, "East");
        chatWindow.add(jpanel, "Center");
        chatWindow.add(jpanel3, "South");
        chatWindow.pack();
        chatWindow.setTitle("Login for Chat");
        chatWindow.setDefaultCloseOperation(0);
        chatWindow.setVisible(true);
        sendButton.addActionListener(this);
        logoutButton.addActionListener(this);
        loginButton.addActionListener(this);
        exitButton.addActionListener(this);
        logoutButton.setEnabled(false);
        loginButton.setEnabled(true);
        txtMessage.addFocusListener(new FocusAdapter() {

            public void focusGained(FocusEvent focusevent)
            {
                txtMessage.selectAll();
            }

        });
        chatWindow.addWindowListener(new WindowAdapter() {


            public void windowClosing(WindowEvent windowevent)
            {
                if(s != null)
                {
                    JOptionPane.showMessageDialog(chatWindow, "u r logged out right now. ", "Exit", 1);
                    logoutSession();
                }
                System.exit(0);
            }

        });
    }

    public void actionPerformed(ActionEvent actionevent)
    {
        JButton jbutton = (JButton)actionevent.getSource();
        if(jbutton == sendButton)
        {
            if(s == null)
            {
                JOptionPane.showMessageDialog(chatWindow, "u r not logged in. plz login first");
                return;
            }
            try
            {
                dos.writeUTF(txtMessage.getText());
                txtMessage.setText("");
            }
            catch(Exception exception)
            {
                txtBroadcast.append((new StringBuilder()).append("\nsend button click :").append(exception).toString());
            }
        }
        if(jbutton == loginButton)
        {
            String s1 = JOptionPane.showInputDialog(chatWindow, "Enter Your lovely nick name: ");
            if(s1 != null)
            {
                clientChat(s1);
            }
        }
        if(jbutton == logoutButton && s != null)
        {
            logoutSession();
        }
        if(jbutton == exitButton)
        {
            if(s != null)
            {
                JOptionPane.showMessageDialog(chatWindow, "u r logged out right now. ", "Exit", 1);
                logoutSession();
            }
            System.exit(0);
        }
    }

    public void logoutSession()
    {
        if(s == null)
        {
            return;
        }
        try
        {
            dos.writeUTF("@@logoutme@@:");
            Thread.sleep(500L);
            s = null;
        }
        catch(Exception exception)
        {
            txtBroadcast.append((new StringBuilder()).append("\n inside logoutSession Method").append(exception).toString());
        }
        logoutButton.setEnabled(false);
        loginButton.setEnabled(true);
        chatWindow.setTitle("Login for Chat");
    }

    public void clientChat(String s1)
    {
        try
        {
            s = new Socket("192.168.43.77", 2001);
            dis = new DataInputStream(s.getInputStream());
            dos = new DataOutputStream(s.getOutputStream());
            ClientThread clientthread = new ClientThread(dis, this);
            Thread thread = new Thread(clientthread);
            thread.start();
            dos.writeUTF(s1);
            chatWindow.setTitle((new StringBuilder()).append(s1).append(" Chat Window").toString());
        }
        catch(Exception exception)
        {
            txtBroadcast.append((new StringBuilder()).append("\nClient Constructor ").append(exception).toString());
        }
        logoutButton.setEnabled(true);
        loginButton.setEnabled(false);
    }

    public MyClient()
    {
        displayGUI();
    }

    public static void main(String args[])
    {
        new MyClient();
    }
}