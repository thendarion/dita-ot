/*
 * This file is part of the DITA Open Toolkit project.
 *
 * Copyright 2019 Jarno Elovirta
 *
 * See the accompanying LICENSE file for applicable license.
 */

package org.dita.dost;

public class IntegrationTestXhtml
  extends AbstractIntegrationTest
  implements ITBookmap, ITConref, ITCopyTo, ITFilter, ITKeyref, ITMisc, ITValidate {

  public AbstractIntegrationTest builder() {
    return new IntegrationTestXhtml();
  }

  @Override
  Transtype getTranstype(Transtype transtype) {
    return transtype;
  }
}
