package hyec.util.spacial.point;

import hyec.util.spacial.vector.Vector2D;

import java.io.Serializable;

/**
 * class Point2D
 * <p>
 * A two dimensional point of doubles to represent a location on a plane.
 *
 * @author Selkie
 * @version 1.1
 */
public class Point2D implements Serializable, Cloneable
{
  /**
   * The X coordinate of this <code>Point2D</code>.
   *
   * @serial
   */
  public double x;

  /**
   * The Y coordinate of this <code>Point2D</code>.
   *
   * @serial
   */
  public double y;

  /**
   * Constructs and initializes a <code>Point2D</code> with
   * coordinates (0,&nbsp;0).
   */
  public Point2D()
  {
    y = x = 0D;
  }

  /**
   * Constructs and initializes a <code>Point2D</code> with
   * the specified coordinates.
   *
   * @param x the X coordinate of the newly
   *          constructed <code>Point2D</code>
   * @param y the Y coordinate of the newly
   *          constructed <code>Point2D</code>
   */
  public Point2D(double x, double y)
  {
    this.x = x;
    this.y = y;
  }

  /**
   * Returns the X coordinate of this <code>Point2D</code> as
   * a <code>double</code>.
   *
   * @return the X coordinate of this <code>Point2D</code>.
   */
  public double getX()
  {
    return x;
  }

  /**
   * Returns the Y coordinate of this <code>Point2D</code> as
   * a <code>double</code>.
   *
   * @return the Y coordinate of this <code>Point2D</code>.
   */
  public double getY()
  {
    return y;
  }

  /**
   * Sets the location of this <code>Point2D</code> to the
   * specified coordinates.
   *
   * @param x the new X coordinate of this {@code Point3I}
   * @param y the new Y coordinate of this {@code Point3I}
   */
  public void set(double x, double y)
  {
    this.x = x;
    this.y = y;
  }

  /**
   * Sets the location of this <code>Point2D</code> to the same
   * coordinates as the specified <code>Point2D</code> object.
   *
   * @param p the specified <code>Point2D</code> to which to set
   *          this <code>Point2D</code>
   */
  public void set(Point2D p)
  {
    set(p.getX(), p.getY());
  }

  /**
   * Returns the square of the distance from this
   * <code>Point2D</code> to a specified <code>Point2D</code>.
   *
   * @param pt the specified point to be measured
   *           against this <code>Point2D</code>
   * @return the square of the distance between this
   * <code>Point2D</code> to a specified <code>Point2D</code>.
   */
  public double distanceSq(Point2D pt)
  {
    double dx = pt.getX() - this.getX();
    double dy = pt.getY() - this.getY();
    return (dx * dx + dy * dy);
  }

  /**
   * Returns the distance from this <code>Point2D</code> to a
   * specified <code>Point2D</code>.
   *
   * @param pt the specified point to be measured
   *           against this <code>Point2D</code>
   * @return the distance between this <code>Point2D</code> and
   * the specified <code>Point2D</code>.
   */
  public double distance(Point2D pt)
  {
    return Math.sqrt(distanceSq(pt));
  }

  /**
   * Returns a new <code>Point2D</code> that has the position of
   * the two <code>Point2D</code>s added together.
   *
   * @param pt the specified point to be added to this <code>Point2D</code>.
   * @return the point who's position is the sum of this <code>Point2D</code>
   * and the specified <code>Point2D</code>.
   */
  public Point2D add(Point2D pt)
  {
    return new Point2D(this.getX() + pt.getX(), this.getY() + pt.getY());
  }

  /**
   * Returns a new <code>Point2D</code> that has the position of
   * the this <code>Point2D</code> added to the coordinates.
   *
   * @param x the X component to be added to this <code>Point2D</code>.
   * @param y the Y component to be added to this <code>Point2D</code>.
   * @return the point who's position is the sum of this <code>Point2D</code>
   * and the specified coordinates.
   */
  public Point2D add(double x, double y)
  {
    return new Point2D(this.getX() + x, this.getY() + y);
  }

  /**
   * Returns a new {@link Point2I} that is this <code>Point2D</code>
   * rounded to the nearest integers.
   *
   * @return the new {@link Point2I} that is this <code>Point2D</code>
   * rounded to the nearest integers.
   */
  public Point2I round()
  {
    return new Point2I((int) Math.round(x), (int) Math.round(y));
  }

  public Point2I toPoint2I() {return new Point2I((int)x,(int)y);}
  public Point2I i() {return toPoint2I();}
  public Point2I ir() {return round();}

  /**
   * Compresses to a magnitude of 1.
   */
  public Point2D compress()
  {
    double mag = Math.sqrt(x*x+y*y);
    return new Point2D(x/mag,y/mag);
  }

  /**
   * Scale the point by a scalar.
   */
  public Point2D scale(double scale)
  {
    return new Point2D(x*scale,y*scale);
  }

  /**
   * Converts this point into a vector from 0,0 to the point's position.
   */
  public Vector2D asVec()
  {
    return new Vector2D(this);
  }

  /**
   * Creates a new object of the same class and with the
   * same contents as this object.
   *
   * @return a clone of this instance.
   * @throws OutOfMemoryError if there is not enough memory, I think.
   */
  public Object clone()
  {
    return new Point2D(x, y);
  }

  /**
   * Determines whether or not two points are equal. Two instances of
   * <code>Point3D</code> are equal if the values of their
   * <code>x</code> and <code>y</code> member fields, representing
   * their position in the coordinate space, are the same.
   *
   * @param obj an object to be compared with this <code>Point2D</code>
   * @return <code>true</code> if the object to be compared is
   * an instance of <code>Point2D</code> and has
   * the same values; <code>false</code> otherwise.
   */
  public boolean equals(Object obj)
  {
    if (obj instanceof Point2D)
    {
      Point2D p2d = (Point2D) obj;
      return (getX() == p2d.getX()) && (getY() == p2d.getY());
    }
    return super.equals(obj);
  }

  @Override
  public String toString()
  {
    return "Point2D{" + getX() + "," + getY() + "}";
  }
}
