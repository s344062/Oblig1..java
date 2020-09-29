package no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 ////////////////////////

import java.lang.UnsupportedOperationException;
import java.util.NoSuchElementException;

public class Oblig1 {
    private Oblig1() {}
    private static void bytt (int [] a, int i, int j){
        int temp = a[i];
        a[i]= a[j];
        a[j]= temp;
    }
    private static void bytt (char []a , int i, int j){
        char temp = a[i];
        a[i]= a[j];
        a[j]= temp;
    }

    ///// Oppgave 1 //////////////////////////////////////
    /* Det er flest ombyttinger når array ikke er sortert
        Det er færrest når array er sortert stignende.
        I gjennomsnitt er det H(n) -1 ombyttinger

     */
    public static int maks(int[] a) {
        if (a.length<= 0)
            {throw new NoSuchElementException("Tabellen er tom!");}

        for (int i=1; i<a.length; i++){ // bruker for-løkke for å finne antall sammenligner
            if (a[i-1]> a[i]){
                bytt(a, i-1, i);
            }
        }
        return a[a.length-1];
    }

    public static int ombyttinger(int[] a) {
        //throw new UnsupportedOperationException();
        if (a.length<1){throw new NoSuchElementException("Tom tabell!");}

        int antallOmbyttinger= 0; //hvis ingen ombyttinger skjer antar jeg at det er 0 ombyttinger


        for (int i=1;i<a.length; i++){ // bruker for-løkke for å finne antall ombyttinger
            if (a[i-1]>a[i]){
                bytt(a, i-1, i);
                antallOmbyttinger++;
            }
        }
        return antallOmbyttinger;
    }

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
        //throw new UnsupportedOperationException();
        int antallSortert = 1;  // minste antall hvis a ikke er sortert
        if (a.length==0){
            return 0;
        }
        for (int i=0; i<a.length-1; i++){
            if (a[i]> a[i+1]){
                throw new IllegalStateException("Ikke sortert i stigende rekkefølge");
            }
            else if (a[i] != a[i+1]){
                antallSortert++;
            }
        }

        return antallSortert;
    }

    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        //throw new UnsupportedOperationException();

            if (a.length<2)
                return a.length;

        int antallUlike= 1; // teller starter med 1

        for (int i=1;i<a.length;++i){ // finner antall ulike med for-løkke
            int j=0;
            for (int j=0; j<i;++j){
                int verdi=a[i];
                if (a[j]==verdi) break;
            }
            if (j==i) antallUlike++;
        }
        return antallUlike;
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {
        //throw new UnsupportedOperationException();
        int lengde = a.length;
        int left = 0, right = lengde - 1;

        if (a.length == 0)
            return;
        while (left <= right) { // bruker while-løkke for å dele i to sorterte deler
            if ((a[left] % 2 == 0) && !((a[right] % 2) == 0))
                bytt(a, right++, left--);
            else if ((a[left]) % 2 == 0) {
                right--;
            } else if (!((a[right]) == 0)) {
                left++;
            } else if (!((a[left] % 2) == 0) && ((a[right] % 2) == 0)) {
                right++;
                left--;
            }
        }
    }
    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        //throw new UnsupportedOperationException();
        if (a.length> 1){
           char temp = a[a.length - 1 ];

            for (int i=a.length-1;i>0; --i){
                a[i]= a[i-1];
            }
            a[0]= temp;
        }
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        //throw new UnsupportedOperationException();
        if (s.isEmpty() && t.isEmpty())
            return "";

        String[] sSplit = s.split("");
        String[] tSplit = t.split("");
        String resultat = "";


        for (int i = 0; ; i++) {
            if (tSplit.length > i || sSplit.length > i) {
                if (sSplit.length > i)
                    resultat += sSplit[i];
                if (tSplit.length > i)
                    resultat += tSplit[i];
            } else {
                return resultat;
            }
        }

    }
    /// 7b)

    public static String flett(String... s) {
        //throw new UnsupportedOperationException();

        String resultat = "";
        boolean done = false;

        for (int i = 0; !done; i++) {
            done = true;

            for (int j = 0; j < s.length; j++) {
                String[] charet = s[j].split("");
                if (charet.length > i) {
                    done = false;
                    resultat += charet[i];
                }
            }
        }
        return resultat;
    }
        return
    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new UnsupportedOperationException();
    }

    public static boolean inneholdt(String a, String b) {
        throw new UnsupportedOperationException();
    }

}  // Oblig1
