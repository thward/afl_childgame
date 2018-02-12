package childrensgame;

import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

import childrensgame.service.ChildService;
import childrensgame.service.impl.ChildServiceImpl;

/**
 * Command line client to find winner of Children's Game 
 * 
 * @author Tom Ward
 * @version 1.0
 * 
 */
public class ChildrensGame {
	public static void main(String[] args) {
		
		ChildService childService = new ChildServiceImpl();
		
		boolean carryOn = true;
		Scanner scanner = new Scanner(System.in);
		
		while (carryOn){
						
			String inputChar = null;
			
			boolean inputCharIsValid = false;
			while (!inputCharIsValid){
				System.out.print("Enter circle size: ");
				inputChar = scanner.nextLine();
				if (!StringUtils.isNumeric(inputChar))
					System.out.println("Circle size must be numeric, and greater than one");
				else if(Integer.parseInt(inputChar) < 2)
					System.out.println("Circle size must be greater than one");
				else
					inputCharIsValid = true;
			}
			Integer circleSize = Integer.parseInt(inputChar);

			inputCharIsValid = false;
			while (!inputCharIsValid){
				System.out.print("Enter elimination count : ");
				inputChar = scanner.nextLine();
				if (!StringUtils.isNumeric(inputChar))
					System.out.println("Elimination count must be numeric, and greater than zero");
				else if(Integer.parseInt(inputChar) < 1)
					System.out.println("Elimination count must be greater than zero");
				else
					inputCharIsValid = true;
			}
			Integer eliminationCount = Integer.parseInt(inputChar);
			
			System.out.println("Id of winning child: " + childService.getWinner(circleSize, eliminationCount));
			
			System.out.print("(q)uit ?: ");
			String operator = scanner.nextLine();
	
            if ("q".equals(operator)) {
                System.out.println("Bye!");
                break;
            }
		}
		scanner.close();

	}

}