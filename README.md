# u-thread-critical-section
Adder Subtractor

Critical section [Race Conditon]- thread safe : deposite/withdrawl use synchrosined k/w (object lvl and function() lvl)

1. When we are doing thread waiting in runnable side -> then less frequent and less random behaviour of SR
   can be seen (since threads are waited from runnable side and when resolved then approached to SR. SR is almost atomic)
   so every time whenever a threads comes (irrsp of its time), race condition is not occuring frequently.

2. Now, for in threadcreator2 package, thread comes all together in SR all at a time, all are almost stop / waited while 
   exceuting half of SR, so its highly highlt possible to change SR behaviour by other thread. Hence, more frequent (100%)
   of the time, SR value is abrubt.