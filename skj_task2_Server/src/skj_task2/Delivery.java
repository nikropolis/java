package skj_task2;

import java.util.ArrayList;
//import java.util.concurrent.TimeUnit;

public class Delivery implements Runnable {
	private Handler handler;
	private boolean running;
	private Thread thread;
	
	public Delivery(Handler handler) {
		this.handler = handler;
		running = true;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
//		while (running) {
			for (int i = 0; i < handler.list.size(); i++) {
				Persona persona = handler.list.get(i);

				ArrayList<Persona> list = new ArrayList<>();
				for (int j = 0; j < handler.list.size(); j++) {
					if (j == i)
						continue;
					list.add(handler.list.get(j));
				}

				Pack pack = new Pack();
				pack.type = 'l'; // list
				pack.obj = list;

				UDPSender sender = new UDPSender(persona.ip, persona.port);
				sender.send(pack);
			}
//			try {
//				TimeUnit.SECONDS.sleep(3);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
	}

	public void start(){
		thread = new Thread(this);
		thread.start();
	}
	public void close() {
		running = false;
		thread.interrupt();
	}
	public boolean isActive(){
		return thread != null;
	}

}
