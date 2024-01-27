
# Tetris Game Solving - Using Multi-Threading in Java

This project is based on the game 'Tetris.' 

In this endeavor, we handle various pieces of different shapes, aiming to fit all of them into a 4x4 grid. 

The objective is to arrange the pieces without any gaps, ensuring that all the components find a suitable place within the grid.

# The Workflow Procedure

- The core concept involves implementing a backtracking algorithm using threads. Each thread manages its own 4x4 grid and begins by strategically placing valid pieces. Subsequently, it invokes another thread, acting as a child, to complete the process.

- The advantage is that the parent thread does not pause or wait for its child to finish, enabling both of them to proceed with their work concurrently. Both threads operate simultaneously, continuously adding pieces and generating children in an uninterrupted manner.

- In summary, the entire tree formed by the backtracking algorithm operates concurrently, leading to a faster and more efficient way to achieve an optimal result.


## For more Details, Take a look at the Attached Documentation.
-----
## How to use?

- The program shows various letter-shaped blocks (L, J, I, O, Z, S) that can be arranged. As a user, you pick the quantity of each shape, and the program provides a potential arrangement solution for the Tetris board. Each time you run the program with the same input, it usually gives a different valid solution.

## The Final Result

- In case of valid query, the program visualize the steps for the solution :
  
![123](https://github.com/Ahmad3oda/SolvingTetris-MultiThreading/assets/104653414/7ac21010-9302-4f5c-a6b6-052d9be918c6)
![456](https://github.com/Ahmad3oda/SolvingTetris-MultiThreading/assets/104653414/9c57668a-64d9-4f4f-b5e4-7366d0416dba)

- In case of invalid query :
  
![789](https://github.com/Ahmad3oda/SolvingTetris-MultiThreading/assets/104653414/056a7b8a-3fe7-4514-a2ad-00b49f80964d)
