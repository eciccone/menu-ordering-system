# menu-ordering-system

For my solution to the Evive Engineering take home test, I completed the project using the programming language Java. 

### Running the project locally

**These instructions assume you are using a UNIX based system such as Linux or MacOS**

To run my solution locally first clone the project to your local machine.

To do this using the command line, execute the following command:

```
~$ git clone https://github.com/eciccone/menu-ordering-system.git
```

Then change into the cloned directory by executing the following command:

```
~$ cd menu-ordering-system
```

After changing directories, now you should compile the java project and store the executable files into a folder called output.

The following command will compile the project and store the compiled files into a folder named output:

```
~$ javac src/*.java src/items/*.java src/menus/*.java src/orders/*.java -d output
```

Once the files have been compiled change into the newly created output directory.

```
~$ cd output
```

After changing into the output directory you can now run the project. To run the project execute the following command:

```
~$ java MenuOrderingSystem
```
