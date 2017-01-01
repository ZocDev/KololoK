package ga.zcktn.kololok.skinchanger;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import com.mojang.authlib.GameProfile;

import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerInfo;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerInfo.EnumPlayerInfoAction;
import net.minecraft.server.v1_8_R3.PlayerInteractManager;
import org.bukkit.World;
import net.minecraft.server.v1_8_R3.WorldServer;

public class HerrBergmannWerden {

	private CraftPlayer p;

	protected static WorldServer getWorldServer(World world) { 
		  if (world instanceof CraftWorld) { 

			  return ((CraftWorld) world).getHandle(); 
		  } 
		  return null; 
		 } 
	
	public HerrBergmannWerden(Player p) {
		this.p = (CraftPlayer)p;
	}

	@SuppressWarnings("deprecation")
	public boolean setSkin() {
		try {
			System.out.println(Bukkit.getOfflinePlayer("HerrBergmann").getUniqueId().toString());
			GameProfile profile = GameProfileBuilder.getProfile(Bukkit.getOfflinePlayer("HerrBergmann").getUniqueId(), "HerrBergmann",
					"http://textures.minecraft.net/texture/dae79c413914ee8679b31955f0ba294a494a7e2ef61b6c55d96864ec6c0334e");
			GameProfileBuilder.setCacheTime(-1);
			PacketPlayOutPlayerInfo packet = new PacketPlayOutPlayerInfo(EnumPlayerInfoAction.UPDATE_DISPLAY_NAME, new EntityPlayer(((CraftServer)Bukkit.getServer()).getServer(),getWorldServer(p.getWorld()) , profile,new PlayerInteractManager(getWorldServer(p.getWorld()))));
			for (Player p2 : Bukkit.getServer().getOnlinePlayers()) {
				CraftPlayer cp = (CraftPlayer) p2;
				cp.getHandle().playerConnection.sendPacket(packet);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
}