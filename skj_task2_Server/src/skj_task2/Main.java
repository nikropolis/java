package skj_task2;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Handler handler = new Handler();
		
		RSA rsa = new RSA();
		handler.rsa = rsa;
		
		ArrayList<Persona>list = new ArrayList<>();
		handler.list = list;
		
		UDPListener listener = new UDPListener(6666, handler);
		handler.listener = listener;
		handler.listener.start();
		
		Delivery delivery = new Delivery(handler);
		handler.delivery = delivery;
		handler.delivery.start();
//		Thread postage = new Thread(delivery);
//		handler.postage = postage;
		
		
	}

}
