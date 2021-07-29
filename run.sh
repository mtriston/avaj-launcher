find * -name "*.java" > sources.txt

mkdir -p target
javac -d target @sources.txt

java -cp target ro.academyplus.avaj.app.Program scenario.txt