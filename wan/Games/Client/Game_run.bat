color 0a
@echo off
echo           测试之前，先运行服务器，如果没有编译生成.class
echo           文件，那就先运行compile.bat
echo           游戏测试，用三个进程调用三个客户端运行在计算机上
echo　　　　　　　　　　╔══════════════════╗
echo　　　　　　　　　　║　　　游戏测试，直接调用三个进程　　║
echo　　　　　　╔═══╩══════════════════╩═══╗
echo　　　　　　║　　　　　　　　　　　　　　　　　　　　　　　　　　║
echo　　　　　　║　　　　1、运行　　　 2、退出　　　　       　　　 ║
echo　　　　　　║　　　　　　　　　　　　　　　　　　　　　　　　　　║
echo　　　　　　╚══════════════════════════╝
echo.　
SET /P Choice=　　　　　请选择要进行的操作[1-2]，然后回车：
cls
echo.
If "%Choice%"=="" Goto Start
Set Choice=%Choice:~0,1%
if /I "%Choice%"=="1" goto Run
if /I "%Choice%"=="2" goto End
goto End

:Run
cd src/classes
java MainClient
echo.游戏正在运行，按任意键退出
pause >nul
goto End
:End
cls
color 0f
popd


