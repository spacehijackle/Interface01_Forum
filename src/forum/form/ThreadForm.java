package forum.form;

import com.fw.form.BaseForm;

/**
 * スレッドアクション用フォーム
 *
 * @author t.yoshida
 */
public class ThreadForm extends BaseForm
{
	// スレッドID
	private String threadId;

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
}
