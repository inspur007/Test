//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
//WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW
/** * @author xiezhimao
 * @version 2016-12-29
 */
 �ร���ٶ�ͦ�õ�ͦ�õ�Ͷ�� 

//�����ļ���ΪUseHttp.java
import java.io.*;
import java.net.*;

public class UseHttp
{
    public static void main(String[] args)
    {
       Scanner scanner = new Scanner(Sysytem.in);       
	   int input = scannner.nextInt();
	   String urlstring = "http://www.sohu.com";
        //String httpresp = new String();
        String status = new String("good");
        try
        {
            //����URL����

			//����URL����//����URL����
			//����URL����//����URL����
			//����URL����//����URL����
			//����URL����//����URL����//����URL����
            URL currenturl = new URL(urlstring);
            urlstring = currenturl.toString();
                      //�ж��Ƿ���HTTPЭ��
            if(!currenturl.getProtocol().equals("http"))
            {
                status  = currenturl.getProtocol() + "protocol";
            }
            else
            {
                          //������
                  URLConnection conn = currenturl.openConnection();
                          //����HttpURLConnection����
                  HttpURLConnection httpconn = (HttpURLConnection)conn;
                     //�ж��Ƿ���ȷ����
            if(httpconn.getResponseCode() == HttpURLConnection.HTTP_OK)
            {
                if(httpconn.getContentType().equals("text/html"))
                {
                                     //�����ļ���д������д���ļ�
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
