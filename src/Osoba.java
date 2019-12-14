import java.util.ArrayList;
import java.util.List;

public class Osoba {
	
	private String ime;
	private String prezime;
	private String jmbg;
	private String pol;
	private String drzavaRodjenja;
	private String mestoRodjenja;
	private String danRodjenja;
	private String mesecRodjenja;
	private String godinaRodjenja;
	private String kontrolnaGreska = "";
	private boolean validanJMBG = true;
	private boolean kontrolnaCifra = true;
	
	public Osoba() {
		
	}
		
	public Osoba(String ime, String prezime, String jmbg) {
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getJmbg() {
		return jmbg;
	}
	
	public boolean getValidanJMBG() {
		return validanJMBG;
	}

	public String getKontrolnaGreska() {
		return kontrolnaGreska;
	}
	
	
	public void setJmbg(String jmbg) {

		char[] a= jmbg.toCharArray();

			for(char s : a) {
				if(s == ' ') {
					validanJMBG = false;
					kontrolnaGreska = "Unijeli ste whitespace!" + "\n";
				}
				else if(!Character.isDigit(s)) {
					validanJMBG = false;
					kontrolnaGreska = "Dozvoljen je samo unos brojeva!" + "\n";
				} 
			}
			if (jmbg == null || jmbg == "" || jmbg.length() != 13) {
				validanJMBG = false;
				kontrolnaGreska += "Neispravna dužina maticnog broja." + "\n";
				
			} else {
				this.jmbg = jmbg;
			}
	} 

	public String getGodinaRodjenja() {
		String godRodjenja = jmbg.substring(4, 7);
		if (godRodjenja.substring(0, godRodjenja.length() - 2).equals("0")) {
			godRodjenja = "2" + godRodjenja;
		} else if(godRodjenja.substring(0, 1).equals("1")) {
			godRodjenja = "2" + godRodjenja;
		}
		else {
			godRodjenja = "1" + godRodjenja;
		}
		return godinaRodjenja = godRodjenja;
	}
	
	public String getDanRodjenja() {
		Integer dan = Integer.parseInt(jmbg.substring(0, 2));
		if(dan > 31 || dan < 1) {
			validanJMBG = false;
			kontrolnaGreska += "Prve 2 cifre označavaju dan i ne smiju biti veće od 31!" + "\n";
		}
		danRodjenja = Integer.toString(dan);
		return danRodjenja;
	}

	public String getMesecRodjenja() {
		Integer mesec = Integer.parseInt(jmbg.substring(2, 4));
		if(mesec > 12 || mesec < 1) {
			validanJMBG = false;
			kontrolnaGreska += "3 i 4 cifra označavaju mesec i broj ne smije biti veći od 12!" + "\n";
		} 		
		else {
		switch (mesec) {
		case 1:
			mesecRodjenja = "Januar";
			break;
		case 2:
			mesecRodjenja = "Februar";
			break;
		case 3:
			mesecRodjenja = "Mart";
			break;
		case 4:
			mesecRodjenja = "April";
			break;
		case 5:
			mesecRodjenja = "Maj";
			break;
		case 6:
			mesecRodjenja = "Jun";
			break;
		case 7:
			mesecRodjenja = "April";
			break;
		case 8:
			mesecRodjenja = "Avgust";
			break;
		case 9:
			mesecRodjenja = "Septembar";
			break;
		case 10:
			mesecRodjenja = "Oktobar";
			break;
		case 11:
			mesecRodjenja = "Novembar";
			break;
		case 12:
			mesecRodjenja = "Decembar";
			break;
		default:
			throw new IllegalArgumentException("Unijeli ste nepostojeci mjesec: " + mesec);
		}
		}
		
		if(mesec <= 12) {
			if (mesec == 1 || mesec == 3 || mesec == 5 || mesec == 7 || mesec == 8 || mesec == 10 || mesec == 12) {
				if(Integer.parseInt(danRodjenja) > 31) {
					validanJMBG = false;
					kontrolnaGreska += mesecRodjenja + " ne može imati više od 31 dan" + "\n";
				}
			 }
			else if(mesec == 4 || mesec == 6 || mesec == 9 || mesec == 11) {
				 if(Integer.parseInt(danRodjenja) > 30) {
					 validanJMBG = false;
					 kontrolnaGreska += mesecRodjenja + " ne može imati više od 30 dana." + "\n";
			 }
			} 
			else if(mesec == 2) {
				 if(Integer.parseInt(getGodinaRodjenja()) % 4 == 0) {
					 if(Integer.parseInt(danRodjenja) > 29) {
						 validanJMBG = false;
						 kontrolnaGreska += "Februar prestupne godine nema vise od 29 dana" + "\n";
					 }
				} else if(Integer.parseInt(getGodinaRodjenja()) % 4 != 0) {
					 if(Integer.parseInt(danRodjenja) > 28) {
						 validanJMBG = false;
						 kontrolnaGreska += "Februar neprestupne godine nema vise od 28 dana" + "\n";

				}
			}
		}
		}
		return mesecRodjenja;
	}
	
	public String getDrzavaRodjenja() {
		return drzavaRodjenja;
	}
	
	public String getMestoRodjenja() {
		return mestoRodjenja;
	}
	
	public int odrediRegionRodjenja() {
		Integer regionRodjenja = Integer.parseInt(jmbg.substring(7, 9));
		
		
		if(regionRodjenja > 0 && regionRodjenja < 10) {
			drzavaRodjenja = "Stranci bez državljanstva bivše SFRJ";
			switch (regionRodjenja) {
			case 1:
				mestoRodjenja = "stranci u BiH";
				break;
			case 2:
				mestoRodjenja = "stranci u Crnoj Gori";
				break;
			case 3:
				mestoRodjenja = "stranci u Hrvatskoj";
				break;
			case 4: 
				mestoRodjenja = "stranci u Makedoniji";
				break;
			case 5: 
				mestoRodjenja = "stranci u Sloveniji";
				break;
			case 7:
				mestoRodjenja = "stranci u Srbiji (bez pokrajina)";
				break;
			case 8:
				mestoRodjenja = "stranci u Vojvodini";
				break;
			case 9:
				mestoRodjenja = "stranci na Kosovu i Metohiji";
				break;
			default:
				mestoRodjenja = "Nije Poznato";
				break;
			}
		}
		
		if(regionRodjenja >= 10 && regionRodjenja <= 19) {
			drzavaRodjenja = "Bosna i Hercegodina";
			switch (regionRodjenja) {
			case 10:
				mestoRodjenja = "Banja Luka";
				break;
			case 11:
				mestoRodjenja = "Bihac";
				break;
			case 12:
				mestoRodjenja = "Doboj";
				break;
			case 13:
				mestoRodjenja = "Gorazde";
				break;
			case 14:
				mestoRodjenja = "Livno";
				break;
			case 15:
				mestoRodjenja = "Mostar";
				break;
			case 16:
				mestoRodjenja = "Prijedor";
				break;
			case 17:
				mestoRodjenja = "Sarajevo";
				break;
			case 18:
				mestoRodjenja = "Tuzla";
				break;
			case 19:
				mestoRodjenja = "Zenica";
				break;
			default:
				mestoRodjenja = "Nije Poznato";
				break;
		}
			
		} else if (regionRodjenja > 20 && regionRodjenja < 30) {
			drzavaRodjenja = "Crna Gora";
			switch (regionRodjenja) {
			case 21:
				mestoRodjenja = "Podgorica";
				break;
			case 26:
				mestoRodjenja = "Niksic";
				break;
			case 29:
				mestoRodjenja = "Pljevlja, ";
				break;
			default:
				mestoRodjenja = "Nije Poznato";
				break;
			}
		} 
		
		else if (regionRodjenja >= 30 && regionRodjenja < 40) {
			drzavaRodjenja = "Hrvatska";
			switch (regionRodjenja) {
			case 30:
				mestoRodjenja = "Osijek, Slavonija region";
				break;
			case 31:
				mestoRodjenja = "Bjelovar, Virovitica, Koprivnica, Pakrac, Podravina regija";
				break;
			case 32:
				mestoRodjenja = "Varaždin, Medimurje regija";
				break;
			case 33:
				mestoRodjenja = "Zagreb";
				break;
			case 34:
				mestoRodjenja = "Karlovac";
				break;
			case 35:
				mestoRodjenja = "Gospic, Lika regija";
				break;
			case 36:
				mestoRodjenja = "Rijeka, Pula, Istra i Primorje regija";
				break;
			case 37:
				mestoRodjenja = "Sisak, Banovina regija";
				break;
			case 38:
				mestoRodjenja = "Split, Zadar, Dubrovnik, Dalmacija regija";
				break;
			case 39:
				mestoRodjenja = "Ostalo";
				break;
			default:
				mestoRodjenja = "Nije Poznato";
				break;
			}
		}
		
		else if (regionRodjenja > 40 && regionRodjenja < 50) {
			drzavaRodjenja = "Makedonija";
			switch (regionRodjenja) {
			case 41:
				mestoRodjenja = "Bitolj";
				break;
			case 42:
				mestoRodjenja = "Kumanovo";
				break;
			case 43:
				mestoRodjenja = "Ohrid";
				break;
			case 44:
				mestoRodjenja = "Prilep";
				break;
			case 45:
				mestoRodjenja = "Skoplje";
				break;
			case 46:
				mestoRodjenja = "Strumica";
				break;
			case 47:
				mestoRodjenja = "Tetovo";
				break;
			case 48:
				mestoRodjenja = "Veles";
				break;
			case 49:
				mestoRodjenja = "Stip";
				break;
			default:
				mestoRodjenja = "Nije Poznato";
				break;
			}
		}

		else if (regionRodjenja >= 50 && regionRodjenja < 60) {
			drzavaRodjenja = "Slovenija";
			mestoRodjenja = "Slovenija";
		}

		else if (regionRodjenja > 70 && regionRodjenja < 80) {
			drzavaRodjenja = "Srbija";
			switch (regionRodjenja) {
			case 71:
				mestoRodjenja = "Beograd regija";
				break;
			case 72:
				mestoRodjenja = "Šumadija";
				break;
			case 73:
				mestoRodjenja = "Niš";
				break;
			case 74:
				mestoRodjenja = "Južna Morava";
				break;
			case 75:
				mestoRodjenja = "Zajecar";
				break;
			case 76:
				mestoRodjenja = "Podunavlje";
				break;
			case 77:
				mestoRodjenja = "Podrinje i Kolubara";
				break;
			case 78:
				mestoRodjenja = "Kraljevo";
				break;
			case 79:
				mestoRodjenja = "Uzice";
				break;
			default:
				mestoRodjenja = "Nije Poznato";
				break;
			}
		}

		else if (regionRodjenja >= 80 && regionRodjenja < 90) {
			drzavaRodjenja = "Srbija";
			switch (regionRodjenja) {
			case 80:
				mestoRodjenja = "Novi Sad";
				break;
			case 81:
				mestoRodjenja = "Sombor";
				break;
			case 82:
				mestoRodjenja = "Subotica";
				break;
			case 85:
				mestoRodjenja = "Zrenjanin";
				break;
			case 86:
				mestoRodjenja = "Pancevo";
				break;
			case 87:
				mestoRodjenja = "Kikinda";
				break;
			case 88:
				mestoRodjenja = "Ruma";
				break;
			case 89:
				mestoRodjenja = "Sremska Mitrovica";
				break;
			default:
				mestoRodjenja = "Nije Poznato";
				break;
			}
		}

		else if (regionRodjenja > 90 && regionRodjenja < 99) {
			drzavaRodjenja = "Srbija";
			switch (regionRodjenja) {
			case 91:
				mestoRodjenja = "Pristina";
				break;
			case 92:
				mestoRodjenja = "Kosovksa Mitrovica";
				break;
			case 93:
				mestoRodjenja = "Pec";
				break;
			case 94:
				mestoRodjenja = "Djakovica";
				break;
			case 95:
				mestoRodjenja = "Prizren";
				break;
			case 96:
				mestoRodjenja = "Gnjilane";
				break;
			default:
				mestoRodjenja = "Nije Poznato";
				break;
			}
		}
		return regionRodjenja;
	}
	
	public String getPol() {
		Integer pol = Integer.parseInt(jmbg.substring(9, 12));
		if(pol >= 0 && pol <= 499) {
			this.pol = "Muški";
		} else if(pol >= 500 && pol <= 999) {
			this.pol = "Ženski";
		}
		return this.pol;
	}
	
	public boolean kontrolnaCifra() {
		int tacnaCifra;
		Integer A = Integer.parseInt(jmbg.substring(0, 1));
		Integer B = Integer.parseInt(jmbg.substring(1, 2));
		Integer V = Integer.parseInt(jmbg.substring(2, 3));
		Integer G = Integer.parseInt(jmbg.substring(3, 4));
		Integer D = Integer.parseInt(jmbg.substring(4, 5));
		Integer Ð = Integer.parseInt(jmbg.substring(5, 6));
		Integer E = Integer.parseInt(jmbg.substring(6, 7));
		Integer Ž = Integer.parseInt(jmbg.substring(7, 8));
		Integer Z = Integer.parseInt(jmbg.substring(8, 9));
		Integer I = Integer.parseInt(jmbg.substring(9, 10));
		Integer J = Integer.parseInt(jmbg.substring(10, 11));
		Integer K = Integer.parseInt(jmbg.substring(11, 12));
		Integer L = Integer.parseInt(jmbg.substring(12, 13));

		tacnaCifra = 11 - (( 7*(A+E) + 6*(B+Ž) + 5*(V+Z) + 4*(G+I) + 3*(D+J) + 2*(Ð+K) ) % 11);
		
		if(tacnaCifra <= 9) {
			if(tacnaCifra != L) {
				validanJMBG = false;
				kontrolnaCifra = false;
				kontrolnaGreska += "Neispravan JMBG!" + "\n";
			}
		} else if(tacnaCifra > 9) {
			if(tacnaCifra != 0) {
				validanJMBG = false;
				kontrolnaCifra = false;
				kontrolnaGreska += "Neispravan JMBG!" + "\n";
			}
		}
		return kontrolnaCifra;
	}
}
