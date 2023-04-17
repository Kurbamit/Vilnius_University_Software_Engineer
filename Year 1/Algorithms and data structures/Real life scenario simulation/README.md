# Real life scenario simulation

`Priėmimo komisija (ADT: dekas). Procesas: priėmimo komisijoje dirba 2
darbuotojos, kurių produktyvumas skirtingas, jos priima stojančiųjų prašymus ir stato į lentyną,
kiekviena iš savo pusės, kai nėra stojančiųjų ir pasibaigus tos dienos priėmimui, jos ima stojančiųjų
prašymus ir juos sutvarko. Tikslas: patyrinėti, kiek laiko reikia skirti prašymų tvarkymui, pasibaigus jų
priėmimui. Pradiniai duomenys: darbuotojų produktyvumas (abi darbuotojos prašymo priėmimui
sugaišta vienodai laiko, bet prašymo sutvarkymui skirtingai laiko), stojančiojo atėjimo tikimybė
(galima realizacija: generuojamas atsitiktinis skaičius ir tikrinama, ar jis tenkina tam tikrą sąlygą),
dokumentų priėmimo laikas. Rezultatai: papildomas darbo laikas, kuris turi būti skiriamas prašymų
tvarkymui, darbuotojų užimtumas (procentais), nes galima situacija, kad pagal pateiktus pradinius
duomenis stojančiųjų intensyvumas toks nedidelis, kad dalį laiko darbuotojos poilsiauja.`
---
#### params.txt
- How long does it take to accept documents
- Productivity of the first worker
- Productivity of the second worker
- Change (in percent) that new person will come in every moment of time
- How long we will simulate (moments of time)
---

#### Output
- How many documents were accepted
- How long it took
- How much more time needed (if needed)
- Workers effort (in percent)
