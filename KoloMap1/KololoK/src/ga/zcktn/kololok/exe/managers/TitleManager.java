package ga.zcktn.kololok.exe.managers;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;

public class TitleManager {

	public static void sendTitle(String title,String subtitle, int fadeInTime, int stayTime, int fadeOutTime, CraftPlayer p){
		IChatBaseComponent chatTitle = ChatSerializer.a("{\"text\": \""+ title + "\"}");
		IChatBaseComponent chatSubtitle = ChatSerializer.a("{\"text\": \""+ subtitle + "\"}");
		PacketPlayOutTitle pactitle = new PacketPlayOutTitle(EnumTitleAction.TITLE, chatTitle);
		PacketPlayOutTitle pacsubtitle = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, chatSubtitle);
		PacketPlayOutTitle pactime = new PacketPlayOutTitle(fadeInTime*20, stayTime*20, fadeOutTime*20);
		p.getHandle().playerConnection.sendPacket(pactitle);
		p.getHandle().playerConnection.sendPacket(pacsubtitle);
		p.getHandle().playerConnection.sendPacket(pactime);
	}
	
}
