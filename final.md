# COM S 227 Final
The final exam is comprehensive, though it will emphasize topics covered since
Exam 2. A reasonable guess is that 50 to 75% of the exam will be on new
material, but this is difficult to measure precisely since all new material
really depends on earlier material. We strongly recommend that you review
anything you had trouble with from earlier exams. The list below is a rough
overview of the highlights for this new material.

## Practice Problems
### Problem 1a
public static int numTiles(int tiles) {
	if (tiles - 3 > -1) {
		return numTiles(tiles - 3) + numTiles(tiles - 2) + numTiles(tiles - 1);
	} else if (tiles - 2 > -1) {
		return numTiles(tiles - 2) + numTiles(tiles - 1);
	} else if (tiles - 1 > -1) {
		return 1;
	} else {
		return 1;
	}
}
### Problem 1b
public static ArrayList<String> counting(int n) {
	return findNumber(new ArrayList<String>(), "", n);
}

public static ArrayList<String> findNumber(ArrayList<String> st, String s, int n) {
	if (n <= 0) {
		return st;
	} else if (n == 1) {
		st.add(s + "1");
	} else if (n == 2) {
		st.add(s + "2");
	} else if (n == 3) {
		st.add(s + "3");
	}

	findNumber(st, s + "1", n - 1);
	findNumber(st, s + "2", n - 2);
	findNumber(st, s + "3", n - 3);
	return st;
}
### Problem 2
public static int routes(int r, int c) {
	if (r == 0 && c == 0) {
		return 0;
	} else if (r == 0) {
		return 1;
	} else if (c == 0) {
		return 1;
	} else {
		return routes(r - 1, c) + routes(r, c - 1);
	}
}
### Problem 3
public static void printAllPresents(Thing t) {
	if (t.isAPresent()) {
		System.out.println(t.getDescription());
	} else {
		for (Thing tt : t.getContents()) {
			printAllPresents(tt);
		}
	}
}
### Problem 4
public class Picture {
	private ArrayList<Shape> shapes;

	public Picture() {
		shapes = new ArrayList<Shape>();
	}

	public void add(Shape s) {
		shapes.add(s);
	}

	public double findTotalArea() {
		int totalArea = 0;
		for (Shape shape : shapes) {
			totalArea += shape.getArea();
		}
	}

	public void undo() {
		shapes.remove(shapes.size());
	}

	public ArrayList<String> getLabels() {
		ArrayList<String> labels = new ArrayList<String>();
		for (Shape shape : shapes) {
			labels.add(labels.getLabel());	
		{
	}
}
### Problem 5
It should technically work, right? However this is a composition (**has a**)
relationship (not an **is a**) so it isn't advisable.
### Problem 6

### Problem 7a
public static void applyToAll(double[] numbers, Transformation t) {
	for (int i = 0; i < numbers.length; i++) {
		numbers[i] = t.transform(numbers[i]);
	}
}
### Problem 7b
public class HalfTransformer implements Transformation {
	@Override
	public double transform(double d) {
		return d / 2;
	}
}
### Problem 8
public static Foo maxiumFoo(Foo[] foo) {
	Foo max = foo[0];
	for (int i = 1; i < foo.length; i++) {
		if (foo[i].compareTo(max) > 0) {
			max = foo[i];
		}
	}
	return max;
}
### Problem 9
class Point implements Comparable<Point> {
	private int x;
	private int y;
	public Point(int givenX, int givenY) {
		x = givenX;
		y = givenY;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	@Override
	public int compareTo(Point a) {
		double thisDist = Math.sqrt(getX() * getX() + getY() * getY());
		double aDist = Math.sqrt(a.getX() * a.getX() + a.getY() * a.getY());
		
		double compare = thisDist - aDist;
		if (compare == 0) {
			return 0;
		} else if (compare > 0) {
			return 1;
		} else {
			return 1;
		}
	}
}
### Problem 10
This problem was done by refactoring code in lab2.
### Problem 11
10
30
10
40
10
-20
### Problem 12
public static void mergeSortRec(int[] arr, int start, int end) {
	if (start >= end) {
		return;
	}

	int mid = (start + end) / 2;

	mergeSortRec(arr, start, mid);
	mergeSortRec(arr, mid + 1, end);

	merge(arr, start, end, mid);
}
### Problem 13
public static void mergeSortRec(int[] arr, int start, int end) {
	if (start + 5 >= end) {
		for (int x = start; x < end, x++) {
			int min = x;
			for (int y = x; y < end, y++) {
				if (arr[y] < arr[max]) {
					min = y;
				}
			}
			int temp = arr[x];
			arr[x] = arr[min];
			arr[min] = arr[y];
		}
	}

	int mid = (start + end) / 2;

	mergeSortRec(arr, start, mid);
	mergeSortRec(arr, mid + 1, end);

	merge(arr, start, end, mid);
}
