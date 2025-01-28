# Percolation

A Java implementation of the Percolation model, which simulates a grid-based system to explore percolation properties. The project uses the Weighted Quick Union-Find algorithm to efficiently determine connectivity and includes methods for grid visualization and probabilistic site opening.

## Authors

- Ana Paula Centeno
- Haolin (Daniel) Jin
- Kobe Lee Martinez

## Features

- **Dynamic grid creation**: Initialize a grid of any size `n x n`.
- **Site opening and connectivity**: Open sites and connect them to neighbors.
- **Percolation detection**: Check if the system percolates.
- **Randomized site opening**: Open sites based on a probability and random seed.
- **Visualization**: Display the grid using the StdDraw library.

## File Structure

- `Percolation.java`: Main class implementing the percolation logic.
- `README.md`: Guide to setting up and running the project.
- `lib/`: Contains required dependencies.
- `src/`: Source folder for additional project files.
- `bin/`: Generated folder for compiled output files.

## Prerequisites

- Java 8 or later
- StdDraw and WeightedQuickUnionFind libraries

## How to Run

1. Clone this repository:
   ```bash
   git clone https://github.com/Kobe-Martinez/percolation.git
   ```

2. Compile the Java files:
   ```bash
   javac -cp .:lib/* src/Percolation.java
   ```

3. Run the program:
   ```bash
   java -cp .:lib/* src/Percolation
   ```

## Usage

### Constructor
Create a Percolation grid of size `n x n`:
```java
Percolation p = new Percolation(n);
```

### Open a Site
Open the site at position `(row, col)`:
```java
p.openSite(row, col);
```

### Check Percolation
Check if the system percolates:
```java
boolean doesPercolate = p.percolationCheck();
```

### Open All Sites Probabilistically
Open sites based on a probability and random seed:
```java
p.openAllSites(probability, seed);
```

### Visualize the Grid
Display the grid using the StdDraw library:
```java
p.displayGrid();
```

## Example
```java
public static void main(String[] args) {
    double probability = 0.47;
    Percolation p = new Percolation(5);

    p.openSite(0, 0);
    p.openAllSites(probability, System.currentTimeMillis());

    System.out.println("The system percolates: " + p.percolationCheck());
    p.displayGrid();
}
```

## References

- [Weighted Quick-Union Algorithm](https://en.wikipedia.org/wiki/Disjoint-set_data_structure)
- [StdDraw Library Documentation](https://introcs.cs.princeton.edu/java/stdlib/javadoc/StdDraw.html)

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
