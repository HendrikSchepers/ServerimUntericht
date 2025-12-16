import jutils.Client;

import javax.swing.*;

public class QOTDClient extends Client {
    public QOTDClient(String pServerIP) {
        super(pServerIP, 17);
    }

    @Override
    public void processMessage(String pMessage) {
        JOptionPane.showMessageDialog(null,"server sendet: \n"+ pMessage);
    }
}
