package fr.einfolearning.tp2.metiers;

public interface TextBufferInterface {
    void ins(String s, int position);

    void del(int from, int to);

    String substr(int from, int to);

    int maxP();

    String toString();
}
