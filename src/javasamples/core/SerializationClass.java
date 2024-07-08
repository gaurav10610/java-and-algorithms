package javasamples.core;

import java.io.*;

public class SerializationClass {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        SuperB obj = new SuperB(10, 20);

        FileOutputStream fOut = new FileOutputStream("data\\Object.ser");
        ObjectOutputStream objOut = new ObjectOutputStream(fOut);
        objOut.writeObject(obj);

        FileInputStream fIn = new FileInputStream("data\\Object.ser");
        ObjectInputStream objIn = new ObjectInputStream(fIn);

        Object object = objIn.readObject();
        if (object instanceof SuperB newObj) {

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

    @Serial
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

    @Serial
    private static final long serialVersionUID = 1L;

    int x;

    public int getX() {
        return x;
    }

    SuperB(int x, int y) {
        super(y);
        this.x = x;
    }
}
