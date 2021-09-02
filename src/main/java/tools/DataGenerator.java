package tools;

import org.apache.commons.text.RandomStringGenerator;

import java.util.Random;

public class DataGenerator {
  public static String generateString(int length) {
    char [][] pairs = {{'A', 'Z'}, {'a','z'}, {'0','9'}};
    RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange(pairs).build();
    return generator.generate(length);
  }

  public static Boolean generateBoolean() {
    return new Random().nextBoolean();
  }
}