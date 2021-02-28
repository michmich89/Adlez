# Adlez

# About
A Zelda-like game created for the course TDA367 at Chalmers University. 

# Installation tips
Clone Adlez:
```
git clone https://github.com/pontusthome/Adlez.git
```

Import the project in an integrated development environment, (we used Intellij IDEA) and build gradle.

Setup a Run configuration with the following settings:
```
The configuration should be an Application.
Main class: com.mygdx.game.desktop.DesktopLauncher
Working directory: ../Adlez/ProjectAdlez/core/assets
Use of classpath of module: desktop
Java: 1.8
```
Set up Project structure:
```
Modules => core => dependencies
Mark JUNIT and change Scope to compile.
```
