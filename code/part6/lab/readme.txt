In this lab, we will design a Writer that will write a series of strings to a 
file. We will design in a way that the user of the Writer class does not have 
to worry about anything other than directing what to write. For example, a 
user of the Writer may want to do something like (pseudocode):

Writer.open("output.txt")
  write("This is line one\n")
  write("This is line two\n")
  write("This is yet another line\n")
  
There should be as little to the syntax as possible to accomplish something like the above code. When the program terminates, the output.txt file should contain the three lines:
This is line one
This is line two
This is yet another line