package forum.action;

import java.sql.SQLException;
import java.util.List;

import com.fw.core.Action;
import com.fw.core.DataContainer;
import com.fw.core.Page;

import forum.dao.ThreadDAO;
import forum.dto.ResponseDTO;
import forum.form.SearchForm;

/**
 * 検索アクション
 *
 * @author t.yoshida
 */
@Page(pageId="thread", eventId="search")
public class SearchAction implements Action<SearchForm>
{
	@Override
	public boolean isReadOnly()
	{
		return true;
	}

	@Override
	public void execute(SearchForm form, DataContainer container) throws SQLException
	{
		// 検索語を含むレスの取得
		List<ResponseDTO> contents = ThreadDAO.searchResponseList(form);
		container.setAttr("contents", contents);
		container.setAttr("result_size", contents.size());
		container.setAttr("search_word", form.getWord());
		container.setAttr("threadId", form.getThreadId());
	}

	@Override
	public String moveTo()
	{
		return "/WEB-INF/jsp/search.jsp";
	}
}
