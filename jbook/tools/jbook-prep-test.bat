@echo off
REM Run the tests in the target directory (or file)
REM Tests are preprocessed with java-fan preprocessor.

REM the fully qualified path to the current directory
SET JBOOK_TOOLS_DIR=%~dp0

%JBOOK_TOOLS_DIR%\bash-run.bat %JBOOK_TOOLS_DIR%\jbook-prep-test.sh %1
