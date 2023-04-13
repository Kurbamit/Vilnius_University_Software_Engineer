package Biblioteka;

// Pagrindinis interface
interface Isduodamas{
    void isduoti() throws PublicationIssuedException;
    void grazinti() throws PublicationIssuedException;
}

// Išplėstinis interface
interface Pratesimas extends Isduodamas{
    void pratesti(int days) throws PublicationIssuedException;
    void pratesti() throws PublicationIssuedException;
}
