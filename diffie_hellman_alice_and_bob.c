#include<stdio.h>
#include<math.h>

int main(){
    int p = 23;  //public known (prime number)
    int g =5;    //public known (primitive root)
    int x =4;  //only Alice know
    int y =3; //only Bob know
    double aliceSend = fmod(pow(g,x), p);
    double bobComputer = fmod(pow(aliceSend, y), p);
    double bobSend = fmod(pow(g,y), p);
    double aliceComputer = fmod(pow(bobSend,x), p);
    double sharedSecret = fmod(pow(g, x*y), p);

    printf("Simulation of Diffie- Hellman key exchange algorithm \n");
    printf("-----------------------------------------------------\n");
    printf("Alice sends: %.0f\n", aliceSend);
    printf("Bob computes: %.0f\n", bobComputer);
    printf("Bob sends: %.0f\n", bobSend);
    printf("Alice computes: %.0f\n", aliceComputer);
    printf("Shared secret: %.0f\n", sharedSecret);

    //shared secret should match and equality is transitive
    if(aliceComputer == sharedSecret && aliceComputer == bobComputer){
        printf("Success: Shared secret matches %.0f\n", sharedSecret);
    }else {
        printf("Error: Shared secret does not match\n");
    }
    return 0;
}