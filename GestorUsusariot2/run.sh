#!/bin/bash
# Compila y ejecuta el proyecto (Linux / macOS)
set -e
SRC="src"
OUT="out"
mkdir -p "$OUT"
javac -encoding UTF-8 -d "$OUT" -sourcepath "$SRC" $(find "$SRC" -name "*.java")
echo "Compilado. Ejecutando..."
java -cp "$OUT" gestor.MainLauncher
