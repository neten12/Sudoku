package sudoku_Generator;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.text.*;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.applet.Applet;
import javax.swing.*;


public class ChangeSize extends Applet
implements ActionListener
{
Button bttn1 = new Button ("Shape");
int choice=0;

public void init ()
{
    this.setSize (500, 300);
    setBackground (Color.lightGray);
    bttn1.addActionListener (this); 
    add (bttn1);

/*
	int matrix[][];
	int row, column;
	void create() {
		Scanner in = new Scanner(System.in);		
		System.out.println("Number of rows :");
 		row = Integer.parseInt(in.nextLine());
		System.out.println("Number of columns :");
		column = Integer.parseInt(in.nextLine());
		matrix = new int[row][column];
		System.out.println("Enter the data :");
		for(int i=0; i < row; i++) {
			for(int j=0; j < column; j++) {
				matrix[i][j] = in.nextInt();
			}
		}
	}
	void display() {
		System.out.println("\nThe Matrix is :");
		for(int i=0; i < row; i++) {
			for(int j=0; j < column; j++) {
				System.out.print("\t" + matrix[i][j]);
			}
			System.out.println();
		}
	}

    */

}

public void actionPerformed (ActionEvent evt)
{
    if (evt.getSource () == bttn1){
        if(choice>=0)choice =choice+ 1;
    	else choice=0;}
          

    repaint ();
}

}

/*class CreateMatrix {
	public static void main(String args[]) {
		ChangeSize	 obj = new ChangeSize();
		obj.create();
		obj.display();
	}
}*/