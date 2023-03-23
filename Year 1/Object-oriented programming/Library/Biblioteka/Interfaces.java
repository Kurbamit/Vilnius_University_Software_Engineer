package Biblioteka;

interface BibliotekaLeidinys{
    boolean isduoti();
    boolean grazinti();
}

interface IsduotiKnyga extends BibliotekaLeidinys{
    int MAX_BOOK_ISSUED_DAYS = 30;
    boolean pratestiKnyga(int days);
    boolean pratestiKnyga();
}

interface IsduotiZurnala extends BibliotekaLeidinys{
    int MAX_JOURNAL_ISSUED_DAYS = 1;
}
