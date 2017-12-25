package base;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;

public class UtillLogic {

	public static final String MP3_UPLOAD_PATH = "/Users/yamatoraneco/git/MyWebSite/MyECSite/WebContent/mp3/";
	public static String FILE_UPLOAD_PATH = "/Users/yamatoraneco/git/MyWebSite/MyECSite/WebContent/img/";
	public static String wave_UPLOAD_PATH = "/Users/yamatoraneco/git/MyWebSite/MyECSite/WebContent/wave/";

	/**
	 * リダイレクトした際のリザルトメッセージの設定
	 * @param request
	 * @return
	 */
	public static HttpServletRequest redirectResultMessage(HttpServletRequest request) {


		if(request.getParameter("addFlg") != null) {
			String setMessage = null;
			String setErrorMessage = null;

			switch(Integer.parseInt(request.getParameter("addFlg"))) {
				case 0:
					break;
				case 1:
					setMessage = "カートに追加しました";
					break;
				case 2:
					setMessage = "アルバムをカートに追加しました";
					break;
				case 3:
					setMessage = "カートから楽曲を削除しました";
					break;
				case 4:
					setMessage = "アルバムを更新しました";
					break;
				case 5:
					setMessage = "アルバムを更新しました";
					break;
				case 6:
					setMessage = "アルバムを追加しました";
					break;
				case 7:
					setMessage = "アーティストを更新しました";
					break;
				case 8:
					setMessage = "アーティストを追加しました";
					break;
				case 9:
					setErrorMessage = "処理に失敗しました";
					break;
				case 10:
					setMessage = "アルバム内の楽曲を更新しました";
					break;
				case 11:
					setErrorMessage = "入力に不備がありました<br>操作をやり直してください";
					break;

			}
			request.setAttribute("resultMessage", setMessage);
			request.setAttribute("errorMessage", setErrorMessage);

				return request;
		}
		return request;
	}

	/**
	 * パスワードのMD5暗号化
	 * @param password
	 * @return
	 */
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