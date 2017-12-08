package base;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import javax.xml.bind.DatatypeConverter;

public class UtillLogic {
	public static String convertPassword(String password) {
		String result = null;

		try {

			//ハッシュ生成前にバイト配列に置き換える際のCharset
			Charset charset = StandardCharsets.UTF_8;
			//ハッシュアルゴリズム
			String algorithm = "MD5";

			//ハッシュ生成処理
			byte[] bytes = MessageDigest.getInstance(algorithm).digest(password.getBytes(charset));
			result = DatatypeConverter.printHexBinary(bytes);
		} catch (Exception e) {
			return null;
		}
		return result;
	}
	/**
	 * 渡された文字列がnullまたは空文字だった場合trueを返す
	 * @param str
	 * @return boolean
	 */
	public static boolean isEmpty(String str) {
		if (null == str || str == "") {
			return true;
		}
		return false;
	}
}