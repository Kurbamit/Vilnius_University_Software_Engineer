package Biblioteka;

// Pagrindinis interface
interface Isduodamas{
    boolean isduoti() throws PublicationIssuedException;
    boolean grazinti() throws PublicationIssuedException;
}

// Išplėstinis interface
interface Pratesimas extends Isduodamas{
    boolean pratesti(int days) throws PublicationIssuedException;
    boolean pratesti() throws PublicationIssuedException;
}
