package Biblioteka;

// Pagrindinis interface
interface Isduodamas{
    void isduoti() throws LibraryException;
    void grazinti() throws LibraryException;
}

// Išplėstinis interface
interface Pratesimas extends Isduodamas{
    void pratesti(int days) throws LibraryException;
    void pratesti() throws LibraryException;
}
