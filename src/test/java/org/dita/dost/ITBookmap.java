/*
 * This file is part of the DITA Open Toolkit project.
 *
 * Copyright 2016 Jarno Elovirta
 *
 *  See the accompanying LICENSE file for applicable license.
 */

package org.dita.dost;

import static org.dita.dost.AbstractIntegrationTest.Transtype.XHTML;

import java.nio.file.Paths;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public interface ITBookmap {
  AbstractIntegrationTest builder();

  @Test
  default void testBookmap1() throws Throwable {
    builder().name("bookmap1").transtype(XHTML).input(Paths.get("bookmap(2)_testdata1.ditamap")).test();
  }

  @Test
  default void testBookmap2() throws Throwable {
    builder().name("bookmap2").transtype(XHTML).input(Paths.get("bookmap(2)_testdata2.ditamap")).errorCount(1).test();
  }

  @Test
  default void testBookmap3() throws Throwable {
    builder().name("bookmap3").transtype(XHTML).input(Paths.get("bookmap(2)_testdata3.ditamap")).test();
  }

  @Test
  default void testBookmap4() throws Throwable {
    builder().name("bookmap4").transtype(XHTML).input(Paths.get("bookmap(2)_testdata4.ditamap")).errorCount(1).test();
  }

  @Test
  default void testBookmap5() throws Throwable {
    builder().name("bookmap5").transtype(XHTML).input(Paths.get("bookmap(2)_testdata5.ditamap")).test();
  }

  @Test
  default void testBookmap6() throws Throwable {
    builder().name("bookmap6").transtype(XHTML).input(Paths.get("bookmap(2)_testdata6.ditamap")).errorCount(1).test();
  }

  @Test
  default void testBookmap7() throws Throwable {
    builder().name("bookmap7").transtype(XHTML).input(Paths.get("bookmap(2)_testdata7.ditamap")).test();
  }
}
