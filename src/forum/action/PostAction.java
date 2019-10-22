package forum.action;

import java.sql.SQLException;

import com.fw.core.Action;
import com.fw.core.DataContainer;
import com.fw.core.Page;

import forum.dao.ThreadDAO;
import forum.form.PostForm;
import forum.form.ThreadForm;

/**
 * 投稿アクション
 *
 * @author t.yoshida
 */
@Page(pageId="thread", eventId="post")
public class PostAction implements Action<PostForm>
{
	@Override
	public boolean isReadOnly()
	{
		return false;
	}

	@Override
	public void execute(PostForm form, DataContainer container) throws SQLException
	{
		// 投稿者名が無い場合、デフォルト名設定
		String name = form.getPoster();
		if(name == null || name.trim().isEmpty())
		{
			form.setPoster("名無しの権兵衛さん");
		}

		// レス内容をデータベースへ登録
		ThreadDAO.postResponse(form);

		// スレッドの再取得
		Action<ThreadForm> thread = new ThreadAction();
		thread.execute(form, container);
	}

	@Override
	public String moveTo()
	{
		return "/WEB-INF/jsp/thread.jsp";
	}

	@Override
	public void onCommitCompleted(DataContainer container)
	{
		// クライアントへメッセージの設定
		container.setAttr("message", "Post completed.");
	}
}
