# Demonstration of circular dependency

## Error (run company:core main.kt)

```text
Circular dependency between the following tasks:
:company:core:classes
\--- :company:core:compileJava
     +--- :company:core:compileKotlin
     |    \--- :company:core:jar
     |         +--- :company:core:classes (*)
     |         +--- :company:core:compileJava (*)
     |         \--- :company:core:compileKotlin (*)
     \--- :company:core:jar (*)
```

## Project structure

```text
.
??? buildSrc
?   ??? build.gradle.kts
?   ??? settings.gradle.kts
?   ??? src
?       ??? main
?           ??? kotlin
?               ??? buildSrc.common.gradle.kts
??? company
?   ??? app
?   ?   ??? build.gradle.kts ---------------- implementation("company:core", ":shared:core", ":shared:app")
?   ?   ??? src
?   ?       ??? main
?   ?           ??? kotlin
?   ?               ??? main.kt
?   ??? core
?       ??? build.gradle.kts ---------------- implementation(":shared:core", ":shared:app")
?       ??? src
?           ??? main
?               ??? kotlin
?                   ??? main.kt
??? shared
    ??? app
    ?   ??? build.gradle.kts ---------------- implementation(":shared:core")
    ?   ??? src
    ?       ??? main
    ?           ??? kotlin
    ?               ??? SharedApp.kt
    ??? core
        ??? build.gradle.kts
        ??? src
            ??? main
                ??? kotlin
                    ??? SharedCore.kt
??? settings.gradle.kts      -----------------include("shared:core", "shared:app", "company:core", "company:app")


```
