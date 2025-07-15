/*
 * This file is part of the DITA Open Toolkit project.
 *
 * Copyright 2016 Jarno Elovirta
 *
 *  See the accompanying LICENSE file for applicable license.
 */

package org.dita.dost;

import static org.dita.dost.AbstractIntegrationTest.Transtype.PREPROCESS;

import java.nio.file.Paths;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
interface ITCopyTo {
  AbstractIntegrationTest builder();

  @Test
  default void testcopyto_extensions_metadata() throws Throwable {
    builder()
      .name(Paths.get("copyto", "copyto_extensions_metadata"))
      .transtype(PREPROCESS)
      .input(Paths.get("TC1.ditamap"))
      .warnCount(3)
      .test();
  }

  @Test
  default void testcopyto() throws Throwable {
    builder()
      .name(Paths.get("copyto", "basic"))
      .transtype(PREPROCESS)
      .input(Paths.get("TC2.ditamap"))
      .warnCount(2)
      .test();
  }

  @Test
  default void testcopyto_sametarget() throws Throwable {
    builder()
      .name(Paths.get("copyto", "copyto_sametarget"))
      .transtype(PREPROCESS)
      .input(Paths.get("TC3.ditamap"))
      .warnCount(3)
      .test();
  }

  @Test
  default void testcopyto_circulartarget() throws Throwable {
    builder()
      .name(Paths.get("copyto", "copyto_circulartarget"))
      .transtype(PREPROCESS)
      .input(Paths.get("TC4.ditamap"))
      .test();
  }

  @Test
  default void testcopyto_linktarget() throws Throwable {
    builder()
      .name(Paths.get("copyto", "copyto_linktarget"))
      .transtype(PREPROCESS)
      .input(Paths.get("linktarget.ditamap"))
      .errorCount(2)
      .warnCount(0)
      .test();
  }

  @Test
  default void testcopyto_sametarget2() throws Throwable {
    builder()
      .name(Paths.get("copyto", "copyto_sametarget2"))
      .transtype(PREPROCESS)
      .input(Paths.get("TC6.ditamap"))
      .warnCount(4)
      .test();
  }
}
