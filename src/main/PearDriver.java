package main;

import java.awt.*;
import java.util.*;
import javax.swing.*;

/*
 * Driver for the PearStore
 * 
 * Copyright Austin_Davis 2020
 */

public class PearDriver extends Store {

	public static void main(String[] args) {
		Store pear = new Store();
		
		pear.appList.add(new Application("Twitter", "A social media app for messages" , "twitter.co", "iphone", "2.0", "twittee.com", 0.99));
		pear.appList.add(new Application("Reddit", "A formum site" , "reddit", "windows", "1.6", "reddit.com", 1.95));
		pear.appList.add(new Application("Insta", "A social media app for photos" , "facebook", "iphone", "1.0", "instagram.com", 2.99)); 
		
		System.out.println("unsorted");
		display(pear, pear.appList);

/*		
		pear.sort(0);
		
		System.out.println("sorted");
		display(pear, pear.appList);
        pear.sort(1);
		
		System.out.println("sorted back");
		display(pear, pear.appList);
		
		pear.filter(2);
		System.out.println("Filtered");
		display(pear, pear.temp);
*/
		
	}
	private static void display(Store s,ArrayList<Application> arrList) {
		//for(int i = 0; i < arrList.size(); i++) {
		//	s.view(s.appList.get(i));
		//}
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(s, arrList);
            }
        });
	}
	private static void createAndShowGUI(Store s,ArrayList<Application> arrList) {
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);
 
        //Create and set up the window.
        JFrame frame = new JFrame("Pear Store");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
 
        //Add the ubiquitous "Hello World" label.
        //JLabel label = new JLabel("Pear Store");
        //frame.getContentPane().add(label);
        
        JPanel panel = new JPanel(); // the panel is not visible in output
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        JLabel label1 = new JLabel("Pear Store");
        JLabel label2 = new JLabel("               ");
        JLabel label3 = new JLabel("Filter Price");
        JTextField tf = new JTextField(10); // accepts upto 10 characters
        JButton filter = new JButton("Filter");
        JLabel label4 = new JLabel("               ");
        JLabel label5 = new JLabel("Sort");
        JButton sortAZ = new JButton("A-Z");
        JButton sortZA = new JButton("Z-A");
        JLabel label6 = new JLabel(s.appList.get(0).getName());
        JLabel label7 = new JLabel(s.appList.get(0).getDescription());
        JButton view1 = new JButton("View");
        /*
        JLabel label8 = new JLabel(s.appList.get(1).getName());
        JLabel label9 = new JLabel(s.appList.get(1).getDescription());
        JButton view2 = new JButton("View");
        JLabel label10 = new JLabel(s.appList.get(2).getName());
        JLabel label11 = new JLabel(s.appList.get(2).getDescription());
        JButton view3 = new JButton("View");
        
        
        JLabel label6 = new JLabel(s.appList.get(0).getName() + "        " + s.appList.get(0).getDescription());
        JLabel label7 = new JLabel("            ");
        JLabel label8 = new JLabel(s.appList.get(1).getName() + "        " + s.appList.get(1).getDescription());
        JButton view2 = new JButton("View");
        JLabel label9 = new JLabel("            ");
        JLabel label10 = new JLabel(s.appList.get(2).getName() + "        " + s.appList.get(2).getDescription());
        JButton view3 = new JButton("View");
        */
        
        
        // Components Added using Flow Layout
        panel.add(label1); 
        panel.add(label2);
        panel.add(label3);
        panel.add(tf);
        panel.add(filter);
        panel.add(label4);
        panel.add(label5);
        panel.add(sortAZ);
        panel.add(sortZA);
        
        
        panel2.add(label6);
        panel3.add(label7);
        panel3.add(view1);
        //panel2.add(label8);
        //panel3.add(label9);
        //panel3.add(view2);
        //panel2.add(label10);
        //panel3.add(label11);
        //panel3.add(view3);
        /*
        
        panel2.add(label8);
        panel2.add(view2);
        panel2.add(label9);
        panel2.add(label10);
        panel2.add(view3);
         */
        
        
        

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.NORTH, panel);
        frame.getContentPane().add(BorderLayout.LINE_START, panel2);
        frame.getContentPane().add(BorderLayout.CENTER, panel3);

        frame.setVisible(true);
 
        //Display the window.
        //frame.pack();
        frame.setVisible(true);
    }
	
	private void login() {
		
	}
	
	private void createUser() {
		
	}

}