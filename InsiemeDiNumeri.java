/**
 * Rappresenta la gestione di un insieme di numeri dove:
 *  - L'ordine non è significativo
 *  - Non possono esserci numeri doppi
 * @author Greta Brugnatti
 */
public class InsiemeDiNumeri {
    private int [] array;
    private int nNum;

    /**
     * Crea un array di dimensione 10 vuoto
     */
    public InsiemeDiNumeri(){
        array = new int[10];
        nNum = 0;
    }

    /**
     * Crea un array di dimensione data vuoto
     * @param dim Numero intero che indica la dimensione, cioè il numero di numeri nell'insieme
     */
    public InsiemeDiNumeri(int dim){
        array = new int [dim];
        nNum = 0;
    }

    /**
     * Aggiunge un numero intero all'insieme di numeri
     * @param n Numero intero da aggiungere
     * @throws Exception Il numero è già stato inserito in precedenza
     */
    public void add(int n) {
        int [] temp;
        int i;

        //controllo che non ci sia già
        for(int k = 0; k< array.length; k++){
            if(array[k] == n){
                System.out.println("Il numero inserito è già presente nell'insieme");
                return;
            }
        }
        if(nNum >= array.length){
            temp = new int[array.length + 10];
            for(i=0; i<array.length; i++){
                temp[i] = array[i];
            }
            temp[i]=n;
            array = temp;
        } else {
            array[nNum] = n;
        }
        nNum++;
    }

    /**
     * Rimuove un numero intero dato
     * @param n Numero intero da eliminare
     */
    public void remove(int n){
        int i;
        for (i=0; i<array.length; i++){
            if(array[i] == n){
                for(int l = i + 1; l<array.length; l++){
                    array[i] = array[l];
                    i++;
                }
                nNum--;
                return;
            }
        }
    }

    /**
     * Controlla se contiene un numero o no
     * @param n Numero intero da controllare
     * @return   posizione - se n è contenuto nell'insieme
     *           -1 - se n non è contenuto nell'insieme
     */
    public int contains (int n){
        for(int i = 0; i < array.length; i++){
            if(n == array[i]){
                return i;
            }
        }
        return -1;
    }

    /**
     * Returna la dimensione dell'insieme
     * @return Dimensione array
     */
    public int size (){
        return array.length;
    }

    /**
     * Svuota l'array
     */
    public void clear (){
        array = null;
        nNum = 0;
    }


    /**
     * Controlla se un insieme di numeri è contenuto in un altro
     * @param idn Insieme di numeri
     * @return     true - se lo contiene
     *             false - se non lo contiene
     */
    public boolean containsAll(InsiemeDiNumeri idn){

        for (int i=0; i<idn.size(); i++){
            if(contains(idn.array[i])!=-1){

            }else{
                return false;
            }
        }
        return true;
    }

    /**
     * Controlla se l'insieme di numeri è vuoto
     * @return true - se è vuoto
     *         false - se non è vuoto
     */
    public boolean isEmpty (){
        if(nNum == 0){
            return true;
        }
        return false;
    }

    /**
     * Aggiunge i numeri di un insieme nel insieme corrente
     * @param idn Insieme di numeri interi da aggiungere
     */
    public void addAll(InsiemeDiNumeri idn){
        for(int i=0; i< idn.nNum; i++){
            add(idn.array[i]);
        }
    }

    /**
     * Rimuove i numeri di un insieme nel insieme corrente
     * @param idn Insieme di numeri interi da rimuovere
     */
    public void removeAll(InsiemeDiNumeri idn){
        for(int i=0; i< idn.nNum; i++){
            remove(idn.array[i]);
        }
    }

    /**
     * Mantiene tutti i numeri all'interno dell'insieme dato
     * @param idn Insieme di numeri da mantenere
     */
    public void retainAll(InsiemeDiNumeri idn){
        int [] temp;
        int k=0;
        int cont;
        temp = new int[idn.nNum];
        for(int i=0; i<idn.nNum; i++){
            cont = contains(idn.array[i]);
            if(cont != -1){
                temp[k] = array[cont];
                k++;
            }
        }
        if(k > 0){
            array = temp;
            nNum = k;
        }

    }

    /**
     * Returna l'insieme in forma di array
     * @return Insieme di numeri in un array
     */
    public int [] toArray (){
        return array;
    }

}
