package org.apollo.game.sync.block;

import org.apollo.game.model.Animation;

/**
 * The animation {@link SynchronizationBlock}. Both npcs and players can utilise this block.
 *
 * @author Graham
 */
public final class AnimationBlock extends SynchronizationBlock {

  /**
   * The animation.
   */
  private final int animation;

  private final int delay;

  /**
   * Creates the animation block.
   *
   * @param animation The animation.
   */
  AnimationBlock(int animation, int delay) {
    this.animation = animation;
    this.delay = delay;
  }

  /**
   * Gets the {@link Animation}.
   *
   * @return The animation.
   */
  public int getAnimation() {
    return animation;
  }

  public int getDelay() {
    return delay;
  }

}