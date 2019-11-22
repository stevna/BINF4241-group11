#Assignment 3
##Class diagram

1:Class diagram of our home automation system
![Iterator_ClassDiagram](./img/classdiagram.JPG)

Explanation:  
Since we did not find it helpful to have a class diagram with a large amount classes, which would only be confusing, we decided to sum up the command classes.  
There are a handful of commands where we decided that starting a thread would make sense, since their execution takes longer(eg. timers) and otherwise would stop the rest of the program. These are basically commands like the others, but also implements the runnable Interface. Like that, they could be executed without interrupting the whole execution.
We also decided usability wise to let the user insert numbers rather than a whole String. He always can get a step back when he inserts -1, without changing the state of the device.



Also we did not see in time the post on the Olat forum about the cleaning robot always being turned on. Thus we implemented, that you have to start the vacuum cleaner first, which basically turn the robot on. Then the other functions get accessible.