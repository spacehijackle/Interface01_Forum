package forum.dto;

/**
 * スレッド一覧用DTO
 *
 * @author t.yoshida
 */
public class ThreadTitleDTO
{
	// スレッドID
	private String threadId;

	// スレッドタイトル
	private String title;

	// スレッド最終No
	private int lastNo;

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
	 * スレッドタイトルを返す。
	 *
	 * @return スレッドタイトル
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * スレッドタイトルを設定する。
	 *
	 * @param title スレッドタイトル
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}

	/**
	 * スレッド最終Noを返す。
	 *
	 * @return スレッド最終No
	 */
	public int getLastNo()
	{
		return lastNo;
	}

	/**
	 * スレッド最終Noを設定する。
	 *
	 * @param lastNo スレッド最終No
	 */
	public void setLastNo(int lastNo)
	{
		this.lastNo = lastNo;
	}
}
