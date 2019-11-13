java -jar CSC499_HW1.jar ascend
results1=(comm output.txt expectedUp.txt)

java -jar CSC499_HW1.jar descend
results2=(comm output.txt expectedDown.txt)

if(results1==1 && results2 ==1);
    exit 1
else
    exit 1

exit results1 && results2