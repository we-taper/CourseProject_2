import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import static taper.util.PythonCodeStyle.*;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.util.Random;

public class test extends JFrame{
	public static void main(String[] args) throws IOException {
		Random input = new Random();
		int array[] = new int[50];
		for(int i : range(50)) {
			array[i] = input.nextInt(100);
		}
		System.out.println(Arrays.toString(array));
		
		bubbleSort(array,0,5);
		System.out.println(Arrays.toString(array));
		
	}
	public static void bubbleSort(int[] array, int startIdx, int endIdx) {
		for(int i = endIdx; i > startIdx; i--) {
			for(int j = startIdx; j <= i-1; j++) {
				if(array[j] > array[j+1]) {
					int t = array[j];
					array[j]= array[j+1];
					array[j+1] = t;
				}//swap
			}// for j
		}// for i
	}
}
