class DCT {
  
//Eingangsmatrizen

private static int[][] matrixA = {{  107,  109,  115,  107,  113,  115,  115,  113},
                                  {   24,   24,   24,    8,   16,    8,   16,   20},
                                  {   16,   24,   16,   16,   24,   16,   16,   24},
                                  {   16,   28,   16,   16,   28,   16,   24,   32},
                                  {   16,   28,   24,   24,   32,   24,   24,   36},
                                  {   24,   28,   24,   24,   28,   24,   24,   28},
                                  {   16,   20,   16,   16,   28,   16,   24,   32},
                                  {    8,   12,    8,    8,    8,    8,    8,    8}};

private static int[][] matrixB = {{  123,  121, 123, 123, 125,  123, 123, 125},
                                  {   66,   65,  66,  16,  16,   16,  16,  20},  
                                  {   28,   24,  24,  32,  24,   24,  32,  24},  
                                  {   32,   24,  24,  32,  24,   24,  32,  24},  
                                  {   32,   24,  24,  36,  33,   24,  36,  33},  
                                  {   36,   33,  24,  36,  33,   24,  32,  24},
                                  {   24,   16,  16,  28,  16,   33,  44,  33},  
                                  {   16,   16,  20,  16,  16,   20,   8,  16}};

private static int[][] matrixC = {{  139,  144, 149, 153, 155,  155, 155, 155},
                                  {  144,  151, 153, 156, 159,  156, 156, 156},  
                                  {  150,  155, 160, 163, 158,  156, 156, 156},  
                                  {  159,  161, 162, 160, 160,  159, 159, 159},  
                                  {  159,  160, 161, 162, 162,  155, 155, 155},  
                                  {  161,  161, 161, 161, 160,  157, 157, 157},
                                  {  162,  162, 161, 163, 162,  157, 157, 157},  
                                  {  162,  162, 161, 161, 163,  158, 158, 158}}; 

private static int[][] matrixD = {{  197,  208, 226, 198, 209,  227, 197, 210},
                                  {  197,  208, 226, 198, 209,  227, 197, 208},  
                                  {  197,  209, 225, 199, 207,  226, 200, 208},  
                                  {  197,  208, 226, 198, 209,  227, 197, 208},  
                                  {  196,  209, 225, 199, 207,  226, 199, 208},  
                                  {  197,  209, 225, 197, 208,  226, 197, 209},
                                  {  196,  209, 225, 197, 208,  226, 197, 209},  
                                  {  197,  209, 225, 197, 208,  226, 197, 209}}; 
  
  /**Entscheidet, ob C(u) [bzw. C(v)] = (1/Wurzel2) 
    *           oder C(u) [bzw. C(v)] = 1.
    *@param u sowohl u als auch v, geben die Indizees der Inputmatrix an.
    *       können in der Schleife also die Werte 0 bis 7 annehmen.
    *@return double entweder (1/Wurzel2)
    *                   oder  1.
    */
  public static double C(int u) {
    if (u == 0) {
      return (1 / Math.sqrt(2));
    } else {
      return 1;
    }
  }
  
  /**Führt die Hauptberechnung durch (also die 2 for-Schleifen / Summenzeichen).
    *@param matrix = Inputmatrix, für die neue Werte berechnet werden sollen.
    *@param u erster Index der Inputmatrix
    *@param v zweiter Index der Inputmatrix
    *@return der Wert der in der Outputmatrix an Stelle u,v stehen wird.
    *        Das heißt hier wird nur ein einziger Wert berechnet.
    */
  public static int compute(int[][] matrix, int u, int v) {
    
    //Variable, in die das Ergebnis der for-Schleifen geschrieben wird.
    double fErg = 0;
    //Variable, in die das Gesamt-Ergebnis geschrieben wird.
    double gErg = 0;
    
    //dritte for-Schleife
    /*läuft bis < 8, da die 7 im Summenzeichen INKLUSIVE ist
      j ist der erste Index für die Ausgangsmatrix
    */
    for (int j = 0; j < 8; j++) {
      //vierte for-Schleife
      /*läuft bis < 8, da die 7 im Summenzeichen INKLUSIVE ist
      k ist der zweite Index für die Ausgangsmatrix
      */
      for (int k = 0; k < 8; k++) {
        
        /*alles das, was vorher in allen Schritten in erg stand plus das,
        was in diesem Schritt dazu kommt.*/
        fErg = fErg +
        //Zugriff auf die Eingangsmatrix: Wert an Stelle j,k herausholen
        matrix[j][k] *
        //das erste Mal den Cosinus berechnen
        Math.cos(((2 * j + 1) * u * Math.PI) / 16) *
        //das zweite Mal den Cosinus berechnen
        Math.cos(((2 * k + 1) * v * Math.PI) / 16);
        
      } 
    }
    
    //schreibe alles in Gesamtergebnis
    gErg = 
    //multipliziere alle Zwischenergebnisse aus, 
    //wobei C(u) und C(v) die oben geschriebene Methode aufrufen!
    (0.25) * C(u) * C(v) * fErg;
    
    //Gesamtergebnis in benötigten int-Wert konvertieren
    //nun das Gesamtergebnis (nur EIN Wert der Matrix) zurück geben
    return (int) Math.round(gErg);
    
  }
  
  
  
  public static void main(String[] args) {
    
    //Matrix A
    System.out.println("Matrix A: \n");    
    //erste for-Schleife 
    //u ist der erste Index der Inputmatrix
    for (int u = 0; u < 8; u++) {
      //zweite for-Schleife
      //v ist der zweite Index der Inputmatrix
      for (int v = 0; v < 8; v++) {
        //schreibt das Ergebnis auf die Konsole, hübsch formatiert
        System.out.printf("%4d", compute(matrixA, u, v));
      }
      //nur um der Form Willen
      System.out.printf("\n");
    }
    /*
    //Matrix B
    System.out.println("\nMatrix B: ");
    for (int u = 0; u < 8; u++) {
      for (int v = 0; v < 8; v++) {
        System.out.printf("%4d", compute(matrixB, u, v));
      }
      System.out.printf("\n");
    }
    
    //Matrix C
    System.out.println("\nMatrix C: ");
    for (int u = 0; u < 8; u++) {
      for (int v = 0; v < 8; v++) {
        System.out.printf("%4d", compute(matrixC, u, v));
      }
      System.out.printf("\n");
    }
    
    //Matrix D
    System.out.println("\nMatrix D: ");
    for (int u = 0; u < 8; u++) {
      for (int v = 0; v < 8; v++) {
        System.out.printf("%4d", compute(matrixD, u, v));
      }
      System.out.printf("\n");
    }
    */
  }
}
