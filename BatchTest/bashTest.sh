java -jar CSC499_HW1.jar ascend
results1=$(diff output.txt expectedUp.txt)

java -jar CSC499_HW1.jar descend
results2=$(diff output.txt expectedDown.txt)

exit $results1 && $results2