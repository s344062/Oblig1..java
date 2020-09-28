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
            {throw new UnsupportedOperationException("Tabellen er tom!");}

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

        for (int i=1;i<a.length;++i){
            if (a[i-1]>a[i]){
                bytt(a, i-1, i);
                antallOmbyttinger++;
            }
        }
        return antallOmbyttinger;
    }

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
        throw new UnsupportedOperationException();
            if (a.length==0) {
                return 0;
            }

        int antallSortert= 1;
        for (int i=1; i<a.length; ++i){
            if (a[i-1]>a[i]){
                bytt(a, i-1, i);
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

        int left =0,  right=a.length - 1;
        while (left<right){
            while (a[left]%2 == 0 && left<right)
                left++;
            while (a[right]% 2 ==1 && left>right)
                right--;
            if (left<right){
                int temp = a[left];
                a[left]= a[right];
                a[right]= temp;
                left++;
                right--;
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

        char [] c= s.toCharArray();
        char [] d= t.toCharArray();
        char [] flett= new char [c.length + d.length];

        int k= Math.min(c.length, d.length);

        for (int i=0, j=0; i<k; ++i){
            flett[j++]= c[i];
            flett[j++]= d[i];
        }

        System.arraycopy(c, k, flett, 2*k, c.length - k);
        System.arraycopy(d, k, flett, 2*k, c.length - k);
        return String.valueOf(flett);
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
