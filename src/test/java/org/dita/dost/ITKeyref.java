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
public interface ITKeyref {
  AbstractIntegrationTest builder();

  @Test
  default void testkeyref() throws Throwable {
    builder().name(Paths.get("keyref", "basic")).transtype(PREPROCESS).input(Paths.get("test.ditamap")).test();
  }

  @Test
  default void testkeyrefKeywordConref() throws Throwable {
    builder().name(Paths.get("keyref", "keyword_conref")).transtype(PREPROCESS).input(Paths.get("test.ditamap")).test();
  }

  @Test
  default void testkeyref_dupkey() throws Throwable {
    builder()
      .name(Paths.get("keyref", "keyref_dupkey"))
      .transtype(XHTML)
      .input(Paths.get("keyref-test-01.ditamap"))
      .test();
  }

  @Test
  default void testkeyref_to_keyref() throws Throwable {
    builder()
      .name(Paths.get("keyref", "keyref_to_keyref"))
      .transtype(XHTML)
      .input(Paths.get("keyref-test-01.ditamap"))
      .test();
  }

  @Test
  default void testkeyref_All_tags() throws Throwable {
    builder()
      .name(Paths.get("keyref", "keyref_All_tags"))
      .transtype(XHTML)
      .input(Paths.get("mp_author1.ditamap"))
      .warnCount(1)
      .test();
  }

  @Test
  default void testkeyref_Keyword_links() throws Throwable {
    builder()
      .name(Paths.get("keyref", "keyref_Keyword_links"))
      .transtype(XHTML)
      .input(Paths.get("mp_author1.ditamap"))
      .test();
  }

  @Test
  default void testkeyref_Redirect_conref_1() throws Throwable {
    builder()
      .name(Paths.get("keyref", "keyref_Redirect_conref_1"))
      .transtype(XHTML)
      .input(Paths.get("mp_author1.ditamap"))
      .test();
  }

  @Test
  default void testkeyref_Redirect_conref_2() throws Throwable {
    builder()
      .name(Paths.get("keyref", "keyref_Redirect_conref_2"))
      .transtype(XHTML)
      .input(Paths.get("mp_author2.ditamap"))
      .test();
  }

  @Test
  default void testkeyref_Redirect_link_or_xref_1() throws Throwable {
    builder()
      .name(Paths.get("keyref", "keyref_Redirect_link_or_xref_1"))
      .transtype(XHTML)
      .input(Paths.get("mp_author1.ditamap"))
      .test();
  }

  @Test
  default void testkeyref_Redirect_link_or_xref_2() throws Throwable {
    builder()
      .name(Paths.get("keyref", "keyref_Redirect_link_or_xref_2"))
      .transtype(XHTML)
      .input(Paths.get("mp_author2.ditamap"))
      .test();
  }

  @Test
  default void testkeyref_Redirect_link_or_xref_3() throws Throwable {
    builder()
      .name(Paths.get("keyref", "keyref_Redirect_link_or_xref_3"))
      .transtype(XHTML)
      .input(Paths.get("mp_author3.ditamap"))
      .test();
  }

  @Test
  default void testkeyref_Redirect_link_or_xref_4() throws Throwable {
    builder()
      .name(Paths.get("keyref", "keyref_Redirect_link_or_xref_4"))
      .transtype(XHTML)
      .input(Paths.get("mp_author4.ditamap"))
      .test();
  }

  @Test
  default void testkeyref_Redirect_link_or_xref_5() throws Throwable {
    builder()
      .name(Paths.get("keyref", "keyref_Redirect_link_or_xref_5"))
      .transtype(XHTML)
      .input(Paths.get("mp_author5.ditamap"))
      .test();
  }

  @Test
  default void testkeyref_Redirect_link_or_xref_6() throws Throwable {
    builder()
      .name(Paths.get("keyref", "keyref_Redirect_link_or_xref_6"))
      .transtype(XHTML)
      .input(Paths.get("mp_author6.ditamap"))
      .test();
  }

  @Test
  default void testkeyref_Splitting_combining_targets1() throws Throwable {
    builder()
      .name(Paths.get("keyref", "keyref_Splitting_combining_targets_1"))
      .transtype(XHTML)
      .input(Paths.get("mp_author1.ditamap"))
      .test();
  }

  @Test
  default void testkeyref_Splitting_combining_targets2() throws Throwable {
    builder()
      .name(Paths.get("keyref", "keyref_Splitting_combining_targets_2"))
      .transtype(XHTML)
      .input(Paths.get("mp_author2.ditamap"))
      .test();
  }

  @Test
  default void testkeyref_Splitting_combining_targets3() throws Throwable {
    builder()
      .name(Paths.get("keyref", "keyref_Splitting_combining_targets_3"))
      .transtype(XHTML)
      .input(Paths.get("mp_author3.ditamap"))
      .test();
  }

  @Test
  default void testkeyref_Swap_out_variable_content() throws Throwable {
    builder()
      .name(Paths.get("keyref", "keyref_Swap_out_variable_content"))
      .transtype(XHTML)
      .input(Paths.get("mp_author1.ditamap"))
      .test();
  }

  @Test
  default void testkeyref_modify() throws Throwable {
    builder()
      .name(Paths.get("keyref", "keyref_modify"))
      .transtype(XHTML)
      .input(Paths.get("mp_author1.ditamap"))
      .warnCount(1)
      .test();
  }
}
