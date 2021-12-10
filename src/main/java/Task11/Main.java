package Task11;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter seed: ");
        long seed = Long.parseLong(scanner.nextLine());
        Random random = new Random(seed);

        System.out.print("Enter message: ");
        String message = scanner.nextLine();
        System.out.println("\nOriginal message: ");
        System.out.println(message);

        try
        {
            OutputStream os = new FileOutputStream("test");
            OutputStream bos = new BufferedOutputStream(os);
            EncryptOutputStream eos = new EncryptOutputStream(bos);

            for(int i = 0; i < message.length(); i++)
            {
                int z = random.nextInt();
                eos.write(message.charAt(i), z);
            }

            eos.close();

            InputStream is = new FileInputStream("test");
            InputStream bis = new BufferedInputStream(is);
            DecryptInputStream dis = new DecryptInputStream(bis);

            long key = seed;
            scanner.close();

            random = new Random(key);

            System.out.println("Decrypted message: ");
            int c;
            while((c = dis.read(random.nextInt())) != -1)
            {
                System.out.print((char)c);
            }

            dis.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
