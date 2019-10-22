package forum.dto;

import com.fw.util.HTMLUtils;

/**
 * スレッドのレス用DTO
 *
 * @author t.yoshida
 */
public class ResponseDTO
{
	// スレッドID
	private String threadId;

	// 通し番号
	private int no;

	// 投稿者
	private String poster;

	// 投稿日時
	private String postDT;

	// 投稿内容
	private String content;

	/**
	 * 通し番号を返す。
	 *
	 * @return 通し番号
	 */
	public int getNo()
	{
		return no;
	}

	/**
	 * 通し番号を設定する。
	 *
	 * @param no 通し番号
	 */
	public void setNo(int no)
	{
		this.no = no;
	}

	/**
	 * スレッドIDを返す。
	 *
	 * @return スレッドID
	 */
	public String getThreadId()
	{
		return threadId;
	}

	/**
	 * スレッドIDを設定する。
	 *
	 * @param threadId スレッドID
	 */
	public void setThreadId(String threadId)
	{
		this.threadId = threadId;
	}

	/**
	 * 投稿者を返す。
	 *
	 * @return 投稿者
	 */
	public String getPoster()
	{
		return poster;
	}

	/**
	 * 投稿者を設定する。
	 *
	 * @param poster 投稿者
	 */
	public void setPoster(String poster)
	{
		this.poster = poster;
	}

	/**
	 * 投稿日時を返す。
	 *
	 * @return 投稿日時
	 */
	public String getPostDT()
	{
		return postDT;
	}

	/**
	 * 投稿日時を設定する。
	 *
	 * @param postDT 投稿日時
	 */
	public void setPostDT(String postDT)
	{
		this.postDT = postDT;
	}

	/**
	 * 投稿内容を返す。
	 * <p>
	 * サニタイズ、改行コードの対応処理を施す。
	 * </p>
	 *
	 * @return 投稿内容
	 */
	public String getContent()
	{
		return HTMLUtils.convRetCodeToTag(HTMLUtils.sanitize(content));
	}

	/**
	 * 投稿内容を設定する。
	 *
	 * @param content 投稿内容
	 */
	public void setContent(String content)
	{
		this.content = content;
	}
}
