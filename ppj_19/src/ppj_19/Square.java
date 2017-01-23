package ppj_19;

public class Square {
	private int m_nBok;
	private Cylinder c;
	
	public Square(int bok){
		m_nBok = bok;
		c = new Cylinder( bok/2 , bok ); //radius and height
	}
	
	public void Show(){
		int V = m_nBok * m_nBok * m_nBok;
		int P = m_nBok * m_nBok;
		System.out.println("area: " + V);
		System.out.println("value: " + P);	
	}
	
	public void ShowCylinder(){
		c.Show();
	}
	
}
