# Locus Tetris Challenge #

## Story so far ##
> This story is based on facts at Locus. Any similarity with fictitious events or characters is purely coincidental.

Folks at Locus believed that 'good engineers' are almost always the ones that are valued internally & are well settled in their job. They usually dont switch jobs often. There is definitely a caveat - folks who switched & figured it is not the right place - but then, lets treat them as outliers. Most of the time, people have shorter duration in companies because they are inherently looking to switch. Lets call them 'not so good' engineers. 

Statistics show - folks who switch often are better at solving Algo/DS problems compared to the ones who dont switch often. The regular Algo/DS based hiring helps in 0/1 evaluation but the system has been broken & systemtically hacked by the engineers who are not the best out there primarily because they are switching often. It puts the 'good engineers' on a disadvantageous position. Looking for a job is a painful process of brushing up your Algo/DS skills, spending time on GeeksForGeeks, Leetcode etc, waste time of companies you dont want to work with by doing redundant interviews & then appearing for the interviews of the companies you actually want to work with. There is some serious but totally unnecessary optimizations one has to do. This is a negative feedback loop for good engineers as this demotivates them further to even apply for jobs/interviews. 

Hiring process at Locus is designed to favor the 'good engineers' over the others. If you are good at your daily job of working with code, this assignment should actually make you feel home. If it does not, please pass it as feedback to ashish@locus.sh . 

Before the assignment, Locus engineers tested folks on a RBAC (role based access control) problem. The focus was to check if the person can

1. Write clean/production code
2. Understand OOPS concept & can implement them on the ground 

There were challenges in terms of less reverts on the problem typically because it was left open ended & required decent amount of time. This assignment serves as a replacement to it. This challenge is 

1. Easy to get started as you get a sample app & steps to setup the code. You should be able to do it within half an hour max.
2. Fun because you can see it in action the moment you set it up
3. Easy to understand. It should take you not more than 20 min to get the code understanding once you have it running. 
4. Close to the real world problem where you add code to an existing codebase & not build something from scratch.
5. Now the tricky part - the challenge ask you to create a new feature. This can take upto 10 min to an hour depending on your problem solving skill & practical understanding of OOP concepts. 

## The Challenge ##

You are provided with a command line tetris app written in Java. The rest of the process is designed the way a develop is actually onboarded on a new project or a new company.

### Step 1 - setup the project ###
> Estimated time - 15 min 

Download the project [here](https://drive.google.com/a/duringcoffee.com/file/d/1MzRwlngDegLkxjOW6X9jUmxEWPyDv4L3/view?usp=sharing). It is built using maven. You need to setup maven on your machine or if you are a java guru, you can always get it to work with your choice of build tool. 

The exact launch command is encapsulated in the `tetris` file on the top. Running it on command line should get you started.

> Make sure the Gamepad window is selected otherwise the left right down moves will not work

![Tetris demo gif will appear here](/tetrisdemo.gif?raw=true)


### Step 2 - understand the code ###
> Estimated time - 15 min 

Go throught the code structure to understand how it works. If you are from gaming background, you might have an advantage but this code is written by someone who is not, so no best practices are followed. The code is intentionally kept unclean. 

### Step 3 - create L piece support ###
> Estimated time - 15 min to an hour 

You will see that game only has box piece falling. You mission (if you choose to accept) is to create L piece support which should look like 

```
+---+
|[X]|
+---+
+---+
|[X]|
+---+
+---++---+
|[X]||[X]|
+---++---+
```

**Please note the L shape alignment need to be exactly like above (the tests are going to run to test the same) & the class name should be *LShape*.**

Also note, a future requirement is to create a rotation support for the pieces which is currently not there. While you solve this problem, keep in mind that your design facilitate easy rotation. 

### Bonus step ###

The game has some crucial logic missing which you will be able to figure out once you get it to run. If you have some time left on your timer, try fixing the logic. Or at least, submit your approach. 

### Next steps ###

If we like what you see, we will call you for telephonic interview. In your in-person interview, we will do a joint review & code pair session to work on a few other features & code cleaning. 

## Why this challenge ##

Outside Algo/DS, the only kind of questions left to evaluate are the ones which are scenario based. Either the interviewer provides a complex problem or the interviewee is asked to talk about a problem he has worked on. In the former case, the interviewer is an expert & there is an unfair expectation for the interviewee to be able to think at the same level. In the latter, the interviewer has hardly any motivation to understand the solution deeply. Also, the interviewee could be good at his skill but might not be great at explaining. 


With the current process, Locus tries to provide an even ground. While folks at Locus know about the problem, the interviewee gets an opportunity to display his problem solving on a well defined problem. This is very similar to on job scenario where you work on a already existing codebase & enhance it over time, rather starting from scratch. 
