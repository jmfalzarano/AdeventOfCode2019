/**
 * Copyright 2020 John Michael Falzarano
 * Advent of Code Problem 1
 */

import java.io.*;
import java.util.Scanner;	

public class Problem1 {
	
	public void main(String[] args) throws FileNotFoundException {
		getMass();
		output();
	}
	
	int mass = 0;
	int fuelRequirement, temp;
	boolean part2 = true;
			
	public int getMass() throws FileNotFoundException {
		
		File file = new File("input.txt");
		Scanner inputFile = new Scanner(file);
		
		while (inputFile.hasNextInt()) {
			mass = inputFile.nextInt();
			temp = (mass / 3) - 2;
			fuelRequirement = fuelRequirement + temp;
			
			/**
			 * I decided to use this strategy so that it would not add the 
			 * possible negative numbers into the fuelReq total (ex: 2/3 - 2 = -2)
			 * if the number is > 0, it does not loop and does not add it's value to the total
			 */
			
			if (part2 == true) {
				boolean loop = true;
				while (loop == true) {
					temp = (temp / 3) - 2;
					if (temp > 0) {
						loop = true;
						fuelRequirement = fuelRequirement + temp;
					}
					else {
						loop = false;
					}
				}
			}
		}
		return fuelRequirement;
	}
		
	public void output() {
		System.out.println(fuelRequirement);
	}
}
