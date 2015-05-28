package hal.tokyo.model;

/**
 * URLは以下の形で構成される。
 * /UKA_system/[ページ名]/[メソッド名]/?[パラメータ...]
 * ex) /UKA_system/detail/like/?param=value...
 * @author shohe
 *
 */

public enum URLCORE {
	TOP("/UKA_system/"),
	LIST("/UKA_system/list/"),
	DETAIL("/UKA_system/detail/"),
	POST("/UKA_system/post/"),
	ERROR("/UKA_system/error/");
	
	private final String name;
	private URLCORE(final String name) { this.name = name; }
	public String getURL() { return name; }
	
	/**
	 * それぞれの表示させるページのパスを取得する。
	 * @param urlCore
	 * @return
	 */
	public static String getJsp(String url) {
		String jspPath = "/JSP/index.jsp";
		if(LIST.getURL().equals(url)) {
			jspPath = "/JSP/list.jsp";
		} else if(DETAIL.getURL().equals(url)) {
			jspPath = "/JSP/detail.jsp";
		} else if(POST.getURL().equals(url)) {
			jspPath = "/JSP/post.jsp";
		} else if(ERROR.getURL().equals(url)) {
			jspPath = "/JSP/error.jsp";
		}
		return jspPath;
	}
	
	/**
	 * URLからアクセスをマッピング
	 * @param url
	 * @return
	 */
	public static Access access(String url) {
		String reformURL = "";
		String[] splitURL = url.split("/", 0);
		for (String value : splitURL) {
			reformURL += value+"/";
		}
		
		splitURL = reformURL.split("/", 0);
		String pageURL = (splitURL.length > 2) ? "/UKA_system/"+splitURL[2]+"/" : "/UKA_system/";
		Access access = new Access(reformURL, getJsp(pageURL));
		if(splitURL.length == 4) access.setMethod(splitURL[3]);
		
		return access;
	}
}
