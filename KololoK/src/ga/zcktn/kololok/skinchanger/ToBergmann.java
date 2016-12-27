package ga.zcktn.kololok.skinchanger;

import org.bukkit.entity.Player;

public class ToBergmann {

	private Player p;

	public ToBergmann(Player p) {

		this.p = p;

	}

	public void setSkin() {
		GameProfileBuilder.getProfile(p.getUniqueId(), "HerrBergmann",
				"http://textures.minecraft.net/texture/dae79c413914ee8679b31955f0ba294a494a7e2ef61b6c55d96864ec6c0334e");
		GameProfileBuilder.setCacheTime(-1);
	}
}
