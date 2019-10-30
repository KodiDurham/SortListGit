@echo off
java -jar CSC499_HW1.jar ascend
echo Ascending Order Test:
FC output.txt expectedUp.txt

java -jar CSC499_HW1.jar descend
echo Descending Order Test:
FC output.txt expectedDown.txt

pause
