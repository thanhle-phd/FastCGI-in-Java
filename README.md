# fastCGI-in-Java
FastCGI programming in Java: library and a demo program. \
The Java library is from libfcgi-dev Debian package.\
# How to compile the program
- Compile the library and export class files to current directory\
javac -d . libfcgi-java/*.java\
- Compile the main program\
javac tnFCGI.java\
- Build program JAR file\
jar cvfm tnFCGI.jar tnFCGI.MF *.class\
# How to run the program
## Prerequisites
- Web server that supports fast CGI, NGINX for example\
## Run program using nginx on Linux (Ubuntu/Debian)
- Setup the program to run as a service (please check systemd)
- Configure NGINX to talk with the program using fastCGI
Here below is an example of NGINX web setting\
> 1
> 2
