# UKA.

HAL TOKYO CASE STUDY
---
team Tamago-Club
* ohtani
* enfumidayo
* kumagai
* takaki
* nitta
* yoneyama
* kosaka

## インポート手順

1. `https://github.com/shohe/UKA..git` をコピー
2. SourceTreeから + New Repository > Clone from URL
3. Source URL に 1. のURLをペースト > Clone
4. Eclipce を開き File > Import をクリック
5. Maven > Exsisting Maven Projects
6. Root Directory > Browse... > クローンしてきたディレクトリを選択 > Finish
<br/>
（ ※ .pomファイルの一つ上のディレクトリ ）
<br/>
7. プロジェクト右クリック > Run As > Maven install
8. プロジェクト > targetディレクトリの下に .warファイルが出来ていればOK.
9. プロジェクト右クリック > Run As > Run on Server
10. `http://localhost:8080/UKA.system/` にてトップページが表示されれば成功

## URL構成

各ページにアクセスする際のURLの構成は
* /UKA_system/ [ページ名] / [メソッド名] / ? [パラメータ...]
* ex) /UKA_system/detail/like/?param=value&param2=value2..

新しい.jspを追加した場合は以下を例に追記すること<br/>
~~~java
/* [ URLCORE.java ] */

// 12行目あたり
// .jspにアクセスするURLを記述
TOP("/UKA_system/"),
LIST("/UKA_system/list/"),
DETAIL("/UKA_system/detail/"),
POST("/UKA_system/post/"),
ERROR("/UKA_system/error/");


// 27行目あたり
// 表示させたい.jspのパスを記述
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
~~~



## コミットについて
コミットは自分が変更したソースを一時的に保持？しておくもの。<br/>
基本的に１つメソッド作り終わった時など、１つ作業が終わった時を目安にしておく。<br/>
コミットが幾つもためてOK.　今日の作業が一段楽ついた所でブランチにプッシュし、サーバーのレポジトリに保存しておく。

---

Thanks,

HAL TOKYO IH14B-284 team Tabago-Club SHOLLER.
