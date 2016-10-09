package cn.mldn.util;

public class TextMDCode {
	public static void main(String[] args) {
		String salt="bWxkbmphdmE=";
		String pwd ="{!("+salt+")!}";
		String md5 =new MD5Code().getMD5ofStr("wy"+pwd);
		System.out.println(md5);
	}
}
