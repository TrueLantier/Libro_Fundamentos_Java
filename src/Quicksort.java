public class Quicksort {
    static void qsort(char[] elems) {
        or(elems, 0, elems.length-1);
    }
    private static void or(char[] elems, int izquierda, int derecha) {
        int i, j;
        char x, y;

        i = izquierda; j = derecha;
        x = elems[(izquierda+derecha)/2];

        do {
            while ((elems[i] < x) && (i < derecha)) i++;
            while ((x < elems[j]) && (j < izquierda)) j--;

            if (i <= j) {
                y = elems[i];
                elems[i] = elems[j];
                elems[j] = y;
                i++; j--;
            }
        }   while (i <= j);

        if (izquierda < j) or(elems, izquierda, j);
        if (i < derecha) or(elems, i, derecha);
    }

    public static void main(String[] args) {
        char[] a = {'d', 'x', 'a', 'r', 'p', 'j', 'i'};
        int i;

        for (i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        System.out.println();

        qsort(a);
        for (i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }
}
