/*
 * This file is part of the DITA Open Toolkit project.
 *
 * Copyright 2016 Jarno Elovirta
 *
 *  See the accompanying LICENSE file for applicable license.
 */

package org.dita.dost;

import static org.dita.dost.AbstractIntegrationTest.Transtype.HTML5;
import static org.dita.dost.AbstractIntegrationTest.resourceDir;

import java.io.File;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
interface ITDitaval {
  AbstractIntegrationTest builder();

  @Test
  default void html5_ditaval_passthrough_all() throws Throwable {
    final File srcDir = new File(resourceDir, "html5_ditaval" + File.separator + "src");
    builder()
      .name("html5_ditaval")
      .transtype(HTML5)
      .input(Paths.get("all.ditamap"))
      .put("validate", "no")
      .put("dita.input.valfile", new File(srcDir, "all.ditaval").getAbsolutePath())
      .warnCount(1)
      .test();
  }

  @Test
  default void html5_ditaval_passthrough_groups_all() throws Throwable {
    final File srcDir = new File(resourceDir, "html5_ditaval_groups" + File.separator + "src");
    builder()
      .name("html5_ditaval_groups")
      .transtype(HTML5)
      .input(Paths.get("all.dita"))
      .put("validate", "no")
      .put("dita.input.valfile", new File(srcDir, "all.ditaval").getAbsolutePath())
      .warnCount(1)
      .test();
  }
}
