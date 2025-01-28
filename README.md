# Percolation Simulator

This project simulates the Percolation model using an `n x n` grid, leveraging the Weighted Quick Union-Find algorithm. It allows users to explore connectivity, percolation detection, and probabilistic site opening while visualizing the grid with the StdDraw library. Perfect for understanding computational simulations and algorithms.


## Table of Contents

- [Features](#features)
- [Usage](#usage)
- [Code Structure](#code-structure)
- [Requirements](#requirements)
- [File Outputs](#file-outputs)
- [License](#license)
- [Important Note](#important-note)


## Features

- **Dynamic Grid Creation**
  - Initialize a customizable grid of size `n x n`.

- **Site Management**
  - Open individual sites and connect them to neighbors.
  - Supports connections to virtual top and bottom nodes for efficient percolation detection.

- **Randomized Site Opening**
  - Open grid sites probabilistically using customizable probabilities and random seeds.

- **Visualization**
  - Visualize the grid state using the StdDraw library, with color-coded open (blue) and closed (black) sites.

- **Percolation Detection**
  - Check if the system percolates (i.e., there is a path of open sites connecting the top and bottom rows).


## Usage

1. **Clone the Repository**
   ```bash
   git clone https://github.com/Kobe-Martinez/percolation-simulator.git
   ```

2. **Compile the Code**
   ```bash
   javac -cp .:lib/* src/Percolation.java
   ```

3. **Run the Program**
   ```bash
   java -cp .:lib/* src/Percolation
   ```

4. **Visualize**
   - The grid is visualized automatically using the StdDraw library.


## Code Structure

- **Percolation.java**
  - Implements the main percolation logic, including site opening, grid visualization, and percolation detection.

- **Grid Management**
  - Handles site connectivity and checks for out-of-bounds indices.

- **Visualization**
  - Draws the grid using StdDraw, coloring open and closed sites appropriately.

- **Main Method**
  - Demonstrates functionality, including random site opening and percolation detection.


## Requirements

- **Java**: Version 8 or higher.
- **Libraries**: 
  - StdDraw for grid visualization.
  - WeightedQuickUnionFind for efficient connectivity checks.


## File Outputs

- Visualization is displayed in a new window, and results are printed to the console.


## License

This project is licensed under the MIT License. See the LICENSE file for details.


## Important Note

This project demonstrates the Percolation model and its applications in understanding connectivity and threshold probabilities in grid systems. It serves as an educational tool for studying algorithms and simulations in computer science.
