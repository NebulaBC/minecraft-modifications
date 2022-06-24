package net.nebulabc.irchatter.tools;

import net.minecraft.text.LiteralTextContent;
import net.minecraft.text.Text;
import net.nebulabc.irchatter.IRChatter;
import org.kitteh.irc.client.library.Client;

public class IRCLIENT {
    public static void sendMessage(String m) {
        IRChatter.client.addChannel("#minecraft");
        IRChatter.client.sendMessage("#minecraft", m);
    }

}
