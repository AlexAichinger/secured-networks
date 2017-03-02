import java.io.*;

public class Crypto {
  public static void main(String[] args) {
    int[] samplePlainText = new int[64];
    int[] sampleKey = new int[64];

  }

  public int[] DES(int[] plaintext, int[] key) {
    int[] encryptedText = new int[64];
    int[] tmpEncryptionSwapArray = new int[64];
    int[] initialKeyPermutation = new int[56];
    int[] permutatedKey = new int[56];
    int[] keyC0 = new int[28];
    int[] keyD0 = new int[28];
    int[] numberOfRotaionsForKey = new int[] {1,1,2,2,2,2,2,2,1,2,2,2,2,2,2,1};

    if (plaintext.length != 64 || key.length != 64) {
      //TODO: implement something to return if wrong size 
    } else {
      tmpEncryptionSwapArray = intialPermutation(plaintext);
      permutatedKey = permutateKey(reduceKeyto54(key));
      
      //split key into two pieces
      for(int i = 0; i < 56; i++){
        if( i < 28){
          keyC0[i] = permutatedKey[i];
        } else {
          keyD0[i] = permutatedKey[i];
        }
      }
      
      // switch(){

      // }

    }
    return encryptedText;

  }

  public int[] intialPermutation(int[] start) {
    int[] permutateInitial = new int[64];
    int counter = 0;

    for (int i = 58; i > 0; i -= 8) {
      permutateInitial[counter] = start[i];
      counter++;
    }
    for (int i = 60; i > 0; i -= 8) {
      permutateInitial[counter] = start[i];
      counter++;
    }
    for (int i = 62; i > 0; i -= 8) {
      permutateInitial[counter] = start[i];
      counter++;
    }
    for (int i = 64; i > 0; i -= 8) {
      permutateInitial[counter] = start[i];
      counter++;
    }
    for (int i = 57; i > 0; i -= 8) {
      permutateInitial[counter] = start[i];
      counter++;
    }
    for (int i = 59; i > 0; i -= 8) {
      permutateInitial[counter] = start[i];
      counter++;
    }
    for (int i = 61; i > 0; i -= 8) {
      permutateInitial[counter] = start[i];
      counter++;
    }
    for (int i = 63; i > 0; i -= 8) {
      permutateInitial[counter] = start[i];
      counter++;
    }

    return permutateInitial;
  }

  public int[] finalPermutation(int[] inProcess) {
    int[] permutatedFinal = new int[64];
    int counter = 0;

    for (int i = 58; i > 0; i -= 8) {
      permutatedFinal[i] = inProcess[counter];
      counter++;
    }
    for (int i = 60; i > 0; i -= 8) {
      permutatedFinal[i] = inProcess[counter];
      counter++;
    }
    for (int i = 62; i > 0; i -= 8) {
      permutatedFinal[i] = inProcess[counter];
      counter++;
    }
    for (int i = 64; i > 0; i -= 8) {
      permutatedFinal[i] = inProcess[counter];
      counter++;
    }
    for (int i = 57; i > 0; i -= 8) {
      permutatedFinal[i] = inProcess[counter];
      counter++;
    }
    for (int i = 59; i > 0; i -= 8) {
      permutatedFinal[i] = inProcess[counter];
      counter++;
    }
    for (int i = 61; i > 0; i -= 8) {
      permutatedFinal[i] = inProcess[counter];
      counter++;
    }
    for (int i = 63; i > 0; i -= 8) {
      permutatedFinal[i] = inProcess[counter];
      counter++;
    }

    return permutatedFinal;
  }

  public int[] reduceKeyto54(int[] initialKey) {
    int[] reducedSizeKey = new int[56];

    //Reduce 64 bit key to 56 bit, no (8, 16, ..., 64) bit
    reducedSizeKey[0] = initialKey[0];
    for (int i = 1; i < 64; i++) {
      if (!((i % 8) == 0)) {
        reducedSizeKey[i] = initialKey[i];
      }
    }

    return reducedSizeKey;
  }

  public int[] permutateKey(int[] key) {
    int[] permutatedKey = new int[56];
    int counter = 0;

    for (int i = 57; i > 0; i -= 8) {
      permutatedKey[counter] = key[i];
    }
    for (int i = 58; i > 0; i -= 8) {
      permutatedKey[counter] = key[i];
    }
    for (int i = 59; i > 0; i -= 8) {
      permutatedKey[counter] = key[i];
    }
    //Will not go all the way to zero, picked up again later
    for (int i = 60; i > 35; i -= 8) {
      permutatedKey[counter] = key[i];
    }
    for (int i = 63; i > 0; i -= 8) {
      permutatedKey[counter] = key[i];
    }
    for (int i = 62; i > 0; i -= 8) {
      permutatedKey[counter] = key[i];
    }
    for (int i = 61; i > 0; i -= 8) {
      permutatedKey[counter] = key[i];
    }
    //pick up from loop that didnt go to zero
    for (int i = 28; i > 0; i -= 8) {
      permutatedKey[counter] = key[i];
    }

    return permutatedKey;
  }

  public int[] leftShiftKey(int[] key, int numberOfRotations){
    int[] tempKey = new int[28];


    return tempKey;
  }


}