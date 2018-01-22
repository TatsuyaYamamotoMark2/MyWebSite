package base;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;

public class UtillLogic {

	public static final String MP3_UPLOAD_PATH = "/Users/yamatoraneco/git/MyWebSite/MyECSite/WebContent/mp3/";
	public static String FILE_UPLOAD_PATH = "/Users/yamatoraneco/git/MyWebSite/MyECSite/WebContent/img/";
	public static String wave_UPLOAD_PATH = "/Users/yamatoraneco/git/MyWebSite/MyECSite/WebContent/wave/";

	/**
	 * メールアドレスの正規表現チェック
	 * @param input チェック対象
	 * @return	正規表現ならtrueを返す
	 *
	 */
	public static boolean isMailPattern(String input) {
		String pattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$" ;
		Pattern p = Pattern.compile(pattern);
		if(p.matcher(input).find()){
			return true;
		}else{
		    return false;
		}
	}

/**
 * 文字列が半角英数のみで構成されているかをチェックする
 *
 * @param input チェック対象の文字列
 * @return チェック結果。半角英数のみなら true そうでなければ false
 */
	public static boolean isStringCheck(String input) {
		for(int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if( (c < '0' || c > '9') &&
				(c < 'a' || c > 'z') &&
				(c < 'A' || c > 'Z')
			) {
			return false;
			}
		}
		return true;
	}

	/**
	 * リダイレクトした際のリザルトメッセージの設定
	 * @param	request	URLのaddFlgの値
	 * @return	jspへ送るエラー、成功のメッセージ
	 * 			 setMessage:緑文字で表示される成功メッセージ
	 * 		setErrorMessage:	赤文字で表示される失敗メッセージ
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
	 * @return 暗号化された文字列を返す
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
