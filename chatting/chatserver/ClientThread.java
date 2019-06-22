import java.io.DataInputStream;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JList;
import javax.swing.JTextArea;

class ClientThread implements Runnable
{
    DataInputStream dis;
    MyClient client;
    ClientThread(DataInputStream datainputstream, MyClient myclient)
    {
        dis = datainputstream;
        client = myclient;
    }

    public void run()
    {
        String s = "";
        _L2:
        s = dis.readUTF();
        if(s.startsWith("updateuserslist:"))
        {
            updateUsersList(s);
            break MISSING_BLOCK_LABEL_69;
        }
        if(s.equals("@@logoutme@@:"))
        {
            break; /* Loop/switch isn't completed */
        }
        client.txtBroadcast.append((new StringBuilder()).append("\n").append(s).toString());
        int i = client.txtBroadcast.getLineStartOffset(client.txtBroadcast.getLineCount() - 1);
        client.txtBroadcast.setCaretPosition(i);
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        client.txtBroadcast.append((new StringBuilder()).append("\nClientThread run : ").append(exception).toString());
        if(true) goto _L2; else goto _L1
         _L1:
    }

    public void updateUsersList(String s)
    {
        Vector vector = new Vector();
        s = s.replace("[", "");
        s = s.replace("]", "");
        s = s.replace("updateuserslist:", "");
        String s1;
        for(StringTokenizer stringtokenizer = new StringTokenizer(s, ","); stringtokenizer.hasMoreTokens(); vector.add(s1))
        {
            s1 = stringtokenizer.nextToken();
        }
        client.usersList.setListData(vector);
    }
}
