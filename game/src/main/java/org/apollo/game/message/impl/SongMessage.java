package org.apollo.game.message.impl;

import org.apollo.net.message.Message;

/**
 * A {@link Message} sent to the client to play a song.
 *
 * @author tlf30
 */
public final class SongMessage extends Message {

	/**
	 * The id of the song to play.
	 */
	private final int id;

	/**
	 * Creates a new send play sound message.
	 *
	 * @param id The id of the song to play.
	 */
	public SongMessage(int id) {
		this.id = id;
	}

  public int getId() {
    return id;
  }
}