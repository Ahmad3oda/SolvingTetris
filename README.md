
# Tetris Game Solving - Using Multi-Threading in Java

This project is based on the game 'Tetris.' 

In this endeavor, we handle various pieces of different shapes, aiming to fit all of them into a 4x4 grid. 

The objective is to arrange the pieces without any gaps, ensuring that all the components find a suitable place within the grid.

---------
# The Workflow Procedure

- The core concept involves implementing a backtracking algorithm using threads. Each thread manages its own 4x4 grid and begins by strategically placing valid pieces. Subsequently, it invokes another thread, acting as a child, to complete the process.

- The advantage is that the parent thread does not pause or wait for its child to finish, enabling both of them to proceed with their work concurrently. Both threads operate simultaneously, continuously adding pieces and generating children in an uninterrupted manner.

- In summary, the entire tree formed by the backtracking algorithm operates concurrently, leading to a faster and more efficient way to achieve an optimal result.

-----

## For more Details, Take a look at the Attached Documentation.
