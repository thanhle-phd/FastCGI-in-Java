# fastCGI-in-Java
FastCGI programming in Java: library and demo program

# How to compile the program
- compile the library and export class files to current directory\
javac -d . libfcgi-java/*.java\
- compile the main program\
javac tnFCGI.java\
- build program JAR file\
jar cvfm tnFCGI.jar tnFCGI.MF *.class\
