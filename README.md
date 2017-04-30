Objektno orijentisano projektovanje – Projektni zadatak 

Dobili ste zadatak da napravite aplikaciju za školsko takmičenje u programiranju. Aplikacija radi sa učenicima,
administratorom i članovima komisije.

Kada korisnik pokrene aplikaciju na ekranu mu se pojavljuje meni sa sledećim opcijama:

0.	Izađite iz aplikacije

1.	Ulogujte se

2.	Vidite rang listu učenika

0 – Korisnik izlazi iz aplikacije i aplikacija se gasi.

1 – Korisnik se loguje sa svojim korisničkim imenom. Korisnička imena počinju sa malim početnim slovom. 
Početna slova su: ’t’ – takmičar odnosno učenik koji se takmiči, 
’k’ – član komisije i ’a’ – korisnik koji je administrator,
a zatim je ostatak imena dodeljeno korisničko ime. 
Na osnovu prvog slova formira se novi korisnik. Ukoliko korisnik nije uneo dobre podatke baca se izuzetak o 
lošem logovanju a korisniku se daju još dva pokušaja nakon čega ukoliko nije uspeo da se uloguje aplikacija se gasi.
Podaci o logovanju nalaze se u bazi podataka.

2 – Izlistava sve učenike sa brojem osvojenih bodova sa takmičenja. Bodovi su poredani po kategorijama, i zadnja kolona je 
kolona za prikaz ukupnog broja bodova po kojim se učenici rangiraju.
Image

Administrator je glavni korisnik koji ima korisničko ime i lozinku i koji može da dodaje druge korisnike i da ih briše iz 
aplikacije. Kada se administrator uloguje vidljiv mu je sledeći meni

0.	Izlogujte se

1.	Dodajte takmičara

2.	Dodajte člana komisije

3.	Obrišite korisnika

0 - Korisnik se vraća na početni ekran i njegov profil prestaje da postoji.

1 – dodaje takmičara u aplikaciju. Podatke vezane za takmičara možete videti u sekciji „Takmičar“.

3 – Dodaje novog člana komisiji za navedenu komisiju (informacije vezane za člana komisije pogledati u sekciji „Članovi komisije“).

4 - Može da obriše nekog korisnika za uneti username. Ne može da briše korisnike koji imaju predznak ’a’. 
Može obrisati sebe što se smatra kao gašenje naloga nakon čega se vraća na početni ekran (Start aplikacije)


Takmičar je korisnik koji ima korisničko ime i lozinku i koji dolaskom na ekran za takmičara može da preda svoj rad.
Rad se predaje tako što se unese apsolutna putanja do txt fajla gde se nalazi takmičarov rad koji se kopira u folder 
koji pregleda komisija. Ime novog fajla je isto kao korisničko ime takmičara. Ukoliko već postoji fajl, stari sadržaj se briše.
Sadržaj tekstualnog fajla nije bitan. Takmičar može videti i informacije o svom predatom radu od strane komisije 
ukoliko je rad ocenjen. Ukoliko nije takmičar vidi status „U fazi ocenjivanja...“. Komentari za rad se povlače iz baze podataka,

Član komisije je korisnik koji ima ime i lozinku. Kada se član komisije uloguje prikazuje mu se sledeći meni:

0.	Odjavite se

1.	Prikaži spisak radova

2.	Oceni rad

0 - Korisnik se vraća na početni ekran i njegov profil prestaje da postoji.

1 – Prikazuje spisak radova. Predati radovi nalaze se na predefinisanoj lokaciji čija je putanja navedena prilikom
pisanja koda aplikacije. To je lokacija gde se smeštaju radovi takmičara.

2 - Na osnovu imena može da oceni rad takmičara. Željeni rad bira na osnovu imena, nakon čega mu prikazuje sadržaj rada. 
Ocenjivanje se izvršava tako što član komisije u jednom redu u terminalu unosi tri ocene. 
Ocene se unose u sledećem redosledu – prva ocena je za kvalitet koda, druga ocena je tačnost koda a treća ocena je opšti utisak.
Ove ocene je potrebno obraditi i upisati ih zasebno u bazu podataka i kao četvrto polje srednju ocenu koja formirana na osnovu 
unetih ocena. Ova lista se kasnije prikazuje kao tabela javnosti kada izaberu opciju 2 na početnom ekranu. Komentari nisu vidljivi 
pored tabele.


