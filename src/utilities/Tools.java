package utilities;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;


public class Tools {

	public static void sleep(int amt) {
		try {
			Thread.sleep(amt);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void sleep(int one, int two) {
		Tools.sleep(Tools.random(one, two));
	}

	public static int random(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt(max - min + 1) + min;
		return randomNum;
	}

	public static Image getImageFromURL(String url) {
		try {
			return ImageIO.read(new URL(url));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static Image getLocalImage(String loc) {
		File f = new File(loc);
		if (f.exists()) {
			return Toolkit.getDefaultToolkit().getImage(loc);
		} else {
			log("File Doesnt Exist: " + loc);
			return null;
		}
	}

	public static void log(Object o) {
		System.out.println(o.toString());
	}

	public static void drawSharpText(Object text, int x, int y, Color c, Color shade, Graphics g) {
		g.setColor(shade);
		g.drawString(text.toString(), x + 1, y + 1);
		g.setColor(c);
		g.drawString(text.toString(), x, y);
	}

	public static void writeFile(String[] lines, File f) {
		try {
			FileWriter outFile = new FileWriter(f);
			PrintWriter out = new PrintWriter(outFile);
			for (String s : lines) {
				out.println(s);
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String[] getTextFrom(File f) {
		ArrayList<String> lines = new ArrayList<String>();
		try {
			if (f.exists()) {
				BufferedReader br = new BufferedReader(new FileReader(f.getPath()));
				String line = br.readLine();
				while (line != null) {
					line = br.readLine();
					lines.add(line);
				}
				br.close();
				return lines.toArray(new String[] {});
			} else {
				Tools.log("File Doesn't Exist: " + f.getPath());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static String getUrlSource(String url) throws IOException {
		URL page = new URL(url);
		// URLConnection yc = page.openConnection();
		// yc.setRequestProperty("Cookie", "foo=bar");
		HttpURLConnection httpcon = (HttpURLConnection) page.openConnection();
		httpcon.addRequestProperty("User-Agent", "Mozilla/4.76");
		BufferedReader in = new BufferedReader(new InputStreamReader(httpcon.getInputStream(), "UTF-8"));
		String inputLine;
		StringBuilder a = new StringBuilder();
		while ((inputLine = in.readLine()) != null)
			a.append(inputLine);
		in.close();
		return a.toString();
	}	

	public static void showErrorMessage(String message, Component c) {
		JOptionPane.showMessageDialog(c, message);
	}

	public static String getDataFromDialog(String message) {
		return JOptionPane.showInputDialog(message);
	}

	public static void openWebpage(URI uri) {
		Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
		if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
			try {
				desktop.browse(uri);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Function to calculate the center of mass for a given polygon, according
	 * to the algorithm defined at
	 * http://local.wasp.uwa.edu.au/~pbourke/geometry/polyarea/
	 * 
	 * @param polyPoints
	 *            array of points in the polygon
	 * @return point that is the center of mass
	 */
	public static Point2D centerOfMass(Point2D[] polyPoints) {
		double cx = 0, cy = 0;
		double area = area(polyPoints);
		// could change this to Point2D.Float if you want to use less memory
		Point2D res = new Point2D.Double();
		int i, j, n = polyPoints.length;

		double factor = 0;
		for (i = 0; i < n; i++) {
			j = (i + 1) % n;
			factor = (polyPoints[i].getX() * polyPoints[j].getY() - polyPoints[j].getX() * polyPoints[i].getY());
			cx += (polyPoints[i].getX() + polyPoints[j].getX()) * factor;
			cy += (polyPoints[i].getY() + polyPoints[j].getY()) * factor;
		}
		area *= 6.0f;
		factor = 1 / area;
		cx *= factor;
		cy *= factor;
		res.setLocation(cx, cy);
		return res;
	}

	/**
	 * Function to calculate the area of a polygon, according to the algorithm
	 * defined at http://local.wasp.uwa.edu.au/~pbourke/geometry/polyarea/
	 * 
	 * @param polyPoints
	 *            array of points in the polygon
	 * @return area of the polygon defined by pgPoints
	 */
	public static double area(Point2D[] polyPoints) {
		int i, j, n = polyPoints.length;
		double area = 0;

		for (i = 0; i < n; i++) {
			j = (i + 1) % n;
			area += polyPoints[i].getX() * polyPoints[j].getY();
			area -= polyPoints[j].getX() * polyPoints[i].getY();
		}
		area /= 2.0;
		return (area);
	}

	/**
	 * Uses System.zoo.bunny() to eat the carrots
	 * 
	 * @param s
	 *            String to be modified
	 * @return returns String s with no <> or anything inside them
	 */
	public static String removeCarrots(String s) {
		String it = "";
		boolean on = false;
		for (char c : s.toCharArray()) {
			if (on) {
				if (c == '>')
					on = false;
			} else {
				if (c == '<') {
					on = true;
				} else {
					it += c;
				}
			}
		}
		return it;
	}

	public static BufferedImage applyBlur(BufferedImage in) {
		float[] matrix = new float[400];
		for (int i = 0; i < 4; i++)
			matrix[i] = 1.0f / 4.0f;
		BufferedImageOp op = new ConvolveOp(new Kernel(20, 20, matrix), ConvolveOp.EDGE_NO_OP, null);
		return op.filter(in, null);
	}

	public static void copyToClipBoard(String string) {
		StringSelection selection = new StringSelection(string);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(selection, selection);
	}

}
