package cn.funeralobjects.demo.exec;

import cn.funeralobjects.demo.exec.youtube.WatchInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

/**
 * 示例程序
 * @author FuneralObjects
 * Create date: 2020/4/3 9:29 AM
 */
public class Sample {

    public static void main(String[] args) throws IOException {
        Process process = Runtime.getRuntime().exec(new String[]{
                "youtube-dl",
                "--proxy" , "socks5://127.0.0.1:1086",
                "-f","137+251","https://www.youtube.com/watch?v=aAbNHSLcYdw"});
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        String s = null;
        while ((s = bufferedReader.readLine()) != null) {
            System.out.println(s);
        }
//        WatchInfo watch = new ObjectMapper().readValue(process.getInputStream(), WatchInfo.class);
//        System.out.println(watch);
        String error;
        while ((error = errorReader.readLine()) != null) {
            System.out.println(error);
        }

    }
}
