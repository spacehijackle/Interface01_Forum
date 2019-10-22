package forum.form;

/**
 * 検索アクション用フォーム
 *
 * @author t.yoshida
 */
public class SearchForm extends ThreadForm
{
	// 検索ワード
	private String word;

	/**
	 * 検索ワードを返す。
	 *
	 * @return 検索ワード
	 */
	public String getWord()
	{
		return word;
	}

	/**
	 * 検索ワードを設定する。
	 *
	 * @param word 検索ワード
	 */
	public void setWord(String word)
	{
		this.word = word;
	}
}
