all: TestJava                                                            

OBJS = Test* test*

CC = gcc
JAVAC = javac
CP = g++
CFLAGS = -std=c99 -O2 -g

TestJava: TestJava.java
	$(JAVAC) TestJava.java

testC: testC.c
	$(CC) $(CFLAGS) -c testC.c
	$(CC) -o testC testC.o 

testCpp: testCpp.cpp
	$(CP) -o testCpp testCpp.cpp   

clean:
	rm -f $(OBJS) *~
