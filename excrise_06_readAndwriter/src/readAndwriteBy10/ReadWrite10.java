package readAndwriteBy10;

import java.io.*;
import TextFileTest.Employee;

public class ReadWrite10 {
	/**
	 * java��������ʽд������
	 */
	public void wirteBinary() {  
        try {  
        	// �������㵽�ڲ���� ��Ӧ���ļ�д���� ����data.dat�ļ�  Ȼ��Ӧ�ø��ٻ���������������ļ� 
        	// Ȼ�����Զ�����д�������򿪻�����򿪵�����  Ȼ��������Ķ���os����д����������
            DataOutputStream os = new DataOutputStream(  
                    new BufferedOutputStream(new FileOutputStream(  
                            "E:\\data.dat")));  
            os.writeInt(1001);  
            os.writeByte(520);  
            os.writeBoolean(true);  
            os.writeFloat(10.0f);  
            os.writeLong(100l);  
            os.writeUTF("��д�������ļ�");  
              
            os.flush();  
            os.close();  
              
        } catch (IOException e) {  
  
        }  
    }  
	/**
	 * java�Զ�������ʽ��������
	 */
	public void readBinary() {  
        try {  
        	// ���Ȼ�����FileInputStream������data.dat�ļ� Ȼ���ø��ٻ��������нӴ򿪵��ļ�
        	// Ȼ���Զ�������ʽ ���� �򿪵Ļ������ļ����� ��������(is) Ȼ�����is����ȡ��������
            DataInputStream is = new DataInputStream(  
                    new BufferedInputStream(new FileInputStream(  
                            "E:\\data.dat")));  
            System.out.println(is.readInt());  
            System.out.println(is.readByte());  
            System.out.println(is.readBoolean());  
            System.out.println(is.readFloat());  
            System.out.println(is.readLong());  
            System.out.println(is.readUTF());  
              
            is.close();  
        } catch (IOException e) {  
  
        }  
    }  
}
