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
        if (a.length<1)
            {throw new NoSuchElementException("Tabellen er tom!");}

        for (int i=1; i<a.length; i++){
            if (a[i-1]> a[i]){
                bytt(a, i-1, i);
            }
        }
        return a[a.length-1];
    }

    public static int ombyttinger(int[] a) {
        //throw new UnsupportedOperationException();
        if (a.length<1){throw new NoSuchElementException("Tom tabell!");}

        int antallOmbyttinger= 0;

        for (int i=1;i<a.length; i++){
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
        int antallSortert = 1;
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

        int antallUlike= 1;

        for (int i=1;i<a.length;++i){
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
        while (left <= right) {
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
        delsortering(a, 0, left);
        delsortering(a, left, lengde);
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


        char [] c= s.toCharArray();
        char [] d= t.toCharArray();
        int lengde= c.length+ d.length;

        StringBuilder sb= new StringBuilder();
        for (int i=0; j<lengde; ++i){
            if (c.length< i){
                sb.append(c[i]);
            }
            if (d.length<i){
                sb.append(d[i]);
            }
        }

        return sb.toString();
    }

    /// 7b)
    public static String flett(String... s) {
        //throw new UnsupportedOperationException();
        if (s.length==0)
            return "";
        int k= s[0].length();

        for (int i= 1; i<s.length; ++i){
            int stringlength= s[i].length();
            if (stringlength> k)
                k=stringlength;
        }

        StringBuilder stringBuilder= new StringBuilder ();

        for (int i= 0; i<k; i++){
            for (String t:s){
                if (i<t.length()) stringBuilder.append(t.charAt(i));
            }
        }
        return stringBuilder.toString();
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
