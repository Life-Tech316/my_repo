import org.apache.commons.logging.*;

public class Main_p233{

	public static void main(String[] args){
		Log logger = LogFactory.getLog(Main.class);
		if(args.length != 2){
			logger.error("起動引数の数が異常 : " + args.length);
		}
	}
}
