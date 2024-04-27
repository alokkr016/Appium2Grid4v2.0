package appium2grid4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;

public class CommonUtils {
    static final String scriptPath = System.getProperty("user.dir")+"/selenium-grid/scripts/";
    public static void runScript(String shellFileWithArgs) throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder();
        System.out.println(scriptPath);
        builder.command("/bin/bash","-c",scriptPath + shellFileWithArgs);
        Process result  = builder.start();

        int exitCode = result.waitFor();

        if (exitCode != 0){
            System.out.println(exitCode);
            throw new RemoteException();
        }

        // Read output from the process if needed
        BufferedReader reader = new BufferedReader(new InputStreamReader(result.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        reader.close();
        if (result != null){
            result.destroy();
        }
    }

    public static void executePermissionToScripts() throws IOException, InterruptedException {
        String shellCommand = "chmod -R 777 " + scriptPath;
        ProcessBuilder builder = new ProcessBuilder();
        builder.command("/bin/bash","-c",shellCommand);
        Process result  = builder.start();

        int exitCode = result.waitFor();

        if (exitCode != 0){
            System.out.println(exitCode);
            throw new RemoteException();
        }

        // Read output from the process if needed
        BufferedReader reader = new BufferedReader(new InputStreamReader(result.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        reader.close();
        if (result != null){
            result.destroy();
        }
    }


    public static void main(String[] args) {
        System.out.println(scriptPath);
    }
}
