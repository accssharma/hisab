# README

**Author:** [Ashish Sharma](http://www.accssharma.com)

**Compile:**

$ javac Main.java 

**Run:**

$ java bill.txt "A U S P"

## Example

### Input format:

100,A,[A U S P],04-21

155,U,[A U S P],04-11

65,P,[A U S P],04-10

### Output:

User initials:[P, A, S, U]

All bills:: 

  1. Total amount paid = 100.0	 Payer = A	 Splitted into = [A, U, S, P]	 Bill detail = 04-21

  2. Total amount paid = 155.0	 Payer = U	 Splitted into = [A, U, S, P]	 Bill detail = 04-11

  3. Total amount paid = 65.0	 Payer = P	 Splitted into = [A, U, S, P]	 Bill detail = 04-10


	user-wise total plus: =>  {P=65.0, A=100.0, S=0.0, U=155.0}

	user-wise total minus:  =>  {P=80.0, A=80.0, S=80.0, U=80.0}

	user-wise settle down:  =>  {P=-15.0, A=20.0, S=-80.0, U=75.0}


