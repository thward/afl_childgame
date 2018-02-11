package childrensgame.service;

/**
 * Specifies a method for finding a winner for Children's game 
 * 
 * @author Tom Ward
 * @version 1.0
 * 
 */
public interface ChildService {

	/**
	 * Given the number of children in the circle, and the elimination range
	 * returns the sequential id of winning child.
	 * 
	 * @param numberOfChildren
	 *            The number of children in the circle
	 * @param eliminationRange
	 *            The number to count to before child eliminated
	 * @return Integer sequential id of winning child
	 */
	public Integer getWinner(Integer numberOfChildren, Integer eliminationRange);

}
