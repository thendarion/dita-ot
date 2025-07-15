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
public interface ITConref {
  AbstractIntegrationTest builder();

  @Test
  default void testconrefend() throws Throwable {
    builder().name(Paths.get("conref", "conrefend")).transtype(PREPROCESS).input(Paths.get("range.ditamap")).test();
  }

  @Test
  default void testcoderef_source() throws Throwable {
    builder()
      .name("coderef_source")
      .transtype(PREPROCESS)
      .input(Paths.get("mp.ditamap"))
      .put("transtype", "preprocess")
      .put("dita.ext", ".dita")
      .put("validate", "false")
      .warnCount(1)
      .test();
  }

  @Test
  default void testconref() throws Throwable {
    builder()
      .name(Paths.get("conref", "basic"))
      .transtype(PREPROCESS)
      .input(Paths.get("lang-common1.dita"))
      .put("validate", "false")
      .warnCount(2)
      .test();
  }

  @Test
  default void testconref_to_specialization() throws Throwable {
    builder()
      .name(Paths.get("conref", "conref_to_specialization"))
      .transtype(PREPROCESS)
      .input(Paths.get("conref_to_specialization.dita"))
      .put("validate", "false")
      .warnCount(1)
      .test();
  }

  @Test
  default void testconrefbreaksxref() throws Throwable {
    builder()
      .name(Paths.get("conref", "conrefbreaksxref"))
      .transtype(PREPROCESS)
      .input(Paths.get("conrefbreaksxref.dita"))
      .test();
  }

  @Test
  default void testconrefinsubmap() throws Throwable {
    builder()
      .name(Paths.get("conref", "conrefinsubmap"))
      .transtype(PREPROCESS)
      .input(Paths.get("rootmap.ditamap"))
      .test();
  }

  @Test
  default void testconrefmissingfile() throws Throwable {
    builder()
      .name(Paths.get("conref", "conrefmissingfile"))
      .transtype(PREPROCESS)
      .input(Paths.get("badconref.dita"))
      .put("validate", "false")
      .warnCount(1)
      .errorCount(2)
      .test();
  }

  @Test
  default void testconref_with_xref() throws Throwable {
    builder()
      .name(Paths.get("conref", "conref_with_xref"))
      .transtype(XHTML)
      .input(Paths.get("test-conref-xref-keyref-bug.ditamap"))
      .test();
  }

  @Test
  default void testconref_pushreplace() throws Throwable {
    builder().name(Paths.get("conref", "conref_pushreplace")).transtype(XHTML).input(Paths.get("test.ditamap")).test();
  }

  @Test
  default void testconref_topiconly() throws Throwable {
    builder()
      .name(Paths.get("conref", "conref_topiconly"))
      .transtype(XHTML)
      .input(Paths.get("conref_to_self.dita"))
      .put("validate", "false")
      .warnCount(1)
      .test();
  }

  @Test
  default void testconkeyref_push() throws Throwable {
    builder()
      .name(Paths.get("conref", "conkeyref_push"))
      .transtype(PREPROCESS)
      .input(Paths.get("conref-push-test.ditamap"))
      .put("dita.ext", ".dita")
      .test();
  }
}
