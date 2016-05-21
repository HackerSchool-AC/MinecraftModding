package hackerschool.aachen.minecraftmod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class MethodenBeispiel {

    @SubscribeEvent
    public void playerLoggedIn(PlayerLoggedInEvent event) {
        sendMessage1(event.player);
        sendMessage2(event.player);
    }

    private void sendMessage1(EntityPlayer player) {
        String playername = player.getName();
        player.addChatMessage(new ChatComponentText("Du (" + playername + ") hast dich eingeloggt"));
    }

    private void sendMessage2(EntityPlayer player) {
        String playername = player.getName();
        String msg = String.format("Du (%s) hast dich eingeloggt", playername);
        player.addChatMessage(new ChatComponentText(msg));
    }
}
