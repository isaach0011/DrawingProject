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
	private JButton rectButton;
	private JButton circButton;
	private JButton elliButton;
	private JButton triButton;
	private JButton polyButton;
	private JButton resetButton;
	private JButton saveButton;
	private JButton randomArrayButton;
	private JLabel title;
	
	public DrawingPanel(DrawingController baseController)
	{
		super();
		this.baseController = baseController;
		this.shapePanel = new ShapePanel(baseController);
		this.baseLayout = new SpringLayout();
		this.title = new JLabel("Drawing with Java!");
		this.rectButton = new JButton("Draw Rectangles");
		this.circButton = new JButton("Draw Circles");
		this.elliButton = new JButton("Draw Ellipses");
		this.triButton = new JButton("Draw Triangles");
		this.polyButton = new JButton("Draw Polygons");
		this.resetButton = new JButton("Reset");




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
		this.add(rectButton);
		this.add(circButton);
		this.add(elliButton);
		this.add(triButton);
		this.add(polyButton);
		this.add(resetButton);
		this.add(title);
	}
	
	public void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, shapePanel, 0, SpringLayout.NORTH, title);
		baseLayout.putConstraint(SpringLayout.NORTH, title, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, title, 20, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, shapePanel, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, polyButton, 318, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, triButton, 0, SpringLayout.WEST, polyButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, triButton, -22, SpringLayout.NORTH, polyButton);
		baseLayout.putConstraint(SpringLayout.WEST, polyButton, 0, SpringLayout.WEST, title);
		baseLayout.putConstraint(SpringLayout.WEST, rectButton, 0, SpringLayout.WEST, circButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, rectButton, -20, SpringLayout.NORTH, circButton);
		baseLayout.putConstraint(SpringLayout.WEST, circButton, 0, SpringLayout.WEST, elliButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, circButton, -24, SpringLayout.NORTH, elliButton);
		baseLayout.putConstraint(SpringLayout.WEST, elliButton, 0, SpringLayout.WEST, triButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, elliButton, -23, SpringLayout.NORTH, triButton);
		baseLayout.putConstraint(SpringLayout.WEST, resetButton, 0, SpringLayout.WEST, rectButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, resetButton, -10, SpringLayout.SOUTH, this);
	}
	
	public void setupListeners()
	{
		rectButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addRectangles();
			}
		});
		
		circButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addCircles();
			}
		});
		
		elliButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addEllipses();
			}
		});
		
		triButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addTriangles();
			}
		});
		
		polyButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addPolygons();
			}
		});
		
		resetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.reset();
			}
		});
	}
}