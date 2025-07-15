/*
 * This file is part of the DITA Open Toolkit project.
 *
 * Copyright 2016 Jarno Elovirta
 *
 *  See the accompanying LICENSE file for applicable license.
 */

package org.dita.dost;

import static org.dita.dost.AbstractIntegrationTest.Transtype.PREPROCESS;
import static org.dita.dost.AbstractIntegrationTest.Transtype.XHTML;

import java.nio.file.Paths;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public interface ITFilter {
  AbstractIntegrationTest builder();

  @Test
  default void testcontrolValueFile1() throws Throwable {
    builder()
      .name(Paths.get("filter", "map13_filter1"))
      .transtype(PREPROCESS)
      .input(Paths.get("map13.ditamap"))
      .put("args.filter", Paths.get("filter1.ditaval"))
      .test();
  }

  @Test
  default void testcontrolValueFile2() throws Throwable {
    builder()
      .name(Paths.get("filter", "map13_filter2"))
      .transtype(PREPROCESS)
      .input(Paths.get("map13.ditamap"))
      .put("args.filter", Paths.get("filter2.ditaval"))
      .test();
  }

  @Test
  default void testcontrolValueFile3() throws Throwable {
    builder()
      .name(Paths.get("filter", "map13_filter3"))
      .transtype(PREPROCESS)
      .input(Paths.get("map13.ditamap"))
      .put("args.filter", Paths.get("filter3.ditaval"))
      .test();
  }

  @Test
  default void testcontrolValueFile4() throws Throwable {
    builder()
      .name(Paths.get("filter", "map31_filter_multi"))
      .transtype(PREPROCESS)
      .input(Paths.get("map31.ditamap"))
      .put("args.filter", Paths.get("filter_multi.ditaval"))
      .warnCount(1)
      .test();
  }

  @Test
  default void testcontrolValueFile5() throws Throwable {
    builder()
      .name(Paths.get("filter", "map32_filter_multi"))
      .transtype(PREPROCESS)
      .input(Paths.get("map32.ditamap"))
      .put("args.filter", Paths.get("filter_multi.ditaval"))
      .warnCount(1)
      .test();
  }

  @Test
  default void testcontrolValueFile6() throws Throwable {
    builder()
      .name(Paths.get("filter", "map33_filter2"))
      .transtype(PREPROCESS)
      .input(Paths.get("map33.ditamap"))
      .put("args.filter", Paths.get("filter2.ditaval"))
      .test();
  }

  @Test
  default void testcontrolValueFile7() throws Throwable {
    builder()
      .name(Paths.get("filter", "map33_filter3"))
      .transtype(PREPROCESS)
      .input(Paths.get("map33.ditamap"))
      .put("args.filter", Paths.get("filter3.ditaval"))
      .test();
  }

  @Test
  default void testcontrolValueFile8() throws Throwable {
    builder()
      .name(Paths.get("filter", "map13_flag"))
      .transtype(XHTML)
      .input(Paths.get("map13.ditamap"))
      .put("args.filter", Paths.get("flag.ditaval"))
      .test();
  }

  @Test
  default void testcontrolValueFile9() throws Throwable {
    builder()
      .name(Paths.get("filter", "map13_flag2"))
      .transtype(XHTML)
      .input(Paths.get("map13.ditamap"))
      .put("args.filter", Paths.get("flag2.ditaval"))
      .test();
  }

  @Test
  default void testcontrolValueFile10() throws Throwable {
    builder()
      .name(Paths.get("filter", "map33_flag"))
      .transtype(XHTML)
      .input(Paths.get("map33.ditamap"))
      .put("args.filter", Paths.get("flag.ditaval"))
      .test();
  }

  @Test
  default void testcontrolValueFile11() throws Throwable {
    builder()
      .name(Paths.get("filter", "map33_flag2"))
      .transtype(XHTML)
      .input(Paths.get("map33.ditamap"))
      .put("args.filter", Paths.get("flag2.ditaval"))
      .test();
  }
}
