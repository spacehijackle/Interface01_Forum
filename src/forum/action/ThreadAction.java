package forum.action;

import java.sql.SQLException;
import java.util.List;

import com.fw.core.Action;
import com.fw.core.DataContainer;
import com.fw.core.Page;

import forum.dao.ThreadDAO;
import forum.dto.ResponseDTO;
import forum.dto.ThreadTitleDTO;
import forum.form.ThreadForm;

/**
 * スレッドアクション
 *
 * @author t.yoshida
 */
@Page(pageId="thread", eventId="*")
public class ThreadAction implements Action<ThreadForm>
{
	// スレッドID存在フラグ
	private boolean _isNotExistThreadId;

	@Override
	public boolean isReadOnly()
	{
		return true;
	}

	@Override
	public void execute(ThreadForm form, DataContainer container) throws SQLException
	{
		// スレッドタイトルの取得
		ThreadTitleDTO thread = ThreadDAO.loadThreadTitle(form);
		container.setAttr("thread", thread);

		// 該当するスレッドIDが無い場合、以降の処理はスキップ
		if(thread == null)
		{
			_isNotExistThreadId = true;
			return;
		}

		// 指定スレッドIDに紐付いたレスの取得
		List<ResponseDTO> contents = ThreadDAO.loadResponseList(form);
		container.setAttr("contents", contents);
	}

	@Override
	public String moveTo()
	{
		if(_isNotExistThreadId)
		{
			return "index.html";
		}

		return "/WEB-INF/jsp/thread.jsp";
	}
}
