package client;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.PublicKey;
import java.time.temporal.ChronoUnit;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import baza.Korisnik;
import baza.PCRTest;
import baza.Status;
import baza.Test;
import baza.TipTesta;
import client.gui.GlavniProzor;
import client.gui.Registracija;
import paket.Paket;


public class Client implements Runnable {

	static Socket socket;
	public static ObjectInputStream inObj;
	public static ObjectOutputStream outObj;
	public static BufferedReader in;
	public static PrintStream out;

	static Registracija registracijaProzor;

	static GlavniProzor glavniProzor;

	public static LinkedList<Korisnik> korisnici = null;
	public static LinkedList<Test> testoviKorisnika = new LinkedList<>();

	public static String[] statistika = null;

	public static PCRTest pcrTest = null;

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

			socket = new Socket("localhost", 9000);

			inObj = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));

			outObj = new ObjectOutputStream(socket.getOutputStream());

			new Thread(new Client()).start();

			int br = 0;

			Client.zatraziStatistiku();
			Client.zatraziKorisnike();
			
			

			while (true) {

				
				Paket odgovorPaket = (Paket) inObj.readObject();

				String zahtev = odgovorPaket.getZaglavlje();

				switch (zahtev) {

				case "prijava":
					if (odgovorPaket.getKodPotvrde().equals("postoji") && odgovorPaket.getData() != null) {
						System.out.println(odgovorPaket.getZaglavlje() + "  " + odgovorPaket.getKodPotvrde() + "\n"
								+ ((Korisnik) odgovorPaket.getData()).toString());
						Korisnik korisnik = (Korisnik) odgovorPaket.getData();

						// korisnik.setVremePoslednjePrijave(new GregorianCalendar());

						if (korisnik.getUsername().equals("admin")) {
							glavniProzor.prikaziAdminPanel(korisnik);
						} else {
							zatraziTestove(korisnik.getUsername());
							glavniProzor.prikaziGlavniPanel((Korisnik) odgovorPaket.getData());
							
						}

					} else {
						glavniProzor.loginPanel.ispisiLoginGresku();
					}

					break;

				case "registracija":

					if (odgovorPaket.getKodPotvrde().equals("uspesno") && odgovorPaket.getData() != null) {

						registracijaProzor.ispisiRezultat("Uspesno", "Registracija uspela novi korisnik je \n"
								+ ((Korisnik) odgovorPaket.getData()).toString());
						System.out.println("Registracija uspela novi korisnik je \n"
								+ ((Korisnik) odgovorPaket.getData()).toString());
						registracijaProzor.dispose();
					} else {

						registracijaProzor.ispisiRezultat("Greska",
								"Registracija neuspela " + (String) odgovorPaket.getData());
						System.out.println("Registracija neuspela " + (String) odgovorPaket.getData());
					}

					break;

				case "pcrStanje":

					glavniProzor.setStanjePCRTestaNaPanelu((String) odgovorPaket.getData());

					break;

				case "zahtevZaPCR":

					if (odgovorPaket.getKodPotvrde().equals("postoji")) {

						pcrTest = (PCRTest) odgovorPaket.getData();
						pratiPCRStanje();
					}

					break;

				case "testoviKorisnika":

					if (odgovorPaket.getKodPotvrde().equals("uspesno") && odgovorPaket.getData() != null) {

						testoviKorisnika = (LinkedList<Test>) odgovorPaket.getData();
					} else if (odgovorPaket.getData() == null) {

						testoviKorisnika = new LinkedList<>();
						System.out.println("Lista testova je prazna");
					}

					break;

				case "statistika":

					if (odgovorPaket.getKodPotvrde().equals("uspesno") && odgovorPaket.getData() != null) {
						statistika = (String[]) odgovorPaket.getData();
					}

					break;

				case "sviKorisnici":

					if (odgovorPaket.getKodPotvrde().equals("uspesno") && odgovorPaket.getData() != null) {

						korisnici = (LinkedList<Korisnik>) odgovorPaket.getData();

						
					} else if (odgovorPaket.getData() == null) {

						korisnici = new LinkedList<>();
						System.out.println("Lista korisnika je prazna");
					}

					break;

				default:
					break;
				}

				;

			}

			// socket.close();

		} catch (UnknownHostException e) {

			e.printStackTrace();
		} catch (IOException e) {

			System.out.println(e.getMessage());
			System.out.println("Server je pao!");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void zatraziPCR() {

		try {
			outObj.writeObject(new Paket("zahtevZaPCR", "none", glavniProzor.getKorisnik().getUsername()));
			outObj.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	

	@Override
	public void run() {

		glavniProzor = new GlavniProzor(null);
		glavniProzor.setVisible(true);
		
	}

	public static void prijavaKorisnika(String username, String password) {

		try {
			outObj.writeObject(new Paket("prijava", "none",
					new Korisnik(username, password, "", "", "", "", Status.NIJE_TESTIRAN, null)));
			outObj.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("prijava-" + username + "-" + password);

	}

	public static void registracijaKorisnikaProzor() {

		registracijaProzor = new Registracija();
		registracijaProzor.setVisible(true);

	}

	public static void registracijaKorisnika(Korisnik korisnik) {

		try {
			outObj.writeObject(new Paket("registracija", "none", korisnik));
			outObj.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void sacuvajKorisnika(Korisnik korisnik) {

		try {
			outObj.writeObject(new Paket("sacuvajKorisnika", "none", korisnik));
			outObj.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	public static void zapocniPCRTest() {

		int dodajMin = 1;


		GregorianCalendar vreme = new GregorianCalendar();

		GregorianCalendar vreme2 = new GregorianCalendar(vreme.get(GregorianCalendar.YEAR),
				vreme.get(GregorianCalendar.MONTH), vreme.get(GregorianCalendar.DAY_OF_MONTH),
				vreme.get(GregorianCalendar.HOUR_OF_DAY), (vreme.get(GregorianCalendar.MINUTE) + dodajMin));

		pcrTest = new PCRTest(vreme, vreme2, glavniProzor.getKorisnik().getUsername());

		try {
			outObj.writeObject(new Paket("zapocniPCR", "none", pcrTest));
			outObj.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		pratiPCRStanje();
	}

	public static void promeniStatus(Status status) {

		try {
			outObj.writeObject(new Paket("statusIzmena", "none", status));
			outObj.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	public static void zatraziTestove(String username) {
	//	testoviKorisnika=null;
		try {
			outObj.writeObject(new Paket("testoviKorisnika", "none", username));
			outObj.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	public static void posaljiTest(Test t) {
		try {
			outObj.writeObject(new Paket("klijentSaljeTest", "none", t));
			outObj.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	public static void zatraziStatistiku() {
		statistika = null;
		try {
			outObj.writeObject(new Paket("statistika", "none", null));
			outObj.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	public static void zatraziKorisnike() {
		korisnici = null;
		try {
			outObj.writeObject(new Paket("sviKorisnici", "none", null));
			outObj.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	public static boolean testMoguc(TipTesta tip) {

		GregorianCalendar vreme = new GregorianCalendar();
		int dan = vreme.get(GregorianCalendar.DAY_OF_MONTH);
		int mesec = vreme.get(GregorianCalendar.MONTH);
		int godina = vreme.get(GregorianCalendar.YEAR);

		for (Test t : testoviKorisnika) {
			if (t.getVreme().get(GregorianCalendar.DAY_OF_MONTH) == dan
					&& t.getVreme().get(GregorianCalendar.MONTH) == mesec
					&& t.getVreme().get(GregorianCalendar.YEAR) == godina && t.getTipTesta().equals(tip)) {
				return false;
			}
		}

		return true;
	}

	

	static void pratiPCRStanje() {
		
		if(pcrTest==null) return;
		glavniProzor.setStanjePCRTestaNaPanelu("U obradi");
		Thread pcrNit = new Thread() {
			public void run() {
				
				if(new GregorianCalendar().after(pcrTest.getVremeZavrsetka())) {
					glavniProzor.rezultatPCRTesta();
					return;
					
				}

				while (true) {
					if(new GregorianCalendar().after(pcrTest.getVremeZavrsetka())) {
						glavniProzor.rezultatPCRTesta();
						break;
				}
	

			}
				glavniProzor.setStanjePCRTestaNaPanelu("PCR gotov");
				obrisiPCRTest();
		}

		
		};
		
		pcrNit.start();
	}
	
	public static void obrisiPCRTest() {
		try {
			outObj.writeObject(new Paket("obrisiPCR", "none", glavniProzor.getKorisnik().getUsername()));
			outObj.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
	
	static Test vratiPoslednjiTest(TipTesta tip) {

		Test poslednji = null;

		for (Test t : testoviKorisnika) {
		
			if (poslednji == null && t.getTipTesta().equals(tip)) {
				poslednji = t;
			} else if (poslednji != null && t.getTipTesta().equals(tip) && poslednji.getVreme().before(t.getVreme())) {
				poslednji = t;
			}
		}
		if(poslednji!=null) {
			System.out.println(poslednji.getKorisnik()+" "+poslednji.getVreme().get(GregorianCalendar.DAY_OF_MONTH)+" "+poslednji.getVreme().get(GregorianCalendar.MONTH)+1);
		}
		return poslednji;
	}
	public static boolean istekaoPeriodTestasamoprocene() {

		if(!glavniProzor.getKorisnik().getStatus().equals(Status.POD_NADZOROM)) {
			return false;
		}
		
		GregorianCalendar vreme = new GregorianCalendar();
		int dan = vreme.get(GregorianCalendar.DAY_OF_MONTH);
		int mesec = vreme.get(GregorianCalendar.MONTH);
		int godina = vreme.get(GregorianCalendar.YEAR);
		int sat = vreme.get(GregorianCalendar.HOUR_OF_DAY);
		int minut = vreme.get(GregorianCalendar.MINUTE);

		Test test = Client.vratiPoslednjiTest(TipTesta.TESTSAMOPROCENE);

		if (test == null) {
			System.out.println("Nema test");
			return false;
		}

		GregorianCalendar vremeTesta = test.getVreme();
		System.out.println("Vreme testa "+vremeTesta.toString());
		int godinaT = vremeTesta.get(GregorianCalendar.YEAR);
		int mesecT = vremeTesta.get(GregorianCalendar.MONTH);
		int danT = vremeTesta.get(GregorianCalendar.DAY_OF_MONTH);
		int satT = vremeTesta.get(GregorianCalendar.HOUR_OF_DAY);
		int minutT = vremeTesta.get(GregorianCalendar.MINUTE);

		if (godinaT < godina)
			return true;
		if (mesecT < mesec)
			return true;
		if (danT < dan)
			return true;
		if (satT < sat)
			return true;
		if (minutT < minut)
			return true;

		return false;

	}
}
