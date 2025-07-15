/*
 * This file is part of the DITA Open Toolkit project.
 *
 * Copyright 2016 Jarno Elovirta
 *
 *  See the accompanying LICENSE file for applicable license.
 */

package org.dita.dost;

import static org.dita.dost.AbstractIntegrationTest.Transtype.PREPROCESS;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Paths;
import org.dita.dost.reader.GrammarPoolManager;
import org.ditang.relaxng.defaults.pool.RNGDefaultsEnabledSynchronizedXMLGrammarPoolImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public interface ITValidate {
  AbstractIntegrationTest builder();

  @Test
  default void testRng() throws Throwable {
    builder().name("rng").transtype(PREPROCESS).input(Paths.get("root.ditamap")).test();
  }

  @Test
  default void testRngGrammarPool() throws Throwable {
    RNGDefaultsEnabledSynchronizedXMLGrammarPoolImpl grammarPool =
      (RNGDefaultsEnabledSynchronizedXMLGrammarPoolImpl) GrammarPoolManager.getGrammarPool();
    grammarPool.clear();
    builder().name("bookmap-rng-based").transtype(PREPROCESS).input(Paths.get("main.ditamap")).test();
    assertEquals(3, grammarPool.getCacheSize());
  }

  @Test
  default void testRngNoGrammarPool() throws Throwable {
    RNGDefaultsEnabledSynchronizedXMLGrammarPoolImpl grammarPool =
      (RNGDefaultsEnabledSynchronizedXMLGrammarPoolImpl) GrammarPoolManager.getGrammarPool();
    grammarPool.clear();
    builder()
      .name("bookmap-rng-based")
      .transtype(PREPROCESS)
      .input(Paths.get("main.ditamap"))
      .put("args.grammar.cache", "no")
      .test();
    assertEquals(0, grammarPool.getCacheSize());
  }

  @Test
  default void testRngGrammarPoolValidate() throws Throwable {
    builder()
      .name("bookmap-rng-based-validate")
      .transtype(PREPROCESS)
      .input(Paths.get("main.ditamap"))
      .put("validate", "true")
      .errorCount(1)
      .test();
  }

  @Test
  default void testRngGrammarPoolNoValidate() throws Throwable {
    builder()
      .name("bookmap-rng-based-no-validate")
      .transtype(PREPROCESS)
      .input(Paths.get("main.ditamap"))
      .put("validate", "false")
      .warnCount(1)
      .errorCount(0)
      .test();
  }

  @Test
  default void testXSDValidate() throws Throwable {
    builder()
      .name("bookmap-xsd-based-validate")
      .transtype(PREPROCESS)
      .input(Paths.get("main.ditamap"))
      .put("validate", "true")
      .warnCount(0)
      .errorCount(0)
      .test();
  }
}
