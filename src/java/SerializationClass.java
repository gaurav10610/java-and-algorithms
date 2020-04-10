package java;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationClass {

  public static void main(String[] args) throws IOException, ClassNotFoundException {

    SuperB obj = new SuperB(10, 20);

    FileOutputStream fOut = new FileOutputStream("data\\Object.ser");
    ObjectOutputStream objOut = new ObjectOutputStream(fOut);
    objOut.writeObject(obj);

    FileInputStream fIn = new FileInputStream("data\\Object.ser");
    ObjectInputStream objIn = new ObjectInputStream(fIn);

    Object object = objIn.readObject();
    if (object instanceof SuperB) {
      SuperB newObj = (SuperB) object;

      System.out.println("Below are the values of the deserialized object: ");
      System.out.println("x: " + newObj.getX());
      System.out.println("y: " + newObj.getY());
    }

    objIn.close();
    fIn.close();
    objOut.close();
    fOut.close();
  }

}


class SuperA implements Serializable {

  private static final long serialVersionUID = 1L;
  int y;

  public int getY() {
    return y;
  }

  SuperA(int y) {
    this.y = y;
  }
}


class SuperB extends SuperA {

  private static final long serialVersionUID = 1L;

  int x;

  public int getX() {
    return x;
  }

  SuperB(int x, int y) {
    super(y);
    this.x = x;
  }

  // private void writeObject(ObjectOutputStream out) throws NotSerializableException {
  // throw new NotSerializableException();
  // }
  //
  // private void readObject(ObjectInputStream in) throws NotSerializableException {
  // throw new NotSerializableException();
  // }
}
