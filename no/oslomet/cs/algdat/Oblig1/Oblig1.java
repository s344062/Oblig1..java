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

        for( int i=0; i<a.length-1; i++){
            if (a[i] > a[i+1]){

                int temp = a[i];
                a[i] = a[i+1];
                a[i+1]= temp;
            }
        }
        int aMaks= a[a.length-1];
        return aMaks;
    }

    public static int ombyttinger(int[] a) {
        //throw new UnsupportedOperationException();
        if (a.length==0){throw new NoSuchElementException("Tom tabell!");}

        int antallOmbyttinger= 0; //hvis ingen ombyttinger skjer antar jeg at det er 0 ombyttinger


        for (int j=0;j<a.length; j++){ // bruker for-løkke for å finne antall ombyttinger
            if (j+1 != a.length){
                if (a[j] > a[j+1]){
                    antallOmbyttinger++;

                    int temp= a[j]; // kode fra undervisning
                    a[j] = a[j+1];
                    a[j+1]= temp;
                }
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
    public static int partisjonering (int a [], int v, int h){
        int skilleverdi = a[h];
        int i = (v-1);
        for (int j= v; j<h; j++){
            //Taller er mindre enn skilleverdi
            if (a[j] < skilleverdi){
                i++;

                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int temp = a [i+1];
        a[i+1]= a[h];
        a[h]= temp;
        return i+1;
    }

    public static void partisjoneringen(int []a, int v, int h){
        if (v >= h) return;  // bruker if setning for å finne om det er tomt
        int k = partisjonering(a, v, h);
        partisjoneringen(a, v, k - 1);     // sorterer a[v:k-1]
        partisjoneringen(a, k + 1, h);     // sorterer a[k+1:h]
    }
    public static void delsortering(int[] a){
        int oddetall = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i] % 2 != 0){
                bytt(a,i,oddetall);
                oddetall++;
            }
        }
        partisjoneringen(a,0,oddetall-1);
        partisjoneringen(a,oddetall,a.length-1);
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
