package drawing.view;

import javax.swing.JFrame;
import drawing.controller.DrawingController;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class DrawingFrame extends JFrame
{
	private DrawingController baseController;
	private DrawingFrame baseFrame;
	private DrawingPanel drawingPanel;
	private ShapePanel shapePanel;
	
	public DrawingFrame(DrawingController baseController)
	{
		super();
		this.baseController = baseController;
		drawingPanel = new DrawingPanel(baseController);
//		shapePanel = new ShapePanel(baseController);
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(drawingPanel);
		this.setTitle("Drawing with Java");
		this.setSize(new Dimension(900,600));
		this.setResizable(true);
		this.setVisible(true);	
	}
}