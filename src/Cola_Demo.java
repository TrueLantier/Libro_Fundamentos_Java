class Cola {
    char q[];
    int colocar_lugar, obtener_lugar;
    Cola( int dimen) {
        q = new char[dimen+1];
        colocar_lugar = obtener_lugar = 0;
    }
    void colocar( char ch) {
        if (colocar_lugar == q.length-1 ) {
            System.out.println(" -- La cola se ha llenado.");
            return;
        }
        colocar_lugar++;
        q[colocar_lugar] = ch;
    }
}

public class Cola_Demo {

}
