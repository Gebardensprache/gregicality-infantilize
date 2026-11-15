plugins {
    id("java-toolchain")
    id("shadow")
    id("minecraft")
    id("ide")
    id("repositories")
    id("publishing")
    id("test")
}

dependencies {
    compileOnlyApi(libs.annotations)
    compileOnlyApi(libs.jspecify)

    implementation(deobf.of(libs.jei))
    implementation(deobf.of(libs.theOneProbe))

    implementation(libs.modularui) {
        isTransitive = false
    }

    api(libs.codeChickenLib) {
        isTransitive = false
    }

    implementation(deobf.of(files("libs/morphismlib-1.12.2-1.0.0.jar")))
    implementation(deobf.of(files("libs/gregtech-1.12.2-master-#2901.jar")))
}

configurations {
    compileOnly {
        // exclude GNU trove, FastUtil is superior and still updated
        exclude(group = "net.sf.trove4j", module = "trove4j")
        // exclude javax.annotation from findbugs, jetbrains annotations are superior
        exclude(group = "com.google.code.findbugs", module = "jsr305")
        // exclude scala as we don't use it for anything and causes import confusion
        exclude(group = "org.scala-lang")
        exclude(group = "org.scala-lang.modules")
        exclude(group = "org.scala-lang.plugins")
    }
}
