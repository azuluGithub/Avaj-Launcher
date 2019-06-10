find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
java azulu.main.Main scenario.txt
