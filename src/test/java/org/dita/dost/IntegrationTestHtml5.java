/*
 * This file is part of the DITA Open Toolkit project.
 *
 * Copyright 2018 Jarno Elovirta
 *
 * See the accompanying LICENSE file for applicable license.
 */

package org.dita.dost;

import static org.dita.dost.AbstractIntegrationTest.Transtype.HTML5;
import static org.dita.dost.AbstractIntegrationTest.Transtype.PREPROCESS2;

public class IntegrationTestHtml5
  extends AbstractIntegrationTest
  implements ITBookmap, ITConref, ITCopyTo, ITCss, ITDitaval, ITFilter, ITKeyref, ITMisc, ITValidate {

  public AbstractIntegrationTest builder() {
    return new IntegrationTestHtml5();
  }

  @Override
  Transtype getTranstype(Transtype transtype) {
    return switch (transtype) {
      case PREPROCESS -> PREPROCESS2;
      case XHTML -> HTML5;
      default -> transtype;
    };
  }
}
