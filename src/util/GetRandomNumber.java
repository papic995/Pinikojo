package util;

import java.util.Random;

/**
 * Created by Johnny on 2/19/2017.
 */
public class GetRandomNumber {

    public static int RandomNumber(int range){
        Random random = new Random();
        return random.nextInt(range) + 1;
    }
}
