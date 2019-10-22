package forum.form;

/**
 * 投稿用フォーム
 *
 * @author t.yoshida
 */
public class PostForm extends ThreadForm
{
	// 投稿者
	private String poster;

	// 内容
	private String content;

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
	 * 内容を返す。
	 *
	 * @return 内容
	 */
	public String getContent()
	{
		return content;
	}

	/**
	 * 内容を設定する。
	 *
	 * @param content 内容
	 */
	public void setContent(String content)
	{
		this.content = content;
	}
}
