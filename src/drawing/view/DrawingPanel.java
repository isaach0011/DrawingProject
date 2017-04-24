package drawing.view;

import javax.swing.*;
import drawing.controller.DrawingController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;

public class DrawingPanel extends JPanel
{
	private DrawingController baseController;
	private ShapePanel shapePanel;
	private DrawingFrame baseFrame;
	private SpringLayout baseLayout;
	private JButton button;
	private JLabel title;
	
	public DrawingPanel(DrawingController baseController)
	{
		super();
		this.baseController = baseController;
		this.shapePanel = new ShapePanel(baseController);
		this.baseLayout = new SpringLayout();
		this.title = new JLabel("Drawing with Java!");
		this.button = new JButton("Draw Rectangles");

		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	public void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setPreferredSize(new Dimension(900,600));
		this.setBackground(Color.gray);
		
		title.setFont(new Font("BigNoodleTitling", Font.PLAIN, 50));
		this.add(shapePanel);
		this.add(button);
		this.add(title);
	}
	
	public void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, button, 6, SpringLayout.SOUTH, title);
		baseLayout.putConstraint(SpringLayout.WEST, button, 90, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, shapePanel, 0, SpringLayout.NORTH, title);
		baseLayout.putConstraint(SpringLayout.NORTH, title, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, title, 20, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, shapePanel, -10, SpringLayout.EAST, this);
	}
	
	public void setupListeners()
	{
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addRectangles();
			}
		});
	}
}