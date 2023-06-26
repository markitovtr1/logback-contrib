/**
 * Copyright (C) 2016, The logback-contrib developers. All rights reserved.
 *
 * This program and the accompanying materials are dual-licensed under either the terms of the
 * Eclipse Public License v1.0 as published by the Eclipse Foundation
 *
 * or (per the licensee's choosing)
 *
 * under the terms of the GNU Lesser General Public License version 2.1 as published by the Free
 * Software Foundation.
 */
rootProject.name = "logback-contrib-parent"

include(":logback-jackson")

include(":logback-json-access")

include(":logback-json-classic")

include(":logback-json-parent")

include(":logback-json-core")

project(":logback-jackson").projectDir = file("jackson")

project(":logback-json-access").projectDir = file("json/access")

project(":logback-json-classic").projectDir = file("json/classic")

project(":logback-json-parent").projectDir = file("json")

project(":logback-json-core").projectDir = file("json/core")

dependencyResolutionManagement {
  versionCatalogs {
    create("libs") {
      version("logback", "1.1.8")
      version("jackson", "2.8.5")
      version("javax", "2.5")

      library("logback-access", "ch.qos.logback", "logback-access").versionRef("logback")
      library("logback-classic", "ch.qos.logback", "logback-classic").versionRef("logback")
      library("logback-core", "ch.qos.logback", "logback-core").versionRef("logback")
      library("jackson", "com.fasterxml.jackson.core", "jackson-databind").versionRef("jackson")
      library("javax-servlet-api", "javax.servlet", "servlet-api").versionRef("javax")
    }
  }
}
