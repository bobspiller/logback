/**
 * Logback: the reliable, generic, fast and flexible logging framework.
 * Copyright (C) 1999-2009, QOS.ch. All rights reserved.
 *
 * This program and the accompanying materials are dual-licensed under
 * either the terms of the Eclipse Public License v1.0 as published by
 * the Eclipse Foundation
 *
 *   or (per the licensee's choosing)
 *
 * under the terms of the GNU Lesser General Public License version 2.1
 * as published by the Free Software Foundation.
 */
package ch.qos.logback.core.appender;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;

import org.junit.Test;

import ch.qos.logback.core.Appender;
import ch.qos.logback.core.encoder.DummyEncoder;
import ch.qos.logback.core.layout.DummyLayout;


public class DummyAppenderTest extends AbstractAppenderTest<Object> {

  ByteArrayOutputStream baos = new ByteArrayOutputStream();
  
  protected Appender<Object> getAppender() {
    return new DummyAppender<Object>(baos);
  }
  
  protected Appender<Object> getConfiguredAppender() {
    DummyAppender<Object> da = new DummyAppender<Object>(baos);
    da.setEncoder(new DummyEncoder<Object>());
    da.start();
    return da;
  }

  @Test
  public void testBasic() {
    DummyAppender<Object> da = new DummyAppender<Object>(baos);
    da.setEncoder(new DummyEncoder<Object>());
    da.start();
    da.doAppend(new Object());
    assertEquals(DummyLayout.DUMMY, baos.toString());
  }
  
}
