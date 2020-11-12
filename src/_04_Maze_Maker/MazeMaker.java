package _04_Maze_Maker;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class MazeMaker {

	private static int width;
	private static int height;

	private static Maze maze;

	private static Random randGen = new Random();
	private static Stack<Cell> uncheckedCells = new Stack<Cell>();

	static Cell leftNeighbor;
	static Cell rightNeighbor;
	static Cell upperNeighbor;
	static Cell lowerNeighbor;

	public static Maze generateMaze(int w, int h) {
		width = w;
		height = h;
		maze = new Maze(width, height);

		// 4. select a random cell to start
		Cell random = maze.getCell(randGen.nextInt(width), randGen.nextInt(height));
maze.getCell(0, 0).setWestWall(false);
maze.getCell(w-1, h-1).setEastWall(false);
		// 5. call selectNextPath method with the randomly selected cell
		selectNextPath(random);

		return maze;
	}

	// 6. Complete the selectNextPathMethod
	private static void selectNextPath(Cell currentCell) {
		// A. mark cell as visited
		currentCell.setBeenVisited(true);
		// B. Get an ArrayList of unvisited neighbors using the current cell and the
		// method below
		// currentCell
// getUnvisitedNeighbors(Cell c)
		ArrayList<Cell> unvisited = getUnvisitedNeighbors(currentCell);

		// C. if has unvisited neighbors,
		if (unvisited.size() > 0) {

			// C1. select one at random.
			int randomInt = randGen.nextInt(unvisited.size());
			// C2. push it to the stack
			Cell randomCell = unvisited.get(randomInt);
			uncheckedCells.push(randomCell);
			// C3. remove the wall between the two cells
			if (randomCell == lowerNeighbor) {
				currentCell.setSouthWall(false);
				randomCell.setNorthWall(false);
			}
			if (randomCell == leftNeighbor) {
				currentCell.setWestWall(false);
				randomCell.setEastWall(false);
			}
			if (randomCell == upperNeighbor) {
				currentCell.setNorthWall(false);
				randomCell.setSouthWall(false);
			}
			if (randomCell == rightNeighbor) {
				currentCell.setEastWall(false);
				randomCell.setWestWall(false);
			}
			// C4. make the new cell the current cell and mark it as visited
			currentCell = randomCell;
			currentCell.setBeenVisited(true);
			// C5. call the selectNextPath method with the current cell
			selectNextPath(currentCell);
		}
		// D. if all neighbors are visited
		boolean visited = true;
		if (lowerNeighbor != null && !lowerNeighbor.hasBeenVisited()) {
			visited = false;
		}
		if (upperNeighbor != null && !upperNeighbor.hasBeenVisited()) {
			visited = false;
		}
		if (leftNeighbor != null && !leftNeighbor.hasBeenVisited()) {
			visited = false;
		}
		if (rightNeighbor != null && !rightNeighbor.hasBeenVisited()) {
			visited = false;
		}
		if (visited) {

			// D1. if the stack is not empty
			if (uncheckedCells.isEmpty() == false) {

				// D1a. pop a cell from the stack
				Cell newCurrent = uncheckedCells.pop();
				// D1b. make that the current cell
				currentCell = newCurrent;
				// D1c. call the selectNextPath method with the current cell
				selectNextPath(currentCell);
			}
		}

	}

	// 7. Complete the remove walls method.
	// This method will check if c1 and c2 are adjacent.
	// If they are, the walls between them are removed.

	// 8. Complete the getUnvisitedNeighbors method
	// Any unvisited neighbor of the passed in cell gets added
	// to the ArrayList
	private static ArrayList<Cell> getUnvisitedNeighbors(Cell currentCell) {
		ArrayList<Cell> unvisited = new ArrayList<Cell>();
		if (currentCell.getX() > 0) {
			leftNeighbor = maze.getCell(currentCell.getX() - 1, currentCell.getY());
			if (leftNeighbor.hasBeenVisited() == false) {
				unvisited.add(leftNeighbor);
			}
		} else {
			leftNeighbor = null;
		}
		if (currentCell.getX() < width - 1) {
			rightNeighbor = maze.getCell(currentCell.getX() + 1, currentCell.getY());

			if (rightNeighbor.hasBeenVisited() == false) {
				unvisited.add(rightNeighbor);
			}
		} else {
			rightNeighbor = null;
		}
		if (currentCell.getY() > 0) {
			upperNeighbor = maze.getCell(currentCell.getX(), currentCell.getY() - 1);
			if (upperNeighbor.hasBeenVisited() == false) {
				unvisited.add(upperNeighbor);
			}
		} else {
			upperNeighbor = null;
		}
		if (currentCell.getY() < height - 1) {
			lowerNeighbor = maze.getCell(currentCell.getX(), currentCell.getY() + 1);
			if (lowerNeighbor.hasBeenVisited() == false) {
				unvisited.add(lowerNeighbor);
			}
		} else {
			lowerNeighbor = null;
		}

		return unvisited;
	}
}
