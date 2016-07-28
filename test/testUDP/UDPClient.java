package testUDP;
  
import java.io.IOException;  
import java.io.InterruptedIOException;  
import java.net.DatagramPacket;  
import java.net.DatagramSocket;  
import java.net.InetAddress;  
  
public class UDPClient {
    private static final int TIMEOUT=5000;  //���ý������ݵĳ�ʱʱ��
    private static final int MAXNUM=5;      //�����ط����ݵ�������

    public static void main(String args[])throws IOException{
        String str_send="Hello UDPserver";
        byte[] buf=new byte[1024];

        DatagramSocket ds=new DatagramSocket(9000);//�ͻ�����9000�˿ڼ������յ�������
        InetAddress loc=InetAddress.getLocalHost();  

        DatagramPacket dp_send=new DatagramPacket(str_send.getBytes(),str_send.length(),loc,3000); //���������������ݵ�DatagramPacketʵ��
        DatagramPacket dp_receive=new DatagramPacket(buf, 1024); //���������������ݵ�DatagramPacketʵ��

        //���ݷ��򱾵�3000�˿�  
        ds.setSoTimeout(TIMEOUT); //���ý�������ʱ�������ʱ��
        int tries=0; //�ط����ݵĴ���
        boolean receivedResponse=false; //�Ƿ���յ����ݵı�־λ
        while (!receivedResponse && tries<MAXNUM) { //ֱ�����յ����ݣ������ط������ﵽԤ��ֵ�����˳�ѭ��
            ds.send(dp_send);
            try{ //���մӷ���˷��ͻ���������
                ds.receive(dp_receive);
                //������յ������ݲ�������Ŀ���ַ�����׳��쳣
                if(!dp_receive.getAddress().equals(loc)) {
                    throw new IOException("Received packet from an umknown source");
                }
                receivedResponse=true; //������յ����ݡ���receivedResponse��־λ��Ϊtrue���Ӷ��˳�ѭ��
            } catch(InterruptedIOException e) {
                //�����������ʱ������ʱ���ط�������һ���ط��Ĵ���
                tries+=1;
                System.out.println("Time out,"+(MAXNUM-tries)+" more tries..." );
            }
        }
        if (receivedResponse) {
            //����յ����ݣ����ӡ����  
            System.out.println("client received data from server��");  
            String str_receive=new String(dp_receive.getData(),0,dp_receive.getLength())+" from "+dp_receive.getAddress().getHostAddress()+":"+dp_receive.getPort();  
            System.out.println(str_receive);  
            //����dp_receive�ڽ���������֮�����ڲ���Ϣ����ֵ���Ϊʵ�ʽ��յ���Ϣ���ֽ�����  
            //��������Ҫ��dp_receive���ڲ���Ϣ����������Ϊ1024  
            dp_receive.setLength(1024);     
        }else{  
            //����ط�MAXNUM�����ݺ���δ��÷��������ͻ��������ݣ����ӡ������Ϣ  
            System.out.println("No response -- give up.");  
        }  
        ds.close();  
    }    
}   