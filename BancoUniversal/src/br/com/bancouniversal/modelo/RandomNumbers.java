package br.com.bancouniversal.modelo;
import java.util.Random;

public class RandomNumbers {
	public static int generateRandomNumber(int maxDigits) {
        Random random = new Random();
        int maxNumber = (int) Math.pow(10, maxDigits);
        return random.nextInt(maxNumber);
    }
}
