package test_network_DNS_TCP;

import java.io.IOException;
import java.net.InetAddress;
import org.xbill.DNS.*;

public class DNSClient { 
static boolean tcp = false; 
public static void main(String[] args) throws IOException{ 
	if(args.length == 4){ // jesli liczba argumentow jest rowna 4( argumenty skladaja sie z(--server, adres, --query, typ)
		if(args[0].equals("--server") && args[2].equals("--query")){  // jesli sie zgadza
			InetAddress adress = InetAddress.getByName(args[1]);  // pobierz adress z argumentu
			toRecord(adress,args[3],tcp); //wykonaj probe
		}else{ 
			System.err.println("Wrong parameters"); //jesli parametry sie nie zgadzaja, wypisz blad
		} 
	}else{System.err.println("Wrong number of arguments");} //jesli nie jest rowna 4, wypisz blad
}
public static void toRecord(InetAddress adress ,String recordType, boolean useTCP) throws IOException { 
	try{
	System.out.println("ANSWER SECTION:"); 
	Resolver res = new SimpleResolver();  //tworze resolver ktory umozliwi mi wyslanie i przechwycenie wiadomosci
	res.setPort(53); //ustawiam port na 53
		if(useTCP){ //jesli true(oznacza ze flaga TC zostala ustawiona w poprzedniej probie)
			res.setIgnoreTruncation(false);  // wylacza ignorowanie Truncation, przez co przelacza sie z UDP na TCP
		} 
	Name name = Name.fromString(adress.getHostName(), Name.root); // Tworze nazwe z podanego adresu
	int type = Type.value(recordType); // Wyciagam z argumentu nazwe podana przez uzytkownika, i zamieniam ja na integera
	int dclass = DClass.ANY;  //ustawiam klase na any
	Record rec = Record.newRecord(name, type, dclass); // Tworze rekord DNS, z nazwy, typu zapytania i klasy
	Message query = Message.newQuery(rec); //Tworze wiadomosc z mojego utworzonego rekordu
	query.getHeader().setFlag(Flags.RD); //ustawiam flage Recursive Desired w moim zapytaniu.
	Message response = res.send(query);  // przechwytuje odpowiedz do obiektu responce
	if(response.getHeader().getFlag(Flags.TC)){ //jesli ten obiekt zawiera w swoim naglowku ustawiona flage TC(czyli jesli wiadomosc jest zbyt dluga)
		System.out.println("Truncation Retrying with TCP..."); 
		tcp = true; 
		toRecord(adress,recordType, tcp); // ponawiam zapytanie 
	}else{ 
		Record[] answers = response.getSectionArray(Section.ANSWER); // pobierz do tablicy recordow cala zawartosc sekcji odpowiedzi
		if (answers.length == 0) { //jesli sekcja jest pusta, wyswietl null
			System.err.println("null"); 
		} else { 
			for (Record answer : answers) { //jesli nie, wyswietl wszystkie odpowiedzi
				System.out.println(answer.toString()); 

			} 
		} 
	} 
	}catch(Exception e){
		System.err.println("Wrong recordType"); //jesli typ rekordu wpisany przez uzytkownika jest zly, wyswietl blad
	} 
	}
}