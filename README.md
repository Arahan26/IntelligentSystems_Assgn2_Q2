# IntelligentSystems_Assgn2_Q2
Submission for Answer2, Assignment 2 of Intelligent Systems(subject) at Monash University

<b>Answer for the following question. (Follows Simulated Annealing)</b>

Question 2 involves simulated annealing or genetic algorithms.  These stochastic search techniques require the use of a random number generator (RNG) or pseudo-RNG.  The simplest way to generate an event of probability p is to sample a random number x in the range [0, 1], 0 <= x <= 1.  If 0 <= x <= p, then an event of probability p has occurred.  If p < x <= 1, then an event of probability 1-p has occurred. Your program output for each of 2a, 2b, 2c and 2d should be included in your .pdf file. 
In what follows below, it might or might not help to observe the following observations.  Setting y = 1 in the formula from 2d gives the formula from 2c, setting w = 1 in the formula from 2c gives the formula from 2b, setting v = 1 in the formula from 2b gives the formula from 2a. 
For values of u, v and w (in what follows below), it might sometimes be advisable to work to at least 4 decimal places, and it might sometimes be necessary to work to 5 decimal places. 

<b>2a  (17 marks)</b> 
 
Consider the function z = f(u) given by  z = f(u)  =  u sin(1/(0.01 + u2)) + u3 sin(1/(0.001 + u4)) where u is in the range -1 <= u <= 1. 
 
Explaining your steps, write a program - with documentation - in Python (3.5.0) or Java which uses simulated annealing or genetic algorithms to find the largest value of z and the corresponding value of u. Your program should have the option of starting the search at u = 0, at a random value of u, or at a userspecified value of u. Your program should be able to show outputs step-by-step during the search - such as (e.g.) temperature T, u and z. Your program output should also include outputs during the search - such as (e.g.) temperature T, u and z. 
 
 
 
 
<b>2b  (9 marks) </b>
 
Consider the function f(u, v) given by  z  =  f(u, v)  =  uv2 sin(v/(0.01 + u2)) + u3v2 sin(v3/(0.001 + u4)) where u is in the range -1 <= u <= 1, and v is in the range -1 <= v <= 1. 
 
Explaining your steps, write a program - with documentation - in Python (3.5.0) or Java which uses simulated annealing or genetic algorithms to find the largest value of z and the corresponding value of (u, v). Your program should have the option of starting the search at (u, v) = (0, 0) at a random value of (u, v), or at a user-specified value of (u, v). Your program should be able to show outputs step-by-step during the search - such as (e.g.) temperature T, u, v and z. Your program output should also include outputs during the search - such as temperature T, u,v and z. 
 
 
 
 
<b>2c  (6 marks) </b>
 
Consider the function z = f(u, v, w) given by z(u,v,w) =  (uv2 + sin(πw)) sin(v/(0.01 + u2)) sin(πw/2) + u3v2w sin(v3/(0.001 sin2(πw/2) + u4 + (w-1)2)) where u is in the range -1 <= u <= 1, v is in the range -1 <= v <= 1, and w is in the range -1 <= w <= 1. 
 
Explaining your steps, write a program - with documentation - in Python (3.5.0) or Java which uses simulated annealing or genetic algorithms to find the largest value of z and the corresponding value (u, v, w). Your program should have the option of starting the search at (u, v, w) = (0, 0, 0) at a random value of (u, v, w), or at a user-specified value of (u, v, w). Your program should be able to show outputs step-by-step during the search - such as (e.g.) temperature T, u, v, w and z. Your program output should also include outputs during the search - such as temperature T, u,v,w and z. 
 
 
  
<b>2d  (5 marks) </b>
 
Consider the function z = f(u, v, w, y) given by z =  ((uv2 + sin(πw)) sin(v/(0.01 + u2)) sin(πw/2) + u3v2w sin(v3/(0.001 sin2(πw/2) + u4 + (w-1)2)))y where u is in the range -1 <= u <= 1,   v is in the range -1 <= v <= 1,  w is in the range -1 <= w <= 1, and y is in {-1, 0, 1} - i.e., (y = -1) or (y = 0) or (y = 1).  
 
Explaining your steps, write a program - with documentation - in Python 3.5.0 or Java which uses simulated annealing or genetic algorithms to find the largest value of z and the corresponding value (u,v,w,y). Your program should have the option of starting the search at (u, v, w, y) = (0, 0, 0, 0) at a random value of (u, v, w, y), or at a user-specified value of (u, v, w, y). Your program should be able to show outputs step-by-step during the search - such as (e.g.) temperature T, u, v, w, y and z. Your program output should also include outputs during the search - such as temperature T, u,v,w,y and z. 
 
Your answer to Question 2 should be in electronic form (e.g., .doc, .docx, .tex, .pdf) and not handwritten. See also submission instructions on the final page. 
