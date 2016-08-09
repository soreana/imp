package org.sinsing.os.applications.md5generator;

import org.sinsing.os.applications.Application;

import java.security.*;
import java.math.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by sosin-PC on 8/8/2016.
 */
public class MD5Generator implements Application {

    private static HashMap<String, String> texts;
    private static ArrayList<String> needToCalculateMD5;
    private MessageDigest messageDigest;

    private static MD5Generator md5Generator;

    public static MD5Generator getInstance() {
        if (md5Generator == null)
            md5Generator = new MD5Generator();
        return md5Generator;
    }

    private MD5Generator() {
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            texts = new HashMap<>();
            needToCalculateMD5 = new ArrayList<>();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static String putString(String input) {
        if (texts.get(input) != null)
            return getResult(input);
        texts.put(input, "Not Calculated.");
        needToCalculateMD5.add(input);
        return null;
    }

    public static String getResult(String key) {
        String temp = texts.get(key);
        if ("Not Calculated.".equals(temp))
            throw new RuntimeException("result was not calculated.");
        return temp;
    }

    private void calculateOneMD5() {
        int index = ThreadLocalRandom.current().nextInt(needToCalculateMD5.size());
        String key = needToCalculateMD5.get(index);
        messageDigest.update(key.getBytes(), 0, key.length());
        texts.put(key, new BigInteger(1, messageDigest.digest()).toString(16));
        needToCalculateMD5.remove(index);
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (needToCalculateMD5.isEmpty())
                    Thread.sleep(100);
                else
                    calculateOneMD5();
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
