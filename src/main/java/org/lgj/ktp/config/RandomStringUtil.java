package org.lgj.ktp.config;

//生成课程码
public class RandomStringUtil {

	public static String getRandString() {
		long r = 0;
		int i = 0;
		while(true) {
			r = System.currentTimeMillis();
			//取模 也就是1----999999的随机数
			i = (int)(r  % 1000000);
			if(0 != i) {
				break;
			}
		}
		return i+"";
	}

}
