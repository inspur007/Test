//1111111111111111111111111
/** * @author xiezhimao
 * @version 2016-12-29
 */

//程序文件名为UseHttp.java
import java.io.*;
import java.net.*;

public class UseHttp
{
    public static void main(String[] args)
    {
        String urlstring = "http://www.sohu.com";
        //String httpresp = new String();
        String status = new String("good");
        try
        {
            //构造URL对象
            URL currenturl = new URL(urlstring);
            urlstring = currenturl.toString();
                      //判断是否是HTTP协议
            if(!currenturl.getProtocol().equals("http"))
            {
                status  = currenturl.getProtocol() + "protocol";
            }
            else
            {
                          //打开连接
                  URLConnection conn = currenturl.openConnection();
                          //建立HttpURLConnection对象
                  HttpURLConnection httpconn = (HttpURLConnection)conn;
                     //判断是否正确返回
            if(httpconn.getResponseCode() == HttpURLConnection.HTTP_OK)
            {
                if(httpconn.getContentType().equals("text/html"))
                {
                                     //构造文件读写流对象，写入文件
                    InputStreamReader isr = new InputStreamReader(conn.getInputStream());
                    File f = new File("sohu.html");
                    FileOutputStream fOut = new FileOutputStream(f);
                    PrintWriter p = new PrintWriter(fOut);
                    int c;
                    while((c = isr.read()) != -1)
                    {
                        p.write(c);
                    }
                    isr.close();
                    httpconn.disconnect();
                }
                else
                    status = "Not text/html";
            }
            else
                status = "bad";
               }
        }
        catch(Exception e)
        {
            status = e.toString();
            System.out.println("Exception:" + e.getMessage());
        }
            
        if(status.equals("good"))
        {
            System.out.println(urlstring);
        }
        else
        {
            System.out.println(status);
            System.out.println("Bad URL = " + urlstring);
        }
            }
    }
