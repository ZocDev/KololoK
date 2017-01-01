package ga.zcktn.kololok.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import ga.zcktn.kololok.resource.enums.EnumChallenge;

public class EndChallengeEvent extends Event {

	private static final HandlerList handlers = new HandlerList();

	private EnumChallenge c;
	private Player p;

	public EndChallengeEvent(Player p, EnumChallenge c) {
		this.p = p;
		this.c = c;
	}

	public EndChallengeEvent(Player p, EnumChallenge c, boolean isAsync) {
		super(isAsync);
		this.p = p;
		this.c = c;
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

	public Player getPlayer() {
		return p;
	}

	public EnumChallenge getEnumChallenge() {
		return c;
	}

}
