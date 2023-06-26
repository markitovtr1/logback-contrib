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
  `java-library`
  `maven-publish`
  signing
}

repositories {
  mavenLocal()
  mavenCentral()
  maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots") }
}

dependencies {
  testImplementation("org.mockito:mockito-core:2.0.44-beta")
  testImplementation("junit:junit:4.8.2")
  testImplementation("org.hamcrest:hamcrest-junit:2.0.0.0")
}

interface MavenConfig {
  val name: Property<String>
}

val mavenConfig = extensions.create<MavenConfig>("mavenConfig")

group = "ch.qos.logback.contrib"

version = "0.1.6-SNAPSHOT"

val projectDescription = description

java.sourceCompatibility = JavaVersion.VERSION_1_8

java {
  withJavadocJar()
  withSourcesJar()
}

publishing {
  publications.create<MavenPublication>("maven") {
    from(components["java"])

    pom {
      name.set(mavenConfig.name)
      url.set("https://github.com/qos-ch/logback-contrib/wiki")
      description.set(
          """
            Logback Contrib provides community-driven and supported
            extensions to the Logback logging framework. All contributions
            are made by contributors with CLA on file.
          """
              .trimIndent())
      inceptionYear.set("2012")

      licenses {
        license {
          name.set("Eclipse Public License - v 1.0")
          url.set("http://www.eclipse.org/legal/epl-v10.html")
        }

        license {
          name.set("GNU Lesser General Public License")
          url.set("http://www.gnu.org/licenses/old-licenses/lgpl-2.1.html")
        }
      }

      scm {
        url.set("https://github.com/qos-ch/logback-contrib")
        connection.set("scm:git:git://github.com/qos-ch/logback-contrib.git")
        developerConnection.set("scm:git:git@github.com:qos-ch/logback-contrib.git")
      }

      issueManagement {
        system.set("GitHub")
        url.set("https://github.com/qos-ch/logback-contrib/issues")
      }

      developers {
        developer {
          id.set("lhazlewood")
          name.set("Les Hazlewood")
          email.set("les@hazlewood.com")
          url.set("http://www.leshazlewood.com")
          timezone.set("-8")
        }

        developer {
          id.set("belaso")
          name.set("Christian Trutz")
          email.set("christian.trutz@belaso.de")
          url.set("http://www.belaso.de")
          timezone.set("+2")
        }

        developer {
          id.set("tony19")
          name.set("Tony Trinh")
          email.set("tony19@gmail.com")
          url.set("http://tony19.github.com")
          timezone.set("-5")
        }
      }

      contributors {
        contributor {
          name.set("David J. M. Karlsen")
          email.set("david@davidkarlsen.com")
        }

        contributor {
          name.set("Espen A. Fossen")
          email.set("espenaf@junta.no")
        }
      }
    }
  }
}

signing {
  sign(publishing.publications.getByName("maven"))
}

tasks.withType<JavaCompile> { options.encoding = "UTF-8" }

tasks.withType<Javadoc> {
  options {
    encoding = "UTF-8"
    (this as CoreJavadocOptions).addStringOption("Xdoclint:none", "-quiet")
  }
}
