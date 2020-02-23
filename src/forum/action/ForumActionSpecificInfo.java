package forum.action;

import com.fw.core.Action;
import com.fw.core.ActionSpecificInfo;
import com.fw.form.BaseForm;

/**
 * {@link ActionSpecificInfo} の実装
 *
 * @author t.yoshida
 */
public class ForumActionSpecificInfo implements ActionSpecificInfo
{
	@Override
	public Action<BaseForm> createDefaultAction()
	{
		return (new ThreadListAction());
	}

	@Override
	public String getPackageNameWhereActionImplExists()
	{
		return "forum.action";
	}
}
