/*
 * This file is part of the DITA Open Toolkit project.
 *
 * Copyright 2017 Jarno Elovirta
 *
 *  See the accompanying LICENSE file for applicable license.
 */

package org.dita.dost;

import static org.dita.dost.AbstractIntegrationTest.Transtype.*;

import java.nio.file.Path;
import java.nio.file.Paths;

public class IntegrationTestXhtmlWithPreprocess2 extends IntegrationTestXhtml {

  public IntegrationTestXhtmlWithPreprocess2 builder() {
    return new IntegrationTestXhtmlWithPreprocess2();
  }

  @Override
  Transtype getTranstype(Transtype transtype) {
    switch (transtype) {
      case XHTML:
        return XHTML_WITH_PREPROCESS2;
      default:
        return transtype;
    }
  }
}
