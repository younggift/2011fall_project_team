color 0a
@echo off
echo           ����֮ǰ�������з����������û�б�������.class
echo           �ļ����Ǿ�������compile.bat
echo           ��Ϸ���ԣ����������̵��������ͻ��������ڼ������
echo���������������������X�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�[
echo���������������������U��������Ϸ���ԣ�ֱ�ӵ����������̡����U
echo�������������X�T�T�T�m�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�m�T�T�T�[
echo�������������U�����������������������������������������������������U
echo�������������U��������1�����С����� 2���˳���������       ������ �U
echo�������������U�����������������������������������������������������U
echo�������������^�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�a
echo.��
SET /P Choice=������������ѡ��Ҫ���еĲ���[1-2]��Ȼ��س���
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
echo.��Ϸ�������У���������˳�
pause >nul
goto End
:End
cls
color 0f
popd


