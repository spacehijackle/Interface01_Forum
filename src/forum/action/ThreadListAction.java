package forum.action;

import java.sql.SQLException;
import java.util.List;

import com.fw.core.Action;
import com.fw.core.DataContainer;
import com.fw.core.Page;
import com.fw.form.BaseForm;

import forum.dao.ThreadDAO;
import forum.dto.ThreadTitleDTO;

/**
 * スレッド一覧アクション
 *
 * @author t.yoshida
 */
@Page(pageId="thread_list", eventId="*")
public class ThreadListAction implements Action<BaseForm>
{
	@Override
	public boolean isReadOnly()
	{
		return true;
	}

	@Override
	public void execute(BaseForm form, DataContainer container) throws SQLException
	{
		// スレッド一覧の取得
		List<ThreadTitleDTO> threads = ThreadDAO.loadThreadList();
		container.setAttr("threads", threads);
	}

	@Override
	public String moveTo()
	{
		return "/WEB-INF/jsp/thread_list.jsp";
	}
}
