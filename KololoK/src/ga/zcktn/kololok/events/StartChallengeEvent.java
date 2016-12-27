package ga.zcktn.kololok.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class StartChallengeEvent extends Event {

	public StartChallengeEvent() {
	}
	
	public StartChallengeEvent(boolean isAsync) {
		super(isAsync);
	}

	@Override
	public HandlerList getHandlers() {
		return null;
	}

}
