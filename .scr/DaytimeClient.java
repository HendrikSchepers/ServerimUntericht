import jutils.Client;

import javax.swing.*;

public class DaytimeClient extends Client {
    public DaytimeClient(String pServerIP) {
        super(pServerIP, 13);
    }

    @Override
    public void processMessage(String pMessage) {
        JOptionPane.showMessageDialog(null,"server sendet: \n"+ pMessage);
    }
}
