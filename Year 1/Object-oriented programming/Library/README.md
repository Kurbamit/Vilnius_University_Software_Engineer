# Bibliotekos programa

## Programos paskirtis

Ši programa yra skirta bibliotekos valdymui. Ji suteikia vartotojui galimybę pridėti naujas knygas ir žurnalus, atspausdinti jau esamas knygas ir žurnalus, išsaugoti ir nuskaityti leidinius, išduoti ir grąžinti knygas bei žurnalus, pratęsti knygos galiojimą, ištrinti knygas ir žurnalus. Programa leidžia vartotojui tvarkyti bibliotekos leidinius ir atlikti įvairias funkcijas, susijusias su knygų ir žurnalų valdymu. Taip pat, galima gauti informaciją apie galimas komandas pasirinkus komandų punktą.

## Paleidimas

Programai paleisti, reikia turėti tris programinius failus viename aplanke.
- ```LibraryApp.jar```- pagrindinis programos failas.
- ```SaveBooks.ser```- Binarinis failas, kuriame saugomi knygų duomenys.
- ```SaveJournal.ser```- Binarinis failas, kuriame saugomi žurnalų duomenys.

**Programai paleisti reikia turėti:**
- Naujausią Java versiją.
- ```Command line``` arba ```Terminal``` 

**Paleidimas:**
```
cd (programos aplanko su 3 failais vieta)
java -jar LibraryApp.jar
```
Taip pat, galima sukurti script failą, kuriame bus šios dvi komandos.
```.sh``` Windows OS ```.command``` MacOS.

## Funkcionalumas

Ši programa yra bibliotekos valdymo sistema, kuri leidžia vartotojams tvarkyti bibliotekos leidinius ir atlikti įvairias funkcijas, susijusias su knygų ir žurnalų valdymu.

Programos funkcionalumas yra suskirstytas į daugiau nei dešimt punktų, kuriuos galima pasirinkti pagrindiniame meniu. Šie punktai yra:

1. "Pridėti knygą" - leidžia vartotojui pridėti naują knygą į bibliotekos duomenų bazę.
2. "Pridėti žurnalą" - leidžia vartotojui pridėti naują žurnalą į bibliotekos duomenų bazę.
3. "Atspausdinti knygas" - atspausdina visų bibliotekos knygų sąrašą.
4. "Atspausdinti žurnalus" - atspausdina visų bibliotekos žurnalų sąrašą.
5. "Išsaugoti leidinius" - išsaugo bibliotekos duomenų bazę į failą.
6. "Nuskaityti leidinius" - nuskaito bibliotekos duomenų bazę iš failo.
7. "Išduoti knygą" - leidžia vartotojui išduoti knygą.
8. "Išduoti žurnalą" - leidžia vartotojui išduoti žurnalą.
9. "Grąžinti knygą" - leidžia vartotojui grąžinti išduotą knygą.
10. "Grąžinti žurnalą" - leidžia vartotojui grąžinti išduotą žurnalą.
11. "Pratęsti knygos galiojimą" - leidžia vartotojui pratęsti knygos išėjimo terminą.
12. "Ištrinti knygą" - leidžia vartotojui ištrinti knygą iš bibliotekos duomenų bazės.
13. "Ištrinti žurnalą" - leidžia vartotojui ištrinti žurnalą iš bibliotekos duomenų bazės.

-1. "Baigti darbą" - leidžia vartotojui nutraukti programos darbą.
Be to, pasirinkus "Komandos" punktą, vartotojas gali gauti informaciją apie galimas komandas, kurios yra prieinamos programoje.

Visas šis funkcionalumas leidžia vartotojams efektyviai tvarkyti bibliotekos leidinius, atlikti reikalingus veiksmus ir saugoti duomenis.

## Pagrindinės klasės

1. **"Leidinys"** - Abstrakti klasė. Ši klasė paveldi sąsają ```Isduodamas```. Ši klasė saugo leidinių duomenis: pavadinimą, išleidimo metus, išdavimo datą, grąžinimo datą ir išdavimo būseną. Taip pat ši klasė turi ```static``` kintamąjį, kuris saugo leidinių skaičių. Ši klasė taip pat implementuoja ```Serializable``` sąsają, kuri leidžia serijalizuoti klasės objektus ir saugoti juos failuose ar kituose laikmenose.
2. **"Knyga"** - Ši klasė paveldi klasę ```Leidinys``` ir implementuoja sąsajas ```Pratesiamas, Cloneable ir Serializable```. Klasė skirta saugoti knygų duomenims. Klasė turi tris laukus: author (knygos autorius), bookCount (knygų skaičius) ir MAX_BOOK_ISSUED_DAYS (maksimalus knygos išdavimo dienų skaičius). Klasė turi du konstruktoriaus metodus, kurių vienas skirtas sukurti tuščią knygą, o kitas su parametrais: pavadinimu, autoriu ir leidimo metais. Klasė turi dvi išimtis: LibraryException (jei knyga jau išduota, ne išduota arba neegzistuoja), ir NegativeDaysException (jei dienų skaičius yra neigiamas).
3. **"Zurnalas"** - Ši klasė paveldi klasę ```Leidinys``` ir implementuoja sąsajas ```Isduodamas, Cloneable ir Serializable```. Klasė skirta saugoti žurnalų duomenims. Klasė turi tris laukus: redactor (žurnalo redaktorius), journalCount (žurnalų skaičius), MAX_JOURNAL_ISSUED_DAYS (maksimalus žurnalo išdavimo dienų skaičius). Klasė turi du konstruktoriaus metodus, kurių cienas skirtas sukurti tuščią knygą, o kitas su parametrais: pavadinimas, išleidimo metai ir redaktorius. Klasė turi vieną išimtį: LibraryException (jei žurnalas jau išduotas, ne išduotas arba neegzistuoja).
4. **"UserInterface"** - Tai yra pagrindinė vartotojo sąsajos klasė. Kuri yra paleidžiama tik vieną kartą ir veikia visą programos gyvavimo laiką. Ši klasė leidžia atlikti meniu pasirinkimus vartotojui.

## Pagrindinių klasių diagrama UML

<details>
	
[Klasių diagrama](https://lucid.app/lucidchart/303d76dd-85e6-4713-b1e9-722843a213ca/edit?viewport_loc=-161%2C-11%2C2433%2C1361%2C0_0&invitationId=inv_ffdc62fe-4a34-41d8-a81d-531e6c3db57b)
![Class diagram](https://github.com/Kurbamit/Vilnius_University_Software_Engineer/blob/main/Year%201/Object-oriented%20programming/Library/Biblioteka_UML_Diagrama.png)
	
</details>

## Plėtimo galimybės

- Grafinė vartotojo sąsaja
- Leidiniai išduodami skaitytojams
- Padidinti tvarkomų leidinių įvairovę
	- Audio knygos
	- DVD filmai
- Pridėti galimybę kategorizuoti leidinius
- Pridėti galimybę atlikti analizę ir statistiką

## Projektavimo šablonai

- Labiausiai naudojamas projektavimo šablonas šiame projekte yra ```Marker interface``` šis projektavimo šablonas yra Java programavimo kalbos konstrukcija, kuri apibrėžia tuščią sąsają (be jokių metodų) tik tam, kad padarytų objektų tipą žymekliu (markeriu). Tai yra, interfeisu, kurio pagrindinis tikslas yra pažymėti objektus, kad reikiamas kodas galėtų juos atpažinti ir atlikti tam tikrus veiksmus su jais. Šis šablonas buvo panaudotas šiose klasėse:
	- **"Leidinys"** - ```Serializable``` galimybė išsaugoti duomenis faile.
	- **"Knyga"** - ```Serializable``` ir ```Cloneable``` galimybė išsaugoti duomenis faile ir klonuoti objektą.
	- **"Leidinys"** - ```Serializable``` ir ```Cloneable``` galimybė išsaugoti duomenis faile ir klonuoti objektą.
- Kitas projektavimo šablonas, kuris yra panaudotas šiame projekte yra ```Singleton```. Šis šablonas užtikrina, kad bus sukurtas tik vienas objekto egzempliorius. Šis šablonas yra panaudotas šioje klasėje:
	- **"UserInterface"**


