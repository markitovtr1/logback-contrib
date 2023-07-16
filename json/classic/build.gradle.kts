/**
 * Copyright (C) 2016, The logback-contrib developers. All rights reserved.
 *
 * This program and the accompanying materials are dual-licensed under
 * either the terms of the Eclipse Public License v1.0 as published by
 * the Eclipse Foundation
 *
 *   or (per the licensee's choosing)
 *
 * under the terms of the GNU Lesser General Public License version 2.1
 * as published by the Free Software Foundation.
 */
plugins { id("br.com.crazycrowd.logback.contrib.java-conventions") }

dependencies {
  api(libs.logback.classic)
  api(project(":logback-json-core"))
}

mavenConfig {
  name.set("Logback Contrib :: JSON :: Classic")
}
