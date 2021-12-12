package Task1.client;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;

public class Main {


    public static String host = "130.3.192.111";

    public static String user = "user";

    public static void main(String[] args) {

        try {

            InputStream in = ClassLoader.class.getResourceAsStream("/centos.ppk");
            byte[] identity = null;
            identity = IOUtils.toByteArray(in);

            Client sshClient = new Client(user, host, identity);

            sshClient.connect();

            String fileContent = sshClient.executeCommand("cat /home/cloud-user/test.txt");
            System.out.println("Content === " + fileContent);

            sshClient.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
