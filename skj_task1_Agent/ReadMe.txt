Ok.. It hard to write about every thing what and how it is working..

I'he done full task with extra points;
 . read config file
 . parse it to Tree
 . Server & Clients (TCP)
 . commands ADD/REMOVE/MODIFY
 . HTML page of global tree (on localhost:8080)

//global tree == globalForest/GF

I left a lot of comment, they help to understand the way this program is working.
Few things i wanted say, is that i refused to take agents "ip" and "port" as an arguments to th program, i think we can fill every thing in  config file.
So one parameter the program is accept is path to our config file, if this parameter is null, the program will look for "config.txt" is the same folder the program is.

About classes... 
Its easy to understand, what classes do by reading there names.
I have a lot of they) to make my main class clean and candy.

 . class Tree
 . class Agent
 . class Pack
they are all collection classes..

 . class CommandListener
 . class CommandParser
 . class MyFileReader
 . class NeighbourCheck
 . class String2Tree
they are all functional classes...

 . class TCPServer
 . class TCPClient
 . class WebServer
they are also functional classes, but these classes help to deal with networking

If any questions, i would like to answer on it)
Mykyta Lazariev s15928