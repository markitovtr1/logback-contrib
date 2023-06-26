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
plugins {
  id("com.github.hierynomus.license") version "0.16.1"
  id("io.github.gradle-nexus.publish-plugin") version "1.3.0"
}

nexusPublishing {
  repositories.sonatype {
    nexusUrl.set(uri("https://s01.oss.sonatype.org/service/local/"))
    snapshotRepositoryUrl.set(uri("https://s01.oss.sonatype.org/content/repositories/snapshots/"))
  }
}

license {
  header = rootProject.file("license-template.txt")
  strictCheck = true

  mapping("kts", "JAVADOC_STYLE")

  ext["owner"] = "The logback-contrib developers"
  ext["year"] = "2016"
  ext["email"] = "logback-user@qos.ch"
}

tasks.register("licenseCheckForKts", com.hierynomus.gradle.license.tasks.LicenseCheck::class) {
  source =
      fileTree(project.projectDir) {
        include("**/*.kts")
        exclude("**/build/**/*.kts")
      }
}

tasks["license"].dependsOn("licenseCheckForKts")

tasks.register("licenseFormatForKts", com.hierynomus.gradle.license.tasks.LicenseFormat::class) {
  source =
      fileTree(project.projectDir) {
        include("**/*.kts")
        exclude("**/build/**/*.kts")
      }
}

tasks["licenseFormat"].dependsOn("licenseFormatForKts")
