package childrensgame.service.impl;

import java.util.ArrayList;

import childrensgame.model.Child;
import childrensgame.service.ChildService;

/**
 * An implementation for Child service 
 * 
 * @author Tom Ward
 * @version 1.0
 * 
 */
public class ChildServiceImpl implements ChildService {

	private ArrayList<Child> children;

	
	public Integer getWinner(Integer numberOfChildren, Integer eliminationRange) {

		if (numberOfChildren < 2) {
			throw new IllegalArgumentException("Must be more than one child");
		}

		if (eliminationRange < 1) {
			throw new IllegalArgumentException("Elimination range must more than zero");
		}

		populateChildren(numberOfChildren);
		removeLosers(numberOfChildren, eliminationRange);
		return findWinner();
	}

	/**
	 * Given the number of children in the circle create array list of children
	 * 
	 * @param numberOfChildren
	 *            The number of children in the circle
	 * 
	 */
	private void populateChildren(Integer numberOfChildren) {
		children = new ArrayList<Child>();

		for (int i = 1; i <= numberOfChildren; i++) {
			Child child = new Child(i);
			children.add(child);
		}
	}

	/**
	 * Given the number of children in the circle and elimination range, remove
	 * the losing children
	 * 
	 * @param numberOfChildren
	 *            The number of children in the circle
	 * @param eliminationRange
	 *            The number to count to before child eliminated
	 * 
	 */
	private void removeLosers(Integer numberOfChildren, Integer eliminationRange) {

		Integer childrenRemaining = numberOfChildren;
		int eliminationCounter = 0;
		int childIndex = 0;

		// Process current child
		while (childrenRemaining > 1) {

			// Skip current child if already eliminated
			if (!children.get(childIndex).isElminated()) {
				// if point of elimination, soft delete the child
				if (eliminationCounter == eliminationRange) {
					children.get(childIndex).setElminated(true);
					childrenRemaining--;
					eliminationCounter = 0;
				} else
					eliminationCounter++; // increment elimination counter
			}

			// If only one child remains finish processing list
			if (childrenRemaining == 1)
				break;

			// find next child
			if (childIndex == children.size() - 1) // if end of list restart at
													// beginning
				childIndex = 0;
			else
				childIndex++;

		}
	}

	/**
	 * Find the remaining child
	 * 
	 * @returns Integer sequential id of winning child
	 * 
	 * 
	 */
	private Integer findWinner() {

		int childIndex = 0;

		childIndex = 0;
		while (1 == 1) {
			if (!children.get(childIndex).isElminated())
				break;

			childIndex++;
		}

		return children.get(childIndex).getId();
	}
}
