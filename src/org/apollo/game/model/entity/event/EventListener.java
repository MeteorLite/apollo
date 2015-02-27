package org.apollo.game.model.entity.event;

/**
 * A listener for an {@link Event} that may occur in the game world.
 *
 * @author Major
 *
 * @param <E> The type of Event.
 */
@FunctionalInterface
public interface EventListener<E> {

	/**
	 * Handles the {@link Event} that occurred.
	 * 
	 * @param event The Event.
	 * @param context The {@link EventContext}.
	 */
	public void handle(E event, EventContext context);

}