import java.io.*;
import java.util.zip.GZIPOutputStream;

public class Main_283{
	public static void main(String[] args) {
		String inFile = args[0];
		String outFile = args[1];
		//通常ファイル入力ストリームの初期化
		FileInputStream fis = null;
		//
		GZIPOutputStream gzos = null;
		try{
				fis = new FileInputStream(inFile);
				//出力ストリームfosを生成
				FileOutputStream fos = new FileOutputStream(outFile);
				//バッファリングフィルタを生成
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				//圧縮フィルタをgzosを生成
				gzos = new GZIPOutputStream(bos);

				int i = fis.read();
				while(i != -1){
						gzos.write(i);
						i = fis.read();
					}
				gzos.flush();
				gzos.close();
				fis.close();
				} catch (IOException e){
					System.out.println("ファイル操作失敗");
				try {
						if(fis != null){
								fis.close();
							}
						if(gzos != null){
								gzos.close();
							}
				} catch (IOException ee) {}
			}
		}
}

