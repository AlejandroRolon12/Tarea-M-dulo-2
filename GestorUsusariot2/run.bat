@echo off
REM Compila y ejecuta el proyecto (Windows)
set SRC=src
set OUT=out
if not exist %OUT% mkdir %OUT%
for /f "delims=" %%f in ('dir /b /s %SRC%\*.java') do (
  set FILES=!FILES! "%%f"
)
javac -encoding UTF-8 -d %OUT% -sourcepath %SRC% %SRC%\gestor\*.java
if errorlevel 1 (
  echo Compilation failed.
  pause
  exit /b 1
)
echo Compilado. Ejecutando...
java -cp %OUT% gestor.MainLauncher
pause
