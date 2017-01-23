package utp3;

import java.util.Arrays;
import java.util.List;

public class lesson {
	

	
	
	public static void main(String[] args){
		
		IFunc<Double, Double> exp = new IFunc<Double, Double>(){
			public Double call(Double a){
				return Math.pow(a, 0.5);
			}
		};
		
		IBFunc<Double, Double, Double> exp2 = new IBFunc<Double, Double, Double>(){
			public Double call(Double a, Double b){
				return Math.pow(a, b);
			}
		};
		
		IFunc < PAIR<Double, Double>, Double > exp3 = new IFunc < PAIR<Double, Double>, Double >(){
			public Double call(PAIR<Double, Double> a){
				return Math.pow(a.FST(), a.SND());
			}
		};
		
		IFunc< Double, IFunc<Double,Double> > lambda = x -> y -> Math.pow(x, y);
		
		IBFunc< Double, Double,Double>  f = (x, y) -> Math.pow(x, y);
		
	    List<Integer> src1 = Arrays.asList(1, 7, 9, 11, 12); 
	    List<String> src2 = Arrays.asList("a", "zzzz", "vvvvvvv");

	    //System.out.println( map);
		
	}
	

}
