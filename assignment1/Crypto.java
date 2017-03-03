package assignment1;

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

    if (plaintext.length != 64 || key.length != 64) {
      //TODO: implement something to return if wrong size 
    } else {
      tmpEncryptionSwapArray = intialPermutationPlaintext(plaintext);
      permutatedKey = permutateKey(keyCompressionTo56Bits(key));
      int keyCreateCounter = 1;
      int[] keyC0 = new int[28];
      int[] tmpKeyC0 = new int[28];
      int[] keyD0 = new int[28];
      int[] tmpKeyD0 = new int[28];
      int[][] keysGenerated = new int[16][48];
      int[] leftPlaintext = new int[]

      //split key into two pieces
      for (int i = 0; i < 56; i++) {
        if (i < 28) {
          keyC0[i] = permutatedKey[i];
        } else {
          keyD0[i] = permutatedKey[i];
        }
      }

      for(int i = 1; i < 17; i++) {
        switch (i) {
        case 1:
          keyC0 = leftShiftKeyOnce(keyC0);
          keyD0 = leftShiftKeyOnce(keyD0);
          break;
        case 2:
          keyC0 = leftShiftKeyOnce(keyC0);
          keyD0 = leftShiftKeyOnce(keyD0);
          break;
        case 3:
          keyC0 = leftShiftKeyTwice(keyC0);
          keyD0 = leftShiftKeyTwice(keyD0);
          break;
        case 4:
          keyC0 = leftShiftKeyTwice(keyC0);
          keyD0 = leftShiftKeyTwice(keyD0);
          break;
        case 5:
          keyC0 = leftShiftKeyTwice(keyC0);
          keyD0 = leftShiftKeyTwice(keyD0);
          break;
        case 6:
          keyC0 = leftShiftKeyTwice(keyC0);
          keyD0 = leftShiftKeyTwice(keyD0);
          break;
        case 7:
          keyC0 = leftShiftKeyTwice(keyC0);
          keyD0 = leftShiftKeyTwice(keyD0);
          break;
        case 8:
          keyC0 = leftShiftKeyTwice(keyC0);
          keyD0 = leftShiftKeyTwice(keyD0);
          break;
        case 9:
          keyC0 = leftShiftKeyOnce(keyC0);
          keyD0 = leftShiftKeyOnce(keyD0);
          break;
        case 10:
          keyC0 = leftShiftKeyTwice(keyC0);
          keyD0 = leftShiftKeyTwice(keyD0);
          break;
        case 11:
          keyC0 = leftShiftKeyTwice(keyC0);
          keyD0 = leftShiftKeyTwice(keyD0);
          break;
        case 12:
          keyC0 = leftShiftKeyTwice(keyC0);
          keyD0 = leftShiftKeyTwice(keyD0);
          break;
        case 13:
          keyC0 = leftShiftKeyTwice(keyC0);
          keyD0 = leftShiftKeyTwice(keyD0);
          break;
        case 14:
          keyC0 = leftShiftKeyTwice(keyC0);
          keyD0 = leftShiftKeyTwice(keyD0);
          break;
        case 15:
          keyC0 = leftShiftKeyTwice(keyC0);
          keyD0 = leftShiftKeyTwice(keyD0);
          break;
        case 16:
          keyC0 = leftShiftKeyOnce(keyC0);
          keyD0 = leftShiftKeyOnce(keyD0);
          break;
        default:
          break;
        }

        tmpKeyC0 = permutateKeyC(keyC0);
        tmpKeyD0 = permutateKeyD(keyD0);

        for(int j = 0; j < 48; i++){
          keysGenerated[i-1][j] = combinePermutateKeyHalves(tmpKeyC0, tmpKeyD0);
        }


      }
    }
    return encryptedText;

  }

  public int[] intialPermutationPlaintext(int[] start) {
    int[] permutateInitial = new int[64];
    int counter = 0;

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
    for (int i = 56; i > 0; i -= 8) {
      permutateInitial[counter] = start[i];
      counter++;
    }
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

    return permutateInitial;
  }

  public int[] finalPermutationPlaintext(int[] inProcess) {
    int[] permutatedFinal = new int[64];
    int counter = 0;

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
    for (int i = 56; i > 0; i -= 8) {
      permutatedFinal[i] = inProcess[counter];
      counter++;
    }
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

    return permutatedFinal;
  }

  public int[] keyCompressionTo56Bits(int[] initialKey) {
    int[] reducedSizeKey = new int[56];

    //Reduce 64 bit key to 56 bit, no (8, 16, ..., 64) bit
    reducedSizeKey[0] = initialKey[0];
    for (int i = 1; i < 63; i++) {
      if (!((i % 8) == 0)) {
        reducedSizeKey[i] = initialKey[i];
      }
    }

    return reducedSizeKey;
  }

  public int[] permutateKey(int[] key) {
    int[] permutatedKey = new int[56];
    int counter = 0;

    for (int i = 56; i > 0; i -= 8) {
      permutatedKey[counter] = key[i];
    }

    for (int i = 57; i > 0; i -= 8) {
      permutatedKey[counter] = key[i];
    }

    for (int i = 58; i > 0; i -= 8) {
      permutatedKey[counter] = key[i];
    }

    //Will not go all the way to zero, picked up again later
    for (int i = 59; i > 35; i -= 8) {
      permutatedKey[counter] = key[i];
    }

    for (int i = 62; i > 0; i -= 8) {
      permutatedKey[counter] = key[i];
    }

    for (int i = 61; i > 0; i -= 8) {
      permutatedKey[counter] = key[i];
    }

    for (int i = 60; i > 0; i -= 8) {
      permutatedKey[counter] = key[i];
    }

    //pick up from loop that didnt go to zero
    for (int i = 28; i > 0; i -= 8) {
      permutatedKey[counter] = key[i];
    }

    return permutatedKey;
  }

  public int[] leftShiftKeyOnce(int[] key) {
    int[] tempKey = new int[28];

    tempKey[27] = key[0];
    for (int i = 1; i < 27; i++) {
      tempKey[i - 1] = key[i];
    }

    return tempKey;
  }

  public int[] leftShiftKeyTwice(int[] key) {
    int[] tempKey = new int[28];

    tempKey[26] = key[0];
    tempKey[27] = key[1];
    for (int i = 2; i < 26; i++) {
      tempKey[i - 2] = key[i];
    }

    return tempKey;
  }

  public int[] permutateKeyC(int[] key) {
    int[] tmpKeyC0 = new int[24];

    tmpKeyC0[0] = key[13];
    tmpKeyC0[1] = key[16];
    tmpKeyC0[2] = key[10];
    tmpKeyC0[3] = key[23];
    tmpKeyC0[4] = key[0];
    tmpKeyC0[5] = key[4];
    tmpKeyC0[6] = key[2];
    tmpKeyC0[7] = key[27];
    tmpKeyC0[8] = key[14];
    tmpKeyC0[9] = key[5];
    tmpKeyC0[10] = key[20];
    tmpKeyC0[11] = key[9];
    tmpKeyC0[12] = key[22];
    tmpKeyC0[13] = key[18];
    tmpKeyC0[14] = key[11];
    tmpKeyC0[15] = key[3];
    tmpKeyC0[16] = key[25];
    tmpKeyC0[17] = key[7];
    tmpKeyC0[18] = key[15];
    tmpKeyC0[19] = key[6];
    tmpKeyC0[20] = key[26];
    tmpKeyC0[21] = key[19];
    tmpKeyC0[22] = key[12];
    tmpKeyC0[23] = key[1];

    return tmpKeyC0;
  }

  public int[] permutateKeyD(int[] key) {
    int[] tmpKeyD = new int[24];

    tmpKeyD[0] = key[40];
    tmpKeyD[1] = key[51];
    tmpKeyD[2] = key[30];
    tmpKeyD[3] = key[36];
    tmpKeyD[4] = key[46];
    tmpKeyD[5] = key[54];
    tmpKeyD[6] = key[29];
    tmpKeyD[7] = key[39];
    tmpKeyD[8] = key[50];
    tmpKeyD[9] = key[44];
    tmpKeyD[10] = key[32];
    tmpKeyD[11] = key[47];
    tmpKeyD[12] = key[43];
    tmpKeyD[13] = key[48];
    tmpKeyD[14] = key[38];
    tmpKeyD[15] = key[55];
    tmpKeyD[16] = key[33];
    tmpKeyD[17] = key[52];
    tmpKeyD[18] = key[45];
    tmpKeyD[19] = key[41];
    tmpKeyD[20] = key[49];
    tmpKeyD[21] = key[35];
    tmpKeyD[22] = key[28];
    tmpKeyD[23] = key[31];

    return tmpKeyD;
  }

  public int[] combinePermutateKeyHalves(int[] keyC, int[] keyD) {
    int[] generatedKey = new int[48];

    for (int i = 0; i < 48; i++) {
      generatedKey[i] = keyC[i];
      generatedKey[28 + i] = keyD[i];
    }

    return generatedKey;
  }

//come back to this to make more efficient
  public int[] expandPlaintText(int[] plaintext) {
    int[] expandedPlaintext = new int[48];

    expandedPlaintext[0] = plaintext[31];
    expandedPlaintext[47] = plaintext[0];
    expandedPlaintext[2] = plaintext[];

    return expandedPlaintext;
  }

}