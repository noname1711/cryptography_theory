import java.util.*;
import java.math.BigInteger;

class euclide {
    final static BigInteger ONE = BigInteger.ONE;
    final static BigInteger ZERO = BigInteger.ZERO;
    public static BigInteger getNextPrime(String ans){
        BigInteger test = new BigInteger(ans);
        while (!test.isProbablePrime(99)) {
            test = test.add(ONE);
        }
        return test;
    }
    public static BigInteger findQ(BigInteger n){
        BigInteger start = BigInteger.valueOf(2);
        while ( !n.isProbablePrime(99)){
            while(!(n.mod(start).equals(ZERO))){
                start = start.add(ONE);
            }
            n = n.divide(start);
        }
        return n;
    }
    public static BigInteger getGen(BigInteger p, BigInteger q, Random r){
        BigInteger h = new BigInteger(p.bitLength(), r);
        h = h.mod(p);
        return h.modPow(p.subtract(ONE).divide(q),p);
    }
    public static void main(String[] args) throws java.lang.Exception {
        Random randObj = new Random();
        BigInteger p = getNextPrime("10600");  //approximate prime
        BigInteger q = findQ(p. subtract(ONE));
        BigInteger g = getGen(p, q, randObj);
        System.out.println("\nSimulation of Digital Signature Algorithm\n");
        System.out.println("\nGlobal public key components are:\n");
        System.out.println("\nP = " + p);
        System.out.println("\nQ = " + q);
        System.out.println("\nG = " + g);
        BigInteger x =new BigInteger(q.bitLength(), randObj);
        x =x.mod(q);
        BigInteger y = g.modPow(x, p);
        BigInteger k = new BigInteger(q.bitLength(), randObj);
        k = k.mod(q);
        BigInteger r = g.modPow(k, p).mod(q);
        BigInteger hashVal = new BigInteger(p.bitLength(), randObj);
        BigInteger kInv = k.modInverse(q);
        BigInteger s = kInv.multiply(hashVal.add(x.multiply(r)));
        s =s.mod(q);
        System.out.println("\nSecret information: ");
        System.out.println("\nX (private) is: "+ x);
        System.out.println("\nK (secret) is: "+ k);
        System.out.println("\nY (public) is: "+ y);
        System.out.println("\nH (rndhash) is: "+ hashVal);
        System.out.println("\nGenerating digital signature: ");
        System.out.println("\nR is: "+ r);
        System.out.println("\nS is: "+ s);
        BigInteger w = s.modInverse(q);
        BigInteger u1 = hashVal.multiply(w).mod(q);
        BigInteger u2 = r.multiply(w).mod(q);
        BigInteger v = g.modPow(u1, p).multiply(y.modPow(u2, p));
        v = v.mod(p).mod(q);
        System.out.println("\nVerifying digital signature (checkpoints): ");
        System.out.println("\nW is : "+w);
        System.out.println("\nU1 is: "+ u1);
        System.out.println("\nU2 is: "+ u2);
        System.out.println("\nV is: "+ v);
        if(v.equals(r)){
            System.out.println("\nSuccess: Digital signature is verified!");
        }else {
            System.out.println("\nError: Incorrect digital signature!");
        }
    }
}
