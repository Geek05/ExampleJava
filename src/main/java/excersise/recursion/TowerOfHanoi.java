package excersise.recursion;

/**
 * @author Bharath.MC
 * @since Nov-2020
 */
public class TowerOfHanoi {


    public static void tower(int numberOfDiscs, int sourcePeg, int destPeg, int sparePeg){
        if(numberOfDiscs==1){
            System.out.println(sourcePeg +" ==> "+ intToChar(destPeg));
        } else {
            tower(numberOfDiscs-1, sourcePeg, sparePeg, destPeg);
            System.out.println(sourcePeg +" ==> "+ intToChar(destPeg));
            tower(numberOfDiscs-1, sparePeg, destPeg, sourcePeg);
        }
    }

    public static String intToChar(int charNumber){
        if(charNumber==1)
            return "A";
        else if(charNumber==2)
            return "B";
        else if(charNumber==3)
            return "C";
        return "unknown";
    }

    /**
     * A B C is in pole 1, we need to move to pole 3 (destination)
     *
     * Move A to Pole 3 [pole1=BC, pole2=null, pole3=A]
     * Move B to pole 2 [pole1=C, pole2=B, pole3=A]
     * Move A to pole 2 [pole1=C, pole2=AB, pole3=null]
     * Move C to pole 3 [pole1=null, pole2=AB, pole3=C]
     * Move A to pole 1 [pole1=A, pole2=B, pole3=C]
     * Move B to pole 3 [pole1=A, pole2=null, pole3=BC]
     * Move A to pole 3 [pole1=null, pole2=null, pole3=ABC]
     */
    public static void tower(int numberOfDiscs, String sourcePeg, String destPeg, String sparePeg){
        if(numberOfDiscs==1){
            System.out.println(sourcePeg +" ==> "+ destPeg);
        } else {
            tower(numberOfDiscs-1, sourcePeg, sparePeg, destPeg);
            System.out.println(sourcePeg +" ==> "+ destPeg);
            tower(numberOfDiscs-1, sparePeg, destPeg, sourcePeg);
        }
    }


    public static void main(String[] args) {
        //tower(3,"A","C","B");
        tower(3,1,3,2);
    }
}
