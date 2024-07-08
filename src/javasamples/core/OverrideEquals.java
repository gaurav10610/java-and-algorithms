package javasamples.core;

public class OverrideEquals {

	public static int i = 0;

	static {
		i++;
		System.out.println("This is the initializer block");
	}

	public static void main(String[] args) {
		Complex obj1 = new Complex(100.00, 3000.00);
		Complex obj2 = new Complex(100.00, 3000.00);

		if (obj1.equals(obj2)) {
			System.out.println("Equal");
		} else {
			System.out.println("Not Equal");
		}

		System.out.println("Value of i: " + i);
		System.out.println("Value of i: " + i);
	}

}

class Complex {
	private double re, im;

	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == this) {

			return true;
		}

		if (!(obj instanceof Complex c)) {

			return false;
		} else {

            return Double.compare(this.im, c.im) == 0 && Double.compare(this.re, c.re) == 0;
		}
	}
}
