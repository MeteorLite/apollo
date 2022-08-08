package org.apollo.game.model.event;

/**
 * A listener for an {@link Event} that may occur in the game world.
 *
 * @param <E> The type of Event.
 * @author Major
 */
@FunctionalInterface
public interface EventListener<E> {

  /**
   * Handles the {@link Event} that occurred.
   *
   * @param event The Event.
   */
  public void handle(E event);

}