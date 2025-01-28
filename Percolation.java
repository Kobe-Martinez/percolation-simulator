/**
 * 
 * Percolation
 * 
 * @author Ana Paula Centeno
 * @author Haolin (Daniel) Jin
 * @author Kobe Lee Martinez
 */

public class Percolation {

	private boolean[][] grid;          // gridSize by gridSize grid of sites; 
	                                   // true = open site, false = closed or blocked site
	private WeightedQuickUnionFind wquFind; // 
	private int 		gridSize;      // gridSize by gridSize is the size of the grid/system 
	private int         gridSquared;
	private int         virtualTop;    // virtual top    index on WeightedQuckUnionFind arrays
	private int         virtualBottom; // virtual bottom index on WeightedQuckUnionFind arrays


	/**
	* Constructor.
	* Initializes all instance variables
	*/
	public Percolation ( int n ){
		gridSize 	  = n;
		gridSquared   = gridSize * gridSize;
		wquFind       = new WeightedQuickUnionFind(gridSquared + 2);
		grid          = new boolean[gridSize][gridSize];   // every site is initialized to closed/blocked
		virtualTop    = gridSquared;
		virtualBottom = gridSquared + 1;
	} 

	/**
	* Getter method for GridSize 
	* @return integer representing the size of the grid.
	*/
	public int getGridSize () {
		return gridSize;
	}

	/**
	 * Returns the grid array
	 * @return grid array
	 */
	public boolean[][] getGridArray () {
		return grid;
	}

	/**
	* Open the site at postion (x,y) on the grid to true and add an edge
	* to any open neighbor (left, right, top, bottom) and/or top/bottom virtual sites
	* Note: diagonal sites are not neighbors
	*
	* @param row grid row
	* @param col grid column
	* @return void
	*/
	public void openSite (int row, int col) {

		// WRITE YOUR CODE HERE
		//checking if values are out of bounds
		check(row, col);
		
		//opening site
		if(grid[row][col] == false) {
			grid[row][col] = true;
		}
		//another way; check with Melly
		//connnecting row 0 to virtual top
		if(row == 0) {
			wquFind.union(idx(row, col), virtualTop);
		}
		//connnecting row n to virtual bottom
		if(row == gridSize) {
			wquFind.union(idx(row, col), virtualBottom);
		}
		//Connecting top, bottom, left, and right neighbors
		if((row + 1) < gridSize) {
			if(grid[row + 1][col] == true)
				wquFind.union(idx(row, col), idx(row + 1, col));
		}
		if((col + 1) < gridSize) {
			if(grid[row][col + 1] == true)
				wquFind.union(idx(row, col), idx(row, col + 1));
		}
		if((row - 1) >= 0) {
			if(grid[row - 1][col] == true)
				wquFind.union(idx(row, col), idx(row - 1, col));
		}
		if((col - 1) >= 0) {
			if(grid[row][col - 1] == true)
				wquFind.union(idx(row, col), idx(row, col - 1));
		}
		return;
	}
	//creates 1D Array and stores index in idx
	private int idx(int row, int col) {
		check(row, col);	
			
        return gridSize * (row) + col;
    }
	//checks if index is in bounds
	private void check(int row, int col) {
		if(row < 0 || row > gridSize || col < 0 || col > gridSize) 
			throw new IndexOutOfBoundsException("the row index is out of bounds");
	}
	

	/**
	* Check if the system percolates (any top and bottom sites are connected by open sites)
	* @return true if system percolates, false otherwise
	*/
	public boolean percolationCheck () {
		// WRITE YOUR CODE HERE
			return true;
	}

	/**
	 * Iterates over the grid array openning every site. 
	 * Starts at [0][0] and moves row wise 
	 * @param probability
	 * @param seed
	 */
	public void openAllSites (double probability, long seed) {

		// Setting the same seed before generating random numbers ensure that
		// the same numbers are generated between different runs
		StdRandom.setSeed(seed); // DO NOT remove this line

		// WRITE YOUR CODE HERE, DO NOT remove the line above
		for(int row = 0; row < grid.length; row++)
			for(int col = 0; col < grid[row].length; col++){
				double chance = (StdRandom.uniform()*100);
					if(chance <= (probability*100)){
						openSite(row, col);
					}
			}
	}

	/**
	* Open up a new window and display the current grid using StdDraw library.
	* The output will be colored based on the grid array. Blue for open site, black for closed site.
	* @return: void 
	*/
	public void displayGrid () {
		double blockSize = 0.9 / gridSize;
		double zeroPt =  0.05+(blockSize/2), x = zeroPt, y = zeroPt;

		for ( int i = gridSize-1; i >= 0; i-- ) {
			x = zeroPt;
			for ( int j = 0; j < gridSize; j++) {
				if ( grid[i][j] ) {
					StdDraw.setPenColor( StdDraw.BOOK_LIGHT_BLUE );
					StdDraw.filledSquare( x, y ,blockSize/2);
					StdDraw.setPenColor( StdDraw.BLACK);
					StdDraw.square( x, y ,blockSize/2);		
				} else {
					StdDraw.filledSquare( x, y ,blockSize/2);
				}
				x += blockSize; 
			}
			y += blockSize;
		}
	}

	/**
	* Main method, for testing only, feel free to change it.
	*/
	public static void main ( String[] args ) {

		double p = 0.47;
		Percolation pl = new Percolation(5);
		pl.openSite(0, 0);

		/* 
		 * Setting a seed before generating random numbers ensure that
		 * the same numbers are generated between runs.
		 *
		 * If you would like to reproduce Autolab's output, update
		 * the seed variable to the value Autolab has used.
		 */
		long seed = System.currentTimeMillis();
		pl.openAllSites(p, seed);

		System.out.println("The system percolates: " + pl.percolationCheck());
		pl.displayGrid();
	}
}