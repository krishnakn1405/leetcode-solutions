// Count Squares Formed by Line Segments

// You are given a list of horizontal and vertical line segments on a 2D coordinate plane.

// Each line segment is represented as:
// [x1, y1, x2, y2]

// where

// (x1, y1) is the starting point.
// (x2, y2) is the ending point.

// It is guaranteed that every line segment is either:

// Horizontal (y1 == y2)
// Vertical (x1 == x2)

// A square is valid if:

// All four sides are completely covered by the given line segments.
// The sides are parallel to the coordinate axes.
// The width equals the height.

// Return the total number of squares.

// Example 1:
// Input: segments = [
//    [0,4,8,4],
//    [0,2,5,2],
//    [2,0,8,0],
//    [0,2,0,4],
//    [2,0,2,4],
//    [5,2,5,4],
//    [8,0,8,4]
// ]
// Output: 1

import java.util.ArrayList;
import java.util.List;

class Point {
  int x, y;

  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

class LineSegment {
  Point start;
  Point end;

  LineSegment(Point start, Point end) {
    this.start = start;
    this.end = end;
  }

  boolean isHorizontal() {
    return start.y == end.y;
  }

  boolean isVertical() {
    return start.x == end.x;
  }
}

public class SquareFinderGoogle {

  List < LineSegment > horizontal = new ArrayList < > ();
  List < LineSegment > vertical = new ArrayList < > ();

  public void addLine(LineSegment line) {
    if (line.isHorizontal()) {
      horizontal.add(line);
    } else if (line.isVertical()) {
      vertical.add(line);
    }
  }

  private boolean hasHorizontal(int y, int x1, int x2) {

    for (LineSegment l: horizontal) {

      int left = Math.min(l.start.x, l.end.x);
      int right = Math.max(l.start.x, l.end.x);

      if (l.start.y == y &&
        left <= x1 &&
        right >= x2) {
        return true;
      }
    }

    return false;
  }

  private boolean hasVertical(int x, int y1, int y2) {

    for (LineSegment l: vertical) {

      int bottom = Math.min(l.start.y, l.end.y);
      int top = Math.max(l.start.y, l.end.y);

      if (l.start.x == x &&
        bottom <= y1 &&
        top >= y2) {
        return true;
      }
    }

    return false;
  }

  public int countSquares() {

    int count = 0;

    for (LineSegment v1: vertical) {

      for (LineSegment v2: vertical) {

        if (v1 == v2)
          continue;

        int x1 = v1.start.x;
        int x2 = v2.start.x;

        if (x1 >= x2)
          continue;

        int side = x2 - x1;

        // Try every possible bottom y
        for (LineSegment h: horizontal) {

          int y = h.start.y;

          if (hasHorizontal(y, x1, x2) &&
            hasHorizontal(y + side, x1, x2) &&
            hasVertical(x1, y, y + side) &&
            hasVertical(x2, y, y + side)) {

            count++;
          }
        }
      }
    }

    return count;
  }

  public static void main(String[] args) {

    SquareFinderGoogle sf = new SquareFinderGoogle();

    // Horizontal lines
    sf.addLine(new LineSegment(new Point(0, 4), new Point(8, 4))); // Top
    sf.addLine(new LineSegment(new Point(0, 2), new Point(5, 2))); // Middle
    sf.addLine(new LineSegment(new Point(2, 0), new Point(8, 0))); // Bottom

    // Vertical lines
    sf.addLine(new LineSegment(new Point(0, 2), new Point(0, 4))); // Left
    sf.addLine(new LineSegment(new Point(2, 0), new Point(2, 4))); // Center Left
    sf.addLine(new LineSegment(new Point(5, 2), new Point(5, 4))); // Center Right
    sf.addLine(new LineSegment(new Point(8, 0), new Point(8, 4))); // Right

    System.out.println("Squares = " + sf.countSquares());
  }

}

