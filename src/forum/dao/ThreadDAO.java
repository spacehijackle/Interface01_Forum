package forum.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.fw.db.QueryLoader;
import com.fw.db.QueryUpdater;

import forum.dto.ResponseDTO;
import forum.dto.ThreadTitleDTO;
import forum.form.PostForm;
import forum.form.SearchForm;
import forum.form.ThreadForm;

/**
 * スレッド関連DAO
 *
 * @author t.yoshida
 */
public class ThreadDAO
{
	/**
	 * スレッド一覧を取得する。
	 *
	 * @return スレッド一覧（スレッドの更新日時の降順）
	 * @throws SQLException データベース関連エラー
	 */
	public static List<ThreadTitleDTO> loadThreadList() throws SQLException
	{
		List<ThreadTitleDTO> threads = QueryLoader.loadAsList
		(
			ThreadTitleDTO.class,
			"SELECT id AS threadId, title, last_no AS lastNo FROM thread ORDER BY update_dt DESC"
		);

		return threads;
	}

	/**
	 * スレッドタイトルを取得する。
	 *
	 * @param form スレッドフォーム
	 * @return スレッドタイトル
	 * @throws SQLException データベース関連エラー
	 */
	public static ThreadTitleDTO loadThreadTitle(ThreadForm form) throws SQLException
	{
		ThreadTitleDTO thread = QueryLoader.load
		(
			ThreadTitleDTO.class,
			"SELECT id AS threadId, title" +
			"  FROM thread" +
			" WHERE id = ?",
			form.getThreadId()
		);

		return thread;
	}

	/**
	 * 特定スレッドのレス一覧を取得する。
	 *
	 * @param form スレッドフォーム
	 * @return レス一覧
	 * @throws SQLException データベース関連エラー
	 */
	public static List<ResponseDTO> loadResponseList(ThreadForm form) throws SQLException
	{
		List<ResponseDTO> contents = QueryLoader.loadAsList
		(
			ResponseDTO.class,
			"SELECT no, poster, content, post_dt AS postDT" +
			"  FROM thread_contents" +
			" WHERE thread_id = ?" +
			" ORDER BY no",
			form.getThreadId()
		);

		return contents;
	}

	/**
	 * 検索語を含むレスの取得
	 *
	 * @param form 検索フォーム
	 * @return 検索結果リスト
	 * @throws SQLException データベース関連エラー
	 */
	public static List<ResponseDTO> searchResponseList(SearchForm form) throws SQLException
	{
		List<ResponseDTO> contents = QueryLoader.loadAsList
		(
			ResponseDTO.class,
			"SELECT no, poster, content, post_dt AS postDT" +
			"  FROM thread_contents" +
			" WHERE thread_id = ?" +
			"   AND content LIKE ? escape '\\'" +
			" ORDER BY no",
			form.getThreadId(),
			"%" + escape(form.getWord()) + "%"
		);

		return contents;
	}

	/**
	 * 投稿されたレスをデータベースに登録する。
	 *
	 * @param form 投稿用フォーム
	 * @throws SQLException データベース関連エラー
	 */
	public static void postResponse(PostForm form) throws SQLException
	{
		// 登録するNoの取得
		int lastNo = (int)QueryLoader.loadAsInteger
		(
			// Sqlite は行ロックできない( ；∀；)
			//"SELECT last_no FROM thread WHERE id = ? FOR UPDATE", form.getThreadId()
			"SELECT last_no FROM thread WHERE id = ?", form.getThreadId()
		);
		lastNo++;

		// 登録日時の取得
		Date t = new Date();
		String postDT = String.format("%tY-%tm-%td %tH:%tM:%tS", t, t, t, t, t, t);

		// レスの登録
		QueryUpdater.update
		(
			"INSERT INTO thread_contents" +
			"      (thread_id, no, poster, content, post_dt)" +
			"      VALUES" +
			"      (?, ?, ?, ?, ?)",
			form.getThreadId(), lastNo, form.getPoster(), form.getContent(), postDT
		);

		// スレの最新インデックス更新
		QueryUpdater.update
		(
			"UPDATE thread" +
			"   SET last_no = ?," +
			"       update_dt = ?" +
			" WHERE id = ?",
			lastNo, postDT, form.getThreadId()
		);
	}

	/**
	 * SQLのワイルドカード（%, _）をエスケープする。
	 *
	 * @param text 対象文字列
	 * @return エスケープ後文字列
	 */
	private static String escape(String text)
	{
		StringBuilder sb = new StringBuilder();

		int length = text.length();
		for(int i=0; i<length; i++)
		{
			char c = text.charAt(i);
			if(c == '%' || c == '_')
				sb.append("\\").append(c);
			else
				sb.append(c);
		}

		return sb.toString();
	}
}
