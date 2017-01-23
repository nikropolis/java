package ppj_19;

public class Main {

	public static void main(String[] args) {

		{
			B b = new B();
			b.nsShowThis();
			B.sShowThis();
			System.out.println();
		}
		
		{
			Square s = new Square(10);
			s.Show();
			System.out.println();
		}
		
		{
			Cylinder c = new Cylinder(5, 11);
			c.Show();
			System.out.println();
		}
		
		{
			Square s = new Square(12);
			s.ShowCylinder();
			System.out.println();
		}
		
		{
			Word w = new Word();
			w.addChar('H');
			w.addChar('E');
			w.addChar('L');
			w.addChar('L');
			w.addChar('O');
			
			System.out.println( w.toString() ) ;
			System.out.println( w.length() );
			
		}
		
	}

}
