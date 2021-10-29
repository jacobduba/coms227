package lab6;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import plotter.Plotter;
import plotter.Polyline;

public class PlotTest {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Polyline> list = readFile("hello.txt");
        Plotter plotter = new Plotter();

        for (Polyline p : list)
        {
            plotter.plot(p);
        }
    }

    public static ArrayList<Polyline> readFile(String name) throws FileNotFoundException {
        File file = new File("hello.txt");
        Scanner scanner = new Scanner(file);

        ArrayList<Polyline> lines = new ArrayList<Polyline>();
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (!line.equals("") && line.charAt(0) != '#') {
                lines.add(parseOneLine(line));
            }
        }

        scanner.close();
        return lines;
    }

    private static Polyline parseOneLine(String line) {
        Scanner scan = new Scanner(line);

        int count = 1;
        if (scan.hasNextInt()) {
            count = scan.nextInt();
        }

        Polyline p = new Polyline(scan.next());

        ArrayList<Point> points = new ArrayList<Point>();
        while (scan.hasNext()) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            points.add(new Point(x, y));
        }

        scan.close();

        for (int i = 0; i < count; i++) {
            for (Point pp : points) {
                p.addPoint(pp);
            }
        }

        return p;
    }
}
