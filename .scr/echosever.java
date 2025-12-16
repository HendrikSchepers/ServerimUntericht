import jutils.Client;

import javax.swing.*;

public class echosever extends Client {
    public echosever(String pServerIP) {
        super(pServerIP, 17);
    }

    @Override
    public void processMessage(String pMessage) {
        JOptionPane.showMessageDialog(null,"server sendet: \n"+ pMessage);
    }
}
