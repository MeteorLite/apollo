package org.apollo.util;

import static org.junit.Assert.assertTrue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import org.junit.Test;

/**
 * Contains unit tests for {@link CollectionUtil}s.
 *
 * @author Major
 */
public final class CollectionUtilTests {

  /**
   * Tests that {@link CollectionUtil#pollAll} functions correctly.
   */
  @Test
  public void poll() {
    Queue<String> queue = new ArrayDeque<>(Arrays.asList("hello", "world"));
    CollectionUtil.pollAll(queue, String::length);
    assertTrue(queue.isEmpty());
  }

}
