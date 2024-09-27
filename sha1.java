import java.security.*;

public class sha1 {
    public static void main(String[] args) {
        try{
            MessageDigest md = MessageDigest.getInstance ("SHA-1");
            System.out.println("Message digest object info: ");
            System.out.println("Algorithm = "+ md.getAlgorithm());
            System.out.println("Provider = "+ md.getProvider());
            System.out.println("ToString = "+ md.toString());
            String input ="";
            byte[] output = calculateDigest(md, input);
            System.out.println("\nSHA1(\""+ input +"\") =" + bytesToHex(output));
            input = "abc";
            output = calculateDigest(md, input);
            System.out.println("\nSHA1(\""+ input +"\") =" + bytesToHex(output));
            input = "abcdefghijklmnopqrstuvwxyz";
            output = calculateDigest(md, input);
            System.out.println("\nSHA1(\""+ input + "\") =" + bytesToHex(output));
            System.out.println("");
        } catch (Exception e){
            System.out.println("Exception: "+e);
        }
    }
    public static byte[] calculateDigest(MessageDigest md, String input){
        md.update(input.getBytes());
        return md.digest();
    }
    public static String bytesToHex(byte[] bytes){
        char[] hexChars = new char[bytes.length *2];
        for (int j = 0; j < bytes.length; j++){
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = Character.forDigit(v >>> 4, 16);
            hexChars[j * 2 + 1] = Character.forDigit(v & 0x0F, 16);
        }
        return new String(hexChars);
    }
}
