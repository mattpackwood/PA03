/* Matt Packwood, Orchard Ridge Campus, Monday Evening Class, Fall Semester 2003
 * 
 * PA03: Multiple figure display; assumes adequate applet screen size 
 *
 * Demo the use of category one user methods (instance vars) to display
 * several figs by multiple refs to a fig display method.  The base values
 * are modified before each reference to resize and relocate each fig.
 *
 * Nested order of encounter used for method definition sequence.   
 */

import java.awt.*;
import java.applet.*;

public class CmptrL3 extends Applet {

int bX, bY, bS; // base vars
int fX, fY, fS; // first vars
int qS, hS, dS; // work ratio vars 
float area; // approximate pixel area of computer
Graphics g; // global screen ref

public void init ( ) {
	setBackground (Color.white);
	}
public void paint (Graphics gg) {
	g= gg; // set global scope for screen ref
	fX= bX= 342; fY= bY= 270; fS= bS= 27; area= 0; // init base values, area
	dsplyFig ( ); // right-most fig 1st
	adjBaseVals ( ); // adj base vals for fig 2
	dsplyFig ( ); // 2nd fig
	adjBaseVals ( ); // adj base vals for fig 3
	dsplyFig ( ); // 3rd fig
	adjBaseVals ( ); // adj base vals for fig 4
	dsplyFig ( ); // 4th fig
	g.setColor (Color.black);
	g.drawString ("init values: bX=" + bX + " bY=" + bY + " bS=" + bS, 216, 100);
	g.drawString ("approx pixel area=" + area, 216, 118); // draw Strings for first (right) fig base values and group area per specs
	}
// user method definitions
private void dsplyFig ( ) {
	calcRatios ( );
	dsplyMonitor ( ); 
	g.setColor (Color.yellow);
	g.fillRect (bX, bY-bS, dS+dS+bS, bS); // CPU
	g.fillRect (bX, bY, dS+dS, bS); // Keyboard
	g.fillOval (bX+dS+dS+qS, bY+qS, hS, hS); // Mouse
	g.setColor (Color.black);
	g.drawRect (bX, bY-bS, dS+dS+bS, bS); // CPU outline
	g.drawRect (bX, bY, dS+dS, bS); // Keyboard outline
	g.drawOval (bX+dS+dS+qS, bY+qS, hS, hS); // Mouse outline
	g.drawLine (bX+dS+dS, bY+hS, bX+dS+dS+qS, bY+hS); // Mouse cord
	g.fillRect (bX+dS+hS, bY-hS-qS, dS, qS); // DVD slot
	g.fillRect (bX+qS, bY+qS, dS+bS, hS); // Keys
	g.fillArc (bX+dS+dS+qS, bY+qS, hS, hS, 45, 135); // Mouse 1
	g.fillArc (bX+dS+dS+qS, bY+qS, hS, hS, 225, 135); // Mouse 2
	area= (float) (area + (((dS+dS+bS)*bS)+ ((dS+dS) * (dS+bS)) + ((dS+dS) * bS) + (Math.PI*((hS/2)*(hS/2))))); // compute and accumulate area
	}
private void calcRatios ( ) {
	qS= Math.round (bS/4.0f); // calc ratio vals
		hS= Math.round (bS/2.0f); // calc ratio vals
	dS= Math.round (bS*2.0f); // calc ratio vals
	}
private void dsplyMonitor ( ) {
	// display monitor and screen
	g.setColor (Color.yellow);
	g.fillRect (bX+hS, bY-dS-dS, dS+dS, dS+bS); // Monitor
	g.setColor (Color.black);
	g.drawRect (bX+hS, bY-dS-dS, dS+dS, dS+bS); // Monitor Outline
	g.setColor (Color.lightGray);
	g.fillRect (bX+hS+qS, bY-dS-bS-hS-qS, dS+bS+hS, dS+hS); // Screen	
	}
private void adjBaseVals ( ) {
	// adjust bX, bY and bS for nxt fig
	bX= Math.round (bX-(dS+dS+bS)); // shift right by a CPU width
		bY= Math.round (bY-hS); // shift up by 50% of CPU height
	bS= Math.round (bS*0.75f); // reduce size by 25%
	} 
}
