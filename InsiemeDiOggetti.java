/**
 * Rappresenta la gestione di un insieme di oggetti dove:
 *  - L'ordine non è significativo
 *  - Non possono esserci oggetti doppi
 * @author Greta Brugnatti
 */
public class InsiemeDiOggetti {
    private Object[] array;
    private int nObj;

    /**
     * Crea un array di dimensione 10 vuoto
     */
    public InsiemeDiOggetti() {
        array = new Object[10];
        nObj = 0;
    }

    /**
     * Crea un array di dimensione data vuoto
     *
     * @param dim Numero intero che indica la dimensione, cioè il numero di oggetti nell'insieme
     */
    public InsiemeDiOggetti(int dim) {
        array = new Object[dim];
        nObj = 0;
    }

    /**
     * Aggiunge un oggetto all'insieme di oggetti
     * <p>
     * Non sapendo la classe di appartenenza degli oggetti l'unico confronto che posso fare
     * è vedere se sono gli stessi identici oggetti tramite il metodo equals()
     *
     * @param obj Oggetto da aggiungere
     */
    public void add(Object obj) {
        Object[] temp;
        int i;

        //controllo che non ci sia già
        for (int k = 0; k < array.length; k++) {
            if (array[k] != null) {
                if (array[k].equals(obj)) {
                    System.out.println("L'oggetto inserito è già presente nell'insieme");
                    return;
                }
            }
        }
        if (nObj >= array.length) {
            temp = new Object[array.length + 10];
            for (i = 0; i < array.length; i++) {
                temp[i] = array[i];
            }
            temp[i] = obj;
            array = temp;
        } else {
            array[nObj] = obj;
        }
        nObj++;
    }

    /**
     * Rimuove l'oggetto dato
     *
     * @param obj Oggetto da eliminare
     */
    public void remove(Object obj) {
        int i;
        for (i = 0; i < array.length; i++) {
            if (array[i].equals(obj)) {
                for (int l = i + 1; l < array.length; l++) {
                    array[i] = array[l];
                    i++;
                }
                nObj--;
                return;
            }
        }
    }

    /**
     * Controlla se contiene un oggetto o no
     *
     * @param obj Oggetto da controllare
     * @return posizione - se obj è contenuto nell'insieme
     * -1 - se obj non è contenuto nell'insieme
     */
    public int contains(Object obj) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                if (array[i].equals(obj)) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Returna la dimensione dell'insieme
     *
     * @return Dimensione array
     */
    public int size() {
        return array.length;
    }

    /**
     * Svuota l'array
     */
    public void clear() {
        array = null;
        nObj = 0;
    }

    /**
     * Controlla se un insieme di oggetti è contenuto in un altro
     *
     * @param ido Insieme di oggetti
     * @return true - se lo contiene
     * false - se non lo contiene
     */
    public boolean containsAll(InsiemeDiOggetti ido) {

        for (int i = 0; i < ido.nObj; i++) {
            if (contains(ido.array[i]) != -1) {

            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * Controlla se l'insieme di oggetti è vuoto
     *
     * @return true - se è vuoto
     * false - se non è vuoto
     */
    public boolean isEmpty() {
        if (nObj == 0) {
            return true;
        }
        return false;
    }

    /**
     * Aggiunge gli oggetti di un insieme nel insieme corrente
     *
     * @param ido Insieme di oggetti da aggiungere
     */
    public void addAll(InsiemeDiOggetti ido) {
        for (int i = 0; i < ido.nObj; i++) {
            add(ido.array[i]);
        }
    }

    /**
     * Rimuove gli oggetti di un insieme nel insieme corrente
     *
     * @param ido Insieme di oggetti da rimuovere
     */
    public void removeAll(InsiemeDiOggetti ido) {
        for (int i = 0; i < ido.nObj; i++) {
            remove(ido.array[i]);
        }
    }

    /**
     * Mantiene tutti gli oggetti all'interno dell'insieme dato
     *
     * @param ido Insieme di oggetti da mantenere
     */
    public void retainAll(InsiemeDiOggetti ido) {
        Object[] temp;
        int k = 0;
        int cont;
        temp = new Object[ido.nObj];
        for (int i = 0; i < ido.nObj; i++) {
            cont = contains(ido.array[i]);
            if (cont != -1) {
                temp[k] = array[cont];
                k++;
            }
        }
        if (k > 0) {
            array = temp;
            nObj = k;
        }
    }



    /**
     * Returna l'insieme in forma di array
     * @return Insieme di oggetti in un array
     */
    public Object [] toArray(){
        return array;
    }
}

