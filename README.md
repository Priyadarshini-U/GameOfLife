#Game Of Life

##Problem Description

The universe of the Game of Life is an infinite two-dimensional orthogonal grid of square cells, each of which is in one of two possible states, live or dead. Every cell interacts with its eight neighbours, which are the cells that are directly horizontally, vertically, or diagonally adjacent. At each step in time, the following transitions occur:
1.     Any live cell with fewer than two live neighbours dies, as if by loneliness.
2.     Any live cell with more than three live neighbours dies, as if by overcrowding.
3.     Any live cell with two or three live neighbours lives, unchanged, to the next generation.
4.     Any dead cell with exactly three live neighbours comes to life.
The initial pattern constitutes the 'seed' of the system. The first generation is created by applying the above rules Simultaneously to every cell in the seed — births and deaths happen simultaneously, and the discrete moment at which this happens is sometimes called a tick. (In other words, each generation is a pure function of the one before.) The rules continue to be applied repeatedly to create further generations.

Problem.
The input represent the cells in the universe as X or - . X is a alive cell. - is a dead cell or no cell.
The output is the state of the system in the next tick (one run of the application of all the rules), represented in the same format.


##Pre-Requisites

    1.Java JDK
    1.Apache ant

##Build CodeBase

    From project Home Directory
    > ant

##Run automated Test script

    From project Home Directory
    > ant runjUnit